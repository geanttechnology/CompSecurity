// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.data.Registration;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import java.io.IOException;
import sg;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETPush

class y
    implements Runnable
{

    final ETPush a;

    y(ETPush etpush)
    {
        a = etpush;
        super();
    }

    public void run()
    {
        try
        {
            m.a("~!ETPush", "Requesting GCM Registration");
            String s = sg.a(ETPush.k()).a(new String[] {
                d.d()
            });
            ETPush.n().setSystemTokenInCache(s);
            m.a("~!ETPush", String.format("GCM Registration complete. System Token received: %s", new Object[] {
                s
            }));
            return;
        }
        catch (IOException ioexception)
        {
            m.c("~!ETPush", ioexception.getMessage(), ioexception);
        }
    }
}
