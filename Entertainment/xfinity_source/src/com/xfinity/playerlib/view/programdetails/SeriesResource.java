// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Map;
import org.apache.commons.lang3.Validate;

public class SeriesResource
{

    public final Map bookmarkMap;
    public final DibicResource dibicResource;
    public final VideoEntitlement entitlement;
    public final TvSeriesFacade tvSeriesFacade;

    public SeriesResource(VideoEntitlement videoentitlement, TvSeriesFacade tvseriesfacade, DibicResource dibicresource, Map map)
    {
        Validate.notNull(videoentitlement);
        Validate.notNull(tvseriesfacade);
        Validate.notNull(dibicresource);
        Validate.notNull(map);
        entitlement = videoentitlement;
        tvSeriesFacade = tvseriesfacade;
        dibicResource = dibicresource;
        bookmarkMap = map;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (SeriesResource)obj;
            if (!bookmarkMap.equals(((SeriesResource) (obj)).bookmarkMap))
            {
                return false;
            }
            if (!dibicResource.equals(((SeriesResource) (obj)).dibicResource))
            {
                return false;
            }
            if (!entitlement.equals(((SeriesResource) (obj)).entitlement))
            {
                return false;
            }
            if (!tvSeriesFacade.equals(((SeriesResource) (obj)).tvSeriesFacade))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ((entitlement.hashCode() * 31 + tvSeriesFacade.hashCode()) * 31 + dibicResource.hashCode()) * 31 + bookmarkMap.hashCode();
    }
}
