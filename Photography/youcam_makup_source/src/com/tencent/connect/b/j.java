// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import java.util.HashMap;

// Referenced classes of package com.tencent.connect.b:
//            k

public class j
{

    public static j a;
    static final boolean d;
    private static int e = 0;
    public HashMap b;
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public j()
    {
        b = new HashMap();
    }

    public static j a()
    {
        if (a == null)
        {
            a = new j();
        }
        return a;
    }

    public static int b()
    {
        int i = e + 1;
        e = i;
        return i;
    }

    private String b(String s, String s1)
    {
        int i = 0;
        if (!d && s.length() % 2 != 0)
        {
            throw new AssertionError();
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = s1.length();
        int j1 = s.length() / 2;
        int l = 0;
        for (; i < j1; i++)
        {
            stringbuilder.append((char)(Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16) ^ s1.charAt(l)));
            l = (l + 1) % i1;
        }

        return stringbuilder.toString();
    }

    public k a(String s)
    {
        return (k)b.get(s);
    }

    public String a(k k1)
    {
        int i = b();
        try
        {
            b.put((new StringBuilder()).append("").append(i).toString(), k1);
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            k1.printStackTrace();
        }
        return (new StringBuilder()).append("").append(i).toString();
    }

    public String a(String s, String s1)
    {
        return b(s, s1);
    }

    public void b(String s)
    {
        b.remove(s);
    }

    public String c()
    {
        int l = (int)Math.ceil(Math.random() * 20D + 3D);
        char ac[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int i1 = ac.length;
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < l; i++)
        {
            stringbuffer.append(ac[(int)(Math.random() * (double)i1)]);
        }

        return stringbuffer.toString();
    }

    static 
    {
        boolean flag;
        if (!com/tencent/connect/b/j.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }
}
