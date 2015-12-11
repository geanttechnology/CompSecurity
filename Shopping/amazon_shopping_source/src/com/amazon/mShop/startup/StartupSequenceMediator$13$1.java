// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.control.smile.SmileController;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.smile.SmileUserListener;
import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class this._cls1
    implements Runnable
{

    final leInfo this$1;

    public void run()
    {
        SmileUserListener.registerUserListener();
        SmileUserListener.registerFeatureStateListener();
        if (SmileHelper.shouldSyncSmileInfo())
        {
            SmileController.getInstance().syncSmileInfo();
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/startup/StartupSequenceMediator$13

/* anonymous class */
    class StartupSequenceMediator._cls13 extends StartupTask
    {

        final StartupSequenceMediator this$0;

        public void start()
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new StartupSequenceMediator._cls13._cls1());
        }

            
            {
                this$0 = StartupSequenceMediator.this;
                super(mediator, s);
            }
    }

}
