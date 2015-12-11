// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.util.Log;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.mediator.Mediator;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class val.activity extends StartupTask
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    public void start()
    {
        Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        StartupSequenceMediator.access$100().execute(new Runnable() {

            final StartupSequenceMediator._cls3 this$1;

            public void run()
            {
                StartupSequenceMediator.access$000(this$0, activity);
                com.amazon.mShop.platform.Platform.Factory.getInstance().runOnUiThread(new Runnable() {

                    final _cls1 this$2;

                    public void run()
                    {
                        endTask("taskGetCookiesAndAccount", "taskResultSucceed");
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$1 = StartupSequenceMediator._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1(String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
