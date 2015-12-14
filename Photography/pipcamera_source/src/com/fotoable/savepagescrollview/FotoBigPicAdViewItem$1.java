// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.savepagescrollview;

import android.view.View;
import android.widget.Button;
import com.flurry.android.FlurryAgent;
import java.util.HashMap;
import java.util.Map;
import nx;

// Referenced classes of package com.fotoable.savepagescrollview:
//            FotoBigPicAdViewItem

class a
    implements android.view.BigPicAdViewItem._cls1
{

    final FotoBigPicAdViewItem a;

    public void onClick(View view)
    {
        if (FotoBigPicAdViewItem.access$000(a) == null)
        {
            FotoBigPicAdViewItem.access$002(a, new HashMap());
        }
        view = (nx)view.getTag();
        if (FotoBigPicAdViewItem.access$100(a).getText().equals("Open"))
        {
            FotoBigPicAdViewItem.access$200(a, ((nx) (view)).e);
            FotoBigPicAdViewItem.access$000(a).put(a.SavePageScrollOpened, ((nx) (view)).a);
        } else
        {
            FotoBigPicAdViewItem.access$300(a, ((nx) (view)).f);
            FotoBigPicAdViewItem.access$000(a).put(a.SavePageScrollClicked, ((nx) (view)).a);
        }
        FlurryAgent.logEvent(a.SavePageScrollClicked, FotoBigPicAdViewItem.access$000(a));
    }

    (FotoBigPicAdViewItem fotobigpicadviewitem)
    {
        a = fotobigpicadviewitem;
        super();
    }
}
