// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.core.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.openx.common.deviceData.listeners.AdTruthListener;
import com.openx.common.deviceData.listeners.DeviceInfoListener;
import com.openx.common.deviceData.listeners.NetworkListener;
import com.openx.common.deviceData.listeners.OXMLocationListener;
import com.openx.common.deviceData.listeners.PreferenceListener;
import com.openx.common.deviceData.managers.AdTruthImpl;
import com.openx.common.deviceData.managers.DeviceInfoImpl;
import com.openx.common.deviceData.managers.NetworkImpl;
import com.openx.common.deviceData.managers.OXMPreferencesImpl;
import com.openx.common.utils.helpers.Utils;
import com.openx.sdk.event.OXMEventsListener;
import com.openx.sdk.event.OXMEventsManagerImpl;
import com.openx.view.WebViewBase;
import java.util.Hashtable;

// Referenced classes of package com.openx.core.sdk:
//            OXMManager

public final class OXMManagersResolver
{

    private WebViewBase currentAd;
    private Context mContext;
    private Hashtable mRegisteredManaers;

    private OXMManagersResolver()
    {
        mRegisteredManaers = new Hashtable();
    }

    OXMManagersResolver(_cls1 _pcls1)
    {
        this();
    }

    public static OXMManagersResolver getInstance()
    {
    /* block-local class not found */
    class OXMManagersResolverHolder {}

        return OXMManagersResolverHolder.instance;
    }

    private Hashtable getRegisteredManagers()
    {
        return mRegisteredManaers;
    }

    private boolean isReady(Context context)
    {
        return context == getContext();
    }

    private void registerManagers(Context context)
    {
    /* block-local class not found */
    class ManagerType {}

        Object obj;
        if (context instanceof Activity)
        {
            obj = (Activity)context;
        } else
        {
            obj = (Application)context;
        }
        Utils.DENSITY = ((ContextWrapper) (obj)).getResources().getDisplayMetrics().density;
        obj = new DeviceInfoImpl();
        ((OXMManager) (obj)).init(context);
        getRegisteredManagers().put(ManagerType.DEVICE_MANAGER, obj);
        obj = new OXMEventsManagerImpl();
        ((OXMManager) (obj)).init(context);
        getRegisteredManagers().put(ManagerType.EVENTS_MANAGER, obj);
        (new Thread(new _cls1(context))).start();
        obj = new NetworkImpl();
        ((OXMManager) (obj)).init(context);
        getRegisteredManagers().put(ManagerType.NETWORK_MANAGER, obj);
        obj = new OXMPreferencesImpl();
        ((OXMManager) (obj)).init(context);
        getRegisteredManagers().put(ManagerType.PREFERENCES_MANAGER, obj);
        obj = new AdTruthImpl();
        ((OXMManager) (obj)).init(context);
        getRegisteredManagers().put(ManagerType.AD_TRUTH_MANAGER, obj);
        setContext(context);
    }

    private void setContext(Context context)
    {
        mContext = context;
    }

    public void dispose()
    {
        OXMManager oxmmanager = getInstance().getManager(ManagerType.EVENTS_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
        oxmmanager = getInstance().getManager(ManagerType.DEVICE_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
        oxmmanager = getInstance().getManager(ManagerType.LOCATION_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
        oxmmanager = getInstance().getManager(ManagerType.NETWORK_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
        oxmmanager = getInstance().getManager(ManagerType.PREFERENCES_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
        oxmmanager = getInstance().getManager(ManagerType.AD_TRUTH_MANAGER);
        if (oxmmanager != null)
        {
            oxmmanager.dispose();
        }
    }

    public AdTruthListener getAdTruthManager()
    {
        return (AdTruthListener)getManager(ManagerType.AD_TRUTH_MANAGER);
    }

    public Context getContext()
    {
        return mContext;
    }

    public WebViewBase getCurrentAd()
    {
        return currentAd;
    }

    public DeviceInfoListener getDeviceManager()
    {
        return (DeviceInfoListener)getManager(ManagerType.DEVICE_MANAGER);
    }

    public OXMEventsListener getEventsManager()
    {
        return (OXMEventsListener)getManager(ManagerType.EVENTS_MANAGER);
    }

    public OXMLocationListener getLocationManager()
    {
        return (OXMLocationListener)getManager(ManagerType.LOCATION_MANAGER);
    }

    public OXMManager getManager(ManagerType managertype)
    {
        if (getRegisteredManagers().containsKey(managertype))
        {
            return (OXMManager)getRegisteredManagers().get(managertype);
        } else
        {
            return null;
        }
    }

    public NetworkListener getNetworkManager()
    {
        return (NetworkListener)getManager(ManagerType.NETWORK_MANAGER);
    }

    public PreferenceListener getPreferencesManager()
    {
        return (PreferenceListener)getManager(ManagerType.PREFERENCES_MANAGER);
    }

    public void prepare(Context context)
    {
        if (!isReady(context))
        {
            dispose();
            registerManagers(context);
        }
    }

    public void setCurrentAd(WebViewBase webviewbase)
    {
        currentAd = webviewbase;
    }


    /* member class not found */
    class _cls1 {}

}
