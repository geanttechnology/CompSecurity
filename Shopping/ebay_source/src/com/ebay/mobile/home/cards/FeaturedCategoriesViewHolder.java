// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Department;
import com.ebay.nautilus.domain.data.cos.base.Text;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            FeaturedCategoriesViewModel

public class FeaturedCategoriesViewHolder extends ViewHolder
{

    private final SparseArray featuredCategoryViews = new SparseArray(6);

    public FeaturedCategoriesViewHolder(View view)
    {
        super(view);
        view = findViewsByIds(view, new int[] {
            0x7f10025b, 0x7f10025c, 0x7f10025d, 0x7f10025e, 0x7f10025f, 0x7f100260
        });
        for (int i = 0; i < view.size(); i++)
        {
            TextView textview = (TextView)view.get(i);
            textview.setOnClickListener(this);
            featuredCategoryViews.put(i, textview);
        }

    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (!(viewmodel instanceof FeaturedCategoriesViewModel)) goto _L2; else goto _L1
_L1:
        int i;
        viewmodel = ((FeaturedCategoriesViewModel)viewmodel).featuredCategories;
        i = 0;
_L4:
        if (i < featuredCategoryViews.size())
        {
            TextView textview = (TextView)featuredCategoryViews.get(i);
            if (viewmodel.size() > i)
            {
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)viewmodel.get(i);
                if (contentrecord.type == ContentTypeEnum.DEPARTMENT && contentrecord.department != null && contentrecord.department.name != null && contentrecord.department.displayName != null && contentrecord.department.displayName.content != null)
                {
                    textview.setTag(0x7f10000c, ContentTypeEnum.DEPARTMENT);
                    textview.setTag(0x7f10000a, contentrecord.department.name);
                    textview.setTag(0x7f10000b, contentrecord.department.displayName.content);
                    textview.setTag(0x7f100009, contentrecord.department.topBannerSmall);
                    textview.setText(contentrecord.department.displayName.content);
                } else
                if (contentrecord.type == ContentTypeEnum.CATEGORY && contentrecord.category != null && contentrecord.category.name != null)
                {
                    textview.setTag(0x7f10000c, ContentTypeEnum.CATEGORY);
                    textview.setTag(0x7f10000a, contentrecord.category.id);
                    textview.setText(contentrecord.category.name.content);
                }
                textview.setVisibility(0);
            } else
            {
                textview.setVisibility(4);
            }
            i++;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
