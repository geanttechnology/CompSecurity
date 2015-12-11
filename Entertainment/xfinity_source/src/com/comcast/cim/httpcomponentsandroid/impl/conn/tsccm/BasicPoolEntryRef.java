// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn.tsccm;

import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import java.lang.ref.WeakReference;

public class BasicPoolEntryRef extends WeakReference
{

    private final HttpRoute route;

    public final HttpRoute getRoute()
    {
        return route;
    }
}
