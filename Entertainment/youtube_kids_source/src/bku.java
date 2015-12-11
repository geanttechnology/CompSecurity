// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;

final class bku extends bkv
    implements LayeredSocketFactory
{

    private LayeredSocketFactory a;

    bku(bkt bkt, LayeredSocketFactory layeredsocketfactory)
    {
        super(bkt, layeredsocketfactory);
        a = layeredsocketfactory;
    }

    public final Socket createSocket(Socket socket, String s, int i, boolean flag)
    {
        return a.createSocket(socket, s, i, flag);
    }
}
