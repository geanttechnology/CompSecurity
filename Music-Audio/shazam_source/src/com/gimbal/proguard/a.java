// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.proguard;

import com.gimbal.a.b;
import com.gimbal.internal.c.c;
import com.gimbal.internal.d.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.gimbal.proguard:
//            Keep

public final class a
{

    private static b a = com.gimbal.internal.c.c.f(com/gimbal/internal/d/g.getName());
    private static com.gimbal.a.a b = com.gimbal.internal.c.c.e(com/gimbal/internal/d/g.getName());
    private static Map c = new ConcurrentHashMap();

    public static boolean a(Class class1)
    {
        Boolean boolean1 = (Boolean)c.get(class1);
        if (boolean1 != null)
        {
            return boolean1.booleanValue();
        }
        if (com/gimbal/proguard/Keep.isAssignableFrom(class1))
        {
            c.put(class1, Boolean.valueOf(true));
            return true;
        }
        if (class1.getName().contains(".protocol."))
        {
            c.put(class1, Boolean.valueOf(true));
            return true;
        } else
        {
            a.d("-----     -----     -----     -----     -----     -----     -----     -----     -----     -----     -----", new Object[0]);
            a.d("CLASS (WILL BE) OBFUSCATED: {} - MISSING PRO_GUARD RULES?", new Object[] {
                class1.getName()
            });
            class1.getName();
            c.put(class1, Boolean.valueOf(false));
            return false;
        }
    }

    public static boolean a(Object obj)
    {
        return a(obj.getClass());
    }

}
