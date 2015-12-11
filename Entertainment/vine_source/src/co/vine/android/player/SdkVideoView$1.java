// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.player;


// Referenced classes of package co.vine.android.player:
//            SdkVideoView

class this._cls0
    implements Runnable
{

    final SdkVideoView this$0;

    public void run()
    {
        SdkVideoView.access$100(SdkVideoView.this).onError(SdkVideoView.access$000(SdkVideoView.this), 1, 0);
    }

    ner()
    {
        this$0 = SdkVideoView.this;
        super();
    }
}
