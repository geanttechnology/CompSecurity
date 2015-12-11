// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.IOException;

public class RuntimeIOException extends RuntimeException
{

    public RuntimeIOException(IOException ioexception)
    {
        super(ioexception);
    }
}
