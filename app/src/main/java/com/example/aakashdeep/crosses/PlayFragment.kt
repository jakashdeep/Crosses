package com.example.aakashdeep.crosses

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_play.*


class PlayFragment : Fragment(), View.OnClickListener {

    val TAG:String = "ak_playfragment"

    var firstPlayer:Boolean = true
    val userClicks = IntArray(5, { i -> 0})
//    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_play, container, false)
        return view;
    }

    override fun onStart() {
        super.onStart()

        row1button1.setOnClickListener(this)
        row1button2.setOnClickListener(this)
        row1button3.setOnClickListener(this)

        row2button1.setOnClickListener(this)
        row2button2.setOnClickListener(this)
        row2button3.setOnClickListener(this)

        row3button1.setOnClickListener(this)
        row3button2.setOnClickListener(this)
        row3button3.setOnClickListener(this)

        tableLayout.visibility = View.GONE;
    }

    fun onButtonPressed(uri: Uri) {
//        if (mListener != null) {
//            mListener!!.onFragmentInteraction(uri)
//        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            mListener = context
//        } else {
//            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
//        mListener = null
    }


//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }

    interface OnFragmentUserPlayListener {
        // TODO: Update argument type and name
        fun onUserPlay(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): PlayFragment {
            val fragment = PlayFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onClick(view: View?) {

        Log.d(TAG, "got onclick event: " + view)
        when (view) {
            row1button1 -> onPlayerClick(1,1, view)
            row1button2 -> onPlayerClick(1,2, view)
            row1button3 -> onPlayerClick(1,3, view)

            row2button1 -> onPlayerClick(2,1, view)
            row2button2 -> onPlayerClick(2,2, view)
            row2button3 -> onPlayerClick(2,3, view)

            row3button1 -> onPlayerClick(3,1, view)
            row3button2 -> onPlayerClick(3,2, view)
            row3button3 -> onPlayerClick(3,3, view)
        }
    }

    fun onPlayerClick(row: Int, column:Int, view: View?){
        Log.d(TAG, "firstPlayer: " + firstPlayer)
        if(firstPlayer){
            viewModifier(view, "X", true, R.color.colorAccent )
        } else{
            viewModifier(view, "O", true, R.color.colorPrimary )
        }
        firstPlayer = firstPlayer.not() //Next players chance


    }

    fun viewModifier(view: View?, text:String, disable:Boolean, color:Int){
        if(view != null){
            val b = view as Button
            b.isClickable = false
            b.text = text
            b.setBackgroundColor(resources.getColor(color))
        }
    }
}
