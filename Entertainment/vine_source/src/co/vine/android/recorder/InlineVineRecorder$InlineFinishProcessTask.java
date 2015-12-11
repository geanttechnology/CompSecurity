// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            InlineVineRecorder, ProgressView

public class this._cls0 extends this._cls0
{

    final InlineVineRecorder this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        SLog.d("Finishing Inline");
        return super.kground(avoid);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.xecute(void1);
        SLog.d("Finishing Inline postExec");
        InlineVineRecorder.access$100(InlineVineRecorder.this).cessingFinish();
        InlineVineRecorder.access$202(InlineVineRecorder.this, false);
    }

    protected void onPreExecute()
    {
        super.ecute();
        SLog.d("Finishing Inline preExec");
        InlineVineRecorder.access$100(InlineVineRecorder.this).cessingStart();
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
        if (InlineVineRecorder.access$300(InlineVineRecorder.this) != null)
        {
            InlineVineRecorder.access$300(InlineVineRecorder.this).setProgressRatio((float)ainteger[0].intValue() / 100F);
        }
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

    public I(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        this$0 = InlineVineRecorder.this;
        super(InlineVineRecorder.this, s, runnable, flag, flag1);
    }
}
