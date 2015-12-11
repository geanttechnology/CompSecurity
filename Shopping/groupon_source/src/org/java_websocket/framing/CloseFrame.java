// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.framing;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

// Referenced classes of package org.java_websocket.framing:
//            Framedata

public interface CloseFrame
    extends Framedata
{

    public abstract int getCloseCode()
        throws InvalidFrameException;

    public abstract String getMessage()
        throws InvalidDataException;
}
