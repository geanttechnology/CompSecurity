// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.setting;

import android.content.Context;
import com.amazon.dcp.settings.SettingBoolean;
import com.amazon.dcp.settings.SettingInteger;
import com.amazon.dcp.settings.SettingLong;
import com.amazon.dcp.settings.SettingString;
import com.amazon.dcp.settings.SettingsCache;
import com.amazon.dcp.settings.SettingsNamespace;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.platform.setting:
//            PlatformSettings

class DCPSettings extends PlatformSettings
{

    private static final String TAG = com/amazon/identity/platform/setting/DCPSettings.getName();

    DCPSettings()
    {
    }

    static DCPSettings getDCPSettings(Context context)
    {
        SettingsCache.setContext(context);
        SettingsCache.waitForInitialSync();
        return new DCPSettings();
    }

    public void addListener(final PlatformSettings.Listener listener)
    {
        try
        {
            SettingsCache.getInstance().addListener(new com.amazon.dcp.settings.SettingsCache.IListener() {

                final DCPSettings this$0;
                final PlatformSettings.Listener val$listener;

                public void onCacheUpdated()
                {
                    listener.onCacheUpdated();
                }

            
            {
                this$0 = DCPSettings.this;
                listener = listener1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final PlatformSettings.Listener listener)
        {
            MAPLog.e(TAG, "Failed to add DCP settings listener", listener);
        }
    }

    public boolean getSettingBoolean(String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = (new SettingBoolean(s, flag)).getValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "DCP Settings throws exceptions. Returning default value.", s);
            return flag;
        }
        return flag1;
    }

    public int getSettingInteger(String s, int i)
    {
        int j;
        try
        {
            j = (new SettingInteger(s, i)).getValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "DCP Settings throws exceptions. Returning default value.", s);
            return i;
        }
        return j;
    }

    public long getSettingLong(String s, long l)
    {
        long l1;
        try
        {
            l1 = (new SettingLong(s, l)).getValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "DCP Settings throws exceptions. Returning default value.", s);
            return l;
        }
        return l1;
    }

    public String getSettingString(PlatformSettings.Namespace namespace, String s, String s1)
    {
        if (namespace == PlatformSettings.Namespace.DeviceGlobal)
        {
            namespace = SettingsNamespace.DeviceGlobal;
        } else
        {
            namespace = SettingsNamespace.Default;
        }
        try
        {
            namespace = (new SettingString(namespace, s, s1)).getValue();
        }
        // Misplaced declaration of an exception variable
        catch (PlatformSettings.Namespace namespace)
        {
            MAPLog.e(TAG, "DCP Settings throws exceptions. Returning default value.", namespace);
            return s1;
        }
        return namespace;
    }

}
