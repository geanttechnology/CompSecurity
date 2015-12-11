// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.p;

import com.shazam.b.a.a;
import com.shazam.model.Tag;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.gimbal.AlternativeTrack;
import com.shazam.model.store.Stores;
import com.shazam.model.store.StoresAnalyticsDecorator;
import com.shazam.model.tag.AddOnFinder;
import com.shazam.model.tag.MiniTagResultItem;
import com.shazam.o.r;

public final class b
    implements a
{

    private final AddOnFinder a;
    private final StoresAnalyticsDecorator b;
    private final r c;

    public b(AddOnFinder addonfinder, StoresAnalyticsDecorator storesanalyticsdecorator, r r1)
    {
        a = addonfinder;
        b = storesanalyticsdecorator;
        c = r1;
    }

    public final Object a(Object obj)
    {
        obj = (Tag)obj;
        AlternativeTrack alternativetrack = a.a(((Tag) (obj)).track);
        if (alternativetrack == null)
        {
            return null;
        }
        obj = com.shazam.model.store.ParameterizedStores.Builder.a();
        obj.stores = alternativetrack.stores;
        obj = ((com.shazam.model.store.ParameterizedStores.Builder) (obj)).b();
        Object obj1 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj1.origin = ScreenOrigin.DETAILS;
        obj1 = ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj1)).b();
        Stores stores = b.a(((com.shazam.model.store.ParameterizedStores) (obj)), ((com.shazam.model.store.StoreAnalyticsInfo) (obj1)));
        obj1 = stores.a();
        obj = obj1;
        if (obj1 != null)
        {
            obj = com.shazam.model.store.Store.Builder.a(((com.shazam.model.store.Store) (obj1)));
            obj.trackId = alternativetrack.id;
            obj = ((com.shazam.model.store.Store.Builder) (obj)).b();
        }
        obj1 = com.shazam.model.tag.MiniTagResultItem.Builder.a();
        obj1.coverArtUrl = stores.a(alternativetrack.image);
        obj1.title = alternativetrack.title;
        obj1.artist = alternativetrack.artist;
        obj1.store = ((com.shazam.model.store.Store) (obj));
        obj1.trackId = alternativetrack.id;
        obj1.tagId = c.a();
        return new MiniTagResultItem(((com.shazam.model.tag.MiniTagResultItem.Builder) (obj1)), null);
    }
}
