// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.instabeauty.application.InstaBeautyApplication;

public class SketchItemView extends LinearLayout
{

    ImageView icon;
    View im_container;
    Boolean selected;

    public SketchItemView(Context context)
    {
        super(context);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030125, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        im_container = findViewById(0x7f0d015c);
        selected = Boolean.valueOf(false);
    }

    public SketchItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030125, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        im_container = findViewById(0x7f0d015c);
        selected = Boolean.valueOf(false);
    }

    public static int getLayoutWidth()
    {
        return (int)(InstaBeautyApplication.a.getResources().getDisplayMetrics().density * 50F);
    }

    public void setIconRes(Bitmap bitmap)
    {
        icon.setImageBitmap(bitmap);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        selected = Boolean.valueOf(flag);
        if (flag)
        {
            im_container.setBackgroundColor(0xff007aff);
            return;
        } else
        {
            im_container.setBackgroundColor(0xff303030);
            return;
        }
    }
}
