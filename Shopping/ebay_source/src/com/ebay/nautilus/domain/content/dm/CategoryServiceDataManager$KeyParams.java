// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            CategoryServiceDataManager

public static final class ebaySite extends com.ebay.nautilus.domain.content.ms
{

    public final EbaySite ebaySite;

    public volatile DataManager createManager(EbayContext ebaycontext)
    {
        return createManager(ebaycontext);
    }

    public CategoryServiceDataManager createManager(EbayContext ebaycontext)
    {
        return new CategoryServiceDataManager(ebaycontext, this);
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof createManager) && ebaySite.equals(((ebaySite)obj).ebaySite);
    }

    public int hashCode()
    {
        return super.Code() * 31 + ebaySite.hashCode();
    }

    public (EbaySite ebaysite)
    {
        if (ebaysite == null)
        {
            throw new IllegalArgumentException("EbaySite must be non-null!");
        } else
        {
            ebaySite = ebaysite;
            return;
        }
    }
}
