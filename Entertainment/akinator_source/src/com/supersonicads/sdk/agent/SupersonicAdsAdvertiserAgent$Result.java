// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;


// Referenced classes of package com.supersonicads.sdk.agent:
//            SupersonicAdsAdvertiserAgent

private class setResponseString
{

    private int mResponseCode;
    private String mResponseString;
    final SupersonicAdsAdvertiserAgent this$0;

    public int getResponseCode()
    {
        return mResponseCode;
    }

    public String getResponseString()
    {
        return mResponseString;
    }

    public void setResponseCode(int i)
    {
        mResponseCode = i;
    }

    public void setResponseString(String s)
    {
        mResponseString = s;
    }

    public ()
    {
        this$0 = SupersonicAdsAdvertiserAgent.this;
        super();
    }

    public this._cls0(int i, String s)
    {
        this$0 = SupersonicAdsAdvertiserAgent.this;
        super();
        setResponseCode(i);
        setResponseString(s);
    }
}
