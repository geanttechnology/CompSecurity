// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import com.socialin.android.apiv3.model.ShopBannersResponse;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.picsart.shop:
//            h

final class t>
    implements d
{

    private h a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        for (obj = ((ShopBannersResponse)obj).response.iterator(); ((Iterator) (obj)).hasNext(); h.n(a).add(((com.socialin.android.apiv3.model.BannersResponse.ShopBanner) (request)).data))
        {
            request = (com.socialin.android.apiv3.model.BannersResponse.ShopBanner)((Iterator) (obj)).next();
        }

        if (h.n(a).size() > 0)
        {
            h.a(a, h.n(a));
        }
    }

    .Request(h h1)
    {
        a = h1;
        super();
    }
}
