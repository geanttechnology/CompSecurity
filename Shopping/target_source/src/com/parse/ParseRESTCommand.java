// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

// Referenced classes of package com.parse:
//            ParseRequest, NoObjectsEncoder, ParseObject, ParseCorePlugins, 
//            LocalIdManager, ParseDigestUtils, ParseByteArrayHttpBody, ParseIOUtils, 
//            ParseHttpClient, ProgressCallback

class ParseRESTCommand extends ParseRequest
{
    public static class Builder extends Init
    {

        public ParseRESTCommand build()
        {
            return new ParseRESTCommand(this);
        }

        Builder self()
        {
            return this;
        }

        volatile Init self()
        {
            return self();
        }

        public Builder()
        {
        }
    }

    static abstract class Init
    {

        private String httpPath;
        private String installationId;
        private JSONObject jsonParameters;
        private String localId;
        public String masterKey;
        private com.parse.http.ParseHttpRequest.Method method;
        private String operationSetUUID;
        private String sessionToken;

        public Init httpPath(String s)
        {
            httpPath = s;
            return self();
        }

        public Init installationId(String s)
        {
            installationId = s;
            return self();
        }

        public Init jsonParameters(JSONObject jsonobject)
        {
            jsonParameters = jsonobject;
            return self();
        }

        public Init localId(String s)
        {
            localId = s;
            return self();
        }

        public Init masterKey(String s)
        {
            masterKey = s;
            return self();
        }

        public Init method(com.parse.http.ParseHttpRequest.Method method1)
        {
            method = method1;
            return self();
        }

        public Init operationSetUUID(String s)
        {
            operationSetUUID = s;
            return self();
        }

        abstract Init self();

        public Init sessionToken(String s)
        {
            sessionToken = s;
            return self();
        }








        Init()
        {
            method = com.parse.http.ParseHttpRequest.Method.GET;
        }
    }


    static final String HEADER_APPLICATION_ID = "X-Parse-Application-Id";
    static final String HEADER_APP_BUILD_VERSION = "X-Parse-App-Build-Version";
    static final String HEADER_APP_DISPLAY_VERSION = "X-Parse-App-Display-Version";
    static final String HEADER_CLIENT_KEY = "X-Parse-Client-Key";
    static final String HEADER_CLIENT_VERSION = "X-Parse-Client-Version";
    static final String HEADER_INSTALLATION_ID = "X-Parse-Installation-Id";
    private static final String HEADER_MASTER_KEY = "X-Parse-Master-Key";
    static final String HEADER_OS_VERSION = "X-Parse-OS-Version";
    private static final String HEADER_SESSION_TOKEN = "X-Parse-Session-Token";
    private static final String PARAMETER_METHOD_OVERRIDE = "_method";
    static final String USER_AGENT = "User-Agent";
    String httpPath;
    private String installationId;
    final JSONObject jsonParameters;
    private String localId;
    public String masterKey;
    private String operationSetUUID;
    private final String sessionToken;

    ParseRESTCommand(Init init)
    {
        super(init.method, createUrl(init.httpPath));
        sessionToken = init.sessionToken;
        installationId = init.installationId;
        masterKey = init.masterKey;
        httpPath = init.httpPath;
        jsonParameters = init.jsonParameters;
        operationSetUUID = init.operationSetUUID;
        localId = init.localId;
    }

