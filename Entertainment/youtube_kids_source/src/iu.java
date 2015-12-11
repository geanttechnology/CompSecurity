// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class iu
    implements ju, kl
{

    final Context a;
    final ArrayList b = new ArrayList();
    final ArrayList c = new ArrayList();
    final ArrayList d = new ArrayList();
    final ArrayList e = new ArrayList();
    final jz f = new jz();
    final kb g;
    jr h;
    iz i;
    im j;
    private final iw k = new iw(this);
    private final iv l = new iv(this);
    private final boolean m;
    private iz n;
    private ih o;

    iu(Context context)
    {
        a = context;
        cf.a(context);
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            flag = activitymanager.isLowRamDevice();
        } else
        {
            flag = false;
        }
        m = flag;
        g = kb.a(context, this);
        a(g);
    }

    private void a(boolean flag)
    {
label0:
        {
            if (n != null && !b(n))
            {
                (new StringBuilder("Clearing the default route because it is no longer selectable: ")).append(n);
                n = null;
            }
            if (n != null || c.isEmpty())
            {
                break label0;
            }
            Iterator iterator = c.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                iz iz1 = (iz)iterator.next();
                boolean flag1;
                if (iz1.d() == g && iz1.a.equals("DEFAULT_ROUTE"))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } while (!flag1 || !b(iz1));
            n = iz1;
            (new StringBuilder("Found default route: ")).append(n);
        }
        if (i != null && !b(i))
        {
            (new StringBuilder("Unselecting the current route because it is no longer selectable: ")).append(i);
            a(((iz) (null)));
        }
        if (i == null)
        {
            a(d());
        } else
        if (flag)
        {
            e();
            return;
        }
    }

    private int b(String s)
    {
        int j1 = c.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((iz)c.get(i1)).b.equals(s))
            {
                return i1;
            }
        }

        return -1;
    }

    private static boolean b(iz iz1)
    {
        return iz1.n != null && iz1.e;
    }

    private iz d()
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            iz iz1 = (iz)iterator.next();
            if (iz1 != n)
            {
                boolean flag;
                if (iz1.d() == g && iz1.a("android.media.intent.category.LIVE_AUDIO") && !iz1.a("android.media.intent.category.LIVE_VIDEO"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag && b(iz1))
                {
                    return iz1;
                }
            }
        }

        return n;
    }

    private void e()
    {
        if (i != null)
        {
            f.a = i.k;
            f.b = i.l;
            f.c = i.j;
            f.d = i.i;
            f.e = i.h;
            int j1 = e.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                ((ix)e.get(i1)).a();
            }

        }
    }

    int a(Object obj)
    {
        int j1 = e.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((ix)e.get(i1)).a.a == obj)
            {
                return i1;
            }
        }

        return -1;
    }

    public final ir a(Context context)
    {
        int i1 = b.size();
label0:
        do
        {
            do
            {
                i1--;
                ir ir1;
                if (i1 >= 0)
                {
                    ir1 = (ir)((WeakReference)b.get(i1)).get();
                    if (ir1 != null)
                    {
                        continue label0;
                    }
                    b.remove(i1);
                } else
                {
                    context = new ir(context);
                    b.add(new WeakReference(context));
                    return context;
                }
            } while (true);
        } while (ir1.b != context);
        return ir1;
    }

    public final iz a()
    {
        if (n == null)
        {
            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
        } else
        {
            return n;
        }
    }

    public final iz a(String s)
    {
        int i1 = c(g);
        if (i1 >= 0)
        {
            iy iy1 = (iy)d.get(i1);
            i1 = iy1.a(s);
            if (i1 >= 0)
            {
                return (iz)iy1.b.get(i1);
            }
        }
        return null;
    }

    public final void a(ii ii1)
    {
        if (c(ii1) < 0)
        {
            iy iy1 = new iy(ii1);
            d.add(iy1);
            if (ir.e())
            {
                (new StringBuilder("Provider added: ")).append(iy1);
            }
            l.a(513, iy1);
            a(iy1, ii1.g);
            ii1.a(k);
            ii1.a(o);
        }
    }

    void a(iy iy1, in in1)
    {
        List list;
        if if1;
        String s1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (iy1.d != in1)
        {
            iy1.d = in1;
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L2; else goto _L1
_L1:
        j1 = 0;
        i1 = 0;
        flag2 = false;
        flag = false;
        flag1 = flag2;
        k1 = j1;
        if (in1 == null) goto _L4; else goto _L3
_L3:
        if (!in1.b()) goto _L6; else goto _L5
_L5:
        list = in1.a();
        l1 = list.size();
        j1 = 0;
_L12:
        flag1 = flag;
        k1 = i1;
        if (j1 >= l1) goto _L4; else goto _L7
_L7:
        if1 = (if)list.get(j1);
        s1 = if1.a();
        i2 = iy1.a(s1);
        if (i2 >= 0) goto _L9; else goto _L8
_L8:
        in1 = (new StringBuilder()).append(iy1.c.a.flattenToShortString()).append(":").append(s1).toString();
        if (b(in1) >= 0) goto _L11; else goto _L10
_L10:
        in1 = new iz(iy1, s1, in1);
        ArrayList arraylist = iy1.b;
        k1 = i1 + 1;
        arraylist.add(i1, in1);
        c.add(in1);
        in1.a(if1);
        if (ir.e())
        {
            (new StringBuilder("Route added: ")).append(in1);
        }
        l.a(257, in1);
        i1 = k1;
_L14:
        j1++;
          goto _L12
_L11:
        k1 = 2;
_L13:
label0:
        {
            String s = String.format(Locale.US, "%s_%d", new Object[] {
                in1, Integer.valueOf(k1)
            });
            if (b(s) >= 0)
            {
                break label0;
            }
            in1 = s;
        }
          goto _L10
        k1++;
          goto _L13
_L9:
        if (i2 < i1)
        {
            Log.w("MediaRouter", (new StringBuilder("Ignoring route descriptor with duplicate id: ")).append(if1).toString());
        } else
        {
            in1 = (iz)iy1.b.get(i2);
            ArrayList arraylist1 = iy1.b;
            k1 = i1 + 1;
            Collections.swap(arraylist1, i2, i1);
            i1 = in1.a(if1);
            if (i1 == 0)
            {
                break MISSING_BLOCK_LABEL_723;
            }
            if ((i1 & 1) != 0)
            {
                if (ir.e())
                {
                    (new StringBuilder("Route changed: ")).append(in1);
                }
                l.a(259, in1);
            }
            if ((i1 & 2) != 0)
            {
                if (ir.e())
                {
                    (new StringBuilder("Route volume changed: ")).append(in1);
                }
                l.a(260, in1);
            }
            if ((i1 & 4) != 0)
            {
                if (ir.e())
                {
                    (new StringBuilder("Route presentation display changed: ")).append(in1);
                }
                l.a(261, in1);
            }
            if (in1 != i)
            {
                break MISSING_BLOCK_LABEL_723;
            }
            flag = true;
            i1 = k1;
        }
          goto _L14
_L6:
        Log.w("MediaRouter", (new StringBuilder("Ignoring invalid provider descriptor: ")).append(in1).toString());
        k1 = j1;
        flag1 = flag2;
_L4:
        for (i1 = iy1.b.size() - 1; i1 >= k1; i1--)
        {
            in1 = (iz)iy1.b.get(i1);
            in1.a(null);
            c.remove(in1);
        }

        a(flag1);
        for (i1 = iy1.b.size() - 1; i1 >= k1; i1--)
        {
            in1 = (iz)iy1.b.remove(i1);
            if (ir.e())
            {
                (new StringBuilder("Route removed: ")).append(in1);
            }
            l.a(258, in1);
        }

        if (ir.e())
        {
            (new StringBuilder("Provider changed: ")).append(iy1);
        }
        l.a(515, iy1);
_L2:
        return;
        i1 = k1;
          goto _L14
    }

    void a(iz iz1)
    {
        if (i != iz1)
        {
            if (i != null)
            {
                if (ir.e())
                {
                    (new StringBuilder("Route unselected: ")).append(i);
                }
                l.a(263, i);
                if (j != null)
                {
                    j.c();
                    j.a();
                    j = null;
                }
            }
            i = iz1;
            if (i != null)
            {
                j = iz1.d().a(iz1.a);
                if (j != null)
                {
                    j.b();
                }
                if (ir.e())
                {
                    (new StringBuilder("Route selected: ")).append(i);
                }
                l.a(262, i);
            }
            e();
        }
    }

    public final boolean a(ip ip1, int i1)
    {
        if (ip1.c())
        {
            return false;
        }
        if ((i1 & 2) == 0 && m)
        {
            return true;
        }
        int k1 = c.size();
        for (int j1 = 0; j1 < k1; j1++)
        {
            iz iz1 = (iz)c.get(j1);
            if (((i1 & 1) == 0 || !iz1.b()) && iz1.a(ip1))
            {
                return true;
            }
        }

        return false;
    }

    public final iz b()
    {
        if (i == null)
        {
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        } else
        {
            return i;
        }
    }

    public final void b(ii ii1)
    {
        int i1 = c(ii1);
        if (i1 >= 0)
        {
            ii1.a(null);
            ii1.a(null);
            ii1 = (iy)d.get(i1);
            a(ii1, ((in) (null)));
            if (ir.e())
            {
                (new StringBuilder("Provider removed: ")).append(ii1);
            }
            l.a(514, ii1);
            d.remove(i1);
        }
    }

    int c(ii ii1)
    {
        int j1 = d.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((iy)d.get(i1)).a == ii1)
            {
                return i1;
            }
        }

        return -1;
    }

    public final void c()
    {
        Object obj;
        boolean flag;
        boolean flag1;
        obj = new iq();
        int j1 = b.size();
        flag1 = false;
        flag = false;
        do
        {
            int l1 = j1 - 1;
            if (l1 < 0)
            {
                break;
            }
            ir ir1 = (ir)((WeakReference)b.get(l1)).get();
            if (ir1 == null)
            {
                b.remove(l1);
                j1 = l1;
            } else
            {
                int j2 = ir1.c.size();
                for (int i2 = 0; i2 < j2; i2++)
                {
                    it it1 = (it)ir1.c.get(i2);
                    ((iq) (obj)).a(it1.c);
                    if ((it1.d & 1) != 0)
                    {
                        flag1 = true;
                        flag = true;
                    }
                    j1 = ((flag) ? 1 : 0);
                    if ((it1.d & 4) != 0)
                    {
                        j1 = ((flag) ? 1 : 0);
                        if (!m)
                        {
                            j1 = 1;
                        }
                    }
                    flag = j1;
                    if ((it1.d & 8) != 0)
                    {
                        flag = true;
                    }
                }

                j1 = l1;
            }
        } while (true);
        if (flag)
        {
            obj = ((iq) (obj)).a();
        } else
        {
            obj = ip.c;
        }
        if (o == null || !o.a().equals(obj) || o.b() != flag1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!((ip) (obj)).c() || flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (o == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        o = null;
_L4:
        if (ir.e())
        {
            (new StringBuilder("Updated discovery request: ")).append(o);
        }
        if (flag && !flag1)
        {
            flag1 = m;
        }
        int k1 = d.size();
        int i1 = 0;
        while (i1 < k1) 
        {
            ((iy)d.get(i1)).a.a(o);
            i1++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        o = new ih(((ip) (obj)), flag1);
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }
}
