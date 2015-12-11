// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.request;

import android.location.Location;
import android.net.Uri;
import android.util.Log;
import com.amazon.bluefront.api.common.Arrf;
import com.amazon.bluefront.api.common.Customer;
import com.amazon.bluefront.api.common.Device;
import com.amazon.bluefront.api.common.TranslateToObfuscatedCustomerIdFrom;
import com.amazon.bluefront.api.v2.DataMartStorageId;
import com.amazon.bluefront.api.v2.IntentParameters;
import com.amazon.bluefront.api.v2.RecognitionParameters;
import com.amazon.bluefront.api.v2.ServiceParameters;
import com.amazon.bluefront.api.v2.SpeechToDataMartInputParameters;
import com.amazon.bluefront.api.v2.SpeechToIntentInputParameters;
import com.amazon.bluefront.api.v2.SpeechToTextInputParameters;
import com.amazon.blueshift.bluefront.android.common.AndroidDevice;
import com.amazon.blueshift.bluefront.android.common.BluefrontCustomer;
import com.amazon.blueshift.bluefront.android.common.DeviceUtils;
import com.amazon.blueshift.bluefront.android.common.RequestTimeouts;
import com.amazon.dee.result.bif.BIF;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.blueshift.bluefront.android.request:
//            SpeechRequest

public final class SpeechRequestBuilder
{
    private static abstract class SpeechRequestBuilderBase
    {

        private BluefrontCustomer mCustomer;
        private AndroidDevice mDevice;
        private Locale mLocale;
        private final Map mMetadata;
        private String mProfile;
        private String mRequestId;
        private RequestTimeouts mTimeouts;
        private final android.net.Uri.Builder mUriBuilder;

        private void addClientMetadata()
        {
            if (mDevice != null)
            {
                mMetadata.put("appVersion", mDevice.getAppVersion());
                mMetadata.put("deviceBrand", mDevice.getBrand());
                mMetadata.put("deviceManufacturer", mDevice.getManufacturer());
                mMetadata.put("deviceSerialNumber", mDevice.getSerialNumber());
                mMetadata.put("deviceModel", mDevice.getModel());
                mMetadata.put("carrier", mDevice.getCarrier());
                mMetadata.put("networkType", DeviceUtils.convertNetworkTypeNumberToName(mDevice.getConnectedNetworkType()));
                if (mDevice.getLocation() != null)
                {
                    mMetadata.put("latitude", String.format("%.1f", new Object[] {
                        Double.valueOf(mDevice.getLocation().getLatitude())
                    }));
                    mMetadata.put("longitude", String.format("%.1f", new Object[] {
                        Double.valueOf(mDevice.getLocation().getLongitude())
                    }));
                } else
                {
                    Log.v(SpeechRequestBuilder.TAG, "Device location is null.");
                }
            } else
            {
                Log.v(SpeechRequestBuilder.TAG, "Device was not set.");
            }
            if (mLocale != null)
            {
                mMetadata.put("language", mLocale.getLanguage());
                mMetadata.put("locale", getLocaleString());
            } else
            {
                Log.v(SpeechRequestBuilder.TAG, "Locale was not set.");
            }
            mMetadata.put("audioRoute", "Android Recognition Default");
            mMetadata.put("os", "Android");
            mMetadata.put("osVersion", android.os.Build.VERSION.RELEASE);
            mMetadata.put("platform", "Android");
            mMetadata.put("requestId", mRequestId);
        }

        protected ServiceParameters buildBaseParameters()
        {
            ServiceParameters serviceparameters;
            addClientMetadata();
            serviceparameters = new ServiceParameters();
            if (mRequestId != null)
            {
                serviceparameters.setRequestId(mRequestId);
            }
            if (mDevice != null)
            {
                Device device1 = new Device();
                device1.setDeviceSerialNumber(mDevice.getId());
                serviceparameters.setDevice(device1);
            }
            if (mCustomer != null)
            {
                Customer customer1 = new Customer();
                customer1.setIdentifier(mCustomer.getCustomerId());
                customer1.setTranslateToObfuscatedCustomerIdFrom(mCustomer.getIdentifierType().toSerializedForm());
                serviceparameters.setCustomer(customer1);
            }
            HashMap hashmap;
            Iterator iterator;
            if (mMetadata.isEmpty())
            {
                break MISSING_BLOCK_LABEL_241;
            }
            hashmap = new HashMap();
            iterator = mMetadata.entrySet().iterator();
_L2:
            Object obj;
            java.util.Map.Entry entry;
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_236;
            }
            entry = (java.util.Map.Entry)iterator.next();
            obj = entry.getValue();
            if (!(obj instanceof String))
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (String)obj;
_L3:
            hashmap.put(entry.getKey(), obj);
            if (true) goto _L2; else goto _L1
_L1:
            try
            {
                obj = SpeechRequestBuilder.MAPPER.writeValueAsString(entry.getValue());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e(SpeechRequestBuilder.TAG, "Failed to serialize request parameters!");
                throw new RuntimeException(((Throwable) (obj)));
            }
              goto _L3
            if (true) goto _L2; else goto _L4
_L4:
            serviceparameters.setMetadata(hashmap);
            return serviceparameters;
        }

