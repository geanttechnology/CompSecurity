// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSimple

public class GNODrawerItemHideable extends GNODrawerItemSimple
    implements GNOItemAdapter.HideableItem
{
    public static class Builder extends GNODrawerItemSimple.Builder
    {

        Callable isHiddenCallable;

        public GNODrawerItemHideable build()
        {
            GNODrawerItemHideable gnodraweritemhideable = (GNODrawerItemHideable)super.build();
            gnodraweritemhideable.mIsHiddenCallable = isHiddenCallable;
            return gnodraweritemhideable;
        }

        public volatile GNODrawerItemSimple build()
        {
            return build();
        }

        public Builder withIsHiddenCallable(Callable callable)
        {
            isHiddenCallable = callable;
            return (Builder)self();
        }

        public Builder(Context context, String s)
        {
            super(new GNODrawerItemHideable(context, s));
        }

        protected Builder(GNODrawerItemHideable gnodraweritemhideable)
        {
            super(gnodraweritemhideable);
        }
    }


    private Callable mIsHiddenCallable;

    public GNODrawerItemHideable(Context context, String s)
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

    public void setIsHiddenCallable(Callable callable)
    {
        mIsHiddenCallable = callable;
    }


/*
    static Callable access$002(GNODrawerItemHideable gnodraweritemhideable, Callable callable)
    {
        gnodraweritemhideable.mIsHiddenCallable = callable;
        return callable;
    }

*/
}
