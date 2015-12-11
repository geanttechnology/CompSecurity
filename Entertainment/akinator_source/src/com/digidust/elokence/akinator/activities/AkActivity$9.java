// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.os.Handler;
import com.digidust.elokence.akinator.factories.AkPlayerBelongingsFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class mStartXp
    implements Runnable
{

    private int mStartXp;
    private int mTotalXp;
    final AkActivity this$0;
    private final long tranche;
    final int val$XpAdded;
    final Handler val$handlerXp;

    public void run()
    {
        while (mStartXp < mTotalXp) 
        {
    /* block-local class not found */
    class _cls1 {}

            try
            {
                Thread.sleep(20L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
            val$handlerXp.post(new _cls1());
            mStartXp = (int)((long)mStartXp + tranche);
        }
    /* block-local class not found */
    class _cls2 {}

        val$handlerXp.post(new _cls2());
    }



    _cls2()
    {
        this$0 = final_akactivity;
        val$XpAdded = i;
        val$handlerXp = Handler.this;
        super();
        mTotalXp = AkPlayerBelongingsFactory.sharedInstance().getXp();
        mStartXp = mTotalXp - val$XpAdded;
        tranche = (mTotalXp - mStartXp) / 50;
    }
}
