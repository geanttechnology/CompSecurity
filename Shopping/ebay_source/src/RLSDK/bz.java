// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            bx, by

final class bz extends bx
{

    private final by a;
    private int b;

    bz(int i, int j, by by)
    {
        super(i, j);
        a = by;
    }

    final by c()
    {
        return a;
    }

    final int d()
    {
        return b;
    }

    final void e()
    {
        b = b + 1;
    }
}
