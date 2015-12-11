// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package android.support.v7:
//            apt, aqe

static final class nit> extends apt
{

    final Socket a;

    protected void timedOut()
    {
        try
        {
            a.close();
            return;
        }
        catch (Exception exception)
        {
            aqe.a().log(Level.WARNING, (new StringBuilder()).append("Failed to close timed out socket ").append(a).toString(), exception);
        }
    }

    (Socket socket)
    {
        a = socket;
        super();
    }
}
