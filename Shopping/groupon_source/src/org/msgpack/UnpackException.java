// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;

public class UnpackException extends IOException
{

    public UnpackException()
    {
    }

    public UnpackException(String s)
    {
        super(s);
    }
}
