// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import aaq;
import aar;
import aas;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import atg;
import ati;
import atj;
import atk;
import atl;
import atm;
import atn;
import ato;
import atp;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import yo;

public class ShareScrolladView extends ScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private View instragramNewView;
    private atg mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public ShareScrolladView(Context context)
    {
        super(context);
        bmList = new ArrayList();
        init();
    }

    public ShareScrolladView(Context context, AttributeSet attributeset)
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
            addItem(aaq.sync_moments2x, "sync_moment", "\u670B\u53CB\u5708", aaq.sync_wechat2x, "sync_wechat", "\u5FAE\u4FE1\u597D\u53CB", aaq.sync_qzone2x, "sync_qqzone", "QQ\u7A7A\u95F4", aaq.sync_qq2x, "sync_qq", "QQ", aaq.sync_sina2x, "sync_sina", "\u65B0\u6D6A\u5FAE\u535A", aaq.sync_fb2x, "sync_facebook", "Facebook", aaq.sync_instagram2x, "sync_instagram", "Instagram", aaq.sync_more2x, "sync_more", "\u66F4\u591A");
            return;
        } else
        {
            addItem(aaq.sync_fb2x, "sync_facebook", "Facebook", aaq.sync_instagram2x, "sync_instagram", "Instagram", aaq.sync_twitter2x, "sync_twitter", "Twitter", aaq.sync_line2x, "sync_line", "Line", aaq.sync_moments2x, "sync_moment", "Moments", aaq.sync_wechat2x, "sync_wechat", "WeChat", aaq.sync_sina2x, "sync_sina", "Weibo", aaq.sync_more2x, "sync_more", "More");
            return;
        }
    }

    public void addItem(int i, String s, String s1, int j, String s2, String s3, int k, 
            String s4, String s5, int l, String s6, String s7, int i1, String s8, 
            String s9, int j1, String s10, String s11, int k1, String s12, String s13, 
            int l1, String s14, String s15)
    {
        View view;
        View view1;
        try
        {
            view = LayoutInflater.from(getContext()).inflate(aas.share_scrollview, null);
            view1 = view.findViewById(aar.shareImage1);
            TextView textview = (TextView)view.findViewById(aar.shareText1);
            if (s.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(aar.flag_new1);
            }
            view.findViewById(aar.lineHorizLayout1);
            textview.setText(s1);
            view1.setTag(s);
            view1.setOnClickListener(new ati(this));
            s = yo.a(getContext(), i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TFilterListScrollView", s.getMessage());
            Crashlytics.logException(s);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        view1.setBackgroundDrawable(s);
        if (s2.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new2);
        }
        s = view.findViewById(aar.shareImage2);
        s1 = (TextView)view.findViewById(aar.shareText2);
        view.findViewById(aar.lineHorizLayout2);
        s1.setText(s3);
        s.setTag(s2);
        s.setOnClickListener(new atj(this));
        s1 = yo.a(getContext(), j);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        s.setBackgroundDrawable(s1);
        if (s4.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new3);
        }
        s = view.findViewById(aar.shareImage3);
        s1 = (TextView)view.findViewById(aar.shareText3);
        view.findViewById(aar.lineHorizLayout3);
        s1.setText(s5);
        s.setTag(s4);
        s.setOnClickListener(new atk(this));
        s1 = yo.a(getContext(), k);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        s.setBackgroundDrawable(s1);
        if (s6.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new4);
        }
        s = view.findViewById(aar.shareImage4);
        s1 = (TextView)view.findViewById(aar.shareText4);
        view.findViewById(aar.lineHorizLayout4);
        s1.setText(s7);
        s.setTag(s6);
        s.setOnClickListener(new atl(this));
        s1 = yo.a(getContext(), l);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        s.setBackgroundDrawable(s1);
        if (s8.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new5);
        }
        s = view.findViewById(aar.shareImage5);
        s1 = (TextView)view.findViewById(aar.shareText5);
        view.findViewById(aar.lineHorizLayout5);
        s1.setText(s9);
        s.setTag(s8);
        s.setOnClickListener(new atm(this));
        s1 = yo.a(getContext(), i1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_493;
        }
        s.setBackgroundDrawable(s1);
        if (s10.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new6);
        }
        s = view.findViewById(aar.shareImage6);
        s1 = (TextView)view.findViewById(aar.shareText6);
        view.findViewById(aar.lineHorizLayout6);
        s1.setText(s11);
        s.setTag(s10);
        s.setOnClickListener(new atn(this));
        s1 = yo.a(getContext(), j1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_588;
        }
        s.setBackgroundDrawable(s1);
        if (s12.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new7);
        }
        s = view.findViewById(aar.shareImage7);
        s1 = (TextView)view.findViewById(aar.shareText7);
        view.findViewById(aar.lineHorizLayout7);
        s1.setText(s13);
        s.setTag(s12);
        s.setOnClickListener(new ato(this));
        s1 = yo.a(getContext(), k1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_683;
        }
        s.setBackgroundDrawable(s1);
        if (s14.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(aar.flag_new8);
        }
        s = view.findViewById(aar.shareImage8);
        s1 = (TextView)view.findViewById(aar.shareText8);
        view.findViewById(aar.lineHorizLayout8);
        s1.setText(s15);
        s.setTag(s14);
        s.setOnClickListener(new atp(this));
        s1 = yo.a(getContext(), l1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_778;
        }
        s.setBackgroundDrawable(s1);
        mLayout.addView(view);
        return;
    }

    public void setCallback(atg atg)
    {
        mCallback = atg;
    }

    public void setInstagramNewViewVisibility(boolean flag)
    {
        if (instragramNewView != null)
        {
            instragramNewView.setBackgroundResource(aaq.gr_newupdate);
            View view = instragramNewView;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            view.setVisibility(i);
        }
    }



/*
    public static View access$002(ShareScrolladView sharescrolladview, View view)
    {
        sharescrolladview.mCurSelectedItem = view;
        return view;
    }

*/

}
