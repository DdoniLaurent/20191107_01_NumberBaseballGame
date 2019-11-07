package com.tioeun.a20191107_01_numberbaseballgame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tioeun.a20191107_01_numberbaseballgame.R
import com.tioeun.a20191107_01_numberbaseballgame.datas.ChatData
import org.w3c.dom.Text

class ChatAdapter(context: Context, res:Int, list:ArrayList<ChatData>) : ArrayAdapter<ChatData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context: Context, list: ArrayList<ChatData>) : this(context, R.layout.chat_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.chat_list_item, null)
        }
        var row = tempRow!!

        var data = mList.get(position)

        var contentTxt = row.findViewById<TextView>(R.id.contentTxt)

        contentTxt.text = data.message

        return row
    }

}