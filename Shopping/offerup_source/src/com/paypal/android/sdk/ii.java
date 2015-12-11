// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            kt

public final class ii
{

    public static final kt a = kt.a(":status");
    public static final kt b = kt.a(":method");
    public static final kt c = kt.a(":path");
    public static final kt d = kt.a(":scheme");
    public static final kt e = kt.a(":authority");
    public static final kt f = kt.a(":host");
    public static final kt g = kt.a(":version");
    public final kt h;
    public final kt i;
    final int j;

    public ii(kt kt1, kt kt2)
    {
        h = kt1;
        i = kt2;
        j = kt1.b.length + 32 + kt2.b.length;
    }

    public ii(kt kt1, String s)
    {
        this(kt1, kt.a(s));
    }

    public ii(String s, String s1)
    {
        this(kt.a(s), kt.a(s1));
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ii)
        {
            obj = (ii)obj;
            flag = flag1;
            if (h.equals(((ii) (obj)).h))
            {
                flag = flag1;
                if (i.equals(((ii) (obj)).i))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (h.hashCode() + 527) * 31 + i.hashCode();
    }

    public final String toString()
    {
        return String.format("%s: %s", new Object[] {
            h.a(), i.a()
        });
    }

}
