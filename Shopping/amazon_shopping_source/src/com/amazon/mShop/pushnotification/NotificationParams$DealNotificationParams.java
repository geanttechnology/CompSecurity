// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationParams

public static class mCategoryDisplayName extends onParams
{

    private String mCategory;
    private String mCategoryDisplayName;

    public String getCategory()
    {
        return mCategory;
    }

    public String getCategoryDisplayName()
    {
        return mCategoryDisplayName;
    }

    public onParams(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        super(s, s1, s2, s3, s6);
        mCategory = s4;
        mCategoryDisplayName = s5;
    }
}
