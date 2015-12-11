// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCrypto;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class arc
    implements ara
{

    final are a;
    final MediaDrm b;
    final arg c;
    final arb d;
    final ari e;
    final UUID f;
    int g;
    boolean h;
    int i;
    byte j[];
    private final Handler k;
    private final HashMap l;
    private HandlerThread m;
    private Handler n;
    private MediaCrypto o;
    private Exception p;
    private String q;
    private byte r[];

    public arc(UUID uuid, Looper looper, arb arb, Handler handler, are are)
    {
        this(uuid, looper, arb, null, handler, are);
    }

    private arc(UUID uuid, Looper looper, arb arb, HashMap hashmap, Handler handler, are are)
    {
        f = uuid;
        d = arb;
        l = null;
        k = handler;
        a = are;
        b = new MediaDrm(uuid);
        b.setOnEventListener(new arf(this));
        c = new arg(this, looper);
        e = new ari(this, looper);
        i = 1;
    }

    public final void a()
    {
        int i1 = g - 1;
        g = i1;
        if (i1 == 0)
        {
            i = 1;
            h = false;
            c.removeCallbacksAndMessages(null);
            e.removeCallbacksAndMessages(null);
            n.removeCallbacksAndMessages(null);
            n = null;
            m.quit();
            m = null;
            r = null;
            o = null;
            p = null;
            if (j != null)
            {
                b.closeSession(j);
                j = null;
                return;
            }
        }
    }

    void a(Exception exception)
    {
        if (exception instanceof NotProvisionedException)
        {
            e();
            return;
        } else
        {
            b(exception);
            return;
        }
    }

    public final void a(Map map, String s)
    {
        int i1 = g + 1;
        g = i1;
        if (i1 != 1)
        {
            return;
        }
        if (n == null)
        {
            m = new HandlerThread("DrmRequestHandler");
            m.start();
            n = new arh(this, m.getLooper());
        }
        if (r == null)
        {
            q = s;
            r = (byte[])map.get(f);
            if (r == null)
            {
                map = String.valueOf(f);
                b(new IllegalStateException((new StringBuilder(String.valueOf(map).length() + 29)).append("Media does not support uuid: ").append(map).toString()));
                return;
            }
        }
        i = 2;
        a(true);
    }

    void a(boolean flag)
    {
        try
        {
            j = b.openSession();
            o = new MediaCrypto(f, j);
            i = 3;
            f();
            return;
        }
        catch (NotProvisionedException notprovisionedexception)
        {
            if (flag)
            {
                e();
                return;
            } else
            {
                b(notprovisionedexception);
                return;
            }
        }
        catch (Exception exception)
        {
            b(exception);
        }
    }

    public boolean a(String s)
    {
        if (i != 3 && i != 4)
        {
            throw new IllegalStateException();
        } else
        {
            return o.requiresSecureDecoderComponent(s);
        }
    }

    public final int b()
    {
        return i;
    }

    void b(Exception exception)
    {
        p = exception;
        if (k != null && a != null)
        {
            k.post(new ard(this, exception));
        }
        if (i != 4)
        {
            i = 0;
        }
    }

    public final MediaCrypto c()
    {
        if (i != 3 && i != 4)
        {
            throw new IllegalStateException();
        } else
        {
            return o;
        }
    }

    public final Exception d()
    {
        if (i == 0)
        {
            return p;
        } else
        {
            return null;
        }
    }

    void e()
    {
        if (h)
        {
            return;
        } else
        {
            h = true;
            android.media.MediaDrm.ProvisionRequest provisionrequest = b.getProvisionRequest();
            n.obtainMessage(0, provisionrequest).sendToTarget();
            return;
        }
    }

    void f()
    {
        try
        {
            android.media.MediaDrm.KeyRequest keyrequest = b.getKeyRequest(j, r, q, 1, l);
            n.obtainMessage(1, keyrequest).sendToTarget();
            return;
        }
        catch (NotProvisionedException notprovisionedexception)
        {
            a(notprovisionedexception);
        }
    }
}
