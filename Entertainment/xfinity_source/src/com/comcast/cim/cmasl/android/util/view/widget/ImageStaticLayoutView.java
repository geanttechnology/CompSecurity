// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageStaticLayoutView extends ImageView
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/view/widget/ImageStaticLayoutView);
    private boolean makeRequest;

    public ImageStaticLayoutView(Context context)
    {
        super(context);
        makeRequest = true;
    }

    public ImageStaticLayoutView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageStaticLayoutView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        makeRequest = true;
    }

    public void requestLayout()
    {
        if (makeRequest)
        {
            super.requestLayout();
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        makeRequest = false;
        super.setImageBitmap(bitmap);
        makeRequest = true;
    }

    public void setImageDrawable(Drawable drawable)
    {
        makeRequest = false;
        super.setImageDrawable(drawable);
        makeRequest = true;
    }

}
