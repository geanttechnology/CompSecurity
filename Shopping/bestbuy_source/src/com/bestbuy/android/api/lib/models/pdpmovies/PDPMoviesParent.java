// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmovies;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpmovies:
//            SIMovies

public class PDPMoviesParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIMovies si;

    public PDPMoviesParent()
    {
    }

    public SIMovies getSi()
    {
        return si;
    }

    public void setSi(SIMovies simovies)
    {
        si = simovies;
    }
}
