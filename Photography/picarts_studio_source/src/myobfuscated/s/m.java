// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import java.util.Arrays;

// Referenced classes of package myobfuscated.s:
//            a

public final class m
    implements a
{

    public m()
    {
    }

    public final volatile int a(Object obj)
    {
        return ((int[])obj).length;
    }

    public final volatile Object a(int i)
    {
        return new int[i];
    }

    public final String a()
    {
        return "IntegerArrayPool";
    }

    public final int b()
    {
        return 4;
    }

    public final void b(Object obj)
    {
        Arrays.fill((int[])obj, 0);
    }
}
