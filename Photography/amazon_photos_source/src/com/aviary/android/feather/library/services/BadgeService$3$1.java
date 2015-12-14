// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.os.Handler;
import com.aviary.android.feather.common.threading.Future;
import com.aviary.android.feather.common.threading.FutureListener;
import java.util.Set;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BadgeService

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        BadgeService.access$300(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aviary/android/feather/library/services/BadgeService$3

/* anonymous class */
    class BadgeService._cls3
        implements FutureListener
    {

        final BadgeService this$0;

        public void onFutureDone(Future future)
        {
label0:
            {
                Object obj = null;
                if (future != null)
                {
                    try
                    {
                        future = (Set)future.get();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Future future)
                    {
                        future.printStackTrace();
                        future = obj;
                    }
                    if (future != null)
                    {
                        int i = BadgeService.access$200(BadgeService.this).size();
                        BadgeService.access$200(BadgeService.this).addAll(future);
                        if (BadgeService.access$200(BadgeService.this).size() != i && mHandler != null)
                        {
                            break label0;
                        }
                    }
                }
                return;
            }
            mHandler.post(new BadgeService._cls3._cls1());
        }

            
            {
                this$0 = BadgeService.this;
                super();
            }
    }

}
