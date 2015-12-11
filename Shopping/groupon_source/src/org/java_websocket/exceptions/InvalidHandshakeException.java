// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.exceptions;


// Referenced classes of package org.java_websocket.exceptions:
//            InvalidDataException

public class InvalidHandshakeException extends InvalidDataException
{

    public InvalidHandshakeException()
    {
        super(1002);
    }

    public InvalidHandshakeException(String s)
    {
        super(1002, s);
    }
}
