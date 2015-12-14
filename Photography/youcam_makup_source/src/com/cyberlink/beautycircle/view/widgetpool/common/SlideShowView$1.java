// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.cyberlink.beautycircle.model.Campaign;
import com.cyberlink.beautycircle.model.CampaignGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            SlideShowView

class a
    implements Runnable
{

    final CampaignGroup a;
    final SlideShowView b;

    public void run()
    {
        b.c();
        b.removeAllViews();
        SlideShowView.a(b, 0);
        if (a == null || a.campaigns == null || a.campaigns.isEmpty())
        {
            SlideShowView.a(b, true);
            b.setVisibility(8);
        } else
        {
            SlideShowView.a(b, false);
        }
        SlideShowView.a(b).clear();
        if (a != null && a.campaigns != null)
        {
            SlideShowView.a(b, a.rotationPeriod);
            Campaign campaign;
            for (Iterator iterator = a.campaigns.iterator(); iterator.hasNext(); SlideShowView.a(b, campaign))
            {
                campaign = (Campaign)iterator.next();
            }

        }
        if (SlideShowView.b(b))
        {
            b.b();
        }
    }

    (SlideShowView slideshowview, CampaignGroup campaigngroup)
    {
        b = slideshowview;
        a = campaigngroup;
        super();
    }
}
