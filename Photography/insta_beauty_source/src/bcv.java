// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.loopj.android.http.AsyncHttpClient;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;

public class bcv
{

    private static bcv b = null;
    private ArrayList a;

    private bcv()
    {
    }

    public static bcv a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        bcv;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new bcv();
        }
        bcv;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        bcv;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(bcv bcv1, AsyncHttpClient asynchttpclient)
    {
        bcv1.a(asynchttpclient);
    }

    private void a(AsyncHttpClient asynchttpclient)
    {
        if (asynchttpclient != null && a != null && a.size() > 0 && a.contains(asynchttpclient))
        {
            a.remove(asynchttpclient);
        }
    }

    public void a(TPhotoComposeInfo tphotocomposeinfo, bcx bcx)
    {
        String s = tphotocomposeinfo.zipUrl;
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
        asynchttpclient.get(s, new bcw(this, bcx, tphotocomposeinfo, asynchttpclient));
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
