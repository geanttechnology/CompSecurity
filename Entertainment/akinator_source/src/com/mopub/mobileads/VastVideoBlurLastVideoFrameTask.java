// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ImageUtils;

public class VastVideoBlurLastVideoFrameTask extends AsyncTask
{

    private Bitmap mBlurredLastVideoFrame;
    private final ImageView mBlurredLastVideoFrameImageView;
    private Bitmap mLastVideoFrame;
    private final MediaMetadataRetriever mMediaMetadataRetriever;
    private int mVideoDuration;

    public VastVideoBlurLastVideoFrameTask(MediaMetadataRetriever mediametadataretriever, ImageView imageview, int i)
    {
        mMediaMetadataRetriever = mediametadataretriever;
        mBlurredLastVideoFrameImageView = imageview;
        mVideoDuration = i;
    }

    protected transient Boolean doInBackground(String as[])
    {
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            if (as == null || as.length == 0 || as[0] == null)
            {
                return Boolean.valueOf(false);
            }
            as = as[0];
            try
            {
                mMediaMetadataRetriever.setDataSource(as);
                mLastVideoFrame = mMediaMetadataRetriever.getFrameAtTime(mVideoDuration * 1000, 3);
                if (mLastVideoFrame == null)
                {
                    return Boolean.valueOf(false);
                }
                mBlurredLastVideoFrame = ImageUtils.applyFastGaussianBlurToBitmap(mLastVideoFrame, 4);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                MoPubLog.d("Failed to blur last video frame", as);
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    Bitmap getBlurredLastVideoFrame()
    {
        return mBlurredLastVideoFrame;
    }

    protected void onCancelled()
    {
        MoPubLog.d("VastVideoBlurLastVideoFrameTask was cancelled.");
    }

    protected void onPostExecute(Boolean boolean1)
    {
        if (isCancelled())
        {
            onCancelled();
        } else
        if (boolean1 != null && boolean1.booleanValue())
        {
            mBlurredLastVideoFrameImageView.setImageBitmap(mBlurredLastVideoFrame);
            ImageUtils.setImageViewAlpha(mBlurredLastVideoFrameImageView, 128);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }
}
