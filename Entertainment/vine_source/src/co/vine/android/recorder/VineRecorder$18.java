// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordingFile

class der extends der.OnResumeTask
{

    final VineRecorder this$0;

    protected void onPostExecute(RecordingFile recordingfile)
    {
        super.onPostExecute(recordingfile);
        VineRecorder.access$000(VineRecorder.this);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RecordingFile)obj);
    }

    der(View view, String s)
    {
        this$0 = VineRecorder.this;
        super(VineRecorder.this, view, s);
    }
}
