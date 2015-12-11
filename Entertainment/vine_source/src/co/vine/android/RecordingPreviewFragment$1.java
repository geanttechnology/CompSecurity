// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;

// Referenced classes of package co.vine.android:
//            RecordingPreviewFragment

class this._cls0
    implements android.view.._cls1
{

    final RecordingPreviewFragment this$0;

    public void onClick(View view)
    {
        RecordingPreviewFragment.access$002(RecordingPreviewFragment.this, (RecordingPreviewFragment.access$000(RecordingPreviewFragment.this) + 1) % RecordingPreviewFragment.access$100().length);
        RecordingPreviewFragment.access$200(RecordingPreviewFragment.this);
    }

    ()
    {
        this$0 = RecordingPreviewFragment.this;
        super();
    }
}
