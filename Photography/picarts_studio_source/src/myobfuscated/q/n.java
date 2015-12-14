// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import java.io.InputStream;
import myobfuscated.s.j;

// Referenced classes of package myobfuscated.q:
//            e, m, d

public final class n
    implements e
{

    private final j a;

    public n(j j)
    {
        a = j;
    }

    public final Class a()
    {
        return java/io/InputStream;
    }

    public final d a(Object obj)
    {
        return new m((InputStream)obj, a);
    }
}
