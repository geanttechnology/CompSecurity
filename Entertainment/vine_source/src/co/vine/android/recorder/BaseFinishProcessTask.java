// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.AsyncTask;
import com.edisonwang.android.slog.SLog;

public abstract class BaseFinishProcessTask extends AsyncTask
{

    public boolean isRunning;
    protected int mCurrentMessage;
    protected long mWaitStartTime;
    public final Runnable onComplete;
    public final boolean releasePreview;
    public final boolean saveSession;
    protected final String tag;

    public BaseFinishProcessTask(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        tag = s;
        onComplete = runnable;
        releasePreview = flag;
        saveSession = flag1;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        SLog.d("Waited for {} ms", Long.valueOf(System.currentTimeMillis() - mWaitStartTime));
        if (onComplete != null)
        {
            onComplete.run();
        }
        isRunning = false;
    }

    protected void onPreExecute()
    {
        mCurrentMessage = 1;
        mWaitStartTime = System.currentTimeMillis();
        isRunning = true;
    }

    public void publish(int i)
    {
        publishProgress(new Integer[] {
            Integer.valueOf(i)
        });
    }
}
