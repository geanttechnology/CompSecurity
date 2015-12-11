// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.SparseIntArray;

public final class ctf
{

    private static final SparseIntArray c = new ctg();
    public final int a;
    public final boolean b;

    public ctf(int i, boolean flag)
    {
        a = i;
        b = flag;
    }

    public static int a(int i)
    {
        return c.get(i, -1);
    }

}
