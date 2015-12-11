// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder

private class <init>
    implements Runnable
{

    public int progress;
    final BasicVineRecorder this$0;

    public void run()
    {
        changeProgress(progress);
    }

    private ()
    {
        this$0 = BasicVineRecorder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
