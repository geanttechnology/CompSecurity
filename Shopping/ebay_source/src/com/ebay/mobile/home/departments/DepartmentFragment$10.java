// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment, DepartmentFragmentActivity

class this._cls0
    implements com.ebay.mobile.common.view.ner
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if ((viewmodel instanceof FeaturedCategoriesViewModel) && view != null)
        {
            viewmodel = view.getContext();
            ContentTypeEnum contenttypeenum = (ContentTypeEnum)view.getTag(0x7f10000c);
            String s = (String)view.getTag(0x7f10000a);
            Object obj = (String)view.getTag(0x7f100009);
            String s1 = (String)view.getTag(0x7f10000b);
            if (contenttypeenum != null && s != null && !s.isEmpty())
            {
                String s2 = TrackingData.sanitize(departmentId);
                SourceIdentification sourceidentification = new SourceIdentification(getTrackingEventName(), "featcat", s2);
                switch (.SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum[contenttypeenum.ordinal()])
                {
                default:
                    return;

                case 1: // '\001'
                    view = new Intent(viewmodel, com/ebay/mobile/home/departments/DepartmentFragmentActivity);
                    view.putExtra("departmentId", s);
                    view.putExtra("departmentTitle", s1);
                    view.putExtra("backgroundUrl", ((String) (obj)));
                    view.putExtra("isDepartment", true);
                    view.putExtra("parentDepartmentId", s2);
                    view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                    viewmodel.startActivity(view);
                    return;

                case 2: // '\002'
                    obj = eBayDictionaryProvider.getLockedSearchParameters(viewmodel, null);
                    break;
                }
                obj.category = new EbayCategorySummary(NumberUtil.safeParseLong(s).longValue(), ((TextView)view).getText().toString());
                view = ActivityStarter.getSearchResultListIntent(viewmodel, ((SearchParameters) (obj)), null);
                view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                viewmodel.startActivity(view);
                return;
            }
        }
    }

    vity()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
