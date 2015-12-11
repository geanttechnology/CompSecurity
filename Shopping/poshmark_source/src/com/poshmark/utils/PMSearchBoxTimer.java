// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.application.PMApplication;
import com.poshmark.ui.MainActivity;
import java.util.Timer;
import java.util.TimerTask;

public class PMSearchBoxTimer extends TimerTask
{
    public static interface PMSearchTimerTaskCallback
    {

        public abstract void timerCallback(String s);
    }


    boolean callOnUIThread;
    PMSearchTimerTaskCallback callback;
    String searchString;

    public PMSearchBoxTimer(int i, boolean flag, String s, PMSearchTimerTaskCallback pmsearchtimertaskcallback)
    {
        searchString = s;
        callback = pmsearchtimertaskcallback;
        callOnUIThread = flag;
        (new Timer()).schedule(this, i);
    }

    public void run()
    {
        if (callOnUIThread)
        {
            PMApplication.getApplicationObject().getActivity().runOnUiThread(new Runnable() {

                final PMSearchBoxTimer this$0;

                public void run()
                {
                    callback.timerCallback(searchString);
                }

            
            {
                this$0 = PMSearchBoxTimer.this;
                super();
            }
            });
            return;
        } else
        {
            callback.timerCallback(searchString);
            return;
        }
    }
}
