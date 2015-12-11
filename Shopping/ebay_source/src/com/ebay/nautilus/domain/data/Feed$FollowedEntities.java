// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Feed

public static final class UserInfo
{
    public static final class CollectionInfo
    {

        public String collectionId;
        public boolean hiddenFeedEvents;

        public CollectionInfo()
        {
        }
    }

    public static final class InterestInfo
    {

        public boolean hiddenFeedEvents;
        public String interestId;

        public InterestInfo()
        {
        }
    }

    public static final class UserInfo
    {

        public boolean hiddenFeedEvents;
        public String userId;

        public UserInfo()
        {
        }
    }


    public List collections;
    public List interests;
    public List users;

    public UserInfo()
    {
    }
}
