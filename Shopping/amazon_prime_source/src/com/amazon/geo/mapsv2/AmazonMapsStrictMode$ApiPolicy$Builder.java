// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;


// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapsStrictMode

public static class mPenaltyThrow
{

    private boolean mDetectAll;
    private boolean mDetectUnimplemented;
    private boolean mPenaltyLog;
    private boolean mPenaltyThrow;

    public mPenaltyThrow build()
    {
        return new mPenaltyThrow(this, null);
    }

    public mPenaltyThrow detectAll()
    {
        mDetectAll = true;
        return this;
    }

    public mDetectAll detectUnimplemented()
    {
        mDetectUnimplemented = true;
        return this;
    }

    public mDetectUnimplemented penaltyLog()
    {
        mPenaltyLog = true;
        return this;
    }

    public mPenaltyLog penaltyThrow()
    {
        mPenaltyThrow = true;
        return this;
    }





    public ()
    {
        mDetectAll = false;
        mDetectUnimplemented = false;
        mPenaltyLog = false;
        mPenaltyThrow = false;
    }
}
