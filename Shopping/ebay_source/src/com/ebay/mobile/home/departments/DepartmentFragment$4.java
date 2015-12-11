// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.deals.BrowseDealsActivity;
import com.ebay.mobile.deals.DealsDetailsActivity;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewModel;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.cos.base.Text;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (!(viewmodel instanceof ListOfListingsViewModel)) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = (ListOfListingsViewModel)viewmodel;
        obj1 = getActivity();
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (departmentId.equals(ChannelEnum.DEALS.name()))
        {
            DealsDetailsActivity.startActivity(((Activity) (obj1)), ((ListOfListingsViewModel) (obj)).listingsTitle, ((ListOfListingsViewModel) (obj)).categoryId, true);
        } else
        {
            Intent intent1 = new Intent(((android.content.Context) (obj1)), com/ebay/mobile/deals/BrowseDealsActivity);
            intent1.putExtra("top_level_channel", ChannelEnum.SHOP.name());
            if (hasCarousel())
            {
                intent1.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
            } else
            {
                intent1.putExtra("browse_type", "SUB_DEPARTMENT");
            }
            intent1.putExtra("department_id", ((ListOfListingsViewModel) (obj)).categoryId);
            intent1.putExtra("department_title", departmentTitle);
            intent1.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", TrackingData.sanitize(departmentId)));
            ((Activity) (obj1)).startActivity(intent1);
        }
_L2:
        if (viewmodel instanceof FeaturedCategoriesViewModel)
        {
            obj = (FeaturedCategoriesViewModel)viewmodel;
            if (view != null)
            {
                viewmodel = (String)view.getTag(0x7f10000a);
                view = null;
                obj = ((FeaturedCategoriesViewModel) (obj)).featuredCategories.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    obj1 = (com.ebay.nautilus.domain.data.UnifiedStream..ContentRecord)((Iterator) (obj)).next();
                    if (((com.ebay.nautilus.domain.data.UnifiedStream..ContentRecord) (obj1)).category != null && ((com.ebay.nautilus.domain.data.UnifiedStream..ContentRecord) (obj1)).category.id == viewmodel)
                    {
                        view = ((com.ebay.nautilus.domain.data.UnifiedStream..ContentRecord) (obj1)).category;
                    }
                } while (true);
                if (view != null)
                {
                    viewmodel = getActivity();
                    if (viewmodel != null)
                    {
                        Intent intent = new Intent(viewmodel, com/ebay/mobile/deals/BrowseDealsActivity);
                        intent.putExtra("top_level_channel", ChannelEnum.SHOP.name());
                        if (hasCarousel())
                        {
                            intent.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
                        } else
                        {
                            intent.putExtra("browse_type", "SUB_DEPARTMENT");
                        }
                        intent.putExtra("department_id", ((Category) (view)).id);
                        intent.putExtra("department_title", ((Category) (view)).name.content);
                        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", TrackingData.sanitize(((Category) (view)).id)));
                        viewmodel.startActivity(intent);
                        return;
                    }
                }
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    ontentGroup.ContentRecord()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
