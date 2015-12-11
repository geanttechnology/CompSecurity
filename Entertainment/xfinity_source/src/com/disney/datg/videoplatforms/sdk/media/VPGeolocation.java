// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.models.api.User;
import com.disney.datg.videoplatforms.sdk.service.GeoAccessor;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            Configuration

public class VPGeolocation
{
    protected static interface VPLocationRequestListener
    {

        public abstract void onLocationRequest();
    }


    private static VPGeolocation geoLocationManager;
    private String _tempLatitude;
    private String _tempLongitude;
    private String _tempZipcode;
    private Configuration configuration;
    private GeoLocation currentGeolocation;
    private Date expires;
    private VPLocationRequestListener onLocationRequestListener;
    private CountDownLatch signal;

    public VPGeolocation()
    {
        _tempLatitude = "";
        _tempLongitude = "";
        _tempZipcode = "";
    }

    public static VPGeolocation getGeolocationManager()
    {
        if (geoLocationManager == null)
        {
            geoLocationManager = new VPGeolocation();
        }
        return geoLocationManager;
    }

    private void setCurrentGeolocation(GeoLocation geolocation)
    {
        currentGeolocation = geolocation;
    }

    protected GeoLocation doLBS(Context context)
    {
        signal = new CountDownLatch(1);
        if (onLocationRequestListener != null)
        {
            onLocationRequestListener.onLocationRequest();
            GeoLocation geolocation;
            try
            {
                if (!signal.await(Configuration.LBS_REQUEST_TIMEOUT, TimeUnit.SECONDS) && TextUtils.isEmpty(_tempZipcode))
                {
                    _tempZipcode = getPostalCode(context, _tempLatitude, _tempLongitude);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                LogUtils.LOGE("VPGeolocation", "lbs countdown interrupted");
            }
        }
        context = null;
        geolocation = getGeolocationManager().getCurrentGeolocation(_tempLatitude, _tempLongitude, _tempZipcode);
        context = geolocation;
_L2:
        _tempZipcode = "";
        _tempLongitude = "";
        _tempLatitude = "";
        return context;
        AndroidSDKException androidsdkexception;
        androidsdkexception;
        LogUtils.LOGE("VPGeolocation", androidsdkexception.getMessage());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public GeoLocation getCurrentGeolocation()
        throws AndroidSDKException
    {
        return getCurrentGeolocation("", "", "");
    }

    public GeoLocation getCurrentGeolocation(final String latitude, final String longitude, final String zipcode)
        throws AndroidSDKException
    {
        if (currentGeolocation != null && expires != null && (new Date()).before(expires))
        {
            return currentGeolocation;
        }
        latitude = new LinkedMultiValueMap() {

            final VPGeolocation this$0;
            final String val$latitude;
            final String val$longitude;
            final String val$zipcode;

            
            {
                this$0 = VPGeolocation.this;
                latitude = s;
                longitude = s1;
                zipcode = s2;
                super();
                add("brand", configuration.getCurrentNetwork());
                add("device", configuration.getCurrentPartnerCode());
                add("type", "gt");
                add("latitude", latitude);
                add("longitude", longitude);
                add("zipcode", zipcode);
            }
        };
        latitude = (new GeoAccessor(configuration.getCurrentConfig().getURLFromWebServiceName("geolocation"), latitude, null)).getServiceAsync();
        long l;
        try
        {
            latitude = (ResponseEntity)latitude.get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR);
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR, latitude.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_TIMEOUT, latitude.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR, latitude.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw latitude;
        }
        // Misplaced declaration of an exception variable
        catch (final String latitude)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR, latitude.getCause());
        }
        if (latitude != null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_ERROR);
        latitude = (GeoLocation)latitude.getBody();
        if (latitude == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        if (latitude.getUser() == null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        if (!latitude.getUser().getAllowed().booleanValue())
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_OUTSIDE_US);
        }
        expires = new Date();
        l = expires.getTime();
        expires.setTime(0x493e0L + l);
        setCurrentGeolocation(latitude);
        return currentGeolocation;
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_GEO_SERVICE_IO_ERROR, "geo service returned null or user returned null");
    }

    protected String getPostalCode(Context context, String s, String s1)
    {
        String s2 = "";
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            s = s2;
            if (!Geocoder.isPresent())
            {
                break MISSING_BLOCK_LABEL_111;
            }
            s = s2;
            if (context == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
        }
        context = new Geocoder(context);
        try
        {
            context = context.getFromLocation(Double.valueOf(_tempLatitude).doubleValue(), Double.valueOf(_tempLongitude).doubleValue(), 5);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.LOGE("VPGeolocation", context.getMessage());
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.LOGE("VPGeolocation", context.getMessage());
            return "";
        }
        s = s2;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = s2;
        if (context.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        context = (Address)context.get(0);
        s = s2;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = context.getPostalCode();
        return s;
    }

    protected void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
    }

}
