// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.MediaRouter;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

class kc extends kb
    implements ja, je
{

    private static final ArrayList o;
    private static final ArrayList p;
    public final Object i;
    public final Object j = c();
    public int k;
    public boolean l;
    public boolean m;
    public final ArrayList n = new ArrayList();
    private final kl q;
    private Object r;
    private Object s;
    private ArrayList t;
    private jd u;
    private jc v;

    public kc(Context context, kl kl1)
    {
        super(context);
        t = new ArrayList();
        q = kl1;
        i = context.getSystemService("media_router");
        r = a.a(this);
        context = context.getResources();
        s = a.a(i, context.getString(0x7f0b0166), false);
        e();
    }

    private void a(ke ke1)
    {
        ig ig1 = new ig(ke1.b, j(ke1.a));
        a(ke1, ig1);
        ke1.c = ig1.a();
    }

    private int b(String s1)
    {
        int j1 = n.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((ke)n.get(i1)).b.equals(s1))
            {
                return i1;
            }
        }

        return -1;
    }

    private int e(iz iz1)
    {
        int j1 = t.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((kf)t.get(i1)).a == iz1)
            {
                return i1;
            }
        }

        return -1;
    }

    private void e()
    {
        Object obj = (MediaRouter)i;
        int j1 = ((MediaRouter) (obj)).getRouteCount();
        ArrayList arraylist = new ArrayList(j1);
        for (int i1 = 0; i1 < j1; i1++)
        {
            arraylist.add(((MediaRouter) (obj)).getRouteAt(i1));
        }

        obj = arraylist.iterator();
        boolean flag;
        for (flag = false; ((Iterator) (obj)).hasNext(); flag |= f(((Iterator) (obj)).next())) { }
        if (flag)
        {
            a();
        }
    }

    private boolean f(Object obj)
    {
        if (i(obj) != null || g(obj) >= 0) goto _L2; else goto _L1
_L1:
        String s1;
        boolean flag;
        if (d() == obj)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s1 = "DEFAULT_ROUTE";
        } else
        {
            s1 = String.format(Locale.US, "ROUTE_%08x", new Object[] {
                Integer.valueOf(j(obj).hashCode())
            });
        }
        if (b(s1) >= 0) goto _L4; else goto _L3
_L3:
        obj = new ke(obj, s1);
        a(((ke) (obj)));
        n.add(obj);
        return true;
_L4:
        int i1 = 2;
        do
        {
            String s2 = String.format(Locale.US, "%s_%d", new Object[] {
                s1, Integer.valueOf(i1)
            });
            if (b(s2) < 0)
            {
                s1 = s2;
                continue; /* Loop/switch isn't completed */
            }
            i1++;
        } while (true);
