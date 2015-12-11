// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Movie;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class MovieEntity extends RetailSearchEntity
    implements Movie
{

    private String runtime;
    private String synopsis;

    public MovieEntity()
    {
    }

    public String getRuntime()
    {
        return runtime;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public void setRuntime(String s)
    {
        runtime = s;
    }

    public void setSynopsis(String s)
    {
        synopsis = s;
    }
}
