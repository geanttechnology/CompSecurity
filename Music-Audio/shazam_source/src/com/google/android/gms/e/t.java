// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package com.google.android.gms.e:
//            o, cj, cu, aj

final class t extends o
{

    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;

    public t()
    {
        super(b, new String[] {
            c
        });
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj = (com.google.android.gms.d.h.a)map.get(c);
        if (obj == null || obj == com.google.android.gms.e.cj.f())
        {
            return com.google.android.gms.e.cj.f();
        }
        Object obj1 = cj.a(((com.google.android.gms.d.h.a) (obj)));
        obj = (com.google.android.gms.d.h.a)map.get(d);
        if (obj == null)
        {
            obj = "MD5";
        } else
        {
            obj = cj.a(((com.google.android.gms.d.h.a) (obj)));
        }
        map = (com.google.android.gms.d.h.a)map.get(e);
        if (map == null)
        {
            map = "text";
        } else
        {
            map = cj.a(map);
        }
        if ("text".equals(map))
        {
            map = ((String) (obj1)).getBytes();
        } else
        if ("base16".equals(map))
        {
            map = cu.a(((String) (obj1)));
        } else
        {
            aj.a((new StringBuilder("Hash: unknown input format: ")).append(map).toString());
            return com.google.android.gms.e.cj.f();
        }
        try
        {
            obj1 = MessageDigest.getInstance(((String) (obj)));
            ((MessageDigest) (obj1)).update(map);
            map = cj.a(cu.a(((MessageDigest) (obj1)).digest()));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            aj.a((new StringBuilder("Hash: unknown algorithm: ")).append(((String) (obj))).toString());
            return com.google.android.gms.e.cj.f();
        }
        return map;
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.I.toString();
        c = f.p.toString();
        d = f.g.toString();
        e = f.bj.toString();
    }
}
