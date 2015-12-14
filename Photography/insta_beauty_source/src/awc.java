// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.sketch.info.TTieZhiInfo;
import com.loopj.android.http.AsyncHttpClient;
import java.util.ArrayList;

public class awc
{

    private static awc b = null;
    private ArrayList a;

    private awc()
    {
    }

    public static awc a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        awc;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new awc();
        }
        awc;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        awc;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(awc awc1, AsyncHttpClient asynchttpclient)
    {
        awc1.a(asynchttpclient);
    }

    private void a(AsyncHttpClient asynchttpclient)
    {
        if (asynchttpclient != null && a != null && a.size() > 0 && a.contains(asynchttpclient))
        {
            a.remove(asynchttpclient);
        }
    }

    public void a(TTieZhiInfo ttiezhiinfo, awe awe)
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
        asynchttpclient.get(s, new awd(this, awe, ttiezhiinfo, asynchttpclient));
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
