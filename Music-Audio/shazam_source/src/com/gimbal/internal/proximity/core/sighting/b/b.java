// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting.b;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.f.e;
import com.gimbal.internal.proximity.core.g.a;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.g;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.util.Map;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting.b:
//            d

public class b
    implements d
{

    private static final com.gimbal.a.a a = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/b/b.getSimpleName());
    private a b;
    private g c;
    private Map d;

    public b(g g1, a a1, Map map)
    {
        b = a1;
        c = g1;
        d = map;
    }

    public final boolean a(Sighting sighting)
    {
        String s = com.gimbal.internal.c.c.d(sighting.getPayload());
        a a1 = b;
        Object obj1 = com.gimbal.internal.proximity.core.g.b.a();
        Object obj2 = com.gimbal.internal.proximity.core.g.b.a(s);
        obj1 = (String)((com.gimbal.internal.proximity.core.g.b) (obj1)).a.a(((String) (obj2)), java/lang/String);
        obj2 = (TransmitterInternal)a1.a.a(((String) (obj1)), com/gimbal/internal/proximity/impl/TransmitterInternal);
        if (obj2 != null)
        {
            d.put(((TransmitterInternal) (obj2)).getIdentifier(), sighting.getPayload());
            com.gimbal.internal.proximity.core.g.c c1 = com.gimbal.internal.proximity.core.g.c.a();
            byte abyte0[] = (byte[])c1.b.get(s);
            Object obj = abyte0;
            if (abyte0 == null)
            {
                obj = com.gimbal.internal.c.c.a(s);
                String s1 = (String)c1.a.a(((String) (obj)), java/lang/String);
                obj = abyte0;
                if (s1 != null)
                {
                    obj = abyte0;
                    if (!s1.contentEquals("null"))
                    {
                        obj = com.gimbal.internal.c.c.b(s1);
                        c1.b.put(s, obj);
                    }
                }
            }
            if (obj != null)
            {
                sighting.getPayload();
                byte abyte1[] = com.gimbal.internal.c.c.b(sighting.getGen4MaskedData());
                int i = abyte1[0];
                i = ((obj[0] ^ i) & 0xff) - 70;
                int j = abyte1[1];
                j = (obj[1] ^ j) >> 6 & 3;
                sighting.setTemperature(i);
                sighting.setBatteryLevel(j);
                ((TransmitterInternal) (obj2)).setTemperature(Integer.valueOf(i));
                ((TransmitterInternal) (obj2)).setBattery(Integer.valueOf(j));
                c.a(sighting, ((TransmitterInternal) (obj2)));
            } else
            {
                ((TransmitterInternal) (obj2)).setBattery(Integer.valueOf(sighting.getBatteryLevel()));
                ((TransmitterInternal) (obj2)).setTemperature(Integer.valueOf(sighting.getTemperature()));
                c.a(sighting, ((TransmitterInternal) (obj2)));
            }
            return true;
        } else
        {
            return false;
        }
    }

}
