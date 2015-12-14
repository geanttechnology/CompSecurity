// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering.mraid:
//            j, i

class a
    implements Runnable
{

    final j a;

    public void run()
    {
        int k = 0;
        Object obj;
label0:
        do
        {
label1:
            {
                if (k <= j.a(a))
                {
                    Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, j.b(), "Attempting to get MRAID Js.");
                    obj = (new d(j.b(a))).a();
                    if (!((c) (obj)).a())
                    {
                        break label0;
                    }
                    Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, j.b(), "Getting MRAID Js from server failed.");
                    k++;
                    if (k <= j.a(a))
                    {
                        break label1;
                    }
                }
                return;
            }
            try
            {
                Thread.sleep(com.inmobi.rendering.mraid.j.c(a) * 1000);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, j.b(), "MRAID Js client interrupted while sleeping.", ((Throwable) (obj)));
            }
        } while (true);
        Logger.a(com.inmobi.commons.core.utilities.er.InternalLogLevel.INTERNAL, j.b(), (new StringBuilder()).append("Getting MRAID Js from server succeeded. Response:").append(((c) (obj)).b()).toString());
        (new i()).a(((c) (obj)).b());
    }

    .c(j j1)
    {
        a = j1;
        super();
    }
}
