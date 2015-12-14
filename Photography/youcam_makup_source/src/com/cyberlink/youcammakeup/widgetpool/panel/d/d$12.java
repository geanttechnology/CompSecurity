// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.clflurry.YMKClicksLipsCartEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import java.net.URI;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements android.view.OnClickListener
{

    final com.cyberlink.youcammakeup.widgetpool.panel.d.d a;

    public void onClick(View view)
    {
        view = d.g(a).e();
        if (view instanceof ba)
        {
            view = (ba)view;
            view = h.b().a(d.c(a), view.n(), view.h());
            if (view != null)
            {
                Object obj = h.b().a(d.c(a), d.a(a)).d();
                if (obj != null && !((String) (obj)).isEmpty())
                {
                    b.a(new YMKClicksLipsCartEvent(((String) (obj)), view.a()));
                }
                obj = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
                ((Intent) (obj)).putExtra("RedirectUrl", view.c().toString());
                a.startActivity(((Intent) (obj)));
                return;
            }
        }
    }

    vity(com.cyberlink.youcammakeup.widgetpool.panel.d.d d1)
    {
        a = d1;
        super();
    }
}
