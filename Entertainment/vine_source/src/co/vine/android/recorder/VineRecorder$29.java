// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.View;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class val.params
    implements Runnable
{

    final VineRecorder this$0;
    final android.view.Params val$params;

    public void run()
    {
        if (VineRecorder.access$3000(VineRecorder.this) != null)
        {
            VineRecorder.access$3000(VineRecorder.this).setLayoutParams(val$params);
        }
    }

    ()
    {
        this$0 = final_vinerecorder;
        val$params = android.view.Params.this;
        super();
    }
}
