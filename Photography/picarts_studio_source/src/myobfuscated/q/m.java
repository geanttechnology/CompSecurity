// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import myobfuscated.s.j;

// Referenced classes of package myobfuscated.q:
//            d

public final class m
    implements d
{

    private final RecyclableBufferedInputStream a;

    m(InputStream inputstream, j j)
    {
        a = new RecyclableBufferedInputStream(inputstream, j);
        a.mark(0x500000);
    }

    public final Object a()
    {
        a.reset();
        return a;
    }

    public final void b()
    {
        a.b();
    }
}
