// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import android.location.Location;
import android.net.Uri;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.pointinside.PIMapsAccessor;
import com.pointinside.internal.ParameterCheck;
import com.pointinside.internal.utils.DevIdUtils;
import com.pointinside.internal.utils.StringUtils;
import com.pointinside.internal.utils.UserAgentUtils;
import com.pointinside.location.geofence.VenueProximityState;
import com.pointinside.net.EndpointType;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class URLBuilder
{

    private static final int CONNECT_TIMEOUT = 15000;
    public static final String KEY_API_KEY = "apiKey".intern();
    public static final String KEY_DEV_ID = "devId".intern();
    private static final int SOCKET_OPERATION_TIMEOUT = 20000;
    private static final String VERSION = "v1.4";
    public static String devId;
    protected final String KEY_ACCURACY = "accuracy".intern();
    protected final String KEY_CLOSEST_STOREID = "storeId".intern();
    protected final String KEY_CLOSEST_VENUEUUID = "closestVenue".intern();
    protected final String KEY_LAT = "lat".intern();
    protected final String KEY_LNG = "lng".intern();
    protected final String KEY_PROXIMITY = "proximity".intern();
    protected final String KEY_USER_LOC_TIME = "userLocTime".intern();
    public final EndpointType endpointType;
    protected String host;
    final String mUserAgent;
    protected final HashMap parameters = new HashMap();
    private String qualifiers;
    private final Object semaphore = new Object();
    public boolean updateCache;

    protected URLBuilder(EndpointType endpointtype, String s)
    {
        updateCache = false;
        android.content.Context context = PIMapsAccessor.getInstance().getContext();
        devId = DevIdUtils.getHashedUUID(context);
        mUserAgent = UserAgentUtils.getUserAgent(context);
        host = PIMapsAccessor.getInstance().getBaseUrl();
        ParameterCheck.throwIfNullOrEmpty("url", host);
        ParameterCheck.throwIfNullOrEmpty("devId", devId);
        if (endpointtype == null)
        {
            throw new IllegalArgumentException("EndpointType cannot be null");
        } else
        {
            endpointType = endpointtype;
            qualifiers = s;
            parameters.put(KEY_DEV_ID, devId);
            return;
        }
    }

    protected static void checkURL(String s)
        throws MalformedURLException
    {
        new URL(s);
    }

    private StringBuilder getActiveURL(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(getHost()).append("/");
        stringbuilder.append(endpointType.service).append("/");
        stringbuilder.append(getVersion());
        if (!endpointType.endpoint.isEmpty())
        {
            stringbuilder.append("/").append(endpointType.endpoint);
        }
        if (updateCache)
        {
            stringbuilder.append("/update_cache");
        }
        if (s != null)
        {
            stringbuilder.append("/").append(s);
        }
        stringbuilder.append("?");
        parameters.put(KEY_API_KEY, PIMapsAccessor.getInstance().getApiKey());
        s = parameters.entrySet();
        Iterator iterator = s.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            stringbuilder.append((String)entry.getKey()).append("=").append(Uri.encode((String)entry.getValue()));
            if (i < s.size() - 1)
            {
                stringbuilder.append("&");
            }
        }

        return stringbuilder;
    }

    protected void addProximityDataIfAvailable()
    {
    }

    protected void appendQualifiers(String s)
        throws MalformedURLException
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        if (!s.trim().equals(""))
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s = (new StringBuilder()).append(qualifiers).append(s).toString();
        checkURL(getActiveURL(s).toString());
        qualifiers = s;
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public URL build()
        throws MalformedURLException
    {
        onPrepareURL();
        return new URL(getActiveURL().toString());
    }

    protected StringBuilder getActiveURL()
    {
        StringBuilder stringbuilder;
        synchronized (semaphore)
        {
            stringbuilder = getActiveURL(qualifiers);
        }
        return stringbuilder;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected String getHost()
    {
        return PIMapsAccessor.getInstance().getBaseUrl();
    }

    public String getQualifiers()
    {
        return qualifiers;
    }

    protected String getVersion()
    {
        return "v1.4";
    }

    protected void onConfigureConnection(HttpURLConnection httpurlconnection)
    {
    }

    protected abstract void onPrepareURL();

    public HttpURLConnection openConnection()
        throws IOException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection(build().openConnection());
        httpurlconnection.setConnectTimeout(20000);
        httpurlconnection.setReadTimeout(15000);
        if (mUserAgent != null)
        {
            httpurlconnection.setRequestProperty("User-Agent", mUserAgent);
        }
        onConfigureConnection(httpurlconnection);
        return httpurlconnection;
    }

    protected void putLocationInParam(Location location)
    {
        if (location != null)
        {
            parameters.put(KEY_LAT, String.valueOf(location.getLatitude()));
            parameters.put(KEY_LNG, String.valueOf(location.getLongitude()));
            parameters.put(KEY_ACCURACY, String.valueOf(location.getAccuracy()));
            parameters.put(KEY_USER_LOC_TIME, StringUtils.getDatetimeInString(location.getTime()));
        }
    }

    protected void putProximityStateInParam(VenueProximityState venueproximitystate)
        throws IllegalArgumentException
    {
    }

    protected void reset()
    {
        synchronized (semaphore)
        {
            qualifiers = null;
            parameters.clear();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void setParameterOrClear(String s, Object obj)
    {
        ParameterCheck.throwIfNullOrEmpty("key", s);
        if (obj == null)
        {
            parameters.remove(s);
            return;
        } else
        {
            parameters.put(s, obj.toString());
            return;
        }
    }

    public String setQualifiers(String s)
    {
        synchronized (semaphore)
        {
            qualifiers = s;
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

}
