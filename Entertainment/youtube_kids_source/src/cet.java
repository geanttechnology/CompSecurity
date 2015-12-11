// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

final class cet extends Thread
{

    private ceq a;

    cet(ceq ceq1, String s)
    {
        a = ceq1;
        super(s);
    }

    public final void run()
    {
        try
        {
            while (ceq.b(a) && !ceq.a(a).get()) 
            {
                ceq.h(a).a(ceq.g(a));
            }
            ceq.f(a).a("Client disconnected, hanging get thread stopped");
            return;
        }
        catch (cfd cfd1)
        {
            ceq.f(a).a("Error on hanging get: server not found.", cfd1);
        }
        catch (InterruptedException interruptedexception)
        {
            ceq.f(a);
            return;
        }
        catch (IOException ioexception)
        {
            ceq.f(a).a("Error on hanging get", ioexception);
        }
        catch (cey cey1)
        {
            ceq.f(a).a("Error on hanging get", cey1);
        }
        catch (cfe cfe1)
        {
            chq chq1 = ceq.f(a);
            int i = cfe1.a;
            chq1.b((new StringBuilder(46)).append("Unexpected response on hanging get ").append(i).toString());
            switch (cfe1.a)
            {
            case 401: 
            case 403: 
                a.a(false);
                return;
            }
        }
        catch (cfc cfc1)
        {
            ceq.f(a).a("Error on hanging get. No network connection: ", cfc1);
        }
        catch (Exception exception)
        {
            ceq.f(a).a("Unexpected exception on hanging get", exception);
        }
        if (!ceq.b(a) || ceq.a(a).get())
        {
            ceq.f(a).a("Client disconnected, hanging get thread stopped");
            return;
        } else
        {
            ceq.i(a);
            return;
        }
    }
}
