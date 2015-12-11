// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class s
    implements Runnable
{

    final VineRecorder this$0;
    final android.widget.ayoutParams val$thumbListParams;

    public void run()
    {
        Object obj = VineRecorder.access$1900(VineRecorder.this);
        if (obj != null)
        {
            ((View) (obj)).setLayoutParams(VineRecorder.access$2000(VineRecorder.this));
        }
        obj = VineRecorder.access$1800(VineRecorder.this);
        if (obj != null)
        {
            ((View) (obj)).setLayoutParams(val$thumbListParams);
        }
    }

    s()
    {
        this$0 = final_vinerecorder;
        val$thumbListParams = android.widget.ayoutParams.this;
        super();
    }
}
