// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.gotv.crackle.views:
//            HeroViewPager

static final class  extends Handler
{

    public void handleMessage(Message message)
    {
        HeroViewPager heroviewpager = (HeroViewPager)message.obj;
        message.what;
        JVM INSTR tableswitch 0 0: default 32
    //                   0 38;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        HeroViewPager.access$000(heroviewpager);
        heroviewpager.setCurrentItem(heroviewpager.getCurrentItem() + 1, true);
        Message message1 = Message.obtain();
        message1.obj = heroviewpager;
        message1.what = 0;
        HeroViewPager.access$100().sendMessageDelayed(message1, 10000L);
        if (true) goto _L1; else goto _L3
_L3:
    }

    ()
    {
    }
}
