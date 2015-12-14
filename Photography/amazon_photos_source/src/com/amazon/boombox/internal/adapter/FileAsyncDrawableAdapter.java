// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.amazon.boombox.util.DecodeUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.boombox.internal.adapter:
//            AsyncDrawableAdapter

public class FileAsyncDrawableAdapter
    implements AsyncDrawableAdapter
{
    private class GetDrawableRunnable
        implements Runnable
    {

        private BitmapDrawable mBitmapDrawable;
        private File mFile;
        private AsyncDrawableAdapter.Listener mListener;
        private int mPosition;
        private int mRequestedHeight;
        private int mRequestedWidth;
        final FileAsyncDrawableAdapter this$0;

        public void run()
        {
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(mFile.getAbsolutePath(), ((android.graphics.BitmapFactory.Options) (obj)));
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = DecodeUtil.calculateInSampleSize(((android.graphics.BitmapFactory.Options) (obj)).outWidth, ((android.graphics.BitmapFactory.Options) (obj)).outHeight, mRequestedWidth, mRequestedHeight);
            obj = BitmapFactory.decodeFile(mFile.getAbsolutePath(), options);
            mBitmapDrawable = new BitmapDrawable(mContext.getResources(), ((android.graphics.Bitmap) (obj)));
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
        }




        public GetDrawableRunnable(File file, int i, int j, int k, AsyncDrawableAdapter.Listener listener)
        {
            this$0 = FileAsyncDrawableAdapter.this;
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
    private File mFiles[];
    private Handler mHandler;

    public FileAsyncDrawableAdapter(Context context, File afile[])
    {
        mExecutor = Executors.newSingleThreadExecutor();
        mContext = context;
        mFiles = afile;
        mHandler = new Handler();
    }

    public void dispose(Drawable drawable)
    {
    }

    public void getCount(AsyncDrawableAdapter.Listener listener)
    {
        listener.onCountReady(mFiles.length);
    }

    public void getDrawable(int i, int j, int k, AsyncDrawableAdapter.Listener listener)
    {
        listener = new GetDrawableRunnable(mFiles[i], i, j, k, listener);
        mExecutor.execute(listener);
    }


}
