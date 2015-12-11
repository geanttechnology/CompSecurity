// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationParams

public static class mAsin extends NotificationParams
{

    private String mAsin;

    public String getAsin()
    {
        return mAsin;
    }

    public (String s, String s1, String s2, String s3, String s4)
    {
        super(s, s1, s2, s4);
        mAsin = s3;
    }
}
