// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.google.gson.Gson;
import java.util.UUID;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

public static final class rKeyParams extends com.ebay.nautilus.domain.content.rams
{

    public final String uniquifier = UUID.randomUUID().toString();

    public static rKeyParams fromString(String s)
    {
        return (rKeyParams)DataMapperFactory.getDefaultMapper().fromJson(s, com/ebay/common/content/dm/SearchDataManager$KeyParams);
    }

    public SearchDataManager createManager(EbayContext ebaycontext)
    {
        return new SearchDataManager(ebaycontext, com/ebay/common/content/dm/SearchDataManager$Observer, this);
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
        if (obj == null || obj.getClass() != getClass())
        {
            return false;
        } else
        {
            obj = (createManager)obj;
            return uniquifier.equals(((uniquifier) (obj)).uniquifier);
        }
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + uniquifier.hashCode();
    }

    public String toString()
    {
        return DataMapperFactory.getDefaultMapper().toJson(this);
    }

    public rKeyParams()
    {
    }
}
