// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.util.Log;
import android.view.View;
import com.flurry.android.FlurryAgent;
import es;
import java.util.HashMap;
import java.util.Map;
import jh;

// Referenced classes of package com.fotoable.fullscreenad:
//            FullScreenAdView

class a
    implements android.view.r
{

    final FullScreenAdView a;

    public void onClick(View view)
    {
label0:
        {
            view = new HashMap();
            view.put("adId", (new StringBuilder()).append("").append(FullScreenAdView.access$100(a)).toString());
            Log.e("FullScreenAd", (new StringBuilder()).append("adid:").append(FullScreenAdView.access$100(a)).toString());
            FlurryAgent.logEvent(FullScreenAdView.access$200(a), view);
            if (FullScreenAdView.access$300(a) != null && FullScreenAdView.access$300(a).length() > 0)
            {
                if (!FullScreenAdView.access$300(a).startsWith("market://"))
                {
                    break label0;
                }
                es.a(FullScreenAdView.access$400(a), FullScreenAdView.access$300(a));
                FullScreenAdView.access$500(a);
            }
            return;
        }
        if (FullScreenAdView.access$600(a) != null)
        {
            FullScreenAdView.access$600(a).a(FullScreenAdView.access$300(a));
        }
        FullScreenAdView.access$500(a);
    }

    (FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }
}
