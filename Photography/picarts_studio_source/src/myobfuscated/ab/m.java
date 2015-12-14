// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import com.bumptech.glide.load.b;
import java.security.MessageDigest;
import java.util.UUID;

final class m
    implements b
{

    private final UUID b;

    public m()
    {
        this(UUID.randomUUID());
    }

    private m(UUID uuid)
    {
        b = uuid;
    }

    public final void a(MessageDigest messagedigest)
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof m)
        {
            return ((m)obj).b.equals(b);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }
}
