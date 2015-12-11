// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.recorder.ProgressView;

// Referenced classes of package co.vine.android:
//            InlineRecorderManager

private class <init>
    implements Runnable
{

    final InlineRecorderManager this$0;

    public void run()
    {
        InlineRecorderManager.access$200(InlineRecorderManager.this, true);
        InlineRecorderManager.access$300(InlineRecorderManager.this).setVisibility(0);
        InlineRecorderManager.access$300(InlineRecorderManager.this).setAlpha(1.0F);
        InlineRecorderManager.access$300(InlineRecorderManager.this).setProgressRatio(0.0F);
    }

    private ()
    {
        this$0 = InlineRecorderManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
