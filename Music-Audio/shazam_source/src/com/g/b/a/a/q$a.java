// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import com.g.b.n;
import com.g.b.u;
import com.g.b.z;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.g.b.a.a:
//            q

public static final class d
{

    public final z a;
    public final Socket b;
    public final u c;
    public final n d;

    public LSocket(z z, Socket socket)
    {
        a = z;
        b = socket;
        c = null;
        d = null;
    }

    public LSocket(z z, SSLSocket sslsocket, u u, n n)
    {
        a = z;
        b = sslsocket;
        c = u;
        d = n;
    }
}
