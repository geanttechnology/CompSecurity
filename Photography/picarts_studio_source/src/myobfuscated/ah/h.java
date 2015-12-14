// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ah;

import com.bumptech.glide.load.DataSource;

// Referenced classes of package myobfuscated.ah:
//            g, c, i, j, 
//            e

public final class h
    implements g
{

    private final j a;
    private e b;

    h(j j)
    {
        a = j;
    }

    public final e a(DataSource datasource, boolean flag)
    {
        if (datasource == DataSource.MEMORY_CACHE || !flag)
        {
            return c.b();
        }
        if (b == null)
        {
            b = new i(a);
        }
        return b;
    }
}
