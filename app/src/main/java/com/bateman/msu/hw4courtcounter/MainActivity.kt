package com.bateman.msu.hw4courtcounter


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bateman.msu.hw4courtcounter.databinding.ActivityMainBinding
import java.io.StreamCorruptedException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var teamAScoreViewModel: TeamAScoreViewModel
    private lateinit var teamBScoreViewModel: TeamBScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamAScoreViewModel = ViewModelProvider(this).get(TeamAScoreViewModel::class.java)
        teamBScoreViewModel = ViewModelProvider(this).get(TeamBScoreViewModel::class.java)

        // Display the initial scores
        displayForTeamA(teamAScoreViewModel.scoreTeamA)
        displayForTeamB(teamBScoreViewModel.scoreTeamB)
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View?) {
        teamAScoreViewModel.scoreTeamA++
        displayForTeamA(teamAScoreViewModel.scoreTeamA)
    }

    fun addTwoForTeamA(v: View?) {
        teamAScoreViewModel.scoreTeamA += 2
        displayForTeamA(teamAScoreViewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View?) {
        teamAScoreViewModel.scoreTeamA += 3
        displayForTeamA(teamAScoreViewModel.scoreTeamA)
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View?) {
        teamBScoreViewModel.scoreTeamB++
        displayForTeamB(teamBScoreViewModel.scoreTeamB)
    }

    fun addTwoForTeamB(v: View?) {
        teamBScoreViewModel.scoreTeamB += 2
        displayForTeamB(teamBScoreViewModel.scoreTeamB)
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View?) {
        teamBScoreViewModel.scoreTeamB += 3
        displayForTeamB(teamBScoreViewModel.scoreTeamB)
    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View?) {
        teamAScoreViewModel.scoreTeamA = 0
        teamBScoreViewModel.scoreTeamB = 0
        displayForTeamA(teamAScoreViewModel.scoreTeamA)
        displayForTeamB(teamBScoreViewModel.scoreTeamB)
    }
    /**
     * Displays the given score for Team A.
     */
    fun displayForTeamA(score: Int) {
        val scoreView = binding.teamAScore
        scoreView.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    fun displayForTeamB(score: Int) {
        val scoreView = binding.teamBScore
        scoreView.text = score.toString()
    }
}