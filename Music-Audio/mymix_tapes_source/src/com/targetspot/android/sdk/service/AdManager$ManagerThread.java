// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdManager

class this._cls0 extends Thread
{

    final AdManager this$0;

    public void run()
    {
        Looper.prepare();
        synchronized (AdManager.access$000(AdManager.this))
        {
            AdManager.access$102(AdManager.this, new Handler() {

                final AdManager.ManagerThread this$1;

                public void handleMessage(Message message)
                {
                    boolean flag2 = true;
                    boolean flag = true;
                    switch (message.what)
                    {
                    default:
                        return;

                    case 0: // '\0'
                        Log.d("AdManager", "Thread start (MSG_START)");
                        if ((AdManager.access$200(this$0) != null || AdManager.access$300(this$0) != null) && !isManagedMode())
                        {
                            Log.d("AdManager", "Refreshing preroll for unmanaged mode");
                            AdManager.access$400(this$0, true, 0);
                        }
                        startRefresh();
                        return;

                    case 4: // '\004'
                        Log.d("AdManager", "Fetch ad (MSG_FETCH_AD)");
                        int i;
                        if (message.arg1 == 0)
                        {
                            flag = false;
                        }
                        i = message.arg2;
                        AdManager.access$400(this$0, flag, i);
                        return;

                    case 2: // '\002'
                        Log.d("AdManager", "Refresh ads (MSG_REFRESH)");
                        refreshAds();
                        return;

                    case 3: // '\003'
                        Log.d("AdManager", "Release ads (MSG_RELEASE)");
                        AdManager admanager = this$0;
                        boolean flag1;
                        if (message.arg1 == 4)
                        {
                            flag1 = flag2;
                        } else
                        {
                            flag1 = false;
                        }
                        AdManager.access$500(admanager, flag1);
                        return;

                    case 1: // '\001'
                        Log.d("AdManager", "Thread exit (MSG_QUIT)");
                        AdManager.access$600(this$0);
                        Looper.myLooper().quit();
                        return;
                    }
                }

            
            {
                this$1 = AdManager.ManagerThread.this;
                super();
            }
            });
            AdManager.access$100(AdManager.this).sendEmptyMessage(0);
            AdManager.access$000(AdManager.this).notify();
        }
        Looper.loop();
        AdManager.access$702(0);
        AdManager.access$102(AdManager.this, null);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    _cls1.this._cls1()
    {
        this$0 = AdManager.this;
        super();
    }
}
