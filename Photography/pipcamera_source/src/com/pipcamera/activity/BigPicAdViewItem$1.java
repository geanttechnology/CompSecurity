// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;
import rt;

// Referenced classes of package com.pipcamera.activity:
//            BigPicAdViewItem

class a
    implements android.view.r
{

    final BigPicAdViewItem a;

    public void onClick(View view)
    {
        if (BigPicAdViewItem.access$000(a) == null)
        {
            BigPicAdViewItem.access$002(a, new HashMap());
        }
        view = (rt)view.getTag();
        if (BigPicAdViewItem.access$100(a).getText().equals(a.getResources().getText(0x7f060180)))
        {
            BigPicAdViewItem.access$200(a, ((rt) (view)).f);
            BigPicAdViewItem.access$000(a).put(a.SavePageScrollOpened, ((rt) (view)).a);
        } else
        {
            BigPicAdViewItem.access$300(a, ((rt) (view)).g);
            BigPicAdViewItem.access$000(a).put(a.SavePageScrollClicked, ((rt) (view)).a);
        }
        FlurryAgent.logEvent(a.SavePageScrollClicked, BigPicAdViewItem.access$000(a));
    }

    (BigPicAdViewItem bigpicadviewitem)
    {
        a = bigpicadviewitem;
        super();
    }
}
