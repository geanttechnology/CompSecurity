// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import org.apache.http.Header;

class bcw extends AsyncHttpResponseHandler
{

    final bcx a;
    final TPhotoComposeInfo b;
    final AsyncHttpClient c;
    final bcv d;

    bcw(bcv bcv1, bcx bcx1, TPhotoComposeInfo tphotocomposeinfo, AsyncHttpClient asynchttpclient)
    {
        d = bcv1;
        a = bcx1;
        b = tphotocomposeinfo;
        c = asynchttpclient;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Log.v("TMagDownloadManager", "TMagDownloadManageronFailure");
        if (a != null)
        {
            a.e(b);
        }
        bcv.a(d, c);
    }

    public void onProgress(int i, int j)
    {
        if (a != null && j > 0)
        {
            float f = (float)i / (float)j;
            if (a != null)
            {
                Log.v("TMagDownloadManager", (new StringBuilder()).append("TMagDownloadManageronProgress:").append(f).toString());
                a.a(b, f);
            }
        }
    }

    public void onStart()
    {
        Log.v("TMagDownloadManager", "TMagDownloadManageronStart");
        if (a != null)
        {
            a.c(b);
        }
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Log.v("TMagDownloadManager", "TMagDownloadManageronSuccess");
        aheader = bcy.a(abyte0, b.resId);
        if (a != null)
        {
            if (aheader != null)
            {
                a.d(aheader);
            } else
            {
                a.e(b);
            }
        }
        bcv.a(d, c);
    }
}
