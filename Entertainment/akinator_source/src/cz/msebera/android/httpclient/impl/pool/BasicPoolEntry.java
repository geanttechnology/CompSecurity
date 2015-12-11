// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.pool;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;

public class BasicPoolEntry extends PoolEntry
{

    public BasicPoolEntry(String s, HttpHost httphost, HttpClientConnection httpclientconnection)
    {
        super(s, httphost, httpclientconnection);
    }

    public void close()
    {
        try
        {
            ((HttpClientConnection)getConnection()).close();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public boolean isClosed()
    {
        return !((HttpClientConnection)getConnection()).isOpen();
    }
}
