// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class asb
{

    private static arf a(arf arf1)
    {
        arf arf2;
        try
        {
            arf2 = new arf(arz.c(a(arz.a((wk)arf1.a()))), arf1.b());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            aqv.a("Escape URI: unsupported encoding", unsupportedencodingexception);
            return arf1;
        }
        return arf2;
    }

    private static arf a(arf arf1, int i)
    {
        if (!a((wk)arf1.a()))
        {
            aqv.a("Escaping can only be applied to strings.");
            return arf1;
        }
        switch (i)
        {
        default:
            aqv.a((new StringBuilder()).append("Unsupported Value Escaping: ").append(i).toString());
            return arf1;

        case 12: // '\f'
            return a(arf1);
        }
    }

    static transient arf a(arf arf1, int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            arf1 = a(arf1, ai[i]);
        }

        return arf1;
    }

    static String a(String s)
    {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean a(wk wk1)
    {
        return arz.c(wk1) instanceof String;
    }
}
