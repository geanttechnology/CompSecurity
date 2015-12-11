// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.View;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class val.bottomMaskParams
    implements Runnable
{

    final AbstractRecordingActivity this$0;
    final View val$bottomMask;
    final android.widget..val.bottomMaskParams val$bottomMaskParams;

    public void run()
    {
        val$bottomMask.setLayoutParams(val$bottomMaskParams);
    }

    ()
    {
        this$0 = final_abstractrecordingactivity;
        val$bottomMask = view;
        val$bottomMaskParams = android.widget..val.bottomMaskParams.this;
        super();
    }
}
