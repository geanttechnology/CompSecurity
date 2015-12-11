// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            InlineVineRecorder, RecordController

class nResumeTask extends nResumeTask
{

    final InlineVineRecorder this$0;

    protected boolean onMakingSureCameraReady(RecordController recordcontroller)
    {
        return InlineVineRecorder.access$000(InlineVineRecorder.this);
    }

    nResumeTask(View view, String s)
    {
        this$0 = InlineVineRecorder.this;
        super(InlineVineRecorder.this, view, s);
    }
}
