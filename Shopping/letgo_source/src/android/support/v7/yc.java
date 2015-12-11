// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package android.support.v7:
//            xu

final class yc
{

    final int a;
    final byte b[];

    int a()
    {
        return 0 + xu.f(a) + b.length;
    }

    void a(xu xu1)
        throws IOException
    {
        xu1.e(a);
        xu1.b(b);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof yc))
            {
                return false;
            }
            obj = (yc)obj;
            if (a != ((yc) (obj)).a || !Arrays.equals(b, ((yc) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (a + 527) * 31 + Arrays.hashCode(b);
    }
}
