// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.millennialmedia.android:
//            aa, al, v, an, 
//            am, g, ac, ag, 
//            at, ap, ao

public abstract class ab
    implements aa
{
    static class a extends ap.a
    {

        WeakReference a;

        final void a()
        {
            ab ab1 = (ab)a.get();
            if (ab1 != null)
            {
                ab1.a(false);
            }
        }

        public void a(String s)
        {
            ab ab1;
            ab1 = (ab)a.get();
            if (ab1 == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            ab1.a(true);
            if (ab1.l == null || ab1.l.b == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            s = ab1.l.b;
            s;
            JVM INSTR monitorenter ;
            if (!ab1.l.b.hasWindowFocus())
            {
                break MISSING_BLOCK_LABEL_73;
            }
            ab1.l.b.n();
_L2:
            return;
            ab1.l.b.m();
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            s;
            JVM INSTR monitorexit ;
            throw exception;
        }

        a(ab ab1)
        {
            a = new WeakReference(ab1);
        }
    }

    static class b extends x.a
    {

        WeakReference f;

        public final void b(Uri uri)
        {
            super.b(uri);
            if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
            {
                uri = (ab)f.get();
                if (uri != null)
                {
                    an.a.d(uri);
                }
            }
        }

        public final void c()
        {
            ab ab1 = (ab)f.get();
            if (ab1 != null && ab1.f != null)
            {
                v.a(ab1.j()).a(ab1.j(), ab1.f);
            }
        }

        public final boolean d()
        {
            Object obj = (ab)f.get();
            if (obj != null)
            {
                obj = ((ab) (obj)).j();
                if (obj != null && (obj instanceof Activity) && ((Activity)obj).isFinishing())
                {
                    return false;
                }
            }
            return true;
        }

        public b(ab ab1)
        {
            if (ab1 != null)
            {
                f = new WeakReference(ab1);
                e = ab1.h;
            }
        }
    }


    private static long a = 1L;
    protected am b;
    public at c;
    boolean d;
    String e;
    String f;
    long g;
    long h;
    boolean i;
    boolean j;
    WeakReference k;
    ac l;
    ap m;
    ap.a n;
    long o;

    public ab(Context context)
    {
        d = false;
        e = "28911";
        j = false;
        k = new WeakReference(context);
        n = new a(this);
        com/millennialmedia/android/ab;
        JVM INSTR monitorenter ;
        h = a;
        a++;
        String.format("Assigning MMAdImpl internal id: %d", new Object[] {
            Long.valueOf(h)
        });
        al.a();
        com/millennialmedia/android/ab;
        JVM INSTR monitorexit ;
        return;
        context;
        com/millennialmedia/android/ab;
        JVM INSTR monitorexit ;
        throw context;
    }

    static String[] l()
    {
        return (new String[] {
            "b", "i"
        });
    }

    void a()
    {
    }

    void a(Bitmap bitmap)
    {
    }

    public final void a(am am1)
    {
        b = am1;
    }

    void a(ao ao)
    {
    }

    void a(ao ao, android.widget.RelativeLayout.LayoutParams layoutparams)
    {
    }

    public final void a(String s)
    {
        if (s != null && !s.isEmpty())
        {
            v.a = s;
        }
        e = s;
    }

    void a(Map map)
    {
        Context context = j();
        map.put("apid", e);
        map.put("do", an.l(context));
        map.put("olock", an.m(context));
        if (!p())
        {
            map.put("cachedvideo", "false");
        }
        map.put("reqtype", o());
        if (b != null)
        {
            am am1 = b;
            java.util.Map.Entry entry;
            for (Iterator iterator = am1.m.entrySet().iterator(); iterator.hasNext(); map.put(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            if (am1.a != null)
            {
                map.put("age", am1.a);
            }
            if (am1.b != null)
            {
                map.put("children", am1.b);
            }
            if (am1.c != null)
            {
                map.put("education", am1.c);
            }
            if (am1.d != null)
            {
                map.put("ethnicity", am1.d);
            }
            if (am1.e != null)
            {
                map.put("gender", am1.e);
            }
            if (am1.f != null)
            {
                map.put("income", am1.f);
            }
            if (am1.g != null)
            {
                map.put("keywords", am1.g);
            }
            if (am1.h != null)
            {
                map.put("marital", am1.h);
            }
            if (am1.i != null)
            {
                map.put("politics", am1.i);
            }
            if (am1.j != null)
            {
                map.put("vendor", am1.j);
            }
            if (am1.k != null)
            {
                map.put("zip", am1.k);
            }
        }
        if (v.a(context).a(f))
        {
            map.put("video", "true");
        } else
        {
            map.put("video", "false");
        }
        if (f != null)
        {
            if (f.equals("b") || f.equals("i"))
            {
                map.put("at", f);
                return;
            } else
            {
                al.a("MMAdImpl", (new StringBuilder("******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (")).append(f).append(") **********").toString());
                return;
            }
        } else
        {
            al.a("MMAdImpl", "******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
            map.put("at", "b");
            return;
        }
    }

    void a(boolean flag)
    {
    }

    boolean b()
    {
        return false;
    }

    ap c()
    {
        (new StringBuilder("Returning a client for user: DefaultWebViewClient, adimpl=")).append(this);
        al.b();
        return new g(n, new b(this));
    }

    abstract aa d();

    public final am e()
    {
        return b;
    }

    int f()
    {
        return -1;
    }

    final void g()
    {
        boolean flag;
        flag = true;
        ac.a(this);
        if (l == null) goto _L2; else goto _L1
_L1:
        Object obj;
        ab ab1;
        obj = l;
        ab1 = (ab)((ac) (obj)).c.get();
        if (ab1 != null) goto _L4; else goto _L3
_L3:
        al.a("MMAdImplController", ag.a(25));
        an.a.a(ab1, new ag(25));
_L2:
        return;
_L4:
        if (an.b)
        {
            al.b();
        } else
        {
            long l1 = System.currentTimeMillis();
            int i1 = (int)((l1 - ab1.g) / 1000L);
            long l2 = v.a(ab1.j()).h;
            if ((long)i1 >= l2)
            {
                ab1.g = l1;
            } else
            {
                String.format("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", new Object[] {
                    Integer.valueOf(i1), Long.valueOf(l2 - (long)i1)
                });
                al.b();
                flag = false;
            }
        }
        if (!flag)
        {
            an.a.a(ab1, new ag(16));
            return;
        }
        if (!an.a())
        {
            al.a("MMAdImplController", ag.a(3));
            an.a.a(ab1, new ag(3));
            return;
        }
        if (v.a(ab1.j()).b)
        {
            al.c();
            an.a.a(ab1, new ag(16));
            return;
        }
        try
        {
            al.b();
            if (ab1.e == null)
            {
                obj = new ag("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
                al.a("MMAdImplController", ((ag) (obj)).getMessage());
                an.a.a(ab1, ((ag) (obj)));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            al.a("MMAdImplController", "There was an exception with the ad request. ", ((Throwable) (obj)));
            ((Exception) (obj)).printStackTrace();
            return;
        }
        if (!ab1.q() && ((ac) (obj)).e(ab1)) goto _L2; else goto _L5
_L5:
        obj;
        JVM INSTR monitorenter ;
        if (((ac) (obj)).d == null)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        al.c();
        an.a.a(ab1, new ag(12));
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj.d = new ac.a(((ac) (obj)), (byte)0);
        au.c.a(((ac) (obj)).d);
        obj;
        JVM INSTR monitorexit ;
    }

    boolean h()
    {
        return false;
    }

    void i()
    {
    }

    final Context j()
    {
        if (k != null)
        {
            return (Context)k.get();
        } else
        {
            return null;
        }
    }

    final String k()
    {
        if (f != null && e != null)
        {
            return (new StringBuilder()).append(f).append("_").append(e).toString();
        } else
        {
            return null;
        }
    }

    String m()
    {
        return "millennialmedia.action.ACTION_FETCH_FAILED";
    }

    String n()
    {
        return "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    }

    String o()
    {
        return "fetch";
    }

    public boolean p()
    {
        return true;
    }

    public boolean q()
    {
        return false;
    }

    boolean r()
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder("AdType[(")).append(f).append(") InternalId(").append(h).append(") LinkedId(").append(o).append(") isFinishing(").append(i).append(")]").toString();
    }

}
