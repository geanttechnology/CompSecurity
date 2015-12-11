// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

// Referenced classes of package com.databerries:
//            LocationReceiver, LocationDataHandler

class ponseHandler extends AsyncHttpResponseHandler
{

    final LocationReceiver this$0;
    final LocationDataHandler val$LocationHandler;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        val$LocationHandler.close();
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        val$LocationHandler.deleteAllLocations();
        val$LocationHandler.close();
    }

    ()
    {
        this$0 = final_locationreceiver;
        val$LocationHandler = LocationDataHandler.this;
        super();
    }
}
