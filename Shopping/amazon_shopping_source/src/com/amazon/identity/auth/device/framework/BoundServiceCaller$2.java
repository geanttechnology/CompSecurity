// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Intent;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceCaller

class this._cls0
    implements Runnable
{

    final BoundServiceCaller this$0;

    public void run()
    {
label0:
        {
            synchronized (BoundServiceCaller.access$200(BoundServiceCaller.this))
            {
                if (!BoundServiceCaller.access$100(BoundServiceCaller.this))
                {
                    break label0;
                }
            }
            return;
        }
        MAPLog.e(BoundServiceCaller.access$000(), String.format("Application timed out trying to bind to %s", new Object[] {
            BoundServiceCaller.access$400(BoundServiceCaller.this).getComponent().getPackageName()
        }));
        BoundServiceCaller.access$302(BoundServiceCaller.this, null);
        aobj;
        JVM INSTR monitorexit ;
        serviceTimedOut();
        return;
        exception;
        throw exception;
    }

    ()
    {
        this$0 = BoundServiceCaller.this;
        super();
    }
}
