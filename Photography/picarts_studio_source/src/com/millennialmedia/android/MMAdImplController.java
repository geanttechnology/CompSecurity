// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.millennialmedia.android:
//            MMLog, MMAdImpl, MMWebView, CachedAd, 
//            HandShake, MMLayout, MMException, AdCache

class MMAdImplController
    implements AdCache.AdCacheTaskListener
{

    private static final Map d = new ConcurrentHashMap();
    private static final Map e = new ConcurrentHashMap();
    volatile MMWebView a;
    volatile WeakReference b;
    RequestAdRunnable c;
    private volatile long f;

    private MMAdImplController(MMAdImpl mmadimpl)
    {
        MMLog.b("MMAdImplController", "**************** creating new controller.");
        b = new WeakReference(mmadimpl);
        if (mmadimpl.j != 0L)
        {
            MMAdImpl mmadimpl1 = a(mmadimpl.j);
            if (mmadimpl1 != null)
            {
                f = mmadimpl.j;
                mmadimpl1.h.f = mmadimpl.f;
                mmadimpl1.j = mmadimpl.f;
            }
            a = c(mmadimpl);
        } else
        if (!(mmadimpl instanceof MMInterstitial.MMInterstitialAdImpl))
        {
            if (mmadimpl.isBanner())
            {
                a = new MMWebView(mmadimpl.i().getApplicationContext(), mmadimpl.f);
                a.e = true;
                return;
            } else
            {
                a = new MMWebView(mmadimpl.i(), mmadimpl.f);
                return;
            }
        }
    }

    static int a(MMAdImpl mmadimpl, CachedAd cachedad)
    {
        if (cachedad.isExpired())
        {
            MMLog.b("MMAdImplController", String.format("%s is expired.", new Object[] {
                cachedad.getId()
            }));
            return 21;
        }
        if (!cachedad.isOnDisk(mmadimpl.i()))
        {
            MMLog.b("MMAdImplController", String.format("%s is not on disk.", new Object[] {
                cachedad.getId()
            }));
            return 22;
        }
        if (!HandShake.a(mmadimpl.i()).a(mmadimpl.e, cachedad.deferredViewStart))
        {
            MMLog.b("MMAdImplController", String.format("%s cannot be shown at this time.", new Object[] {
                cachedad.getId()
            }));
            return 24;
        } else
        {
            return 100;
        }
    }

    static MMAdImpl a(long l)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        if (l != -4L) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return ((MMAdImpl) (obj));
_L2:
        MMAdImplController mmadimplcontroller = (MMAdImplController)d.get(Long.valueOf(l));
        obj = mmadimplcontroller;
        if (mmadimplcontroller != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        WeakReference weakreference = (WeakReference)e.get(Long.valueOf(l));
        obj = mmadimplcontroller;
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj = (MMAdImplController)weakreference.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = (MMAdImpl)((MMAdImplController) (obj)).b.get();
        continue; /* Loop/switch isn't completed */
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String a()
    {
        return (new StringBuilder()).append(e.toString()).append(" SAVED:").append(d.toString()).toString();
    }

    static void a(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        if (mmadimpl.h == null) goto _L2; else goto _L1
_L1:
        if (d.containsValue(mmadimpl.h)) goto _L4; else goto _L3
_L3:
        if (!mmadimpl.o()) goto _L6; else goto _L5
_L5:
        d.put(Long.valueOf(mmadimpl.f), mmadimpl.h);
        if (e.containsKey(Long.valueOf(mmadimpl.f)))
        {
            e.remove(Long.valueOf(mmadimpl.f));
        }
_L4:
        MMLog.b("MMAdImplController", (new StringBuilder()).append(mmadimpl).append(" - Has a controller").toString());
_L8:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (e.containsKey(Long.valueOf(mmadimpl.f))) goto _L4; else goto _L7
_L7:
        e.put(Long.valueOf(mmadimpl.f), new WeakReference(mmadimpl.h));
          goto _L4
        mmadimpl;
        throw mmadimpl;
_L2:
        MMAdImplController mmadimplcontroller;
        MMLog.b("MMAdImplController", (new StringBuilder("*****************************************assignAdViewController for ")).append(mmadimpl).toString());
        mmadimplcontroller = (MMAdImplController)d.get(Long.valueOf(mmadimpl.f));
        Object obj;
        obj = mmadimplcontroller;
        if (mmadimplcontroller != null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        obj = (WeakReference)e.get(Long.valueOf(mmadimpl.f));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        mmadimplcontroller = (MMAdImplController)((WeakReference) (obj)).get();
        obj = mmadimplcontroller;
        if (mmadimplcontroller != null)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        obj = new MMAdImplController(mmadimpl);
        if (!mmadimpl.o())
        {
            break MISSING_BLOCK_LABEL_322;
        }
        d.put(Long.valueOf(mmadimpl.f), obj);
_L9:
        mmadimpl.h = ((MMAdImplController) (obj));
        obj.b = new WeakReference(mmadimpl);
        if (((MMAdImplController) (obj)).a != null && !(mmadimpl instanceof MMInterstitial.MMInterstitialAdImpl))
        {
            f(mmadimpl);
        }
          goto _L8
        e.put(Long.valueOf(mmadimpl.f), new WeakReference(obj));
          goto _L9
    }

    static void b()
    {
        Iterator iterator = d.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (MMAdImplController)((java.util.Map.Entry)iterator.next()).getValue();
            if (obj != null)
            {
                obj = (MMAdImpl)((MMAdImplController) (obj)).b.get();
                if (obj != null)
                {
                    obj = ((MMAdImpl) (obj)).d();
                    if (obj != null && (obj instanceof MMLayout))
                    {
                        ((MMLayout)obj).g();
                    }
                }
            }
        } while (true);
    }

    static boolean b(MMAdImpl mmadimpl)
    {
        boolean flag1 = false;
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        if (mmadimpl != null) goto _L2; else goto _L1
_L1:
        boolean flag = flag1;
_L4:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        MMAdImpl mmadimpl1;
        MMLog.b("MMAdImplController", (new StringBuilder("attachWebViewFromOverlay with ")).append(mmadimpl).toString());
        if (mmadimpl.h != null && mmadimpl.h.a != null)
        {
            mmadimpl.h.a.d();
        }
        mmadimpl1 = a(mmadimpl.j);
        flag = flag1;
        if (mmadimpl1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (mmadimpl1.h == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mmadimpl1.h.a != null)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        flag = flag1;
        if (mmadimpl.h == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (mmadimpl.h.a == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mmadimpl1.h.a = mmadimpl.h.a;
        mmadimpl.removeView(mmadimpl.h.a);
        mmadimpl.h.a = null;
        mmadimpl1.h.a.j();
        mmadimpl1.h.a.setWebViewClient(mmadimpl1.c());
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        mmadimpl;
        throw mmadimpl;
    }

    static MMWebView c(MMAdImpl mmadimpl)
    {
        Object obj = null;
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImpl mmadimpl1;
        MMLog.c("MMAdImplController", (new StringBuilder("getWebViewFromExistingLayout(")).append(mmadimpl.f).append(" taking from ").append(mmadimpl.j).append(")").toString());
        mmadimpl1 = a(mmadimpl.j);
        mmadimpl = obj;
        if (mmadimpl1 == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        mmadimpl = obj;
        if (mmadimpl1.h != null)
        {
            mmadimpl = mmadimpl1.h.a;
            mmadimpl1.h.a = null;
        }
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return mmadimpl;
        mmadimpl;
        throw mmadimpl;
    }

    static void d(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImplController mmadimplcontroller = mmadimpl.h;
        if (mmadimplcontroller != null) goto _L2; else goto _L1
_L1:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!mmadimpl.o())
        {
            break; /* Loop/switch isn't completed */
        }
        d.put(Long.valueOf(mmadimpl.f), mmadimpl.h);
        if (e.get(Long.valueOf(mmadimpl.f)) != null)
        {
            e.remove(Long.valueOf(mmadimpl.f));
        }
_L4:
        MMLog.b("MMAdImplController", (new StringBuilder("****************RemoveAdviewcontroller - ")).append(mmadimpl).toString());
        if (mmadimpl.g)
        {
            d.remove(Long.valueOf(mmadimpl.f));
            e.remove(Long.valueOf(mmadimpl.f));
        }
        MMAdImplController mmadimplcontroller1 = mmadimpl.h;
        mmadimpl.h = null;
        MMLog.b("MMAdImplController", (new StringBuilder("****************RemoveAdviewcontroller - controllers ")).append(a()).toString());
        if (mmadimplcontroller1.a != null)
        {
            MMLog.b("MMAdImplController", (new StringBuilder("****************RemoveAdviewcontroller - controller!=null, expanding=")).append(mmadimplcontroller1.a.b).toString());
            mmadimpl.removeView(mmadimplcontroller1.a);
            mmadimplcontroller1.a.b = false;
            if (mmadimpl.g && mmadimpl.j == 0L)
            {
                mmadimplcontroller1.a.loadData("<html></html>", "text/html", "UTF-8");
                mmadimplcontroller1.a.d();
                mmadimplcontroller1.a = null;
            }
        }
        if (true) goto _L1; else goto _L3
        mmadimpl;
        throw mmadimpl;
_L3:
        e.put(Long.valueOf(mmadimpl.f), new WeakReference(mmadimpl.h));
          goto _L4
    }

    private static void f(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImplController mmadimplcontroller = mmadimpl.h;
        if (mmadimplcontroller.a == null) goto _L2; else goto _L1
_L1:
        mmadimplcontroller.a.setWebViewClient(mmadimpl.c());
        if (mmadimplcontroller.a.a(mmadimpl.f)) goto _L2; else goto _L3
_L3:
        if (!mmadimpl.isBanner()) goto _L5; else goto _L4
_L4:
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams = layoutparams1;
        if (!mmadimplcontroller.a.p())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        mmadimplcontroller.a.a(mmadimpl);
        layoutparams = layoutparams1;
_L7:
        mmadimplcontroller.a.o();
        mmadimpl.addView(mmadimplcontroller.a, layoutparams);
_L2:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L5:
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        if (true) goto _L7; else goto _L6
_L6:
        mmadimpl;
        throw mmadimpl;
    }

    final void a(String s, String s1)
    {
        if (a != null)
        {
            a.a(s, s1, (MMAdImpl)b.get());
        }
    }

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        MMAdImpl mmadimpl = (MMAdImpl)b.get();
        if (mmadimpl == null)
        {
            MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(25));
            return;
        }
        if (flag)
        {
            AdCache.a(mmadimpl.i(), mmadimpl.j(), cachedad.getId());
        }
        if (flag)
        {
            MMSDK.Event.f(mmadimpl);
            return;
        } else
        {
            MMSDK.Event.a(mmadimpl, new MMException(15));
            return;
        }
    }

    public void downloadStart(CachedAd cachedad)
    {
    }

    boolean e(MMAdImpl mmadimpl)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Context context = mmadimpl.i();
        if (!HandShake.a(context).b(mmadimpl.e)) goto _L2; else goto _L1
_L1:
        MMLog.c("MMAdImplController", "There is a download in progress. Defering call for new ad");
        MMSDK.Event.a(mmadimpl, new MMException(12));
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        CachedAd cachedad;
        MMLog.b("MMAdImplController", "No download in progress.");
        cachedad = AdCache.e(context, mmadimpl.j());
        if (cachedad == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        MMLog.c("MMAdImplController", "Last ad wasn't fully downloaded. Download again.");
        MMSDK.Event.b(mmadimpl);
        AdCache.a(context, mmadimpl.j(), cachedad, this);
        continue; /* Loop/switch isn't completed */
        mmadimpl;
        throw mmadimpl;
        MMLog.c("MMAdImplController", "No incomplete downloads.");
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getDefaultUserAgentString(Context context)
    {
        return System.getProperty("http.agent");
    }

    public String toString()
    {
        MMAdImpl mmadimpl = (MMAdImpl)b.get();
        StringBuilder stringbuilder = new StringBuilder();
        if (mmadimpl != null)
        {
            stringbuilder.append((new StringBuilder()).append(mmadimpl).append("-LinkInC=").append(f).toString());
        }
        return (new StringBuilder()).append(stringbuilder.toString()).append(" w/").append(a).toString();
    }

}
