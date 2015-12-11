// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.floatwindow:
//            FloatWindowService, MyWindowManager

class this._cls0 extends TimerTask
{

    final FloatWindowService this$0;

    public void run()
    {
        if (FloatWindowService.access$0(FloatWindowService.this) && !MyWindowManager.isWindowShowing())
        {
            FloatWindowService.access$1(FloatWindowService.this).post(new Runnable() {

                final FloatWindowService.RefreshTask this$1;

                public void run()
                {
                    MyWindowManager.createSmallWindow(getApplicationContext());
                }

            
            {
                this$1 = FloatWindowService.RefreshTask.this;
                super();
            }
            });
        } else
        {
            if (!FloatWindowService.access$0(FloatWindowService.this) && MyWindowManager.isWindowShowing())
            {
                FloatWindowService.access$1(FloatWindowService.this).post(new Runnable() {

                    final FloatWindowService.RefreshTask this$1;

                    public void run()
                    {
                        MyWindowManager.removeSmallWindow(getApplicationContext());
                        MyWindowManager.removeBigWindow(getApplicationContext());
                    }

            
            {
                this$1 = FloatWindowService.RefreshTask.this;
                super();
            }
                });
                return;
            }
            if (FloatWindowService.access$0(FloatWindowService.this) && MyWindowManager.isWindowShowing())
            {
                FloatWindowService.access$1(FloatWindowService.this).post(new Runnable() {

                    final FloatWindowService.RefreshTask this$1;

                    public void run()
                    {
                        MyWindowManager.updateUsedPercent(getApplicationContext());
                    }

            
            {
                this$1 = FloatWindowService.RefreshTask.this;
                super();
            }
                });
                return;
            }
        }
    }


    _cls3.this._cls1()
    {
        this$0 = FloatWindowService.this;
        super();
    }
}
