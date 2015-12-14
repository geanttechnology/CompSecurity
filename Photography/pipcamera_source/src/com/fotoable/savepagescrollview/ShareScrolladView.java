// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import ev;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ny;

public class ShareScrolladView extends ScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private View instragramNewView;
    private ny mCallback;
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
            addItem(com.fotoable.fotoadpackage.R.drawable.sync_moments2x, "sync_moment", "\u670B\u53CB\u5708", com.fotoable.fotoadpackage.R.drawable.sync_wechat2x, "sync_wechat", "\u5FAE\u4FE1\u597D\u53CB", com.fotoable.fotoadpackage.R.drawable.sync_qzone2x, "sync_qqzone", "QQ\u7A7A\u95F4", com.fotoable.fotoadpackage.R.drawable.sync_qq2x, "sync_qq", "QQ", com.fotoable.fotoadpackage.R.drawable.sync_sina2x, "sync_sina", "\u65B0\u6D6A\u5FAE\u535A", com.fotoable.fotoadpackage.R.drawable.sync_fb2x, "sync_facebook", "Facebook", com.fotoable.fotoadpackage.R.drawable.sync_instagram2x, "sync_instagram", "Instagram", com.fotoable.fotoadpackage.R.drawable.sync_more2x, "sync_more", "\u66F4\u591A");
            return;
        } else
        {
            addItem(com.fotoable.fotoadpackage.R.drawable.sync_fb2x, "sync_facebook", "Facebook", com.fotoable.fotoadpackage.R.drawable.sync_instagram2x, "sync_instagram", "Instagram", com.fotoable.fotoadpackage.R.drawable.sync_twitter2x, "sync_twitter", "Twitter", com.fotoable.fotoadpackage.R.drawable.sync_line2x, "sync_line", "Line", com.fotoable.fotoadpackage.R.drawable.sync_moments2x, "sync_moment", "Moments", com.fotoable.fotoadpackage.R.drawable.sync_wechat2x, "sync_wechat", "WeChat", com.fotoable.fotoadpackage.R.drawable.sync_sina2x, "sync_sina", "Weibo", com.fotoable.fotoadpackage.R.drawable.sync_more2x, "sync_more", "More");
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
            view = LayoutInflater.from(getContext()).inflate(com.fotoable.fotoadpackage.R.layout.share_scrollview, null);
            view1 = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage1);
            TextView textview = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText1);
            if (s.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new1);
            }
            view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout1);
            textview.setText(s1);
            view1.setTag(s);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final ShareScrolladView a;

                public void onClick(View view2)
                {
                    if (a.mCurSelectedItem != view2)
                    {
                        if (a.mCurSelectedItem != null)
                        {
                            a.mCurSelectedItem.setSelected(false);
                        }
                        a.mCurSelectedItem = view2;
                    }
                    view2.setSelected(true);
                    if (a.mCallback != null)
                    {
                        a.mCallback.a((String)view2.getTag(), a);
                    }
                }

            
            {
                a = ShareScrolladView.this;
                super();
            }
            });
            s = ev.a(getContext(), i);
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
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new2);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage2);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText2);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout2);
        s1.setText(s3);
        s.setTag(s2);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), j);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        s.setBackgroundDrawable(s1);
        if (s4.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new3);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage3);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText3);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout3);
        s1.setText(s5);
        s.setTag(s4);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), k);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_303;
        }
        s.setBackgroundDrawable(s1);
        if (s6.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new4);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage4);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText4);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout4);
        s1.setText(s7);
        s.setTag(s6);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), l);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        s.setBackgroundDrawable(s1);
        if (s8.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new5);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage5);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText5);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout5);
        s1.setText(s9);
        s.setTag(s8);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), i1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_493;
        }
        s.setBackgroundDrawable(s1);
        if (s10.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new6);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage6);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText6);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout6);
        s1.setText(s11);
        s.setTag(s10);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), j1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_588;
        }
        s.setBackgroundDrawable(s1);
        if (s12.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new7);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage7);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText7);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout7);
        s1.setText(s13);
        s.setTag(s12);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), k1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_683;
        }
        s.setBackgroundDrawable(s1);
        if (s14.equalsIgnoreCase("sync_instagram"))
        {
            instragramNewView = view.findViewById(com.fotoable.fotoadpackage.R.id.flag_new8);
        }
        s = view.findViewById(com.fotoable.fotoadpackage.R.id.shareImage8);
        s1 = (TextView)view.findViewById(com.fotoable.fotoadpackage.R.id.shareText8);
        view.findViewById(com.fotoable.fotoadpackage.R.id.lineHorizLayout8);
        s1.setText(s15);
        s.setTag(s14);
        s.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareScrolladView a;

            public void onClick(View view2)
            {
                if (a.mCurSelectedItem != view2)
                {
                    if (a.mCurSelectedItem != null)
                    {
                        a.mCurSelectedItem.setSelected(false);
                    }
                    a.mCurSelectedItem = view2;
                }
                view2.setSelected(true);
                if (a.mCallback != null)
                {
                    a.mCallback.a((String)view2.getTag(), a);
                }
            }

            
            {
                a = ShareScrolladView.this;
                super();
            }
        });
        s1 = ev.a(getContext(), l1);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_778;
        }
        s.setBackgroundDrawable(s1);
        mLayout.addView(view);
        return;
    }

    public void setCallback(ny ny)
    {
        mCallback = ny;
    }

    public void setInstagramNewViewVisibility(boolean flag)
    {
        if (instragramNewView != null)
        {
            instragramNewView.setBackgroundResource(com.fotoable.fotoadpackage.R.drawable.gr_newupdate);
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
    static View access$002(ShareScrolladView sharescrolladview, View view)
    {
        sharescrolladview.mCurSelectedItem = view;
        return view;
    }

*/

}
