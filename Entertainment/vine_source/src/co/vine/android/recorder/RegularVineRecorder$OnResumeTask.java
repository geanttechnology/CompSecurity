// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.ProgressDialog;
import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder, RecordingFile

protected class nit> extends nit>
{

    final RegularVineRecorder this$0;

    protected void onPostExecute(RecordingFile recordingfile)
    {
        super.PostExecute(recordingfile);
        if (mStartProgressDialog != null && !isCancelled())
        {
            mStartProgressDialog.dismiss();
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RecordingFile)obj);
    }

    protected transient void onProgressUpdate(CharSequence acharsequence[])
    {
        if (mStartProgressDialog != null)
        {
            if (!showDialogDelayed && !mStartProgressDialog.isShowing())
            {
                mStartProgressDialog.show();
            }
            mStartProgressDialog.setMessage(acharsequence[0]);
        }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((CharSequence[])aobj);
    }

    protected void publishFinishLastSegmentProgress()
    {
        publishProgress(new CharSequence[] {
            mFinishLastSegmentString
        });
    }

    protected void publishStartProgres()
    {
        publishProgress(new CharSequence[] {
            mStartProgressDialogMessage
        });
    }

    public (View view, String s)
    {
        this$0 = RegularVineRecorder.this;
        super(RegularVineRecorder.this, view, s);
    }
}
