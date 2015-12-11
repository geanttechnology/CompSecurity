// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;
import android.view.ViewPropertyAnimator;
import co.vine.android.recorder.InlineVineRecorder;
import co.vine.android.recorder.ProgressView;
import co.vine.android.recorder.ViewGoneAnimationListener;

// Referenced classes of package co.vine.android:
//            InlineRecorderManager, ConversationFragment

private class <init>
    implements Runnable
{

    final InlineRecorderManager this$0;

    public void run()
    {
        InlineRecorderManager.access$400(InlineRecorderManager.this).setVisibility(0);
        InlineRecorderManager.access$500(InlineRecorderManager.this).prepareUpload();
        InlineRecorderManager.access$600(InlineRecorderManager.this).deleteCurrentDraftFolder("inline finish.");
        InlineRecorderManager.access$600(InlineRecorderManager.this).swapSession("Inline record", InlineRecorderManager.access$700(InlineRecorderManager.this));
        InlineRecorderManager.access$800(InlineRecorderManager.this).setVisibility(0);
        InlineRecorderManager.access$800(InlineRecorderManager.this).setEnabled(true);
        InlineRecorderManager.access$300(InlineRecorderManager.this).animate().alpha(0.0F).setListener(new ViewGoneAnimationListener(InlineRecorderManager.access$300(InlineRecorderManager.this))).start();
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
