// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.gimbal.internal.a.a.b;
import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.d.a;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            n, c, b

public abstract class h
    implements b
{

    private static com.gimbal.a.a d = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/c/h.getName());
    private static com.gimbal.a.b e = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/core/c/h.getName());
    n a;
    final com.gimbal.internal.proximity.core.sighting.c b;
    ExecutorService c;
    private final com.gimbal.internal.proximity.core.c.c f;
    private Context g;

    public h(Context context, com.gimbal.internal.proximity.core.c.c c1, n n, com.gimbal.internal.proximity.core.sighting.c c2)
    {
        f = c1;
        a = n;
        b = c2;
        g = context;
    }

    static com.gimbal.internal.proximity.core.c.c a(h h1)
    {
        return h1.f;
    }

    static com.gimbal.a.a i()
    {
        return d;
    }

    public final Runnable a(int j, byte abyte0[])
    {
        return new Runnable(abyte0, j) {

            private byte a[];
            private int b;
            private h c;

            public final void run()
            {
                Object obj = com.gimbal.internal.proximity.core.c.h.a(c).a(a);
                if (obj != null)
                {
                    static final class _cls2
                    {

                        static final int a[];

                        static 
                        {
                            a = new int[com.gimbal.internal.proximity.core.c.c.a.values().length];
                            try
                            {
                                a[com.gimbal.internal.proximity.core.c.c.a.a.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror) { }
                        }
                    }

                    h h1;
                    switch (com.gimbal.internal.proximity.core.c._cls2.a[((com.gimbal.internal.proximity.core.c.b) (obj)).a.ordinal()])
                    {
                    default:
                        h.i();
                        return;

                    case 1: // '\001'
                        h1 = c;
                        break;
                    }
                    int k = b;
                    obj = ((com.gimbal.internal.proximity.core.c.b) (obj)).b;
                    obj = h1.b.a(((j) (obj)), k);
                    h1.a.a.a(((com.gimbal.internal.proximity.core.sighting.Sighting) (obj)));
                    return;
                } else
                {
                    h.i();
                    return;
                }
            }

            
            {
                c = h.this;
                a = abyte0;
                b = j;
                super();
            }
        };
    }

    public abstract void c();

    public abstract void d();

    public boolean e()
    {
        BluetoothAdapter bluetoothadapter = h();
        if (bluetoothadapter != null)
        {
            return bluetoothadapter.isEnabled();
        } else
        {
            return false;
        }
    }

    public final ExecutorService f()
    {
        if (c == null)
        {
            c = com.gimbal.internal.proximity.core.d.a.a("Sightings");
        }
        return c;
    }

    public final void g()
    {
        if (c != null && !c.isShutdown())
        {
            c.shutdownNow();
            c = null;
        }
    }

    public final BluetoothAdapter h()
    {
        Object obj = (BluetoothManager)g.getSystemService("bluetooth");
        if (obj == null)
        {
            e.d("Unable to initialize BluetoothManager.", new Object[0]);
            obj = null;
        } else
        {
            BluetoothAdapter bluetoothadapter = ((BluetoothManager) (obj)).getAdapter();
            obj = bluetoothadapter;
            if (bluetoothadapter == null)
            {
                e.d("Unable to initialize BluetoothManager.", new Object[0]);
                return null;
            }
        }
        return ((BluetoothAdapter) (obj));
    }

}
