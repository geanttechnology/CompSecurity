// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            FSECameraActivity

protected class mApplicationKey
{

    private String mApplicationKey;
    private String mSecret;
    private String mUser;
    final FSECameraActivity this$0;

    public String getApplicationKey()
    {
        return mApplicationKey;
    }

    public String getSecret()
    {
        return mSecret;
    }

    public String getUser()
    {
        return mUser;
    }

    public (String s, String s1, String s2)
    {
        this$0 = FSECameraActivity.this;
        super();
        mUser = s;
        mSecret = s1;
        mApplicationKey = s2;
    }
}
