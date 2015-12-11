// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            k, JsonHttpResponseHandler

final class l
    implements Runnable
{

    final Object a;
    final k b;

    l(k k1, Object obj)
    {
        b = k1;
        a = obj;
        super();
    }

    public final void run()
    {
        if (a instanceof JSONObject)
        {
            b.d.onSuccess(b.b, b.c, (JSONObject)a);
            return;
        }
        if (a instanceof JSONArray)
        {
            b.d.onSuccess(b.b, b.c, (JSONArray)a);
            return;
        }
        if (a instanceof String)
        {
            b.d.onSuccess(b.b, b.c, (String)a);
            return;
        } else
        {
            b.d.onFailure(new JSONException((new StringBuilder("Unexpected type ")).append(a.getClass().getName()).toString()), null);
            return;
        }
    }
}
