// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;


public final class SettingsNamespace extends Enum
{

    private static final SettingsNamespace $VALUES[];
    public static final SettingsNamespace AppLocal;
    public static final SettingsNamespace Default;
    public static final SettingsNamespace DeviceGlobal;

    private SettingsNamespace(String s, int i)
    {
        super(s, i);
    }

    public static SettingsNamespace valueOf(String s)
    {
        return (SettingsNamespace)Enum.valueOf(com/amazon/dcp/settings/SettingsNamespace, s);
    }

    public static SettingsNamespace[] values()
    {
        return (SettingsNamespace[])$VALUES.clone();
    }

    static 
    {
        Default = new SettingsNamespace("Default", 0);
        AppLocal = new SettingsNamespace("AppLocal", 1);
        DeviceGlobal = new SettingsNamespace("DeviceGlobal", 2);
        $VALUES = (new SettingsNamespace[] {
            Default, AppLocal, DeviceGlobal
        });
    }
}
