// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.o;
import com.smule.android.network.core.t;
import java.util.ArrayList;
import java.util.List;

public class y extends t
{

    public List mSongs;

    public y()
    {
        mSongs = new ArrayList();
    }

    static y a(o o)
    {
        return (y)a(o, com/smule/android/network/managers/y);
    }

    public String toString()
    {
        return (new StringBuilder()).append("RecommedationResponse[songs=").append(mSongs).append("]").toString();
    }
}
