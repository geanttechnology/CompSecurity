// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            HashAsyncTask, BasicVineRecorder, RecordingFile, RecordCompleteConsumer

public class ReusableHashAsyncTask extends HashAsyncTask
{

    private final boolean mCanKeepRecording;
    private RecordingFile mComputedFile;
    private boolean mIsCompleted;
    private final BasicVineRecorder mRecorder;
    private Exception mStartingException;

    public ReusableHashAsyncTask(BasicVineRecorder basicvinerecorder)
    {
        super(null);
        mIsCompleted = false;
        mStartingException = new Exception();
        mRecorder = basicvinerecorder;
        mCanKeepRecording = mRecorder.canKeepRecording();
    }

    protected transient RecordingFile doInBackground(RecordingFile arecordingfile[])
    {
        if (mCanKeepRecording)
        {
            return super.doInBackground(arecordingfile);
        } else
        {
            return super.doInBackground(new RecordingFile[] {
                mRecorder.getFile()
            });
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((RecordingFile[])aobj);
    }

    public RecordingFile getComputedFile()
    {
        return mComputedFile;
    }

    public boolean isComplete()
    {
        return mIsCompleted;
    }

    public void onComplete(RecordingFile recordingfile, RecordCompleteConsumer recordcompleteconsumer)
    {
        if (!mCanKeepRecording)
        {
            mRecorder.setFinalFile(recordingfile);
        }
        if (isCancelled())
        {
            mComputedFile = recordingfile;
            return;
        } else
        {
            run();
            return;
        }
    }

    public void onError(RecordingFile recordingfile, Exception exception, RecordCompleteConsumer recordcompleteconsumer)
    {
        if (isCancelled())
        {
            mIsCompleted = true;
            return;
        } else
        {
            SLog.d("Pre-post processing error.", exception);
            SLog.d("Pre-post was started here.", mStartingException);
            return;
        }
    }

    public void reset()
    {
        mIsCompleted = false;
    }

    public void resumeAll()
    {
        Runnable runnable = mRecorder.getOnCompleteConsumer();
        if (runnable != null && !mCanKeepRecording)
        {
            runnable.run();
            return;
        } else
        {
            run();
            return;
        }
    }

    public void run()
    {
        Runnable runnable = mRecorder.getOnCompleteConsumer();
        if (runnable != null && !mCanKeepRecording)
        {
            runnable.run();
            return;
        } else
        {
            mIsCompleted = true;
            return;
        }
    }
}
