// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.source;


public interface SettingsStore
{
    public static final class SettingsKey extends Enum
    {

        private static final SettingsKey $VALUES[];
        public static final SettingsKey DROPBOX_TIME_INDEX_KEY;
        public static final SettingsKey MAP_BUILD_INDEX_KEY;
        public static final SettingsKey RAMDUMP_TIME_INDEX_KEY;
        public static final SettingsKey VERSION_NUMBER;

        public static SettingsKey valueOf(String s)
        {
            return (SettingsKey)Enum.valueOf(com/amazon/device/crashmanager/source/SettingsStore$SettingsKey, s);
        }

        public static SettingsKey[] values()
        {
            return (SettingsKey[])$VALUES.clone();
        }

        static 
        {
            DROPBOX_TIME_INDEX_KEY = new SettingsKey("DROPBOX_TIME_INDEX_KEY", 0);
            MAP_BUILD_INDEX_KEY = new SettingsKey("MAP_BUILD_INDEX_KEY", 1);
            RAMDUMP_TIME_INDEX_KEY = new SettingsKey("RAMDUMP_TIME_INDEX_KEY", 2);
            VERSION_NUMBER = new SettingsKey("VERSION_NUMBER", 3);
            $VALUES = (new SettingsKey[] {
                DROPBOX_TIME_INDEX_KEY, MAP_BUILD_INDEX_KEY, RAMDUMP_TIME_INDEX_KEY, VERSION_NUMBER
            });
        }

        private SettingsKey(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract long getLong(SettingsKey settingskey, long l);

    public abstract String getString(SettingsKey settingskey, String s);

    public abstract void saveLong(SettingsKey settingskey, long l);

    public abstract void saveString(SettingsKey settingskey, String s);
}
