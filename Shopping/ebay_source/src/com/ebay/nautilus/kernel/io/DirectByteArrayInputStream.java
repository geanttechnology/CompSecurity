// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.io;

import java.io.ByteArrayInputStream;

public class DirectByteArrayInputStream extends ByteArrayInputStream
{

    public DirectByteArrayInputStream(byte abyte0[])
    {
        super(abyte0);
    }

    public byte[] bytesByReference()
    {
        return super.buf;
    }
}
