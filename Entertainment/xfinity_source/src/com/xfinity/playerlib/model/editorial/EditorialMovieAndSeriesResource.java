// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import java.util.List;

public class EditorialMovieAndSeriesResource
{

    private final String movieCollectionTitle;
    private final List movies;
    private final List series;
    private final String seriesCollectionTitle;

    public EditorialMovieAndSeriesResource(List list, String s, List list1, String s1)
    {
        movies = list;
        movieCollectionTitle = s;
        series = list1;
        seriesCollectionTitle = s1;
    }

    public String getMovieCollectionTitle()
    {
        return movieCollectionTitle;
    }

    public List getMovies()
    {
        return movies;
    }

    public List getSeries()
    {
        return series;
    }

    public String getSeriesCollectionTitle()
    {
        return seriesCollectionTitle;
    }
}
