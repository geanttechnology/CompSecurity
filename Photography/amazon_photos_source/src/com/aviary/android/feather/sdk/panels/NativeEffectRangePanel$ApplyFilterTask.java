// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.IFilter;
import com.aviary.android.feather.headless.filters.INativeRangeFilter;
import com.aviary.android.feather.headless.moa.MoaFloatParameter;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.drawable.FakeBitmapDrawable;
import com.aviary.android.feather.library.vo.ToolActionVO;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            NativeEffectRangePanel

class filter extends AviaryAsyncTask
{

    IFilter filter;
    boolean isPreview;
    Bitmap mCurrentBitmap;
    MoaResult mResult;
    boolean mShowProgress;
    final NativeEffectRangePanel this$0;

    protected transient Bitmap doInBackground(Bitmap abitmap[])
    {
        if (isCancelled() || filter == null)
        {
            return null;
        }
        if (!isPreview || NativeEffectRangePanel.access$000(NativeEffectRangePanel.this) == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        mCurrentBitmap = Bitmap.createBitmap(NativeEffectRangePanel.access$000(NativeEffectRangePanel.this).getWidth(), NativeEffectRangePanel.access$000(NativeEffectRangePanel.this).getHeight(), NativeEffectRangePanel.access$000(NativeEffectRangePanel.this).getConfig());
        mResult = ((INativeRangeFilter)filter).prepare(NativeEffectRangePanel.access$000(NativeEffectRangePanel.this), mCurrentBitmap, 1, 1);
_L1:
        mResult.execute();
        if (!isCancelled())
        {
            break MISSING_BLOCK_LABEL_171;
        }
        mLogger.isCancelled("isCancelled... return null");
        return null;
        try
        {
            mResult = ((INativeRangeFilter)filter).prepare(mBitmap, mPreview, 1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap abitmap[])
        {
            abitmap.printStackTrace();
            return null;
        }
          goto _L1
        NativeEffectRangePanel.access$100(NativeEffectRangePanel.this).setValue(((INativeRangeFilter)filter).getValue().getValue());
        NativeEffectRangePanel.access$202(NativeEffectRangePanel.this, ((INativeRangeFilter)filter).getActions());
        if (isCancelled())
        {
            return null;
        } else
        {
            return mResult.outputBitmap;
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Bitmap[])aobj);
    }

    protected void doPostExecute(Bitmap bitmap)
    {
        mLogger.doInBackground("onPostExecute, isPreview: %b, result: %s", new Object[] {
            Boolean.valueOf(isPreview), bitmap
        });
        if (!isActive())
        {
            return;
        }
        if (mShowProgress)
        {
            onProgressEnd();
        }
        if (bitmap != null && !isCancelled())
        {
            mLogger.isCancelled("result size: %dx%d", new Object[] {
                Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
            });
            NativeEffectRangePanel.access$300(NativeEffectRangePanel.this).updateBitmap(bitmap, mBitmap.getWidth(), mBitmap.getHeight());
            onPreviewUpdated();
            if (!isPreview)
            {
                setIsChanged(true);
            }
        } else
        {
            mLogger.isPreview("result == null || isCancelled");
        }
        if (!isPreview)
        {
            mIsRendering = false;
        }
        NativeEffectRangePanel.access$402(NativeEffectRangePanel.this, null);
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Bitmap)obj);
    }

    protected void doPreExecute()
    {
        if (filter != null && mShowProgress)
        {
            onProgressStart();
        }
    }

    protected void onCancelled()
    {
        super.onCancelled();
        if (mResult != null)
        {
            mResult.cancel();
        }
        if (mCurrentBitmap != null && !mCurrentBitmap.isRecycled())
        {
            mCurrentBitmap.recycle();
        }
    }

    public (float f, boolean flag, boolean flag1)
    {
        this$0 = NativeEffectRangePanel.this;
        super();
        isPreview = flag1;
        mShowProgress = flag;
        if (mFilter != null)
        {
            filter = ToolLoaderFactory.get(getName());
            ((INativeRangeFilter)filter).setValue(Float.valueOf(f));
        }
    }
}
