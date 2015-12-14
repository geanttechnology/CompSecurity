// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.SharedPreferences;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.VolleyError;

public class MoPubConversionTracker
{

    private Context mContext;
    private String mIsTrackedKey;
    private String mPackageName;
    private SharedPreferences mSharedPreferences;

    public MoPubConversionTracker()
    {
    }

    private boolean isAlreadyTracked()
    {
        return mSharedPreferences.getBoolean(mIsTrackedKey, false);
    }

    public void reportAppOpen(Context context)
    {
        if (context == null)
        {
            return;
        }
        mContext = context;
        mPackageName = mContext.getPackageName();
        mIsTrackedKey = (new StringBuilder()).append(mPackageName).append(" tracked").toString();
        mSharedPreferences = SharedPreferencesHelper.getSharedPreferences(mContext);
        if (!isAlreadyTracked())
        {
            TrackingRequest.makeTrackingHttpRequest((new ConversionUrlGenerator()).generateUrlString("ads.mopub.com"), mContext, new com.mopub.network.TrackingRequest.Listener() {

                final MoPubConversionTracker this$0;

                public void onErrorResponse(VolleyError volleyerror)
                {
                }

                public void onResponse(String s)
                {
                    mSharedPreferences.edit().putBoolean(mIsTrackedKey, true).commit();
                }

            
            {
                this$0 = MoPubConversionTracker.this;
                super();
            }
            });
            return;
        } else
        {
            MoPubLog.d("Conversion already tracked");
            return;
        }
    }





    private class ConversionUrlGenerator extends BaseUrlGenerator
    {

        final MoPubConversionTracker this$0;

        private void setPackageId(String s)
        {
            addParam("id", s);
        }

        public String generateUrlString(String s)
        {
            initUrlString(s, "/m/open");
            setApiVersion("6");
            setPackageId(mPackageName);
            setAppVersion(ClientMetadata.getInstance(mContext).getAppVersion());
            appendAdvertisingInfoTemplates();
            return getFinalUrlString();
        }

        private ConversionUrlGenerator()
        {
            this$0 = MoPubConversionTracker.this;
            super();
        }

    }

}
