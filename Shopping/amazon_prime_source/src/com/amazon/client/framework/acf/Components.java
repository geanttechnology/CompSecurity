// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import com.amazon.client.framework.acf.annotations.RegisteredComponent;
import com.amazon.client.framework.acf.util.AcfLog;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.client.framework.acf:
//            ComponentRegistry, MissingComponentException

public final class Components
{
    public static interface ComponentRegistryFactory
    {

        public abstract ComponentRegistry create(Context context);
    }


    public static final String ACTIVITY_SERVICE = "amazon.activity.acf.Activity";
    public static final String APPLICATION_SERVICE = "amazon.acf.Application";
    public static final String FRAGMENT_SERVICE = "amazon.activity.acf.Fragment";
    public static final String HANDLER_SERVICE = "amazon.acf.HandlerComponent";
    public static final String PREFIX_ACTIVITY = "amazon.activity.";
    public static final String PREFIX_APP = "amazon.";
    public static final String PREFIX_COMPONENT = "amazon.";
    private static final int SYSTEM_SERVICE_COUNT = 40;
    public static String TAG = AcfLog.getTag(com/amazon/client/framework/acf/Components);
    private static ComponentRegistryFactory mComponentRegistryFactory;
    private static Map sSystemServiceMap;

    private Components()
    {
    }

    public static ComponentRegistry createDefaultComponentRegistry(Context context)
    {
        if (mComponentRegistryFactory == null)
        {
            throw new UnsupportedOperationException("Must call setComponentRegistryFactory to use this function.  Did you mean to call Aomame.init()?");
        } else
        {
            return mComponentRegistryFactory.create(context);
        }
    }

    public static Object get(ComponentRegistry componentregistry, Class class1)
    {
        return class1.cast(componentregistry.getComponent(getName(class1)));
    }

    private static String getErrorMessage(String s, Class class1, String s1)
    {
        class1 = (new StringBuilder()).append("Service ").append(s).append(" of type ").append(class1.getName()).append(" not found.  Ensure you are using the context (Application, Activity or Module) that provides the desired component.").toString();
        s = class1;
        if (s1 != null)
        {
            s = (new StringBuilder()).append(class1).append(" ").append(s1).toString();
        }
        Log.v(com/amazon/client/framework/acf/MissingComponentException.getSimpleName(), s);
        return s;
    }

    public static String getName(Class class1)
    {
        String s = class1.getName();
        if (class1.isAnnotationPresent(com/amazon/client/framework/acf/annotations/RegisteredComponent))
        {
            return ((RegisteredComponent)class1.getAnnotation(com/amazon/client/framework/acf/annotations/RegisteredComponent)).value();
        }
        if (sSystemServiceMap.containsKey(s))
        {
            return (String)sSystemServiceMap.get(s);
        } else
        {
            throw new MissingComponentException((new StringBuilder()).append("Component ").append(s).append(" is missing required annotation ComponentName").toString());
        }
    }

    public static boolean isComponentized(Context context)
    {
        return optional(context, com/amazon/client/framework/acf/ComponentRegistry) != null;
    }

    public static Object optional(Fragment fragment, Class class1)
    {
        return optional(fragment, getName(class1), class1);
    }

    public static Object optional(Fragment fragment, String s, Class class1)
    {
        if (fragment.getActivity() == null)
        {
            return null;
        } else
        {
            return optional(((Context) (fragment.getActivity())), s, class1);
        }
    }

    public static Object optional(Context context, Class class1)
    {
        return optional(context, getName(class1), class1);
    }

