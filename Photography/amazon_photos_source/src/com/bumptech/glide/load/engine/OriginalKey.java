// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

class OriginalKey
    implements Key
{

    private final String id;
    private final Key signature;

    public OriginalKey(String s, Key key)
    {
        id = s;
        signature = key;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (OriginalKey)obj;
            if (!id.equals(((OriginalKey) (obj)).id))
            {
                return false;
            }
            if (!signature.equals(((OriginalKey) (obj)).signature))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return id.hashCode() * 31 + signature.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
        throws UnsupportedEncodingException
    {
        messagedigest.update(id.getBytes("UTF-8"));
        signature.updateDiskCacheKey(messagedigest);
    }
}
