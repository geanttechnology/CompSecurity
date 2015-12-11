// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FeaturedCategoriesViewModel extends ViewModel
{

    public final List featuredCategories;

    public FeaturedCategoriesViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        if (contentgroup.contents != null)
        {
            onclicklistener = new ArrayList(contentgroup.contents.size());
            contentgroup = contentgroup.contents.iterator();
            do
            {
                if (!contentgroup.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
                if (contentrecord != null)
                {
                    onclicklistener.add(contentrecord);
                }
            } while (true);
            featuredCategories = Collections.unmodifiableList(onclicklistener);
            return;
        } else
        {
            featuredCategories = Collections.emptyList();
            return;
        }
    }
}