    public ParseRESTCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        if (map != null)
        {
            map = (JSONObject)NoObjectsEncoder.get().encode(map);
        } else
        {
            map = null;
        }
        this(s, method, ((JSONObject) (map)), s1);
    }

    protected ParseRESTCommand(String s, com.parse.http.ParseHttpRequest.Method method, JSONObject jsonobject, String s1)
    {
        this(s, method, jsonobject, null, s1);
    }

    private ParseRESTCommand(String s, com.parse.http.ParseHttpRequest.Method method, JSONObject jsonobject, String s1, String s2)
    {
        super(method, createUrl(s));
        httpPath = s;
        jsonParameters = jsonobject;
        localId = s1;
        sessionToken = s2;
    }

    private static void addToStringer(JSONStringer jsonstringer, Object obj)
        throws JSONException
    {
        if (obj instanceof JSONObject)
        {
            jsonstringer.object();
            obj = (JSONObject)obj;
            Iterator iterator = ((JSONObject) (obj)).keys();
            Object obj1 = new ArrayList();
            for (; iterator.hasNext(); ((ArrayList) (obj1)).add(iterator.next())) { }
            Collections.sort(((java.util.List) (obj1)));
            for (Iterator iterator1 = ((ArrayList) (obj1)).iterator(); iterator1.hasNext(); addToStringer(jsonstringer, ((JSONObject) (obj)).opt(((String) (obj1)))))
            {
                obj1 = (String)iterator1.next();
                jsonstringer.key(((String) (obj1)));
            }

            jsonstringer.endObject();
            return;
        }
        if (obj instanceof JSONArray)
        {
            obj = (JSONArray)obj;
            jsonstringer.array();
            for (int i = 0; i < ((JSONArray) (obj)).length(); i++)
            {
                addToStringer(jsonstringer, ((JSONArray) (obj)).get(i));
            }

            jsonstringer.endArray();
            return;
        } else
        {
            jsonstringer.value(obj);
            return;
        }
    }

    private static String createUrl(String s)
    {
        return String.format("%s/1/%s", new Object[] {
            ParseObject.server, s
        });
    }

    public static ParseRESTCommand fromJSONObject(JSONObject jsonobject)
    {
        String s = jsonobject.optString("httpPath");
        com.parse.http.ParseHttpRequest.Method method = com.parse.http.ParseHttpRequest.Method.fromString(jsonobject.optString("httpMethod"));
        String s1 = jsonobject.optString("sessionToken", null);
        String s2 = jsonobject.optString("localId", null);
        return new ParseRESTCommand(s, method, jsonobject.optJSONObject("parameters"), s2, s1);
    }

    private static LocalIdManager getLocalIdManager()
    {
        return ParseCorePlugins.getInstance().getLocalIdManager();
    }

    protected static void getLocalPointersIn(Object obj, ArrayList arraylist)
        throws JSONException
    {
        if (!(obj instanceof JSONObject)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = (JSONObject)obj;
        if (!"Pointer".equals(jsonobject.opt("__type")) || !jsonobject.has("localId")) goto _L4; else goto _L3
_L3:
        arraylist.add((JSONObject)obj);
_L6:
        return;
_L4:
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); getLocalPointersIn(jsonobject.get((String)iterator.next()), arraylist)) { }
_L2:
        if (obj instanceof JSONArray)
        {
            obj = (JSONArray)obj;
            int i = 0;
            while (i < ((JSONArray) (obj)).length()) 
            {
                getLocalPointersIn(((JSONArray) (obj)).get(i), arraylist);
                i++;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean isValidCommandJSONObject(JSONObject jsonobject)
    {
        return jsonobject.has("httpPath");
    }

    static boolean isValidOldFormatCommandJSONObject(JSONObject jsonobject)
    {
        return jsonobject.has("op");
    }

    private void maybeChangeServerOperation()
        throws JSONException
    {
        if (localId != null)
        {
            String s = getLocalIdManager().getObjectId(localId);
            if (s != null)
            {
                localId = null;
                httpPath = (new StringBuilder()).append(httpPath).append(String.format("/%s", new Object[] {
                    s
                })).toString();
                url = createUrl(httpPath);
                if (httpPath.startsWith("classes") && method == com.parse.http.ParseHttpRequest.Method.POST)
                {
                    method = com.parse.http.ParseHttpRequest.Method.PUT;
                }
            }
        }
    }

    static String toDeterministicString(Object obj)
        throws JSONException
    {
        JSONStringer jsonstringer = new JSONStringer();
        addToStringer(jsonstringer, obj);
        return jsonstringer.toString();
    }

    protected void addAdditionalHeaders(com.parse.http.ParseHttpRequest.Builder builder)
    {
        if (installationId != null)
        {
            builder.addHeader("X-Parse-Installation-Id", installationId);
        }
        if (sessionToken != null)
        {
            builder.addHeader("X-Parse-Session-Token", sessionToken);
        }
        if (masterKey != null)
        {
            builder.addHeader("X-Parse-Master-Key", masterKey);
        }
    }

    void enableRetrying()
    {
        setMaxRetries(4);
    }

    public j executeAsync(ParseHttpClient parsehttpclient, ProgressCallback progresscallback, ProgressCallback progresscallback1, j j1)
    {
        resolveLocalIds();
        return super.executeAsync(parsehttpclient, progresscallback, progresscallback1, j1);
    }

    public String getCacheKey()
    {
        Object obj;
        Object obj1;
        if (jsonParameters != null)
        {
            try
            {
                obj = toDeterministicString(jsonParameters);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((JSONException) (obj)).getMessage());
            }
        } else
        {
            obj = "";
        }
        obj1 = obj;
        if (sessionToken != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append(sessionToken).toString();
        }
        return String.format("ParseRESTCommand.%s.%s.%s", new Object[] {
            method.toString(), ParseDigestUtils.md5(httpPath), ParseDigestUtils.md5(((String) (obj1)))
        });
    }

    public String getLocalId()
    {
        return localId;
    }

    public String getOperationSetUUID()
    {
        return operationSetUUID;
    }

    public String getSessionToken()
    {
        return sessionToken;
    }

    protected ParseHttpBody newBody(ProgressCallback progresscallback)
    {
        if (jsonParameters == null)
        {
            throw new IllegalArgumentException(String.format("Trying to execute a %s command without body parameters.", new Object[] {
                method.toString()
            }));
        }
        try
        {
            progresscallback = jsonParameters;
            if (method == com.parse.http.ParseHttpRequest.Method.GET || method == com.parse.http.ParseHttpRequest.Method.DELETE)
            {
                progresscallback = jsonParameters;
                if (!(progresscallback instanceof JSONObject))
                {
                    progresscallback = progresscallback.toString();
                } else
                {
                    progresscallback = JSONObjectInstrumentation.toString((JSONObject)progresscallback);
                }
                progresscallback = JSONObjectInstrumentation.init(progresscallback);
                progresscallback.put("_method", method.toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (ProgressCallback progresscallback)
        {
            throw new RuntimeException(progresscallback.getMessage());
        }
        if (progresscallback instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        progresscallback = progresscallback.toString();
        return new ParseByteArrayHttpBody(progresscallback, "application/json");
        progresscallback = JSONObjectInstrumentation.toString((JSONObject)progresscallback);
        break MISSING_BLOCK_LABEL_108;
    }

    protected ParseHttpRequest newRequest(com.parse.http.ParseHttpRequest.Method method, String s, ProgressCallback progresscallback)
    {
        if (jsonParameters != null && method != com.parse.http.ParseHttpRequest.Method.POST && method != com.parse.http.ParseHttpRequest.Method.PUT)
        {
            method = super.newRequest(com.parse.http.ParseHttpRequest.Method.POST, s, progresscallback);
        } else
        {
            method = super.newRequest(method, s, progresscallback);
        }
        method = new com.parse.http.ParseHttpRequest.Builder(method);
        addAdditionalHeaders(method);
        return method.build();
    }

    protected j onResponseAsync(ParseHttpResponse parsehttpresponse, ProgressCallback progresscallback)
    {
        Object obj;
        obj = null;
        progresscallback = null;
        java.io.InputStream inputstream = parsehttpresponse.getContent();
        progresscallback = inputstream;
        obj = inputstream;
        String s = new String(ParseIOUtils.toByteArray(inputstream));
        ParseIOUtils.closeQuietly(inputstream);
        int i = parsehttpresponse.getStatusCode();
        if (i < 200 || i >= 600)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        try
        {
            parsehttpresponse = JSONObjectInstrumentation.init(s);
        }
        // Misplaced declaration of an exception variable
        catch (ParseHttpResponse parsehttpresponse)
        {
            return j.a(newTemporaryException("bad json response", parsehttpresponse));
        }
        if (i < 400 || i >= 500)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        parsehttpresponse = j.a(newPermanentException(parsehttpresponse.optInt("code"), parsehttpresponse.optString("error")));
        return parsehttpresponse;
        parsehttpresponse;
        obj = progresscallback;
        parsehttpresponse = j.a(parsehttpresponse);
        ParseIOUtils.closeQuietly(progresscallback);
        return parsehttpresponse;
        parsehttpresponse;
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw parsehttpresponse;
        if (i < 500)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        return j.a(newTemporaryException(parsehttpresponse.optInt("code"), parsehttpresponse.optString("error")));
        parsehttpresponse = j.a(parsehttpresponse);
        return parsehttpresponse;
        return j.a(newPermanentException(-1, s));
    }

    public void releaseLocalIds()
    {
        if (localId != null)
        {
            getLocalIdManager().releaseLocalIdOnDisk(localId);
        }
        try
        {
            Object obj = new ArrayList();
            getLocalPointersIn(jsonParameters, ((ArrayList) (obj)));
            String s;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); getLocalIdManager().releaseLocalIdOnDisk(s))
            {
                s = (String)((JSONObject)((Iterator) (obj)).next()).get("localId");
            }

        }
        catch (JSONException jsonexception) { }
    }

    public void resolveLocalIds()
    {
        Object obj;
        obj = new ArrayList();
        getLocalPointersIn(jsonParameters, ((ArrayList) (obj)));
        obj = ((ArrayList) (obj)).iterator();
_L1:
        JSONObject jsonobject;
        String s;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        jsonobject = (JSONObject)((Iterator) (obj)).next();
        s = (String)jsonobject.get("localId");
        s = getLocalIdManager().getObjectId(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        throw new IllegalStateException("Tried to serialize a command referencing a new, unsaved object.");
        jsonobject.put("objectId", s);
        jsonobject.remove("localId");
          goto _L1
        try
        {
            maybeChangeServerOperation();
            return;
        }
        catch (JSONException jsonexception)
        {
            return;
        }
    }

    public void retainLocalIds()
    {
        if (localId != null)
        {
            getLocalIdManager().retainLocalIdOnDisk(localId);
        }
        try
        {
            Object obj = new ArrayList();
            getLocalPointersIn(jsonParameters, ((ArrayList) (obj)));
            String s;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); getLocalIdManager().retainLocalIdOnDisk(s))
            {
                s = (String)((JSONObject)((Iterator) (obj)).next()).get("localId");
            }

        }
        catch (JSONException jsonexception) { }
    }

    public void setLocalId(String s)
    {
        localId = s;
    }

    void setOperationSetUUID(String s)
    {
        operationSetUUID = s;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (httpPath != null)
            {
                jsonobject.put("httpPath", httpPath);
            }
            jsonobject.put("httpMethod", method.toString());
            if (jsonParameters != null)
            {
                jsonobject.put("parameters", jsonParameters);
            }
            if (sessionToken != null)
            {
                jsonobject.put("sessionToken", sessionToken);
            }
            if (localId != null)
            {
                jsonobject.put("localId", localId);
            }
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception.getMessage());
        }
        return jsonobject;
    }
}
