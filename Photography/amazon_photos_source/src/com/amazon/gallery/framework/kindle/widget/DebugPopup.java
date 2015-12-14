// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.gallery.video.player.VideoQuality;
import com.amazon.gallery.framework.kindle.notifications.NewPromotionNotificationHandler;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import com.amazon.gallery.thor.removablestorage.StorageLocationPreference;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DebugPopup
    implements android.app.DatePickerDialog.OnDateSetListener
{
    public static interface DebugCallback
    {

        public abstract void run(String s, Object obj);
    }

    public static interface DebugSelectedCheck
    {

        public abstract boolean check(String s, Object obj);
    }

    public static class MenuEntry
    {

        DebugCallback callback;
        DebugSelectedCheck entryCheck;
        boolean isModal;
        String key;
        String name;
        ArrayList options;

        private void executeOption(Context context1, String s, OptionValue optionvalue)
        {
            if (key != null)
            {
                optionvalue.saveValue(context1, key);
            }
            if (callback != null)
            {
                callback.run(s, optionvalue.value);
            }
        }

        private boolean shouldCheckEntry(Context context1, String s, OptionValue optionvalue)
        {
            if (entryCheck != null)
            {
                return entryCheck.check(s, optionvalue.value);
            }
            if (key == null)
            {
                return false;
            } else
            {
                return optionvalue.CheckPreferenceEquality(context1, key);
            }
        }

        public void showSubMenu(Context context1)
        {
            if ((options == null || options.isEmpty()) && callback != null)
            {
                callback.run(name, null);
                return;
            }
            int k = options.size();
            String as[] = new String[k];
            int j = -1;
            for (int i = 0; i < k; i++)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)options.get(i);
                as[i] = (String)entry.getKey();
                if (shouldCheckEntry(context1, (String)entry.getKey(), (OptionValue)entry.getValue()))
                {
                    j = i;
                }
            }

            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context1);
            builder.setTitle(name);
            context1 = context1. new android.content.DialogInterface.OnClickListener() {

                final MenuEntry this$0;
                final Context val$context;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    executeOption(context, (String)((java.util.Map.Entry)options.get(i)).getKey(), (OptionValue)((java.util.Map.Entry)options.get(i)).getValue());
                }

            
            {
                this$0 = final_menuentry;
                context = Context.this;
                super();
            }
            };
            if (isModal)
            {
                builder.setSingleChoiceItems(as, j, context1);
            } else
            {
                builder.setItems(as, context1);
            }
            builder.show();
        }


        public MenuEntry()
        {
        }
    }

    private static abstract class OptionValue
    {

        Object value;

        abstract boolean CheckPreferenceEquality(Context context1, String s);

        abstract void saveValue(Context context1, String s);

        public OptionValue(Object obj)
        {
            value = obj;
        }
    }

    private static class OptionValueBoolean extends OptionValue
    {

        boolean CheckPreferenceEquality(Context context1, String s)
        {
            return context1.getSharedPreferences("galleryKindleSharedPrefs", 0).getBoolean(s, false) == ((Boolean)value).booleanValue();
        }

        void saveValue(Context context1, String s)
        {
            context1.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean(s, ((Boolean)value).booleanValue()).apply();
        }

        public OptionValueBoolean(Boolean boolean1)
        {
            super(boolean1);
        }
    }

    private static class OptionValueFeatureManager extends OptionValue
    {

        boolean CheckPreferenceEquality(Context context1, String s)
        {
            return FeatureManager.isFeatureEnabled(Features.valueOf(s)) == ((Boolean)value).booleanValue();
        }

        void saveValue(Context context1, String s)
        {
            FeatureManager.setFeatureEnabled(context1, Features.valueOf(s), ((Boolean)value).booleanValue());
        }

        public OptionValueFeatureManager(Boolean boolean1)
        {
            super(boolean1);
        }
    }

    private static class OptionValueLong extends OptionValue
    {

        boolean CheckPreferenceEquality(Context context1, String s)
        {
            return context1.getSharedPreferences("galleryKindleSharedPrefs", 0).getLong(s, 0L) == ((Long)value).longValue();
        }

        void saveValue(Context context1, String s)
        {
            context1.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putLong(s, ((Long)value).longValue()).apply();
        }

        public OptionValueLong(Long long1)
        {
            super(long1);
        }
    }

    private static class OptionValueString extends OptionValue
    {

        boolean CheckPreferenceEquality(Context context1, String s)
        {
            return context1.getSharedPreferences("galleryKindleSharedPrefs", 0).getString(s, "").contentEquals((String)value);
        }

        void saveValue(Context context1, String s)
        {
            context1.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString(s, (String)value).apply();
        }

        public OptionValueString(String s)
        {
            super(s);
        }
    }


    private static boolean addedDefaultOptions = false;
    private static ArrayList entries;
    Context context;
    android.support.v7.app.AlertDialog.Builder mainBuilder;

    public DebugPopup(Context context1)
    {
        context = context1;
        mainBuilder = new android.support.v7.app.AlertDialog.Builder(context);
        mainBuilder.setTitle("Debug options");
        if (!addedDefaultOptions)
        {
            addDefaultDebugOptions();
            addedDefaultOptions = true;
        }
    }

    public static transient void registerBooleanOption(String s, String s1, boolean flag, boolean flag1, DebugCallback debugcallback, DebugSelectedCheck debugselectedcheck, java.util.Map.Entry aentry[])
    {
        ArrayList arraylist = new ArrayList();
        int j = aentry.length;
        int i = 0;
        while (i < j) 
        {
            java.util.Map.Entry entry = aentry[i];
            if (flag1)
            {
                arraylist.add(new java.util.AbstractMap.SimpleEntry(entry.getKey(), new OptionValueFeatureManager((Boolean)entry.getValue())));
            } else
            {
                arraylist.add(new java.util.AbstractMap.SimpleEntry(entry.getKey(), new OptionValueBoolean((Boolean)entry.getValue())));
            }
            i++;
        }
        registerDebugOptionInternal(s, s1, flag, debugcallback, debugselectedcheck, arraylist);
    }

    private static void registerCustomDebugOptionInternal(String s, DebugCallback debugcallback)
    {
        registerDebugOptionInternal(s, null, false, debugcallback, null, null);
    }

    private static void registerDebugOptionInternal(String s, String s1, boolean flag, DebugCallback debugcallback, DebugSelectedCheck debugselectedcheck, ArrayList arraylist)
    {
        if (entries == null)
        {
            entries = new ArrayList();
        }
        MenuEntry menuentry = new MenuEntry();
        menuentry.name = s;
        menuentry.key = s1;
        menuentry.callback = debugcallback;
        menuentry.isModal = flag;
        menuentry.options = arraylist;
        menuentry.entryCheck = debugselectedcheck;
        entries.add(menuentry);
    }

    private void registerIsDebugBuildOption()
    {
        registerBooleanOption("DebugAssert.isDebugBuild", null, true, false, new DebugCallback() {

            final DebugPopup this$0;

            public void run(String s, Boolean boolean1)
            {
                DebugAssert.isDebugBuild = boolean1.booleanValue();
            }

            public volatile void run(String s, Object obj)
            {
                run(s, (Boolean)obj);
            }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
        }, new DebugSelectedCheck() {

            final DebugPopup this$0;

            public boolean check(String s, Boolean boolean1)
            {
                if (s.equals("Enabled"))
                {
                    return DebugAssert.isDebugBuild;
                }
                return !DebugAssert.isDebugBuild;
            }

            public volatile boolean check(String s, Object obj)
            {
                return check(s, (Boolean)obj);
            }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
        }, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Enabled", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("Disabled", Boolean.valueOf(false))
        });
    }

    public static transient void registerLongOption(String s, String s1, boolean flag, DebugCallback debugcallback, DebugSelectedCheck debugselectedcheck, java.util.Map.Entry aentry[])
    {
        ArrayList arraylist = new ArrayList();
        int j = aentry.length;
        for (int i = 0; i < j; i++)
        {
            java.util.Map.Entry entry = aentry[i];
            arraylist.add(new java.util.AbstractMap.SimpleEntry(entry.getKey(), new OptionValueLong((Long)entry.getValue())));
        }

        registerDebugOptionInternal(s, s1, flag, debugcallback, debugselectedcheck, arraylist);
    }

    private void registerSetThisDayOption()
    {
        registerCustomDebugOptionInternal("Set this day", new DebugCallback() {

            final DebugPopup this$0;

            public void run(String s, Object obj)
            {
                s = ThisDayUtils.getThisDayDate(context);
                (new DatePickerDialog(context, DebugPopup.this, s.get(1), s.get(2), s.get(5))).show();
            }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
        });
    }

    private void registerShowInfoOption()
    {
        registerCustomDebugOptionInternal("Show info", new DebugCallback() {

            final DebugPopup this$0;

            public void run(String s, Object obj)
            {
                s = new ArrayAdapter(context, 0x1090003);
                s.add((new StringBuilder()).append("Device uuid: ").append((new AospPreferences(context)).getDeviceUUID()).toString());
                (new android.support.v7.app.AlertDialog.Builder(context)).setAdapter(s, null).show();
            }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
        });
    }

    public static transient void registerStringOption(String s, String s1, boolean flag, DebugCallback debugcallback, DebugSelectedCheck debugselectedcheck, java.util.Map.Entry aentry[])
    {
        ArrayList arraylist = new ArrayList();
        int j = aentry.length;
        for (int i = 0; i < j; i++)
        {
            java.util.Map.Entry entry = aentry[i];
            arraylist.add(new java.util.AbstractMap.SimpleEntry(entry.getKey(), new OptionValueString((String)entry.getValue())));
        }

        registerDebugOptionInternal(s, s1, flag, debugcallback, debugselectedcheck, arraylist);
    }

    public void addDefaultDebugOptions()
    {
        registerBooleanOption("Facebook permissions", "debug_facebook_no_permissions", true, false, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Force no permissions", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("Get real permissions", Boolean.valueOf(false))
        });
        Context context1 = context;
        Context context2 = context;
        context1.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString(com/amazon/gallery/framework/gallery/video/player/VideoQuality.getSimpleName(), VideoQuality.CURRENT_QUALITY.toString()).apply();
        registerIsDebugBuildOption();
        registerBooleanOption("Force promotion", "FORCE_DEBUG_PROMOTION", true, false, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Force promotion", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("Remove forced promotion", Boolean.valueOf(false))
        });
        if (!BuildFlavors.isFos5())
        {
            registerLongOption("Force promotion check interval", "NEW_PROMOTION_CHECK_BACKGROUND_WIFI_WAKE_INTERVAL", true, new DebugCallback() {

                final DebugPopup this$0;

                public void run(String s, Long long1)
                {
                    if (context instanceof BeanAwareActivity)
                    {
                        NewPromotionNotificationHandler.scheduleNewPromotionCheck(context, ((BeanAwareActivity)context).getBeanFactory());
                    }
                }

                public volatile void run(String s, Object obj)
                {
                    run(s, (Long)obj);
                }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
            }, null, new java.util.Map.Entry[] {
                new java.util.AbstractMap.SimpleEntry("Default", Long.valueOf(60L)), new java.util.AbstractMap.SimpleEntry("1 min", Long.valueOf(1L)), new java.util.AbstractMap.SimpleEntry("15 min", Long.valueOf(15L))
            });
        }
        registerStringOption("Promotion Notification last seen id", "new_promotion_notification_last_shown_promotion_id", true, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Reset", ""), new java.util.AbstractMap.SimpleEntry("Forced Promotion", "999"), new java.util.AbstractMap.SimpleEntry("Alternate Fake Promotion", "998")
        });
        registerBooleanOption("Force ftue", "FORCE_FTUE", true, false, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Force ftue", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("Disable ftue", Boolean.valueOf(false))
        });
        registerBooleanOption("Use Real Splash Call", "USE_REAL_SPLASH_CALL", true, false, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("use network call", Boolean.valueOf(true)), new java.util.AbstractMap.SimpleEntry("disable network call", Boolean.valueOf(false))
        });
        registerStringOption("Override Webview host", "WEBVIEW_OVERRIDE_HOST", true, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("Reset", ""), new java.util.AbstractMap.SimpleEntry("adrive-qa-us.amazon.com", "adrive-qa-us.amazon.com")
        });
        registerStringOption("SD Card Download Preference", "removable_storage_manager_storage_preference_key", true, null, null, new java.util.Map.Entry[] {
            new java.util.AbstractMap.SimpleEntry("unspecified", StorageLocationPreference.UNSPECIFIED.toString()), new java.util.AbstractMap.SimpleEntry("internal", StorageLocationPreference.USE_INTERNAL.toString()), new java.util.AbstractMap.SimpleEntry("SD card", StorageLocationPreference.USE_REMOVABLE.toString()), new java.util.AbstractMap.SimpleEntry("Clear value", "")
        });
        if (BuildFlavors.isFos5())
        {
            registerLongOption("Wallpaper manifest TTL", "wallpaper_manifest_ttl", true, null, null, new java.util.Map.Entry[] {
                new java.util.AbstractMap.SimpleEntry("1 minute", Long.valueOf(TimeUnit.MINUTES.toMillis(1L))), new java.util.AbstractMap.SimpleEntry("1 day", Long.valueOf(TimeUnit.DAYS.toMillis(1L)))
            });
        }
        registerShowInfoOption();
        registerSetThisDayOption();
    }

    public void onDateSet(DatePicker datepicker, int i, int j, int k)
    {
        datepicker = Calendar.getInstance();
        datepicker.set(i, j, k);
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putLong("THIS_DAY_TIME_OVERRIDE", datepicker.getTime().getTime()).apply();
    }

    public void show()
    {
        String as[] = new String[entries.size()];
        int j = entries.size();
        for (int i = 0; i < j; i++)
        {
            as[i] = ((MenuEntry)entries.get(i)).name;
        }

        mainBuilder.setItems(as, new android.content.DialogInterface.OnClickListener() {

            final DebugPopup this$0;

            public void onClick(DialogInterface dialoginterface, int k)
            {
                dialoginterface.dismiss();
                ((MenuEntry)DebugPopup.entries.get(k)).showSubMenu(context);
            }

            
            {
                this$0 = DebugPopup.this;
                super();
            }
        });
        mainBuilder.show();
    }


}
