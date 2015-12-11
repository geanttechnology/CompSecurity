// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package io.branch.referral:
//            Branch, SystemObserver, PrefHelper

class _cls1.started
    implements android.view.uchListener
{
    class KeepDebugConnectionTask extends TimerTask
    {

        final Branch._cls1 this$1;

        public void run()
        {
            if (!Branch.access$100(this$0).keepDebugConnection())
            {
                Branch.access$200(this$0).post(_longPressed);
            }
        }

        KeepDebugConnectionTask()
        {
            this$1 = Branch._cls1.this;
            super();
        }
    }


    Runnable _longPressed;
    final Branch this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        int i = motionevent.getPointerCount();
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 5: default 52
    //                   0 54
    //                   1 105
    //                   2 52
    //                   3 88
    //                   4 52
    //                   5 127;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
        return true;
_L2:
        if (Branch.access$300(Branch.this).isSimulator())
        {
            Branch.access$200(Branch.this).postDelayed(_longPressed, 3000L);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Branch.access$200(Branch.this).removeCallbacks(_longPressed);
        continue; /* Loop/switch isn't completed */
_L3:
        view.performClick();
        Branch.access$200(Branch.this).removeCallbacks(_longPressed);
        continue; /* Loop/switch isn't completed */
_L5:
        if (i == 4)
        {
            Branch.access$200(Branch.this).postDelayed(_longPressed, 3000L);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    _cls1.started()
    {
        this$0 = Branch.this;
        super();
        _longPressed = new Runnable() {

            private boolean started;
            final Branch._cls1 this$1;
            private Timer timer;

            public void run()
            {
                Branch.access$200(this$0).removeCallbacks(_longPressed);
                boolean flag;
                if (!started)
                {
                    Log.i("Branch Debug", "======= Start Debug Session =======");
                    Branch.access$100(this$0).setDebug();
                    timer = new Timer();
                    timer.scheduleAtFixedRate(new KeepDebugConnectionTask(), new Date(), 20000L);
                } else
                {
                    Log.i("Branch Debug", "======= End Debug Session =======");
                    Branch.access$100(this$0).clearDebug();
                    timer.cancel();
                    timer = null;
                }
                if (!started)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                started = flag;
            }

            
            {
                this$1 = Branch._cls1.this;
                super();
                started = false;
            }
        };
    }
}
