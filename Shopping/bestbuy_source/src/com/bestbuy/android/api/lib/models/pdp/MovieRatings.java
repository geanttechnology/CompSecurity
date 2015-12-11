// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp:
//            Link

public class MovieRatings
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private Link link;
    private String rating;

    public MovieRatings()
    {
    }

    public Link getLink()
    {
        return link;
    }

    public String getRating()
    {
        return rating;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setRating(String s)
    {
        rating = s;
    }
}
