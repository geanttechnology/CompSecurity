// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Feed

public static final class SearchRequest
{
    public static class AspectConstraint
    {

        public String name;
        public List value;

        public AspectConstraint()
        {
        }
    }

    public static class AspectScope
    {

        public String type;
        public String value;

        public AspectScope()
        {
        }
    }

    public static class Constraints
    {

        public List scopedAspect;

        public Constraints()
        {
        }
    }

    public static final class ImageUrl
    {

        public String url;

        public ImageUrl()
        {
        }
    }

    public static class ScopedAspect
    {

        public List aspect;
        public AspectScope scope;

        public ScopedAspect()
        {
        }
    }

    public static final class SearchRequest
    {

        public List categoryId;
        public Constraints constraints;
        public String keyword;

        public SearchRequest()
        {
        }
    }


    public String customTitle;
    public ImageUrl imageUrl;
    public String interestId;
    public SearchRequest searchRequest;
    public String title;

    public SearchRequest()
    {
    }
}
