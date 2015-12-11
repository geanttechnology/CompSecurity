// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.ProgressDialog;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder

public class nit> extends nit>
{

    final RegularVineRecorder this$0;

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.PostExecute(void1);
        RegularVineRecorder.access$002(RegularVineRecorder.this, false);
        void1 = mFinishProgressDialog;
        if (void1 != null && void1.isShowing())
        {
            void1.dismiss();
        }
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        ProgressDialog progressdialog = mFinishProgressDialog;
        if (progressdialog != null && progressdialog.isShowing())
        {
            if (mFinishProgressDialogMessage != null && mFinishProgressDialogMessage.length > 2 && ainteger[0].intValue() >= (100 / (mFinishProgressDialogMessage.length - 1)) * mCurrentMessage)
            {
                if (mCurrentMessage + 1 < mFinishProgressDialogMessage.length)
                {
                    progressdialog.setMessage(mFinishProgressDialogMessage[mCurrentMessage + 1]);
                }
                mCurrentMessage = mCurrentMessage + 1;
            }
            progressdialog.setProgress(ainteger[0].intValue());
        }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

    public (String s, Runnable runnable, boolean flag, boolean flag1)
    {
        this$0 = RegularVineRecorder.this;
        super(RegularVineRecorder.this, s, runnable, flag, flag1);
    }
}
