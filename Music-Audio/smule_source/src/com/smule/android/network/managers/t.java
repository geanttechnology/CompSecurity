// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import java.util.List;

public class t extends com.smule.android.network.core.t
{

    public List performances;

    public String toString()
    {
        return (new StringBuilder()).append("PlaylistPerformancesResponse [mResponse=").append(a).append(", performances=").append(performances).append("]").toString();
    }
}
