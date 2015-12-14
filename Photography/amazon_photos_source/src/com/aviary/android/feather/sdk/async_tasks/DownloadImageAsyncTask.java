// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.async_tasks;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.library.utils.DecodeUtils;
import com.aviary.android.feather.library.utils.ImageInfo;

public class DownloadImageAsyncTask extends AviaryAsyncTask
{
    public static interface OnImageDownloadListener
    {

        public abstract void onDownloadComplete(Bitmap bitmap, ImageInfo imageinfo);

        public abstract void onDownloadError(String s);

        public abstract void onDownloadStart();
    }


    private static final String TAG = "DownloadImageAsyncTask";
    private String error;
    private ImageInfo mImageOutputInfo;
    private OnImageDownloadListener mListener;
    private int mMaxSize;
    private Uri mUri;

    public DownloadImageAsyncTask(Uri uri, int i)
    {
        mUri = uri;
        mMaxSize = i;
        mImageOutputInfo = new ImageInfo();
    }

    public static int getManagedMaxImageSize(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        int i = Math.max(((DisplayMetrics) (context)).widthPixels, ((DisplayMetrics) (context)).heightPixels);
        double d = com.aviary.android.feather.common.utils.SystemUtils.MemoryInfo.getRuntimeTotalMemory();
        if (d >= 48D)
        {
            return Math.min(i, 1280);
        }
        if (d >= 32D)
        {
            return Math.min(i, 900);
        } else
        {
            return Math.min(i, 700);
        }
    }

    protected transient Bitmap doInBackground(Context acontext[])
    {
        Log.i("DownloadImageAsyncTask", (new StringBuilder()).append("doInBackground: current thread #").append(Thread.currentThread().getId()).toString());
        acontext = acontext[0];
        int i = -1;
        if (mMaxSize > 0)
        {
            i = mMaxSize;
        }
        int j = i;
        if (i <= 0)
        {
            j = getManagedMaxImageSize(acontext);
        }
        try
        {
            acontext = DecodeUtils.decode(acontext, mUri, j, j, mImageOutputInfo);
        }
        // Misplaced declaration of an exception variable
        catch (Context acontext[])
        {
            Log.e("DownloadImageAsyncTask", "decode error", acontext);
            error = acontext.getMessage();
            return null;
        }
        return acontext;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Context[])aobj);
    }

    protected void doPostExecute(Bitmap bitmap)
    {
        Log.i("DownloadImageAsyncTask", (new StringBuilder()).append("doPostExecute: current thread #").append(Thread.currentThread().getId()).toString());
        if (mListener != null)
        {
            if (bitmap != null)
            {
                mListener.onDownloadComplete(bitmap, mImageOutputInfo);
            } else
            {
                mListener.onDownloadError(error);
            }
        }
        mListener = null;
        mUri = null;
        error = null;
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Bitmap)obj);
    }

    protected void doPreExecute()
    {
        Log.i("DownloadImageAsyncTask", (new StringBuilder()).append("doPreExecute: current thread #").append(Thread.currentThread().getId()).toString());
        if (mListener != null)
        {
            mListener.onDownloadStart();
        }
    }

    public void setOnLoadListener(OnImageDownloadListener onimagedownloadlistener)
    {
        mListener = onimagedownloadlistener;
    }
}
