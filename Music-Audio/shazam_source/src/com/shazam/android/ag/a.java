// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.shazam.android.ag:
//            b

public final class a
{

    private static final Pattern e = Pattern.compile("(.*?)__(\\d+)[\\.](\\d+)[\\.](\\d+)([^/]*)(?:/(.*))?");
    public String a;
    public String b;
    public b c;
    public String d;
    private String f;

    private a(String s)
    {
        Object obj = e.matcher(s);
        if (!((Matcher) (obj)).matches())
        {
            throw new ParseException((new StringBuilder("AppId not parsable since it doesn't match regex '")).append(e.pattern()).append("': ").append(s).toString(), 0);
        } else
        {
            s = ((Matcher) (obj)).group(1);
            String s1 = ((Matcher) (obj)).group(2);
            String s2 = ((Matcher) (obj)).group(3);
            String s3 = ((Matcher) (obj)).group(4);
            String s4 = ((Matcher) (obj)).group(5);
            obj = ((Matcher) (obj)).group(6);
            f = s;
            d = ((String) (obj));
            c = new b(s1, s2, s3, s4);
            a();
            return;
        }
    }

    public static a a(String s)
    {
        return new a(s);
    }

    public static a b(String s)
    {
        try
        {
            s = new a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("Totally unexpected ParseException - be sure it parses or use tryParse: ", s);
        }
        return s;
    }

    public final void a()
    {
        StringBuilder stringbuilder = new StringBuilder("/");
        String s;
        if (d != null)
        {
            s = d;
        } else
        {
            s = "";
        }
        s = stringbuilder.append(s).toString();
        a = (new StringBuilder()).append(f).append("__").append(c.a()).append(s).toString();
        b = (new StringBuilder()).append(f).append("__").append(c.a).append(s).toString();
    }

    public final void c(String s)
    {
        d = s;
        a();
    }

    public final String toString()
    {
        return (new StringBuilder("AppId{appIdFull='")).append(a).append('\'').append(", appIdFullForServer='").append(b).append('\'').append('}').toString();
    }

}
