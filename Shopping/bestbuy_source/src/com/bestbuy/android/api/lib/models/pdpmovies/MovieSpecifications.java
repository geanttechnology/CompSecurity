// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmovies;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmovies:
//            MovieLink

public class MovieSpecifications
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private MovieLink link;
    private String value;

    public MovieSpecifications()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public MovieLink getLink()
    {
        return link;
    }

    public String getValue()
    {
        return value;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setLink(MovieLink movielink)
    {
        link = movielink;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
