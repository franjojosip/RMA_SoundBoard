package ht.ferit.fjjukic.rma_lv5

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mSoundPool: SoundPool
    var soundMap: HashMap<Int, Int> = HashMap()
    var isLoaded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
        loadSounds()
    }

    private fun setListener() {
        this.imgOne.setOnClickListener(this)
        this.imgTwo.setOnClickListener(this)
        this.imgThree.setOnClickListener(this)
        this.imgFour.setOnClickListener(this)
        this.imgFive.setOnClickListener(this)
    }

    private fun loadSounds() {
        this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        this.mSoundPool.setOnLoadCompleteListener { _, _, _ -> isLoaded = true }
        this.soundMap[R.raw.air_wrench] = this.mSoundPool.load(this, R.raw.air_wrench, 1)
        this.soundMap[R.raw.crow_call] = this.mSoundPool.load(this, R.raw.crow_call, 1)
        this.soundMap[R.raw.dial] = this.mSoundPool.load(this, R.raw.dial, 1)
        this.soundMap[R.raw.fire_crackers] = this.mSoundPool.load(this, R.raw.fire_crackers, 1)
        this.soundMap[R.raw.fizzle] = this.mSoundPool.load(this, R.raw.fizzle, 1)
    }

    override fun onClick(v: View?) {
        if (!isLoaded) return
        when (v?.id) {
            R.id.imgOne -> play(R.raw.air_wrench)
            R.id.imgTwo -> play(R.raw.crow_call)
            R.id.imgThree -> play(R.raw.dial)
            R.id.imgFour -> play(R.raw.fire_crackers)
            R.id.imgFive -> play(R.raw.fizzle)
        }
    }
    private fun play(sound: Int) {
        val soundID: Int = this.soundMap[sound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }

}
