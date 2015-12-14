// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import com.mopub.network.AdResponse;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.mopub.common:
//            ClientMetadata

public class AdReport
    implements Serializable
{

    private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
    private static final long serialVersionUID = 1L;
    private final AdResponse mAdResponse;
    private final String mAdUnitId;
    private final Locale mDeviceLocale;
    private final String mDeviceModel;
    private final String mSdkVersion;
    private final String mUdid;

    public AdReport(String s, ClientMetadata clientmetadata, AdResponse adresponse)
    {
        mAdUnitId = s;
        mSdkVersion = clientmetadata.getSdkVersion();
        mDeviceModel = clientmetadata.getDeviceModel();
        mDeviceLocale = clientmetadata.getDeviceLocale();
        mUdid = clientmetadata.getDeviceId();
        mAdResponse = adresponse;
    }

    private void appendKeyValue(StringBuilder stringbuilder, String s, String s1)
    {
        stringbuilder.append(s);
        stringbuilder.append(" : ");
        stringbuilder.append(s1);
        stringbuilder.append("\n");
    }

    private String getFormattedTimeStamp(long l)
    {
        if (l != -1L)
        {
            return (new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US)).format(new Date(l));
        } else
        {
            return null;
        }
    }

    public String getResponseString()
    {
        return mAdResponse.getStringBody();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        appendKeyValue(stringbuilder, "sdk_version", mSdkVersion);
        appendKeyValue(stringbuilder, "creative_id", mAdResponse.getDspCreativeId());
        appendKeyValue(stringbuilder, "platform_version", Integer.toString(android.os.Build.VERSION.SDK_INT));
        appendKeyValue(stringbuilder, "device_model", mDeviceModel);
        appendKeyValue(stringbuilder, "ad_unit_id", mAdUnitId);
        Object obj;
        Integer integer;
        Object obj1;
        StringBuilder stringbuilder1;
        if (mDeviceLocale == null)
        {
            obj = null;
        } else
        {
            obj = mDeviceLocale.toString();
        }
        appendKeyValue(stringbuilder, "device_locale", ((String) (obj)));
        appendKeyValue(stringbuilder, "device_id", mUdid);
        appendKeyValue(stringbuilder, "network_type", mAdResponse.getNetworkType());
        appendKeyValue(stringbuilder, "platform", "android");
        appendKeyValue(stringbuilder, "timestamp", getFormattedTimeStamp(mAdResponse.getTimestamp()));
        appendKeyValue(stringbuilder, "ad_type", mAdResponse.getAdType());
        obj1 = mAdResponse.getWidth();
        integer = mAdResponse.getHeight();
        stringbuilder1 = (new StringBuilder()).append("{");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "0";
        }
        obj1 = stringbuilder1.append(obj).append(", ");
        obj = integer;
        if (integer == null)
        {
            obj = "0";
        }
        appendKeyValue(stringbuilder, "ad_size", ((StringBuilder) (obj1)).append(obj).append("}").toString());
        return stringbuilder.toString();
    }
}
