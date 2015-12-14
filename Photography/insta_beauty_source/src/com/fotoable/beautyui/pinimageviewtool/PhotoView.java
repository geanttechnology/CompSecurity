// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.pinimageviewtool;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import xu;
import xz;
import ya;
import yc;

public class PhotoView extends ImageView
{

    private final xu mAttacher;
    private android.widget.ImageView.ScaleType mPendingScaleType;

    public PhotoView(Context context)
    {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PhotoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        super.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        mAttacher = new xu(this);
        if (mPendingScaleType != null)
        {
            setScaleType(mPendingScaleType);
            mPendingScaleType = null;
        }
    }

    public boolean canZoom()
    {
        return mAttacher.a();
    }

    public RectF getDisplayRect()
    {
        return mAttacher.c();
    }

    public float getMaxScale()
    {
        return mAttacher.g();
    }

    public float getMidScale()
    {
        return mAttacher.f();
    }

    public float getMinScale()
    {
        return mAttacher.e();
    }

    public float getScale()
    {
        return mAttacher.h();
    }

    public android.widget.ImageView.ScaleType getScaleType()
    {
        return mAttacher.i();
    }

    protected void onDetachedFromWindow()
    {
        mAttacher.b();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean flag)
    {
        mAttacher.a(flag);
    }

    public void setImageDrawable(Drawable drawable)
    {
        super.setImageDrawable(drawable);
        if (mAttacher != null)
        {
            mAttacher.j();
        }
    }

    public void setImageResource(int i)
    {
        super.setImageResource(i);
        if (mAttacher != null)
        {
            mAttacher.j();
        }
    }

    public void setImageURI(Uri uri)
    {
        super.setImageURI(uri);
        if (mAttacher != null)
        {
            mAttacher.j();
        }
    }

    public void setMaxScale(float f)
    {
        mAttacher.c(f);
    }

    public void setMidScale(float f)
    {
        mAttacher.b(f);
    }

    public void setMinScale(float f)
    {
        mAttacher.a(f);
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mAttacher.a(onlongclicklistener);
    }

    public void setOnMatrixChangeListener(xz xz)
    {
        mAttacher.a(xz);
    }

    public void setOnPhotoTapListener(ya ya)
    {
        mAttacher.a(ya);
    }

    public void setOnViewTapListener(yc yc)
    {
        mAttacher.a(yc);
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (mAttacher != null)
        {
            mAttacher.a(scaletype);
            return;
        } else
        {
            mPendingScaleType = scaletype;
            return;
        }
    }

    public void setZoomable(boolean flag)
    {
        mAttacher.b(flag);
    }

    public void zoomTo(float f, float f1, float f2)
    {
        mAttacher.b(f, f1, f2);
    }
}
