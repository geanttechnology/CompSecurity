// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;

import java.io.IOException;
import java.net.Socket;

// Referenced classes of package cz.msebera.android.httpclient:
//            HttpConnection

public interface HttpConnectionFactory
{

    public abstract HttpConnection createConnection(Socket socket)
        throws IOException;
}
