// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.Socket;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            ControllerThreadSocketFactory

public static abstract class 
    implements Runnable
{

    private IOException exception;
    private Socket socket;

    public abstract void doit()
        throws IOException;

    protected Socket getSocket()
    {
        return socket;
    }

    public void run()
    {
        try
        {
            doit();
            return;
        }
        catch (IOException ioexception)
        {
            exception = ioexception;
        }
    }

    protected void setSocket(Socket socket1)
    {
        socket = socket1;
    }


    public ()
    {
    }
}
