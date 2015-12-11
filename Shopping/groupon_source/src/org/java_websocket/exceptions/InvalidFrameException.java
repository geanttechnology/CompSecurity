// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.exceptions;


// Referenced classes of package org.java_websocket.exceptions:
//            InvalidDataException

public class InvalidFrameException extends InvalidDataException
{

    public InvalidFrameException()
    {
        super(1002);
    }

    public InvalidFrameException(String s)
    {
        super(1002, s);
    }

    public InvalidFrameException(Throwable throwable)
    {
        super(1002, throwable);
    }
}
