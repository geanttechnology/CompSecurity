// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.comm;

import android.content.Context;
import com.apptentive.android.sdk.GlobalInfo;
import com.apptentive.android.sdk.Log;
import com.apptentive.android.sdk.model.AppRelease;
import com.apptentive.android.sdk.model.ConversationTokenRequest;
import com.apptentive.android.sdk.model.Device;
import com.apptentive.android.sdk.model.Event;
import com.apptentive.android.sdk.model.FileMessage;
import com.apptentive.android.sdk.model.Message;
import com.apptentive.android.sdk.model.Person;
import com.apptentive.android.sdk.model.Sdk;
import com.apptentive.android.sdk.model.StoredFile;
import com.apptentive.android.sdk.model.SurveyResponse;
import com.apptentive.android.sdk.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.apptentive.android.sdk.comm:
//            ApptentiveHttpResponse

public class ApptentiveClient
{

    private static final int API_VERSION = 2;
    private static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 30000;
    private static final int DEFAULT_HTTP_SOCKET_TIMEOUT = 30000;
    private static final String ENDPOINT_BASE_PRODUCTION = "https://api.apptentive.com";
    private static final String ENDPOINT_BASE_STAGING = "https://api.apptentive-beta.com";
    private static final String ENDPOINT_CONFIGURATION = "/conversation/configuration";
    private static final String ENDPOINT_CONVERSATION = "/conversation";
    private static final String ENDPOINT_CONVERSATION_FETCH = "/conversation?count=%s&after_id=%s&before_id=%s";
    private static final String ENDPOINT_DEVICES = "/devices";
    private static final String ENDPOINT_EVENTS = "/events";
    private static final String ENDPOINT_INTERACTIONS = "/interactions";
    private static final String ENDPOINT_MESSAGES = "/messages";
    private static final String ENDPOINT_PEOPLE = "/people";
    private static final String ENDPOINT_SURVEYS_POST = "/surveys/%s/respond";
    private static final String USER_AGENT_STRING = "Apptentive/%s (Android)";
    public static boolean useStagingServer = false;

    public ApptentiveClient()
    {
    }

