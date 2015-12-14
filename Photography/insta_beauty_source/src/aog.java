// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.fullscreenad.FullScreenAdView;
import java.util.HashMap;
import java.util.Map;

public class aog
    implements android.view.View.OnClickListener
{

    final FullScreenAdView a;

    public aog(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }

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
                if (!FullScreenAdView.access$300(a).startsWith("market://") && !FullScreenAdView.access$300(a).startsWith("com."))
                {
                    break label0;
                }
                ie.a(FullScreenAdView.access$400(a), FullScreenAdView.access$300(a));
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
}
