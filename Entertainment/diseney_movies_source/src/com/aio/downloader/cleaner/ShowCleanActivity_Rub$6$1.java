// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.widget.TextView;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ShowCleanActivity_Rub.access$8(_fld0).setText((new StringBuilder(String.valueOf(ShowCleanActivity_Rub.access$6(_fld0)))).append("MB").toString());
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/cleaner/ShowCleanActivity_Rub$6

/* anonymous class */
    class ShowCleanActivity_Rub._cls6 extends Thread
    {

        final ShowCleanActivity_Rub this$0;

        public void run()
        {
            super.run();
            do
            {
                do
                {
                    if (!ShowCleanActivity_Rub.access$5(ShowCleanActivity_Rub.this))
                    {
                        return;
                    }
                    ShowCleanActivity_Rub showcleanactivity_rub = ShowCleanActivity_Rub.this;
                    ShowCleanActivity_Rub.access$7(showcleanactivity_rub, ShowCleanActivity_Rub.access$6(showcleanactivity_rub) + 1.1000000000000001D);
                    ShowCleanActivity_Rub.access$7(ShowCleanActivity_Rub.this, ShowCleanActivity_Rub.roundDouble(ShowCleanActivity_Rub.access$6(ShowCleanActivity_Rub.this), 2).doubleValue());
                    ShowCleanActivity_Rub.access$8(ShowCleanActivity_Rub.this).post(new ShowCleanActivity_Rub._cls6._cls1());
                    try
                    {
                        sleep(7L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                } while (ShowCleanActivity_Rub.access$6(ShowCleanActivity_Rub.this) < ShowCleanActivity_Rub.access$9(ShowCleanActivity_Rub.this).doubleValue());
                ShowCleanActivity_Rub.access$10(ShowCleanActivity_Rub.this, false);
            } while (true);
        }


            
            {
                this$0 = ShowCleanActivity_Rub.this;
                super();
            }
    }

}
