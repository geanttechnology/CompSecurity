// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photoselector.uicomp;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RecycleableImageView extends ImageView
{

    private Bitmap bm;

    public RecycleableImageView(Context context)
    {
        super(context);
    }

    public RecycleableImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RecycleableImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public Bitmap getImageBitmap()
    {
        return bm;
    }

    public void recycleImage()
    {
        setImageBitmap(null);
        if (bm != null && !bm.isRecycled())
        {
            bm.recycle();
            bm = null;
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
    }
}
