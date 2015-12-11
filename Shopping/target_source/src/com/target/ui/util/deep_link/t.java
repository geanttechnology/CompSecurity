// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import android.net.Uri;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.common.SimpleThankYouDialogFragment;

// Referenced classes of package com.target.ui.util.deep_link:
//            f

class t
{

    public static f a(Uri uri, Store store)
    {
        return b(uri, store);
    }

    private static f b(Uri uri, Store store)
    {
        return new f(uri, SimpleThankYouDialogFragment.a(uri.getQueryParameter("message")));
    }
}
