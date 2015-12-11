// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class qt extends cpj
{

    public static String a(cpj cpj1)
    {
        String s = cpj1.b.c();
        cpj1 = cpj1.b.d();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        if (cpj1 != null)
        {
            stringbuilder.append(":").append(cpj1);
        }
        return stringbuilder.toString();
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof qt))
        {
            return false;
        } else
        {
            obj = (qt)obj;
            return b.equals(((qt) (obj)).b);
        }
    }
}
