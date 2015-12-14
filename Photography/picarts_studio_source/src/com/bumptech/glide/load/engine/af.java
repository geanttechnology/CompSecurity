// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.b;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.h;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import myobfuscated.aj.g;

final class af
    implements b
{

    private static final g b = new g(50);
    private final b c;
    private final b d;
    private final int e;
    private final int f;
    private final Class g;
    private final e h;
    private final h i;

    public af(b b1, b b2, int j, int k, h h1, Class class1, e e1)
    {
        c = b1;
        d = b2;
        e = j;
        f = k;
        i = h1;
        g = class1;
        h = e1;
    }

    public final void a(MessageDigest messagedigest)
    {
        byte abyte0[] = ByteBuffer.allocate(8).putInt(e).putInt(f).array();
        d.a(messagedigest);
        c.a(messagedigest);
        messagedigest.update(abyte0);
        if (i != null)
        {
            i.a(messagedigest);
        }
        h.a(messagedigest);
        byte abyte1[] = (byte[])b.b(g);
        abyte0 = abyte1;
        if (abyte1 == null)
        {
            abyte0 = g.getName().getBytes(a);
            b.b(g, abyte0);
        }
        messagedigest.update(abyte0);
    }

    public final boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (!(obj instanceof af)) goto _L2; else goto _L1
_L1:
        obj = (af)obj;
        flag = flag1;
        if (f != ((af) (obj)).f) goto _L2; else goto _L3
_L3:
        flag = flag1;
        if (e != ((af) (obj)).e) goto _L2; else goto _L4
_L4:
        if (i != null) goto _L6; else goto _L5
_L5:
        flag = flag1;
        if (((af) (obj)).i != null) goto _L2; else goto _L7
_L7:
        flag = flag1;
        if (g.equals(((af) (obj)).g))
        {
            flag = flag1;
            if (c.equals(((af) (obj)).c))
            {
                flag = flag1;
                if (d.equals(((af) (obj)).d))
                {
                    flag = flag1;
                    if (h.equals(((af) (obj)).h))
                    {
                        flag = true;
                    }
                }
            }
        }
_L2:
        return flag;
_L6:
        flag = flag1;
        if (!i.equals(((af) (obj)).i)) goto _L2; else goto _L7
    }

    public final int hashCode()
    {
        int k = ((c.hashCode() * 31 + d.hashCode()) * 31 + e) * 31 + f;
        int j = k;
        if (i != null)
        {
            j = k * 31 + i.hashCode();
        }
        return (j * 31 + g.hashCode()) * 31 + h.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("ResourceCacheKey{sourceKey=")).append(c).append(", signature=").append(d).append(", width=").append(e).append(", height=").append(f).append(", decodedResourceClass=").append(g).append(", transformation='").append(i).append('\'').append(", options=").append(h).append('}').toString();
    }

}
