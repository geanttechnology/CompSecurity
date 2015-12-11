// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.conn:
//            AbstractPooledConnAdapter, SingleClientConnManager

protected class ute extends AbstractPooledConnAdapter
{

    final SingleClientConnManager this$0;

    protected Y(Y y, HttpRoute httproute)
    {
        this$0 = SingleClientConnManager.this;
        super(SingleClientConnManager.this, y);
        markReusable();
        y.ute = httproute;
    }
}
