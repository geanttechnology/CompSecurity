// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifFrameLoader

static class uuid
    implements Key
{

    private final UUID uuid;

    public boolean equals(Object obj)
    {
        if (obj instanceof uuid)
        {
            return ((uuid)obj).uuid.equals(uuid);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return uuid.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
        throws UnsupportedEncodingException
    {
        throw new UnsupportedOperationException("Not implemented");
    }

    public ()
    {
        this(UUID.randomUUID());
    }

    <init>(UUID uuid1)
    {
        uuid = uuid1;
    }
}
