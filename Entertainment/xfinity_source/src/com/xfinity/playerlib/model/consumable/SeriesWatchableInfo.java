// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import java.util.Date;

public interface SeriesWatchableInfo
{

    public abstract Integer getEpisodeNumber();

    public abstract Date getOriginalAirdate();

    public abstract Integer getSeasonNumber();

    public abstract String getSeriesSortTitle();

    public abstract String getSeriesTitle();
}
