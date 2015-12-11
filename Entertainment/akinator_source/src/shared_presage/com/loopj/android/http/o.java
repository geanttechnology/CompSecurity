// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            n, JsonHttpResponseHandler

final class o
    implements Runnable
{

    final Object a;
    final n b;

    o(n n1, Object obj)
    {
        b = n1;
        a = obj;
        super();
    }

    public final void run()
    {
        if (a instanceof JSONObject)
        {
            b.e.onFailure(b.b, b.c, b.d, (JSONObject)a);
            return;
        }
        if (a instanceof JSONArray)
        {
            b.e.onFailure(b.b, b.c, b.d, (JSONArray)a);
            return;
        }
        if (a instanceof String)
        {
            b.e.onFailure(b.b, b.c, b.d, (String)a);
            return;
        } else
        {
            b.e.onFailure(new JSONException((new StringBuilder("Unexpected type ")).append(a.getClass().getName()).toString()), null);
            return;
        }
    }
}
