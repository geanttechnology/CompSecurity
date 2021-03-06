// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphMultiResult;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            HttpMethod, Session, FacebookException, Response, 
//            RequestBatch, RequestAsyncTask, LoggingBehavior

public class Request
{

    private static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    private static final String MIGRATION_BUNDLE_PARAM = "migration_bundle";
    private static final String MIME_BOUNDARY = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
    private static final String MY_FEED = "me/feed";
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String MY_VIDEOS = "me/videos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static String defaultBatchApplicationId;
    private static volatile String userAgent;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private GraphObject graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private String restMethod;
    private Session session;

    public Request()
    {
        this(null, null, null, null, null);
    }

    public Request(Session session1, String s)
    {
        this(session1, s, null, null, null);
    }

    public Request(Session session1, String s, Bundle bundle, HttpMethod httpmethod)
    {
        this(session1, s, bundle, httpmethod, null);
    }

    public Request(Session session1, String s, Bundle bundle, HttpMethod httpmethod, Callback callback1)
    {
        batchEntryOmitResultOnSuccess = true;
        session = session1;
        graphPath = s;
        callback = callback1;
        setHttpMethod(httpmethod);
        if (bundle != null)
        {
            parameters = new Bundle(bundle);
        } else
        {
            parameters = new Bundle();
        }
        if (!parameters.containsKey("migration_bundle"))
        {
            parameters.putString("migration_bundle", "fbsdk:20121026");
        }
    }

    Request(Session session1, URL url)
    {
        batchEntryOmitResultOnSuccess = true;
        session = session1;
        overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        parameters = new Bundle();
    }

    private void addCommonParameters()
    {
        if (session != null)
        {
            if (!session.isOpened())
            {
                throw new FacebookException("Session provided to a Request in un-opened state.");
            }
            if (!parameters.containsKey("access_token"))
            {
                String s = session.getAccessToken();
                Logger.registerAccessToken(s);
                parameters.putString("access_token", s);
            }
        }
        parameters.putString("sdk", "android");
        parameters.putString("format", "json");
    }

