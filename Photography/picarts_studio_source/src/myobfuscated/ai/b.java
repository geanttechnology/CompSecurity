// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ai;

import java.security.MessageDigest;
import myobfuscated.f.m;

public final class b
    implements com.bumptech.glide.load.b
{

    private final Object b;

    public b(Object obj)
    {
        b = m.a(obj, "Argument must not be null");
    }

    public final void a(MessageDigest messagedigest)
    {
        messagedigest.update(b.toString().getBytes(a));
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof b)
        {
            obj = (b)obj;
            return b.equals(((b) (obj)).b);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("ObjectKey{object=")).append(b).append('}').toString();
    }
}
