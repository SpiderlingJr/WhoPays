package scom.example.whopays

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import scom.example.whopays.databinding.FragmentPartnerViewBinding

class PartnerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPartnerViewBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_partner_view, container, false
        )
        // Inflate the layout for this fragment
        binding.buttonNewPartner.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_partnerViewFragment_to_invitePartnerFragment))
        binding.buttonPendingInvites.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_partnerViewFragment_to_pendingInvites))
        return binding.root
    }
}