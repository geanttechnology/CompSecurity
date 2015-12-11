// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            JsonHttpResponseHandler, l, m

final class k
    implements Runnable
{

    final String a;
    final int b;
    final Header c[];
    final JsonHttpResponseHandler d;

    k(JsonHttpResponseHandler jsonhttpresponsehandler, String s, int i, Header aheader[])
    {
        d = jsonhttpresponsehandler;
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
            d.postRunnable(new l(this, obj));
            return;
        }
        catch (JSONException jsonexception)
        {
            d.postRunnable(new m(this, jsonexception));
        }
    }
}
