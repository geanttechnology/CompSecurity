// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector;

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
import arm;
import arn;
import asx;

public class PhotoSelectScrollView extends HorizontalScrollView
{

    private static final String TAG = "PhotoSelectScrollView";
    private arn mCallback;
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
        try
        {
            view = LayoutInflater.from(getContext()).inflate(aei.selector_item_view, null);
            imagebutton = (ImageButton)view.findViewById(aeh.item_icon);
            ImageButton imagebutton1 = (ImageButton)view.findViewById(aeh.delete_icon);
            view.setTag(new Integer(mLayout.getChildCount()));
            imagebutton1.setOnClickListener(new arm(this, view));
            asx1 = asx1.c(getContext());
        }
        // Misplaced declaration of an exception variable
        catch (asx asx1)
        {
            Log.e("PhotoSelectScrollView", asx1.getMessage());
            return;
        }
        if (asx1 == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        imagebutton.setImageBitmap(asx1);
_L2:
        mLayout.addView(view);
        return;
        Log.v("hedong_icon", "no bimap");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setCallback(arn arn)
    {
        mCallback = arn;
    }


}
