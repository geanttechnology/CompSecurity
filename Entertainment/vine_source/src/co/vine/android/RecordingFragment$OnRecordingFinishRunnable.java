// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.recorder.RecordingFile;
import co.vine.android.recorder.VineRecorder;
import java.lang.ref.WeakReference;

// Referenced classes of package co.vine.android:
//            RecordingFragment

public static class mFragment
    implements Runnable
{

    private WeakReference mFragment;

    public void run()
    {
        RecordingFragment recordingfragment = (RecordingFragment)mFragment.get();
        if (recordingfragment != null)
        {
            RecordingFile recordingfile = RecordingFragment.access$800(recordingfragment).finalFile;
            if (recordingfile != null && recordingfile.isValid())
            {
                co.vine.android.util.ment ment = RecordingFragment.access$800(recordingfragment).grabThumbnailsRunnable;
                RecordingFragment.access$800(recordingfragment).grabThumbnailsRunnable = null;
                RecordingFragment.access$1800(recordingfragment, "OnRecordingFinishRunnable", RecordingFragment.access$800(recordingfragment).detectedInvalidSession, ment);
            }
        }
    }

    public A(WeakReference weakreference)
    {
        mFragment = weakreference;
    }
}
