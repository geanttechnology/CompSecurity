// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.json.JSONException;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            k, JsonHttpResponseHandler

final class m
    implements Runnable
{

    final JSONException a;
    final k b;

    m(k k1, JSONException jsonexception)
    {
        b = k1;
        a = jsonexception;
        super();
    }

    public final void run()
    {
        b.d.onFailure(a, null);
    }
}
