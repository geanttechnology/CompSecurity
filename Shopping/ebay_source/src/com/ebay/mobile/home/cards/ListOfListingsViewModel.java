// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListingViewModel

public class ListOfListingsViewModel extends ViewModel
{

    public String categoryId;
    public boolean hasMoreListings;
    public final List listings = new ArrayList();
    public String listingsTitle;

    private ListOfListingsViewModel(int i, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        listingsTitle = null;
        categoryId = null;
    }

    public static ListOfListingsViewModel createFromContentRecordListings(int i, String s, String s1, List list, boolean flag, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1)
    {
        onclicklistener1 = new ListOfListingsViewModel(i, onclicklistener1);
        onclicklistener1.listingsTitle = s;
        onclicklistener1.categoryId = s1;
        onclicklistener1.hasMoreListings = flag;
        s = list.iterator();
        do
        {
            if (!s.hasNext())
            {
                break;
            }
            s1 = new ListingViewModel(i, (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)s.next(), onclicklistener);
            if (s1.isValid())
            {
                ((ListOfListingsViewModel) (onclicklistener1)).listings.add(s1);
            }
        } while (true);
        return onclicklistener1;
    }
}
