// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.Intent;
import android.view.View;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.home.cards.CategoriesViewModel;
import com.ebay.mobile.home.channels.ChannelDispatcher;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (view != null && viewmodel != null && (viewmodel instanceof CategoriesViewModel))
        {
            viewmodel = (Category)view.getTag(0x7f10000d);
            if (viewmodel != null)
            {
                if (com.ebay.nautilus.domain.data.UnifiedStream.RP.quals(((Category) (viewmodel)).destination))
                {
                    SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(view.getContext(), null);
                    searchparameters.category = new EbayCategorySummary(NumberUtil.safeParseLong(((Category) (viewmodel)).id).longValue(), ((Category) (viewmodel)).name.content);
                    view = ActivityStarter.getSearchResultListIntent(view.getContext(), searchparameters, null);
                    view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "browsecat", TrackingData.sanitize(departmentId)));
                    startActivity(view);
                    return;
                } else
                {
                    DepartmentFragment.access$500(DepartmentFragment.this).onCategorySelected(DepartmentFragment.this, viewmodel);
                    return;
                }
            }
        }
    }

    stination()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
