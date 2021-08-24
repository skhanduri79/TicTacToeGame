package com.example.tictactoe

//import android.graphics.Color
//import android.graphics.Color

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoe.R.*
import com.example.tictactoe.R.color.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
    }




    fun onBtnClick(view: View) {
        val btnSelected = view as Button

        var cellID = 0
        when(btnSelected.id){
            id.btn1-> cellID=1
            id.btn2-> cellID=2
            id.btn3-> cellID=3
            id.btn4-> cellID=4
            id.btn5-> cellID=5
            id.btn6-> cellID=6
            id.btn7-> cellID=7
            id.btn8-> cellID=8
            id.btn9-> cellID=9
        }

        Log.d("onBtnClick:", btnSelected.id.toString())
        Log.d("onBtnClick: cellId: ", cellID.toString())
        playGame(cellID,btnSelected)
    }
    var activePlayer=1
    var player1 = ArrayList<Int>()
    var player2= ArrayList<Int>()

    @SuppressLint("ResourceAsColor")
    fun playGame(cellId:Int, btnSelected:Button){

        if(activePlayer == 1){
            btnSelected.text="X"
            btnSelected.setBackgroundResource(mint)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }
        else{
            btnSelected.text="O"
            btnSelected.setBackgroundResource(pink)
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){

        var winner = -1

        // row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2

        //row 2
        if(player1.contains(3) && player1.contains(4) && player1.contains(5))
            winner = 1
        if(player2.contains(3) && player2.contains(4) && player2.contains(5))
            winner = 2

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        //column 1

        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2

        // column 2

        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        if(player2.contains(3) && player2.contains(4) && player2.contains(5))
            winner = 2

        // column 3

        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        // diagnal 1

        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2

        // diagnol 2

        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2

        if (winner==1){
            Toast.makeText(this, "player 1 is the winner", Toast.LENGTH_LONG).show()
            restartGame()
        }
        else if( winner==2){
            Toast.makeText(this,"player 2 is the winner", Toast.LENGTH_LONG).show()
            restartGame()
        }
    }
    fun autoPlay()
    {
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9){
            if (!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        var btnSelected:Button?
        btnSelected = when(cellId){
            1->btn1
            2->btn2
            3->btn3
            4->btn4
            5->btn5
            6->btn6
            7->btn7
            8->btn8
            9->btn9
            else ->{btn1}
        }
        playGame(cellId, btnSelected)
    }
    

    fun restartGame(){
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (cellId in 1..9){
            var btnSelected:Button? = when(cellId){
                1->btn1
                2->btn2
                3->btn3
                4->btn4
                5->btn5
                6->btn6
                7->btn7
                8->btn8
                9->btn9
                else ->{btn1}
            }
            btnSelected!!.text=""
            btnSelected.setBackgroundResource(white)
        }
    }
}