// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            JsonHttpResponseHandler, o, p

final class n
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final Throwable d;
    final JsonHttpResponseHandler e;

    n(JsonHttpResponseHandler jsonhttpresponsehandler, String s, int i, Header aheader[], Throwable throwable)
    {
        e = jsonhttpresponsehandler;
        a = s;
        b = i;
        c = aheader;
        d = throwable;
        super();
    }

    public final void run()
    {
        try
        {
            Object obj = e.parseResponse(a);
            e.postRunnable(new o(this, obj));
            return;
        }
        catch (JSONException jsonexception)
        {
            e.postRunnable(new p(this, jsonexception));
        }
    }
}
