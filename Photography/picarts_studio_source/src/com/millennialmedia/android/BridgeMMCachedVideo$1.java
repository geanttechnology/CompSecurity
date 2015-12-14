// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            BridgeMMCachedVideo, VideoAd, CachedAd

class > extends >
{

    private Context a;
    private JSONArray b;

    final boolean a(CachedAd cachedad)
    {
        if ((cachedad instanceof VideoAd) && cachedad.isOnDisk(a) && !cachedad.isExpired())
        {
            b.put(cachedad.getId());
        }
        return true;
    }

    (Context context, JSONArray jsonarray)
    {
        a = context;
        b = jsonarray;
        super();
    }
}
