// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.os.Handler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.io.IOException;
import java.util.HashMap;

// Referenced classes of package com.smule.android.network.managers:
//            ad

public class ac
{

    private static final String a = com/smule/android/network/managers/ac.getName();
    private static ac b;
    private Handler c;

    private ac()
    {
        c = new Handler();
    }

    public static ac a()
    {
        com/smule/android/network/managers/ac;
        JVM INSTR monitorenter ;
        ac ac1;
        if (b == null)
        {
            b = new ac();
        }
        ac1 = b;
        com/smule/android/network/managers/ac;
        JVM INSTR monitorexit ;
        return ac1;
        Exception exception;
        exception;
        throw exception;
    }

    public int a(int i)
    {
        Object obj2;
        Object obj = new HashMap();
        ((HashMap) (obj)).put("rewardType", Integer.valueOf(i));
        obj = new k(m.a, "/v2/store/rewardCoins", l.b, n.c, ((java.util.Map) (obj)), true);
        obj.h = 2;
        obj2 = com.smule.android.network.core.b.a().a(((k) (obj)));
        if (((o) (obj2)).b == 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        com.smule.android.network.core.b.a(((o) (obj2)));
        if (1010 == ((o) (obj2)).b)
        {
            return 0;
        }
        Object obj1;
label0:
        {
            boolean flag;
            try
            {
                obj1 = ((o) (obj2)).h;
                if (i != ad.a.c && i != com.smule.android.network.managers.ad.b.c)
                {
                    break label0;
                }
                flag = ((o) (obj2)).a();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                aa.a(a, "Exception thrown when requesting coin reward:", ((Throwable) (obj1)));
                return -1;
            }
            if (flag)
            {
                i = 1;
            } else
            {
                i = -1;
            }
            return i;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj2 = new ObjectMapper();
        obj1 = (JsonNode)((ObjectMapper) (obj2)).readValue(((String) (obj1)), com/fasterxml/jackson/databind/JsonNode);
        if (!((JsonNode) (obj1)).has("data"))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj1 = ((JsonNode) (obj1)).get("data");
        if (!((JsonNode) (obj1)).has("count"))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        i = ((JsonNode) (obj1)).get("count").intValue();
        return i;
        IOException ioexception;
        ioexception;
        return -1;
    }

}
