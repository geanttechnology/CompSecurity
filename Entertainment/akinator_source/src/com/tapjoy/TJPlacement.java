// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.AndroidListenerProxy;
import com.tapjoy.internal.ci;
import com.tapjoy.internal.cw;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gi;
import com.tapjoy.internal.gk;
import com.tapjoy.internal.hc;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.tapjoy:
//            TJPlacementListener, TJPlacementData, TapjoyConnectCore, TJPlacementManager, 
//            TJAdUnit, FiveRocksIntegration, TapjoyLog, TapjoyUtil, 
//            TapjoyHttpURLResponse, TJCacheListener, TapjoyCache, TJError, 
//            TJAdUnitActivity, TapjoyURLConnection

public class TJPlacement
{

    private Context a;
    private TJAdUnit b;
    private TJPlacementData c;
    private Map d;
    private TJPlacementListener e;
    private TJPlacementListener f;
    private boolean g;
    private boolean h;
    private boolean i;
    private hc j;
    private gk k;
    private boolean l;
    private boolean m;
    private boolean n;

    public TJPlacement(Context context, String s, TJPlacementListener tjplacementlistener)
    {
        TJPlacementListener tjplacementlistener1 = null;
        super();
        g = false;
        h = false;
        i = false;
        j = null;
        k = null;
        l = false;
        m = false;
        a = context;
        e = tjplacementlistener;
        if (tjplacementlistener != null)
        {
            tjplacementlistener1 = (TJPlacementListener)AndroidListenerProxy.newProxyInstance(tjplacementlistener, com/tapjoy/TJPlacementListener);
        }
        f = tjplacementlistener1;
        c = new TJPlacementData((new StringBuilder()).append(TapjoyConnectCore.getPlacementURL()).append("v1/apps/").append(TapjoyConnectCore.getAppID()).append("/content?").toString());
        c.setPlacementName(s);
        c.setViewType(0);
        TJPlacementManager.put(c.getGuid(), this);
        b = new TJAdUnit(context);
        b.setWebViewListener(new TJAdUnit.TJAdUnitWebViewListener() {

            final TJPlacement a;

            public final void onClosed()
            {
                if (TJPlacement.b(a))
                {
                    TJPlacementManager.decrementPlacementCacheCount();
                    TJPlacement.c(a);
                }
                if (TJPlacement.d(a))
                {
                    TJPlacementManager.decrementPlacementPreRenderCount();
                    TJPlacement.a(a, false);
                }
            }

            public final void onContentReady()
            {
                TJPlacement.a(a);
            }

            
            {
                a = TJPlacement.this;
                super();
            }
        });
        FiveRocksIntegration.addPlacementCallback(s, this);
    }

    static hc a(TJPlacement tjplacement, hc hc1)
    {
        tjplacement.j = hc1;
        return hc1;
    }

    static void a(TJPlacement tjplacement)
    {
        if (!tjplacement.i)
        {
            tjplacement.h = true;
            TapjoyLog.i("TJPlacement", (new StringBuilder("Content is ready for placement ")).append(tjplacement.c.getPlacementName()).toString());
            if (tjplacement.e != null)
            {
                tjplacement.e.onContentReady(tjplacement);
                tjplacement.i = true;
            }
        }
    }

    static boolean a(TJPlacement tjplacement, String s)
    {
        return tjplacement.a(s);
    }

    static boolean a(TJPlacement tjplacement, boolean flag)
    {
        tjplacement.m = flag;
        return flag;
    }

    private boolean a(String s)
    {
label0:
        {
            s = new ByteArrayInputStream(s.getBytes());
            try
            {
                s = (com.tapjoy.internal.hc.a)j.a(URI.create(c.getUrl()), s);
                k = ((com.tapjoy.internal.hc.a) (s)).a;
                ((com.tapjoy.internal.hc.a) (s)).a.a();
                if (((com.tapjoy.internal.hc.a) (s)).a.b())
                {
                    break label0;
                }
                TapjoyLog.e("TJPlacement", "Failed to load fiverocks placement");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                TapjoyLog.e("TJPlacement", s.toString());
                s.printStackTrace();
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                TapjoyLog.e("TJPlacement", s.toString());
                s.printStackTrace();
                return false;
            }
            return false;
        }
        return true;
    }

    static boolean b(TJPlacement tjplacement)
    {
        return tjplacement.l;
    }

    static boolean c(TJPlacement tjplacement)
    {
        tjplacement.l = false;
        return false;
    }

