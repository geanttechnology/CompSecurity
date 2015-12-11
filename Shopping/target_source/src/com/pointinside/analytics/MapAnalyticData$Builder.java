// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


// Referenced classes of package com.pointinside.analytics:
//            MapAnalyticData

public static class mCustData
{

    private String mCustData;
    private String mReferrer;

    public MapAnalyticData build()
    {
        return new MapAnalyticData(this);
    }

    public mCustData custData(String s)
    {
        mCustData = s;
        return this;
    }

    public mCustData referrer(String s)
    {
        mReferrer = s;
        return this;
    }



/*
    static String access$002( , String s)
    {
        .mReferrer = s;
        return s;
    }

*/



/*
    static String access$102(mReferrer mreferrer, String s)
    {
        mreferrer.mCustData = s;
        return s;
    }

*/

    public mCustData()
    {
    }
}
