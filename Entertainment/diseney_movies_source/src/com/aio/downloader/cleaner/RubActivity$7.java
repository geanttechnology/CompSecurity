// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.widget.TextView;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity

class this._cls0 extends Thread
{

    final RubActivity this$0;

    public void run()
    {
        super.run();
        do
        {
            do
            {
                if (!RubActivity.access$25())
                {
                    return;
                }
                RubActivity.access$7(RubActivity.access$26() - 1.1000000000000001D);
                RubActivity.access$7(RubActivity.roundDouble(RubActivity.access$26(), 2).doubleValue());
                RubActivity.access$10(RubActivity.this).post(new Runnable() {

                    final RubActivity._cls7 this$1;

                    public void run()
                    {
                        if (RubActivity.access$26() < 0.0D)
                        {
                            RubActivity.access$10(this$0).setTextSize(50F);
                            RubActivity.access$10(this$0).setText("0");
                            return;
                        } else
                        {
                            RubActivity.access$10(this$0).setTextSize(50F);
                            RubActivity.access$10(this$0).setText((new StringBuilder()).append(RubActivity.access$26()).toString());
                            return;
                        }
                    }

            
            {
                this$1 = RubActivity._cls7.this;
                super();
            }
                });
                try
                {
                    sleep(10L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
            } while (RubActivity.access$26() > 0.0D);
            RubActivity.access$27(false);
        } while (true);
    }


    _cls1.this._cls1()
    {
        this$0 = RubActivity.this;
        super();
    }
}