    private void d()
    {
        this;
        JVM INSTR monitorenter ;
        c.resetPlacementRequestData();
        n = true;
        i = false;
        d = TapjoyConnectCore.getGenericURLParams();
        d.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
        TapjoyUtil.safePut(d, "event_name", c.getPlacementName(), true);
        TapjoyUtil.safePut(d, "event_preload", String.valueOf(true), true);
        TapjoyUtil.safePut(d, "debug", Boolean.toString(ga.a), true);
        gd gd1 = gd.a();
        TapjoyUtil.safePut(d, "action_id_exclusion", gd1.i(), true);
        (new Thread(gd1) {

            final gd a;
            final TJPlacement b;

            public final void run()
            {
                TapjoyHttpURLResponse tapjoyhttpurlresponse;
                TapjoyLog.i("TJPlacement", (new StringBuilder("Sending content request for placement ")).append(TJPlacement.e(b).getPlacementName()).toString());
                TJPlacement.a(b, a.a(TJPlacement.e(b).getPlacementName(), TJPlacement.f(b)));
                tapjoyhttpurlresponse = (new TapjoyURLConnection()).getResponseFromURL(TJPlacement.e(b).getUrl(), null, null, TJPlacement.g(b));
                TJPlacement.e(b).setHttpStatusCode(tapjoyhttpurlresponse.statusCode);
                TJPlacement.e(b).setHttpResponse(tapjoyhttpurlresponse.response);
                if (!tapjoyhttpurlresponse.getHeaderFieldAsString("x-tapjoy-prerender").equals("0"))
                {
                    TJPlacement.e(b).setPrerenderingRequested(true);
                }
                String s = tapjoyhttpurlresponse.getHeaderFieldAsString("X-Tapjoy-Debug");
                if (s != null)
                {
                    TapjoyLog.v("TJPlacement", (new StringBuilder("Tapjoy-Server-Debug: ")).append(s).toString());
                }
                if (tapjoyhttpurlresponse == null || TJPlacement.h(b) == null) goto _L2; else goto _L1
_L1:
                tapjoyhttpurlresponse.statusCode;
                JVM INSTR lookupswitch 2: default 220
            //                           0: 434
            //                           200: 290;
                   goto _L3 _L4 _L5
_L3:
                TapjoyLog.i("TJPlacement", (new StringBuilder("Content request delivered successfully for placement ")).append(TJPlacement.e(b).getPlacementName()).append(", contentAvailable: ").append(TJPlacement.i(b)).toString());
                TJPlacement.h(b).onRequestSuccess(b);
_L2:
                TJPlacement.l(b);
                return;
_L5:
                String s1 = tapjoyhttpurlresponse.getHeaderFieldAsString("Content-Type");
                if (!cw.c(s1) && s1.contains("json"))
                {
                    if (TJPlacement.a(b, tapjoyhttpurlresponse.response))
                    {
                        b.b();
                        TJPlacement.a(b);
                    } else
                    {
                        TapjoyLog.i("TJPlacement", (new StringBuilder("Content request delivered successfully for placement ")).append(TJPlacement.e(b).getPlacementName()).append(", contentAvailable: ").append(TJPlacement.i(b)).toString());
                        TJPlacement.h(b).onRequestSuccess(b);
                    }
                } else
                {
                    b.b();
                    b.a(tapjoyhttpurlresponse, new TJCacheListener(this) {

                        final _cls2 a;

                        public final void onCachingComplete(int i1)
                        {
                            TJPlacement.a(a.b, TJPlacement.j(a.b).preload(TJPlacement.e(a.b)));
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }
                continue; /* Loop/switch isn't completed */
_L4:
                TapjoyLog.i("TJPlacement", (new StringBuilder("Send request failed for placement ")).append(TJPlacement.e(b).getPlacementName()).toString());
                TJPlacement.k(b);
                TJPlacement.h(b).onRequestFailure(b, new TJError(tapjoyhttpurlresponse.statusCode, tapjoyhttpurlresponse.response));
                if (true) goto _L2; else goto _L6
_L6:
            }

            
            {
                b = TJPlacement.this;
                a = gd1;
                super();
            }
        }).start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean d(TJPlacement tjplacement)
    {
        return tjplacement.m;
    }

    static TJPlacementData e(TJPlacement tjplacement)
    {
        return tjplacement.c;
    }

    static Context f(TJPlacement tjplacement)
    {
        return tjplacement.a;
    }

    static Map g(TJPlacement tjplacement)
    {
        return tjplacement.d;
    }

    static TJPlacementListener h(TJPlacement tjplacement)
    {
        return tjplacement.e;
    }

    static boolean i(TJPlacement tjplacement)
    {
        return tjplacement.g;
    }

    static TJAdUnit j(TJPlacement tjplacement)
    {
        return tjplacement.b;
    }

    static void k(TJPlacement tjplacement)
    {
        TapjoyLog.i("TJPlacement", (new StringBuilder("Tracking event ")).append(tjplacement.c.getPlacementName()).append(" for offline delivery").toString());
        tjplacement.d.remove("timestamp");
        tjplacement.d.remove("verifier");
        TapjoyConnectCore.saveOfflineLog((new StringBuilder()).append(tjplacement.c.getUrl()).append(TapjoyUtil.convertURLParams(tjplacement.d, false)).toString());
    }

    static boolean l(TJPlacement tjplacement)
    {
        tjplacement.n = false;
        return false;
    }

    static gk m(TJPlacement tjplacement)
    {
        return tjplacement.k;
    }

    final TJPlacementListener a()
    {
        return f;
    }

    final void a(TapjoyHttpURLResponse tapjoyhttpurlresponse, TJCacheListener tjcachelistener)
    {
        TapjoyLog.i("TJPlacement", (new StringBuilder("Checking if there is content to cache for placement ")).append(c.getPlacementName()).toString());
        tapjoyhttpurlresponse = tapjoyhttpurlresponse.getHeaderFieldAsString("x-tapjoy-cacheable-assets");
        try
        {
            if (!TJPlacementManager.canCachePlacement())
            {
                TapjoyLog.i("TJPlacement", (new StringBuilder("Placement caching limit reached. No content will be cached for placement ")).append(c.getPlacementName()).toString());
                tjcachelistener.onCachingComplete(2);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (TapjoyHttpURLResponse tapjoyhttpurlresponse)
        {
            tjcachelistener.onCachingComplete(2);
            return;
        }
        tapjoyhttpurlresponse = new JSONArray(tapjoyhttpurlresponse);
        if (tapjoyhttpurlresponse.length() > 0)
        {
            TapjoyLog.i("TJPlacement", (new StringBuilder("Begin caching content for placement ")).append(c.getPlacementName()).toString());
            TJPlacementManager.incrementPlacementCacheCount();
            l = true;
            TapjoyCache.getInstance().cacheAssetGroup(tapjoyhttpurlresponse, new TJCacheListener(tjcachelistener) {

                final TJCacheListener a;
                final TJPlacement b;

                public final void onCachingComplete(int i1)
                {
                    a.onCachingComplete(i1);
                }

            
            {
                b = TJPlacement.this;
                a = tjcachelistener;
                super();
            }
            });
            return;
        }
        tjcachelistener.onCachingComplete(1);
        return;
    }

    protected final void b()
    {
        g = true;
        TapjoyLog.i("TJPlacement", (new StringBuilder("Content request delivered successfully for placement ")).append(c.getPlacementName()).append(", contentAvailable: ").append(g).toString());
        e.onRequestSuccess(this);
    }

    final TJAdUnit c()
    {
        return b;
    }

    public String getGUID()
    {
        return c.getGuid();
    }

    public TJPlacementListener getListener()
    {
        return e;
    }

    public String getName()
    {
        return c.getPlacementName();
    }

    public boolean isContentAvailable()
    {
        return g;
    }

    public boolean isContentReady()
    {
        return h;
    }

    public void requestContent()
    {
        if (TapjoyConnectCore.isConnected()) goto _L2; else goto _L1
_L1:
        TapjoyLog.e("TJPlacement", "Can not call requestContent for TJPlacement because Tapjoy SDK has not successfully connected.");
        if (e != null)
        {
            e.onRequestFailure(this, new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        }
_L4:
        return;
_L2:
        if (a != null)
        {
            break; /* Loop/switch isn't completed */
        }
        TapjoyLog.e("TJPlacement", "Can not call requestContent for TJPlacement because context is null");
        if (e != null)
        {
            e.onRequestFailure(this, new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (cw.c(c.getPlacementName()))
        {
            TapjoyLog.e("TJPlacement", "Can not call send for TJPlacement because name is null or empty");
            if (e != null)
            {
                e.onRequestFailure(this, new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
                return;
            }
        } else
        if (n)
        {
            TapjoyLog.i("TJPlacement", (new StringBuilder("Placement ")).append(getName()).append(" is already requesting content").toString());
            return;
        } else
        {
            d();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void showContent()
    {
        TapjoyLog.i("TJPlacement", (new StringBuilder("showPlacementContent() called for placement ")).append(c.getPlacementName()).toString());
        if (!g)
        {
            TapjoyLog.e("TJPlacement", "No placement content available. Can not show content for non-200 placement.");
            return;
        }
        if (e == null)
        {
            TapjoyLog.e("TJPlacement", "TJPlacementListener is null");
            return;
        }
        if (TapjoyConnectCore.isViewOpen())
        {
            TapjoyLog.w("TJPlacement", "Only one view can be presented at a time.");
            return;
        }
        if (k != null)
        {
            if (k instanceof gi)
            {
                TapjoyConnectCore.viewWillOpen(0);
                ((gi)k).e = new fy() {

                    final TJPlacement a;

                    public final void a(Context context, String s)
                    {
                        TJPlacement.e(a).setRedirectURL(s);
                        TJPlacement.e(a).setHasProgressSpinner(true);
                        s = new Intent(TJPlacement.f(a), com/tapjoy/TJAdUnitActivity);
                        s.putExtra("placement_data", TJPlacement.e(a));
                        s.setFlags(0x10000000);
                        context.startActivity(s);
                    }

            
            {
                a = TJPlacement.this;
                super();
            }
                };
                gd.a(new Runnable() {

                    final TJPlacement a;

                    public final void run()
                    {
                        TJPlacement.m(a).a(gd.a().j());
                    }

            
            {
                a = TJPlacement.this;
                super();
            }
                });
            }
        } else
        {
            TapjoyConnectCore.viewWillOpen(0);
            Intent intent = new Intent(a, com/tapjoy/TJAdUnitActivity);
            intent.putExtra("placement_data", c);
            intent.setFlags(0x10000000);
            a.startActivity(intent);
        }
        g = false;
        h = false;
    }
}
