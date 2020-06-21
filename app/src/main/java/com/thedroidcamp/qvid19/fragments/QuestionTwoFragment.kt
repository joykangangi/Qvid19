package com.thedroidcamp.qvid19.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import android.widget.Toast
import com.thedroidcamp.qvid19.MainActivity
import com.thedroidcamp.qvid19.R
import com.thedroidcamp.qvid19.databinding.FragmentQuestionTwoBinding
import kotlinx.android.synthetic.main.fragment_question_two.*


class QuestionTwoFragment : Fragment() {

    lateinit var navController: NavController
    private lateinit var _binding: FragmentQuestionTwoBinding
    private lateinit var mainActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mainActivity =
            context as MainActivity // doing this because running i don't know about how to pass the score to next fragment
        if (mainActivity.q2Answered) {
            _binding.answerGroup.isEnabled = false
            setAllRadioButtonDisable()
        }
        _binding = DataBindingUtil.inflate<FragmentQuestionTwoBinding>(
            inflater, R.layout.fragment_question_two, container, false
        )
        _binding.questionTwo = this
        _binding.invalidateAll()
        return _binding.root
    }

    private fun setAllRadioButtonDisable() {
        _binding.optionOneRadioBtn.isEnabled = false
        _binding.optionTwoRadioBtn.isEnabled = false
        _binding.optionThreeRadioBtn.isEnabled = false

    }

    private fun goToNext() {
        navController.navigate(QuestionTwoFragmentDirections.actionQuestionTwoFragmentToQuestionThreeFragment())
        when (_binding.answerGroup.checkedRadioButtonId) {
            -1 -> return
            _binding.optionThreeRadioBtn.id -> addUpScore()
        }
        //save a state that question one answered already
        mainActivity.setAnswered(2) //setting answer id 1 as answered
    }

    private fun goToPrevious() {
        navController.navigate(QuestionTwoFragmentDirections.actionQuestionTwoFragmentToQuestionOneFragment2())
    }

    private fun addUpScore() {
        mainActivity.calculateScore(10) //giving 10 point for correct answer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        _binding.scoreView.text = mainActivity.currentScore.toString()
        _binding.nextLink.setOnClickListener { goToNext() }
        _binding.previousLink.setOnClickListener { goToPrevious() }
    }



}