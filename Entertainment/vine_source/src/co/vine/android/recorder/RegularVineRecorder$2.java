// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.app.ProgressDialog;

// Referenced classes of package co.vine.android.recorder:
//            RegularVineRecorder

class val.dialog
    implements Runnable
{

    final RegularVineRecorder this$0;
    final ProgressDialog val$dialog;

    public void run()
    {
        val$dialog.show();
    }

    ()
    {
        this$0 = final_regularvinerecorder;
        val$dialog = ProgressDialog.this;
        super();
    }
}
