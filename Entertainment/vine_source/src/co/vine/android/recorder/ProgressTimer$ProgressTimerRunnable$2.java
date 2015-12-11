// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            ProgressTimer, BasicVineRecorder

class val.controller
    implements Runnable
{

    final  this$0;
    final BasicVineRecorder val$controller;

    public void run()
    {
        val$controller.onProgressMaxReached();
    }

    ()
    {
        this$0 = final_;
        val$controller = BasicVineRecorder.this;
        super();
    }
}
