// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsTest

public static final class ngs
    implements com.ebay.nautilus.domain.dcs.
{

    public List getProperties()
    {
        int i = ApiSettings.values().length + EbaySettings.values().length;
        if (i == 0)
        {
            return Collections.emptyList();
        } else
        {
            ArrayList arraylist = new ArrayList(i);
            Collections.addAll(arraylist, ApiSettings.values());
            Collections.addAll(arraylist, EbaySettings.values());
            return Collections.unmodifiableList(arraylist);
        }
    }

    public ngs()
    {
    }
}
