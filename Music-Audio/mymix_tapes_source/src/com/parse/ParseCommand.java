// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.http.AndroidHttpClient;
import bolts.Task;
import com.parse.codec.digest.DigestUtils;
import com.parse.signpost.OAuthConsumer;
import com.parse.signpost.commonshttp.CommonsHttpOAuthConsumer;
import com.parse.signpost.exception.OAuthCommunicationException;
import com.parse.signpost.exception.OAuthExpectationFailedException;
import com.parse.signpost.exception.OAuthMessageSignerException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

// Referenced classes of package com.parse:
//            ParseRequest, ParseUser, ManifestInfo, ParseInstallation, 
//            ParseObject, LocalIdManager, ParseException, Parse, 
//            ParseIOUtils, ProgressCallback

class ParseCommand extends ParseRequest
{

    private static final String APP_BUILD_VERSION = "appBuildVersion";
    private static final String APP_DISPLAY_VERSION = "appDisplayVersion";
    private static final String COMMAND_UUID = "uuid";
    private static final String DEVICE_TYPE_AND_SDK_VERSION = "v";
    private static final String INSTALLATION_ID = "iid";
    private static final String OS_VERSION = "osVersion";
    private static final String SESSION_TOKEN = "session_token";
    private String localId;
    private String op;
    private String operationSetUUID;
    JSONObject params;
    private final String sessionToken;

    ParseCommand(String s, String s1)
    {
        this(s, new JSONObject(), null, null, s1);
    }

    private ParseCommand(String s, JSONObject jsonobject, String s1, String s2, String s3)
    {
        super(1, generateUrl(s));
        op = s;
        params = jsonobject;
        localId = s1;
        operationSetUUID = s2;
        sessionToken = s3;
        maxRetries = 0;
    }

    ParseCommand(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getString("op");
        JSONObject jsonobject1 = jsonobject.getJSONObject("params");
        String s1 = jsonobject.optString("localId", null);
        String s2 = jsonobject.optString("operationSetUUID", null);
        if (jsonobject.has("session_token"))
        {
            jsonobject = jsonobject.getString("session_token");
        } else
        {
            jsonobject = ParseUser.getCurrentSessionToken();
        }
        this(s, jsonobject1, s1, s2, ((String) (jsonobject)));
    }

    static void addDefaultParameters(JSONObject jsonobject, String s)
        throws JSONException
    {
        jsonobject.put("osVersion", android.os.Build.VERSION.RELEASE);
        jsonobject.put("appBuildVersion", Integer.toString(ManifestInfo.getVersionCode()));
        jsonobject.put("appDisplayVersion", ManifestInfo.getVersionName());
        jsonobject.put("v", "a1.8.0");
        jsonobject.put("iid", ParseInstallation.getOrCreateCurrentInstallationId());
        jsonobject.put("uuid", UUID.randomUUID().toString());
        if (s != null)
        {
            jsonobject.put("session_token", s);
        }
    }

    static void addToStringer(JSONStringer jsonstringer, Object obj)
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

    private static String generateUrl(String s)
    {
        return String.format("%s/%s/%s", new Object[] {
            ParseObject.server, "2", s
        });
    }

    private static void getLocalPointersIn(Object obj, ArrayList arraylist)
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

    static String toDeterministicString(Object obj)
        throws JSONException
    {
        JSONStringer jsonstringer = new JSONStringer();
        addToStringer(jsonstringer, obj);
        return jsonstringer.toString();
    }

    void enableRetrying()
    {
        maxRetries = 4;
    }

