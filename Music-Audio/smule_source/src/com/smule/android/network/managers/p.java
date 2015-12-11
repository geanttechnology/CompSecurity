// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.ArrayList;

public class p extends t
{

    public Integer mNext;
    public String mPerformanceKey;
    public ArrayList mPerformancePosts;

    public String toString()
    {
        return (new StringBuilder()).append("PerformancePostsResponse [mResponse=").append(a).append(", mPerformanceKey=").append(mPerformanceKey).append(", mNext=").append(mNext).append(", mPerformancePosts=").append(mPerformancePosts).append("]").toString();
    }
}
