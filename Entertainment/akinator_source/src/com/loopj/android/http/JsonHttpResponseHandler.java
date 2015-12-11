// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler, AsyncHttpClient, LogInterface

public class JsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "JsonHttpRH";
    private boolean useRFC5179CompatibilityMode;

    public JsonHttpResponseHandler()
    {
        super("UTF-8");
        useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(String s)
    {
        super(s);
        useRFC5179CompatibilityMode = true;
    }

    public JsonHttpResponseHandler(String s, boolean flag)
    {
        super(s);
        useRFC5179CompatibilityMode = true;
        useRFC5179CompatibilityMode = flag;
    }

    public JsonHttpResponseHandler(boolean flag)
    {
        super("UTF-8");
        useRFC5179CompatibilityMode = true;
        useRFC5179CompatibilityMode = flag;
    }

    public boolean isUseRFC5179CompatibilityMode()
    {
        return useRFC5179CompatibilityMode;
    }

    public void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONArray jsonarray)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    public final void onFailure(final int statusCode, final Header headers[], final byte responseBytes[], final Throwable throwable)
    {
        if (responseBytes != null)
        {
            headers = new Runnable() {

                final JsonHttpResponseHandler this$0;
                final Header val$headers[];
                final byte val$responseBytes[];
                final int val$statusCode;
                final Throwable val$throwable;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseBytes);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls2 this$1;
                            final Object val$jsonResponse;

                            public void run()
                            {
                                if (!useRFC5179CompatibilityMode && jsonResponse == null)
                                {
                                    onFailure(statusCode, headers, (String)null, throwable);
                                    return;
                                }
                                if (jsonResponse instanceof JSONObject)
                                {
                                    onFailure(statusCode, headers, throwable, (JSONObject)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof JSONArray)
                                {
                                    onFailure(statusCode, headers, throwable, (JSONArray)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof String)
                                {
                                    onFailure(statusCode, headers, (String)jsonResponse, throwable);
                                    return;
                                } else
                                {
                                    onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(jsonResponse.getClass().getName()).toString()), (JSONObject)null);
                                    return;
                                }
                            }

            
            {
                this$1 = final__pcls2;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        postRunnable(jsonexception. new Runnable() {

                            final _cls2 this$1;
                            final JSONException val$ex;

                            public void run()
                            {
                                onFailure(statusCode, headers, ex, (JSONObject)null);
                            }

            
            {
                this$1 = final__pcls2;
                ex = JSONException.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = JsonHttpResponseHandler.this;
                responseBytes = abyte0;
                statusCode = i;
                headers = aheader;
                throwable = throwable1;
                super();
            }
            };
            if (!getUseSynchronousMode() && !getUsePoolThread())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            AsyncHttpClient.log.v("JsonHttpRH", "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(statusCode, headers, throwable, (JSONObject)null);
            return;
        }
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header aheader[], JSONArray jsonarray)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        AsyncHttpClient.log.w("JsonHttpRH", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public final void onSuccess(final int statusCode, final Header headers[], final byte responseBytes[])
    {
        if (statusCode != 204)
        {
            headers = new Runnable() {

                final JsonHttpResponseHandler this$0;
                final Header val$headers[];
                final byte val$responseBytes[];
                final int val$statusCode;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseBytes);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls1 this$1;
                            final Object val$jsonResponse;

                            public void run()
                            {
                                if (!useRFC5179CompatibilityMode && jsonResponse == null)
                                {
                                    onSuccess(statusCode, headers, (String)null);
                                    return;
                                }
                                if (jsonResponse instanceof JSONObject)
                                {
                                    onSuccess(statusCode, headers, (JSONObject)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof JSONArray)
                                {
                                    onSuccess(statusCode, headers, (JSONArray)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof String)
                                {
                                    if (useRFC5179CompatibilityMode)
                                    {
                                        onFailure(statusCode, headers, (String)jsonResponse, new JSONException("Response cannot be parsed as JSON data"));
                                        return;
                                    } else
                                    {
                                        onSuccess(statusCode, headers, (String)jsonResponse);
                                        return;
                                    }
                                } else
                                {
                                    onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(jsonResponse.getClass().getName()).toString()), (JSONObject)null);
                                    return;
                                }
                            }

            
            {
                this$1 = final__pcls1;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        postRunnable(jsonexception. new Runnable() {

                            final _cls1 this$1;
                            final JSONException val$ex;

                            public void run()
                            {
                                onFailure(statusCode, headers, ex, (JSONObject)null);
                            }

            
            {
                this$1 = final__pcls1;
                ex = JSONException.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = JsonHttpResponseHandler.this;
                responseBytes = abyte0;
                statusCode = i;
                headers = aheader;
                super();
            }
            };
            if (!getUseSynchronousMode() && !getUsePoolThread())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            onSuccess(statusCode, headers, new JSONObject());
            return;
        }
    }

    protected Object parseResponse(byte abyte0[])
        throws JSONException
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        Object obj;
        Object obj2;
label0:
        {
            obj2 = null;
            obj1 = getResponseString(abyte0, getCharset());
            obj = obj1;
            abyte0 = obj2;
            if (obj1 == null)
            {
                break label0;
            }
            obj1 = ((String) (obj1)).trim();
            if (!useRFC5179CompatibilityMode)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!((String) (obj1)).startsWith("{"))
            {
                obj = obj1;
                abyte0 = obj2;
                if (!((String) (obj1)).startsWith("["))
                {
                    break label0;
                }
            }
            abyte0 = ((byte []) ((new JSONTokener(((String) (obj1)))).nextValue()));
            obj = obj1;
        }
_L5:
        obj1 = abyte0;
        if (abyte0 == null)
        {
            return obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (((String) (obj1)).startsWith("{") && ((String) (obj1)).endsWith("}") || ((String) (obj1)).startsWith("[") && ((String) (obj1)).endsWith("]"))
        {
            abyte0 = ((byte []) ((new JSONTokener(((String) (obj1)))).nextValue()));
            obj = obj1;
        } else
        {
            obj = obj1;
            abyte0 = obj2;
            if (((String) (obj1)).startsWith("\""))
            {
                obj = obj1;
                abyte0 = obj2;
                if (((String) (obj1)).endsWith("\""))
                {
                    abyte0 = ((String) (obj1)).substring(1, ((String) (obj1)).length() - 1);
                    obj = obj1;
                }
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void setUseRFC5179CompatibilityMode(boolean flag)
    {
        useRFC5179CompatibilityMode = flag;
    }

}
