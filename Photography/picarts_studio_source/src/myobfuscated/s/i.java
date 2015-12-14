// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import java.util.Arrays;

// Referenced classes of package myobfuscated.s:
//            a

public final class i
    implements a
{

    public i()
    {
    }

    public final volatile int a(Object obj)
    {
        return ((byte[])obj).length;
    }

    public final volatile Object a(int j)
    {
        return new byte[j];
    }

    public final String a()
    {
        return "ByteArrayPool";
    }

    public final int b()
    {
        return 1;
    }

    public final void b(Object obj)
    {
        Arrays.fill((byte[])obj, (byte)0);
    }
}
