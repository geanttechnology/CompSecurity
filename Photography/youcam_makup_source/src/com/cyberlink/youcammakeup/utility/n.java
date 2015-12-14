// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.Locale;

class n
{

    public final String a;
    private final String b;

    public n(String s, String s1)
    {
        b = s;
        a = s1;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof n)
        {
            obj = (n)obj;
            if ((b != null || ((n) (obj)).b == null) && (b == null || ((n) (obj)).b != null) && (a != null || ((n) (obj)).a == null) && (a == null || ((n) (obj)).a != null) && (b == null || ((n) (obj)).b == null || b.equalsIgnoreCase(((n) (obj)).b)) && (a == null || ((n) (obj)).a == null || a.equalsIgnoreCase(((n) (obj)).a)))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        while (b == null || (new StringBuilder()).append(b.hashCode()).append(a).toString() == null) 
        {
            return 0;
        }
        return a.hashCode();
    }

    public String toString()
    {
        return String.format(Locale.ENGLISH, "MANUFACTURER: %s, MODEL: %s", new Object[] {
            b, a
        });
    }
}
