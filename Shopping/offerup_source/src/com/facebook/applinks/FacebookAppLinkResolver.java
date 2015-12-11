// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.applinks;

import a.b;
import a.d;
import a.i;
import a.p;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookAppLinkResolver
{

    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap cachedAppLinks = new HashMap();

    public FacebookAppLinkResolver()
    {
    }

    private static d getAndroidTargetFromJson(JSONObject jsonobject)
    {
        Object obj = null;
        String s = tryGetStringFromJson(jsonobject, "package", null);
        if (s == null)
        {
            return null;
        }
        String s1 = tryGetStringFromJson(jsonobject, "class", null);
        String s2 = tryGetStringFromJson(jsonobject, "app_name", null);
        String s3 = tryGetStringFromJson(jsonobject, "url", null);
        jsonobject = obj;
        if (s3 != null)
        {
            jsonobject = Uri.parse(s3);
        }
        return new d(s, s1, jsonobject, s2);
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jsonobject)
    {
        Object obj = null;
        jsonobject = jsonobject.getJSONObject("web");
        if (!tryGetBooleanFromJson(jsonobject, "should_fallback", true))
        {
            return null;
        }
        String s;
        try
        {
            s = tryGetStringFromJson(jsonobject, "url", null);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return uri;
        }
        jsonobject = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        jsonobject = Uri.parse(s);
label0:
        {
            if (jsonobject != null)
            {
                return jsonobject;
            }
            break label0;
        }
    }

    private static boolean tryGetBooleanFromJson(JSONObject jsonobject, String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = jsonobject.getBoolean(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return flag;
        }
        return flag1;
    }

    private static String tryGetStringFromJson(JSONObject jsonobject, String s, String s1)
    {
        try
        {
            jsonobject = jsonobject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return s1;
        }
        return jsonobject;
    }

    public i getAppLinkFromUrlInBackground(final Uri uri)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(uri);
        return getAppLinkFromUrlsInBackground(arraylist).b(new _cls1());
    }

    public i getAppLinkFromUrlsInBackground(final List taskCompletionSource)
    {
        final HashSet urisToRequest;
        StringBuilder stringbuilder;
        appLinkResults = new HashMap();
        urisToRequest = new HashSet();
        stringbuilder = new StringBuilder();
        for (Iterator iterator = taskCompletionSource.iterator(); iterator.hasNext();)
        {
            Uri uri = (Uri)iterator.next();
            b b1;
            synchronized (cachedAppLinks)
            {
                b1 = (b)cachedAppLinks.get(uri);
            }
            if (b1 != null)
            {
                ((Map) (appLinkResults)).put(uri, b1);
            } else
            {
                if (!urisToRequest.isEmpty())
                {
                    stringbuilder.append(',');
                }
                stringbuilder.append(uri.toString());
                urisToRequest.add(uri);
            }
        }

        break MISSING_BLOCK_LABEL_138;
        appLinkResults;
        taskCompletionSource;
        JVM INSTR monitorexit ;
        throw appLinkResults;
        if (urisToRequest.isEmpty())
        {
            return i.a(appLinkResults);
        } else
        {
            taskCompletionSource = i.a();
            Bundle bundle = new Bundle();
            bundle.putString("ids", stringbuilder.toString());
            bundle.putString("fields", String.format("%s.fields(%s,%s)", new Object[] {
                "app_links", "android", "web"
            }));
            (new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, null, new _cls2())).executeAsync();
            return taskCompletionSource.a();
        }
    }




    private class _cls1
        implements h
    {

        final FacebookAppLinkResolver this$0;
        final Uri val$uri;

        public Object then(i j)
        {
            return then$5aa18d35(j);
        }

        public b then$5aa18d35(i j)
        {
            return (b)((Map)j.d()).get(uri);
        }

        _cls1()
        {
            this$0 = FacebookAppLinkResolver.this;
            uri = uri1;
            super();
        }
    }


    private class _cls2
        implements com.facebook.GraphRequest.Callback
    {

        final FacebookAppLinkResolver this$0;
        final Map val$appLinkResults;
        final p val$taskCompletionSource;
        final HashSet val$urisToRequest;

        public void onCompleted(GraphResponse graphresponse)
        {
            Object obj;
            obj = graphresponse.getError();
            if (obj != null)
            {
                taskCompletionSource.a(((FacebookRequestError) (obj)).getException());
                return;
            }
            graphresponse = graphresponse.getJSONObject();
            if (graphresponse == null)
            {
                taskCompletionSource.a(appLinkResults);
                return;
            }
            obj = urisToRequest.iterator();
_L2:
            Uri uri;
            if (!((Iterator) (obj)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            uri = (Uri)((Iterator) (obj)).next();
            if (!graphresponse.has(uri.toString()))
            {
                continue; /* Loop/switch isn't completed */
            }
            JSONObject jsonobject;
            Object obj1;
            ArrayList arraylist;
            int k;
            jsonobject = graphresponse.getJSONObject(uri.toString()).getJSONObject("app_links");
            obj1 = jsonobject.getJSONArray("android");
            k = ((JSONArray) (obj1)).length();
            arraylist = new ArrayList(k);
            JSONException jsonexception;
            d d1;
            for (int j = 0; j >= k; j++)
            {
                break MISSING_BLOCK_LABEL_162;
            }

            d1 = FacebookAppLinkResolver.getAndroidTargetFromJson(((JSONArray) (obj1)).getJSONObject(j));
            if (d1 == null)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            arraylist.add(d1);
            break MISSING_BLOCK_LABEL_247;
            obj1 = new b(uri, arraylist, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jsonobject));
            appLinkResults.put(uri, obj1);
            synchronized (cachedAppLinks)
            {
                cachedAppLinks.put(uri, obj1);
            }
            continue; /* Loop/switch isn't completed */
            exception;
            hashmap;
            JVM INSTR monitorexit ;
            try
            {
                throw exception;
            }
            // Misplaced declaration of an exception variable
            catch (JSONException jsonexception) { }
            if (true) goto _L2; else goto _L1
_L1:
            taskCompletionSource.a(appLinkResults);
            return;
        }

        _cls2()
        {
            this$0 = FacebookAppLinkResolver.this;
            taskCompletionSource = p1;
            appLinkResults = map;
            urisToRequest = hashset;
            super();
        }
    }

}
