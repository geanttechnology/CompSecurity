// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util.a;


public class b
{

    private final String a;
    private final int b;
    private Exception c;

    public b(String s)
    {
        this(s, 5222);
    }

    public b(String s, int i)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("FQDN is null");
        }
        if (i < 0 || i > 65535)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Port must be a 16-bit unsiged integer (i.e. between 0-65535. Port was: ").append(i).toString());
        }
        if (s.charAt(s.length() - 1) == '.')
        {
            a = s.substring(0, s.length() - 1);
        } else
        {
            a = s;
        }
        b = i;
    }

    public String a()
    {
        return a;
    }

    public void a(Exception exception)
    {
        c = exception;
    }

    public int b()
    {
        return b;
    }

    public String c()
    {
        String s;
        if (c == null)
        {
            s = "No error logged";
        } else
        {
            s = c.getMessage();
        }
        return (new StringBuilder()).append(toString()).append(" Exception: ").append(s).toString();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof b))
            {
                return false;
            }
            obj = (b)obj;
            if (!a.equals(((b) (obj)).a))
            {
                return false;
            }
            if (b != ((b) (obj)).b)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (a.hashCode() + 37) * 37 + b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(":").append(b).toString();
    }
}
