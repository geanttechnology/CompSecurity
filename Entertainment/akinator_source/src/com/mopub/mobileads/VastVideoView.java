// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Streams;
import java.io.File;
import java.io.FileInputStream;

// Referenced classes of package com.mopub.mobileads:
//            VastVideoBlurLastVideoFrameTask

public class VastVideoView extends VideoView
{

    private static final int MAX_VIDEO_RETRIES = 1;
    private static final int VIDEO_VIEW_FILE_PERMISSION_ERROR = 0x80000000;
    private VastVideoBlurLastVideoFrameTask mBlurLastVideoFrameTask;
    private MediaMetadataRetriever mMediaMetadataRetriever;
    private int mVideoRetries;

    public VastVideoView(Context context)
    {
        super(context);
        Preconditions.checkNotNull(context, "context cannot be null");
        mMediaMetadataRetriever = createMediaMetadataRetriever();
    }

    MediaMetadataRetriever createMediaMetadataRetriever()
    {
        if (android.os.Build.VERSION.SDK_INT >= 10)
        {
            return new MediaMetadataRetriever();
        } else
        {
            return null;
        }
    }

    VastVideoBlurLastVideoFrameTask getBlurLastVideoFrameTask()
    {
        return mBlurLastVideoFrameTask;
    }

    int getVideoRetries()
    {
        return mVideoRetries;
    }

    public void onDestroy()
    {
        if (mBlurLastVideoFrameTask != null && mBlurLastVideoFrameTask.getStatus() != android.os.AsyncTask.Status.FINISHED)
        {
            mBlurLastVideoFrameTask.cancel(true);
        }
    }

    public void onResume()
    {
        mVideoRetries = 0;
    }

    public void prepareBlurredLastVideoFrame(ImageView imageview, String s)
    {
        if (mMediaMetadataRetriever == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        mBlurLastVideoFrameTask = new VastVideoBlurLastVideoFrameTask(mMediaMetadataRetriever, imageview, getDuration());
        AsyncTasks.safeExecuteOnExecutor(mBlurLastVideoFrameTask, new String[] {
            s
        });
        return;
        imageview;
        MoPubLog.d("Failed to blur last video frame", imageview);
        return;
    }

    boolean retryMediaPlayer(MediaPlayer mediaplayer, int i, int j, String s)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 || i != 1 || j != 0x80000000 || mVideoRetries >= 1) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        mediaplayer.reset();
        s = new FileInputStream(new File(s));
        mediaplayer.setDataSource(s.getFD());
        mediaplayer.prepareAsync();
        start();
        Streams.closeStream(s);
        mVideoRetries = mVideoRetries + 1;
        return true;
        mediaplayer;
        mediaplayer = obj1;
_L6:
        Streams.closeStream(mediaplayer);
        mVideoRetries = mVideoRetries + 1;
        return false;
        s;
        mediaplayer = obj;
_L4:
        Streams.closeStream(mediaplayer);
        mVideoRetries = mVideoRetries + 1;
        throw s;
_L2:
        return false;
        Exception exception;
        exception;
        mediaplayer = s;
        s = exception;
        if (true) goto _L4; else goto _L3
_L3:
        mediaplayer;
        mediaplayer = s;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void setBlurLastVideoFrameTask(VastVideoBlurLastVideoFrameTask vastvideoblurlastvideoframetask)
    {
        mBlurLastVideoFrameTask = vastvideoblurlastvideoframetask;
    }

    void setMediaMetadataRetriever(MediaMetadataRetriever mediametadataretriever)
    {
        mMediaMetadataRetriever = mediametadataretriever;
    }
}
