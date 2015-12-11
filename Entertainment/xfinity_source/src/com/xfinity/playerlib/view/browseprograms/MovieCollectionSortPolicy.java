// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            MoviesSortPolicy

public class MovieCollectionSortPolicy extends MoviesSortPolicy
{

    public MovieCollectionSortPolicy(PlayNowUserManager playnowusermanager)
    {
        super(playnowusermanager);
    }

    public SortPolicy.SortType getCurrentSortType()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getMovieCollectionSort();
    }

    public void setCurrentSortType(SortPolicy.SortType sorttype)
    {
        ((PlayerUserSettings)userManager.getUserSettings()).setMovieCollectionSort(sorttype);
    }
}
