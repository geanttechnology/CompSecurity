// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class StringSignature
    implements Key
{

    private final String signature;

    public StringSignature(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("Signature cannot be null!");
        } else
        {
            signature = s;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (StringSignature)obj;
            return signature.equals(((StringSignature) (obj)).signature);
        }
    }

    public int hashCode()
    {
        return signature.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
        throws UnsupportedEncodingException
    {
        messagedigest.update(signature.getBytes("UTF-8"));
    }
}
