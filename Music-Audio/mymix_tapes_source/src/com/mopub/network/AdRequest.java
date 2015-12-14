// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.Preconditions;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mopub.network:
//            AdResponse, HeaderUtils, MoPubNetworkError

public class AdRequest extends Request
{
    public static interface Listener
        extends com.mopub.volley.Response.ErrorListener
    {

        public abstract void onSuccess(AdResponse adresponse);
    }


    private final AdFormat mAdFormat;
    private final String mAdUnitId;
    private final Context mContext;
    private final Listener mListener;

    public AdRequest(String s, AdFormat adformat, String s1, Context context, Listener listener)
    {
        super(0, s, listener);
        Preconditions.checkNotNull(adformat);
        Preconditions.checkNotNull(listener);
        mAdUnitId = s1;
        mListener = listener;
        mAdFormat = adformat;
        mContext = context.getApplicationContext();
        setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
        setShouldCache(false);
    }

    private boolean eventDataIsInResponseBody(String s, String s1)
    {
        return "mraid".equals(s) || "html".equals(s) || "interstitial".equals(s) && "vast".equals(s1);
    }

    protected void deliverResponse(AdResponse adresponse)
    {
        mListener.onSuccess(adresponse);
    }

    protected volatile void deliverResponse(Object obj)
    {
        deliverResponse((AdResponse)obj);
    }

    public Map getHeaders()
    {
        TreeMap treemap = new TreeMap();
        String s1 = Locale.getDefault().getLanguage();
        Locale locale = mContext.getResources().getConfiguration().locale;
        String s = s1;
        if (locale != null)
        {
            s = s1;
            if (!locale.getLanguage().trim().isEmpty())
            {
                s = locale.getLanguage().trim();
            }
        }
        if (!s.isEmpty())
        {
            treemap.put(ResponseHeader.ACCEPT_LANGUAGE.getKey(), s);
        }
        return treemap;
    }

    public Listener getListener()
    {
        return mListener;
    }

    String getRequestId(String s)
    {
        if (s == null)
        {
            return null;
        }
        s = Uri.parse(s);
        try
        {
            s = s.getQueryParameter("request_id");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MoPubLog.d("Unable to obtain request id from fail url.");
            return null;
        }
        return s;
    }

