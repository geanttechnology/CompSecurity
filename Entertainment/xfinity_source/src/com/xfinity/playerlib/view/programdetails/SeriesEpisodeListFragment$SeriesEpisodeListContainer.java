// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.xfinity.playerlib.model.consumable.SeriesWatchable;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEpisodeListFragment

public static interface 
{

    public abstract boolean shouldShowSeriesListItemsChecked();

    public abstract void showSeriesDetail();

    public abstract void showSeriesWatchableDetail(SeriesWatchable serieswatchable);
}
