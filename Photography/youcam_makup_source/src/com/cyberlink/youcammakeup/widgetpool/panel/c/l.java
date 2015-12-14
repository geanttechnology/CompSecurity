// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.content.Context;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            n

public class l extends n
{

    private String e;

    public l(Context context, BeautyMode beautymode, String s)
    {
        super(context, beautymode);
        e = s;
        a();
    }

    protected void a()
    {
        if (e != null)
        {
            PanelDataCenter paneldatacenter = PanelDataCenter.a();
            List list = paneldatacenter.b(e, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c);
            list.addAll(paneldatacenter.b(e, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a));
            list.addAll(paneldatacenter.b(e, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b));
            list.addAll(paneldatacenter.b(e, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d));
            int i = 0;
            while (i < list.size()) 
            {
                ax ax1 = PanelDataCenter.a().p((String)list.get(i));
                if (ax1 != null)
                {
                    b.add(new p(ax1.c(), ax1.a(), ax1.d(), ax1.e().booleanValue(), ax1.i()));
                }
                i++;
            }
        }
    }
}
