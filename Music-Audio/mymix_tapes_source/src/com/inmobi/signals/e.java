// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.signals:
//            c, f, b

public class e
{

    private static final String a = com/inmobi/signals/e.getSimpleName();

    public e()
    {
    }

    public com.inmobi.signals.c a(b b)
    {
        b = new com.inmobi.signals.c((new d(b)).a());
        if (b.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Getting Carb list from server failed.");
            return b;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Getting Carb list from server succeeded.");
            return b;
        }
    }

    public boolean a(f f1)
    {
        int i;
        boolean flag1;
        flag1 = false;
        i = 0;
_L5:
        boolean flag = flag1;
        if (i > f1.b()) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Attempting to send pruned Carb list to server.");
        if (!(new d(f1)).a().a())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Sending pruned Carb list to server failed.");
        i++;
        if (i <= f1.b()) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L2:
        if (!flag)
        {
            com.inmobi.commons.core.c.a.a().a(new com.inmobi.commons.core.c.e("signals", "CarbUploadDiscarded"));
        }
        return flag;
_L4:
        try
        {
            Thread.sleep(f1.c() * 1000);
        }
        catch (InterruptedException interruptedexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "User data network client interrupted while sleeping.", interruptedexception);
        }
          goto _L5
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Sending pruned Carb list to server succeeded.");
        flag = true;
          goto _L2
    }

}
