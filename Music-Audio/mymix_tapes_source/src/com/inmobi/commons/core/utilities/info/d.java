// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.info;

import com.inmobi.commons.a.b;
import com.inmobi.commons.core.utilities.uid.c;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.commons.core.utilities.info:
//            f

public class d
{

    private static final String a = com/inmobi/commons/core/utilities/info/d.getSimpleName();

    public d()
    {
    }

    public static Map a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("mk-version", com.inmobi.commons.a.b.a());
        int i;
        if (com.inmobi.commons.core.utilities.uid.c.a().m())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        hashmap.put("u-id-adt", String.valueOf(i));
        hashmap.put("ts", b());
        hashmap.put("tz", c());
        hashmap.putAll(f.a().c());
        return hashmap;
    }

    private static String b()
    {
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    private static String c()
    {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(15);
        return String.valueOf(calendar.get(16) + i);
    }

}
