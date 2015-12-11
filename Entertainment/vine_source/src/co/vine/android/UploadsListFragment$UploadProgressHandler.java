// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import co.vine.android.recorder.ProgressView;
import com.edisonwang.android.slog.SLog;

// Referenced classes of package co.vine.android:
//            UploadsListFragment

private class <init> extends Handler
{

    final UploadsListFragment this$0;

    public void handleMessage(Message message)
    {
        int i;
        i = message.what;
        message = (Bundle)message.obj;
        SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Message received, what=").append(i).toString());
        i;
        JVM INSTR tableswitch 6 7: default 64
    //                   6 65
    //                   7 184;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (UploadsListFragment.access$500(UploadsListFragment.this) != null && UploadsListFragment.access$600(UploadsListFragment.this) != null)
        {
            double d = message.getDouble("upload_progress");
            SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Upload progress changed to p=").append(d).toString());
            if (UploadsListFragment.access$700(UploadsListFragment.this) == 0)
            {
                UploadsListFragment.access$702(UploadsListFragment.this, UploadsListFragment.access$600(UploadsListFragment.this).getMeasuredWidth());
            }
            UploadsListFragment.access$600(UploadsListFragment.this).setProgressRatio((float)((0.97999999999999998D * d) / 100D));
            UploadsListFragment.access$500(UploadsListFragment.this).setText(getString(0x7f0e0260));
            return;
        }
          goto _L1
_L3:
        boolean flag = message.getBoolean("success");
        SLog.dWithTag("UploadsListFragment", (new StringBuilder()).append("Post completed, success=").append(flag).toString());
        sendMessage(Message.obtain(null, 2));
        if (flag)
        {
            UploadsListFragment.access$500(UploadsListFragment.this).setText(getString(0x7f0e025f));
            return;
        } else
        {
            UploadsListFragment.access$800(UploadsListFragment.this);
            return;
        }
    }

    private ()
    {
        this$0 = UploadsListFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
