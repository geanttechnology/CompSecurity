// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ig;
import com.google.android.gms.internal.il;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class azk extends azu
{

    public AtomicBoolean a;
    final azh b;

    azk(azh azh1)
    {
        b = azh1;
        super();
        a = new AtomicBoolean(false);
    }

    private void b(long l, int i)
    {
        awh awh1;
        synchronized (azh.h(b))
        {
            awh1 = (awh)azh.h(b).remove(Long.valueOf(l));
        }
        if (awh1 != null)
        {
            awh1.a(new Status(i));
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean f(int i)
    {
        Object obj = azh.l();
        obj;
        JVM INSTR monitorenter ;
        if (azh.i(b) == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        azh.i(b).a(new Status(i));
        azh.b(b, null);
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i)
    {
        if (a())
        {
            azh.j().a("ICastDeviceControllerListener.onDisconnected: %d", new Object[] {
                Integer.valueOf(i)
            });
            if (i != 0)
            {
                azh azh1 = b;
                ((axi) (azh1)).b.sendMessage(((axi) (azh1)).b.obtainMessage(4, Integer.valueOf(2)));
                return;
            }
        }
    }

    public final void a(long l)
    {
        if (a.get())
        {
            return;
        } else
        {
            b(l, 0);
            return;
        }
    }

    public final void a(long l, int i)
    {
        if (a.get())
        {
            return;
        } else
        {
            b(l, i);
            return;
        }
    }

    public final void a(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        if (a.get())
        {
            return;
        }
        azh.a(b, applicationmetadata);
        azh.a(b, applicationmetadata.b);
        azh.b(b, s1);
        synchronized (azh.k())
        {
            if (azh.c(b) != null)
            {
                azh.c(b).a(new azi(new Status(0), applicationmetadata, s, s1, flag));
                azh.a(b, null);
            }
        }
        return;
        applicationmetadata;
        obj;
        JVM INSTR monitorexit ;
        throw applicationmetadata;
    }

    public final void a(ig ig)
    {
        if (a.get())
        {
            return;
        } else
        {
            azh.j().a("onApplicationStatusChanged", new Object[0]);
            azh.e(b).post(new azn(this, ig));
            return;
        }
    }

    public final void a(il il)
    {
        if (a.get())
        {
            return;
        } else
        {
            azh.j().a("onDeviceStatusChanged", new Object[0]);
            azh.e(b).post(new azm(this, il));
            return;
        }
    }

    public final void a(String s, String s1)
    {
        if (a.get())
        {
            return;
        } else
        {
            azh.j().a("Receive (type=text, ns=%s) %s", new Object[] {
                s, s1
            });
            azh.e(b).post(new azo(this, s, s1));
            return;
        }
    }

    public final void a(String s, byte abyte0[])
    {
        if (a.get())
        {
            return;
        } else
        {
            azh.j().a("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                s, Integer.valueOf(abyte0.length)
            });
            return;
        }
    }

    public final boolean a()
    {
        if (a.getAndSet(true))
        {
            return false;
        } else
        {
            azh.b(b);
            return true;
        }
    }

    public final void b()
    {
        azh.j().a("Deprecated callback: \"onStatusreceived\"", new Object[0]);
    }

    public final void b(int i)
    {
        if (a.get())
        {
            return;
        }
        synchronized (azh.k())
        {
            if (azh.c(b) != null)
            {
                azh.c(b).a(new azi(new Status(i)));
                azh.a(b, null);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c(int i)
    {
        if (a.get())
        {
            return;
        } else
        {
            f(i);
            return;
        }
    }

    public final void d(int i)
    {
        if (a.get())
        {
            return;
        } else
        {
            f(i);
            return;
        }
    }

    public final void e(int i)
    {
        if (!a.get())
        {
            azh.a(b, null);
            azh.b(b, null);
            f(i);
            if (azh.d(b) != null)
            {
                azh.e(b).post(new azl(this, i));
                return;
            }
        }
    }
}
