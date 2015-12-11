// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSubHeaderHideable, GNODrawerItemSimple

public static class A extends A
{

    Callable isHiddenCallable;

    public volatile GNODrawerItemSimple build()
    {
        return build();
    }

    public GNODrawerItemSubHeaderHideable build()
    {
        GNODrawerItemSubHeaderHideable gnodraweritemsubheaderhideable = (GNODrawerItemSubHeaderHideable)super.build();
        GNODrawerItemSubHeaderHideable.access$002(gnodraweritemsubheaderhideable, isHiddenCallable);
        return gnodraweritemsubheaderhideable;
    }

    public isHiddenCallable withIsHiddenCallable(Callable callable)
    {
        isHiddenCallable = callable;
        return (isHiddenCallable)self();
    }

    public A(Context context, String s)
    {
        super(new GNODrawerItemSubHeaderHideable(context, s));
    }
}
