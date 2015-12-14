// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view.scroll;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import bqx;
import bqy;
import bqz;
import bra;
import brb;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewTShareScrollView extends ScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private bqx mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public NewTShareScrollView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public NewTShareScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bmList = new ArrayList();
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        mLayout.setOrientation(1);
        addView(mLayout);
        if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
        {
            addItem(0x7f020414, "sync_moment", "\u670B\u53CB\u5708", 0x7f020426, "sync_sina", "\u65B0\u6D6A\u5FAE\u535A", 0x7f020421, "sync_qqzone", "QQ\u7A7A\u95F4", 0x7f020416, "sync_more", "\u66F4\u591A");
            return;
        }
        if (Locale.getDefault().getLanguage().compareTo("zh_TW") == 0)
        {
            addItem(0x7f020410, "sync_instagram", "Instagram", 0x7f02040e, "sync_facebook", "Facebook", 0x7f020414, "sync_moment", "\u670B\u53CB\u5708", 0x7f020416, "sync_more", "more");
            return;
        } else
        {
            addItem(0x7f02040e, "sync_facebook", "Facebook", 0x7f020410, "sync_instagram", "Instagram", 0x7f02042b, "sync_twitter", "Twitter", 0x7f020416, "sync_more", "more");
            return;
        }
    }

    public void addItem(int i, String s, String s1, int j, String s2, String s3, int k, 
            String s4, String s5, int l, String s6, String s7)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f0300c4, null);
            View view1 = view.findViewById(0x7f0d02cd);
            TextView textview = (TextView)view.findViewById(0x7f0d02cc);
            view.findViewById(0x7f0d02ca);
            textview.setText(s1);
            view1.setTag(s);
            view1.setOnClickListener(new bqy(this));
            view1.setBackgroundDrawable(getResources().getDrawable(i));
            s = view.findViewById(0x7f0d02d1);
            s1 = (TextView)view.findViewById(0x7f0d02d0);
            view.findViewById(0x7f0d02ce);
            s1.setText(s3);
            s.setTag(s2);
            s.setOnClickListener(new bqz(this));
            s.setBackgroundDrawable(getResources().getDrawable(j));
            s = view.findViewById(0x7f0d02d5);
            s1 = (TextView)view.findViewById(0x7f0d02d4);
            view.findViewById(0x7f0d02d2);
            s1.setText(s5);
            s.setTag(s4);
            s.setOnClickListener(new bra(this));
            s.setBackgroundDrawable(getResources().getDrawable(k));
            s = view.findViewById(0x7f0d02d9);
            s1 = (TextView)view.findViewById(0x7f0d02d8);
            view.findViewById(0x7f0d02d6);
            s1.setText(s7);
            s.setTag(s6);
            s.setOnClickListener(new brb(this));
            s.setBackgroundDrawable(getResources().getDrawable(l));
            mLayout.addView(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TFilterListScrollView", s.getMessage());
        }
        Crashlytics.logException(s);
    }

    public void setCallback(bqx bqx)
    {
        mCallback = bqx;
    }



/*
    public static View access$002(NewTShareScrollView newtsharescrollview, View view)
    {
        newtsharescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
