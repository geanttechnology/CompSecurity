// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.wantu.model.res.TResInfo;
import java.util.ArrayList;
import org.apache.http.Header;

public class tz
{

    private static tz b = null;
    private ArrayList a;

    private tz()
    {
    }

    public static tz a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        tz;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new tz();
        }
        tz;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        tz;
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

    static void a(tz tz1, AsyncHttpClient asynchttpclient)
    {
        tz1.a(asynchttpclient);
    }

    public void a(TResInfo tresinfo, ua ua)
    {
        String s = tresinfo.zipUrl;
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
        asynchttpclient.get(s, new AsyncHttpResponseHandler(ua, tresinfo, asynchttpclient) {

            final ua a;
            final TResInfo b;
            final AsyncHttpClient c;
            final tz d;

            public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
            {
                Log.v("TPipDownloadManager", "TPipDownloadManageronFailure");
                if (a != null)
                {
                    a.b(b);
                }
                tz.a(d, c);
            }

            public void onProgress(int i, int j)
            {
                if (a != null && j > 0)
                {
                    float f = (float)i / (float)j;
                    if (a != null)
                    {
                        Log.v("TPipDownloadManager", (new StringBuilder()).append("TPipDownloadManageronProgress:").append(f).append(" totolSize:").append(j / 8192).append("KB").toString());
                        a.a(b, f);
                    }
                }
            }

            public void onStart()
            {
                Log.v("TPipDownloadManager", "TPipDownloadManageronStart");
                if (a != null)
                {
                    a.a(b);
                }
            }

            public void onSuccess(int i, Header aheader[], byte abyte0[])
            {
                Log.v("TPipDownloadManager", "TPipDownloadManageronSuccess");
                aheader = tx.a(abyte0, b.resId);
                if (a != null)
                {
                    if (aheader != null)
                    {
                        Log.v("TPipDownloadManager", "TPipDownloadManageronSuccess absluteInfo is not null");
                        a.a(aheader);
                    } else
                    {
                        Log.v("TPipDownloadManager", "TPipDownloadManageronSuccess absluteInfo is null");
                        a.b(b);
                    }
                }
                tz.a(d, c);
            }

            
            {
                d = tz.this;
                a = ua1;
                b = tresinfo;
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
