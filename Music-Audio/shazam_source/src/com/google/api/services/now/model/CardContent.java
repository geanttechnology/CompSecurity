// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            BarcodeCard, GenericCard, TemplatedString, ListCard, 
//            MapCard, PhotoCard, TableCard, VideoCard

public final class CardContent extends b
{

    private BarcodeCard barcodeCard;
    private GenericCard genericCard;
    private TemplatedString justification;
    private ListCard listCard;
    private List locales;
    private MapCard mapCard;
    private PhotoCard photoCard;
    private TableCard tableCard;
    private VideoCard videoCard;

    public CardContent()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final CardContent clone()
    {
        return (CardContent)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final BarcodeCard getBarcodeCard()
    {
        return barcodeCard;
    }

    public final GenericCard getGenericCard()
    {
        return genericCard;
    }

    public final TemplatedString getJustification()
    {
        return justification;
    }

    public final ListCard getListCard()
    {
        return listCard;
    }

    public final List getLocales()
    {
        return locales;
    }

    public final MapCard getMapCard()
    {
        return mapCard;
    }

    public final PhotoCard getPhotoCard()
    {
        return photoCard;
    }

    public final TableCard getTableCard()
    {
        return tableCard;
    }

    public final VideoCard getVideoCard()
    {
        return videoCard;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final CardContent set(String s, Object obj)
    {
        return (CardContent)super.set(s, obj);
    }

    public final CardContent setBarcodeCard(BarcodeCard barcodecard)
    {
        barcodeCard = barcodecard;
        return this;
    }

    public final CardContent setGenericCard(GenericCard genericcard)
    {
        genericCard = genericcard;
        return this;
    }

    public final CardContent setJustification(TemplatedString templatedstring)
    {
        justification = templatedstring;
        return this;
    }

    public final CardContent setListCard(ListCard listcard)
    {
        listCard = listcard;
        return this;
    }

    public final CardContent setLocales(List list)
    {
        locales = list;
        return this;
    }

    public final CardContent setMapCard(MapCard mapcard)
    {
        mapCard = mapcard;
        return this;
    }

    public final CardContent setPhotoCard(PhotoCard photocard)
    {
        photoCard = photocard;
        return this;
    }

    public final CardContent setTableCard(TableCard tablecard)
    {
        tableCard = tablecard;
        return this;
    }

    public final CardContent setVideoCard(VideoCard videocard)
    {
        videoCard = videocard;
        return this;
    }
}
