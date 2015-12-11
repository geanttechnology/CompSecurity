// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            TextHttpResponseHandler, n, k

public class JsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "JsonHttpResponseHandler";

    public JsonHttpResponseHandler()
    {
        super("UTF-8");
    }

    public JsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public void onFailure(int i, Throwable throwable, JSONArray jsonarray)
    {
        onFailure(throwable, jsonarray);
    }

    public void onFailure(int i, Throwable throwable, JSONObject jsonobject)
    {
        onFailure(throwable, jsonobject);
    }

    public void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        if (s != null)
        {
            (new Thread(new n(this, s, i, aheader, throwable))).start();
            return;
        } else
        {
            Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(i, aheader, throwable, ((JSONObject) (null)));
            return;
        }
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONArray jsonarray)
    {
        onFailure(i, throwable, jsonarray);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        onFailure(i, throwable, jsonobject);
    }

    public void onFailure(Throwable throwable, JSONArray jsonarray)
    {
        onFailure(throwable);
    }

    public void onFailure(Throwable throwable, JSONObject jsonobject)
    {
        onFailure(throwable);
    }

    public void onSuccess(int i, JSONArray jsonarray)
    {
        onSuccess(jsonarray);
    }

    public void onSuccess(int i, JSONObject jsonobject)
    {
        onSuccess(jsonobject);
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        if (i != 204)
        {
            (new Thread(new k(this, s, i, aheader))).start();
            return;
        } else
        {
            onSuccess(i, aheader, new JSONObject());
            return;
        }
    }

    public void onSuccess(int i, Header aheader[], JSONArray jsonarray)
    {
        onSuccess(i, jsonarray);
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        onSuccess(i, jsonobject);
    }

    public void onSuccess(JSONArray jsonarray)
    {
    }

    public void onSuccess(JSONObject jsonobject)
    {
    }

    protected Object parseResponse(String s)
    {
        Object obj = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        s1 = s.trim();
        if (!s1.startsWith("{"))
        {
            s = obj;
            if (!s1.startsWith("["))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        s = ((String) ((new JSONTokener(s1)).nextValue()));
        if (s == null) goto _L4; else goto _L3
_L3:
        return s;
    }
}
