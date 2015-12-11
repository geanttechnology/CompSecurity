// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.h.c.ad;
import com.h.c.e;
import java.lang.ref.WeakReference;

public class BitmapImageView extends ImageView
    implements ad
{

    private static final int BITMAP_LAYER = 1;
    private static final int PLACEHOLDER_LAYER = 0;
    private static final String TAG = com/target/ui/view/BitmapImageView.getSimpleName();
    private static final int TRANSITION_DURATION = 200;
    private e mCallback;
    private WeakReference mPlaceholderDrawableRef;

    public BitmapImageView(Context context)
    {
        super(context);
    }

    public BitmapImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BitmapImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void a(Bitmap bitmap, com.h.c.u.d d)
    {
        if (mCallback != null)
        {
            mCallback.a();
        }
        BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), bitmap);
        if (com.h.c.u.d.a.equals(d))
        {
            setImageDrawable(bitmapdrawable);
        } else
        {
            if (mPlaceholderDrawableRef != null && mPlaceholderDrawableRef.get() != null)
            {
                bitmap = (Drawable)mPlaceholderDrawableRef.get();
            } else
            {
                bitmap = new ColorDrawable(0);
            }
            bitmap = new TransitionDrawable(new Drawable[] {
                bitmap, bitmapdrawable
            });
            setImageDrawable(bitmap);
            bitmap.startTransition(200);
        }
        mPlaceholderDrawableRef = null;
    }

    public void a(Drawable drawable)
    {
        if (mCallback != null)
        {
            mCallback.b();
        }
        setImageDrawable(drawable);
    }

    public void b(Drawable drawable)
    {
        if (drawable != null)
        {
            mPlaceholderDrawableRef = new WeakReference(drawable);
        } else
        {
            mPlaceholderDrawableRef = null;
        }
        setImageDrawable(drawable);
    }

    public com.google.a.a.e getBitmap()
    {
        if (getDrawable() == null)
        {
            return com.google.a.a.e.e();
        }
        if (!(getDrawable() instanceof BitmapDrawable)) goto _L2; else goto _L1
_L1:
        Object obj = (BitmapDrawable)getDrawable();
_L4:
        if (obj == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.c(((BitmapDrawable) (obj)).getBitmap());
        }
_L2:
        if (getDrawable() instanceof TransitionDrawable)
        {
            obj = (TransitionDrawable)getDrawable();
            if (((TransitionDrawable) (obj)).getDrawable(1) instanceof BitmapDrawable)
            {
                obj = (BitmapDrawable)((TransitionDrawable) (obj)).getDrawable(1);
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setCallback(e e1)
    {
        mCallback = e1;
    }

}
