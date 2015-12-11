// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class p
{

    public static f a(Uri uri, Store store)
    {
        if (store != null)
        {
            store = store.getStoreId();
        } else
        {
            store = null;
        }
        return new f(uri, WeeklyAdFragment.a(store, null));
    }
}
