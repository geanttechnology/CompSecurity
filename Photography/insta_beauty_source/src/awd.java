// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

class awd extends AsyncHttpResponseHandler
{

    final awe a;
    final TTieZhiInfo b;
    final AsyncHttpClient c;
    final awc d;

    awd(awc awc1, awe awe1, TTieZhiInfo ttiezhiinfo, AsyncHttpClient asynchttpclient)
    {
        d = awc1;
        a = awe1;
        b = ttiezhiinfo;
        c = asynchttpclient;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Log.v("TTieZhiDownloadManager", "TTieZhiDownloadManageronFailure");
        FlurryAgent.logEvent("TieZhiZipDownloadFailed");
        if (a != null)
        {
            a.c(b);
        }
        awc.a(d, c);
    }

    public void onProgress(int i, int j)
    {
        if (a != null && j > 0)
        {
            float f = (float)i / (float)j;
            if (a != null)
            {
                Log.v("TTieZhiDownloadManager", (new StringBuilder()).append("TTieZhiDownloadManageronProgress:").append(f).toString());
                a.a(b, f);
            }
        }
    }

    public void onStart()
    {
        Log.v("TTieZhiDownloadManager", "TTieZhiDownloadManageronStart");
        FlurryAgent.logEvent("TieZhiZipDownloadStart");
        if (a != null)
        {
            a.a(b);
        }
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Log.v("TTieZhiDownloadManager", "TTieZhiDownloadManageronSuccess");
        aheader = awb.a(abyte0, b.resId);
        if (a != null)
        {
            if (aheader != null)
            {
                a.b(aheader);
            } else
            {
                a.c(b);
            }
        }
        awc.a(d, c);
    }
}
