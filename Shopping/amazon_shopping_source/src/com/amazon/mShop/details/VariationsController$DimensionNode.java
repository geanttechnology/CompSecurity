// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;


// Referenced classes of package com.amazon.mShop.details:
//            VariationsController

private class A
{

    private mOption mChildren[];
    private int mDimension;
    private int mOption;

    public A getChildAt(int i)
    {
        return mChildren[i];
    }

    public int getDimension()
    {
        return mDimension;
    }

    public int getNumChildren()
    {
        return mChildren.length;
    }

    public int getOption()
    {
        return mOption;
    }
}
