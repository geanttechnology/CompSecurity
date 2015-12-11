// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.os.Handler;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package io.branch.referral:
//            Branch, SystemObserver, PrefHelper

public class _cls1.this._cls1
    implements android.view.lback
{
    class KeepDebugConnectionTask extends TimerTask
    {

        final Branch.BranchWindowCallback this$1;

        public void run()
        {
            if (Branch.access$2800(this$0) && !Branch.access$100(this$0).keepDebugConnection() && longPressed_ != null)
            {
                Branch.access$200(this$0).post(longPressed_);
            }
        }

        KeepDebugConnectionTask()
        {
            this$1 = Branch.BranchWindowCallback.this;
            super();
        }
    }


    private android.view.tingActionMode callback_;
    private Runnable longPressed_;
    final Branch this$0;

    public boolean dispatchGenericMotionEvent(MotionEvent motionevent)
    {
        return callback_.ricMotionEvent(motionevent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return callback_.vent(keyevent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyevent)
    {
        return callback_.hortcutEvent(keyevent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return callback_.lateAccessibilityEvent(accessibilityevent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 5: default 48
    //                   0 59
    //                   1 110
    //                   2 48
    //                   3 93
    //                   4 48
    //                   5 127;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L5
_L1:
        return callback_.hEvent(motionevent);
_L2:
        if (Branch.access$300(Branch.this).isSimulator())
        {
            Branch.access$200(Branch.this).postDelayed(longPressed_, 3000L);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Branch.access$200(Branch.this).removeCallbacks(longPressed_);
        continue; /* Loop/switch isn't completed */
_L3:
        Branch.access$200(Branch.this).removeCallbacks(longPressed_);
        continue; /* Loop/switch isn't completed */
_L5:
        if (motionevent.getPointerCount() == 4)
        {
            Branch.access$200(Branch.this).postDelayed(longPressed_, 3000L);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean dispatchTrackballEvent(MotionEvent motionevent)
    {
        return callback_.kballEvent(motionevent);
    }

    public void onActionModeFinished(ActionMode actionmode)
    {
        callback_.Finished(actionmode);
    }

    public void onActionModeStarted(ActionMode actionmode)
    {
        callback_.Started(actionmode);
    }

    public void onAttachedToWindow()
    {
        callback_.Window();
    }

    public void onContentChanged()
    {
        callback_.nged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        return callback_.lMenu(i, menu);
    }

    public View onCreatePanelView(int i)
    {
        return callback_.lView(i);
    }

    public void onDetachedFromWindow()
    {
        callback_.omWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        return callback_.lected(i, menuitem);
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        return callback_.(i, menu);
    }

    public void onPanelClosed(int i, Menu menu)
    {
        callback_.d(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        return callback_.el(i, view, menu);
    }

    public boolean onSearchRequested()
    {
        return callback_.ested();
    }

    public void onWindowAttributesChanged(android.view.lback lback)
    {
        callback_.ibutesChanged(lback);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        callback_.sChanged(flag);
    }

    public ActionMode onWindowStartingActionMode(android.view.lback lback)
    {
        return callback_.tingActionMode(lback);
    }



    public _cls1.val.this._cls0(android.view.lback lback)
    {
        this.this$0 = Branch.this;
        super();
        callback_ = lback;
        if (longPressed_ == null)
        {
            longPressed_ = new Runnable() {

                final Branch.BranchWindowCallback this$1;
                private Timer timer;
                final Branch val$this$0;

                public void run()
                {
                    Branch.access$200(Branch.BranchWindowCallback.this.this$0).removeCallbacks(longPressed_);
                    Branch branch;
                    boolean flag;
                    if (!Branch.access$2800(Branch.BranchWindowCallback.this.this$0))
                    {
                        Log.i("Branch Debug", "======= Start Debug Session =======");
                        Branch.access$100(Branch.BranchWindowCallback.this.this$0).setDebug();
                        timer = new Timer();
                        timer.scheduleAtFixedRate(new KeepDebugConnectionTask(), new Date(), 20000L);
                    } else
                    {
                        Log.i("Branch Debug", "======= End Debug Session =======");
                        Branch.access$100(Branch.BranchWindowCallback.this.this$0).clearDebug();
                        if (timer != null)
                        {
                            timer.cancel();
                            timer = null;
                        }
                    }
                    branch = Branch.BranchWindowCallback.this.this$0;
                    if (!Branch.access$2800(Branch.BranchWindowCallback.this.this$0))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    Branch.access$2802(branch, flag);
                }

            
            {
                this$1 = Branch.BranchWindowCallback.this;
                this$0 = branch;
                super();
            }
            };
        }
    }
}
