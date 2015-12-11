// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.view.View;
import com.amazon.venezia.web.NoConnectionViewAdapter;
import com.amazon.venezia.web.NoConnectionViewAdapterFactory;

// Referenced classes of package com.amazon.mShop.appstore:
//            SnuffyNoConnectionViewAdapter

public class SnuffyNoConnectionViewAdapterFactory
    implements NoConnectionViewAdapterFactory
{

    public SnuffyNoConnectionViewAdapterFactory()
    {
    }

    public NoConnectionViewAdapter createNoConnectionViewAdapter(View view, int i)
    {
        return new SnuffyNoConnectionViewAdapter(view, i);
    }
}
