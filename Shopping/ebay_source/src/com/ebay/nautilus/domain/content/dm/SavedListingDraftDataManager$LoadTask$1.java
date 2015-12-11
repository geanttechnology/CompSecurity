// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.ListingDraft;
import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager

class this._cls1
    implements Comparator
{

    final compare this$1;

    public int compare(ListingDraft listingdraft, ListingDraft listingdraft1)
    {
        return listingdraft1.lastModified.getDateValue().compareTo(listingdraft.lastModified.getDateValue());
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ListingDraft)obj, (ListingDraft)obj1);
    }

    Q()
    {
        this$1 = this._cls1.this;
        super();
    }
}
