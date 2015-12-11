// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.Process;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.util.LinkedList;

// Referenced classes of package co.vine.android.recorder:
//            SwEncodingRunnable, VideoData, ByteBufferQueue, RecordController, 
//            BaseFinishProcessTask

static class mBufferedVideoData
    implements Runnable
{

    private final int LOCK[] = new int[0];
    private LinkedList mBufferedVideoData;
    private SwEncodingRunnable mParent;
    public boolean mRun;
    private int totalSizeToWait;

    public byte[] add(VideoData videodata)
    {
        int ai[] = LOCK;
        ai;
        JVM INSTR monitorenter ;
        SwEncodingRunnable swencodingrunnable;
        byte abyte0[];
        swencodingrunnable = mParent;
        abyte0 = videodata.data;
        if (abyte0 == null || swencodingrunnable == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (!SwEncodingRunnable.access$100(swencodingrunnable).put(new mParent(abyte0, videodata)))
        {
            CrashUtil.log("Not enough memory left. (BufferOverflow)");
        }
        videodata = videodata.data;
        ai;
        JVM INSTR monitorexit ;
        return videodata;
        videodata;
        ai;
        JVM INSTR monitorexit ;
        throw videodata;
    }

    public void run()
    {
        Process.setThreadPriority(19);
        while (mRun) 
        {
            mParent mparent = SwEncodingRunnable.access$100(mParent).get();
            if (!SwEncodingRunnable.access$200(mParent).isRecordingStarted() && SwEncodingRunnable.access$300(mParent) != null)
            {
                int i = Math.max(SwEncodingRunnable.access$100(mParent).size(), 1);
                if (totalSizeToWait == -1)
                {
                    totalSizeToWait = i;
                    Process.setThreadPriority(-8);
                    SLog.i("Size to wait: {}.", Integer.valueOf(totalSizeToWait));
                }
                SwEncodingRunnable.access$300(mParent).publish(((totalSizeToWait - i) * 90) / totalSizeToWait);
            }
            if (mparent != null)
            {
                VideoData videodata = (VideoData)mparent.totalSizeToWait;
                videodata.data = mparent.totalSizeToWait;
                try
                {
                    mParent.processVideoData(mBufferedVideoData, videodata);
                }
                catch (Exception exception)
                {
                    throw new RuntimeException(exception);
                }
            } else
            if (SwEncodingRunnable.access$100(mParent).isEndOfPut())
            {
                mRun = false;
            } else
            {
                try
                {
                    Thread.sleep(50L);
                }
                catch (InterruptedException interruptedexception)
                {
                    SLog.e("Interrupted.");
                }
            }
        }
        SwEncodingRunnable.access$400(mParent, mBufferedVideoData);
        mParent = null;
    }

    public I(SwEncodingRunnable swencodingrunnable)
    {
        totalSizeToWait = -1;
        mParent = swencodingrunnable;
        SwEncodingRunnable.access$000(mParent);
        mBufferedVideoData = new LinkedList();
    }
}
