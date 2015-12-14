// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.activity;

import aeh;
import aei;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import arv;
import arw;
import arx;
import arz;
import asx;
import java.lang.ref.WeakReference;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private arz mCallback;
    private WeakReference mContext;
    private LinearLayout mLayout;

    public PhotoSelectScrollView(Context context)
    {
        super(context);
        mContext = new WeakReference(context);
        init();
    }

    public PhotoSelectScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = new WeakReference(context);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(asx asx)
    {
        Log.v("PhotoSelectScrollView", "addItem");
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(aei.selector_item_view, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(aeh.item_icon);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(aeh.delete_icon);
            view.setTag(new Integer(mLayout.getChildCount()));
            imagebutton.setOnClickListener(new arv(this, view));
            imagebutton1.setOnClickListener(new arw(this, view));
            (new Thread(new arx(this, asx, imagebutton, view))).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (asx asx)
        {
            Log.e("PhotoSelectScrollView", (new StringBuilder()).append(asx.getMessage()).append("Exception").toString());
        }
    }

    public void setCallback(arz arz)
    {
        mCallback = arz;
    }


}
