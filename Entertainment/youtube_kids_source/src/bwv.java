// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class bwv
    implements Comparable
{

    public final int a;
    public final String b;
    public final boolean c;

    public bwv(int i, bwb bwb1)
    {
        String s = bwb1.a.s;
        if (TextUtils.isEmpty(s))
        {
            s = String.format("%dp", new Object[] {
                Integer.valueOf(i)
            });
        }
        this(i, s, bwb1.d());
    }

    public bwv(int i, String s, boolean flag)
    {
        a = i;
        b = b.a(s);
        c = flag;
    }

    public final int compareTo(Object obj)
    {
        obj = (bwv)obj;
        return a - ((bwv) (obj)).a;
    }
}