    public static Object optional(Context context, String s, Class class1)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Could not get service - context was null.");
        }
        context = ((Context) (context.getSystemService(s)));
        if (context == null)
        {
            Log.d(TAG, (new StringBuilder()).append("Service ").append(s).append(" not found.").toString());
        } else
        {
            if (class1 == null)
            {
                return context;
            }
            if (class1.isAssignableFrom(context.getClass()))
            {
                return class1.cast(context);
            }
        }
        return null;
    }

    public static Object register(ComponentRegistry componentregistry, Class class1, Object obj)
    {
        return componentregistry.registerComponent(getName(class1), obj);
    }

    static void registerAmazonServiceTypes()
    {
        sSystemServiceMap.put("com.amazon.clipboard.AmazonClipboardManager", "amzClipboard");
    }

    public static void registerComponentName(Class class1, String s)
    {
        sSystemServiceMap.put(class1.getName(), s);
    }

    static void registerSystemServiceTypes()
    {
        sSystemServiceMap.put("android.view.accessibility.AccessibilityManager", "accessibility");
        sSystemServiceMap.put("android.accounts.AccountManager", "account");
        sSystemServiceMap.put("android.app.ActivityManager", "activity");
        sSystemServiceMap.put("android.app.AlarmManager", "alarm");
        sSystemServiceMap.put("android.media.AudioManager", "audio");
        sSystemServiceMap.put("android.bluetooth.BluetoothAdapter", "bluetooth");
        sSystemServiceMap.put("android.text.ClipboardManager", "clipboard");
        sSystemServiceMap.put("android.net.ConnectivityManager", "connectivity");
        sSystemServiceMap.put("android.app.admin.DevicePolicyManager", "device_policy");
        sSystemServiceMap.put("android.app.DownloadManager", "download");
        sSystemServiceMap.put("android.os.DropBoxManager", "dropbox");
        sSystemServiceMap.put("android.view.inputmethod.InputMethodManager", "input_method");
        sSystemServiceMap.put("android.app.KeyguardManager", "keyguard");
        sSystemServiceMap.put("android.view.LayoutInflater", "layout_inflater");
        sSystemServiceMap.put("android.location.LocationManager", "location");
        sSystemServiceMap.put("android.nfc.NfcManager", "nfc");
        sSystemServiceMap.put("android.app.NotificationManager", "notification");
        sSystemServiceMap.put("android.os.PowerManager", "power");
        sSystemServiceMap.put("android.app.SearchManager", "search");
        sSystemServiceMap.put("android.hardware.SensorManager", "sensor");
        sSystemServiceMap.put("android.os.storage.StorageManager", "storage");
        sSystemServiceMap.put("android.telephony.TelephonyManager", "phone");
        sSystemServiceMap.put("android.view.textservice.TextServicesManager", "textservices");
        sSystemServiceMap.put("android.hardware.usb.UsbManager", "usb");
        sSystemServiceMap.put("android.os.Vibrator", "vibrator");
        sSystemServiceMap.put("android.service.wallpaper.WallpaperService", "wallpaper");
        sSystemServiceMap.put("android.net.wifi.p2p.WifiP2pManager", "wifip2p");
        sSystemServiceMap.put("android.net.wifi.WifiManager", "wifi");
        sSystemServiceMap.put("android.view.WindowManager", "window");
    }

    static void registerSystemServiceTypes16()
    {
        sSystemServiceMap.put("android.hardware.input.InputManager", "input");
        sSystemServiceMap.put("android.media.MediaRouter", "media_router");
        sSystemServiceMap.put("android.net.nsd.NsdManager", "servicediscovery");
    }

    static void registerSystemServiceTypes17()
    {
        sSystemServiceMap.put("android.os.UserManager", "user");
    }

    static void registerSystemServiceTypes19()
    {
        sSystemServiceMap.put("android.app.AppOpsManager", "appops");
        sSystemServiceMap.put("android.print.PrintManager", "print");
    }

    public static Object required(Context context, Class class1)
    {
        return required(context, getName(class1), class1);
    }

    public static Object required(Context context, String s, Class class1)
    {
        if (context == null)
        {
            throw new IllegalArgumentException(getErrorMessage(s, class1, "Context was null."));
        }
        try
        {
            context = ((Context) (context.getSystemService(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new MissingComponentException(class1, s, context.getMessage(), context);
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        throw new MissingComponentException(class1, s, getErrorMessage(s, class1, null));
        context = ((Context) (class1.cast(context)));
        return context;
    }

    public static void setDefaultComponentRegistryFactory(ComponentRegistryFactory componentregistryfactory)
    {
        if (mComponentRegistryFactory != null)
        {
            throw new UnsupportedOperationException("Can only set the ComponentRegistryFactory once per process.");
        } else
        {
            mComponentRegistryFactory = componentregistryfactory;
            return;
        }
    }

    static 
    {
        sSystemServiceMap = new HashMap(40);
        sSystemServiceMap.put("android.app.Activity", "amazon.activity.acf.Activity");
        sSystemServiceMap.put("android.app.Application", "amazon.acf.Application");
        sSystemServiceMap.put("android.app.Fragment", "amazon.activity.acf.Fragment");
        registerAmazonServiceTypes();
        registerSystemServiceTypes();
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 16)
        {
            registerSystemServiceTypes16();
        }
        if (i >= 17)
        {
            registerSystemServiceTypes17();
        }
        if (i >= 19)
        {
            registerSystemServiceTypes19();
        }
    }
}