    private String appendParametersToBaseUrl(String s)
    {
        android.net.Uri.Builder builder;
label0:
        {
            builder = (new android.net.Uri.Builder()).encodedPath(s);
label1:
            do
            {
                String s1;
                for (Iterator iterator = parameters.keySet().iterator(); iterator.hasNext(); builder.appendQueryParameter(s1, parameterToString(s).toString()))
                {
                    s1 = (String)iterator.next();
                    Object obj = parameters.get(s1);
                    s = ((String) (obj));
                    if (obj == null)
                    {
                        s = "";
                    }
                    if (!isSupportedParameterType(s))
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (httpMethod != HttpMethod.GET);
            throw new IllegalArgumentException(String.format("Unsupported parameter type for GET request: %s", new Object[] {
                s.getClass().getSimpleName()
            }));
        }
        return builder.toString();
    }

    static HttpURLConnection createConnection(URL url)
    {
        url = (HttpURLConnection)url.openConnection();
        url.setRequestProperty("User-Agent", getUserAgent());
        url.setRequestProperty("Content-Type", getMimeContentType());
        url.setChunkedStreamingMode(0);
        return url;
    }

    public static Response executeAndWait(Request request)
    {
        request = executeBatchAndWait(new Request[] {
            request
        });
        if (request == null || request.size() != 1)
        {
            throw new FacebookException("invalid state: expected a single response");
        } else
        {
            return (Response)request.get(0);
        }
    }

    public static List executeBatchAndWait(RequestBatch requestbatch)
    {
        Validate.notEmptyAndContainsNoNulls(requestbatch, "requests");
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = toHttpConnection(requestbatch);
        }
        catch (Exception exception)
        {
            List list = Response.constructErrorResponses(requestbatch.getRequests(), null, new FacebookException(exception));
            runCallbacks(requestbatch, list);
            return list;
        }
        return executeConnectionAndWait(httpurlconnection, requestbatch);
    }

    public static List executeBatchAndWait(Collection collection)
    {
        return executeBatchAndWait(new RequestBatch(collection));
    }

    public static transient List executeBatchAndWait(Request arequest[])
    {
        Validate.notNull(arequest, "requests");
        return executeBatchAndWait(((Collection) (Arrays.asList(arequest))));
    }

    public static RequestAsyncTask executeBatchAsync(RequestBatch requestbatch)
    {
        Validate.notEmptyAndContainsNoNulls(requestbatch, "requests");
        requestbatch = new RequestAsyncTask(requestbatch);
        requestbatch.executeOnSettingsExecutor();
        return requestbatch;
    }

    public static RequestAsyncTask executeBatchAsync(Collection collection)
    {
        return executeBatchAsync(new RequestBatch(collection));
    }

    public static transient RequestAsyncTask executeBatchAsync(Request arequest[])
    {
        Validate.notNull(arequest, "requests");
        return executeBatchAsync(((Collection) (Arrays.asList(arequest))));
    }

    public static List executeConnectionAndWait(HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        List list = Response.fromHttpConnection(httpurlconnection, requestbatch);
        Utility.disconnectQuietly(httpurlconnection);
        int i = requestbatch.size();
        if (i != list.size())
        {
            throw new FacebookException(String.format("Received %d responses while expecting %d", new Object[] {
                Integer.valueOf(list.size()), Integer.valueOf(i)
            }));
        }
        runCallbacks(requestbatch, list);
        httpurlconnection = new HashSet();
        requestbatch = requestbatch.iterator();
        do
        {
            if (!requestbatch.hasNext())
            {
                break;
            }
            Request request = (Request)requestbatch.next();
            if (request.session != null)
            {
                httpurlconnection.add(request.session);
            }
        } while (true);
        for (httpurlconnection = httpurlconnection.iterator(); httpurlconnection.hasNext(); ((Session)httpurlconnection.next()).extendAccessTokenIfNeeded()) { }
        return list;
    }

    public static List executeConnectionAndWait(HttpURLConnection httpurlconnection, Collection collection)
    {
        return executeConnectionAndWait(httpurlconnection, new RequestBatch(collection));
    }

    public static RequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        Validate.notNull(httpurlconnection, "connection");
        httpurlconnection = new RequestAsyncTask(httpurlconnection, requestbatch);
        requestbatch.setCallbackHandler(handler);
        httpurlconnection.executeOnSettingsExecutor();
        return httpurlconnection;
    }

    public static RequestAsyncTask executeConnectionAsync(HttpURLConnection httpurlconnection, RequestBatch requestbatch)
    {
        return executeConnectionAsync(null, httpurlconnection, requestbatch);
    }

    public static RequestAsyncTask executeGraphPathRequestAsync(Session session1, String s, Callback callback1)
    {
        return newGraphPathRequest(session1, s, callback1).executeAsync();
    }

    public static RequestAsyncTask executeMeRequestAsync(Session session1, GraphUserCallback graphusercallback)
    {
        return newMeRequest(session1, graphusercallback).executeAsync();
    }

    public static RequestAsyncTask executeMyFriendsRequestAsync(Session session1, GraphUserListCallback graphuserlistcallback)
    {
        return newMyFriendsRequest(session1, graphuserlistcallback).executeAsync();
    }

    public static RequestAsyncTask executePlacesSearchRequestAsync(Session session1, Location location, int i, int j, String s, GraphPlaceListCallback graphplacelistcallback)
    {
        return newPlacesSearchRequest(session1, location, i, j, s, graphplacelistcallback).executeAsync();
    }

    public static RequestAsyncTask executePostRequestAsync(Session session1, String s, GraphObject graphobject, Callback callback1)
    {
        return newPostRequest(session1, s, graphobject, callback1).executeAsync();
    }

    public static RequestAsyncTask executeRestRequestAsync(Session session1, String s, Bundle bundle, HttpMethod httpmethod)
    {
        return newRestRequest(session1, s, bundle, httpmethod).executeAsync();
    }

    public static RequestAsyncTask executeStatusUpdateRequestAsync(Session session1, String s, Callback callback1)
    {
        return newStatusUpdateRequest(session1, s, callback1).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session1, Bitmap bitmap, Callback callback1)
    {
        return newUploadPhotoRequest(session1, bitmap, callback1).executeAsync();
    }

