// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface b
{

    public static final Charset a = Charset.forName("UTF-8");

    public abstract void a(MessageDigest messagedigest);

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

}
