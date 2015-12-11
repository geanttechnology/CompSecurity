// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import com.loopj.android.http.AsyncHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

// Referenced classes of package com.databerries:
//            DataBerries

class tpResponseHandler extends AsyncHttpResponseHandler
{

    final DataBerries this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
    }

    Header()
    {
        this$0 = DataBerries.this;
        super();
    }
}
