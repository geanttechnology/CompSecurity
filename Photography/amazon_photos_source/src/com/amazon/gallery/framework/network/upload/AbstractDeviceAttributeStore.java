// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.device.DeviceUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.gallery.framework.network.upload:
//            DeviceAttributeStore

public abstract class AbstractDeviceAttributeStore
    implements DeviceAttributeStore
{

    private static final String TAG = com/amazon/gallery/framework/network/upload/AbstractDeviceAttributeStore.getName();
    public static boolean deviceHasWAN;
    public static boolean isTablet;
    protected final Context appContext;
    protected final CustomerAttributeStore customerAttributeStore;
    protected String deviceName;

    public AbstractDeviceAttributeStore(Context context)
    {
        boolean flag1 = false;
        super();
        appContext = context;
        customerAttributeStore = CustomerAttributeStore.getInstance(context);
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(0);
        boolean flag = flag1;
        if (networkinfo != null)
        {
            flag = flag1;
            if (networkinfo.getState() != android.net.NetworkInfo.State.UNKNOWN)
            {
                flag = true;
            }
        }
        deviceHasWAN = flag;
        isTablet = DeviceUtil.isTablet(context);
    }

    private String getCustomerAttributeValueOrDefault(String s, String s1)
    {
        UserManager usermanager = (UserManager)ThorGalleryApplication.getBean(Keys.USER_MANAGER);
        String s2 = ((AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER)).getAccountId();
        if (usermanager == null || s2 == null)
        {
            GLogger.w(TAG, "Device not registered", new Object[0]);
            return s1;
        }
        s = customerAttributeStore.getAttribute(s2, s, null, null);
        s = CustomerAttributeStore.getValueOrAttributeDefault((Bundle)s.get());
        return s;
        s;
_L2:
        GLogger.ex(TAG, "Error calling MAPAttributeStore", s);
        return s1;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean deviceHasWAN()
    {
        return deviceHasWAN;
    }

    public String getDeviceType()
    {
        if (BuildFlavors.isAosp())
        {
            return "ANDROID";
        } else
        {
            return "KINDLE";
        }
    }

    public String getDeviceTypeId()
    {
        String s = getCustomerAttributeValueOrDefault("com.amazon.dcp.sso.token.devicedevicetype", "A2PGLM6YI9EXDZ");
        GLogger.d(TAG, (new StringBuilder()).append("getDeviceTypeId()... Value:").append(s).toString(), new Object[0]);
        return s;
    }

    public String getUniqueDeviceId()
    {
        return null;
    }

    public boolean isTablet()
    {
        return isTablet;
    }

}
