// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmovies;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmovies:
//            MovieDetails, MovieNames

public class MoviesResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private MovieDetails movieDetails;
    private MovieNames names;
    private String productType;
    private String skuId;

    public MoviesResponse()
    {
    }

    public MovieDetails getMovieDetails()
    {
        return movieDetails;
    }

    public MovieNames getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setMovieDetails(MovieDetails moviedetails)
    {
        movieDetails = moviedetails;
    }

    public void setNames(MovieNames movienames)
    {
        names = movienames;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
