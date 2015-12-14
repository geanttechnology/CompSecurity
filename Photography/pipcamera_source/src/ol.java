// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

public class ol
{

    private static ol b = null;
    private ArrayList a;

    private ol()
    {
    }

    public static ol a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        ol;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new ol();
        }
        ol;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        ol;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(AsyncHttpClient asynchttpclient)
    {
        if (asynchttpclient != null && a != null && a.size() > 0 && a.contains(asynchttpclient))
        {
            a.remove(asynchttpclient);
        }
    }

    static void a(ol ol1, AsyncHttpClient asynchttpclient)
    {
        ol1.a(asynchttpclient);
    }

    public void a(TTieZhiInfo ttiezhiinfo, om om)
    {
        String s = ttiezhiinfo.zipUrl;
        if (s == null || s.length() == 0)
        {
            return;
        }
        AsyncHttpClient asynchttpclient = new AsyncHttpClient();
        if (a == null)
        {
            a = new ArrayList(3);
        }
        a.add(asynchttpclient);
        asynchttpclient.get(s, new AsyncHttpResponseHandler(om, ttiezhiinfo, asynchttpclient) {

            final om a;
            final TTieZhiInfo b;
            final AsyncHttpClient c;
            final ol d;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                Log.v("TTieZhiDownloadManager", "TTieZhiDownloadManageronFailure");
                FlurryAgent.logEvent("TieZhiZipDownloadFailed");
                if (a != null)
                {
                    a.c(b);
                }
                ol.a(d, c);
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
                aheader = ok.a(abyte0, b.resId);
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
                ol.a(d, c);
            }

            
            {
                d = ol.this;
                a = om1;
                b = ttiezhiinfo;
                c = asynchttpclient;
                super();
            }
        });
    }

    public void b()
    {
        if (a != null)
        {
            for (int i = 0; i < a.size(); i++)
            {
                ((AsyncHttpClient)a.get(i)).cancelAllRequests(true);
            }

            a.clear();
        }
    }

}
