// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.exceptions;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.io.IOException;

public class CimIOException extends CimException
{

    public CimIOException()
    {
    }

    public CimIOException(IOException ioexception)
    {
        super(ioexception);
    }

    public CimIOException(String s)
    {
        super(s);
    }

    public CimIOException(String s, IOException ioexception)
    {
        super(s, ioexception);
    }
}
