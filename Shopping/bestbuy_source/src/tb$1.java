// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

class lang.Object
    implements Comparator
{

    final tb a;

    public int a(String s, String s1)
    {
        return s1.length() - s.length();
    }

    public int compare(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }

    >(tb tb1)
    {
        a = tb1;
        super();
    }
}
