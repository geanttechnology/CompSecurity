// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationParams

public static class mUseCoinsIcon extends NotificationParams
{

    private String mTitle;
    private String mUrl;
    private boolean mUseCoinsIcon;

    public String getTitle()
    {
        return mTitle;
    }

    public String getUrl()
    {
        return mUrl;
    }

    public boolean useCoinsIcon()
    {
        return mUseCoinsIcon;
    }

    public (String s, String s1, String s2, String s3, boolean flag, String s4, String s5)
    {
        super(s, s1, s3, s4);
        mUrl = s5;
        mTitle = s2;
        mUseCoinsIcon = flag;
    }
}
