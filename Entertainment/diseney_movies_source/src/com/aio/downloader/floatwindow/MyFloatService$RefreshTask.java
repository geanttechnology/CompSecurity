// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyFloatService, MyWindowManager

class this._cls0 extends TimerTask
{

    final MyFloatService this$0;

    public void run()
    {
        if (!MyWindowManager.isWindowShowing())
        {
            MyFloatService.access$0(MyFloatService.this).post(new Runnable() {

                final MyFloatService.RefreshTask this$1;

                public void run()
                {
                    MyWindowManager.createSmallWindow(getApplicationContext());
                }

            
            {
                this$1 = MyFloatService.RefreshTask.this;
                super();
            }
            });
        } else
        {
            if (MyWindowManager.isWindowShowing())
            {
                MyFloatService.access$0(MyFloatService.this).post(new Runnable() {

                    final MyFloatService.RefreshTask this$1;

                    public void run()
                    {
                    }

            
            {
                this$1 = MyFloatService.RefreshTask.this;
                super();
            }
                });
                return;
            }
            if (MyWindowManager.isWindowShowing())
            {
                MyFloatService.access$0(MyFloatService.this).post(new Runnable() {

                    final MyFloatService.RefreshTask this$1;

                    public void run()
                    {
                        MyWindowManager.updateUsedPercent(getApplicationContext());
                    }

            
            {
                this$1 = MyFloatService.RefreshTask.this;
                super();
            }
                });
                return;
            }
        }
    }


    _cls3.this._cls1()
    {
        this$0 = MyFloatService.this;
        super();
    }
}
