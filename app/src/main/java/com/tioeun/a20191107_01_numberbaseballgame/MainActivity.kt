package com.tioeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tioeun.a20191107_01_numberbaseballgame.adapter.ChatAdapter
import com.tioeun.a20191107_01_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {


    var chatAdapter:ChatAdapter? = null
    var chatList = ArrayList<ChatData>()

    var questionNumArray = ArrayList<Int>()
    var userINputNumArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValus()
        createQuestion()
    }

    fun createQuestion(){
        while(true){
            val number = Random.nextInt(1, 10)

            if(!questionNumArray.contains(number)){
                questionNumArray.add(number)
            }
            if(questionNumArray.size == 3){
                break
            }
        }
        for (num in questionNumArray){
            Log.d("출제숫자 ", num.toString())
        }
    }

    fun checkAnswer(){

        var strikeCount = 0
        var ballCount = 0

        for (i in 0..2){
            for(j in 0..2){
                if(userINputNumArray.get(i) == questionNumArray.get(j)){
                    if(i==j){
                        //strike 증가
                        strikeCount ++
                    } else {
                        //ball 증가
                        ballCount ++
                    }
                }
            }
        }
    }

    override fun setupEvents() {
        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()
            chatList.add(ChatData(inputNum, "ME"))

            chatAdapter?.notifyDataSetChanged()

            userINputNumArray.clear()
            userINputNumArray.add(inputNum.toInt()/100)  // 맨 앞 숫자 추출
            userINputNumArray.add(inputNum.toInt()/ 10 % 10)
            userINputNumArray.add(inputNum.toInt() % 10) // 맨 뒤 숫자 추출

            chatListView.smoothScrollByOffset(chatList.size-1)

            checkAnswer()
        }
    }

    override fun setValus() {
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }


}
