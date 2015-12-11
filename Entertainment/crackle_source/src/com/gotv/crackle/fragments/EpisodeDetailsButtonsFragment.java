// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.gotv.crackle.Application;

public class EpisodeDetailsButtonsFragment extends Fragment
{
    public static interface EpisodeDetailsButtonListener
    {

        public abstract void onEpisodeAddToWatchlistCheckChanged(boolean flag);

        public abstract void onEpisodeDetailsWatchNowClick();

        public abstract void onShowInfoClick();
    }


    private boolean mAdToWatchlistButtonState;
    private EpisodeDetailsButtonListener mEpisodeDetailsButtonListener;
    private android.widget.CompoundButton.OnCheckedChangeListener mWatchlistCheckChangedListener;

    public EpisodeDetailsButtonsFragment()
    {
        mAdToWatchlistButtonState = false;
        mWatchlistCheckChangedListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final EpisodeDetailsButtonsFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                mEpisodeDetailsButtonListener.onEpisodeAddToWatchlistCheckChanged(flag);
            }

            
            {
                this$0 = EpisodeDetailsButtonsFragment.this;
                super();
            }
        };
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mEpisodeDetailsButtonListener = (EpisodeDetailsButtonListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement EpisodeDetailsButtonListener.").toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030046, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00dd);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final EpisodeDetailsButtonsFragment this$0;

            public void onClick(View view)
            {
                mEpisodeDetailsButtonListener.onEpisodeDetailsWatchNowClick();
            }

            
            {
                this$0 = EpisodeDetailsButtonsFragment.this;
                super();
            }
        });
        bundle = (Button)layoutinflater.findViewById(0x7f0a00df);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final EpisodeDetailsButtonsFragment this$0;

            public void onClick(View view)
            {
                mEpisodeDetailsButtonListener.onShowInfoClick();
            }

            
            {
                this$0 = EpisodeDetailsButtonsFragment.this;
                super();
            }
        });
        ToggleButton togglebutton = (ToggleButton)layoutinflater.findViewById(0x7f0a00de);
        togglebutton.setChecked(mAdToWatchlistButtonState);
        togglebutton.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        if (Application.isFanhattan())
        {
            viewgroup.setBackgroundResource(0x7f0200c1);
            bundle.setBackgroundResource(0x7f0200c1);
            togglebutton.setBackgroundResource(0x7f0200c1);
            togglebutton.setVisibility(8);
        }
        return layoutinflater;
    }

    public void setAddToWatchlistButtonState(boolean flag)
    {
        mAdToWatchlistButtonState = flag;
        if (getView() != null)
        {
            ToggleButton togglebutton = (ToggleButton)getView().findViewById(0x7f0a00de);
            togglebutton.setOnCheckedChangeListener(null);
            togglebutton.setChecked(mAdToWatchlistButtonState);
            togglebutton.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        }
    }

}
