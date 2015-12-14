// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public final class EmptySignature
    implements Key
{

    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    private EmptySignature()
    {
    }

    public static EmptySignature obtain()
    {
        return EMPTY_KEY;
    }

    public void updateDiskCacheKey(MessageDigest messagedigest)
        throws UnsupportedEncodingException
    {
    }

}
