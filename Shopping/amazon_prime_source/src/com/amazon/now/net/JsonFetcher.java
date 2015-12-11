// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.net;

import android.os.AsyncTask;
import android.util.Log;
import com.amazon.now.util.NetUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class JsonFetcher
{
    public static interface JsonCallback
    {

        public abstract void response(String s);
    }


    private static final String TAG = com/amazon/now/net/JsonFetcher.getSimpleName();
    private JsonCallback mCallback;
    private String mUrl;

    public JsonFetcher(String s, JsonCallback jsoncallback)
    {
        if (jsoncallback == null)
        {
            throw new RuntimeException("JsonCallback cannot be null");
        } else
        {
            mUrl = s;
            mCallback = jsoncallback;
            return;
        }
    }

    public void fetch()
    {
        if (mCallback == null)
        {
            throw new RuntimeException("JsonCallback cannot be null");
        } else
        {
            (new AsyncTask() {

                final JsonFetcher this$0;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    Object obj;
                    Object obj1;
                    Object obj2;
                    Object obj3;
                    Object obj4;
                    Object obj5;
                    obj5 = null;
                    obj = null;
                    obj3 = null;
                    obj4 = null;
                    avoid = ((Void []) (obj));
                    obj1 = obj3;
                    obj2 = obj5;
                    URLConnection urlconnection = NetUtil.getURLConnection(mUrl);
                    avoid = ((Void []) (obj));
                    obj1 = obj3;
                    obj2 = obj5;
                    urlconnection.setConnectTimeout(5000);
                    avoid = ((Void []) (obj));
                    obj1 = obj3;
                    obj2 = obj5;
                    obj = urlconnection.getInputStream();
                    avoid = ((Void []) (obj));
                    obj1 = obj3;
                    obj2 = obj;
                    obj3 = new BufferedReader(new InputStreamReader(((InputStream) (obj)), Charset.forName("UTF-8")));
                    avoid = new StringBuilder();
_L3:
                    obj1 = ((BufferedReader) (obj3)).readLine();
                    if (obj1 == null) goto _L2; else goto _L1
_L1:
                    avoid.append(((String) (obj1)).trim());
                      goto _L3
                    avoid;
                    obj2 = obj3;
                    obj3 = avoid;
_L7:
                    avoid = ((Void []) (obj));
                    obj1 = obj2;
                    Log.e(JsonFetcher.TAG, ((IOException) (obj3)).toString(), ((Throwable) (obj3)));
                    if (obj != null)
                    {
                        try
                        {
                            ((InputStream) (obj)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            Log.e(JsonFetcher.TAG, avoid.toString(), avoid);
                        }
                    }
                    if (obj2 != null)
                    {
                        try
                        {
                            ((BufferedReader) (obj2)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            Log.e(JsonFetcher.TAG, avoid.toString(), avoid);
                            return "";
                        }
                    }
                    return "";
_L2:
                    avoid = avoid.toString();
                    if (obj != null)
                    {
                        try
                        {
                            ((InputStream) (obj)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            Log.e(JsonFetcher.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                        }
                    }
                    if (obj3 != null)
                    {
                        try
                        {
                            ((BufferedReader) (obj3)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            Log.e(JsonFetcher.TAG, ((IOException) (obj)).toString(), ((Throwable) (obj)));
                            return avoid;
                        }
                        return avoid;
                    } else
                    {
                        return avoid;
                    }
                    obj;
_L5:
                    if (avoid != null)
                    {
                        try
                        {
                            avoid.close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            Log.e(JsonFetcher.TAG, avoid.toString(), avoid);
                        }
                    }
                    if (obj1 != null)
                    {
                        try
                        {
                            ((BufferedReader) (obj1)).close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            Log.e(JsonFetcher.TAG, avoid.toString(), avoid);
                        }
                    }
                    throw obj;
                    obj2;
                    obj1 = obj3;
                    avoid = ((Void []) (obj));
                    obj = obj2;
                    if (true) goto _L5; else goto _L4
_L4:
                    obj3;
                    obj = obj2;
                    obj2 = obj4;
                    if (true) goto _L7; else goto _L6
_L6:
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    mCallback.response(s);
                }

            
            {
                this$0 = JsonFetcher.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }




}
