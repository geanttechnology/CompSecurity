// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;


// Referenced classes of package co.vine.android.player:
//            SdkVideoTimer, SdkVideoView

class this._cls0
    implements Runnable
{

    final ntroller.getLastPlayer this$0;

    public void run()
    {
        SdkVideoView sdkvideoview = cess._mth000(this._cls0.this).getLastPlayer();
        if (sdkvideoview != null && sdkvideoview.getVisibility() != 0)
        {
            sdkvideoview.setVisibility(0);
        }
    }

    ntroller()
    {
        this$0 = this._cls0.this;
        super();
    }
}
