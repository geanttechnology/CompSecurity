// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.json.JSONException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            n, JsonHttpResponseHandler

final class p
    implements Runnable
{

    final JSONException a;
    final n b;

    p(n n1, JSONException jsonexception)
    {
        b = n1;
        a = jsonexception;
        super();
    }

    public final void run()
    {
        b.e.onFailure(b.b, b.c, a, null);
    }
}
