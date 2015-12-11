// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.os.AsyncTask;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TapjoyLog, TJWebViewJSInterfaceListener

public class TJWebViewJSInterface
{
    final class a extends AsyncTask
    {

        WebView a;
        final TJWebViewJSInterface b;

        protected final volatile Object doInBackground(Object aobj[])
        {
            return ((String[])aobj)[0];
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (String)obj;
            if (a == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            if (!((String) (obj)).startsWith("javascript:") || android.os.Build.VERSION.SDK_INT < 19)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            obj = ((String) (obj)).replaceFirst("javascript:", "");
            a.evaluateJavascript(((String) (obj)), null);
            return;
            obj;
            TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in evaluateJavascript. Device not supported. ")).append(((Exception) (obj)).toString()).toString());
            return;
            try
            {
                a.loadUrl(((String) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in loadUrl. Device not supported. ")).append(((Exception) (obj)).toString()).toString());
            }
            return;
        }

        public a(WebView webview)
        {
            b = TJWebViewJSInterface.this;
            super();
            a = webview;
        }
    }


    WebView a;
    TJWebViewJSInterfaceListener b;
    PriorityQueue c;

    public TJWebViewJSInterface(WebView webview, TJWebViewJSInterfaceListener tjwebviewjsinterfacelistener)
    {
        a = webview;
        b = tjwebviewjsinterfacelistener;
        c = new PriorityQueue();
    }

    public void callback(ArrayList arraylist, String s, String s1)
    {
        try
        {
            callbackToJavaScript(new JSONArray(arraylist), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ArrayList arraylist)
        {
            arraylist.printStackTrace();
        }
    }

    public void callback(Map map, String s, String s1)
    {
        try
        {
            JSONArray jsonarray = new JSONArray();
            jsonarray.put(new JSONObject(map));
            callbackToJavaScript(jsonarray, s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in callback to JS: ")).append(map.toString()).toString());
        }
        map.printStackTrace();
    }

    public void callbackToJavaScript(Object obj, String s, String s1)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("arguments", obj);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (s.length() > 0)
        {
            jsonobject.put("method", s);
        }
        obj = new JSONObject();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (s1.length() > 0)
        {
            ((JSONObject) (obj)).put("callbackId", s1);
        }
        ((JSONObject) (obj)).put("data", jsonobject);
        obj = (new StringBuilder("javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('")).append(obj).append("');").toString();
        if (c != null)
        {
            c.add(obj);
            return;
        }
        try
        {
            (new a(a)).execute(new String[] {
                obj
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            TapjoyLog.e("TJWebViewJSInterface", (new StringBuilder("Exception in callback to JS: ")).append(((Exception) (obj)).toString()).toString());
        }
        ((Exception) (obj)).printStackTrace();
        return;
    }

    public void dispatchMethod(String s)
    {
        TapjoyLog.i("TJWebViewJSInterface", (new StringBuilder("dispatchMethod params: ")).append(s).toString());
        try
        {
            s = new JSONObject(s);
            String s1 = s.getJSONObject("data").getString("method");
            TapjoyLog.i("TJWebViewJSInterface", (new StringBuilder("method: ")).append(s1).toString());
            if (b != null)
            {
                b.onDispatchMethod(s1, s);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void flushMessageQueue()
    {
        if (c != null)
        {
            String s;
            for (; c.size() != 0; (new a(a)).execute(new String[] {
    s
}))
            {
                s = (String)c.poll();
            }

            c = null;
        }
    }
}
