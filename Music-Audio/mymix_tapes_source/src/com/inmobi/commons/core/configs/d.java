// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import com.inmobi.commons.core.utilities.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.inmobi.commons.core.configs:
//            e, ConfigNetworkResponse

class d
    implements Runnable
{
    public static interface a
    {

        public abstract void a(ConfigNetworkResponse.ConfigResponse configresponse);

        public abstract void b();
    }


    private static final String a = com/inmobi/commons/core/configs/d.getName();
    private e b;
    private int c;
    private a d;

    public d(a a1, e e1)
    {
        d = a1;
        b = e1;
        c = 0;
    }

    private void a()
        throws InterruptedException
    {
        do
        {
            if (c > b.c())
            {
                break;
            }
            Object obj = (new com.inmobi.commons.core.network.d(b)).a();
            obj = (new ConfigNetworkResponse(b.b(), ((com.inmobi.commons.core.network.c) (obj)))).a();
            Iterator iterator = ((Map) (obj)).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = (java.util.Map.Entry)iterator.next();
                ConfigNetworkResponse.ConfigResponse configresponse = (ConfigNetworkResponse.ConfigResponse)((java.util.Map.Entry) (obj1)).getValue();
                obj1 = (String)((java.util.Map.Entry) (obj1)).getKey();
                if (!configresponse.d())
                {
                    d.a(configresponse);
                    b.a(((String) (obj1)));
                }
            } while (true);
            if (b.b().isEmpty())
            {
                break;
            }
            c = c + 1;
            if (c > b.c())
            {
                Iterator iterator1 = b.b().entrySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    String s = (String)((java.util.Map.Entry)iterator1.next()).getKey();
                    if (((Map) (obj)).containsKey(s))
                    {
                        d.a((ConfigNetworkResponse.ConfigResponse)((Map) (obj)).get(s));
                    }
                } while (true);
                break;
            }
            Thread.sleep(b.d() * 1000);
        } while (true);
        d.b();
    }

    public void run()
    {
        try
        {
            a();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Fetching config interrupted by the component de-initialization.");
        }
    }

}
