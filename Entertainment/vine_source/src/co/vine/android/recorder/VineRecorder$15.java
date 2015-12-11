// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.DialogInterface;
import android.widget.EditText;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordController

class val.et
    implements android.content.OnClickListener
{

    final VineRecorder this$0;
    final EditText val$et;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (mVideoController != null)
        {
            mVideoController.setAudioTrim(true);
            startTimeLapse(Double.parseDouble(val$et.getText().toString()));
        }
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = final_vinerecorder;
        val$et = EditText.this;
        super();
    }
}
