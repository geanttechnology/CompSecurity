// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.regex.Pattern;

public final class anc
    implements Comparable
{

    public static final anc c = new anc();
    public final String a;
    public final String b;
    private String d;
    private boolean e;

    private anc()
    {
        a = "DEFAULT";
        b = "";
        d = null;
        e = false;
    }

    public anc(String s, String s1)
    {
        a = s;
        String as[] = anb.a().split(s1);
        if (as.length == 0)
        {
            throw new and("Empty rule");
        }
        b = as[0];
        s = null;
        boolean flag = false;
        for (int i = 1; i < as.length;)
        {
            String s2 = as[i].toLowerCase();
            if (s2.equals("rewrite") && i + 1 < as.length)
            {
                s = as[i + 1];
                i += 2;
            } else
            if (s2.equals("block"))
            {
                i++;
                flag = true;
            } else
            {
                throw new and((new StringBuilder("Illegal rule: ")).append(s1).toString());
            }
        }

        d = s;
        e = flag;
    }

    public final String a(String s)
    {
        String s1;
        if (e)
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (d != null)
            {
                return (new StringBuilder()).append(d).append(s.substring(b.length())).toString();
            }
        }
        return s1;
    }

    public final int compareTo(Object obj)
    {
        return ((anc)obj).b.compareTo(b);
    }

}
