// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Scanner;

public class jf
{

    private String a;
    private String b;
    private String c;
    private String d;

    public jf(String s, String s1, String s2)
    {
        c = s;
        b = s1;
        a = s2;
    }

    public jf(char ac[])
    {
        ac = new Scanner(new String(ac));
        do
        {
            if (!ac.hasNextLine())
            {
                break;
            }
            String s = ac.nextLine();
            if (s.startsWith("url="))
            {
                c = s.substring("url=".length()).trim();
            } else
            if (s.startsWith("version="))
            {
                a = s.substring("version=".length()).trim();
            } else
            if (s.startsWith("data="))
            {
                b = s.substring("data=".length()).trim();
            }
        } while (true);
        ac.close();
    }

    public String a()
    {
        return a;
    }

    public void a(String s)
    {
        d = s;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }
}
