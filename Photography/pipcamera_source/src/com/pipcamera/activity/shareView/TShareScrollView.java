// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.shareView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ta;

public class TShareScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private List bmList;
    private ta mCallback;
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
            addItem(0x7f020283, "sync_wechat");
            addItem(0x7f02026c, "sync_moment");
            addItem(0x7f02027d, "sync_sina");
            addItem(0x7f020275, "sync_qq");
            addItem(0x7f020279, "sync_qqzone");
            addItem(0x7f020277, "sync_qqweibo");
            addItem(0x7f020269, "sync_instagram");
            addItem(0x7f020267, "sync_facebook");
            addItem(0x7f020281, "sync_twitter");
            addItem(0x7f02027f, "sync_tumblr");
            addItem(0x7f020272, "sync_more");
            return;
        } else
        {
            addItem(0x7f020267, "sync_facebook");
            addItem(0x7f020269, "sync_instagram");
            addItem(0x7f020281, "sync_twitter");
            addItem(0x7f02027f, "sync_tumblr");
            addItem(0x7f020283, "sync_wechat");
            addItem(0x7f02026c, "sync_moment");
            addItem(0x7f02027d, "sync_sina");
            addItem(0x7f020275, "sync_qq");
            addItem(0x7f020279, "sync_qqzone");
            addItem(0x7f020277, "sync_qqweibo");
            addItem(0x7f020270, "sync_more");
            return;
        }
    }

    public void addItem(int i, String s)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f030084, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0c010f);
            imagebutton.setTag(s);
            imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

                final TShareScrollView a;

                public void onClick(View view1)
                {
                    if (a.mCurSelectedItem != view1)
                    {
                        if (a.mCurSelectedItem != null)
                        {
                            a.mCurSelectedItem.setSelected(false);
                        }
                        a.mCurSelectedItem = view1;
                    }
                    view1.setSelected(true);
                    if (a.mCallback != null)
                    {
                        a.mCallback.a((String)view1.getTag(), a);
                    }
                }

            
            {
                a = TShareScrollView.this;
                super();
            }
            });
            imagebutton.setBackgroundResource(i);
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



/*
    static View access$002(TShareScrollView tsharescrollview, View view)
    {
        tsharescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
