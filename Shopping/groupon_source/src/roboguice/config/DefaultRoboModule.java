// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.config;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.google.inject.AbstractModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import roboguice.inject.AccountManagerProvider;
import roboguice.inject.AssetManagerProvider;
import roboguice.inject.ContentResolverProvider;
import roboguice.inject.ContextScope;
import roboguice.inject.ContextScopedSystemServiceProvider;
import roboguice.inject.ContextSingleton;
import roboguice.inject.HandlerProvider;
import roboguice.inject.NullProvider;
import roboguice.inject.ResourcesProvider;
import roboguice.inject.SharedPreferencesProvider;
import roboguice.inject.SystemServiceProvider;
import roboguice.util.Ln;
import roboguice.util.LnImpl;
import roboguice.util.LnInterface;

public class DefaultRoboModule extends AbstractModule
{

    private static Map mapSystemSericeClassToName;
    protected Application application;
    protected ContextScope contextScope;

    public DefaultRoboModule(Application application1, ContextScope contextscope)
    {
        application = application1;
        contextScope = contextscope;
    }

    private void bindDynamicBindings()
    {
        if (android.os.Build.VERSION.SDK_INT < 5)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        bind(Class.forName("android.accounts.AccountManager")).toProvider(roboguice/inject/AccountManagerProvider);
        return;
        Throwable throwable;
        throwable;
        Log.e(roboguice/config/DefaultRoboModule.getName(), "Impossible to bind AccountManager", throwable);
        return;
    }

    private void bindSystemService(Class class1, String s)
    {
        bind(class1).toProvider(new SystemServiceProvider(application, s));
    }

    protected void configure()
    {
        com.google.inject.Provider provider = getProvider(android/content/Context);
        bindScope(roboguice/inject/ContextSingleton, contextScope);
        superbind(roboguice/inject/ContextScope).toInstance(contextScope);
        bind(android/content/res/AssetManager).toProvider(roboguice/inject/AssetManagerProvider);
        bind(android/content/Context).toProvider(NullProvider.instance()).in(roboguice/inject/ContextSingleton);
        bind(android/app/Activity).toProvider(NullProvider.instance()).in(roboguice/inject/ContextSingleton);
        bind(android/app/Service).toProvider(NullProvider.instance()).in(roboguice/inject/ContextSingleton);
        bind(android/content/SharedPreferences).toProvider(roboguice/inject/SharedPreferencesProvider);
        bind(android/content/res/Resources).toProvider(roboguice/inject/ResourcesProvider);
        bind(android/content/ContentResolver).toProvider(roboguice/inject/ContentResolverProvider);
        bind(android/app/Application).toInstance(application);
        bind(android/os/Handler).toProvider(roboguice/inject/HandlerProvider);
        java.util.Map.Entry entry;
        for (Iterator iterator = mapSystemSericeClassToName.entrySet().iterator(); iterator.hasNext(); bindSystemService((Class)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        bind(android/view/LayoutInflater).toProvider(new ContextScopedSystemServiceProvider(provider, "layout_inflater"));
        bind(android/app/SearchManager).toProvider(new ContextScopedSystemServiceProvider(provider, "search"));
        if (isInjectable(roboguice/util/Ln))
        {
            bind(roboguice/util/LnInterface).to(roboguice/util/LnImpl);
            requestStaticInjection(new Class[] {
                roboguice/util/Ln
            });
        }
        bindDynamicBindings();
    }

    public String providesAndroidId()
    {
        String s;
        Object obj;
        s = null;
        obj = application.getContentResolver();
        obj = android.provider.Settings.Secure.getString(((ContentResolver) (obj)), "android_id");
        s = ((String) (obj));
_L1:
        RuntimeException runtimeexception;
        if (!"".equals(s))
        {
            return s;
        } else
        {
            throw new RuntimeException("No Android Id.");
        }
        runtimeexception;
        Log.e(roboguice/config/DefaultRoboModule.getName(), "Impossible to get the android device Id. This may fail 'normally' when testing.", runtimeexception);
          goto _L1
    }

    public PackageInfo providesPackageInfo()
    {
        PackageInfo packageinfo;
        try
        {
            packageinfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            throw new RuntimeException(namenotfoundexception);
        }
        return packageinfo;
    }

    static 
    {
        mapSystemSericeClassToName = new HashMap();
        mapSystemSericeClassToName.put(android/location/LocationManager, "location");
        mapSystemSericeClassToName.put(android/view/WindowManager, "window");
        mapSystemSericeClassToName.put(android/app/ActivityManager, "activity");
        mapSystemSericeClassToName.put(android/os/PowerManager, "power");
        mapSystemSericeClassToName.put(android/app/AlarmManager, "alarm");
        mapSystemSericeClassToName.put(android/app/NotificationManager, "notification");
        mapSystemSericeClassToName.put(android/app/KeyguardManager, "keyguard");
        mapSystemSericeClassToName.put(android/os/Vibrator, "vibrator");
        mapSystemSericeClassToName.put(android/net/ConnectivityManager, "connectivity");
        mapSystemSericeClassToName.put(android/net/wifi/WifiManager, "wifi");
        mapSystemSericeClassToName.put(android/view/inputmethod/InputMethodManager, "input_method");
        mapSystemSericeClassToName.put(android/hardware/SensorManager, "sensor");
        mapSystemSericeClassToName.put(android/telephony/TelephonyManager, "phone");
        mapSystemSericeClassToName.put(android/media/AudioManager, "audio");
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            mapSystemSericeClassToName.put(android/app/DownloadManager, "download");
        }
    }
}
