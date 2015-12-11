// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package d;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package d:
//            a, q

final class t extends a
{

    private Socket a;

    t(Socket socket)
    {
        a = socket;
        super();
    }

    protected final void timedOut()
    {
        try
        {
            a.close();
            return;
        }
        catch (Exception exception)
        {
            q.a().log(Level.WARNING, (new StringBuilder("Failed to close timed out socket ")).append(a).toString(), exception);
        }
    }
}
