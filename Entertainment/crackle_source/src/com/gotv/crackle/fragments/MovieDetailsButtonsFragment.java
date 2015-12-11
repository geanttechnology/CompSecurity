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

public class MovieDetailsButtonsFragment extends Fragment
{
    public static interface MovieDetailsButtonListener
    {

        public abstract void onMovieAddToWatchlistCheckChanged(boolean flag);

        public abstract void onMovieDetailsWatchNowClick();
    }


    private boolean mAdToWatchlistButtonState;
    private MovieDetailsButtonListener mMovieDetailsButtonListener;
    private android.widget.CompoundButton.OnCheckedChangeListener mWatchlistCheckChangedListener;

    public MovieDetailsButtonsFragment()
    {
        mAdToWatchlistButtonState = false;
        mWatchlistCheckChangedListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final MovieDetailsButtonsFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                mMovieDetailsButtonListener.onMovieAddToWatchlistCheckChanged(flag);
            }

            
            {
                this$0 = MovieDetailsButtonsFragment.this;
                super();
            }
        };
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mMovieDetailsButtonListener = (MovieDetailsButtonListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement MovieDetailsButtonListener.").toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030057, viewgroup, false);
        viewgroup = (Button)layoutinflater.findViewById(0x7f0a00dd);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            final MovieDetailsButtonsFragment this$0;

            public void onClick(View view)
            {
                mMovieDetailsButtonListener.onMovieDetailsWatchNowClick();
            }

            
            {
                this$0 = MovieDetailsButtonsFragment.this;
                super();
            }
        });
        bundle = (ToggleButton)layoutinflater.findViewById(0x7f0a0113);
        bundle.setChecked(mAdToWatchlistButtonState);
        bundle.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        if (Application.isFanhattan())
        {
            viewgroup.setBackgroundResource(0x7f0200c1);
            bundle.setBackgroundResource(0x7f0200c1);
            bundle.setVisibility(8);
        }
        return layoutinflater;
    }

    public void setAddToWatchlistButtonState(boolean flag)
    {
        mAdToWatchlistButtonState = flag;
        if (getView() != null)
        {
            ToggleButton togglebutton = (ToggleButton)getView().findViewById(0x7f0a0113);
            togglebutton.setOnCheckedChangeListener(null);
            togglebutton.setChecked(mAdToWatchlistButtonState);
            togglebutton.setOnCheckedChangeListener(mWatchlistCheckChangedListener);
        }
    }

}
