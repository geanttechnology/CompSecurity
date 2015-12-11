// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.Map;

// Referenced classes of package com.google.android.gms.tagmanager:
//            aj, di, j, bh

class ac extends aj
{

    private static final String ID;
    private static final String US;
    private static final String UT;
    private static final String UU;
    private static final String UV;

    public ac()
    {
        super(ID, new String[] {
            US
        });
    }

    public boolean iy()
    {
        return true;
    }

    public com.google.android.gms.internal.d.a u(Map map)
    {
        Object obj = (com.google.android.gms.internal.d.a)map.get(US);
        if (obj == null || obj == di.ku())
        {
            return di.ku();
        }
        String s1 = di.j(((com.google.android.gms.internal.d.a) (obj)));
        obj = (com.google.android.gms.internal.d.a)map.get(UU);
        String s;
        byte byte0;
        if (obj == null)
        {
            s = "text";
        } else
        {
            s = di.j(((com.google.android.gms.internal.d.a) (obj)));
        }
        obj = (com.google.android.gms.internal.d.a)map.get(UV);
        if (obj == null)
        {
            obj = "base16";
        } else
        {
            obj = di.j(((com.google.android.gms.internal.d.a) (obj)));
        }
        map = (com.google.android.gms.internal.d.a)map.get(UT);
        if (map != null && di.n(map).booleanValue())
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
        map = j.d(map);
_L6:
        return di.r(map);
_L2:
        if ("base16".equals(s))
        {
            map = j.aX(s1);
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
                bh.t((new StringBuilder()).append("Encode: unknown input format: ").append(s).toString());
                map = di.ku();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                bh.t("Encode: invalid input:");
                return di.ku();
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
        bh.t((new StringBuilder()).append("Encode: unknown output format: ").append(((String) (obj))).toString());
        return di.ku();
        if (true) goto _L8; else goto _L7
_L7:
    }

    static 
    {
        ID = a.aj.toString();
        US = b.bt.toString();
        UT = b.dt.toString();
        UU = b.cS.toString();
        UV = b.dB.toString();
    }
}
