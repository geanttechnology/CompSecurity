// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.ArrayList;

public class r extends t
{

    public Integer mNext;
    public ArrayList mPerformances;
    public Integer mStorageLimit;
    public Integer mTotalPerformances;

    public String toString()
    {
        return (new StringBuilder()).append("PerformancesByPerformerResponse{mPerformances=").append(mPerformances).append(", mTotalPerformances=").append(mTotalPerformances).append(", mStorageLimit=").append(mStorageLimit).append(", mNext=").append(mNext).append('}').toString();
    }
}