_L2:
        return false;
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static kf i(Object obj)
    {
        obj = ((android.media.MediaRouter.RouteInfo)obj).getTag();
        if (obj instanceof kf)
        {
            return (kf)obj;
        } else
        {
            return null;
        }
    }

    private String j(Object obj)
    {
        Context context = super.a;
        obj = ((android.media.MediaRouter.RouteInfo)obj).getName(context);
        if (obj != null)
        {
            return ((CharSequence) (obj)).toString();
        } else
        {
            return "";
        }
    }

    public final im a(String s1)
    {
        int i1 = b(s1);
        if (i1 >= 0)
        {
            return new kd(this, ((ke)n.get(i1)).a);
        } else
        {
            return null;
        }
    }

    protected final void a()
    {
        io io1 = new io();
        int j1 = n.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            io1.a(((ke)n.get(i1)).c);
        }

        a(io1.a());
    }

    public final void a(iz iz1)
    {
        if (iz1.d() != this)
        {
            Object obj = a.b(i, s);
            iz1 = new kf(iz1, obj);
            a.c(obj, iz1);
            a.d(obj, r);
            a(((kf) (iz1)));
            t.add(iz1);
            ((MediaRouter)i).addUserRoute((android.media.MediaRouter.UserRouteInfo)obj);
        } else
        {
            int i1 = g(a.a(i, 0x800003));
            if (i1 >= 0 && ((ke)n.get(i1)).b.equals(iz1.a))
            {
                iz1.c();
                return;
            }
        }
    }

    public final void a(Object obj)
    {
        if (obj == a.a(i, 0x800003))
        {
            kf kf1 = i(obj);
            if (kf1 != null)
            {
                kf1.a.c();
                return;
            }
            int i1 = g(obj);
            if (i1 >= 0)
            {
                obj = (ke)n.get(i1);
                obj = q.a(((ke) (obj)).b);
                if (obj != null)
                {
                    ((iz) (obj)).c();
                    return;
                }
            }
        }
    }

    public final void a(Object obj, int i1)
    {
        obj = i(obj);
        if (obj != null)
        {
            ((kf) (obj)).a.a(i1);
        }
    }

    protected void a(ke ke1, ig ig1)
    {
        int i1 = ((android.media.MediaRouter.RouteInfo)ke1.a).getSupportedTypes();
        if ((i1 & 1) != 0)
        {
            ig1.a(o);
        }
        if ((i1 & 2) != 0)
        {
            ig1.a(p);
        }
        ig1.a(((android.media.MediaRouter.RouteInfo)ke1.a).getPlaybackType());
        ig1.b(((android.media.MediaRouter.RouteInfo)ke1.a).getPlaybackStream());
        ig1.c(((android.media.MediaRouter.RouteInfo)ke1.a).getVolume());
        ig1.d(((android.media.MediaRouter.RouteInfo)ke1.a).getVolumeMax());
        ig1.e(((android.media.MediaRouter.RouteInfo)ke1.a).getVolumeHandling());
    }

    protected void a(kf kf1)
    {
        Object obj = kf1.b;
        String s1 = kf1.a.c;
        ((android.media.MediaRouter.UserRouteInfo)obj).setName(s1);
        a.b(kf1.b, kf1.a.h);
        a.c(kf1.b, kf1.a.i);
        a.d(kf1.b, kf1.a.k);
        a.e(kf1.b, kf1.a.l);
        a.f(kf1.b, kf1.a.j);
    }

    protected void b()
    {
        if (m)
        {
            m = false;
            a.a(i, j);
        }
        if (k != 0)
        {
            m = true;
            Object obj = i;
            int i1 = k;
            Object obj1 = j;
            ((MediaRouter)obj).addCallback(i1, (android.media.MediaRouter.Callback)obj1);
        }
    }

    public final void b(ih ih1)
    {
        boolean flag = false;
        int i1;
        if (ih1 != null)
        {
            List list = ih1.a().a();
            int k1 = list.size();
            int j1 = 0;
            i1 = 0;
            while (j1 < k1) 
            {
                String s1 = (String)list.get(j1);
                if (s1.equals("android.media.intent.category.LIVE_AUDIO"))
                {
                    i1 |= 1;
                } else
                if (s1.equals("android.media.intent.category.LIVE_VIDEO"))
                {
                    i1 |= 2;
                } else
                {
                    i1 = 0x800000 | i1;
                }
                j1++;
            }
            flag = ih1.b();
        } else
        {
            i1 = 0;
        }
        if (k != i1 || l != flag)
        {
            k = i1;
            l = flag;
            b();
            e();
        }
    }

    public final void b(iz iz1)
    {
        if (iz1.d() != this)
        {
            int i1 = e(iz1);
            if (i1 >= 0)
            {
                Object obj = (kf)t.remove(i1);
                a.c(((kf) (obj)).b, null);
                a.d(((kf) (obj)).b, null);
                iz1 = ((iz) (i));
                obj = ((kf) (obj)).b;
                ((MediaRouter)iz1).removeUserRoute((android.media.MediaRouter.UserRouteInfo)obj);
            }
        }
    }

    public final void b(Object obj)
    {
        if (f(obj))
        {
            a();
        }
    }

    public final void b(Object obj, int i1)
    {
        obj = i(obj);
        if (obj != null)
        {
            ((kf) (obj)).a.b(i1);
        }
    }

    protected Object c()
    {
        return new jb(this);
    }

    public final void c(iz iz1)
    {
        if (iz1.d() != this)
        {
            int i1 = e(iz1);
            if (i1 >= 0)
            {
                a((kf)t.get(i1));
            }
        }
    }

    public final void c(Object obj)
    {
        if (i(obj) == null)
        {
            int i1 = g(obj);
            if (i1 >= 0)
            {
                n.remove(i1);
                a();
            }
        }
    }

    protected Object d()
    {
        if (v == null)
        {
            v = new jc();
        }
        return v.a(i);
    }

    public final void d(iz iz1)
    {
        if (iz1.a()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        if (iz1.d() == this)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((i1 = e(iz1)) >= 0)
        {
            h(((kf)t.get(i1)).b);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int j1 = b(iz1.a);
        if (j1 >= 0)
        {
            h(((ke)n.get(j1)).a);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void d(Object obj)
    {
        if (i(obj) == null)
        {
            int i1 = g(obj);
            if (i1 >= 0)
            {
                a((ke)n.get(i1));
                a();
            }
        }
    }

    public final void e(Object obj)
    {
        if (i(obj) == null)
        {
            int i1 = g(obj);
            if (i1 >= 0)
            {
                ke ke1 = (ke)n.get(i1);
                i1 = ((android.media.MediaRouter.RouteInfo)obj).getVolume();
                if (i1 != ke1.c.j())
                {
                    ke1.c = (new ig(ke1.c)).c(i1).a();
                    a();
                }
            }
        }
    }

    protected final int g(Object obj)
    {
        int j1 = n.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((ke)n.get(i1)).a == obj)
            {
                return i1;
            }
        }

        return -1;
    }

    protected void h(Object obj)
    {
        if (u == null)
        {
            u = new jd();
        }
        jd jd1 = u;
        MediaRouter mediarouter = (MediaRouter)i;
        obj = (android.media.MediaRouter.RouteInfo)obj;
        if ((((android.media.MediaRouter.RouteInfo) (obj)).getSupportedTypes() & 0x800000) == 0)
        {
            if (jd1.a != null)
            {
                try
                {
                    jd1.a.invoke(mediarouter, new Object[] {
                        Integer.valueOf(0x800003), obj
                    });
                    return;
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", illegalaccessexception);
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route.  Media routing may not work.", invocationtargetexception);
                }
            } else
            {
                Log.w("MediaRouterJellybean", "Cannot programmatically select non-user route because the platform is missing the selectRouteInt() method.  Media routing may not work.");
            }
        }
        mediarouter.selectRoute(0x800003, ((android.media.MediaRouter.RouteInfo) (obj)));
    }

    static 
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addCategory("android.media.intent.category.LIVE_AUDIO");
        ArrayList arraylist = new ArrayList();
        o = arraylist;
        arraylist.add(intentfilter);
        intentfilter = new IntentFilter();
        intentfilter.addCategory("android.media.intent.category.LIVE_VIDEO");
        arraylist = new ArrayList();
        p = arraylist;
        arraylist.add(intentfilter);
    }
}
