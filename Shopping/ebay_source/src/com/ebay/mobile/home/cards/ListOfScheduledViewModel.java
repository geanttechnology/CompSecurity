// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ScheduledListingViewModel

public class ListOfScheduledViewModel extends ViewModel
{

    public final String groupTitle;
    public final List scheduledListings = new ArrayList();

    public ListOfScheduledViewModel(int i, String s, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
        super(i, onclicklistener);
        groupTitle = s;
    }

    public static ListOfScheduledViewModel createFromScheduledListings(int i, String s, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener1)
    {
        s = new ListOfScheduledViewModel(i, s, onclicklistener1);
        if (contentgroup.contents != null)
        {
            contentgroup = contentgroup.contents.iterator();
            do
            {
                if (!contentgroup.hasNext())
                {
                    break;
                }
                onclicklistener1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contentgroup.next();
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener1)).scheduledListing != null)
                {
                    ((ListOfScheduledViewModel) (s)).scheduledListings.add(new ScheduledListingViewModel(i, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (onclicklistener1)).scheduledListing, onclicklistener));
                }
            } while (true);
        }
        return s;
    }
}
