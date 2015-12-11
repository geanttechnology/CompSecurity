// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package android.support.v7:
//            ace, ado, abo

class ads
{

    private static ace a(ace ace1)
    {
        ace ace2;
        try
        {
            ace2 = new ace(ado.e(a(ado.a((lv.a)ace1.a()))), ace1.b());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            abo.a("Escape URI: unsupported encoding", unsupportedencodingexception);
            return ace1;
        }
        return ace2;
    }

    private static ace a(ace ace1, int i)
    {
        if (!a((lv.a)ace1.a()))
        {
            abo.a("Escaping can only be applied to strings.");
            return ace1;
        }
        switch (i)
        {
        default:
            abo.a((new StringBuilder()).append("Unsupported Value Escaping: ").append(i).toString());
            return ace1;

        case 12: // '\f'
            return a(ace1);
        }
    }

    static transient ace a(ace ace1, int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            ace1 = a(ace1, ai[i]);
        }

        return ace1;
    }

    static String a(String s)
        throws UnsupportedEncodingException
    {
        return URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean a(lv.a a1)
    {
        return ado.e(a1) instanceof String;
    }
}
