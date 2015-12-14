// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import asx;
import bjn;
import bjo;
import bjp;
import yo;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private bjp mCallback;
    private LinearLayout mLayout;

    public PhotoSelectScrollView(Context context)
    {
        super(context);
        init();
    }

    public PhotoSelectScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(asx asx1)
    {
        Log.v("PhotoSelectScrollView", "addItem");
        View view;
        ImageButton imagebutton;
        Bitmap bitmap;
        try
        {
            view = LayoutInflater.from(getContext()).inflate(0x7f0300c0, null);
            imagebutton = (ImageButton)view.findViewById(0x7f0d01cd);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(0x7f0d0305);
            view.setTag(new Integer(mLayout.getChildCount()));
            imagebutton1.setOnClickListener(new bjn(this, view));
            asx1 = asx1.a(getContext(), 120, 120);
        }
        // Misplaced declaration of an exception variable
        catch (asx asx1)
        {
            Log.e("PhotoSelectScrollView", (new StringBuilder()).append(asx1.getMessage()).append("Exception").toString());
            return;
        }
        if (asx1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        bitmap = yo.a(asx1, 10F);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        imagebutton.setImageBitmap(bitmap);
        asx1.recycle();
_L2:
        mLayout.addView(view);
        (new Handler()).postDelayed(new bjo(this), 300L);
        return;
        Log.v("hedong_icon", "no bimap");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void scroolToLast()
    {
        if (mLayout.getChildCount() >= 2)
        {
            View view = mLayout.getChildAt(mLayout.getChildCount() - 1);
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView itemView.lastItemView.right :").append(view.getRight()).toString());
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView getScreenWidth :").append(getWidth()).toString());
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView getItemWidth :").append(view.getWidth()).toString());
            int i = getScrollX();
            Log.v("PhotoSelectScrollView", (new StringBuilder()).append("PhotoSelectScrollView scrollx :").append(i).toString());
            if (view.getRight() > getWidth() && i < getWidth())
            {
                smoothScrollTo(getWidth(), 0);
            }
        }
    }

    public void setCallback(bjp bjp)
    {
        mCallback = bjp;
    }


}
