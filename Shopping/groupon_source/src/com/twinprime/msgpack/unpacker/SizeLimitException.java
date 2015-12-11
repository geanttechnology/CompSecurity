// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import java.io.IOException;

public class SizeLimitException extends IOException
{

    public SizeLimitException(String s)
    {
        super(s);
    }
}
