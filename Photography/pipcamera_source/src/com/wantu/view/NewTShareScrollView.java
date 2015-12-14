// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ta;

public class NewTShareScrollView extends ScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private View instragramNewView;
    private ta mCallback;
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
            addItem(0x7f02026d, "sync_moment", "\u670B\u53CB\u5708", 0x7f020284, "sync_wechat", "\u5FAE\u4FE1\u597D\u53CB", 0x7f02027a, "sync_qqzone", "QQ\u7A7A\u95F4", 0x7f020276, "sync_qq", "QQ", 0x7f02027e, "sync_sina", "\u65B0\u6D6A\u5FAE\u535A", 0x7f020268, "sync_facebook", "Facebook", 0x7f02026a, "sync_instagram", "Instagram", 0x7f02026f, "sync_more", "\u66F4\u591A");
            return;
        }
        if (Locale.getDefault().getLanguage().compareTo("zh_TW") == 0)
        {
            addItem(0x7f02026a, "sync_instagram", "Instagram", 0x7f020268, "sync_facebook", "Facebook", 0x7f020282, "sync_twitter", "Twitter", 0x7f02026b, "sync_line", "Line", 0x7f02026d, "sync_moment", "Moments", 0x7f020284, "sync_wechat", "WeChat", 0x7f02027e, "sync_sina", "Weibo", 0x7f02026f, "sync_more", "More");
            return;
        } else
        {
            addItem(0x7f020268, "sync_facebook", "Facebook", 0x7f02026a, "sync_instagram", "Instagram", 0x7f020282, "sync_twitter", "Twitter", 0x7f02026b, "sync_line", "Line", 0x7f02026d, "sync_moment", "Moments", 0x7f020284, "sync_wechat", "WeChat", 0x7f02027e, "sync_sina", "Weibo", 0x7f02026f, "sync_more", "More");
            return;
        }
    }

    public void addItem(int i, String s, String s1, int j, String s2, String s3, int k, 
            String s4, String s5, int l, String s6, String s7, int i1, String s8, 
            String s9, int j1, String s10, String s11, int k1, String s12, String s13, 
            int l1, String s14, String s15)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f030061, null);
            View view1 = view.findViewById(0x7f0c01b4);
            TextView textview = (TextView)view.findViewById(0x7f0c01b6);
            if (s.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(0x7f0c01b5);
            }
            view.findViewById(0x7f0c01b2);
            textview.setText(s1);
            view1.setTag(s);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            view1.setBackgroundDrawable(getResources().getDrawable(i));
            s = view.findViewById(0x7f0c01b9);
            s1 = (TextView)view.findViewById(0x7f0c01bb);
            view.findViewById(0x7f0c01b7);
            s1.setText(s3);
            s.setTag(s2);
            if (s2.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(0x7f0c01ba);
            }
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(j));
            s = view.findViewById(0x7f0c01be);
            s1 = (TextView)view.findViewById(0x7f0c01c0);
            if (s4.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(0x7f0c01bf);
            }
            view.findViewById(0x7f0c01bc);
            s1.setText(s5);
            s.setTag(s4);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(k));
            s = view.findViewById(0x7f0c01c3);
            s1 = (TextView)view.findViewById(0x7f0c01c5);
            if (s6.equalsIgnoreCase("sync_instagram"))
            {
                instragramNewView = view.findViewById(0x7f0c01c4);
            }
            view.findViewById(0x7f0c01c1);
            s1.setText(s7);
            s.setTag(s6);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(l));
            s = view.findViewById(0x7f0c01c9);
            s1 = (TextView)view.findViewById(0x7f0c01cb);
            view.findViewById(0x7f0c01c7);
            s1.setText(s9);
            s.setTag(s8);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(i1));
            s = view.findViewById(0x7f0c01ce);
            s1 = (TextView)view.findViewById(0x7f0c01d0);
            view.findViewById(0x7f0c01cc);
            s1.setText(s11);
            s.setTag(s10);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(j1));
            s = view.findViewById(0x7f0c01d3);
            s1 = (TextView)view.findViewById(0x7f0c01d5);
            view.findViewById(0x7f0c01d1);
            s1.setText(s13);
            s.setTag(s12);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(k1));
            s = view.findViewById(0x7f0c01d8);
            s1 = (TextView)view.findViewById(0x7f0c01da);
            view.findViewById(0x7f0c01d6);
            s1.setText(s15);
            s.setTag(s14);
            s.setOnClickListener(new android.view.View.OnClickListener() {

                final NewTShareScrollView a;

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
                a = NewTShareScrollView.this;
                super();
            }
            });
            s.setBackgroundDrawable(getResources().getDrawable(l1));
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

    public void setCallback(ta ta)
    {
        mCallback = ta;
    }

    public void setInstagramNewViewVisibility(boolean flag)
    {
        if (instragramNewView != null)
        {
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
    static View access$002(NewTShareScrollView newtsharescrollview, View view)
    {
        newtsharescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
