// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.setting;

import android.content.Context;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.platform.setting:
//            DCPSettings

public class PlatformSettings
{
    public static interface Listener
    {

        public abstract void onCacheUpdated();
    }

    public static final class Namespace extends Enum
    {

        private static final Namespace $VALUES[];
        public static final Namespace Default;
        public static final Namespace DeviceGlobal;

        public static Namespace valueOf(String s)
        {
            return (Namespace)Enum.valueOf(com/amazon/identity/platform/setting/PlatformSettings$Namespace, s);
        }

        public static Namespace[] values()
        {
            return (Namespace[])$VALUES.clone();
        }

        static 
        {
            DeviceGlobal = new Namespace("DeviceGlobal", 0);
            Default = new Namespace("Default", 1);
            $VALUES = (new Namespace[] {
                DeviceGlobal, Default
            });
        }

        private Namespace(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/identity/platform/setting/PlatformSettings.getName();
    private static PlatformSettings sTheOnlyInstance = null;

    public PlatformSettings()
    {
    }

    public static PlatformSettings getInstance(Context context)
    {
        com/amazon/identity/platform/setting/PlatformSettings;
        JVM INSTR monitorenter ;
        if (sTheOnlyInstance == null) goto _L2; else goto _L1
_L1:
        context = sTheOnlyInstance;
_L3:
        com/amazon/identity/platform/setting/PlatformSettings;
        JVM INSTR monitorexit ;
        return context;
_L2:
        Class.forName("com.amazon.dcp.settings.SettingsCache");
        if (context.getApplicationContext() != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        MAPLog.w(TAG, "Can't initialize DCP settings without an application context; using defaults");
        context = new PlatformSettings();
          goto _L3
        context;
        throw context;
        context;
        MAPLog.i(TAG, "DCP settings not available; using defaults");
        context = new PlatformSettings();
        sTheOnlyInstance = context;
          goto _L3
        context = DCPSettings.getDCPSettings(context);
        sTheOnlyInstance = context;
          goto _L3
        context;
        MAPLog.w(TAG, "Failed to initialize DCP settings; using defaults", context);
        context = new PlatformSettings();
          goto _L3
    }

    public void addListener(Listener listener)
    {
    }

    public boolean getSettingBoolean(String s, boolean flag)
    {
        return flag;
    }

    public int getSettingInteger(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        return i;
    }

    public long getSettingLong(String s, long l)
    {
        return l;
    }

    public String getSettingString(Namespace namespace, String s, String s1)
    {
        return s1;
    }

    public final String getSettingString(String s, String s1)
    {
        return getSettingString(Namespace.Default, s, s1);
    }

}
