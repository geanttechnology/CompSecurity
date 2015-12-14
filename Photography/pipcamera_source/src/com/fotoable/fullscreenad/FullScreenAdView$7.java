// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package com.fotoable.fullscreenad:
//            FullScreenAdView

class er extends AsyncHttpResponseHandler
{

    final FullScreenAdView a;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Log.v(FullScreenAdView.access$800(a), "post failed...");
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Log.v(FullScreenAdView.access$800(a), "post succeed...");
    }

    er(FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }
}
