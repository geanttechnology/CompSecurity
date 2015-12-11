// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.t;

public class ay extends t
{

    public long accountId;
    public b b;
    public String groupId;
    public String handle;
    public int newsletter;
    public String picUrl;
    public long playerId;
    public String sessionToken;
    public String testId;

    public ay()
    {
    }

    public static ay a(o o)
    {
        o = (ay)a(o, com/smule/android/network/managers/ay);
        o.b = com.smule.android.f.b.a(((ay) (o)).newsletter);
        return o;
    }
}
