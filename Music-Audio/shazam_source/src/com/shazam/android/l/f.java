// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.android.k.f.t;
import com.shazam.b.a.a;
import com.shazam.model.AutoTag;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Stores;
import com.shazam.server.response.recognition.Images;
import com.shazam.server.response.recognition.Match;

public final class f
    implements a
{

    private final t a;
    private final a b;
    private final OrderedPurchaseOptions c;

    public f(t t1, a a1, OrderedPurchaseOptions orderedpurchaseoptions)
    {
        a = t1;
        b = a1;
        c = orderedpurchaseoptions;
    }

    public final Object a(Object obj)
    {
        Object obj2 = (AutoTag)obj;
        obj = ((AutoTag) (obj2)).match;
        Object obj1 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj1.trackId = ((Match) (obj)).trackId;
        obj1 = ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj1)).b();
        Object obj3 = c.a(((Match) (obj)).stores, ((com.shazam.model.store.StoreAnalyticsInfo) (obj1)), ((Match) (obj)).urlParams);
        obj1 = com.shazam.model.myshazam.MyShazamTag.Builder.a();
        obj1.requestId = ((AutoTag) (obj2)).uuid;
        obj1.trackId = ((Match) (obj)).trackId;
        obj1.timestamp = Long.valueOf(((AutoTag) (obj2)).timestamp);
        obj1.trackTitle = ((Match) (obj)).title;
        obj1.artistsDescription = ((Match) (obj)).description;
        obj1.store = ((Stores) (obj3)).a();
        obj1.isFull = true;
        obj2 = a.a(((AutoTag) (obj2)));
        obj3 = com.shazam.model.details.UriIdentifiedTag.Builder.a();
        obj3.uri = ((android.net.Uri) (obj2));
        obj2 = ((com.shazam.model.details.UriIdentifiedTag.Builder) (obj3)).b();
        obj1.previewViewData = (PreviewViewData)b.a(obj2);
        obj = ((Match) (obj)).images;
        if (obj != null)
        {
            obj1.artUrl = ((Images) (obj)).getLargestAvailableImage();
        }
        return ((com.shazam.model.myshazam.MyShazamTag.Builder) (obj1)).b();
    }
}
