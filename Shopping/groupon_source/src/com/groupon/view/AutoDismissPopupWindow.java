// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import java.util.Timer;
import java.util.TimerTask;
import roboguice.util.Ln;

public class AutoDismissPopupWindow extends PopupWindow
{

    private int timeoutValue;
    private Timer timer;

    public AutoDismissPopupWindow(View view)
    {
        super(view);
        timer = null;
        timeoutValue = 5000;
    }

    protected void clearTimer()
    {
        if (timer != null)
        {
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }

    public void dismiss()
    {
        clearTimer();
        try
        {
            super.dismiss();
            return;
        }
        catch (Exception exception)
        {
            Ln.e("Unable to dismiss auto-dismiss popup; probably activity was closed", new Object[0]);
        }
    }

    public void setAutoDismissTimeout(int i)
    {
        timeoutValue = i;
    }

    protected void setTimer()
    {
        final Handler handler = new Handler();
        clearTimer();
        if (timer == null)
        {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {

            final AutoDismissPopupWindow this$0;
            final Handler val$handler;

            public void run()
            {
                handler.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = AutoDismissPopupWindow.this;
                handler = handler1;
                super();
            }
        }, timeoutValue);
    }

    public void showAsDropDown(View view)
    {
        super.showAsDropDown(view);
        setTimer();
    }

    public void showAsDropDown(View view, int i, int j)
    {
        super.showAsDropDown(view, i, j);
        setTimer();
    }

    public void showAtLocation(View view, int i, int j, int k)
    {
        try
        {
            super.showAtLocation(view, i, j, k);
            setTimer();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.e("Unable to show popup!", new Object[0]);
        }
    }

    public void update()
    {
        super.update();
        setTimer();
    }

    public void update(int i, int j)
    {
        super.update(i, j);
        setTimer();
    }

    public void update(int i, int j, int k, int l)
    {
        super.update(i, j, k, l);
        setTimer();
    }

    public void update(int i, int j, int k, int l, boolean flag)
    {
        super.update(i, j, k, l, flag);
        setTimer();
    }

    public void update(View view, int i, int j)
    {
        super.update(view, i, j);
        setTimer();
    }

    public void update(View view, int i, int j, int k, int l)
    {
        super.update(view, i, j, k, l);
        setTimer();
    }
}