    public static RequestAsyncTask executeUploadPhotoRequestAsync(Session session1, File file, Callback callback1)
    {
        return newUploadPhotoRequest(session1, file, callback1).executeAsync();
    }

    private static String getBatchAppId(RequestBatch requestbatch)
    {
        if (!Utility.isNullOrEmpty(requestbatch.getBatchApplicationId()))
        {
            return requestbatch.getBatchApplicationId();
        }
        for (requestbatch = requestbatch.iterator(); requestbatch.hasNext();)
        {
            Session session1 = ((Request)requestbatch.next()).session;
            if (session1 != null)
            {
                return session1.getApplicationId();
            }
        }

        return defaultBatchApplicationId;
    }

    public static final String getDefaultBatchApplicationId()
    {
        return defaultBatchApplicationId;
    }

    private static String getMimeContentType()
    {
        return String.format("multipart/form-data; boundary=%s", new Object[] {
            "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
        });
    }

    private static String getUserAgent()
    {
        if (userAgent == null)
        {
            userAgent = String.format("%s.%s", new Object[] {
                "FBAndroidSDK", "3.0.1"
            });
        }
        return userAgent;
    }

    private static boolean isSupportedAttachmentType(Object obj)
    {
        return (obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof ParcelFileDescriptor);
    }

    private static boolean isSupportedParameterType(Object obj)
    {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
    }

    public static Request newGraphPathRequest(Session session1, String s, Callback callback1)
    {
        return new Request(session1, s, null, null, callback1);
    }

    public static Request newMeRequest(Session session1, final GraphUserCallback callback)
    {
        return new Request(session1, "me", null, null, new _cls1());
    }

    public static Request newMyFriendsRequest(Session session1, final GraphUserListCallback callback)
    {
        return new Request(session1, "me/friends", null, null, new _cls2());
    }

    public static Request newPlacesSearchRequest(Session session1, Location location, int i, int j, String s, final GraphPlaceListCallback callback)
    {
        if (location == null && Utility.isNullOrEmpty(s))
        {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        Bundle bundle = new Bundle(5);
        bundle.putString("type", "place");
        bundle.putInt("limit", j);
        if (location != null)
        {
            bundle.putString("center", String.format(Locale.US, "%f,%f", new Object[] {
                Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())
            }));
            bundle.putInt("distance", i);
        }
        if (!Utility.isNullOrEmpty(s))
        {
            bundle.putString("q", s);
        }
        location = new _cls3();
        return new Request(session1, "search", bundle, HttpMethod.GET, location);
    }

    public static Request newPostRequest(Session session1, String s, GraphObject graphobject, Callback callback1)
    {
        session1 = new Request(session1, s, null, HttpMethod.POST, callback1);
        session1.graphObject = graphobject;
        return session1;
    }

    public static Request newRestRequest(Session session1, String s, Bundle bundle, HttpMethod httpmethod)
    {
        session1 = new Request(session1, null, bundle, httpmethod);
        session1.restMethod = s;
        return session1;
    }

