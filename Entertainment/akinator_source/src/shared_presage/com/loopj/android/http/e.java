// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            BaseJsonHttpResponseHandler, f, g

final class e
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final BaseJsonHttpResponseHandler d;

    e(BaseJsonHttpResponseHandler basejsonhttpresponsehandler, String s, int i, Header aheader[])
    {
        d = basejsonhttpresponsehandler;
        a = s;
        b = i;
        c = aheader;
        super();
    }

    public final void run()
    {
        try
        {
            Object obj = d.parseResponse(a);
            d.postRunnable(new f(this, obj));
            return;
        }
        catch (Throwable throwable)
        {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable);
            d.postRunnable(new g(this, throwable));
            return;
        }
    }
}
