// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.cw;
import com.tapjoy.internal.gd;

// Referenced classes of package com.tapjoy:
//            TJCacheListener, TJPlacement, TJAdUnit, TJPlacementData, 
//            TapjoyLog, TapjoyURLConnection, TapjoyHttpURLResponse, TJPlacementListener, 
//            TJError

final class a
    implements TJCacheListener
{

    final a a;

    public final void onCachingComplete(int i)
    {
        TJPlacement.a(a.a, TJPlacement.j(a.a).preload(TJPlacement.e(a.a)));
    }

    ner(ner ner)
    {
        a = ner;
        super();
    }

    // Unreferenced inner class com/tapjoy/TJPlacement$2

/* anonymous class */
    final class TJPlacement._cls2 extends Thread
    {

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
        //                       0: 434
        //                       200: 290;
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
                b.a(tapjoyhttpurlresponse, new TJPlacement._cls2._cls1(this));
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
                b = tjplacement;
                a = gd1;
                super();
            }
    }

}
