// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.util.VineProgressEvent;
import co.vine.android.util.VineProgressListener;

public abstract class UploadProgressListener
    implements VineProgressListener
{

    public long currentSize;
    public int lastProgress;
    public String path;
    public long size;
    public String thumbnail;

    public UploadProgressListener(String s)
    {
        String s1 = RecordConfigUtils.getThumbnailPath(s);
        path = s;
        thumbnail = s1;
    }

    public abstract void onPostFinished(boolean flag);

    public abstract void onTranscodeStarted();

    public abstract void progressChanged(VineProgressEvent vineprogressevent);

    public void showPostNotification(String s)
    {
    }

    public abstract void updateTranscodeProgress(int i);
}
