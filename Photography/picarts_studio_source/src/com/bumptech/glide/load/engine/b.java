// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import java.security.MessageDigest;

final class b
    implements com.bumptech.glide.load.b
{

    private final com.bumptech.glide.load.b b;
    private final com.bumptech.glide.load.b c;

    public b(com.bumptech.glide.load.b b1, com.bumptech.glide.load.b b2)
    {
        b = b1;
        c = b2;
    }

    public final void a(MessageDigest messagedigest)
    {
        b.a(messagedigest);
        c.a(messagedigest);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof b)
        {
            obj = (b)obj;
            flag = flag1;
            if (b.equals(((b) (obj)).b))
            {
                flag = flag1;
                if (c.equals(((b) (obj)).c))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return b.hashCode() * 31 + c.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("DataCacheKey{sourceKey=")).append(b).append(", signature=").append(c).append('}').toString();
    }
}
