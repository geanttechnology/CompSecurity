// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.ui.PMActivity;

public class UIThreadTask
{
    public static interface Callback
    {

        public abstract void runOnUIThread(Object obj);
    }


    PMActivity activity;
    Callback callback;
    Object data;

    public UIThreadTask(PMActivity pmactivity)
    {
        activity = pmactivity;
    }

    public void execute(final Object data)
    {
        activity.runOnUiThread(new Runnable() {

            final UIThreadTask this$0;
            final Object val$data;

            public void run()
            {
                callback.runOnUIThread(data);
            }

            
            {
                this$0 = UIThreadTask.this;
                data = obj;
                super();
            }
        });
    }

    public void setCallback(Callback callback1)
    {
        callback = callback1;
    }
}
