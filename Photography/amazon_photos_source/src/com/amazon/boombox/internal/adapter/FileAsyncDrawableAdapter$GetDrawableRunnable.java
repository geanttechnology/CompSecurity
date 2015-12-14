// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.amazon.boombox.util.DecodeUtil;
import java.io.File;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            FileAsyncDrawableAdapter

private class mListener
    implements Runnable
{

    private BitmapDrawable mBitmapDrawable;
    private File mFile;
    private mBitmapDrawable mListener;
    private int mPosition;
    private int mRequestedHeight;
    private int mRequestedWidth;
    final FileAsyncDrawableAdapter this$0;

    public void run()
    {
        Object obj = new android.graphics.etDrawableRunnable();
        obj.etDrawableRunnable = true;
        BitmapFactory.decodeFile(mFile.getAbsolutePath(), ((android.graphics.etDrawableRunnable.mFile) (obj)));
        android.graphics.etDrawableRunnable etdrawablerunnable = new android.graphics.etDrawableRunnable.mFile();
        etdrawablerunnable.mFile = DecodeUtil.calculateInSampleSize(((android.graphics.etDrawableRunnable.mFile) (obj)).mFile, ((android.graphics.etDrawableRunnable.mFile) (obj)).mFile, mRequestedWidth, mRequestedHeight);
        obj = BitmapFactory.decodeFile(mFile.getAbsolutePath(), etdrawablerunnable);
        mBitmapDrawable = new BitmapDrawable(FileAsyncDrawableAdapter.access$000(FileAsyncDrawableAdapter.this).getResources(), ((android.graphics.Bitmap) (obj)));
        FileAsyncDrawableAdapter.access$400(FileAsyncDrawableAdapter.this).post(new Runnable() {

            final FileAsyncDrawableAdapter.GetDrawableRunnable this$1;

            public void run()
            {
                mListener.onDrawableReady(mPosition, mBitmapDrawable);
            }

            
            {
                this$1 = FileAsyncDrawableAdapter.GetDrawableRunnable.this;
                super();
            }
        });
    }




    public _cls1.this._cls1(File file, int i, int j, int k, _cls1.this._cls1 _pcls1)
    {
        this$0 = FileAsyncDrawableAdapter.this;
        super();
        mFile = file;
        mPosition = i;
        mRequestedWidth = j;
        mRequestedHeight = k;
        mListener = _pcls1;
    }
}
