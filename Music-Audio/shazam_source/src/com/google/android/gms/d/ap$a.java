// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            ap

public static final class b
{

    final long a;
    final String b;

    public final boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof b) || ((b)obj).a != a) 
        {
            return false;
        }
        return true;
    }

    public final int hashCode()
    {
        return (int)a;
    }

    (long l, String s)
    {
        a = l;
        b = s;
    }
}
