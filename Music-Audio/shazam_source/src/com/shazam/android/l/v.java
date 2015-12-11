// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.android.k.f.t;
import com.shazam.b.a.a;
import com.shazam.model.Art;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.TrackCategory;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.TrackStyle;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Stores;

public final class v
    implements a
{

    private final t a;
    private final a b;
    private final OrderedPurchaseOptions c;

    public v(t t1, a a1, OrderedPurchaseOptions orderedpurchaseoptions)
    {
        a = t1;
        b = a1;
        c = orderedpurchaseoptions;
    }

    public final Object a(Object obj)
    {
        boolean flag1 = true;
        obj = (Tag)obj;
        Object obj2 = ((Tag) (obj)).track;
        Object obj1 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj1.trackId = ((Track) (obj2)).id;
        obj1.origin = ScreenOrigin.MY_SHAZAM;
        obj1.campaign = ((Track) (obj2)).campaign;
        if (((Track) (obj2)).category != null)
        {
            obj1.trackCategory = ((Track) (obj2)).category.toString();
        }
        Object obj3 = ((Track) (obj2)).trackStyle;
        if (obj3 != null)
        {
            obj1.trackStyle = ((TrackStyle) (obj3)).getStyle();
        }
        obj1 = ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj1)).b();
        Stores stores = c.a(((Track) (obj2)).stores, ((com.shazam.model.store.StoreAnalyticsInfo) (obj1)), ((Track) (obj2)).urlParams);
        obj1 = com.shazam.model.myshazam.MyShazamTag.Builder.a();
        obj1.requestId = ((Tag) (obj)).requestId;
        obj1.trackId = ((Track) (obj2)).id;
        obj1.timestamp = Long.valueOf(((Tag) (obj)).timestamp);
        obj1.trackTitle = ((Track) (obj2)).title;
        obj1.trackStyle = ((TrackStyle) (obj3));
        obj1.artistsDescription = ((Track) (obj2)).artistName;
        obj1.store = stores.a();
        obj1.isFull = ((Track) (obj2)).isFull;
        boolean flag;
        if (((Tag) (obj)).status == com.shazam.model.Tag.Status.VISUAL && ((Track) (obj2)).trackLayoutType == TrackLayoutType.LOCAL_WEB)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag1 = false;
        }
        obj1.publishable = flag1;
        obj1.post = ((Tag) (obj)).post;
        obj2 = ((Track) (obj2)).art;
        if (obj2 != null)
        {
            obj1.artUrl = ((Art) (obj2)).url;
        }
        obj2 = a.a(((Tag) (obj)));
        obj3 = com.shazam.model.details.UriIdentifiedTag.Builder.a();
        obj3.tag = ((Tag) (obj));
        obj3.uri = ((android.net.Uri) (obj2));
        obj = ((com.shazam.model.details.UriIdentifiedTag.Builder) (obj3)).b();
        obj1.previewViewData = (PreviewViewData)b.a(obj);
        return ((com.shazam.model.myshazam.MyShazamTag.Builder) (obj1)).b();
    }
}
