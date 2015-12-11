// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialVideoCoverResource, EditorialMovieAndSeriesResource

public class FeaturedResource
{

    private final EditorialMovieAndSeriesResource movieAndSeriesResource;
    private final EditorialVideoCoverResource videoCoverResource;

    public FeaturedResource(EditorialMovieAndSeriesResource editorialmovieandseriesresource, EditorialVideoCoverResource editorialvideocoverresource)
    {
        movieAndSeriesResource = editorialmovieandseriesresource;
        videoCoverResource = editorialvideocoverresource;
    }

    public String getCoverVideoCollectionTitle()
    {
        return videoCoverResource.getCollectionTitle();
    }

    public List getCoverVideos()
    {
        return videoCoverResource.getPrograms();
    }

    public String getMovieCollectionTitle()
    {
        return movieAndSeriesResource.getMovieCollectionTitle();
    }

    public List getMovies()
    {
        return movieAndSeriesResource.getMovies();
    }

    public List getSeries()
    {
        return movieAndSeriesResource.getSeries();
    }

    public String getSeriesCollectionTitle()
    {
        return movieAndSeriesResource.getSeriesCollectionTitle();
    }
}
