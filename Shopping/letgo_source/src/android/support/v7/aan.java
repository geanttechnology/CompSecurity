// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Base64;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            adz, abo

class aan extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;

    public aan()
    {
        super(a, new String[] {
            b
        });
    }

    public lv.a a(Map map)
    {
        Object obj = (lv.a)map.get(b);
        if (obj == null || obj == ado.f())
        {
            return ado.f();
        }
        String s1 = ado.a(((lv.a) (obj)));
        obj = (lv.a)map.get(d);
        String s;
        byte byte0;
        if (obj == null)
        {
            s = "text";
        } else
        {
            s = ado.a(((lv.a) (obj)));
        }
        obj = (lv.a)map.get(e);
        if (obj == null)
        {
            obj = "base16";
        } else
        {
            obj = ado.a(((lv.a) (obj)));
        }
        map = (lv.a)map.get(c);
        if (map != null && ado.d(map).booleanValue())
        {
            byte0 = 3;
        } else
        {
            byte0 = 2;
        }
        if (!"text".equals(s)) goto _L2; else goto _L1
_L1:
        map = s1.getBytes();
_L8:
        if (!"base16".equals(obj)) goto _L4; else goto _L3
_L3:
        map = adz.a(map);
_L6:
        return ado.e(map);
_L2:
        if ("base16".equals(s))
        {
            map = adz.a(s1);
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
                abo.a((new StringBuilder()).append("Encode: unknown input format: ").append(s).toString());
                map = ado.f();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                abo.a("Encode: invalid input:");
                return ado.f();
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
        abo.a((new StringBuilder()).append("Encode: unknown output format: ").append(((String) (obj))).toString());
        return ado.f();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.G.toString();
        b = lt.p.toString();
        c = lt.bN.toString();
        d = lt.bj.toString();
        e = lt.bV.toString();
    }
}
