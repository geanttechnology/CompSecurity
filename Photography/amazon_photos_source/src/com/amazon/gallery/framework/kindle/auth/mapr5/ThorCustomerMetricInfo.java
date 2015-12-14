// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.metrics.customer.KindleCustomerMetricsInfo;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;

// Referenced classes of package com.amazon.gallery.framework.kindle.auth.mapr5:
//            MapAttributeHelper

public class ThorCustomerMetricInfo extends KindleCustomerMetricsInfo
{

    private final AuthenticationManager authenticationManager;
    private final CustomerAttributeStore customerAttStore;
    private String deviceName;
    private String dsn;
    private String registryId;

    public ThorCustomerMetricInfo(Context context, AuthenticationManager authenticationmanager, RestClient restclient)
    {
        super(context, restclient);
        authenticationManager = authenticationmanager;
        customerAttStore = CustomerAttributeStore.getInstance(context);
    }

    private String getDeviceAttribute(String s, String s1)
    {
        return MapAttributeHelper.getDeviceAttribute(customerAttStore, authenticationManager.getAccountId(), s, s1);
    }

    public String getClientId()
    {
        if (registryId == null)
        {
            registryId = getDeviceAttribute("com.amazon.dcp.sso.token.devicedevicetype", "");
        }
        return registryId;
    }

    public String getDSN()
    {
        if (dsn == null)
        {
            dsn = getDeviceAttribute("com.amazon.dcp.sso.token.device.deviceserialname", super.getDSN());
        }
        return dsn;
    }

    public String getDeviceName()
    {
        if (deviceName == null)
        {
            deviceName = getDeviceAttribute("com.amazon.dcp.sso.property.devicename", null);
        }
        return deviceName;
    }
}
