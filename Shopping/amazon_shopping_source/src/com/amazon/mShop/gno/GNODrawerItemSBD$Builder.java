// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSBD, GNODrawerItemGroup, GNODrawerItemHideable, GNODrawerItemSimple

public static class r extends r
{

    public volatile GNODrawerItemGroup build()
    {
        return build();
    }

    public volatile GNODrawerItemHideable build()
    {
        return build();
    }

    public GNODrawerItemSBD build()
    {
        return (GNODrawerItemSBD)super.build();
    }

    public volatile GNODrawerItemSimple build()
    {
        return build();
    }

    public r(Context context, String s)
    {
        super(new GNODrawerItemSBD(context, s));
    }
}
