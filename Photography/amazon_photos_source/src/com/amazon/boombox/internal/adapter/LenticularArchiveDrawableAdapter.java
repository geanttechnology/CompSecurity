// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.amazon.boombox.file.LenticularArchive;
import com.amazon.boombox.internal.util.IoUtil;
import com.amazon.boombox.util.DecodeUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            AsyncDrawableAdapter

public class LenticularArchiveDrawableAdapter
    implements AsyncDrawableAdapter
{
    private class GetCountRunnable
        implements Runnable
    {

        private int mCount;
        private File mFile;
        private AsyncDrawableAdapter.Listener mListener;
        final LenticularArchiveDrawableAdapter this$0;

        public void run()
        {
            Object obj1;
            Object obj3;
            obj3 = null;
            obj1 = null;
            Object obj = new LenticularArchive(mFile);
            mCount = ((LenticularArchive) (obj)).getFrameCount();
            mHandler.post(new Runnable() {

                final GetCountRunnable this$1;

                public void run()
                {
                    mListener.onCountReady(mCount);
                }

            
            {
                this$1 = GetCountRunnable.this;
                super();
            }
            });
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            return;
            obj;
            obj = obj1;
_L4:
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            return;
            Object obj2;
            obj2;
            obj = obj3;
_L2:
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            throw obj2;
            obj2;
            if (true) goto _L2; else goto _L1
_L1:
            obj2;
            if (true) goto _L4; else goto _L3
_L3:
        }



        public GetCountRunnable(File file, AsyncDrawableAdapter.Listener listener)
        {
            this$0 = LenticularArchiveDrawableAdapter.this;
            super();
            mFile = file;
            mListener = listener;
        }
    }

    private class GetDrawableRunnable
        implements Runnable
    {

        private BitmapDrawable mBitmapDrawable;
        private File mFile;
        private AsyncDrawableAdapter.Listener mListener;
        private int mPosition;
        private int mRequestedHeight;
        private int mRequestedWidth;
        final LenticularArchiveDrawableAdapter this$0;

        public void run()
        {
            Object obj1;
            android.graphics.BitmapFactory.Options options;
            options = null;
            obj1 = null;
            Object obj = new LenticularArchive(mFile);
            obj1 = ((LenticularArchive) (obj)).getFrameBytes(mPosition);
            options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(((byte []) (obj1)), 0, obj1.length, options);
            android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
            options1.inSampleSize = DecodeUtil.calculateInSampleSize(options.outWidth, options.outHeight, mRequestedWidth, mRequestedHeight);
            obj1 = BitmapFactory.decodeByteArray(((byte []) (obj1)), 0, obj1.length, options1);
            mBitmapDrawable = new BitmapDrawable(mContext.getResources(), ((Bitmap) (obj1)));
            mHandler.post(new Runnable() {

                final GetDrawableRunnable this$1;

                public void run()
                {
                    mListener.onDrawableReady(mPosition, mBitmapDrawable);
                }

            
            {
                this$1 = GetDrawableRunnable.this;
                super();
            }
            });
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            return;
            obj;
            obj = obj1;
_L4:
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            return;
            Object obj2;
            obj2;
            obj = options;
_L2:
            IoUtil.closeSilently(((java.io.Closeable) (obj)));
            throw obj2;
            obj2;
            if (true) goto _L2; else goto _L1
_L1:
            obj2;
            if (true) goto _L4; else goto _L3
_L3:
        }




        public GetDrawableRunnable(File file, int i, int j, int k, AsyncDrawableAdapter.Listener listener)
        {
            this$0 = LenticularArchiveDrawableAdapter.this;
            super();
            mFile = file;
            mPosition = i;
            mRequestedWidth = j;
            mRequestedHeight = k;
            mListener = listener;
        }
    }


    private Context mContext;
    private ExecutorService mExecutor;
    private File mFile;
    private Handler mHandler;

    public LenticularArchiveDrawableAdapter(Context context, File file)
    {
        mExecutor = Executors.newSingleThreadExecutor();
        mContext = context;
        mFile = file;
        mHandler = new Handler();
    }

    public void dispose(Drawable drawable)
    {
        drawable = (BitmapDrawable)drawable;
        if (drawable != null)
        {
            drawable.getBitmap().recycle();
        }
    }

    public void getCount(AsyncDrawableAdapter.Listener listener)
    {
        listener = new GetCountRunnable(mFile, listener);
        mExecutor.execute(listener);
    }

    public void getDrawable(int i, int j, int k, AsyncDrawableAdapter.Listener listener)
    {
        listener = new GetDrawableRunnable(mFile, i, j, k, listener);
        mExecutor.execute(listener);
    }


}
