// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

final class bny
    implements Runnable
{

    private String a;
    private bhw b;
    private bnx c;

    bny(bnx bnx1, String s, bhw bhw1)
    {
        c = bnx1;
        a = s;
        b = bhw1;
        super();
    }

    public final void run()
    {
        try
        {
            String s = atz.a(c.b, a, c.a.c);
            c.c.put(a, s);
            b.a(null, bnz.a(s));
            return;
        }
        catch (Object obj)
        {
            bhw bhw1 = b;
            if (((aub) (obj)).a == null)
            {
                obj = null;
            } else
            {
                obj = new Intent(((aub) (obj)).a);
            }
            bhw1.a(null, new bnz(null, (Intent)b.a(obj), null, false));
            return;
        }
        catch (aty aty1)
        {
            b.a(null, bnz.a(aty1));
            return;
        }
        catch (IOException ioexception)
        {
            b.a(null, new bnz(null, null, (Exception)b.a(ioexception), true));
        }
    }
}
