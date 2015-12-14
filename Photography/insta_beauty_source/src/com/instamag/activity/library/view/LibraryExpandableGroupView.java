// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdk;

public class LibraryExpandableGroupView extends LinearLayout
{

    ImageView img_section;
    bdk listener;
    boolean mIsEdit;
    TextView txt_title;

    public LibraryExpandableGroupView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03007e, this, true);
        txt_title = (TextView)findViewById(0x7f0d0278);
        img_section = (ImageView)findViewById(0x7f0d0277);
    }

    public void handleDataWithState(boolean flag)
    {
        if (flag)
        {
            img_section.setBackgroundResource(0x7f0202ba);
            return;
        } else
        {
            img_section.setBackgroundResource(0x7f0202bb);
            return;
        }
    }

    public void handleDataWithTitleAndMode(String s, boolean flag)
    {
        txt_title.setText(s);
        if (!flag);
        mIsEdit = flag;
    }

    public void setIconColor(int i)
    {
    }

    public void setListener(bdk bdk)
    {
        listener = bdk;
    }
}
