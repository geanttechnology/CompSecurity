// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.google.android.gms.e:
//            az, cj, aj

final class cn
{

    private static az a(az az1)
    {
        az az2;
        try
        {
            az2 = new az(cj.a(a(cj.a((com.google.android.gms.d.h.a)az1.a))), az1.b);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            aj.a("Escape URI: unsupported encoding", unsupportedencodingexception);
            return az1;
        }
        return az2;
    }

    static transient az a(az az1, int ai[])
    {
        int i;
        int j;
        j = ai.length;
        i = 0;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        int k = ai[i];
        if (cj.e((com.google.android.gms.d.h.a)az1.a) instanceof String) goto _L4; else goto _L3
_L3:
        aj.a("Escaping can only be applied to strings.");
_L7:
        i++;
          goto _L5
_L4:
        switch (k)
        {
        default:
            aj.a((new StringBuilder("Unsupported Value Escaping: ")).append(k).toString());
            break;

        case 12: // '\f'
            az1 = a(az1);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        return az1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static String a(String s)
    {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
    }
}
