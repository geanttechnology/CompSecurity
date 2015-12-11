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

public class ShowDetailsButtonsFragment extends Fragment
{
    public static interface ShowDetailsButtonListener
    {

        public abstract void onBrowseEpisodesClick();

        public abstract void onShowDetailsAddToWatchlistCheckChanged(boolean flag);

        public abstract void onShowDetailsWatchNowClick();
    }


    private boolean mAdToWatchlistButtonState;
    private ToggleButton mAddWatchlistButton;
    private Button mBrowseEpisodesButton;
    private ShowDetailsButtonListener mShowDetailsButtonListener;
    private android.widget.CompoundButton.OnCheckedChangeListener mWatchlistCheckChangedListener;

    public ShowDetailsButtonsFragment()
    {
        mAdToWatchlistButtonState = false;
        mWatchlistCheckChangedListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final ShowDetailsButtonsFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                mShowDetailsButtonListener.onShowDetailsAddToWatchlistCheckChanged(flag);
            }

            
            {
                this$0 = ShowDetailsButtonsFragment.this;
                super();
            }
        };
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mShowDetailsButtonListener = (ShowDetailsButtonListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ShowDetailsButtonListener.").toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006d, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00dd);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowDetailsButtonsFragment this$0;

            public void onClick(View view)
            {
                mShowDetailsButtonListener.onShowDetailsWatchNowClick();
            }

            
            {
                this$0 = ShowDetailsButtonsFragment.this;
                super();
            }
        });
        mBrowseEpisodesButton = (Button)layoutinflater.findViewById(0x7f0a017d);
        mBrowseEpisodesButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShowDetailsButtonsFragment this$0;

            public void onClick(View view)
            {
                mShowDetailsButtonListener.onBrowseEpisodesClick();
            }

            
            {
                this$0 = ShowDetailsButtonsFragment.this;
                super();
            }
        });
        mAddWatchlistButton = (ToggleButton)layoutinflater.findViewById(0x7f0a017e);
        mAddWatchlistButton.setChecked(mAdToWatchlistButtonState);
        mAddWatchlistButton.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        if (Application.isFanhattan())
        {
            viewgroup.setBackgroundResource(0x7f0200c1);
            mBrowseEpisodesButton.setBackgroundResource(0x7f0200c1);
            mAddWatchlistButton.setBackgroundResource(0x7f0200c1);
            mAddWatchlistButton.setVisibility(8);
        }
        return layoutinflater;
    }

    public void setAddToWatchlistButtonState(boolean flag)
    {
        mAdToWatchlistButtonState = flag;
        if (getView() != null)
        {
            mAddWatchlistButton.setOnCheckedChangeListener(null);
            mAddWatchlistButton.setChecked(mAdToWatchlistButtonState);
            mAddWatchlistButton.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        }
    }

    public void setAddWatchlistOffTitle(String s)
    {
        mAddWatchlistButton.setTextOff(s);
    }

    public void setAddWatchlistOnTitle(String s)
    {
        mAddWatchlistButton.setTextOn(s);
    }

    public void setBrowseTitle(String s)
    {
        mBrowseEpisodesButton.setText(s);
    }

}
