// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            AbstractPooledConnAdapter, SingleClientConnManager

protected class ute extends AbstractPooledConnAdapter
{

    final SingleClientConnManager this$0;

    protected Q(Q q, HttpRoute httproute)
    {
        this$0 = SingleClientConnManager.this;
        super(SingleClientConnManager.this, q);
        markReusable();
        q.ute = httproute;
    }
}
