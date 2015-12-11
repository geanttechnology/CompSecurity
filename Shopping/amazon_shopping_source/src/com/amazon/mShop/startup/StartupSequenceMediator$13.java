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

class this._cls0 extends StartupTask
{

    final StartupSequenceMediator this$0;

    public void start()
    {
        com.amazon.mShop.platform.e().invokeLater(new Runnable() {

            final StartupSequenceMediator._cls13 this$1;

            public void run()
            {
                SmileUserListener.registerUserListener();
                SmileUserListener.registerFeatureStateListener();
                if (SmileHelper.shouldSyncSmileInfo())
                {
                    SmileController.getInstance().syncSmileInfo();
                }
            }

            
            {
                this$1 = StartupSequenceMediator._cls13.this;
                super();
            }
        });
    }

    _cls1.this._cls1(Mediator mediator, String s)
    {
        this$0 = StartupSequenceMediator.this;
        super(mediator, s);
    }
}
