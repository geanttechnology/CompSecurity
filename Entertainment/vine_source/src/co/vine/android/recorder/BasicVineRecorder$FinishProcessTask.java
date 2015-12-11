// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            BaseFinishProcessTask, BasicVineRecorder

public class this._cls0 extends BaseFinishProcessTask
{

    final BasicVineRecorder this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        mFinishProcessRunnable.run(tag, releasePreview, saveSession);
        return null;
    }

    public ble(String s, Runnable runnable, boolean flag, boolean flag1)
    {
        this$0 = BasicVineRecorder.this;
        super(s, runnable, flag, flag1);
    }
}
