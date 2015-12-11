// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import com.g.b.u;
import com.g.b.x;
import java.net.ProtocolException;

public final class s
{

    public final u a;
    public final int b;
    public final String c;

    public s(u u1, int i, String s1)
    {
        a = u1;
        b = i;
        c = s1;
    }

    public static s a(x x1)
    {
        return new s(x1.b, x1.c, x1.d);
    }

    public static s a(String s1)
    {
        byte byte0 = 9;
        Object obj;
        if (s1.startsWith("HTTP/1."))
        {
            if (s1.length() < 9 || s1.charAt(8) != ' ')
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
            }
            int i = s1.charAt(7) - 48;
            if (i == 0)
            {
                obj = u.a;
            } else
            if (i == 1)
            {
                obj = u.b;
            } else
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
            }
        } else
        if (s1.startsWith("ICY "))
        {
            obj = u.a;
            byte0 = 4;
        } else
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
        }
        if (s1.length() < byte0 + 3)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
        }
        int j;
        try
        {
            j = Integer.parseInt(s1.substring(byte0, byte0 + 3));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
        }
        if (s1.length() > byte0 + 3)
        {
            if (s1.charAt(byte0 + 3) != ' ')
            {
                throw new ProtocolException((new StringBuilder("Unexpected status line: ")).append(s1).toString());
            }
            s1 = s1.substring(byte0 + 4);
        } else
        {
            s1 = "";
        }
        return new s(((u) (obj)), j, s1);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        if (a == u.a)
        {
            s1 = "HTTP/1.0";
        } else
        {
            s1 = "HTTP/1.1";
        }
        stringbuilder.append(s1);
        stringbuilder.append(' ').append(b);
        if (c != null)
        {
            stringbuilder.append(' ').append(c);
        }
        return stringbuilder.toString();
    }
}
