// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.SharedPreferences;

public class i
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Production;
        public static final a Stage;
        public static final a UAT;
        public String prefValue;

        static a a(String s)
        {
            a aa[] = values();
            int k = aa.length;
            for (int j = 0; j < k; j++)
            {
                a a1 = aa[j];
                if (a1.prefValue.equalsIgnoreCase(s))
                {
                    return a1;
                }
            }

            return UAT;
        }

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/util/i$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Production = new a("Production", 0, "Production");
            Stage = new a("Stage", 1, "Stage");
            UAT = new a("UAT", 2, "UAT");
            $VALUES = (new a[] {
                Production, Stage, UAT
            });
        }

        private a(String s, int j, String s1)
        {
            super(s, j);
            prefValue = s1;
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b AlwaysShowCardStream;
        public static final b AlwaysShowCardStreamInStore;
        public static final b Default;
        public String prefValue;

        static b a(String s)
        {
            b ab[] = values();
            int k = ab.length;
            for (int j = 0; j < k; j++)
            {
                b b1 = ab[j];
                if (b1.prefValue.equalsIgnoreCase(s))
                {
                    return b1;
                }
            }

            return Default;
        }

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/util/i$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            Default = new b("Default", 0, "IN_STORE_DEFAULT");
            AlwaysShowCardStreamInStore = new b("AlwaysShowCardStreamInStore", 1, "SHOW_CARD_STREAM_IN_STORE");
            AlwaysShowCardStream = new b("AlwaysShowCardStream", 2, "ALWAYS_SHOW_CARD_STREAM");
            $VALUES = (new b[] {
                Default, AlwaysShowCardStreamInStore, AlwaysShowCardStream
            });
        }

        private b(String s, int j, String s1)
        {
            super(s, j);
            prefValue = s1;
        }
    }


    private static final String KEY_DEBUG_PREFS = (new StringBuilder()).append(TAG).append("debugSharedPrefs").toString();
    private static final String KEY_ENVIRONMENT = "environment";
    private static final String KEY_IN_STORE_MODE = "inStoreMode";
    private static final String KEY_TAPLYTICS_ENABLE = "taplyticsEnabledPrefs";
    private static final String KEY_VLC_STORE_ID = "vlcStoreId";
    private static final String KEY_VLC_ZONE_ID = "vlcZoneId";
    private static final String TAG = com/target/ui/util/i.getSimpleName();
    private static final String VALUE_ENVIRONMENT_DEFAULT = "Production";
    private static final String VALUE_ENV_PROD = "Production";
    private static final String VALUE_ENV_STAGE = "Stage";
    private static final String VALUE_ENV_UAT = "UAT";

    public i()
    {
    }

    public static String a(Context context)
    {
        return e(context).getString("vlcStoreId", "");
    }

    public static void a(a a1, Context context)
    {
        a("environment", a1.prefValue, context);
    }

    public static void a(b b1, Context context)
    {
        a("inStoreMode", b1.prefValue, context);
    }

    public static void a(String s, Context context)
    {
        a("vlcStoreId", s, context);
    }

    private static void a(String s, String s1, Context context)
    {
        e(context).edit().putString(s, s1).apply();
    }

    public static void a(boolean flag, Context context)
    {
        e(context).edit().putBoolean("taplyticsEnabledPrefs", flag).commit();
    }

    public static boolean b(Context context)
    {
        return e(context).getBoolean("taplyticsEnabledPrefs", false);
    }

    public static a c(Context context)
    {
        return a.a(e(context).getString("environment", "Production"));
    }

    public static b d(Context context)
    {
        return b.a(e(context).getString("inStoreMode", b.Default.prefValue));
    }

    private static SharedPreferences e(Context context)
    {
        return context.getSharedPreferences(KEY_DEBUG_PREFS, 0);
    }

}
