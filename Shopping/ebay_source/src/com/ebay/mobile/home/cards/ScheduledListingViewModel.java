// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.text.TextUtils;
import com.ebay.mobile.common.view.ViewModel;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class ScheduledListingViewModel extends ViewModel
{

    public final Date date;
    public final String imageUrl;
    public final String listingId;
    public final String title;

    public ScheduledListingViewModel(int i, com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.ScheduledListing scheduledlisting, com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener)
    {
label0:
        {
            super(i, onclicklistener);
            title = scheduledlisting.title.getSourceContent();
            listingId = scheduledlisting.listingId;
            Object obj = null;
            onclicklistener = obj;
            if (scheduledlisting.images == null)
            {
                break label0;
            }
            onclicklistener = obj;
            if (scheduledlisting.images.size() <= 0)
            {
                break label0;
            }
            ListIterator listiterator = scheduledlisting.images.listIterator();
            do
            {
                onclicklistener = obj;
                if (!listiterator.hasNext())
                {
                    break label0;
                }
                onclicklistener = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.ScheduledListing.Image)listiterator.next();
            } while (TextUtils.isEmpty(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.ScheduledListing.Image) (onclicklistener)).imageUrl));
            onclicklistener = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.ScheduledListing.Image) (onclicklistener)).imageUrl;
        }
        imageUrl = onclicklistener;
        if (scheduledlisting.listingLifecycle != null && scheduledlisting.listingLifecycle.scheduledStartDate != null)
        {
            scheduledlisting = scheduledlisting.listingLifecycle.scheduledStartDate.value;
        } else
        {
            scheduledlisting = null;
        }
        date = scheduledlisting;
    }
}
