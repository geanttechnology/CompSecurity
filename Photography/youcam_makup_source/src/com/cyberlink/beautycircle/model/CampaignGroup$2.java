// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CampaignGroup

final class a extends j
{

    final String a;

    public CampaignGroup a(ArrayList arraylist)
    {
        if (arraylist == null)
        {
            return null;
        }
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            CampaignGroup campaigngroup = (CampaignGroup)arraylist.next();
            if (campaigngroup.name.equals(a.toString()))
            {
                return campaigngroup;
            }
        }

        return null;
    }

    public volatile Object a(Object obj)
    {
        return a((ArrayList)obj);
    }

    (String s)
    {
        a = s;
        super();
    }
}
