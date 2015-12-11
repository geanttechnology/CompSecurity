// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shazam.android.ag.g.e;
import com.shazam.android.k.i;
import com.shazam.f.d.a;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Stores;

// Referenced classes of package com.shazam.android.l:
//            b

public final class h
    implements b
{

    private final Context a;
    private final i b;
    private final OrderedPurchaseOptions c;

    public h(Context context, i i, OrderedPurchaseOptions orderedpurchaseoptions)
    {
        a = context;
        b = i;
        c = orderedpurchaseoptions;
    }

    public final Object a(Object obj)
    {
        obj = ((Tag)obj).track;
        Object obj1 = c;
        Object obj2 = ((Track) (obj)).stores;
        com.shazam.model.store.StoreAnalyticsInfo.Builder builder = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        builder.trackId = ((Track) (obj)).id;
        obj1 = ((OrderedPurchaseOptions) (obj1)).a(((Stores) (obj2)), builder.b(), ((Track) (obj)).urlParams);
        obj = a.getString(0x7f09004d);
        obj1 = ((Stores) (obj1)).a();
        obj2 = e.a(((com.shazam.model.store.Store) (obj1)), b);
        if (obj2 != null)
        {
            boolean flag;
            if (obj2 == null || ((Intent) (obj2)).getData() == null)
            {
                flag = false;
            } else
            {
                flag = "shazaminternal".equals(((Intent) (obj2)).getData().getScheme());
            }
            if (flag)
            {
                ((Intent) (obj2)).setPackage(a.getPackageName());
            }
            return new android.support.v4.app.u.a(0x7f020046, ((CharSequence) (obj)), PendingIntent.getActivity(a, 0, ((Intent) (obj2)), 0x8000000));
        } else
        {
            throw new a((new StringBuilder("Unable to find valid intent in store: ")).append(obj1).toString());
        }
    }
}
