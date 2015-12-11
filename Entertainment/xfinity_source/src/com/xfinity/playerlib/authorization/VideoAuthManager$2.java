// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.httpcomponentsandroid.NoHttpResponseException;
import java.net.SocketTimeoutException;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthManager

class this._cls0
    implements com.comcast.cim.cmasl.http.service..RetryPredicate
{

    final VideoAuthManager this$0;

    public boolean shouldRetry(CimException cimexception, int i)
    {
        cimexception = cimexception.getCause();
        return ((cimexception instanceof SocketTimeoutException) || (cimexception instanceof NoHttpResponseException)) && i < 1;
    }

    eption()
    {
        this$0 = VideoAuthManager.this;
        super();
    }
}
