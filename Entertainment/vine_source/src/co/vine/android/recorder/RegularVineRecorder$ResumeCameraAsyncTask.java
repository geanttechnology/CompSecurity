// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.ProgressDialog;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder

protected class nit> extends nit>
{

    final RegularVineRecorder this$0;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.PostExecute(void1);
        if (mOpenCameraDialog != null)
        {
            mOpenCameraDialog.dismiss();
        }
    }

    protected void onPreExecute()
    {
        super.PreExecute();
        if (mOpenCameraDialog != null)
        {
            mOpenCameraDialog.show();
        }
    }

    public (boolean flag)
    {
        this$0 = RegularVineRecorder.this;
        super(RegularVineRecorder.this, flag);
    }
}
