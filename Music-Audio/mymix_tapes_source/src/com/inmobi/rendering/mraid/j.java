// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.rendering.mraid:
//            i

public class j
{

    private static final String a = com/inmobi/rendering/mraid/j.getSimpleName();
    private String b;
    private int c;
    private int d;
    private NetworkRequest e;

    public j(String s, int i, int k)
    {
        b = s;
        c = i;
        d = k;
    }

    static int a(j j1)
    {
        return j1.c;
    }

    static NetworkRequest b(j j1)
    {
        return j1.e;
    }

    static String b()
    {
        return a;
    }

    static int c(j j1)
    {
        return j1.d;
    }

    public void a()
    {
        if (b == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "MRAID Js Url provided is invalid.");
            return;
        } else
        {
            e = new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.GET, b, false, null);
            (new Thread(new Runnable() {

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
                                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "Attempting to get MRAID Js.");
                                obj = (new d(j.b(a))).a();
                                if (!((c) (obj)).a())
                                {
                                    break label0;
                                }
                                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "Getting MRAID Js from server failed.");
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
                            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "MRAID Js client interrupted while sleeping.", ((Throwable) (obj)));
                        }
                    } while (true);
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), (new StringBuilder()).append("Getting MRAID Js from server succeeded. Response:").append(((c) (obj)).b()).toString());
                    (new i()).a(((c) (obj)).b());
                }

            
            {
                a = j.this;
                super();
            }
            })).start();
            return;
        }
    }

}
