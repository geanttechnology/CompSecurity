// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


// Referenced classes of package co.vine.android.recorder:
//            BasicVineRecorder

class val.tag
    implements Runnable
{

    final BasicVineRecorder this$0;
    final String val$tag;

    public void run()
    {
        guardedStartRecording(val$tag);
    }

    ()
    {
        this$0 = final_basicvinerecorder;
        val$tag = String.this;
        super();
    }
}
