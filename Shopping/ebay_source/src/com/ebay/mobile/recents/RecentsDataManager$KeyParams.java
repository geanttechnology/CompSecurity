// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.recents;

import android.text.TextUtils;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.mobile.recents:
//            RecentsDataManager

public static final class hashCode extends com.ebay.nautilus.domain.content.ams
{

    final int hashCode;
    public final String iafToken;
    public final boolean recentlyViewedOnly;

    public RecentsDataManager createManager(EbayContext ebaycontext)
    {
        return new RecentsDataManager(ebaycontext, this);
    }

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj != null && obj.getClass() == getClass())
        {
            return TextUtils.equals(((createManager)obj).iafToken, iafToken);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return hashCode;
    }

    public gerKeyParams(String s)
    {
        this(s, false);
    }

    public <init>(String s, boolean flag)
    {
        iafToken = s;
        recentlyViewedOnly = flag;
        if (s == null)
        {
            throw new IllegalArgumentException("KeyParams must be constructed with a valid iafToken");
        }
        int j = com/ebay/mobile/recents/RecentsDataManager$KeyParams.getName().hashCode();
        int k = s.hashCode();
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        hashCode = (j * 31 + k) * 31 + i;
    }
}