    String getCacheKey()
    {
        String s;
        String s1;
        try
        {
            s = toDeterministicString(params);
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception.getMessage());
        }
        s1 = s;
        if (sessionToken != null)
        {
            s1 = (new StringBuilder()).append(s).append(sessionToken).toString();
        }
        return (new StringBuilder()).append("ParseCommand.").append(op).append(".").append("2").append(".").append(DigestUtils.md5Hex(s1)).toString();
    }

    String getLocalId()
    {
        return localId;
    }

    String getOp()
    {
        return op;
    }

    String getOperationSetUUID()
    {
        return operationSetUUID;
    }

    String getSessionToken()
    {
        return sessionToken;
    }

    public void maybeChangeServerOperation()
        throws JSONException
    {
        if (localId != null)
        {
            String s = LocalIdManager.getDefaultInstance().getObjectId(localId);
            if (s != null)
            {
                localId = null;
                JSONObject jsonobject = params.optJSONObject("data");
                if (jsonobject != null)
                {
                    jsonobject.put("objectId", s);
                }
                if (op.equals("create"))
                {
                    setOp("update");
                }
            }
        }
    }

    protected HttpEntity newEntity()
    {
        JSONObject jsonobject;
        Iterator iterator = params.keys();
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (; iterator.hasNext(); jsonobject.put(s, params.get(s)))
            {
                s = (String)iterator.next();
            }

        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception.getMessage());
        }
        addDefaultParameters(jsonobject, sessionToken);
        StringEntity stringentity;
        try
        {
            stringentity = new StringEntity(jsonobject.toString(), "UTF8");
            stringentity.setContentType("application/json");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception.getMessage());
        }
        return stringentity;
    }

    protected HttpUriRequest newRequest()
        throws ParseException
    {
        HttpUriRequest httpurirequest = super.newRequest();
        try
        {
            CommonsHttpOAuthConsumer commonshttpoauthconsumer = new CommonsHttpOAuthConsumer(Parse.applicationId, Parse.clientKey);
            commonshttpoauthconsumer.setTokenWithSecret(null, "");
            commonshttpoauthconsumer.sign(httpurirequest);
        }
        catch (OAuthMessageSignerException oauthmessagesignerexception)
        {
            throw new ParseException(109, oauthmessagesignerexception.getMessage());
        }
        catch (OAuthExpectationFailedException oauthexpectationfailedexception)
        {
            throw new ParseException(109, oauthexpectationfailedexception.getMessage());
        }
        catch (OAuthCommunicationException oauthcommunicationexception)
        {
            throw new ParseException(109, oauthcommunicationexception.getMessage());
        }
        return httpurirequest;
    }

    protected Task onPostExecute(Task task)
    {
        task = (JSONObject)task.getResult();
        try
        {
            if (task.has("error"))
            {
                return Task.forError(new ParseException(task.getInt("code"), task.getString("error")));
            }
            task = ((Task) (task.get("result")));
        }
        // Misplaced declaration of an exception variable
        catch (Task task)
        {
            return Task.forError(connectionFailed("corrupted json", task));
        }
        return Task.forResult(task);
    }

    protected Task onPreExecute(Task task)
    {
        Parse.checkInit();
        resolveLocalIds();
        return task;
    }

    protected volatile Object onResponse(HttpResponse httpresponse, ProgressCallback progresscallback)
        throws IOException, ParseException
    {
        return onResponse(httpresponse, progresscallback);
    }

    protected JSONObject onResponse(HttpResponse httpresponse, ProgressCallback progresscallback)
        throws IOException, ParseException
    {
        Object obj;
        obj = null;
        progresscallback = null;
        httpresponse = AndroidHttpClient.getUngzippedContent(httpresponse.getEntity());
        progresscallback = httpresponse;
        obj = httpresponse;
        JSONObject jsonobject = new JSONObject(new JSONTokener(new String(ParseIOUtils.toByteArray(httpresponse))));
        ParseIOUtils.closeQuietly(httpresponse);
        return jsonobject;
        httpresponse;
        obj = progresscallback;
        throw connectionFailed("bad json response", httpresponse);
        httpresponse;
        ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
        throw httpresponse;
    }

    void put(String s, int i)
    {
        try
        {
            params.put(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
    }

    void put(String s, long l)
    {
        try
        {
            params.put(s, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
    }

    void put(String s, String s1)
    {
        try
        {
            params.put(s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
    }

    void put(String s, JSONArray jsonarray)
    {
        try
        {
            params.put(s, jsonarray);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
    }

    void put(String s, JSONObject jsonobject)
    {
        try
        {
            params.put(s, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage());
        }
    }

    public void releaseLocalIds()
    {
        if (localId != null)
        {
            LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(localId);
        }
        try
        {
            Object obj = params.get("data");
            Object obj1 = new ArrayList();
            getLocalPointersIn(obj, ((ArrayList) (obj1)));
            for (Iterator iterator = ((ArrayList) (obj1)).iterator(); iterator.hasNext(); LocalIdManager.getDefaultInstance().releaseLocalIdOnDisk(((String) (obj1))))
            {
                obj1 = (String)((JSONObject)iterator.next()).get("localId");
            }

        }
        catch (JSONException jsonexception) { }
    }

    public void resolveLocalIds()
    {
        Object obj;
        obj = params.get("data");
        ArrayList arraylist = new ArrayList();
        getLocalPointersIn(obj, arraylist);
        obj = arraylist.iterator();
_L1:
        JSONObject jsonobject;
        String s;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        jsonobject = (JSONObject)((Iterator) (obj)).next();
        s = (String)jsonobject.get("localId");
        s = LocalIdManager.getDefaultInstance().getObjectId(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_81;
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
            LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(localId);
        }
        try
        {
            Object obj = params.get("data");
            Object obj1 = new ArrayList();
            getLocalPointersIn(obj, ((ArrayList) (obj1)));
            for (Iterator iterator = ((ArrayList) (obj1)).iterator(); iterator.hasNext(); LocalIdManager.getDefaultInstance().retainLocalIdOnDisk(((String) (obj1))))
            {
                obj1 = (String)((JSONObject)iterator.next()).get("localId");
            }

        }
        catch (JSONException jsonexception) { }
    }

    void setLocalId(String s)
    {
        localId = s;
    }

    void setOp(String s)
    {
        op = s;
        setUrl(generateUrl(s));
    }

    void setOperationSetUUID(String s)
    {
        operationSetUUID = s;
    }

    JSONObject toJSONObject()
    {
        Object obj;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("op", op);
        jsonobject.put("params", params);
        if (localId != null)
        {
            jsonobject.put("localId", localId);
        }
        if (operationSetUUID != null)
        {
            jsonobject.put("operationSetUUID", operationSetUUID);
        }
        if (sessionToken == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = sessionToken;
_L1:
        jsonobject.put("session_token", obj);
        return jsonobject;
        try
        {
            obj = JSONObject.NULL;
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception.getMessage());
        }
          goto _L1
    }
}
