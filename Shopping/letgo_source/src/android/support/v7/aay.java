// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            adz, abo

class aay extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;

    public aay()
    {
        super(a, new String[] {
            b
        });
    }

    private byte[] a(String s, byte abyte0[])
        throws NoSuchAlgorithmException
    {
        s = MessageDigest.getInstance(s);
        s.update(abyte0);
        return s.digest();
    }

    public lv.a a(Map map)
    {
        Object obj = (lv.a)map.get(b);
        if (obj == null || obj == ado.f())
        {
            return ado.f();
        }
        String s = ado.a(((lv.a) (obj)));
        obj = (lv.a)map.get(c);
        if (obj == null)
        {
            obj = "MD5";
        } else
        {
            obj = ado.a(((lv.a) (obj)));
        }
        map = (lv.a)map.get(d);
        if (map == null)
        {
            map = "text";
        } else
        {
            map = ado.a(map);
        }
        if ("text".equals(map))
        {
            map = s.getBytes();
        } else
        if ("base16".equals(map))
        {
            map = adz.a(s);
        } else
        {
            abo.a((new StringBuilder()).append("Hash: unknown input format: ").append(map).toString());
            return ado.f();
        }
        try
        {
            map = ado.e(adz.a(a(((String) (obj)), ((byte []) (map)))));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            abo.a((new StringBuilder()).append("Hash: unknown algorithm: ").append(((String) (obj))).toString());
            return ado.f();
        }
        return map;
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.I.toString();
        b = lt.p.toString();
        c = lt.g.toString();
        d = lt.bj.toString();
    }
}
