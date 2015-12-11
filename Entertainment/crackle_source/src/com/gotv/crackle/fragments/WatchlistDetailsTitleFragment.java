// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WatchlistDetailsTitleFragment extends Fragment
{

    private TextView mTitleText;

    public WatchlistDetailsTitleFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03007f, viewgroup, false);
        mTitleText = (TextView)layoutinflater.findViewById(0x7f0a01a9);
        return layoutinflater;
    }

    public void setWatchlistDetailsTitle(String s)
    {
        if (s == null)
        {
            mTitleText.setVisibility(8);
            return;
        } else
        {
            mTitleText.setText(s);
            return;
        }
    }
}
