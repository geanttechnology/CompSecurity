// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.config.ConnectionConfig;

public interface HttpConnectionFactory
{

    public abstract HttpConnection create(Object obj, ConnectionConfig connectionconfig);
}
