// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            EventAnalyticsService, BitstripsAnalyticsWebService, Category, Action

public class BitstripsAnalyticsService
    implements EventAnalyticsService
{

    private static final String TAG = com/bitstrips/imoji/analytics/BitstripsAnalyticsService.getSimpleName();
    BitstripsAnalyticsWebService bitstripsAnalyticsWebService;
    Context context;
    PreferenceUtils preferenceUtils;

    public BitstripsAnalyticsService()
    {
    }

    private int getAppId()
    {
        return context.getResources().getInteger(0x7f0c0003);
    }

    private String getAvatarId()
    {
        String s;
label0:
        {
            String s1 = preferenceUtils.getString(0x7f06002a, null);
            if (s1 != null)
            {
                s = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s = "0";
        }
        return s;
    }

    private Callback getDoNothingCallback()
    {
        return new Callback() {

            final BitstripsAnalyticsService this$0;

            public void failure(RetrofitError retrofiterror)
            {
                Log.d(BitstripsAnalyticsService.TAG, (new StringBuilder()).append("problem!").append(retrofiterror).toString());
            }

            public volatile void success(Object obj, Response response)
            {
                success((Void)obj, response);
            }

            public void success(Void void1, Response response)
            {
                Log.d(BitstripsAnalyticsService.TAG, (new StringBuilder()).append("success!").append(String.valueOf(response.getStatus())).toString());
            }

            
            {
                this$0 = BitstripsAnalyticsService.this;
                super();
            }
        };
    }

    public void sendEvent(Category category, Action action, String s)
    {
        bitstripsAnalyticsWebService.notify(getAppId(), category, action, getAvatarId(), s, getDoNothingCallback());
    }

    public void sendEvent(Category category, Action action, String s, long l)
    {
        bitstripsAnalyticsWebService.notify(getAppId(), category, action, getAvatarId(), s, l, getDoNothingCallback());
    }


}
