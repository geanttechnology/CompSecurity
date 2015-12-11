// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Comparator;

// Referenced classes of package android.support.v7:
//            nb

class a
    implements Comparator
{

    final nb a;

    public int a(String s, String s1)
    {
        return s1.length() - s.length();
    }

    public int compare(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }

    (nb nb1)
    {
        a = nb1;
        super();
    }
}
