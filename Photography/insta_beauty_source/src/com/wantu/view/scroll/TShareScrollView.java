// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bqx;
import brc;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TShareScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private bqx mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TShareScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public TShareScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bmList = new ArrayList();
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            addItem(0x7f020419, "sync_more");
            addItem(0x7f020424, "sync_sina");
            addItem(0x7f02041c, "sync_qq");
            addItem(0x7f020420, "sync_qqzone");
            addItem(0x7f02041e, "sync_qqweibo");
            addItem(0x7f02040f, "sync_instagram");
            addItem(0x7f020422, "sync_rr");
            addItem(0x7f02040d, "sync_facebook");
            addItem(0x7f02042a, "sync_twitter");
            addItem(0x7f020428, "sync_tumblr");
            return;
        } else
        {
            addItem(0x7f020415, "sync_more");
            addItem(0x7f02040d, "sync_facebook");
            addItem(0x7f02040f, "sync_instagram");
            addItem(0x7f02042a, "sync_twitter");
            addItem(0x7f020428, "sync_tumblr");
            addItem(0x7f020424, "sync_sina");
            addItem(0x7f02041c, "sync_qq");
            addItem(0x7f020420, "sync_qqzone");
            addItem(0x7f02041e, "sync_qqweibo");
            addItem(0x7f020422, "sync_rr");
            return;
        }
    }

    public void addItem(int i, String s)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f0300c3, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01cd);
            imagebutton.setTag(s);
            imagebutton.setOnClickListener(new brc(this));
            imagebutton.setBackgroundResource(i);
            mLayout.addView(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TFilterListScrollView", s.getMessage());
        }
    }

    public void setCallback(bqx bqx)
    {
        mCallback = bqx;
    }



/*
    public static View access$002(TShareScrollView tsharescrollview, View view)
    {
        tsharescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
