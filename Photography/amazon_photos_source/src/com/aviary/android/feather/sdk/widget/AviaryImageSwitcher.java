// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ViewSwitcher;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

public class AviaryImageSwitcher extends ViewSwitcher
{

    protected boolean mSwitchEnabled;

    public AviaryImageSwitcher(Context context)
    {
        super(context);
        mSwitchEnabled = true;
    }

    public AviaryImageSwitcher(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSwitchEnabled = true;
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix)
    {
        ImageViewTouch imageviewtouch;
        if (mSwitchEnabled)
        {
            imageviewtouch = (ImageViewTouch)getNextView();
        } else
        {
            imageviewtouch = (ImageViewTouch)getChildAt(0);
        }
        imageviewtouch.setImageBitmap(bitmap, matrix, -1F, -1F);
        if (mSwitchEnabled)
        {
            showNext();
            return;
        } else
        {
            setDisplayedChild(0);
            return;
        }
    }

    public void setImageDrawable(Drawable drawable, Matrix matrix)
    {
        ImageViewTouch imageviewtouch;
        if (mSwitchEnabled)
        {
            imageviewtouch = (ImageViewTouch)getNextView();
        } else
        {
            imageviewtouch = (ImageViewTouch)getChildAt(0);
        }
        imageviewtouch.setImageDrawable(drawable, matrix, -1F, -1F);
        if (mSwitchEnabled)
        {
            showNext();
            return;
        } else
        {
            setDisplayedChild(0);
            return;
        }
    }

    public void setSwitchEnabled(boolean flag)
    {
        mSwitchEnabled = flag;
    }
}
