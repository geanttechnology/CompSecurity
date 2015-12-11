// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSubHeader, GNODrawerItemSimple

public class GNODrawerItemSubHeaderHideable extends GNODrawerItemSubHeader
    implements GNOItemAdapter.HideableItem
{
    public static class Builder extends GNODrawerItemSubHeader.Builder
    {

        Callable isHiddenCallable;

        public volatile GNODrawerItemSimple build()
        {
            return build();
        }

        public GNODrawerItemSubHeaderHideable build()
        {
            GNODrawerItemSubHeaderHideable gnodraweritemsubheaderhideable = (GNODrawerItemSubHeaderHideable)super.build();
            gnodraweritemsubheaderhideable.mIsHiddenCallable = isHiddenCallable;
            return gnodraweritemsubheaderhideable;
        }

        public Builder withIsHiddenCallable(Callable callable)
        {
            isHiddenCallable = callable;
            return (Builder)self();
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemSubHeaderHideable(context, s));
        }
    }


    private Callable mIsHiddenCallable;

    public GNODrawerItemSubHeaderHideable(Context context, String s)
    {
        super(context, s);
    }

    public static Builder builder(Context context, String s)
    {
        return new Builder(context, s);
    }

    public Callable getIsHiddenCallable()
    {
        return mIsHiddenCallable;
    }

    public boolean isHidden()
    {
        boolean flag;
        if (mIsHiddenCallable == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        flag = ((Boolean)mIsHiddenCallable.call()).booleanValue();
        return flag;
        Exception exception;
        exception;
        return false;
    }


/*
    static Callable access$002(GNODrawerItemSubHeaderHideable gnodraweritemsubheaderhideable, Callable callable)
    {
        gnodraweritemsubheaderhideable.mIsHiddenCallable = callable;
        return callable;
    }

*/
}
