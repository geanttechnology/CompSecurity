// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.Handler;
import android.util.Log;
import java.util.Date;
import java.util.Timer;

// Referenced classes of package io.branch.referral:
//            Branch, PrefHelper

class val.this._cls0
    implements Runnable
{

    final is._cls0 this$1;
    private Timer timer;
    final Branch val$this$0;

    public void run()
    {
        Branch.access$200(_fld0).removeCallbacks(cess._mth2700(this._cls1.this));
        Branch branch;
        boolean flag;
        if (!Branch.access$2800(_fld0))
        {
            Log.i("Branch Debug", "======= Start Debug Session =======");
            Branch.access$100(_fld0).setDebug();
            timer = new Timer();
            timer.scheduleAtFixedRate(new epDebugConnectionTask(this._cls1.this), new Date(), 20000L);
        } else
        {
            Log.i("Branch Debug", "======= End Debug Session =======");
            Branch.access$100(_fld0).clearDebug();
            if (timer != null)
            {
                timer.cancel();
                timer = null;
            }
        }
        branch = _fld0;
        if (!Branch.access$2800(_fld0))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Branch.access$2802(branch, flag);
    }

    epDebugConnectionTask()
    {
        this$1 = final_epdebugconnectiontask;
        val$this$0 = Branch.this;
        super();
    }
}