    public static ApptentiveHttpResponse getAppConfiguration()
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/conversation/configuration", Method.GET, null);
    }

    public static ApptentiveHttpResponse getConversationToken(ConversationTokenRequest conversationtokenrequest)
    {
        return performHttpRequest(GlobalInfo.apiKey, "/conversation", Method.POST, conversationtokenrequest.toString());
    }

    private static String getEndpointBase()
    {
        if (useStagingServer)
        {
            return "https://api.apptentive-beta.com";
        } else
        {
            return "https://api.apptentive.com";
        }
    }

    public static ApptentiveHttpResponse getInteractions()
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/interactions", Method.GET, null);
    }

    public static ApptentiveHttpResponse getMessages(Integer integer, String s, String s1)
    {
        String s2;
        if (integer == null)
        {
            integer = "";
        } else
        {
            integer = integer.toString();
        }
        s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        integer = String.format("/conversation?count=%s&after_id=%s&before_id=%s", new Object[] {
            integer, s2, s
        });
        return performHttpRequest(GlobalInfo.conversationToken, integer, Method.GET, null);
    }

    private static String getUserAgentString()
    {
        return String.format("Apptentive/%s (Android)", new Object[] {
            "1.7.3"
        });
    }

    private static ApptentiveHttpResponse performHttpRequest(String s, String s1, Method method, String s2)
    {
        String s3;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        ApptentiveHttpResponse apptentivehttpresponse;
        Object obj5;
        obj3 = null;
        obj2 = null;
        s3 = null;
        obj4 = null;
        obj1 = null;
        obj5 = (new StringBuilder()).append(getEndpointBase()).append(s1).toString();
        Log.d("Performing request to %s", new Object[] {
            obj5
        });
        apptentivehttpresponse = new ApptentiveHttpResponse();
        s1 = new DefaultHttpClient();
        Object obj;
        obj = obj4;
        s3 = s1;
        _cls1..SwitchMap.com.apptentive.android.sdk.comm.ApptentiveClient.Method[method.ordinal()];
        JVM INSTR tableswitch 1 3: default 1169
    //                   1 159
    //                   2 558
    //                   3 692;
           goto _L1 _L2 _L3 _L4
_L1:
        obj = obj4;
        s3 = s1;
        Log.e((new StringBuilder("Unrecognized method: ")).append(method.name()).toString(), new Object[0]);
        s1.getConnectionManager().shutdown();
        Util.ensureClosed(null);
        return apptentivehttpresponse;
_L2:
        obj = obj4;
        s3 = s1;
        method = new HttpGet(((String) (obj5)));
_L9:
        obj = obj4;
        s3 = s1;
        s2 = method.getParams();
        obj = obj4;
        s3 = s1;
        HttpConnectionParams.setConnectionTimeout(s2, 30000);
        obj = obj4;
        s3 = s1;
        HttpConnectionParams.setSoTimeout(s2, 30000);
        obj = obj4;
        s3 = s1;
        s2.setParameter("http.useragent", getUserAgentString());
        obj = obj4;
        s3 = s1;
        method.setHeader("Authorization", (new StringBuilder("OAuth ")).append(s).toString());
        obj = obj4;
        s3 = s1;
        method.setHeader("Accept-Encoding", "gzip");
        obj = obj4;
        s3 = s1;
        method.setHeader("Accept", "application/json");
        obj = obj4;
        s3 = s1;
        method.setHeader("X-API-Version", "2");
        obj = obj4;
        s3 = s1;
        s = s1.execute(method);
        obj = obj4;
        s3 = s1;
        int i = s.getStatusLine().getStatusCode();
        obj = obj4;
        s3 = s1;
        apptentivehttpresponse.setCode(i);
        obj = obj4;
        s3 = s1;
        apptentivehttpresponse.setReason(s.getStatusLine().getReasonPhrase());
        obj = obj4;
        s3 = s1;
        Log.d((new StringBuilder("Response Status Line: ")).append(s.getStatusLine().toString()).toString(), new Object[0]);
        obj = obj4;
        s3 = s1;
        method = s.headerIterator();
        if (method == null) goto _L6; else goto _L5
_L5:
        obj = obj4;
        s3 = s1;
        s2 = new HashMap();
_L8:
        obj = obj4;
        s3 = s1;
        if (!method.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj4;
        s3 = s1;
        obj5 = (Header)method.next();
        obj = obj4;
        s3 = s1;
        s2.put(((Header) (obj5)).getName(), ((Header) (obj5)).getValue());
        if (true) goto _L8; else goto _L7
        s2;
        s = s1;
        method = obj1;
        s1 = s2;
_L17:
        Log.w("Error communicating with server.", s1, new Object[0]);
        if (s != null)
        {
            s.getConnectionManager().shutdown();
        }
        Util.ensureClosed(method);
_L10:
        return apptentivehttpresponse;
_L3:
        obj = obj4;
        s3 = s1;
        method = new HttpPut(((String) (obj5)));
        obj = obj4;
        s3 = s1;
        method.setHeader("Content-Type", "application/json");
        obj = obj4;
        s3 = s1;
        Log.d((new StringBuilder("PUT body: ")).append(s2).toString(), new Object[0]);
        obj = obj4;
        s3 = s1;
        ((HttpPut)method).setEntity(new StringEntity(s2, "UTF-8"));
          goto _L9
        s;
        s = obj3;
_L21:
        obj = s;
        s3 = s1;
        Log.w("Timeout communicating with server.", new Object[0]);
        if (s1 != null)
        {
            s1.getConnectionManager().shutdown();
        }
        Util.ensureClosed(s);
          goto _L10
_L4:
        obj = obj4;
        s3 = s1;
        method = new HttpPost(((String) (obj5)));
        obj = obj4;
        s3 = s1;
        method.setHeader("Content-Type", "application/json");
        obj = obj4;
        s3 = s1;
        Log.d((new StringBuilder("POST body: ")).append(s2).toString(), new Object[0]);
        obj = obj4;
        s3 = s1;
        ((HttpPost)method).setEntity(new StringEntity(s2, "UTF-8"));
          goto _L9
        s;
        method = obj2;
_L20:
        obj = method;
        s3 = s1;
        Log.w("Error communicating with server.", s, new Object[0]);
        if (s1 != null)
        {
            s1.getConnectionManager().shutdown();
        }
        Util.ensureClosed(method);
          goto _L10
_L7:
        obj = obj4;
        s3 = s1;
        apptentivehttpresponse.setHeaders(s2);
_L6:
        obj = obj4;
        s3 = s1;
        s = s.getEntity();
        if (s == null) goto _L12; else goto _L11
_L11:
        obj = obj4;
        s3 = s1;
        s = s.getContent();
        if (s == null) goto _L14; else goto _L13
_L13:
        method = (String)apptentivehttpresponse.getHeaders().get("Content-Encoding");
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_917;
        }
        if (!method.equalsIgnoreCase("gzip"))
        {
            break MISSING_BLOCK_LABEL_917;
        }
        method = new GZIPInputStream(s);
        s = method;
        apptentivehttpresponse.setContent(Util.readStringFromInputStream(s, "UTF-8"));
        if (i < 200 || i >= 300) goto _L16; else goto _L15
_L15:
        Log.v((new StringBuilder("Response: ")).append(apptentivehttpresponse.getContent()).toString(), new Object[0]);
_L14:
        s1.getConnectionManager().shutdown();
        Util.ensureClosed(s);
          goto _L10
_L16:
        Log.w((new StringBuilder("Response: ")).append(apptentivehttpresponse.getContent()).toString(), new Object[0]);
          goto _L14
        s2;
        method = s;
        s = s2;
        s2 = s1;
        s1 = s;
        s = s2;
          goto _L17
        s;
        s1 = null;
        method = s3;
_L19:
        if (s1 != null)
        {
            s1.getConnectionManager().shutdown();
        }
        Util.ensureClosed(method);
        throw s;
        s;
        method = ((Method) (obj));
        s1 = s3;
        continue; /* Loop/switch isn't completed */
        s2;
        method = s;
        s = s2;
        continue; /* Loop/switch isn't completed */
        s2;
        method = s;
        s = s2;
        continue; /* Loop/switch isn't completed */
        s2;
        s1 = s;
        s = s2;
        if (true) goto _L19; else goto _L18
_L18:
        s;
        s1 = null;
        method = obj2;
          goto _L20
        s2;
        method = s;
        s = s2;
          goto _L20
        s2;
        method = s;
        s = s2;
          goto _L20
        s;
        s1 = null;
        s = obj3;
          goto _L21
        method;
          goto _L21
        method;
          goto _L21
        s1;
        s = null;
        method = obj1;
          goto _L17
        s2;
        method = s;
        s = s1;
        s1 = s2;
          goto _L17
_L12:
        s = null;
          goto _L14
    }

    private static ApptentiveHttpResponse performMultipartFilePost(Context context, String s, String s1, String s2, StoredFile storedfile)
    {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        ApptentiveHttpResponse apptentivehttpresponse;
        Object obj7;
        String s3;
        obj7 = (new StringBuilder()).append(getEndpointBase()).append(s1).toString();
        Log.d("Performing multipart request to %s", new Object[] {
            obj7
        });
        apptentivehttpresponse = new ApptentiveHttpResponse();
        if (storedfile == null)
        {
            Log.e("StoredFile is null. Unable to send.", new Object[0]);
            return apptentivehttpresponse;
        }
        s3 = UUID.randomUUID().toString();
        obj3 = null;
        obj5 = null;
        obj4 = null;
        obj = null;
        obj6 = null;
        obj2 = null;
        s1 = null;
        context = context.openFileInput(storedfile.getLocalFilePath());
        obj = obj6;
        s1 = context;
        obj7 = (HttpURLConnection)(new URL(((String) (obj7)))).openConnection();
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setDoInput(true);
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setDoOutput(true);
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setUseCaches(false);
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setConnectTimeout(30000);
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setReadTimeout(30000);
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestMethod("POST");
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("Connection", "Keep-Alive");
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data;boundary=")).append(s3).toString());
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("Authorization", (new StringBuilder("OAuth ")).append(s).toString());
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("Accept", "application/json");
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("X-API-Version", "2");
        obj = obj6;
        s1 = context;
        ((HttpURLConnection) (obj7)).setRequestProperty("User-Agent", getUserAgentString());
        obj = obj6;
        s1 = context;
        StringBuilder stringbuilder = new StringBuilder();
        obj = obj6;
        s1 = context;
        stringbuilder.append("--").append(s3).append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("Content-Disposition: form-data; name=\"message\"").append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("Content-Type: text/plain").append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append(s2);
        obj = obj6;
        s1 = context;
        stringbuilder.append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("--").append(s3).append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append(String.format("Content-Disposition: form-data; name=\"file\"; filename=\"%s\"", new Object[] {
            storedfile.getFileName()
        })).append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("Content-Type: ").append(storedfile.getMimeType()).append("\r\n");
        obj = obj6;
        s1 = context;
        stringbuilder.append("\r\n");
        obj = obj6;
        s1 = context;
        Log.d((new StringBuilder("Post body: ")).append(stringbuilder).toString(), new Object[0]);
        obj = obj6;
        s1 = context;
        s = new DataOutputStream(((HttpURLConnection) (obj7)).getOutputStream());
        s.writeBytes(stringbuilder.toString());
        s1 = new byte[4096];
_L3:
        int i = context.read(s1, 0, 4096);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        s.write(s1, 0, i);
          goto _L3
        s1;
        Log.d("Error writing file bytes to HTTP connection.", s1, new Object[0]);
        apptentivehttpresponse.setBadPayload(true);
        throw s1;
        s1;
        obj = s;
        s = s1;
_L16:
        Log.e("Error getting file to upload.", s, new Object[0]);
        Util.ensureClosed(context);
        Util.ensureClosed(((java.io.Closeable) (obj)));
_L8:
        return apptentivehttpresponse;
_L2:
        s.writeBytes((new StringBuilder()).append("--").append(s3).append("--").append("\r\n").toString());
        s.close();
        apptentivehttpresponse.setCode(((HttpURLConnection) (obj7)).getResponseCode());
        apptentivehttpresponse.setReason(((HttpURLConnection) (obj7)).getResponseMessage());
        s2 = null;
        obj = null;
        Log.d((new StringBuilder("Sending file: ")).append(storedfile.getLocalFilePath()).toString(), new Object[0]);
        s1 = ((HttpURLConnection) (obj7)).getInputStream();
        storedfile = new ByteArrayOutputStream();
        s2 = new byte[1024];
_L5:
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = s1.read(s2, 0, 1024);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        storedfile.write(s2, 0, i);
        if (true) goto _L5; else goto _L4
        obj;
        s2 = s1;
        s1 = storedfile;
        storedfile = ((StoredFile) (obj));
_L20:
        Log.w("Can't read return stream.", storedfile, new Object[0]);
        Util.ensureClosed(s2);
        Util.ensureClosed(s1);
_L9:
        s1 = ((HttpURLConnection) (obj7)).getErrorStream();
        storedfile = new ByteArrayOutputStream();
        s2 = new byte[1024];
_L7:
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i = s1.read(s2, 0, 1024);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        storedfile.write(s2, 0, i);
        if (true) goto _L7; else goto _L6
        obj;
        s2 = s1;
        s1 = storedfile;
        storedfile = ((StoredFile) (obj));
_L18:
        Log.w("Can't read error stream.", storedfile, new Object[0]);
        Util.ensureClosed(s2);
        Util.ensureClosed(s1);
_L10:
        Log.d((new StringBuilder("HTTP ")).append(((HttpURLConnection) (obj7)).getResponseCode()).append(": ").append(((HttpURLConnection) (obj7)).getResponseMessage()).toString(), new Object[0]);
        Log.v(apptentivehttpresponse.getContent(), new Object[0]);
        Util.ensureClosed(context);
        Util.ensureClosed(s);
          goto _L8
_L4:
        apptentivehttpresponse.setContent(storedfile.toString());
        Util.ensureClosed(s1);
        Util.ensureClosed(storedfile);
          goto _L9
        s1;
        s2 = s;
        s = s1;
_L15:
        obj = s2;
        s1 = context;
        Log.e("Error constructing url for file upload.", s, new Object[0]);
        Util.ensureClosed(context);
        Util.ensureClosed(s2);
          goto _L8
        s1;
        storedfile = ((StoredFile) (obj));
_L19:
        Util.ensureClosed(s2);
        Util.ensureClosed(storedfile);
        throw s1;
        s1;
_L14:
        obj = s;
        s1 = context;
        Log.w("Timeout communicating with server.", new Object[0]);
        Util.ensureClosed(context);
        Util.ensureClosed(s);
          goto _L8
_L6:
        if (storedfile.size() > 0)
        {
            apptentivehttpresponse.setContent(storedfile.toString());
        }
        Util.ensureClosed(s1);
        Util.ensureClosed(storedfile);
          goto _L10
        s1;
        s2 = s;
        s = s1;
_L13:
        obj = s2;
        s1 = context;
        Log.e("Error executing file upload.", s, new Object[0]);
        Util.ensureClosed(context);
        Util.ensureClosed(s2);
          goto _L8
        s2;
        s1 = null;
        storedfile = null;
_L17:
        Util.ensureClosed(s1);
        Util.ensureClosed(storedfile);
        throw s2;
        s2;
        s1 = context;
        obj = s;
        context = s2;
_L12:
        Util.ensureClosed(s1);
        Util.ensureClosed(((java.io.Closeable) (obj)));
        throw context;
        context;
        s1 = null;
        continue; /* Loop/switch isn't completed */
        context;
        continue; /* Loop/switch isn't completed */
        s;
        s1 = context;
        context = s;
        if (true) goto _L12; else goto _L11
_L11:
        s;
        context = null;
        s2 = obj4;
          goto _L13
        s;
        s2 = obj4;
          goto _L13
        context;
        context = null;
        s = obj5;
          goto _L14
        s;
        s = obj5;
          goto _L14
        s;
        context = null;
        s2 = obj3;
          goto _L15
        s;
        s2 = obj3;
          goto _L15
        s;
        context = s1;
        obj = obj2;
          goto _L16
        s;
        obj = obj2;
          goto _L16
        s2;
        storedfile = null;
          goto _L17
        s2;
          goto _L17
        storedfile;
        obj = s2;
        s2 = storedfile;
        storedfile = s1;
        s1 = ((String) (obj));
          goto _L17
        storedfile;
        s2 = null;
        s1 = null;
          goto _L18
        storedfile;
        obj = null;
        s2 = s1;
        s1 = ((String) (obj));
          goto _L18
        storedfile;
        s2 = s1;
        s1 = storedfile;
        storedfile = ((StoredFile) (obj));
          goto _L19
        Exception exception;
        exception;
        s2 = s1;
        s1 = exception;
          goto _L19
        exception;
        storedfile = s1;
        s1 = exception;
          goto _L19
        storedfile;
        s2 = null;
        s1 = null;
          goto _L20
        storedfile;
        Object obj1 = null;
        s2 = s1;
        s1 = obj1;
          goto _L20
    }

    public static ApptentiveHttpResponse postEvent(Event event)
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/events", Method.POST, event.marshallForSending());
    }

    public static ApptentiveHttpResponse postMessage(Context context, Message message)
    {
        StoredFile storedfile;
        switch (_cls1..SwitchMap.com.apptentive.android.sdk.model.Message.Type[message.getType().ordinal()])
        {
        default:
            return new ApptentiveHttpResponse();

        case 1: // '\001'
            return performHttpRequest(GlobalInfo.conversationToken, "/messages", Method.POST, message.marshallForSending());

        case 2: // '\002'
            return performHttpRequest(GlobalInfo.conversationToken, "/messages", Method.POST, message.marshallForSending());

        case 3: // '\003'
            storedfile = ((FileMessage)message).getStoredFile(context);
            break;
        }
        return performMultipartFilePost(context, GlobalInfo.conversationToken, "/messages", message.marshallForSending(), storedfile);
    }

    public static ApptentiveHttpResponse postSurvey(SurveyResponse surveyresponse)
    {
        String s = String.format("/surveys/%s/respond", new Object[] {
            surveyresponse.getId()
        });
        return performHttpRequest(GlobalInfo.conversationToken, s, Method.POST, surveyresponse.marshallForSending());
    }

    public static ApptentiveHttpResponse putAppRelease(AppRelease apprelease)
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/conversation", Method.PUT, apprelease.marshallForSending());
    }

    public static ApptentiveHttpResponse putDevice(Device device)
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/devices", Method.PUT, device.marshallForSending());
    }

    public static ApptentiveHttpResponse putPerson(Person person)
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/people", Method.PUT, person.marshallForSending());
    }

    public static ApptentiveHttpResponse putSdk(Sdk sdk)
    {
        return performHttpRequest(GlobalInfo.conversationToken, "/conversation", Method.PUT, sdk.marshallForSending());
    }


    private class Method extends Enum
    {

        private static final Method $VALUES[];
        public static final Method GET;
        public static final Method POST;
        public static final Method PUT;

        public static Method valueOf(String s)
        {
            return (Method)Enum.valueOf(com/apptentive/android/sdk/comm/ApptentiveClient$Method, s);
        }

        public static Method[] values()
        {
            return (Method[])$VALUES.clone();
        }

        static 
        {
            GET = new Method("GET", 0);
            PUT = new Method("PUT", 1);
            POST = new Method("POST", 2);
            $VALUES = (new Method[] {
                GET, PUT, POST
            });
        }

        private Method(String s, int i)
        {
            super(s, i);
        }
    }


    private class _cls1
    {

        static final int $SwitchMap$com$apptentive$android$sdk$comm$ApptentiveClient$Method[];
        static final int $SwitchMap$com$apptentive$android$sdk$model$Message$Type[];

        static 
        {
            $SwitchMap$com$apptentive$android$sdk$comm$ApptentiveClient$Method = new int[Method.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$comm$ApptentiveClient$Method[Method.GET.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$comm$ApptentiveClient$Method[Method.PUT.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$comm$ApptentiveClient$Method[Method.POST.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            $SwitchMap$com$apptentive$android$sdk$model$Message$Type = new int[com.apptentive.android.sdk.model.Message.Type.values().length];
            try
            {
                $SwitchMap$com$apptentive$android$sdk$model$Message$Type[com.apptentive.android.sdk.model.Message.Type.TextMessage.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$model$Message$Type[com.apptentive.android.sdk.model.Message.Type.AutomatedMessage.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$model$Message$Type[com.apptentive.android.sdk.model.Message.Type.FileMessage.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$apptentive$android$sdk$model$Message$Type[com.apptentive.android.sdk.model.Message.Type.unknown.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
