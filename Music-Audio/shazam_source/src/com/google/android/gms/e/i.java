// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.util.Base64;
import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, cu, aj

final class i extends o
{

    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;

    public i()
    {
        super(b, new String[] {
            c
        });
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj;
        String s;
        String s1;
        byte byte0;
        obj = (com.google.android.gms.d.h.a)map.get(c);
        if (obj == null || obj == com.google.android.gms.e.cj.f())
        {
            return com.google.android.gms.e.cj.f();
        }
        s1 = cj.a(((com.google.android.gms.d.h.a) (obj)));
        obj = (com.google.android.gms.d.h.a)map.get(e);
        byte byte1;
        if (obj == null)
        {
            s = "text";
        } else
        {
            s = cj.a(((com.google.android.gms.d.h.a) (obj)));
        }
        obj = (com.google.android.gms.d.h.a)map.get(f);
        if (obj == null)
        {
            obj = "base16";
        } else
        {
            obj = cj.a(((com.google.android.gms.d.h.a) (obj)));
        }
        byte1 = 2;
        map = (com.google.android.gms.d.h.a)map.get(d);
        byte0 = byte1;
        if (map != null)
        {
            byte0 = byte1;
            if (cj.d(map).booleanValue())
            {
                byte0 = 3;
            }
        }
        if (!"text".equals(s)) goto _L2; else goto _L1
_L1:
        map = s1.getBytes();
_L8:
        if (!"base16".equals(obj)) goto _L4; else goto _L3
_L3:
        map = cu.a(map);
_L6:
        return cj.a(map);
_L2:
        if ("base16".equals(s))
        {
            map = cu.a(s1);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64".equals(s))
        {
            map = Base64.decode(s1, byte0);
            continue; /* Loop/switch isn't completed */
        }
        if ("base64url".equals(s))
        {
            map = Base64.decode(s1, byte0 | 8);
            continue; /* Loop/switch isn't completed */
        } else
        {
            try
            {
                aj.a((new StringBuilder("Encode: unknown input format: ")).append(s).toString());
                map = com.google.android.gms.e.cj.f();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                aj.a("Encode: invalid input:");
                return com.google.android.gms.e.cj.f();
            }
            return map;
        }
_L4:
        if ("base64".equals(obj))
        {
            map = Base64.encodeToString(map, byte0);
            continue; /* Loop/switch isn't completed */
        }
        if (!"base64url".equals(obj))
        {
            break; /* Loop/switch isn't completed */
        }
        map = Base64.encodeToString(map, byte0 | 8);
        if (true) goto _L6; else goto _L5
_L5:
        aj.a((new StringBuilder("Encode: unknown output format: ")).append(((String) (obj))).toString());
        return com.google.android.gms.e.cj.f();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.G.toString();
        c = f.p.toString();
        d = f.bN.toString();
        e = f.bj.toString();
        f = f.bV.toString();
    }
}
