// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http.synchronous;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.groupon.http.GrouponOkHttpClient;
import com.groupon.models.error.ErrorConverter;
import com.groupon.network.HttpResponseException;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BitmapUtil;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.HttpUtil;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import oauth.signpost.OAuth;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class SyncHttp
    implements Callable
{

    public static final String HEADER_SHOULD_ADD_AUTHORIZATION = "Suppress authorization";
    private static final int NOT_CONNECTED_EXCEPTION_CODE = -1;
    private static final int OTHER_EXCEPTION_CODE = 0;
    private static final String SUBTYPE_JSON = "json";
    private String apiKey;
    private BitmapUtil bitmapUtil;
    private RequestBody body;
    private Lazy connectivityManager;
    protected Context context;
    private Lazy currentCountryManager;
    private Lazy currentCountryService;
    protected Lazy deviceInfoUtil;
    private Lazy errorConverter;
    private boolean forceFullSizeBitmapDownload;
    private Lazy grouponOkHttpClient;
    private Headers headers;
    private boolean isAuthorizationRequired;
    private Logger logger;
    protected String method;
    private Object nvps[];
    private ObjectMapperWrapper om;
    private Lazy packageInfo;
    protected URI parsedUri;
    private Class resultType;
    protected String uri;

    public SyncHttp(Context context1, Class class1, String s)
    {
        this(context1, class1, s, (Object[])null);
    }

    public SyncHttp(Context context1, Class class1, String s, Headers headers1, RequestBody requestbody)
    {
        this(context1, class1, s);
        headers = headers1;
        body = requestbody;
    }

    public SyncHttp(Context context1, Class class1, String s, RequestBody requestbody)
    {
        this(context1, class1, s);
        body = requestbody;
    }

    public transient SyncHttp(Context context1, Class class1, String s, Object aobj[])
    {
        isAuthorizationRequired = true;
        method = "GET";
        nvps = new Object[0];
        context = context1;
        uri = s;
        resultType = class1;
        apiKey = "b9ab4fb791ccb18cac3a83c999a9d559";
        nvps = aobj;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public SyncHttp body(RequestBody requestbody)
    {
        body = requestbody;
        return this;
    }

    public Object call()
        throws Exception
    {
        Object obj;
        int i;
        int j;
        long l;
        obj = getURI();
        Ln.d(obj, new Object[0]);
        j = 0;
        l = System.currentTimeMillis();
        i = j;
        obj = getResponse(((URI) (obj)));
        logApiRequest(((Response) (obj)), 0, l, System.currentTimeMillis());
        InputStream inputstream = ((Response) (obj)).body().byteStream();
        if (inputstream == null)
        {
            obj = null;
        } else
        {
            obj = inputstream;
            if (!java/io/InputStream.isAssignableFrom(resultType))
            {
                if (java/io/Reader.isAssignableFrom(resultType))
                {
                    return new InputStreamReader(inputstream, "UTF-8");
                } else
                {
                    return getResultFromStream(inputstream);
                }
            }
        }
        return obj;
        obj;
        i = j;
        j = ((HttpResponseException) (obj)).getStatusCode();
        i = j;
        throw obj;
        obj;
        logApiRequest(null, i, l, System.currentTimeMillis());
        throw obj;
        obj;
        i = -1;
        throw obj;
    }

    public Context context()
    {
        return context;
    }

    public SyncHttp forceFullSizeBitmapDownload(boolean flag)
    {
        forceFullSizeBitmapDownload = flag;
        return this;
    }

    public String getBaseUrl()
        throws Exception
    {
        return ((CurrentCountryService)currentCountryService.get()).getBaseUrl(((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry());
    }

    public URI getFullURI()
        throws Exception
    {
        if (nvps != null && nvps.length > 0)
        {
            return new URI(OAuth.addQueryParameters(Strings.toString(getURI()), nvpsToMap(nvps)));
        } else
        {
            return getURI();
        }
    }

    protected Request getRequest(URI uri1)
        throws Exception
    {
label0:
        {
label1:
            {
                if (!Strings.equalsIgnoreCase(method, "GET") && !Strings.equalsIgnoreCase(method, "DELETE"))
                {
                    break label0;
                }
                URI uri2 = uri1;
                if (nvps != null)
                {
                    uri2 = uri1;
                    if (nvps.length > 0)
                    {
                        uri2 = new URI(OAuth.addQueryParameters(Strings.toString(uri1), nvpsToMap(nvps)));
                    }
                }
                String s = Strings.toString(uri2);
                if (!s.contains("/deals"))
                {
                    uri1 = uri2;
                    if (!s.contains("/now_deals"))
                    {
                        break label1;
                    }
                }
                uri1 = new URI(OAuth.addQueryParameters(Strings.toString(uri2), new String[] {
                    "metadata", Strings.toString(Boolean.valueOf(true))
                }));
            }
            uri1 = newHttpUriRequest(new URI(OAuth.addQueryParameters(Strings.toString(uri1), new String[] {
                "client_id", apiKey, "client_version_id", ((PackageInfo)packageInfo.get()).versionName, "secure_assets", Strings.toString(Boolean.valueOf(false))
            })), null);
            if (headers == null)
            {
                return uri1;
            }
            uri1 = uri1.newBuilder();
            String s1;
            for (Iterator iterator = headers.names().iterator(); iterator.hasNext(); uri1.addHeader(s1, headers.get(s1)))
            {
                s1 = (String)iterator.next();
            }

            return uri1.build();
        }
        if (body != null)
        {
            Ln.d("Unused code for now", new Object[0]);
            uri1 = newHttpUriRequest(new URI(OAuth.addQueryParameters(Strings.toString(uri1), new String[] {
                "client_id", apiKey, "client_version_id", ((PackageInfo)packageInfo.get()).versionName, "secure_assets", Strings.toString(Boolean.valueOf(false))
            })), body);
            com.squareup.okhttp.Request.Builder builder = uri1.newBuilder();
            if (headers != null)
            {
                builder.headers(headers);
            }
            return uri1;
        }
        Object obj = newHttpUriRequest(new URI(OAuth.addQueryParameters(Strings.toString(uri1), new String[] {
            "client_id", apiKey, "client_version_id", ((PackageInfo)packageInfo.get()).versionName
        })), null);
        uri1 = new FormEncodingBuilder();
        for (int i = 0; i < nvps.length; i += 2)
        {
            uri1.add(Strings.toString(nvps[i]), Strings.toString(nvps[i + 1]));
        }

        obj = ((Request) (obj)).newBuilder();
        if (Strings.equalsIgnoreCase(method, "POST"))
        {
            ((com.squareup.okhttp.Request.Builder) (obj)).post(uri1.build());
        } else
        {
            ((com.squareup.okhttp.Request.Builder) (obj)).put(uri1.build());
        }
        return ((com.squareup.okhttp.Request.Builder) (obj)).build();
    }

    protected Response getResponse(URI uri1)
        throws Exception
    {
        Response response;
        int i;
        if (((ConnectivityManager)connectivityManager.get()).getActiveNetworkInfo() == null)
        {
            throw new ConnectException("No internet connection available");
        }
        response = ((GrouponOkHttpClient)grouponOkHttpClient.get()).newCall(getRequest(uri1)).execute();
        i = response.code();
        if (!HttpUtil.isExceptionResponseCode(i))
        {
            break MISSING_BLOCK_LABEL_202;
        }
        if (!HttpUtil.canParseJsonErrorMessage(i)) goto _L2; else goto _L1
_L1:
        uri1 = response.body();
        if (!uri1.contentType().subtype().contains("json")) goto _L2; else goto _L3
_L3:
        byte abyte0[];
        abyte0 = uri1.bytes();
        uri1 = null;
        Map map = (Map)om.readValue(abyte0, new TypeReference() {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super();
            }
        });
        uri1 = map;
_L4:
        if (uri1 != null && !uri1.isEmpty())
        {
            throw ((ErrorConverter)errorConverter.get()).fromJson(uri1);
        }
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        Ln.e(ioexception);
        if (true) goto _L4; else goto _L2
_L2:
        throw new HttpResponseException(i, String.format("%s %s for %s", new Object[] {
            Integer.valueOf(i), response.message(), response.request().uri()
        }));
        return response;
    }

    protected Object getResultFromStream(InputStream inputstream)
        throws Exception
    {
        if (inputstream == null)
        {
            IOUtils.close(inputstream);
            return null;
        }
        Object obj = new InputStreamReader(inputstream, "UTF-8");
        if (!android/graphics/Bitmap.equals(resultType)) goto _L2; else goto _L1
_L1:
        obj = bitmapUtil.createBitmapFromStream(inputstream, getFullURI(), forceFullSizeBitmapDownload, ((DeviceInfoUtil)deviceInfoUtil.get()).getDisplayMetrics());
_L3:
        IOUtils.close(inputstream);
        return obj;
_L2:
label0:
        {
            if (!android/graphics/drawable/Drawable.isAssignableFrom(resultType))
            {
                break label0;
            }
            obj = new BitmapDrawable(bitmapUtil.createBitmapFromStream(inputstream, getFullURI(), forceFullSizeBitmapDownload, ((DeviceInfoUtil)deviceInfoUtil.get()).getDisplayMetrics()));
        }
          goto _L3
label1:
        {
            if (!java/lang/String.equals(resultType))
            {
                break label1;
            }
            obj = Strings.toString(inputstream);
        }
          goto _L3
        boolean flag = java/lang/Void.equals(resultType);
        if (flag)
        {
            IOUtils.close(inputstream);
            return null;
        }
        obj = om.readValue(((Reader) (obj)), resultType);
          goto _L3
        Exception exception;
        exception;
        IOUtils.close(inputstream);
        throw exception;
    }

    public URI getURI()
        throws Exception
    {
        if (parsedUri != null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        CurrentCountryManager currentcountrymanager;
        obj = (CurrentCountryService)currentCountryService.get();
        currentcountrymanager = (CurrentCountryManager)currentCountryManager.get();
        s = uri;
        if (s != null) goto _L4; else goto _L3
_L3:
        obj = ((CurrentCountryService) (obj)).getBaseUrl(currentcountrymanager.getCurrentCountry());
_L6:
        parsedUri = new URI(((String) (obj)));
        if (!"https".equalsIgnoreCase(parsedUri.getScheme()) && !Strings.equalsIgnoreCase(method, "GET"))
        {
            parsedUri = new URI("https", parsedUri.getUserInfo(), parsedUri.getHost(), parsedUri.getPort(), parsedUri.getPath(), parsedUri.getQuery(), parsedUri.getFragment());
        }
        Ln.d("Using Uri: %s", new Object[] {
            parsedUri
        });
_L2:
        return parsedUri;
_L4:
        if (s.startsWith("/"))
        {
            obj = (new StringBuilder()).append(((CurrentCountryService) (obj)).getBaseUrl(currentcountrymanager.getCurrentCountry())).append(s).toString();
        } else
        {
            obj = s;
            if (s.toLowerCase().startsWith("https:/"))
            {
                obj = s;
                if (!s.toLowerCase().startsWith("https://"))
                {
                    obj = getBaseUrl();
                    obj = (new StringBuilder()).append("https://").append(((String) (obj)).substring(((String) (obj)).indexOf("://") + 3)).append(s.substring(6)).toString();
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void init()
    {
        grouponOkHttpClient = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        currentCountryService = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        currentCountryManager = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        connectivityManager = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        packageInfo = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        deviceInfoUtil = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
        errorConverter = new Lazy(context) {

            final SyncHttp this$0;

            
            {
                this$0 = SyncHttp.this;
                super(context1);
            }
        };
    }

    protected void logApiRequest(Response response, int i, long l, long l1)
    {
        Object obj;
        StringBuilder stringbuilder;
        Iterator iterator;
        stringbuilder = new StringBuilder();
        obj = new HashSet(com.groupon.Constants.Http.hiddenList);
        iterator = nvpsToMap(nvps()).entrySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (!((Set) (obj)).contains(entry.getKey())) goto _L4; else goto _L3
_L3:
        String s = "HIDDEN";
_L6:
        stringbuilder.append("&").append((String)entry.getKey()).append("=").append(s);
          goto _L5
_L13:
        return;
_L4:
        s = (String)entry.getValue();
          goto _L6
_L2:
        obj = Strings.toString(getURI());
        if (stringbuilder.length() != 0) goto _L8; else goto _L7
_L7:
        s = "";
          goto _L9
_L15:
        int j = (int)(l1 - l);
        response = ((ConnectivityManager)connectivityManager.get()).getActiveNetworkInfo();
        if (response != null) goto _L11; else goto _L10
_L10:
        response = "none";
_L14:
        if (((String) (obj)).contains("logs/analytic/event.gif") || ((String) (obj)).contains("logs/analytic/view.gif")) goto _L13; else goto _L12
_L12:
        logger.logAPITransaction(method, ((String) (obj)), s, i, l, 0L, j, response, Logger.NULL_NST_FIELD);
        return;
_L8:
        s = stringbuilder.substring(1);
          goto _L9
_L16:
        try
        {
            i = response.code();
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            Ln.e(response);
        }
          goto _L13
_L11:
        if (response.getType() != 0)
        {
            break MISSING_BLOCK_LABEL_277;
        }
        response = "mobile";
          goto _L14
        if (response.getType() == 1)
        {
            response = "wifi";
        } else
        {
            response = "unknown";
        }
          goto _L14
_L9:
        if (response != null) goto _L16; else goto _L15
    }

    public SyncHttp method(String s)
    {
        method = s;
        return this;
    }

    public String method()
    {
        return method;
    }

    protected Request newHttpUriRequest(URI uri1, RequestBody requestbody)
        throws MalformedURLException
    {
        uri1 = (new com.squareup.okhttp.Request.Builder()).url(uri1.toURL()).method(method, requestbody);
        if (isAuthorizationRequired)
        {
            uri1.header("Suppress authorization", "");
        }
        return uri1.build();
    }

    public transient SyncHttp nvps(Object aobj[])
    {
        nvps = aobj;
        return this;
    }

    public Object[] nvps()
    {
        return nvps;
    }

    protected transient Map nvpsToMap(Object aobj[])
    {
        HashMap hashmap = new HashMap();
        if (aobj != null)
        {
            if (aobj.length % 2 != 0)
            {
                throw new RuntimeException((new StringBuilder()).append("Invalid URL name/value pairs: ").append(Strings.toString(((Object) (aobj)))).toString());
            }
            for (int i = 0; i < aobj.length - 1; i += 2)
            {
                hashmap.put(Strings.toString(aobj[i]), Strings.toString(aobj[i + 1]));
            }

        }
        return hashmap;
    }

    public SyncHttp setAuthorizationRequired(boolean flag)
    {
        isAuthorizationRequired = flag;
        return this;
    }

    public void setHeader(Map map)
    {
        headers = Headers.of(map);
    }

    public void setObjectMapper(ObjectMapper objectmapper)
    {
        om = new ObjectMapperWrapper(objectmapper);
    }

    public SyncHttp uri(String s)
    {
        uri = s;
        parsedUri = null;
        return this;
    }

    public Object uri()
    {
        return uri;
    }
}
