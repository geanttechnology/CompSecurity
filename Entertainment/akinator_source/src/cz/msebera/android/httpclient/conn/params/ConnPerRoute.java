// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

public interface ConnPerRoute
{

    public abstract int getMaxForRoute(HttpRoute httproute);
}
