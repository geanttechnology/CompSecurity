// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android.recorder:
//            RecordingActivityHelper

class this._cls0
    implements ServiceConnection
{

    final RecordingActivityHelper this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        SLog.i("Camera service connected.");
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SLog.i("Camera service disconnected.");
    }

    ()
    {
        this$0 = RecordingActivityHelper.this;
        super();
    }
}
