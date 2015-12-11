// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.adapters;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.mobile.search.SearchRefineFragment;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.adapters:
//            RefineSingleOptionAdapter

public class AspectOptionAdapter extends RefineSingleOptionAdapter
{

    public AspectOptionAdapter(Context context, List list)
    {
        super(context, list);
    }

    public static String getReadableItemTitle(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
    {
        if (SearchRefineFragment.isRefineCategoryHistoDisplayEnabledByDCS)
        {
            return aspectvalue.toString();
        }
        if (!TextUtils.isEmpty(aspectvalue.serviceValue) && aspectvalue.serviceValue.equals("!"))
        {
            return SearchRefineFragment.NOT_SPECIFIED_LABEL;
        } else
        {
            return aspectvalue.value;
        }
    }

    protected String getItemTitle(com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue)
    {
        return getReadableItemTitle(aspectvalue);
    }

    protected volatile String getItemTitle(Object obj)
    {
        return getItemTitle((com.ebay.common.model.search.EbayAspectHistogram.AspectValue)obj);
    }
}