    public static Request newStatusUpdateRequest(Session session1, String s, Callback callback1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        return new Request(session1, "me/feed", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadPhotoRequest(Session session1, Bitmap bitmap, Callback callback1)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", bitmap);
        return new Request(session1, "me/photos", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadPhotoRequest(Session session1, File file, Callback callback1)
    {
        file = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("picture", file);
        return new Request(session1, "me/photos", bundle, HttpMethod.POST, callback1);
    }

    public static Request newUploadVideoRequest(Session session1, File file, Callback callback1)
    {
        ParcelFileDescriptor parcelfiledescriptor = ParcelFileDescriptor.open(file, 0x10000000);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(file.getName(), parcelfiledescriptor);
        return new Request(session1, "me/videos", bundle, HttpMethod.POST, callback1);
    }

    private static String parameterToString(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if ((obj instanceof Boolean) || (obj instanceof Number))
        {
            return obj.toString();
        }
        if (obj instanceof Date)
        {
            return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(obj);
        } else
        {
            throw new IllegalArgumentException("Unsupported parameter type.");
        }
    }

    private static void processGraphObject(GraphObject graphobject, String s, KeyValueSerializer keyvalueserializer)
    {
        int i;
        if (s.startsWith("me/") || s.startsWith("/me/"))
        {
            i = s.indexOf(":");
            int j = s.indexOf("?");
            if (i > 3 && (j == -1 || i < j))
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 0;
        }
        graphobject = graphobject.asMap().entrySet().iterator();
        while (graphobject.hasNext()) 
        {
            s = (java.util.Map.Entry)graphobject.next();
            boolean flag;
            if (i && ((String)s.getKey()).equalsIgnoreCase("image"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            processGraphObjectProperty((String)s.getKey(), s.getValue(), keyvalueserializer, flag);
        }
    }

    private static void processGraphObjectProperty(String s, Object obj, KeyValueSerializer keyvalueserializer, boolean flag)
    {
        Object obj1;
        obj1 = obj.getClass();
        String s1;
        if (com/facebook/model/GraphObject.isAssignableFrom(((Class) (obj1))))
        {
            obj = ((GraphObject)obj).getInnerJSONObject();
            obj1 = obj.getClass();
        } else
        if (com/facebook/model/GraphObjectList.isAssignableFrom(((Class) (obj1))))
        {
            obj = ((GraphObjectList)obj).getInnerJSONArray();
            obj1 = obj.getClass();
        }
        if (!org/json/JSONObject.isAssignableFrom(((Class) (obj1)))) goto _L2; else goto _L1
_L1:
        obj = (JSONObject)obj;
        if (!flag) goto _L4; else goto _L3
_L3:
        for (obj1 = ((JSONObject) (obj)).keys(); ((Iterator) (obj1)).hasNext(); processGraphObjectProperty(String.format("%s[%s]", new Object[] {
    s, s1
}), ((JSONObject) (obj)).opt(s1), keyvalueserializer, flag))
        {
            s1 = (String)((Iterator) (obj1)).next();
        }

          goto _L5
_L4:
        if (!((JSONObject) (obj)).has("id")) goto _L7; else goto _L6
_L6:
        processGraphObjectProperty(s, ((JSONObject) (obj)).optString("id"), keyvalueserializer, flag);
_L5:
        return;
_L7:
        if (((JSONObject) (obj)).has("url"))
        {
            processGraphObjectProperty(s, ((JSONObject) (obj)).optString("url"), keyvalueserializer, flag);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!org/json/JSONArray.isAssignableFrom(((Class) (obj1))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONArray)obj;
        int j = ((JSONArray) (obj)).length();
        int i = 0;
        while (i < j) 
        {
            processGraphObjectProperty(String.format("%s[%d]", new Object[] {
                s, Integer.valueOf(i)
            }), ((JSONArray) (obj)).opt(i), keyvalueserializer, flag);
            i++;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (java/lang/String.isAssignableFrom(((Class) (obj1))) || java/lang/Number.isAssignableFrom(((Class) (obj1))) || java/lang/Boolean.isAssignableFrom(((Class) (obj1))))
        {
            keyvalueserializer.writeString(s, obj.toString());
            return;
        }
        if (java/util/Date.isAssignableFrom(((Class) (obj1))))
        {
            obj = (Date)obj;
            keyvalueserializer.writeString(s, (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)).format(((Date) (obj))));
            return;
        }
        if (true) goto _L5; else goto _L9
_L9:
    }

    static void runCallbacks(final RequestBatch requests, List list)
    {
label0:
        {
            int j = requests.size();
            final ArrayList callbacks = new ArrayList();
            for (int i = 0; i < j; i++)
            {
                Request request = requests.get(i);
                if (request.callback != null)
                {
                    callbacks.add(new Pair(request.callback, list.get(i)));
                }
            }

            if (callbacks.size() > 0)
            {
                list = new _cls4();
                requests = requests.getCallbackHandler();
                if (requests != null)
                {
                    break label0;
                }
                list.run();
            }
            return;
        }
        requests.post(list);
    }

    private static void serializeAttachments(Bundle bundle, Serializer serializer)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (isSupportedAttachmentType(obj))
            {
                serializer.writeObject(s, obj);
            }
        } while (true);
    }

    private static void serializeParameters(Bundle bundle, Serializer serializer)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Object obj = bundle.get(s);
            if (isSupportedParameterType(obj))
            {
                serializer.writeObject(s, obj);
            }
        } while (true);
    }

    private static void serializeRequestsAsJSON(Serializer serializer, Collection collection, Bundle bundle)
    {
        JSONArray jsonarray = new JSONArray();
        for (collection = collection.iterator(); collection.hasNext(); ((Request)collection.next()).serializeToBatch(jsonarray, bundle)) { }
        serializer.writeString("batch", jsonarray.toString());
    }

    private void serializeToBatch(JSONArray jsonarray, final Bundle keysAndValues)
    {
        JSONObject jsonobject = new JSONObject();
        if (batchEntryName != null)
        {
            jsonobject.put("name", batchEntryName);
            jsonobject.put("omit_response_on_success", batchEntryOmitResultOnSuccess);
        }
        if (batchEntryDependsOn != null)
        {
            jsonobject.put("depends_on", batchEntryDependsOn);
        }
        String s = getUrlForBatchedRequest();
        jsonobject.put("relative_url", s);
        jsonobject.put("method", httpMethod);
        if (session != null)
        {
            Logger.registerAccessToken(session.getAccessToken());
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = parameters.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = parameters.get(((String) (obj)));
            if (isSupportedAttachmentType(obj))
            {
                String s1 = String.format("%s%d", new Object[] {
                    "file", Integer.valueOf(keysAndValues.size())
                });
                arraylist.add(s1);
                Utility.putObjectInBundle(keysAndValues, s1, obj);
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            jsonobject.put("attached_files", TextUtils.join(",", arraylist));
        }
        if (graphObject != null)
        {
            keysAndValues = new ArrayList();
            processGraphObject(graphObject, s, new _cls5());
            jsonobject.put("body", TextUtils.join("&", keysAndValues));
        }
        jsonarray.put(jsonobject);
    }

    static final void serializeToUrlConnection(RequestBatch requestbatch, HttpURLConnection httpurlconnection)
    {
        Logger logger;
        Object obj;
        int i;
        logger = new Logger(LoggingBehavior.REQUESTS, "Request");
        i = requestbatch.size();
        HttpMethod httpmethod;
        boolean flag;
        if (i == 1)
        {
            httpmethod = requestbatch.get(0).httpMethod;
        } else
        {
            httpmethod = HttpMethod.POST;
        }
        httpurlconnection.setRequestMethod(httpmethod.name());
        obj = httpurlconnection.getURL();
        logger.append("Request:\n");
        logger.appendKeyValue("Id", requestbatch.getId());
        logger.appendKeyValue("URL", obj);
        logger.appendKeyValue("Method", httpurlconnection.getRequestMethod());
        logger.appendKeyValue("User-Agent", httpurlconnection.getRequestProperty("User-Agent"));
        logger.appendKeyValue("Content-Type", httpurlconnection.getRequestProperty("Content-Type"));
        httpurlconnection.setConnectTimeout(requestbatch.getTimeout());
        httpurlconnection.setReadTimeout(requestbatch.getTimeout());
        if (httpmethod == HttpMethod.POST)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            logger.log();
            return;
        }
        httpurlconnection.setDoOutput(true);
        httpurlconnection = new BufferedOutputStream(httpurlconnection.getOutputStream());
        Serializer serializer = new Serializer(httpurlconnection, logger);
        if (i != 1) goto _L2; else goto _L1
_L1:
        requestbatch = requestbatch.get(0);
        logger.append("  Parameters:\n");
        serializeParameters(((Request) (requestbatch)).parameters, serializer);
        logger.append("  Attachments:\n");
        serializeAttachments(((Request) (requestbatch)).parameters, serializer);
        if (((Request) (requestbatch)).graphObject != null)
        {
            processGraphObject(((Request) (requestbatch)).graphObject, ((URL) (obj)).getPath(), serializer);
        }
_L3:
        httpurlconnection.close();
        logger.log();
        return;
_L2:
        obj = getBatchAppId(requestbatch);
        if (Utility.isNullOrEmpty(((String) (obj))))
        {
            throw new FacebookException("At least one request in a batch must have an open Session, or a default app ID must be specified.");
        }
        break MISSING_BLOCK_LABEL_290;
        requestbatch;
        httpurlconnection.close();
        throw requestbatch;
        serializer.writeString("batch_app_id", ((String) (obj)));
        obj = new Bundle();
        serializeRequestsAsJSON(serializer, requestbatch, ((Bundle) (obj)));
        logger.append("  Attachments:\n");
        serializeAttachments(((Bundle) (obj)), serializer);
          goto _L3
    }

    public static final void setDefaultBatchApplicationId(String s)
    {
        defaultBatchApplicationId = s;
    }

    public static HttpURLConnection toHttpConnection(RequestBatch requestbatch)
    {
        for (Iterator iterator = requestbatch.iterator(); iterator.hasNext(); ((Request)iterator.next()).validate()) { }
        Object obj;
        if (requestbatch.size() != 1)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        obj = new URL(requestbatch.get(0).getUrlForSingleRequest());
_L1:
        try
        {
            obj = createConnection(((URL) (obj)));
            serializeToUrlConnection(requestbatch, ((HttpURLConnection) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct request body", requestbatch);
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct request body", requestbatch);
        }
        return ((HttpURLConnection) (obj));
        try
        {
            obj = new URL("https://graph.facebook.com");
        }
        // Misplaced declaration of an exception variable
        catch (RequestBatch requestbatch)
        {
            throw new FacebookException("could not construct URL for request", requestbatch);
        }
          goto _L1
    }

    public static HttpURLConnection toHttpConnection(Collection collection)
    {
        Validate.notEmptyAndContainsNoNulls(collection, "requests");
        return toHttpConnection(new RequestBatch(collection));
    }

    public static transient HttpURLConnection toHttpConnection(Request arequest[])
    {
        return toHttpConnection(((Collection) (Arrays.asList(arequest))));
    }

    private static List typedListFromResponse(Response response, Class class1)
    {
        response = (GraphMultiResult)response.getGraphObjectAs(com/facebook/model/GraphMultiResult);
        if (response == null)
        {
            return null;
        }
        response = response.getData();
        if (response == null)
        {
            return null;
        } else
        {
            return response.castToListOf(class1);
        }
    }

    private void validate()
    {
        if (graphPath != null && restMethod != null)
        {
            throw new IllegalArgumentException("Only one of a graph path or REST method may be specified per request.");
        } else
        {
            return;
        }
    }

    public final Response executeAndWait()
    {
        return executeAndWait(this);
    }

    public final RequestAsyncTask executeAsync()
    {
        return executeBatchAsync(new Request[] {
            this
        });
    }

    public final String getBatchEntryDependsOn()
    {
        return batchEntryDependsOn;
    }

    public final String getBatchEntryName()
    {
        return batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess()
    {
        return batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback()
    {
        return callback;
    }

    public final GraphObject getGraphObject()
    {
        return graphObject;
    }

    public final String getGraphPath()
    {
        return graphPath;
    }

    public final HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public final Bundle getParameters()
    {
        return parameters;
    }

    public final String getRestMethod()
    {
        return restMethod;
    }

    public final Session getSession()
    {
        return session;
    }

    final String getUrlForBatchedRequest()
    {
        if (overriddenURL != null)
        {
            throw new FacebookException("Can't override URL for a batch request");
        }
        String s;
        if (restMethod != null)
        {
            s = (new StringBuilder()).append("method/").append(restMethod).toString();
        } else
        {
            s = graphPath;
        }
        addCommonParameters();
        return appendParametersToBaseUrl(s);
    }

    final String getUrlForSingleRequest()
    {
        if (overriddenURL != null)
        {
            return overriddenURL.toString();
        }
        String s;
        if (restMethod != null)
        {
            s = (new StringBuilder()).append("https://api.facebook.com/method/").append(restMethod).toString();
        } else
        {
            s = (new StringBuilder()).append("https://graph.facebook.com/").append(graphPath).toString();
        }
        addCommonParameters();
        return appendParametersToBaseUrl(s);
    }

    public final void setBatchEntryDependsOn(String s)
    {
        batchEntryDependsOn = s;
    }

    public final void setBatchEntryName(String s)
    {
        batchEntryName = s;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean flag)
    {
        batchEntryOmitResultOnSuccess = flag;
    }

    public final void setCallback(Callback callback1)
    {
        callback = callback1;
    }

    public final void setGraphObject(GraphObject graphobject)
    {
        graphObject = graphobject;
    }

    public final void setGraphPath(String s)
    {
        graphPath = s;
    }

    public final void setHttpMethod(HttpMethod httpmethod)
    {
        if (overriddenURL != null && httpmethod != HttpMethod.GET)
        {
            throw new FacebookException("Can't change HTTP method on request with overridden URL.");
        }
        if (httpmethod == null)
        {
            httpmethod = HttpMethod.GET;
        }
        httpMethod = httpmethod;
    }

    public final void setParameters(Bundle bundle)
    {
        parameters = bundle;
    }

    public final void setRestMethod(String s)
    {
        restMethod = s;
    }

    public final void setSession(Session session1)
    {
        session = session1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("{Request: ").append(" session: ").append(session).append(", graphPath: ").append(graphPath).append(", graphObject: ").append(graphObject).append(", restMethod: ").append(restMethod).append(", httpMethod: ").append(httpMethod).append(", parameters: ").append(parameters).append("}").toString();
    }




    private class _cls1
        implements Callback
    {

        final GraphUserCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted((GraphUser)response.getGraphObjectAs(com/facebook/model/GraphUser), response);
            }
        }

        _cls1()
        {
            callback = graphusercallback;
            super();
        }

        private class GraphUserCallback
        {

            public abstract void onCompleted(GraphUser graphuser, Response response);
        }

    }


    private class _cls2
        implements Callback
    {

        final GraphUserListCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted(Request.typedListFromResponse(response, com/facebook/model/GraphUser), response);
            }
        }

        _cls2()
        {
            callback = graphuserlistcallback;
            super();
        }

        private class GraphUserListCallback
        {

            public abstract void onCompleted(List list, Response response);
        }

    }


    private class _cls3
        implements Callback
    {

        final GraphPlaceListCallback val$callback;

        public final void onCompleted(Response response)
        {
            if (callback != null)
            {
                callback.onCompleted(Request.typedListFromResponse(response, com/facebook/model/GraphPlace), response);
            }
        }

        _cls3()
        {
            callback = graphplacelistcallback;
            super();
        }

        private class GraphPlaceListCallback
        {

            public abstract void onCompleted(List list, Response response);
        }

    }


    private class KeyValueSerializer
    {

        public abstract void writeString(String s, String s1);
    }


    private class _cls4
        implements Runnable
    {

        final ArrayList val$callbacks;
        final RequestBatch val$requests;

        public final void run()
        {
            Pair pair;
            for (Iterator iterator = callbacks.iterator(); iterator.hasNext(); ((Callback)pair.first).onCompleted((Response)pair.second))
            {
                pair = (Pair)iterator.next();
            }

            for (Iterator iterator1 = requests.getCallbacks().iterator(); iterator1.hasNext(); ((RequestBatch.Callback)iterator1.next()).onBatchCompleted(requests)) { }
        }

        _cls4()
        {
            callbacks = arraylist;
            requests = requestbatch;
            super();
        }

        private class Callback
        {

            public abstract void onCompleted(Response response);
        }

    }


    private class Serializer
        implements KeyValueSerializer
    {

        private boolean firstWrite;
        private final Logger logger;
        private final BufferedOutputStream outputStream;

        public transient void write(String s, Object aobj[])
        {
            if (firstWrite)
            {
                outputStream.write("--".getBytes());
                outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
                outputStream.write("\r\n".getBytes());
                firstWrite = false;
            }
            outputStream.write(String.format(s, aobj).getBytes());
        }

        public void writeBitmap(String s, Bitmap bitmap)
        {
            writeContentDisposition(s, s, "image/png");
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), "<Image>");
        }

        public void writeBytes(String s, byte abyte0[])
        {
            writeContentDisposition(s, s, "content/unknown");
            outputStream.write(abyte0);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), String.format("<Data: %d>", new Object[] {
                Integer.valueOf(abyte0.length)
            }));
        }

        public void writeContentDisposition(String s, String s1, String s2)
        {
            write("Content-Disposition: form-data; name=\"%s\"", new Object[] {
                s
            });
            if (s1 != null)
            {
                write("; filename=\"%s\"", new Object[] {
                    s1
                });
            }
            writeLine("", new Object[0]);
            if (s2 != null)
            {
                writeLine("%s: %s", new Object[] {
                    "Content-Type", s2
                });
            }
            writeLine("", new Object[0]);
        }

        public void writeFile(String s, ParcelFileDescriptor parcelfiledescriptor)
        {
            Object obj;
            obj = null;
            writeContentDisposition(s, s, "content/unknown");
            parcelfiledescriptor = new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelfiledescriptor);
            BufferedInputStream bufferedinputstream = new BufferedInputStream(parcelfiledescriptor);
            obj = new byte[8192];
            int i = 0;
