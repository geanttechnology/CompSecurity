// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class SyncHorizontalScrollView extends HorizontalScrollView
{

    private ImageView leftImage;
    private Activity mContext;
    private ImageView rightImage;
    private View view;
    private int windowWitdh;

    public SyncHorizontalScrollView(Context context)
    {
        super(context);
        windowWitdh = 0;
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        windowWitdh = 0;
    }

    public void setSomeParam(View view1, ImageView imageview, ImageView imageview1, Activity activity)
    {
        mContext = activity;
        view = view1;
        leftImage = imageview;
        rightImage = imageview1;
        view1 = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(view1);
        windowWitdh = ((DisplayMetrics) (view1)).widthPixels;
    }

    public void showAndHideArrow()
    {
label0:
        {
            if (!mContext.isFinishing() && view != null)
            {
                measure(0, 0);
                if (windowWitdh < getMeasuredWidth())
                {
                    break label0;
                }
                leftImage.setVisibility(8);
                rightImage.setVisibility(8);
            }
            return;
        }
        if (getLeft() == 0)
        {
            leftImage.setVisibility(8);
            rightImage.setVisibility(0);
            return;
        }
        if (getRight() == getMeasuredWidth() - windowWitdh)
        {
            leftImage.setVisibility(0);
            rightImage.setVisibility(8);
            return;
        } else
        {
            leftImage.setVisibility(0);
            rightImage.setVisibility(0);
            return;
        }
    }
}
