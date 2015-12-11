// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package bolts:
//            AppLinkResolver, AppLink, Capture, Task, 
//            Continuation

public class WebViewAppLinkResolver
    implements AppLinkResolver
{

    private static final String KEY_AL_VALUE = "value";
    private static final String KEY_ANDROID = "android";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_CLASS = "class";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_SHOULD_FALLBACK = "should_fallback";
    private static final String KEY_URL = "url";
    private static final String KEY_WEB = "web";
    private static final String KEY_WEB_URL = "url";
    private static final String META_TAG_PREFIX = "al";
    private static final String PREFER_HEADER = "Prefer-Html-Meta-Tags";
    private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    private final Context context;

    public WebViewAppLinkResolver(Context context1)
    {
        context = context1;
    }

    private static List getAlList(Map map, String s)
    {
        s = (List)map.get(s);
        map = s;
        if (s == null)
        {
            map = Collections.emptyList();
        }
        return map;
    }

    private static AppLink makeAppLinkFromAlData(Map map, Uri uri)
    {
        Object obj2;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj2 = (List)map.get("android");
        List list = ((List) (obj2));
        if (obj2 == null)
        {
            list = Collections.emptyList();
        }
        for (obj2 = list.iterator(); ((Iterator) (obj2)).hasNext();)
        {
            Map map1 = (Map)((Iterator) (obj2)).next();
            List list1 = getAlList(map1, "url");
            List list2 = getAlList(map1, "package");
            List list3 = getAlList(map1, "class");
            List list4 = getAlList(map1, "app_name");
            int j = Math.max(list1.size(), Math.max(list2.size(), Math.max(list3.size(), list4.size())));
            int i = 0;
            while (i < j) 
            {
                Object obj;
                Uri uri1;
                String s;
                String s1;
                if (list1.size() > i)
                {
                    obj = ((Map)list1.get(i)).get("value");
                } else
                {
                    obj = null;
                }
                uri1 = tryCreateUrl((String)(String)obj);
                if (list2.size() > i)
                {
                    obj = ((Map)list2.get(i)).get("value");
                } else
                {
                    obj = null;
                }
                s = (String)(String)obj;
                if (list3.size() > i)
                {
                    obj = ((Map)list3.get(i)).get("value");
                } else
                {
                    obj = null;
                }
                s1 = (String)(String)obj;
                if (list4.size() > i)
                {
                    obj = ((Map)list4.get(i)).get("value");
                } else
                {
                    obj = null;
                }
                arraylist.add(new AppLink.Target(s, s1, uri1, (String)(String)obj));
                i++;
            }
        }

        map = (List)map.get("web");
        if (map == null || map.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_547;
        }
        map = (Map)map.get(0);
        obj2 = (List)map.get("url");
        map = (List)map.get("should_fallback");
        if (map == null || map.size() <= 0) goto _L2; else goto _L1
_L1:
        map = (String)((Map)map.get(0)).get("value");
        if (!Arrays.asList(new String[] {
            "no", "false", "0"
        }).contains(map.toLowerCase())) goto _L2; else goto _L3
_L3:
        map = null;
_L4:
        Object obj1;
        obj1 = map;
        if (map != null)
        {
            obj1 = map;
            if (obj2 != null)
            {
                obj1 = map;
                if (((List) (obj2)).size() > 0)
                {
                    obj1 = tryCreateUrl((String)((Map)((List) (obj2)).get(0)).get("value"));
                }
            }
        }
_L5:
        return new AppLink(uri, arraylist, ((Uri) (obj1)));
_L2:
        map = uri;
          goto _L4
        obj1 = uri;
          goto _L5
    }

    private static Map parseAlData(JSONArray jsonarray)
    {
        HashMap hashmap = new HashMap();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            String as[] = jsonobject.getString("property").split(":");
            if (as[0].equals("al"))
            {
                int j = 1;
                Object obj = hashmap;
                while (j < as.length) 
                {
                    Object obj1 = (List)((Map) (obj)).get(as[j]);
                    if (obj1 == null)
                    {
                        obj1 = new ArrayList();
                        ((Map) (obj)).put(as[j], obj1);
                    }
                    if (((List) (obj1)).size() > 0)
                    {
                        obj = (Map)((List) (obj1)).get(((List) (obj1)).size() - 1);
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null || j == as.length - 1)
                    {
                        obj = new HashMap();
                        ((List) (obj1)).add(obj);
                    }
                    j++;
                }
                if (jsonobject.has("content"))
                {
                    if (jsonobject.isNull("content"))
                    {
                        ((Map) (obj)).put("value", null);
                    } else
                    {
                        ((Map) (obj)).put("value", jsonobject.getString("content"));
                    }
                }
            }
            i++;
        }
        return hashmap;
    }

    private static String readFromConnection(URLConnection urlconnection)
    {
        Object obj2;
        ByteArrayOutputStream bytearrayoutputstream;
        int i;
        i = 0;
        if (urlconnection instanceof HttpURLConnection)
        {
            obj2 = (HttpURLConnection)urlconnection;
            Object obj;
            int j;
            try
            {
                obj = urlconnection.getInputStream();
            }
            catch (Exception exception)
            {
                exception = ((HttpURLConnection) (obj2)).getErrorStream();
            }
            obj2 = obj;
        } else
        {
            obj2 = urlconnection.getInputStream();
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        obj = new byte[1024];
_L1:
        j = ((InputStream) (obj2)).read(((byte []) (obj)));
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        bytearrayoutputstream.write(((byte []) (obj)), 0, j);
          goto _L1
        urlconnection;
        ((InputStream) (obj2)).close();
        throw urlconnection;
        String s = urlconnection.getContentEncoding();
        Object obj1 = s;
        if (s != null) goto _L3; else goto _L2
_L2:
        int k;
        obj1 = urlconnection.getContentType().split(";");
        k = obj1.length;
_L6:
        urlconnection = s;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_179;
        }
          goto _L4
_L3:
        urlconnection = new String(bytearrayoutputstream.toByteArray(), ((String) (obj1)));
        ((InputStream) (obj2)).close();
        return urlconnection;
_L4:
        urlconnection = obj1[i].trim();
        if (urlconnection.startsWith("charset="))
        {
            urlconnection = urlconnection.substring("charset=".length());
            break MISSING_BLOCK_LABEL_179;
        }
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        obj1 = urlconnection;
        if (urlconnection == null)
        {
            obj1 = "UTF-8";
        }
          goto _L3
    }

    private static Uri tryCreateUrl(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Uri.parse(s);
        }
    }

    public Task getAppLinkFromUrlInBackground(final Uri url)
    {
        final Capture content = new Capture();
        final Capture contentType = new Capture();
        return Task.callInBackground(new Callable() {

            final WebViewAppLinkResolver this$0;
            final Capture val$content;
            final Capture val$contentType;
            final Uri val$url;

            public volatile Object call()
            {
                return call();
            }

            public Void call()
            {
                Object obj;
                Object obj1 = new URL(url.toString());
                obj = null;
                while (obj1 != null) 
                {
                    obj1 = ((URL) (obj1)).openConnection();
                    if (obj1 instanceof HttpURLConnection)
                    {
                        ((HttpURLConnection)obj1).setInstanceFollowRedirects(true);
                    }
                    ((URLConnection) (obj1)).setRequestProperty("Prefer-Html-Meta-Tags", "al");
                    ((URLConnection) (obj1)).connect();
                    if (obj1 instanceof HttpURLConnection)
                    {
                        Object obj2 = (HttpURLConnection)obj1;
                        if (((HttpURLConnection) (obj2)).getResponseCode() >= 300 && ((HttpURLConnection) (obj2)).getResponseCode() < 400)
                        {
                            obj = new URL(((HttpURLConnection) (obj2)).getHeaderField("Location"));
                            ((HttpURLConnection) (obj2)).disconnect();
                        } else
                        {
                            obj = null;
                        }
                        obj2 = obj;
                        obj = obj1;
                        obj1 = obj2;
                    } else
                    {
                        obj = obj1;
                        obj1 = null;
                    }
                }
                content.set(WebViewAppLinkResolver.readFromConnection(((URLConnection) (obj))));
                contentType.set(((URLConnection) (obj)).getContentType());
                if (obj instanceof HttpURLConnection)
                {
                    ((HttpURLConnection)obj).disconnect();
                }
                return null;
                Exception exception;
                exception;
                if (obj instanceof HttpURLConnection)
                {
                    ((HttpURLConnection)obj).disconnect();
                }
                throw exception;
            }

            
            {
                this$0 = WebViewAppLinkResolver.this;
                url = uri;
                content = capture;
                contentType = capture1;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final WebViewAppLinkResolver this$0;
            final Capture val$content;
            final Capture val$contentType;
            final Uri val$url;

            public Task then(Task task)
            {
                Task.TaskCompletionSource taskcompletionsource = Task.create();
                WebView webview = new WebView(context);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.setNetworkAvailable(false);
                webview.setWebViewClient(new WebViewClient() {

                    private boolean loaded;
                    final _cls2 this$1;

                    private void runJavaScript(WebView webview)
                    {
                        if (!loaded)
                        {
                            loaded = true;
                            webview.loadUrl("javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())");
                        }
                    }

                    public void onLoadResource(WebView webview, String s)
                    {
                        super.onLoadResource(webview, s);
                        runJavaScript(webview);
                    }

                    public void onPageFinished(WebView webview, String s)
                    {
                        super.onPageFinished(webview, s);
                        runJavaScript(webview);
                    }

            
            {
                this$1 = _cls2.this;
                super();
                loaded = false;
            }
                });
                webview.addJavascriptInterface(taskcompletionsource. new Object() {

                    final _cls2 this$1;
                    final Task.TaskCompletionSource val$tcs;

                    public void setValue(String s)
                    {
                        try
                        {
                            tcs.trySetResult(new JSONArray(s));
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            tcs.trySetError(s);
                        }
                    }

            
            {
                this$1 = final__pcls2;
                tcs = Task.TaskCompletionSource.this;
                super();
            }
                }, "boltsWebViewAppLinkResolverResult");
                if (contentType.get() != null)
                {
                    task = ((String)contentType.get()).split(";")[0];
                } else
                {
                    task = null;
                }
                webview.loadDataWithBaseURL(url.toString(), (String)content.get(), task, null, null);
                return taskcompletionsource.getTask();
            }

            public volatile Object then(Task task)
            {
                return then(task);
            }

            
            {
                this$0 = WebViewAppLinkResolver.this;
                contentType = capture;
                url = uri;
                content = capture1;
                super();
            }
        }, Task.UI_THREAD_EXECUTOR).onSuccess(new Continuation() {

            final WebViewAppLinkResolver this$0;
            final Uri val$url;

            public AppLink then(Task task)
            {
                return WebViewAppLinkResolver.makeAppLinkFromAlData(WebViewAppLinkResolver.parseAlData((JSONArray)task.getResult()), url);
            }

            public volatile Object then(Task task)
            {
                return then(task);
            }

            
            {
                this$0 = WebViewAppLinkResolver.this;
                url = uri;
                super();
            }
        });
    }




}
