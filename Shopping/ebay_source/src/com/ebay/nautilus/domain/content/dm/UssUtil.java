// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.List;

public class UssUtil
{

    private static final String ANDROID_CORE_APP_ID = "AEAPP";
    private static final String ANDROID_MOBILE_APP_CONTEXT_ID_TYPE = "39";
    private static final String CLIENT_CHANNEL_KEY = "451";
    private static final String CONTEXT_ID_KEY = "CID";
    private static final String CORRELATION_GUID_KEY = "CORRELATION_GUID";
    private static final String MAPP_CHANNEL = "MAPP";
    private static final String MOBILE_APP_CARRIER_KEY = "425";
    private static final String MOBILE_APP_DEVICE_TYPE_KEY = "420";
    private static final String MOBILE_APP_ID_KEY = "418";
    private static final String MOBILE_APP_INSTALLED_APPS_KEY = "419";
    private static final String MOBILE_APP_NEW_UPDATE_KEY = "416";
    private static final String MOBILE_APP_NEW_USER_KEY = "415";
    private static final String MOBILE_APP_OS_VERSION_KEY = "421";
    private static final String MOBILE_APP_VERSION_KEY = "417";
    private static final String PLACEMENTS_KEY = "PLACEMENTS";
    private static final String REFERRER_NAME_KEY = "231";
    private static final String RTM2_SOURCE = "RTM2";
    private static final String RTM_SOURCE = "RTM";
    private static final String SITE_ID_KEY = "12";
    private static final String SOJOURNER_CGUID_KEY = "SOJOURNER_GUID";
    private static final String deviceType;
    private static List rtm2BaseValues;
    private static List rtmBaseValues;

    public UssUtil()
    {
    }

    public static List getRtmRequestContextValues(Context context, String s, String s1, int i)
    {
        if (rtmBaseValues == null || rtm2BaseValues == null)
        {
            setBasicRtmRequestContext(context);
        }
        context = new ArrayList();
        context.addAll(rtmBaseValues);
        context.add(new KeyValue("RTM", "12", s));
        context.add(new KeyValue("RTM", "415", Boolean.toString(false)));
        context.add(new KeyValue("RTM", "416", Boolean.toString(false)));
        context.add(new KeyValue("RTM", "PLACEMENTS", Integer.toString(i)));
        context.add(new KeyValue("RTM", "CORRELATION_GUID", s1));
        context.addAll(rtm2BaseValues);
        context.add(new KeyValue("RTM2", "12", s));
        context.add(new KeyValue("RTM2", "415", Boolean.toString(false)));
        context.add(new KeyValue("RTM2", "416", Boolean.toString(false)));
        context.add(new KeyValue("RTM2", "PLACEMENTS", Integer.toString(i)));
        context.add(new KeyValue("RTM2", "CORRELATION_GUID", s1));
        return context;
    }

    public static void setBasicRtmRequestContext(Context context)
    {
        String s1 = EbayIdentity.getDeviceIdString(context);
        String s2 = NautilusKernel.getAppVersionName(context);
        String s = "unknown";
        Object obj = (TelephonyManager)context.getSystemService("phone");
        context = s;
        if (obj != null)
        {
            obj = ((TelephonyManager) (obj)).getNetworkOperatorName();
            context = s;
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                context = ((Context) (obj));
            }
        }
        rtmBaseValues = new ArrayList();
        rtmBaseValues.add(new KeyValue("RTM", "CID", "39"));
        rtmBaseValues.add(new KeyValue("RTM", "418", "AEAPP"));
        rtmBaseValues.add(new KeyValue("RTM", "420", deviceType));
        rtmBaseValues.add(new KeyValue("RTM", "421", android.os.Build.VERSION.RELEASE));
        rtmBaseValues.add(new KeyValue("RTM", "425", context));
        rtmBaseValues.add(new KeyValue("RTM", "231", s1));
        rtmBaseValues.add(new KeyValue("RTM", "417", s2));
        rtmBaseValues.add(new KeyValue("RTM", "419", ""));
        rtmBaseValues.add(new KeyValue("RTM", "SOJOURNER_GUID", s1));
        rtm2BaseValues = new ArrayList();
        rtm2BaseValues.add(new KeyValue("RTM2", "CID", "39"));
        rtm2BaseValues.add(new KeyValue("RTM2", "418", "AEAPP"));
        rtm2BaseValues.add(new KeyValue("RTM2", "420", deviceType));
        rtm2BaseValues.add(new KeyValue("RTM2", "421", android.os.Build.VERSION.RELEASE));
        rtm2BaseValues.add(new KeyValue("RTM2", "451", "MAPP"));
        rtm2BaseValues.add(new KeyValue("RTM2", "425", context));
        rtm2BaseValues.add(new KeyValue("RTM2", "231", s1));
        rtm2BaseValues.add(new KeyValue("RTM2", "417", s2));
        rtm2BaseValues.add(new KeyValue("RTM2", "419", ""));
        rtm2BaseValues.add(new KeyValue("RTM2", "SOJOURNER_GUID", s1));
    }

    static 
    {
        deviceType = (new StringBuilder()).append("oem:").append(Build.MANUFACTURER).append(" model:").append(Build.MODEL).toString();
    }
}
