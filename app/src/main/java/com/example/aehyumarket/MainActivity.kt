package com.example.aehyumarket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aehyumarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.notificationBtn.setOnClickListener(){
            notification()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
//                TODO("Not yet implemented")
                showDialog()
            }

        }

        onBackPressedDispatcher.addCallback(this, callback)



        val productList = mutableListOf<DummyProduct>()
        productList.add(DummyProduct(1, R.drawable.sample1, "산진 한달된 선풍기 팝니다", "이사가서 필요가 없어졌어요 급하게 내놓습니다", "대현동", 1000, "서울 서대문구 창천동", 13, 25))
        productList.add(DummyProduct(2, R.drawable.sample2, "김치냉장고", "이사로인해 내놔요", "안마담", 20000, "인천 계양구 귤현동", 8, 28))
        productList.add(DummyProduct(3, R.drawable.sample3, "샤넬 카드지갑", "고퀄지갑이구요\n사용감이 있어서 싸게 내어둡니다", "코코유", 10000, "수성구 범어동", 23, 5))
        productList.add(DummyProduct(4, R.drawable.sample4, "금고", "금고\n떼서 가져가야함\n대우월드마크센텀\n미국이주관계로 싸게 팝니다", "Nicole", 10000, "해운대구 우제2동", 14, 17))
        productList.add(DummyProduct(5, R.drawable.sample5, "갤럭시Z플립3 팝니다", "갤럭시 Z플립3 그린 팝니다\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!", "절명", 150000, "연제구 연산제8동", 22, 9))
        productList.add(DummyProduct(6, R.drawable.sample6, "프라다 복조리백", "까임 오염없고 상태 깨끗합니다\n정품여부모름", "미니멀하게", 50000, "수원시 영통구 원천동", 25, 16))
        productList.add(DummyProduct(7, R.drawable.sample7, "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장", "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\n2. 장소: 북구 블루마시티, 32-33층\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\n6. 고기 굽기 가능\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\n8. 층간소음 주의 부탁드립니다.\n9. 방3개, 화장실3개, 비데 3개\n10. 저희 집안이 쓰는 별장입니다.", "굿리치", 150000, "남구 옥동", 142, 54))
        productList.add(DummyProduct(8, R.drawable.sample8, "샤넬 탑핸들 가방", "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\n + \"\n\" + \"색상 : 블랙\n\" + \"사이즈 : 25.5cm * 17.5cm * 8cm\n\" + \"구성 : 본품더스트\n\" + \"\n\" + \"급하게 돈이 필요해서 팝니다 ㅠ ㅠ", "난쉽", 180000, "동래구 온천제2동", 31, 7))
        productList.add(DummyProduct(9, R.drawable.sample9, "4행정 엔진분무기 판매합니다.", "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.", "알뜰한", 30000, "원주시 명륜2동", 7, 28))
        productList.add(DummyProduct(10, R.drawable.sample10, "셀린느 버킷 가방", "22년 신세계 대전 구매입니당\n + \"셀린느 버킷백\n\" + \"구매해서 몇번사용했어요\n\" + \"까짐 스크래치 없습니다.\n\" + \"타지역에서 보내는거라 택배로 진행합니당!", "똑태현", 190000, "중구 동화동", 40, 6))

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        // apapter와 itemclick 부분은 모두 onCreate안에 들어와야 했다.
        // 어댑터 연결이 안되었었는데, 알고보니 어댑터 클래스명이 MyAdapter로 되어 있었다.
        val adapter = Adapter(productList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.addItemDecoration(decoration)

    adapter.itemClick = object : Adapter.ItemClick {
        override fun onClick(view: View, position: Int) {
//            val image: Int = productList[position].image
//            val seller: String = productList[position].seller
//            val address: String = productList[position].address
//            val name: String = productList[position].name
//            val description: String = productList[position].description
//            val price : Int = productList[position].price.toInt()
//            val intent = Intent(this@MainActivity, DetailActivity::class.java)
//            intent.putExtra("image", image)
//            intent.putExtra("seller", seller)
//            intent.putExtra("address", address)
//            intent.putExtra("name", name)
//            intent.putExtra("description", description)
//            intent.putExtra("price", price)
            val itemParcel = productList[position]
            val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                putExtra("A", itemParcel)
            }
            startActivity(intent)
        }
    }


    }
    fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("종료")
            .setMessage("종료하시겠습니까?")
            .setIcon(R.mipmap.ic_launcher)
            .setPositiveButton("확인") {_, _, -> finish()}
            .setNegativeButton("취소") {_, _, -> }
            .show()
    }
    fun notification() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder: NotificationCompat.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
                    // 알림 권한이 없다면, 사용자에게 권한 요청
                    val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                        putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                    }
                    startActivity(intent)
                }
            }
            // 26 버전 이상
            val channelId = "one-channel"
            val channelName = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                // 채널에 다양한 정보 설정
                description = "My Channel One Description"
                setShowBadge(true)
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                setSound(uri, audioAttributes)
                enableVibration(true)
            }
            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널을 이용하여 builder 생성
            builder = NotificationCompat.Builder(this, channelId)

        } else {
            // 26 버전 이하
            builder = NotificationCompat.Builder(this)
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.hate)
        val intent = Intent(this, DetailActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        // 알림의 기본 정보
        builder.run {
            setSmallIcon(R.mipmap.ic_launcher)
            setWhen(System.currentTimeMillis())
            setContentTitle("키워드 알림")
            setContentText("설정한 키워드에 대한 알람이 도착했습니다!!")
            setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("설정한 키워드에 대한 알람이 도착했습니다!!")
//                    .bigText(
//                        "이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다.이것은 긴텍스트 샘플입니다. 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 . 이것은 긴텍스트 샘플입니다 . 아주 긴 텍스트를 쓸때는 여기다 하면 됩니다 ."
                    )
//            )

            setLargeIcon(bitmap)
//            setStyle(NotificationCompat.BigPictureStyle()
//                    .bigPicture(bitmap)
//                    .bigLargeIcon(null))  // hide largeIcon while expanding
            addAction (R.mipmap.ic_launcher, "Action", pendingIntent)
        }
        manager.notify(11, builder.build())
    }
}

