// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemHideable, GNODrawerItemSimple

public static class nit> extends nit>
{

    Callable isHiddenCallable;

    public GNODrawerItemHideable build()
    {
        GNODrawerItemHideable gnodraweritemhideable = (GNODrawerItemHideable)super.ild();
        GNODrawerItemHideable.access$002(gnodraweritemhideable, isHiddenCallable);
        return gnodraweritemhideable;
    }

    public volatile GNODrawerItemSimple build()
    {
        return build();
    }

    public build withIsHiddenCallable(Callable callable)
    {
        isHiddenCallable = callable;
        return (isHiddenCallable)self();
    }

    public (Context context, String s)
    {
        super(new GNODrawerItemHideable(context, s));
    }

    protected nit>(GNODrawerItemHideable gnodraweritemhideable)
    {
        super(gnodraweritemhideable);
    }
}
