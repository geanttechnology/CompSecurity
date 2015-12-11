// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            co, dq, ay, f, 
//            cn, ak, ab

class m
{

    private static final String f = com/amazon/device/ads/m.getSimpleName();
    final ay a;
    final f b;
    final cn c;
    final ak d;
    final ab e;

    public m(ay ay, ab ab, f f1, ak ak)
    {
        a = ay;
        e = ab;
        b = f1;
        c = co.a(f);
        d = ak;
    }

    static String a(String s)
    {
        String s1 = "";
        if (!dq.a("\\A\\s*<![Dd][Oo][Cc][Tt][Yy][Pp][Ee]\\s+[Hh][Tt][Mm][Ll][\\s>]", s))
        {
            s1 = "<!DOCTYPE html>";
        }
        String s2;
        String s3;
        String s4;
        if (!dq.a("<[Hh][Tt][Mm][Ll][\\s>]", s))
        {
            s3 = (new StringBuilder()).append(s1).append("<html>").toString();
            s1 = "</html>";
        } else
        {
            s3 = s1;
            s1 = "";
        }
        s2 = s3;
        if (!dq.a("<[Hh][Ee][Aa][Dd][\\s>]", s))
        {
            s2 = (new StringBuilder()).append(s3).append("<head></head>").toString();
        }
        s4 = s1;
        s3 = s2;
        if (!dq.a("<[Bb][Oo][Dd][Yy][\\s>]", s))
        {
            s3 = (new StringBuilder()).append(s2).append("<body>").toString();
            s4 = (new StringBuilder("</body>")).append(s1).toString();
        }
        return (new StringBuilder()).append(s3).append(s).append(s4).toString();
    }

}
