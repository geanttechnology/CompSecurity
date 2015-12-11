// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.currency;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.currency:
//            SPCurrencyServerSuccesfulResponse, SPCurrencyServerErrorResponse, SPCurrencyServerRequestErrorType, SPCurrencyServerListener, 
//            SPCurrencyServerRequester

public class SPVirtualCurrencyConnector
    implements SPCurrencyServerRequester.SPVCSResultListener
{

    public static final String CURRENT_API_LEVEL_NOT_SUPPORTED_ERROR = "Only devices running Android API level 10 and above are supported";
    private static final String STATE_LATEST_TRANSACTION_ID_KEY_PREFIX = "STATE_LATEST_CURRENCY_TRANSACTION_ID_";
    private static final String STATE_LATEST_TRANSACTION_ID_KEY_SEPARATOR = "_";
    private static final String TAG = "SPVirtualCurrencyConnector";
    private static final String URL_PARAM_VALUE_NO_TRANSACTION = "NO_TRANSACTION";
    private static final int VCS_TIMER = 15;
    private static HashMap cacheInfo = new HashMap();
    private static boolean showToastNotification = true;
    protected Context mContext;
    protected SPCredentials mCredentials;
    private String mCurrency;
    protected SPCurrencyServerListener mCurrencyServerListener;
    protected Map mCustomParameters;
    private boolean mShouldShowNotification;

    public SPVirtualCurrencyConnector(Context context, String s, SPCurrencyServerListener spcurrencyserverlistener)
    {
        mCredentials = SponsorPay.getCredentials(s);
        if (StringUtils.nullOrEmpty(mCredentials.getSecurityToken()))
        {
            throw new IllegalArgumentException("Security token has not been set on the credentials");
        } else
        {
            mContext = context;
            mCurrencyServerListener = spcurrencyserverlistener;
            return;
        }
    }

    public static String fetchLatestTransactionId(Context context, String s)
    {
        s = SponsorPay.getCredentials(s);
        return context.getSharedPreferences("SponsorPayPublisherState", 0).getString(generatePreferencesLatestTransactionIdKey(s), "NO_TRANSACTION");
    }

    private String fetchLatestTransactionIdForCurrentAppAndUser()
    {
        return fetchLatestTransactionId(mContext, mCredentials.getCredentialsToken());
    }

    private static String generatePreferencesLatestTransactionIdKey(SPCredentials spcredentials)
    {
        return (new StringBuilder("STATE_LATEST_CURRENCY_TRANSACTION_ID_")).append(spcredentials.getAppId()).append("_").append(spcredentials.getUserId()).toString();
    }

    private Calendar getCachedCalendar(Calendar calendar)
    {
        CacheInfo cacheinfo1 = (CacheInfo)cacheInfo.get(mCredentials.getCredentialsToken());
        CacheInfo cacheinfo = cacheinfo1;
        if (cacheinfo1 == null)
        {
            cacheinfo = new CacheInfo(null);
            cacheinfo.calendar = calendar;
            cacheInfo.put(mCredentials.getCredentialsToken(), cacheinfo);
        }
        return cacheinfo.calendar;
    }

    private SPCurrencyServerRequester.SPCurrencyServerReponse getCachedResponse()
    {
        CacheInfo cacheinfo1 = (CacheInfo)cacheInfo.get(mCredentials.getCredentialsToken());
        CacheInfo cacheinfo = cacheinfo1;
        if (cacheinfo1 == null)
        {
            cacheinfo = new CacheInfo(null);
            cacheinfo.calendar = Calendar.getInstance();
            cacheInfo.put(mCredentials.getCredentialsToken(), cacheinfo);
        }
        return cacheinfo.response;
    }

    private void onDeltaOfCoinsResponse(SPCurrencyServerSuccesfulResponse spcurrencyserversuccesfulresponse)
    {
        saveLatestTransactionIdForCurrentUser(spcurrencyserversuccesfulresponse.getLatestTransactionId());
        if (spcurrencyserversuccesfulresponse.getDeltaOfCoins() > 0.0D && mShouldShowNotification)
        {
            String s = SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.VCS_COINS_NOTIFICATION);
            double d = spcurrencyserversuccesfulresponse.getDeltaOfCoins();
            if (StringUtils.notNullNorEmpty(mCurrency))
            {
                spcurrencyserversuccesfulresponse = mCurrency;
            } else
            {
                spcurrencyserversuccesfulresponse = SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.VCS_DEFAULT_CURRENCY);
            }
            spcurrencyserversuccesfulresponse = String.format(s, new Object[] {
                Double.valueOf(d), spcurrencyserversuccesfulresponse
            });
            Toast.makeText(mContext, spcurrencyserversuccesfulresponse, 1).show();
        }
    }

    private void saveLatestTransactionIdForCurrentUser(String s)
    {
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("SponsorPayPublisherState", 0).edit();
        editor.putString(generatePreferencesLatestTransactionIdKey(mCredentials), s);
        editor.commit();
    }

    private void setCachedResponse(SPCurrencyServerRequester.SPCurrencyServerReponse spcurrencyserverreponse)
    {
        CacheInfo cacheinfo1 = (CacheInfo)cacheInfo.get(mCredentials.getCredentialsToken());
        CacheInfo cacheinfo = cacheinfo1;
        if (cacheinfo1 == null)
        {
            cacheinfo = new CacheInfo(null);
            cacheInfo.put(mCredentials.getCredentialsToken(), cacheinfo);
        }
        cacheinfo.response = spcurrencyserverreponse;
    }

    private void setTimerCalendar(Calendar calendar)
    {
        CacheInfo cacheinfo1 = (CacheInfo)cacheInfo.get(mCredentials.getCredentialsToken());
        CacheInfo cacheinfo = cacheinfo1;
        if (cacheinfo1 == null)
        {
            cacheinfo = new CacheInfo(null);
            cacheInfo.put(mCredentials.getCredentialsToken(), cacheinfo);
        }
        cacheinfo.calendar = calendar;
    }

    public static void shouldShowToastNotification(boolean flag)
    {
        showToastNotification = flag;
    }

    public void fetchDeltaOfCoins()
    {
        fetchDeltaOfCoinsForCurrentUserSinceTransactionId(null);
    }

    public void fetchDeltaOfCoinsForCurrentUserSinceTransactionId(String s)
    {
        if (!HostInfo.isDeviceSupported())
        {
            s = new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_OTHER, "", "Only devices running Android API level 10 and above are supported");
            mCurrencyServerListener.onSPCurrencyServerError(s);
            return;
        }
        Object obj = Calendar.getInstance();
        if (((Calendar) (obj)).before(getCachedCalendar(((Calendar) (obj)))))
        {
            SponsorPayLogger.d("SPVirtualCurrencyConnector", "The VCS was queried less than 15s ago.Replying with cached response");
            s = getCachedResponse();
            if (s != null)
            {
                onSPCurrencyServerResponseReceived(s);
                return;
            } else
            {
                mCurrencyServerListener.onSPCurrencyServerError(new SPCurrencyServerErrorResponse(SPCurrencyServerRequestErrorType.ERROR_OTHER, "", "Unknown error"));
                return;
            }
        }
        ((Calendar) (obj)).add(13, 15);
        setTimerCalendar(((Calendar) (obj)));
        obj = s;
        if (StringUtils.nullOrEmpty(s))
        {
            obj = fetchLatestTransactionIdForCurrentAppAndUser();
        }
        mShouldShowNotification = showToastNotification;
        SPCurrencyServerRequester.requestCurrency(this, mCredentials, ((String) (obj)), mCustomParameters);
    }

    public void onSPCurrencyServerResponseReceived(SPCurrencyServerRequester.SPCurrencyServerReponse spcurrencyserverreponse)
    {
        if (spcurrencyserverreponse instanceof SPCurrencyServerSuccesfulResponse)
        {
            setCachedResponse(new SPCurrencyServerSuccesfulResponse(0.0D, ((SPCurrencyServerSuccesfulResponse)spcurrencyserverreponse).getLatestTransactionId()));
            onDeltaOfCoinsResponse((SPCurrencyServerSuccesfulResponse)spcurrencyserverreponse);
            mCurrencyServerListener.onSPCurrencyDeltaReceived((SPCurrencyServerSuccesfulResponse)spcurrencyserverreponse);
            return;
        } else
        {
            setCachedResponse(spcurrencyserverreponse);
            mCurrencyServerListener.onSPCurrencyServerError((SPCurrencyServerErrorResponse)spcurrencyserverreponse);
            return;
        }
    }

    public SPVirtualCurrencyConnector setCurrency(String s)
    {
        mCurrency = s;
        return this;
    }

    public SPVirtualCurrencyConnector setCustomParameters(Map map)
    {
        mCustomParameters = map;
        return this;
    }


    private class CacheInfo
    {

        private Calendar calendar;
        private SPCurrencyServerRequester.SPCurrencyServerReponse response;
        final SPVirtualCurrencyConnector this$0;





        private CacheInfo()
        {
            this$0 = SPVirtualCurrencyConnector.this;
            super();
        }

        CacheInfo(CacheInfo cacheinfo)
        {
            this();
        }
    }

}
