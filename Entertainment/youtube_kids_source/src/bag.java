// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

final class bag
    implements avs
{

    private String a;
    private LinkedBlockingQueue b;
    private baf c;

    bag(baf baf1, String s, LinkedBlockingQueue linkedblockingqueue)
    {
        c = baf1;
        a = s;
        b = linkedblockingqueue;
        super();
    }

    public final void a()
    {
        try
        {
            ban ban1 = ((baq)c.i()).a();
            baj baj1 = new baj(ban1, c);
            ban1.a(a);
            b.put(baj1);
            return;
        }
        catch (Exception exception)
        {
            Log.e("DGClientImpl", "Unexpected exception.", exception);
            try
            {
                b.put(new bai(exception.toString()));
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }
    }

    public final void b()
    {
        try
        {
            b.put(new bai("Disconnected."));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }
}
