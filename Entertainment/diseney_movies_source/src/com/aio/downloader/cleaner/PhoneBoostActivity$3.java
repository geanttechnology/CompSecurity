// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.widget.ProgressBar;

// Referenced classes of package com.aio.downloader.cleaner:
//            PhoneBoostActivity

class this._cls0 extends Thread
{

    final PhoneBoostActivity this$0;

    public void run()
    {
        int i = 0;
        do
        {
            if (i >= 101)
            {
                return;
            }
            try
            {
                sleep(15L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            PhoneBoostActivity.access$19(PhoneBoostActivity.this).setProgress(i);
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 5)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(10);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 10)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(20);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 15)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(30);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 20)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(40);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 25)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(50);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 30)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(60);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 35)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(70);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 40)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(80);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 45)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(90);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 50)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(100);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 55)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(110);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 60)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(120);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 65)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(130);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 70)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(140);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 75)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(150);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 80)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(160);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 85)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(170);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 90)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(180);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 95)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(190);
            }
            if (PhoneBoostActivity.access$19(PhoneBoostActivity.this).getProgress() == 100)
            {
                PhoneBoostActivity.access$18(PhoneBoostActivity.this).sendEmptyMessage(200);
            }
            i++;
        } while (true);
    }

    ()
    {
        this$0 = PhoneBoostActivity.this;
        super();
    }
}
