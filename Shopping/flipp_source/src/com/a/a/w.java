// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

// Referenced classes of package com.a.a:
//            v

public final class w
{

    private final Set a = new LinkedHashSet();

    public w()
    {
    }

    public final void a(v v1)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(v1);
        this;
        JVM INSTR monitorexit ;
        return;
        v1;
        throw v1;
    }

    public final void a(v v1, IOException ioexception)
    {
        this;
        JVM INSTR monitorenter ;
        a a1;
        java.net.Proxy proxy;
        java.net.InetSocketAddress inetsocketaddress;
        a.add(v1);
        if (ioexception instanceof SSLHandshakeException)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        ioexception = a;
        a1 = v1.a;
        proxy = v1.b;
        inetsocketaddress = v1.c;
        boolean flag;
        if (!v1.d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ioexception.add(new v(a1, proxy, inetsocketaddress, flag));
        this;
        JVM INSTR monitorexit ;
        return;
        v1;
        throw v1;
    }

    public final boolean b(v v1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.contains(v1);
        this;
        JVM INSTR monitorexit ;
        return flag;
        v1;
        throw v1;
    }
}
