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
import com.gotv.crackle.Application;

public class WatchlistDetailsWhyCracklesFragment extends Fragment
{

    private TextView mWhyCracklesLabel;
    private View mWhyCracklesLine;
    private TextView mWhyCracklesText;

    public WatchlistDetailsWhyCracklesFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030080, viewgroup, false);
        mWhyCracklesLabel = (TextView)layoutinflater.findViewById(0x7f0a0104);
        mWhyCracklesLine = layoutinflater.findViewById(0x7f0a01aa);
        mWhyCracklesText = (TextView)layoutinflater.findViewById(0x7f0a0105);
        if (Application.getInstance().isTablet())
        {
            mWhyCracklesLabel.setPadding(0, 0, 0, 0);
            mWhyCracklesText.setPadding(0, 0, 0, 0);
        }
        return layoutinflater;
    }

    public void setWatchlistDetailsWhyCrackles(String s)
    {
        if (s == null || s.equalsIgnoreCase(""))
        {
            mWhyCracklesLabel.setVisibility(8);
            mWhyCracklesLine.setVisibility(8);
            mWhyCracklesText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mWhyCracklesText.setText(s);
            return;
        } else
        {
            mWhyCracklesText.setText(Application.setStringColor("", s));
            return;
        }
    }
}