_L2:
            int j = bufferedinputstream.read(((byte []) (obj)));
            if (j == -1)
            {
                break; /* Loop/switch isn't completed */
            }
            outputStream.write(((byte []) (obj)), 0, j);
            i += j;
            if (true) goto _L2; else goto _L1
_L1:
            bufferedinputstream.close();
            parcelfiledescriptor.close();
            writeLine("", new Object[0]);
            writeRecordBoundary();
            logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), String.format("<Data: %d>", new Object[] {
                Integer.valueOf(i)
            }));
            return;
            s;
            parcelfiledescriptor = null;
_L4:
            if (parcelfiledescriptor != null)
            {
                parcelfiledescriptor.close();
            }
            if (obj != null)
            {
                ((android.os.ParcelFileDescriptor.AutoCloseInputStream) (obj)).close();
            }
            throw s;
            s;
            bufferedinputstream = null;
            obj = parcelfiledescriptor;
            parcelfiledescriptor = bufferedinputstream;
            continue; /* Loop/switch isn't completed */
            s;
            obj = parcelfiledescriptor;
            parcelfiledescriptor = bufferedinputstream;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public transient void writeLine(String s, Object aobj[])
        {
            write(s, aobj);
            write("\r\n", new Object[0]);
        }

        public void writeObject(String s, Object obj)
        {
            if (Request.isSupportedParameterType(obj))
            {
                writeString(s, Request.parameterToString(obj));
                return;
            }
            if (obj instanceof Bitmap)
            {
                writeBitmap(s, (Bitmap)obj);
                return;
            }
            if (obj instanceof byte[])
            {
                writeBytes(s, (byte[])obj);
                return;
            }
            if (obj instanceof ParcelFileDescriptor)
            {
                writeFile(s, (ParcelFileDescriptor)obj);
                return;
            } else
            {
                throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
            }
        }

        public void writeRecordBoundary()
        {
            writeLine("--%s", new Object[] {
                "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f"
            });
        }

        public void writeString(String s, String s1)
        {
            writeContentDisposition(s, null, null);
            writeLine("%s", new Object[] {
                s1
            });
            writeRecordBoundary();
            if (logger != null)
            {
                logger.appendKeyValue((new StringBuilder()).append("    ").append(s).toString(), s1);
            }
        }

        public Serializer(BufferedOutputStream bufferedoutputstream, Logger logger1)
        {
            firstWrite = true;
            outputStream = bufferedoutputstream;
            logger = logger1;
        }
    }


    private class _cls5
        implements KeyValueSerializer
    {

        final Request this$0;
        final ArrayList val$keysAndValues;

        public void writeString(String s, String s1)
        {
            keysAndValues.add(String.format("%s=%s", new Object[] {
                s, URLEncoder.encode(s1, "UTF-8")
            }));
        }

        _cls5()
        {
            this$0 = Request.this;
            keysAndValues = arraylist;
            super();
        }
    }

}
