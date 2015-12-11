// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            BaseJsonHttpResponseHandler, i, j

final class h
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final Throwable d;
    final BaseJsonHttpResponseHandler e;

    h(BaseJsonHttpResponseHandler basejsonhttpresponsehandler, String s, int k, Header aheader[], Throwable throwable)
    {
        e = basejsonhttpresponsehandler;
        a = s;
        b = k;
        c = aheader;
        d = throwable;
        super();
    }

    public final void run()
    {
        try
        {
            Object obj = e.parseResponse(a);
            e.postRunnable(new i(this, obj));
            return;
        }
        catch (Throwable throwable)
        {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable);
        }
        e.postRunnable(new j(this));
    }
}