    void logScribeEvent(AdResponse adresponse, NetworkResponse networkresponse, Location location)
    {
        Object obj = null;
        Preconditions.checkNotNull(adresponse);
        Preconditions.checkNotNull(networkresponse);
        com.mopub.common.event.BaseEvent.Builder builder = (new com.mopub.common.event.Event.Builder(com.mopub.common.event.BaseEvent.Name.AD_REQUEST, com.mopub.common.event.BaseEvent.Category.REQUESTS, com.mopub.common.event.BaseEvent.SamplingRate.AD_REQUEST.getSamplingRate())).withAdUnitId(mAdUnitId).withAdCreativeId(adresponse.getDspCreativeId()).withAdType(adresponse.getAdType()).withAdNetworkType(adresponse.getNetworkType());
        Double double1;
        if (adresponse.getWidth() != null)
        {
            double1 = Double.valueOf(adresponse.getWidth().doubleValue());
        } else
        {
            double1 = null;
        }
        builder = builder.withAdWidthPx(double1);
        if (adresponse.getHeight() != null)
        {
            double1 = Double.valueOf(adresponse.getHeight().doubleValue());
        } else
        {
            double1 = null;
        }
        builder = builder.withAdHeightPx(double1);
        if (location != null)
        {
            double1 = Double.valueOf(location.getLatitude());
        } else
        {
            double1 = null;
        }
        builder = builder.withGeoLat(double1);
        if (location != null)
        {
            double1 = Double.valueOf(location.getLongitude());
        } else
        {
            double1 = null;
        }
        builder = builder.withGeoLon(double1);
        double1 = obj;
        if (location != null)
        {
            double1 = Double.valueOf(location.getAccuracy());
        }
        MoPubEvents.log(builder.withGeoAccuracy(double1).withPerformanceDurationMs(Double.valueOf(networkresponse.networkTimeMs)).withRequestId(adresponse.getRequestId()).withRequestStatusCode(Integer.valueOf(networkresponse.statusCode)).withRequestUri(getUrl()).build());
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        Object obj2 = networkresponse.headers;
        if (HeaderUtils.extractBooleanHeader(((Map) (obj2)), ResponseHeader.WARMUP, false))
        {
            return Response.error(new MoPubNetworkError("Ad Unit is warming up.", MoPubNetworkError.Reason.WARMING_UP));
        }
        Location location = LocationService.getLastKnownLocation(mContext, MoPub.getLocationPrecision(), MoPub.getLocationAwareness());
        AdResponse.Builder builder = new AdResponse.Builder();
        builder.setAdUnitId(mAdUnitId);
        String s1 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.AD_TYPE);
        String s2 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.FULL_AD_TYPE);
        builder.setAdType(s1);
        builder.setFullAdType(s2);
        Object obj = HeaderUtils.extractIntegerHeader(((Map) (obj2)), ResponseHeader.REFRESH_TIME);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(((Integer) (obj)).intValue() * 1000);
        }
        builder.setRefreshTimeMilliseconds(((Integer) (obj)));
        if ("clear".equals(s1))
        {
            logScribeEvent(builder.build(), networkresponse, location);
            return Response.error(new MoPubNetworkError("No ads found for ad unit.", MoPubNetworkError.Reason.NO_FILL, ((Integer) (obj))));
        }
        String s3 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.NETWORK_TYPE);
        builder.setNetworkType(s3);
        String s4 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.REDIRECT_URL);
        builder.setRedirectUrl(s4);
        String s5 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.CLICK_TRACKING_URL);
        builder.setClickTrackingUrl(s5);
        builder.setImpressionTrackingUrl(HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.IMPRESSION_URL));
        obj = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.FAIL_URL);
        builder.setFailoverUrl(((String) (obj)));
        String s = getRequestId(((String) (obj)));
        builder.setRequestId(s);
        boolean flag = HeaderUtils.extractBooleanHeader(((Map) (obj2)), ResponseHeader.SCROLLABLE, false);
        builder.setScrollable(Boolean.valueOf(flag));
        Integer integer = HeaderUtils.extractIntegerHeader(((Map) (obj2)), ResponseHeader.WIDTH);
        Integer integer1 = HeaderUtils.extractIntegerHeader(((Map) (obj2)), ResponseHeader.HEIGHT);
        builder.setDimensions(integer, integer1);
        obj = HeaderUtils.extractIntegerHeader(((Map) (obj2)), ResponseHeader.AD_TIMEOUT);
        Object obj1;
        String s6;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = Integer.valueOf(((Integer) (obj)).intValue() * 1000);
        }
        builder.setAdTimeoutDelayMilliseconds(((Integer) (obj)));
        s6 = parseStringBody(networkresponse);
        builder.setResponseBody(s6);
        if ("json".equals(s1) || "json_video".equals(s1))
        {
            try
            {
                builder.setJsonBody(new JSONObject(s6));
            }
            // Misplaced declaration of an exception variable
            catch (NetworkResponse networkresponse)
            {
                return Response.error(new MoPubNetworkError("Failed to decode body JSON for native ad format", networkresponse, MoPubNetworkError.Reason.BAD_BODY));
            }
        }
        builder.setCustomEventClassName(AdTypeTranslator.getCustomEventName(mAdFormat, s1, s2, ((Map) (obj2))));
        obj1 = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.CUSTOM_EVENT_DATA);
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.NATIVE_PARAMS);
        }
        try
        {
            obj1 = Json.jsonStringToMap(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (NetworkResponse networkresponse)
        {
            return Response.error(new MoPubNetworkError("Failed to decode server extras for custom event data.", networkresponse, MoPubNetworkError.Reason.BAD_HEADER_DATA));
        }
        if (s4 != null)
        {
            ((Map) (obj1)).put("Redirect-Url", s4);
        }
        if (s5 != null)
        {
            ((Map) (obj1)).put("Clickthrough-Url", s5);
        }
        if (eventDataIsInResponseBody(s1, s2))
        {
            ((Map) (obj1)).put("Html-Response-Body", s6);
            ((Map) (obj1)).put("Scrollable", Boolean.toString(flag));
            ((Map) (obj1)).put("com_mopub_orientation", HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.ORIENTATION));
        }
        if ("json_video".equals(s1))
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                return Response.error(new MoPubNetworkError("Native Video ads are only supported for Android API Level 16 (JellyBean) and above.", MoPubNetworkError.Reason.UNSPECIFIED));
            }
            ((Map) (obj1)).put("Play-Visible-Percent", HeaderUtils.extractPercentHeaderString(((Map) (obj2)), ResponseHeader.PLAY_VISIBLE_PERCENT));
            ((Map) (obj1)).put("Pause-Visible-Percent", HeaderUtils.extractPercentHeaderString(((Map) (obj2)), ResponseHeader.PAUSE_VISIBLE_PERCENT));
            ((Map) (obj1)).put("Impression-Min-Visible-Percent", HeaderUtils.extractPercentHeaderString(((Map) (obj2)), ResponseHeader.IMPRESSION_MIN_VISIBLE_PERCENT));
            ((Map) (obj1)).put("Impression-Visible-Ms", HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.IMPRESSION_VISIBLE_MS));
            ((Map) (obj1)).put("Max-Buffer-Ms", HeaderUtils.extractHeader(((Map) (obj2)), ResponseHeader.MAX_BUFFER_MS));
            obj2 = (new com.mopub.common.event.EventDetails.Builder()).adUnitId(mAdUnitId).adType(s1).adNetworkType(s3).adWidthPx(integer).adHeightPx(integer1);
            if (location == null)
            {
                obj = null;
            } else
            {
                obj = Double.valueOf(location.getLatitude());
            }
            obj2 = ((com.mopub.common.event.EventDetails.Builder) (obj2)).geoLatitude(((Double) (obj)));
            if (location == null)
            {
                obj = null;
            } else
            {
                obj = Double.valueOf(location.getLongitude());
            }
            obj2 = ((com.mopub.common.event.EventDetails.Builder) (obj2)).geoLongitude(((Double) (obj)));
            if (location == null)
            {
                obj = null;
            } else
            {
                obj = Float.valueOf(location.getAccuracy());
            }
            builder.setEventDetails(((com.mopub.common.event.EventDetails.Builder) (obj2)).geoAccuracy(((Float) (obj))).performanceDurationMs(Long.valueOf(networkresponse.networkTimeMs)).requestId(s).requestStatusCode(Integer.valueOf(networkresponse.statusCode)).requestUri(getUrl()).build());
        }
        builder.setServerExtras(((Map) (obj1)));
        logScribeEvent(builder.build(), networkresponse, location);
        return Response.success(builder.build(), HttpHeaderParser.parseCacheHeaders(networkresponse));
    }

    protected String parseStringBody(NetworkResponse networkresponse)
    {
        String s;
        try
        {
            s = new String(networkresponse.data, HttpHeaderParser.parseCharset(networkresponse.headers));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return new String(networkresponse.data);
        }
        return s;
    }
}