        public SpeechRequestBuilderBase customer(String s, TranslateToObfuscatedCustomerIdFrom translatetoobfuscatedcustomeridfrom)
        {
            mCustomer = new BluefrontCustomer(s, translatetoobfuscatedcustomeridfrom);
            return this;
        }

        public SpeechRequestBuilderBase device(AndroidDevice androiddevice)
        {
            mDevice = androiddevice;
            return this;
        }

        Uri getCompleteUri(String s)
        {
            mUriBuilder.appendEncodedPath(s);
            return mUriBuilder.build();
        }

        public final BluefrontCustomer getCustomer()
        {
            return mCustomer;
        }

        public final AndroidDevice getDevice()
        {
            return mDevice;
        }

        public final Uri getHostname()
        {
            return mUriBuilder.build();
        }

        public final Locale getLocale()
        {
            return mLocale;
        }

        String getLocaleString()
        {
            if (mLocale != null)
            {
                return (new StringBuilder(mLocale.getLanguage())).append('_').append(mLocale.getCountry()).toString();
            } else
            {
                return null;
            }
        }

        public final Map getMetadata()
        {
            return mMetadata;
        }

        public final String getProfile()
        {
            return mProfile;
        }

        public final String getRequestId()
        {
            return mRequestId;
        }

        public final RequestTimeouts getTimeouts()
        {
            return mTimeouts;
        }

        public SpeechRequestBuilderBase hostname(String s)
        {
            mUriBuilder.encodedAuthority(s);
            return this;
        }

        public SpeechRequestBuilderBase locale(Locale locale1)
        {
            Preconditions.checkNotNull(locale1, "Locale cannot be null");
            mLocale = locale1;
            mUriBuilder.appendQueryParameter("locale", getLocaleString());
            return this;
        }

        public SpeechRequestBuilderBase metadata(String s, Object obj)
        {
            mMetadata.put(s, obj);
            return this;
        }

        public SpeechRequestBuilderBase metadataMap(Map map)
        {
            Preconditions.checkNotNull(map, "Metadata cannot be null");
            mMetadata.putAll(map);
            return this;
        }

        public SpeechRequestBuilderBase profile(String s)
        {
            Preconditions.checkNotNull(s, "Profile cannot be null");
            mProfile = s;
            mUriBuilder.appendQueryParameter("profile", mProfile);
            return this;
        }

        public SpeechRequestBuilderBase requestId(String s)
        {
            mRequestId = s;
            return this;
        }

        public SpeechRequestBuilderBase timeouts(RequestTimeouts requesttimeouts)
        {
            mTimeouts = requesttimeouts;
            return this;
        }

