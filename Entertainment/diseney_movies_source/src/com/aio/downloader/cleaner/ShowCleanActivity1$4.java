// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

class this._cls0 extends Thread
{

    final ShowCleanActivity1 this$0;

    public void run()
    {
        super.run();
        do
        {
            do
            {
                if (!ShowCleanActivity1.access$16(ShowCleanActivity1.this))
                {
                    ShowCleanActivity1.access$22(ShowCleanActivity1.this).sendEmptyMessage(100);
                    return;
                }
                ShowCleanActivity1 showcleanactivity1 = ShowCleanActivity1.this;
                ShowCleanActivity1.access$18(showcleanactivity1, ShowCleanActivity1.access$17(showcleanactivity1) + 2.1000000000000001D);
                ShowCleanActivity1.access$18(ShowCleanActivity1.this, ShowCleanActivity1.roundDouble(ShowCleanActivity1.access$17(ShowCleanActivity1.this), 2).doubleValue());
                Log.e("fff", (new StringBuilder("cont")).append(ShowCleanActivity1.access$17(ShowCleanActivity1.this)).toString());
                ShowCleanActivity1.access$19(ShowCleanActivity1.this).post(new Runnable() {

                    final ShowCleanActivity1._cls4 this$1;

                    public void run()
                    {
                        if (ShowCleanActivity1.access$17(this$0) < 1024D)
                        {
                            ShowCleanActivity1.access$19(this$0).setText((new StringBuilder("Cleaned: ")).append(ShowCleanActivity1.access$17(this$0)).append("MB").toString());
                            return;
                        } else
                        {
                            ShowCleanActivity1.access$19(this$0).setText((new StringBuilder("Cleaned: ")).append(ShowCleanActivity1.roundDouble(ShowCleanActivity1.access$17(this$0) / 1024D, 2)).append("GB").toString());
                            return;
                        }
                    }

            
            {
                this$1 = ShowCleanActivity1._cls4.this;
                super();
            }
                });
                try
                {
                    sleep(15L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
            } while (ShowCleanActivity1.access$17(ShowCleanActivity1.this) < ShowCleanActivity1.access$20(ShowCleanActivity1.this).doubleValue());
            ShowCleanActivity1.access$21(ShowCleanActivity1.this, false);
        } while (true);
    }


    _cls1.this._cls1()
    {
        this$0 = ShowCleanActivity1.this;
        super();
    }
}
