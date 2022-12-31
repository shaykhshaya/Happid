package com.shaya.happid.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.shaya.happid.databinding.ActivitySplashBinding
import com.shaya.happid.utils.SPLASH_WAIT_DURATION
import com.shaya.happid.utils.loadCircleImageByUrl


class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadOnEntryImages()
        startLandingActivity()
    }

    private fun startLandingActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val intent = Intent(this, LandingActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_WAIT_DURATION
        )
    }

    private fun loadOnEntryImages() {
       binding.apply {
           imgOne.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/f7aa/35e4/3774073e1da8e70ba2e93d86685cbe85?Expires=1673222400&Signature=YhhH5cvpZAomAp7zAkeLKW-5-or2JnHxeC-r3W21i1QDm1Wp8YFScqk9IDysm484w1GIzzshN5-5qPtfoElupFXvVvdmvH5WrJ9AzbQM74PXdzObTNz4j8Nk8zG6unaoYVJuZaca8AoijCSpeqSDm-ZzwJq-Uli14kSTUq7GhYyQIaQQflvo9I9xsgRtuFY3iUsRc~wPoNPcAsvvrk1raZnhALBON-WVv~bPK~LLLJ-gtV~bZieWoJdOVAIwdmBMBBBwK8~r3tzm92LGk6z~kuBX~rSNYQrRVYc1HJA52ue45gmj3aHY65qk-YHmKSpDnEdRJ~yQfyyb2tJLrODzsw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgTwo.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/f12f/0a6c/f719ceaec619a6ef306c07496b5125b4?Expires=1673222400&Signature=lOGBsYbC17clYvwQPPtt78jyDzmzKSf61ZDsiQ1U~JFz7~brmme5O3kn89inOllFVidiCF16wKBFVZfP2aPfNSjNMjkhI0fNj11hMYS5SFW23ALkEEjCILhhfs9Gl8nxy3UU2VhZ7v8-2Uf~Tmasw5bgnFJwHy1Sv36~84I6hXheniNs~YgyZ61V1JfZ7ybvZ9~FBwSaciNz4qyDTeyk6~Dk6sOYYCNSUSWyMwzc3GNWTcv-xP~VgsEACd1ga9smomvNB0tO00xbBBEKqPNV96nrJNm-LcvevujzWpInoeBf69MooEpbHgkC-gtSJafe6Ek63I4w06nDAm9-cIKxFw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgThree.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/d04c/ea42/f0bd6d2a16171f62b1acfead093cb116?Expires=1673222400&Signature=Ti0NOs1LGIzjNEpc5lQyAYz7VdIOyc7yQzePVgVmGESdL4cGczRj2L-CPSj5aQ1k~dFtDRyyg54GtFtO1ptj5HazdOFzX646WBekNkQQ~KJWeAuzNECu2F6t4cgtAHt6tzgRrkuMWUK7cd~1XqgEjA865F~~r1lC7SWWjssRhP4wZeZLc5SmYlvucNA6nrepcua~vWoQjvQYUulX-xlGIKTqQ1481u9e4CIPgDYMbTkE-Q1fpCCXj6XaTzjhq4UgfmFr1MCwBrYP9xvoMsrU-~jLFjN-BSam0al4ponpqUYzJYp4Ka2i~-QD4FoyDy57sX~iKoJMx2WdnMSbRJylbQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgFour.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/fd44/faeb/b71445e606213e9313b2ad26e3c30196?Expires=1673222400&Signature=kMyy0HLjfX5UtxE28R3dgGhFS1pjKJqxU2vuJnq4aLynw80rvZKJZ3J6tEfxt3holh6YpNph9gB5N1~vY5nVpKD4gt4VbJ0KW0IzRCiVRe6uSDBrt8qT2qC3~jEUJOAP3oemNpvVQTXxzgxbBIa~SfA-Xe7fH6wFsSHdrDq9TGWtPPHAjq6vYGOqn~sdtdrYZ~5WgOEIWMX59MSjZrOyUF1epeMne6H-TuM5XnjHGgnpd6vJ0NE9owqBEdrTgZGLJ6qNMU092qXlJ5qSoERnAGMKihpLq~Qy8S5WcJxmYtSGkcZs8cwRYNcNhYP-kgTqjPU4I4OmD4cIFkR5N8Vk8A__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgFive.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/35fd/096e/6ad74fb07fd8cff7c7d0f5282e55a639?Expires=1673222400&Signature=Pa-IWK9WFEEqOKHC-cwzyTnnw2ZNVfGvxwbaOJxYade1MIxcb05udBY8UIbZSrjLkv3VoBzeLFme3EBLK16NXVyAnr9FJZHVsD8lbdSw8LFC-DurCXRybdk-M1dBJLscO7nwQJtBETPikcExlpumGLGCHBcg~vClVDLXbcBKzGZE0j5Ibz93kLWcC~W4vOGCwaLiiGEutFcu1DvgnmlBXrW8L6MZnbDF51vF53ZRUIwN~GCfx7J05M9uyTWAyP2cMqS4Gndn8KFZg6guSyU3qHmkV2Yv-gfSQsx~-q9htTBJOnilHpQdad294J3BXIWxcD8NAwtKBQzaaD4zidvw4A__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgSix.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/a964/a12d/fcf9639a49aaa565d87053aa34ce1951?Expires=1673222400&Signature=MJLauYxWfOZBkIWeGCWZnEhXaMIzGQuKOMOH0Emp-wvmVqUIMIB9Z4retpB64QQPchAaapuGuTBzZSzIvSgKePqUwyXYuYZvEpoDVFif7iam0QzOQR-dDsMZeQ9W3rvRMeWr3ttc4HfUcvt7MzjXECpqXfsbU~b6VrotVgLS3HQb1CXvCT-9xxEwJTEZhiienkH744s~9vS3CWrPmedUfoLc-gdRtggEftPH8Foo66JtmugvN5H-Wmq5KsHY7H7vXahR8xGhxv2XNLnqmvqODNiPgdoAkgUMaTp8aBtSKQIyHKRfG5Hmu5orhP8VAjraO2kQr9alkZvdc2sPa-14ug__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
           imgSeven.loadCircleImageByUrl(
               this@SplashActivity,
               url = "https://s3-alpha-sig.figma.com/img/aac6/7370/6c5478dcc98985f7a3d98b8061146720?Expires=1673222400&Signature=UgDZ3Ds4axMYgyOBbkJFJ~moX5Hu9V8gbsUF4IEF8U4qAScBQUv1mJL-atDjnFpnMrcKwWRV2Df1PsSxYo63XdHomFD82EjU3eNY0lZ1YrfoKnNnDNyD30K3EEJSwbP9WWNrzstqNn~GPB-~xns4Ae0esehBd3mQMoEuUB~3MfzLCKOBrhuNRCVHeuEAMOWM3m6oNuZgjsCCDfyrRibwM6~p-u3Orn~LmyATk-Qw6ebp-Zq0QamlvAmCGUeOJ72iGaTjKnEDzm8~jDGdYK7xtGOc9o2ZtSb8Wbuxg90n95INvEW0CCzvmjlhsSDuGdasTgtitR7BJtxeQtYAGdxm9g__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4"
           )
       }
    }
}