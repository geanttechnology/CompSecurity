// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.widget.SeekBar;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements Runnable
{

    final VineRecorder this$0;

    public void run()
    {
        if (VineRecorder.access$1200(VineRecorder.this) != null && VineRecorder.access$1300(VineRecorder.this) >= 0)
        {
            SLog.d((new StringBuilder()).append("Zoom progress updated: ").append(VineRecorder.access$1300(VineRecorder.this)).toString());
            VineRecorder.access$1200(VineRecorder.this).setProgress(VineRecorder.access$1300(VineRecorder.this) - 1);
        }
        requestZoomProgressUpdate();
    }

    ()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
