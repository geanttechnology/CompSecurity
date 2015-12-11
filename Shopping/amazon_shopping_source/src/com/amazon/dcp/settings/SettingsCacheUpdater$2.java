// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;


// Referenced classes of package com.amazon.dcp.settings:
//            SettingsCacheUpdater, SettingsNamespace

static class 
{

    static final int $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[];

    static 
    {
        $SwitchMap$com$amazon$dcp$settings$SettingsNamespace = new int[SettingsNamespace.values().length];
        try
        {
            $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[SettingsNamespace.AppLocal.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$dcp$settings$SettingsNamespace[SettingsNamespace.DeviceGlobal.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
