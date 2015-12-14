// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.i;
import com.cyberlink.youcammakeup.clflurry.w;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.ba;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements android.view.OnClickListener
{

    final d a;

    public void onClick(View view)
    {
        view = d.g(a).e();
        if (!(view instanceof ba))
        {
            return;
        }
        view = (ba)view;
        view = new com.cyberlink.youcammakeup.utility.mplateUtils.SkuTryItUrl(d.c(a), view.n(), view.h(), StatusManager.j().e());
        if (view != null)
        {
            String s = ((com.cyberlink.youcammakeup.utility.mplateUtils.SkuTryItUrl) (view)).type;
            String s1 = ((com.cyberlink.youcammakeup.utility.mplateUtils.SkuTryItUrl) (view)).skuGuid;
            String s2 = ((com.cyberlink.youcammakeup.utility.mplateUtils.SkuTryItUrl) (view)).itemGuid;
            b.a(new i(s, s1, s2));
            b.a(new w(SkuTemplateUtils.i(s), s1, s2));
        }
        Intent intent = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        intent.putExtra("RedirectUrl", view);
        a.startActivity(intent);
    }

    vity(d d1)
    {
        a = d1;
        super();
    }
}