        private SpeechRequestBuilderBase()
        {
            mUriBuilder = (new android.net.Uri.Builder()).scheme("https").encodedAuthority("blue-ash.amazon.com");
            mTimeouts = new RequestTimeouts();
            mProfile = null;
            mLocale = null;
            mRequestId = null;
            mDevice = null;
            mCustomer = null;
            mMetadata = new HashMap();
        }

    }

    public static class SpeechToIntentRequestBuilder extends SpeechRequestBuilderBase
    {

        private static final String PATH = "speech/interpreter/v2";
        private int mMaxResultCount;

        public SpeechRequest build()
        {
            Object obj = buildBaseParameters();
            IntentParameters intentparameters = new IntentParameters();
            intentparameters.setMaxNBest(mMaxResultCount);
            SpeechToIntentInputParameters speechtointentinputparameters = new SpeechToIntentInputParameters();
            speechtointentinputparameters.setServiceParams(((ServiceParameters) (obj)));
            speechtointentinputparameters.setIntentParams(intentparameters);
            try
            {
                obj = new SpeechRequest(SpeechRequestBuilder.MAPPER.writeValueAsString(speechtointentinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/interpreter/v2"), getTimeouts(), com/amazon/dee/result/bif/BIF);
            }
            catch (JsonProcessingException jsonprocessingexception)
            {
                throw new RuntimeException("Error building request json", jsonprocessingexception);
            }
            return ((SpeechRequest) (obj));
        }

        public SpeechToIntentRequestBuilder maxResultCount(int i)
        {
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Max result count must be greater than 0");
            mMaxResultCount = i;
            return this;
        }

        public SpeechToIntentRequestBuilder()
        {
            mMaxResultCount = 1;
        }
    }

    public static class SpeechToStorageIdRequestBuilder extends SpeechRequestBuilderBase
    {

        private static final String PATH = "speech/recorder/v2";

        public SpeechRequest build()
        {
            Object obj = buildBaseParameters();
            SpeechToDataMartInputParameters speechtodatamartinputparameters = new SpeechToDataMartInputParameters();
            speechtodatamartinputparameters.setServiceParams(((ServiceParameters) (obj)));
            try
            {
                obj = new SpeechRequest(SpeechRequestBuilder.MAPPER.writeValueAsString(speechtodatamartinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/recorder/v2"), getTimeouts(), com/amazon/bluefront/api/v2/DataMartStorageId);
            }
            catch (JsonProcessingException jsonprocessingexception)
            {
                throw new RuntimeException("Error building request json", jsonprocessingexception);
            }
            return ((SpeechRequest) (obj));
        }

        public SpeechToStorageIdRequestBuilder()
        {
        }
    }

    public static class SpeechToTextRequestBuilder extends SpeechRequestBuilderBase
    {

        private static final String PATH = "speech/recognizer/v2";
        private int mMaxResultCount;
        private String mRecognitionOutputType;

        private SpeechRequest build(Class class1)
        {
            if (class1.equals(com/amazon/bluefront/api/common/Arrf))
            {
                mRecognitionOutputType = "ARRF";
                ServiceParameters serviceparameters = buildBaseParameters();
                RecognitionParameters recognitionparameters = new RecognitionParameters();
                recognitionparameters.setMaxNBest(mMaxResultCount);
                recognitionparameters.setOutputFormat(mRecognitionOutputType);
                SpeechToTextInputParameters speechtotextinputparameters = new SpeechToTextInputParameters();
                speechtotextinputparameters.setServiceParams(serviceparameters);
                speechtotextinputparameters.setRecognitionParams(recognitionparameters);
                try
                {
                    class1 = new SpeechRequest(SpeechRequestBuilder.MAPPER.writeValueAsString(speechtotextinputparameters), getLocaleString(), getProfile(), getCompleteUri("speech/recognizer/v2"), getTimeouts(), class1);
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RuntimeException("Error building request json", class1);
                }
                return class1;
            } else
            {
                throw new IllegalArgumentException("SpeechToText only supports ARRF");
            }
        }

        public SpeechRequest build()
        {
            return build(com/amazon/bluefront/api/common/Arrf);
        }

        public SpeechToTextRequestBuilder maxResultCount(int i)
        {
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Max result count must be greater than 0");
            mMaxResultCount = i;
            return this;
        }

        public SpeechToTextRequestBuilder()
        {
            mMaxResultCount = 1;
        }
    }


    private static final String ANDROID = "Android";
    private static final String APP_VERSION = "appVersion";
    private static final String AUDIO_ROUTE = "audioRoute";
    private static final String CARRIER = "carrier";
    private static final String DEVICE_BRAND = "deviceBrand";
    private static final String DEVICE_MANUFACTURER = "deviceManufacturer";
    private static final String DEVICE_MODEL = "deviceModel";
    private static final String DEVICE_SERIAL_NUMBER = "deviceSerialNumber";
    private static final String LANGUAGE = "language";
    private static final String LATITUDE = "latitude";
    private static final String LOCALE = "locale";
    private static final String LOCALE_KEY = "locale";
    private static final String LONGTITUDE = "longitude";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String NETWORK_TYPE = "networkType";
    private static final String OS = "os";
    private static final String OS_VERSION = "osVersion";
    private static final String PLATFORM = "platform";
    private static final String PROFILE_KEY = "profile";
    private static final String REQUEST_ID = "requestId";
    private static final String TAG = com/amazon/blueshift/bluefront/android/request/SpeechRequestBuilder.getCanonicalName();

    private SpeechRequestBuilder()
    {
    }



}
