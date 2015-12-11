// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class jk extends ii
    implements ServiceConnection
{

    static final boolean i = Log.isLoggable("MediaRouteProviderProxy", 3);
    final ComponentName j;
    boolean k;
    jl l;
    private final jp m = new jp(this);
    private final ArrayList n = new ArrayList();
    private boolean o;
    private boolean p;

    public jk(Context context, ComponentName componentname)
    {
        super(context, new il(componentname));
        j = componentname;
    }

    static jp a(jk jk1)
    {
        return jk1.m;
    }

    static void a(jk jk1, jl jl1)
    {
        if (jk1.l == jl1)
        {
            jk1.p = true;
            int j1 = jk1.n.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                ((jo)jk1.n.get(i1)).a(jk1.l);
            }

            jl1 = ((ii) (jk1)).e;
            if (jl1 != null)
            {
                jk1.l.a(jl1);
            }
        }
    }

    static void a(jk jk1, jl jl1, in in1)
    {
        if (jk1.l == jl1)
        {
            if (i)
            {
                (new StringBuilder()).append(jk1).append(": Descriptor changed, descriptor=").append(in1);
            }
            jk1.a(in1);
        }
    }

    static void a(jk jk1, jl jl1, String s)
    {
        if (jk1.l == jl1)
        {
            if (i)
            {
                (new StringBuilder()).append(jk1).append(": Service connection error - ").append(s);
            }
            jk1.e();
        }
    }

    static void a(jk jk1, jo jo1)
    {
        jk1.n.remove(jo1);
        jo1.d();
        jk1.b();
    }

    static void b(jk jk1, jl jl1)
    {
        if (jk1.l == jl1)
        {
            if (i)
            {
                (new StringBuilder()).append(jk1).append(": Service connection died");
            }
            jk1.g();
        }
    }

    static boolean f()
    {
        return i;
    }

    private void g()
    {
        if (l != null)
        {
            a(((in) (null)));
            p = false;
            int j1 = n.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                ((jo)n.get(i1)).d();
            }

            jl jl1 = l;
            jl1.a(2, 0, 0, null, null);
            jl1.b.a.clear();
            jl1.a.getBinder().unlinkToDeath(jl1, 0);
            jl1.h.m.post(new jm(jl1));
            l = null;
        }
    }

    public final im a(String s)
    {
        Object obj = super.g;
        if (obj != null)
        {
            obj = ((in) (obj)).a();
            int j1 = ((List) (obj)).size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                if (((if)((List) (obj)).get(i1)).a().equals(s))
                {
                    s = new jo(this, s);
                    n.add(s);
                    if (p)
                    {
                        s.a(l);
                    }
                    b();
                    return s;
                }
            }

        }
        return null;
    }

    public final void a()
    {
        if (!k)
        {
            if (i)
            {
                (new StringBuilder()).append(this).append(": Starting");
            }
            k = true;
            b();
        }
    }

    void b()
    {
        if (c())
        {
            d();
            return;
        } else
        {
            e();
            return;
        }
    }

    public final void b(ih ih)
    {
        if (p)
        {
            l.a(ih);
        }
        b();
    }

    boolean c()
    {
        while (k && (super.e != null || !n.isEmpty())) 
        {
            return true;
        }
        return false;
    }

    void d()
    {
        Intent intent;
        if (o)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (i)
        {
            (new StringBuilder()).append(this).append(": Binding");
        }
        intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(j);
        o = super.a.bindService(intent, this, 1);
        if (!o && i)
        {
            (new StringBuilder()).append(this).append(": Bind failed");
        }
_L1:
        return;
        SecurityException securityexception;
        securityexception;
        if (i)
        {
            (new StringBuilder()).append(this).append(": Bind failed");
            return;
        }
          goto _L1
    }

    void e()
    {
        if (o)
        {
            if (i)
            {
                (new StringBuilder()).append(this).append(": Unbinding");
            }
            o = false;
            g();
            super.a.unbindService(this);
        }
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (i)
        {
            (new StringBuilder()).append(this).append(": Connected");
        }
        if (!o) goto _L2; else goto _L1
_L1:
        g();
        if (ibinder != null)
        {
            componentname = new Messenger(ibinder);
        } else
        {
            componentname = null;
        }
        if (!r.a(componentname))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        componentname = new jl(this, componentname);
        if (!componentname.a()) goto _L4; else goto _L3
_L3:
        l = componentname;
_L2:
        return;
_L4:
        if (!i) goto _L2; else goto _L5
_L5:
        (new StringBuilder()).append(this).append(": Registration failed");
        return;
        Log.e("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Service returned invalid messenger binder").toString());
        return;
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        if (i)
        {
            (new StringBuilder()).append(this).append(": Service disconnected");
        }
        g();
    }

    public final String toString()
    {
        return (new StringBuilder("Service connection ")).append(j.flattenToShortString()).toString();
    }

}
