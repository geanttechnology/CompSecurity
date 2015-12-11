// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            TrendItemViewModel

public class ListOfTrendingViewModel extends ViewModel
{

    private static String DELTA_TYPE_NONE = "NONE";
    public int trendAnchor;
    public final List trends = new ArrayList();

    public ListOfTrendingViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
    }

    public static ListOfTrendingViewModel createFromTrendingTopics(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1)
    {
        onclicklistener1 = new ListOfTrendingViewModel(i, onclicklistener1);
        if (contentgroup.contents != null)
        {
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord;
            for (contentgroup = contentgroup.contents.iterator(); contentgroup.hasNext(); ((ListOfTrendingViewModel) (onclicklistener1)).trends.add(new TrendItemViewModel(i, onclicklistener, contentrecord.topic)))
            {
                contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
            }

        }
        return onclicklistener1;
    }

}
