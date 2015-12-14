// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, MMLog, MMSDK, MMRequest, 
//            HandShake, BannerWebViewClient, MMAdImplController, MMException, 
//            RequestListener, MMWebView, MMWebViewClient

abstract class MMAdImpl
    implements MMAd
{

    private static long m = 1L;
    protected MMRequest a;
    RequestListener b;
    boolean c;
    String d;
    String e;
    long f;
    boolean g;
    MMAdImplController h;
    MMWebViewClient.MMWebViewClientListener i;
    long j;
    private long k;
    private WeakReference l;

    public MMAdImpl(Context context)
    {
        c = false;
        d = "28911";
        l = new WeakReference(context);
        i = new BasicWebViewClientListener();
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorenter ;
        f = m;
        m++;
        MMLog.a("MMAdImpl", String.format("Assigning MMAdImpl internal id: %d", new Object[] {
            Long.valueOf(f)
        }));
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorexit ;
        return;
        context;
        com/millennialmedia/android/MMAdImpl;
        JVM INSTR monitorexit ;
        throw context;
    }

    static String[] k()
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

    void a(Map map)
    {
        Context context = i();
        map.put("apid", d);
        map.put("do", MMSDK.k(context));
        map.put("olock", MMSDK.l(context));
        if (!hasCachedVideoSupport())
        {
            map.put("cachedvideo", "false");
        }
        map.put("reqtype", n());
        if (a != null)
        {
            a.a(map);
        }
        if (HandShake.a(context).a(e))
        {
            map.put("video", "true");
        } else
        {
            map.put("video", "false");
        }
        if (e != null)
        {
            if (e.equals("b") || e.equals("i"))
            {
                map.put("at", e);
                return;
            } else
            {
                MMLog.e("MMAdImpl", (new StringBuilder("******* ERROR: INCORRECT AD TYPE IN MMADVIEW OBJECT PARAMETERS (")).append(e).append(") **********").toString());
                return;
            }
        } else
        {
            MMLog.e("MMAdImpl", "******* SDK DEFAULTED TO MMBannerAdBottom. THIS MAY AFFECT THE ADS YOU RECIEVE!!! **********");
            map.put("at", "b");
            return;
        }
    }

    void addView(MMWebView mmwebview, android.widget.RelativeLayout.LayoutParams layoutparams)
    {
    }

    boolean b()
    {
        return false;
    }

    MMWebViewClient c()
    {
        MMLog.b("MMAdImpl", (new StringBuilder("Returning a client for user: DefaultWebViewClient, adimpl=")).append(this).toString());
        return new BannerWebViewClient(i, new MMAdImplRedirectionListenerImpl());
    }

    abstract MMAd d();

    int e()
    {
        return -1;
    }

    final void f()
    {
        boolean flag;
        flag = true;
        MMAdImplController.a(this);
        if (h == null) goto _L2; else goto _L1
_L1:
        Object obj;
        MMAdImpl mmadimpl;
        obj = h;
        mmadimpl = (MMAdImpl)((MMAdImplController) (obj)).b.get();
        if (mmadimpl != null) goto _L4; else goto _L3
_L3:
        MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(25));
        MMSDK.Event.a(mmadimpl, new MMException(25));
_L2:
        return;
_L4:
        boolean flag1 = MMSDK.b;
        long l1 = System.currentTimeMillis();
        int i1 = (int)((l1 - mmadimpl.k) / 1000L);
        long l2 = HandShake.a(mmadimpl.i()).f;
        if ((long)i1 >= l2)
        {
            mmadimpl.k = l1;
        } else
        {
            MMLog.b("MMAdImpl", String.format("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", new Object[] {
                Integer.valueOf(i1), Long.valueOf(l2 - (long)i1)
            }));
            flag = false;
        }
        if (!flag)
        {
            MMSDK.Event.a(mmadimpl, new MMException(16));
            return;
        }
        if (!MMSDK.a())
        {
            MMLog.e("MMAdImplController", MMException.getErrorCodeMessage(3));
            MMSDK.Event.a(mmadimpl, new MMException(3));
            return;
        }
        if (HandShake.a(mmadimpl.i()).b)
        {
            MMLog.c("MMAdImplController", "The server is no longer allowing ads.");
            MMSDK.Event.a(mmadimpl, new MMException(16));
            return;
        }
        try
        {
            MMLog.b("MMAdImplController", "adLayout - requestAd");
            if (mmadimpl.d == null)
            {
                obj = new MMException("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
                MMLog.e("MMAdImplController", ((MMException) (obj)).getMessage());
                MMSDK.Event.a(mmadimpl, ((MMException) (obj)));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.a("MMAdImplController", "There was an exception with the ad request. ", ((Throwable) (obj)));
            ((Exception) (obj)).printStackTrace();
            return;
        }
        if (!mmadimpl.isBanner() && ((MMAdImplController) (obj)).e(mmadimpl)) goto _L2; else goto _L5
_L5:
        obj;
        JVM INSTR monitorenter ;
        if (((MMAdImplController) (obj)).c == null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        MMLog.c("MMAdImplController", MMException.getErrorCodeMessage(12));
        MMSDK.Event.a(mmadimpl, new MMException(12));
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj.c = new MMAdImplController.RequestAdRunnable(((MMAdImplController) (obj)), (byte)0);
        Utils.ThreadUtils.a(((MMAdImplController) (obj)).c);
        obj;
        JVM INSTR monitorexit ;
    }

    boolean g()
    {
        return false;
    }

    public String getApid()
    {
        return d;
    }

    public boolean getIgnoresDensityScaling()
    {
        return c;
    }

    public RequestListener getListener()
    {
        return b;
    }

    public MMRequest getMMRequest()
    {
        return a;
    }

    void h()
    {
    }

    public boolean hasCachedVideoSupport()
    {
        return true;
    }

    final Context i()
    {
        if (l != null)
        {
            return (Context)l.get();
        } else
        {
            return null;
        }
    }

    public boolean isBanner()
    {
        return false;
    }

    final String j()
    {
        if (e != null && d != null)
        {
            return (new StringBuilder()).append(e).append("_").append(d).toString();
        } else
        {
            return null;
        }
    }

    String l()
    {
        return "millennialmedia.action.ACTION_FETCH_FAILED";
    }

    String m()
    {
        return "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
    }

    String n()
    {
        return "fetch";
    }

    boolean o()
    {
        return false;
    }

    void removeView(MMWebView mmwebview)
    {
    }

    public void setApid(String s)
    {
        if (s != null && !s.isEmpty())
        {
            HandShake.a = s;
        }
        d = s;
    }

    void setClickable(boolean flag)
    {
    }

    public void setIgnoresDensityScaling(boolean flag)
    {
        c = flag;
    }

    public void setListener(RequestListener requestlistener)
    {
        b = requestlistener;
    }

    public void setMMRequest(MMRequest mmrequest)
    {
        a = mmrequest;
    }

    public String toString()
    {
        return (new StringBuilder("AdType[(")).append(e).append(") InternalId(").append(f).append(") LinkedId(").append(j).append(") isFinishing(").append(g).append(")]").toString();
    }


    private class BasicWebViewClientListener extends MMWebViewClient.MMWebViewClientListener
    {

        WeakReference a;

        final void a()
        {
            MMAdImpl mmadimpl = (MMAdImpl)a.get();
            if (mmadimpl != null)
            {
                mmadimpl.setClickable(false);
            }
        }

        public void onPageFinished(String s)
        {
            MMAdImpl mmadimpl;
            mmadimpl = (MMAdImpl)a.get();
            if (mmadimpl == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            mmadimpl.setClickable(true);
            if (mmadimpl.h == null || mmadimpl.h.a == null)
            {
                break MISSING_BLOCK_LABEL_91;
            }
            s = mmadimpl.h.a;
            s;
            JVM INSTR monitorenter ;
            if (!mmadimpl.h.a.hasWindowFocus())
            {
                break MISSING_BLOCK_LABEL_73;
            }
            mmadimpl.h.a.m();
_L2:
            return;
            mmadimpl.h.a.l();
            if (true) goto _L2; else goto _L1
_L1:
            Exception exception;
            exception;
            s;
            JVM INSTR monitorexit ;
            throw exception;
        }

        BasicWebViewClientListener()
        {
            a = new WeakReference(MMAdImpl.this);
        }
    }


    private class MMAdImplRedirectionListenerImpl extends HttpRedirection.RedirectionListenerImpl
    {

        WeakReference f;

        public boolean isActivityStartable(Uri uri)
        {
            uri = (MMAdImpl)f.get();
            if (uri != null)
            {
                uri = uri.i();
                if (uri != null && (uri instanceof Activity) && ((Activity)uri).isFinishing())
                {
                    return false;
                }
            }
            return true;
        }

        public void startingActivity(Uri uri)
        {
            super.startingActivity(uri);
            if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
            {
                uri = (MMAdImpl)f.get();
                if (uri != null)
                {
                    MMSDK.Event.d(uri);
                }
            }
        }

        public void updateLastVideoViewedTime()
        {
            MMAdImpl mmadimpl = (MMAdImpl)f.get();
            if (mmadimpl != null && mmadimpl.e != null)
            {
                HandShake.a(mmadimpl.i()).a(mmadimpl.i(), mmadimpl.e);
            }
        }

        public MMAdImplRedirectionListenerImpl()
        {
            if (MMAdImpl.this != null)
            {
                f = new WeakReference(MMAdImpl.this);
                e = MMAdImpl.this.f;
            }
        }
    }

}
