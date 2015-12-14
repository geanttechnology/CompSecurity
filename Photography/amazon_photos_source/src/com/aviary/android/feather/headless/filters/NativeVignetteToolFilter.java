// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.util.Log;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeFilter

public class NativeVignetteToolFilter extends NativeFilter
{

    private final Object lock = new Object();
    private Bitmap mBitmap;
    private final MoaAction mFirstAction;
    private int mScale;
    private long n_ptr;

    public NativeVignetteToolFilter()
    {
        super("vignette");
        n_ptr = 0L;
        mScale = 1;
        n_ptr = nativeCtor();
        mFirstAction = mActions.get(0);
    }

    private void clearBitmapAlreadyLocked()
    {
        nativeSetBitmap(n_ptr, null);
        if (mBitmap != null && !mBitmap.isRecycled())
        {
            mBitmap.recycle();
        }
        mBitmap = null;
    }

    public void clearBitmap()
    {
        synchronized (lock)
        {
            clearBitmapAlreadyLocked();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void createBitmap(int i, int j, int k)
    {
        synchronized (lock)
        {
            clearBitmapAlreadyLocked();
            mBitmap = Bitmap.createBitmap(i / k, j / k, android.graphics.Bitmap.Config.ARGB_8888);
            mScale = k;
            mFirstAction.setValue("bitmapscale", k);
            mFirstAction.setValue("previewsize", new MoaPointParameter(i, j));
            if (!nativeSetBitmap(n_ptr, mBitmap))
            {
                Log.e("NativeVignetteToolFilter", "nativeSetBitmap returned false!");
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void dispose()
    {
        synchronized (lock)
        {
            if (n_ptr != 0L)
            {
                clearBitmap();
                nativeDispose(n_ptr);
            }
            n_ptr = 0L;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap getBitmap()
    {
        Bitmap bitmap;
        synchronized (lock)
        {
            bitmap = mBitmap;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    native long nativeCtor();

    native void nativeDispose(long l);

    native boolean nativeRenderPreview(long l, float f, float f1, float f2, float f3, int i, 
            float f4);

    native boolean nativeSetBitmap(long l, Bitmap bitmap);

    public boolean renderPreview(RectF rectf, int i, float f)
    {
label0:
        {
            if (n_ptr == 0L)
            {
                break MISSING_BLOCK_LABEL_153;
            }
            boolean flag;
            synchronized (lock)
            {
                if (mBitmap == null || mBitmap.isRecycled())
                {
                    break label0;
                }
                mFirstAction.setValue("left", rectf.left);
                mFirstAction.setValue("top", rectf.top);
                mFirstAction.setValue("right", rectf.right);
                mFirstAction.setValue("bottom", rectf.bottom);
                mFirstAction.setValue("intensity", i);
                mFirstAction.setValue("feather", f);
                flag = nativeRenderPreview(n_ptr, rectf.left, rectf.top, rectf.right, rectf.bottom, i, f);
            }
            return flag;
        }
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_153;
        rectf;
        obj;
        JVM INSTR monitorexit ;
        throw rectf;
        return false;
    }

    public void setValues(RectF rectf, int i, float f)
    {
        mFirstAction.setValue("left", rectf.left);
        mFirstAction.setValue("top", rectf.top);
        mFirstAction.setValue("right", rectf.right);
        mFirstAction.setValue("bottom", rectf.bottom);
        mFirstAction.setValue("intensity", i);
        mFirstAction.setValue("feather", f);
    }
}
