// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;

// Referenced classes of package com.target.ui.util.deep_link:
//            PromotionParams, e, f

class s
{

    public static f a(Uri uri, Store store)
    {
        return b(uri, store);
    }

    private static f b(Uri uri, Store store)
    {
        Object obj = uri.getQueryParameter("code");
        String s1 = uri.getQueryParameter("type");
        store = uri.getQueryParameter("deeplink");
        obj = new PromotionParams(s1, ((String) (obj)));
        if (o.g(store))
        {
            ((PromotionParams) (obj)).a(Uri.parse(store));
        }
        store = new e();
        store.a(((PromotionParams) (obj)));
        return new f(uri, f.a.PROMOTION, store);
    }
}
