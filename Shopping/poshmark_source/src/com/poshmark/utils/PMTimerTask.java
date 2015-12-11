// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.application.PMApplication;
import com.poshmark.ui.MainActivity;
import java.util.Timer;
import java.util.TimerTask;

public class PMTimerTask extends TimerTask
{
    public static interface PMTimerTaskCallback
    {

        public abstract void timerCallback();
    }


    boolean callOnUIThread;
    PMTimerTaskCallback callback;

    public PMTimerTask(int i, boolean flag, PMTimerTaskCallback pmtimertaskcallback)
    {
        callback = pmtimertaskcallback;
        callOnUIThread = flag;
        (new Timer()).schedule(this, i);
    }

    public void run()
    {
        if (callOnUIThread)
        {
            PMApplication.getApplicationObject().getActivity().runOnUiThread(new Runnable() {

                final PMTimerTask this$0;

                public void run()
                {
                    callback.timerCallback();
                }

            
            {
                this$0 = PMTimerTask.this;
                super();
            }
            });
            return;
        } else
        {
            callback.timerCallback();
            return;
        }
    }
}
