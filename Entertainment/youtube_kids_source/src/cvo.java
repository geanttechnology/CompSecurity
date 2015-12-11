// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpException;
import org.apache.http.impl.DefaultHttpServerConnection;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpService;

final class cvo
    implements Runnable
{

    private final Socket a;
    private cvm b;

    public cvo(cvm cvm1, Socket socket)
    {
        b = cvm1;
        super();
        a = socket;
    }

    public final void run()
    {
        Object obj;
        bmo.e("New connection received");
        obj = new DefaultHttpServerConnection();
        ((DefaultHttpServerConnection) (obj)).bind(a, b.a);
        BasicHttpContext basichttpcontext = new BasicHttpContext();
        for (; !Thread.interrupted() && ((DefaultHttpServerConnection) (obj)).isOpen(); b.b.handleRequest(((org.apache.http.HttpServerConnection) (obj)), basichttpcontext)) { }
        break MISSING_BLOCK_LABEL_75;
        Object obj1;
        obj1;
        bmo.e("Connection closed");
        try
        {
            ((DefaultHttpServerConnection) (obj)).shutdown();
            return;
        }
        catch (IOException ioexception1)
        {
            return;
        }
        try
        {
            ((DefaultHttpServerConnection) (obj)).shutdown();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj1;
        if (!(obj1 instanceof SocketException) || !((IOException) (obj1)).getMessage().contains("Connection reset by peer") && !((IOException) (obj1)).getMessage().contains("Socket closed")) goto _L2; else goto _L1
_L1:
        bmo.e("Connection closed");
_L4:
        try
        {
            ((DefaultHttpServerConnection) (obj)).shutdown();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
_L2:
        bmo.a("IOException when handling a request", ((Throwable) (obj1)));
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        IOException ioexception;
        try
        {
            ((DefaultHttpServerConnection) (obj)).shutdown();
        }
        catch (IOException ioexception2) { }
        throw obj1;
        obj1;
        bmo.a("HTTP protocol violation", ((Throwable) (obj1)));
        try
        {
            ((DefaultHttpServerConnection) (obj)).shutdown();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            return;
        }
    }
}
