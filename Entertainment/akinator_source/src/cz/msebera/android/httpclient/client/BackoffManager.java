// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

public interface BackoffManager
{

    public abstract void backOff(HttpRoute httproute);

    public abstract void probe(HttpRoute httproute);
}
