// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.List;

public class k extends t
{

    public List mAccountApps;
    public List mFollowers;
    public int mTotalFollowees;

    public String toString()
    {
        return (new StringBuilder()).append("FollowersResponse [mResponse=").append(a).append(", mFollowers=").append(mFollowers).append(", mAccountApps=").append(mAccountApps).append(", mTotalFollowees=").append(mTotalFollowees).append("]").toString();
    }
}
