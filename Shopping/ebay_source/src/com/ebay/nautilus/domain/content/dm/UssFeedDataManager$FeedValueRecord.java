// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UssFeedDataManager

public class rtm
{

    public com.ebay.nautilus.domain.data.UnifiedStream..Collection collection;
    public com.ebay.nautilus.domain.data.UnifiedStream..Listing listing;
    public com.ebay.nautilus.domain.data.UnifiedStream..RppEventGroup rppEventGroup;
    public com.ebay.nautilus.domain.data.UnifiedStream..Rtm rtm;
    final UssFeedDataManager this$0;
    public String title;
    public ContentTypeEnum type;

    public ntRecord.Collection(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream..Collection collection1)
    {
        this$0 = UssFeedDataManager.this;
        super();
        type = contenttypeenum;
        title = s;
        collection = collection1;
    }

    public ntRecord.Listing(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream..Listing listing1)
    {
        this$0 = UssFeedDataManager.this;
        super();
        type = contenttypeenum;
        title = s;
        listing = listing1;
    }

    public ntRecord.RppEventGroup(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream..RppEventGroup rppeventgroup)
    {
        this$0 = UssFeedDataManager.this;
        super();
        type = contenttypeenum;
        title = s;
        rppEventGroup = rppeventgroup;
    }

    public ntRecord.Rtm(ContentTypeEnum contenttypeenum, String s, com.ebay.nautilus.domain.data.UnifiedStream..Rtm rtm1)
    {
        this$0 = UssFeedDataManager.this;
        super();
        type = contenttypeenum;
        title = s;
        rtm = rtm1;
    }
}
