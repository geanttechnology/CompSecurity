// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class ir
{

    static iu a;
    private static final boolean d = Log.isLoggable("MediaRouter", 3);
    final Context b;
    final ArrayList c = new ArrayList();

    ir(Context context)
    {
        b = context;
    }

    public static ir a(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        d();
        if (a == null)
        {
            Object obj = new iu(context.getApplicationContext());
            a = ((iu) (obj));
            obj.h = new jr(((iu) (obj)).a, ((ju) (obj)));
            obj = ((iu) (obj)).h;
            if (!((jr) (obj)).c)
            {
                obj.c = true;
                IntentFilter intentfilter = new IntentFilter();
                intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
                intentfilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentfilter.addAction("android.intent.action.PACKAGE_RESTARTED");
                intentfilter.addDataScheme("package");
                ((jr) (obj)).a.registerReceiver(((jr) (obj)).d, intentfilter, null, ((jr) (obj)).b);
                ((jr) (obj)).b.post(((jr) (obj)).e);
            }
        }
        return a.a(context);
    }

    public static List a()
    {
        d();
        return a.c;
    }

    public static void a(ii ii)
    {
        if (ii == null)
        {
            throw new IllegalArgumentException("providerInstance must not be null");
        }
        d();
        if (d)
        {
            (new StringBuilder("addProvider: ")).append(ii);
        }
        a.a(ii);
    }

    public static void a(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("remoteControlClient must not be null");
        }
        d();
        if (d)
        {
            (new StringBuilder("addRemoteControlClient: ")).append(obj);
        }
        iu iu1 = a;
        if (iu1.a(obj) < 0)
        {
            obj = new ix(iu1, obj);
            iu1.e.add(obj);
        }
    }

    public static boolean a(ip ip1, int i)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        } else
        {
            d();
            return a.a(ip1, i);
        }
    }

    static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj1 != null && obj.equals(obj1);
    }

    private int b(is is)
    {
        int j = c.size();
        for (int i = 0; i < j; i++)
        {
            if (((it)c.get(i)).b == is)
            {
                return i;
            }
        }

        return -1;
    }

    public static iz b()
    {
        d();
        return a.a();
    }

    public static void b(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("remoteControlClient must not be null");
        }
        if (d)
        {
            (new StringBuilder("removeRemoteControlClient: ")).append(obj);
        }
        iu iu1 = a;
        int i = iu1.a(obj);
        if (i >= 0)
        {
            obj = (ix)iu1.e.remove(i);
            obj.b = true;
            ((ix) (obj)).a.b = null;
        }
    }

    public static iz c()
    {
        d();
        return a.b();
    }

    static void d()
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        } else
        {
            return;
        }
    }

    static boolean e()
    {
        return d;
    }

    public final void a(ip ip1, is is, int i)
    {
        boolean flag = true;
        boolean flag1 = false;
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (is == null)
        {
            throw new IllegalArgumentException("callback must not be null");
        }
        d();
        if (d)
        {
            (new StringBuilder("addCallback: selector=")).append(ip1).append(", callback=").append(is).append(", flags=").append(Integer.toHexString(i));
        }
        int j = b(is);
        ip ip2;
        if (j < 0)
        {
            is = new it(this, is);
            c.add(is);
        } else
        {
            is = (it)c.get(j);
        }
        if ((~((it) (is)).d & i) != 0)
        {
            is.d = ((it) (is)).d | i;
            i = 1;
        } else
        {
            i = 0;
        }
        ip2 = ((it) (is)).c;
        if (ip1 != null)
        {
            ip2.b();
            ip1.b();
            flag1 = ip2.b.containsAll(ip1.b);
        }
        if (!flag1)
        {
            is.c = (new iq(((it) (is)).c)).a(ip1).a();
            i = ((flag) ? 1 : 0);
        }
        if (i != 0)
        {
            a.c();
        }
    }

    public final void a(is is)
    {
        if (is == null)
        {
            throw new IllegalArgumentException("callback must not be null");
        }
        d();
        if (d)
        {
            (new StringBuilder("removeCallback: callback=")).append(is);
        }
        int i = b(is);
        if (i >= 0)
        {
            c.remove(i);
            a.c();
        }
    }

}
