// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class SearchRequest
{
    public static final class FollowedImageUrl
    {

        public String thumbs;

        public FollowedImageUrl()
        {
        }
    }

    public static final class SearchRequest
    {

        public List categoryId;
        public String keyword;

        public SearchRequest()
        {
        }
    }


    public com.ebay.nautilus.domain.data.nterestEntity.SearchRequest createdDate;
    public String customTitle;
    public FollowedImageUrl imageUrl;
    public String interestId;
    public String marketplaceId;
    public SearchRequest searchRequest;
    public String searchUrl;
    public String title;

    public SearchRequest()
    {
    }
}
