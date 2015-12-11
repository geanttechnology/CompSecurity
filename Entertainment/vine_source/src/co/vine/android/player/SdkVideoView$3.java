// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;


// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class val.keepScreenOn
    implements Runnable
{

    final SdkVideoView this$0;
    final boolean val$keepScreenOn;

    public void run()
    {
        SdkVideoView.access$1601(SdkVideoView.this, val$keepScreenOn);
    }

    ()
    {
        this$0 = final_sdkvideoview;
        val$keepScreenOn = Z.this;
        super();
    }
}
