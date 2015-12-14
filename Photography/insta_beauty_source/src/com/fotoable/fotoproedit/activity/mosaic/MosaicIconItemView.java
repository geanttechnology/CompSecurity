// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.mosaic;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MosaicIconItemView extends FrameLayout
{

    private ImageView imagev;

    public MosaicIconItemView(Context context)
    {
        super(context);
        init();
    }

    public MosaicIconItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030114, this, true);
        imagev = (ImageView)findViewById(0x7f0d020e);
    }

    public void setImage(Bitmap bitmap)
    {
        imagev.setImageBitmap(bitmap);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        imagev.setSelected(flag);
    }
}
