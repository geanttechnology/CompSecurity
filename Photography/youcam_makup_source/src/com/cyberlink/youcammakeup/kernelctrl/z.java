// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.content.Context;
import android.content.SharedPreferences;
import com.cyberlink.youcammakeup.Globals;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class z
{

    public static Long a(Context context, String s1, Long long1)
    {
        return b((new StringBuilder()).append("BeautyCategory_LastModified_").append(s1).toString(), Long.valueOf(0L), context);
    }

    public static String a(Context context)
    {
        if (context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).contains("InstallationId"))
        {
            return b("InstallationId", context);
        } else
        {
            String s1 = UUID.randomUUID().toString();
            a("InstallationId", s1, context);
            return s1;
        }
    }

    public static Set a(String s1, Set set, Context context)
    {
        if (s1 == null || context == null)
        {
            throw new IllegalArgumentException("Parameter can not be null.");
        } else
        {
            return context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getStringSet(s1, set);
        }
    }

    public static void a()
    {
        Globals.d().getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().clear().commit();
    }

    public static void a(int i1)
    {
        a("DownloadYCPHintCount", i1, ((Context) (Globals.d())));
    }

    public static void a(Context context, float f1)
    {
        a("SkuVersion", f1, context);
    }

    public static void a(Context context, int i1)
    {
        a("BeautyCategoryVersion", i1, context);
    }

    public static void a(Context context, long l1)
    {
        a("MessageNId", Long.valueOf(l1), context);
    }

    public static void a(Context context, long l1, long l2)
    {
        a((new StringBuilder()).append("BeautyFilmTotalCount_").append(String.valueOf(l1)).toString(), Long.valueOf(l2), context);
    }

    public static void a(Context context, String s1)
    {
        a("LanguageCode", s1, context);
    }

    public static void a(Context context, Set set)
    {
        b("CostumeSeenList", set, context);
    }

    public static void a(com.cyberlink.youcammakeup.camera.LiveCategoryCtrl.LiveCategory livecategory)
    {
        a("MAKEUP_MIRROR_LIVE_CATEGORY", livecategory.toString(), ((Context) (Globals.d())));
    }

    public static void a(com.cyberlink.youcammakeup.clflurry.UInstallTrackEvent.STATUS status)
    {
        a("UInstallTrackStatus", status.toString(), ((Context) (Globals.d())));
    }

    public static void a(com.cyberlink.youcammakeup.clflurry.YCPInstallTrackEvent.STATUS status)
    {
        a("YCPInstallTrackStatus", status.toString(), ((Context) (Globals.d())));
    }

    public static void a(String s1)
    {
        a("BaiduCahnnelID", s1, ((Context) (Globals.d())));
    }

    public static void a(String s1, float f1, Context context)
    {
        if (s1 != null && context != null)
        {
            context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().putFloat(s1, f1).commit();
        }
    }

    public static void a(String s1, int i1, Context context)
    {
        if (s1 != null && context != null)
        {
            context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().putInt(s1, i1).commit();
        }
    }

    public static void a(String s1, Boolean boolean1, Context context)
    {
        if (s1 != null && boolean1 != null && context != null)
        {
            context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().putBoolean(s1, boolean1.booleanValue()).commit();
        }
    }

    public static void a(String s1, Long long1, Context context)
    {
        if (s1 != null && context != null)
        {
            context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().putLong(s1, long1.longValue()).commit();
        }
    }

    public static void a(String s1, String s2, Context context)
    {
        if (s1 != null && s2 != null && context != null)
        {
            context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit().putString(s1, s2).commit();
        }
    }

    public static void a(boolean flag)
    {
        a("CameraInfoCollectedV2", Boolean.valueOf(flag), ((Context) (Globals.d())));
    }

    public static boolean a(String s1, Context context)
    {
        return a(s1, false, context);
    }

    public static boolean a(String s1, boolean flag, Context context)
    {
        if (s1 != null && context != null)
        {
            return Boolean.valueOf(context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getBoolean(s1, flag)).booleanValue();
        } else
        {
            throw new NullPointerException("Parameter can not be null.");
        }
    }

    public static float b(Context context, float f1)
    {
        return b("SkuVersion", f1, context);
    }

    public static float b(String s1, float f1, Context context)
    {
        if (s1 == null || context == null)
        {
            throw new IllegalArgumentException("Parameter can not be null.");
        } else
        {
            return context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getFloat(s1, f1);
        }
    }

    public static int b()
    {
        return c("DownloadYCPHintCount", Globals.d());
    }

    public static int b(Context context, int i1)
    {
        return b("BeautyCategoryVersion", i1, context);
    }

    public static int b(String s1, int i1, Context context)
    {
        if (s1 != null && context != null)
        {
            return context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getInt(s1, i1);
        } else
        {
            throw new NullPointerException("Parameter can not be null.");
        }
    }

    public static long b(Context context, long l1)
    {
        return b("MessageNId", Long.valueOf(l1), context).longValue();
    }

    public static long b(Context context, long l1, long l2)
    {
        return b((new StringBuilder()).append("BeautyFilmTotalCount_").append(String.valueOf(l1)).toString(), Long.valueOf(l2), context).longValue();
    }

    public static Long b(String s1, Long long1, Context context)
    {
        if (s1 == null || context == null)
        {
            throw new IllegalArgumentException("Parameter can not be null.");
        } else
        {
            return Long.valueOf(context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getLong(s1, long1.longValue()));
        }
    }

    public static String b(Context context)
    {
        return a(context);
    }

    public static String b(Context context, String s1)
    {
        return b("SkuLanguage", s1, context);
    }

    public static String b(String s1, Context context)
    {
        return b(s1, "", context);
    }

    public static String b(String s1, String s2, Context context)
    {
        if (s1 != null && s2 != null && context != null)
        {
            return context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).getString(s1, s2);
        } else
        {
            throw new NullPointerException("Parameter can not be null.");
        }
    }

    public static void b(Context context, String s1, Long long1)
    {
        a((new StringBuilder()).append("BeautyCategory_LastModified_").append(s1).toString(), long1, context);
    }

    public static void b(String s1)
    {
        a("BaiduUserID", s1, Globals.d());
    }

    public static void b(String s1, Set set, Context context)
    {
        if (s1 == null || context == null)
        {
            throw new IllegalArgumentException("Parameter can not be null.");
        } else
        {
            context = context.getSharedPreferences("YOUCAMMAKEUP_ANDROID_SETTING", 0).edit();
            context.putStringSet(s1, set);
            context.commit();
            return;
        }
    }

    public static int c(String s1, Context context)
    {
        return b(s1, 0, context);
    }

    public static Long c(Context context, String s1, Long long1)
    {
        return b((new StringBuilder()).append("MKCategory_LastModified_").append(s1).toString(), Long.valueOf(0L), context);
    }

    public static String c()
    {
        return b("BaiduCahnnelID", Globals.d());
    }

    public static String c(String s1)
    {
        return b("LanguageCode", s1, Globals.d());
    }

    public static Set c(Context context)
    {
        return a("CostumeSeenList", new HashSet(), context);
    }

    public static void c(Context context, long l1)
    {
        a("NoticeLastModified", Long.valueOf(l1), context);
    }

    public static void c(Context context, String s1)
    {
        a("SkuLanguage", s1, context);
    }

    public static long d(Context context, long l1)
    {
        return b("NoticeLastModified", Long.valueOf(l1), context).longValue();
    }

    public static Long d(String s1, Context context)
    {
        return b(s1, Long.valueOf(0L), context);
    }

    public static String d()
    {
        return b("BaiduUserID", Globals.d());
    }

    public static void d(Context context, String s1)
    {
        a("SKU_INPUT_SECRET_ID", s1, context);
    }

    public static void d(Context context, String s1, Long long1)
    {
        a((new StringBuilder()).append("MKCategory_LastModified_").append(s1).toString(), long1, context);
    }

    public static void d(String s1)
    {
        a("SRNumberOri", s1, Globals.d());
    }

    public static float e(String s1, Context context)
    {
        return b(s1, 0.0F, context);
    }

    public static String e(Context context, String s1)
    {
        return b("SKU_INPUT_SECRET_ID", s1, context);
    }

    public static void e(Context context, long l1)
    {
        a("NoticeTotalCount", Long.valueOf(l1), context);
    }

    public static void e(String s1)
    {
        if (s1 == null)
        {
            return;
        } else
        {
            a("ABOUT_LATEST_VERSION", s1, Globals.d());
            return;
        }
    }

    public static boolean e()
    {
        return a("AmnetTrackHasSent", false, Globals.d());
    }

    public static long f(Context context, long l1)
    {
        return b("NoticeTotalCount", Long.valueOf(l1), context).longValue();
    }

    public static String f()
    {
        return b("UInstallTrackStatus", Globals.d());
    }

    public static void f(String s1)
    {
        if (s1 != null)
        {
            String s2 = b("VERSION_UPGRADE_HISTORY", Globals.d());
            if (s2.isEmpty())
            {
                a("VERSION_UPGRADE_HISTORY", s1, Globals.d());
                return;
            }
            int i1 = s2.lastIndexOf(";");
            if (i1 <= 0)
            {
                i1 = 0;
            } else
            {
                i1++;
            }
            if (!s2.substring(i1, s2.length()).equalsIgnoreCase(s1))
            {
                a("VERSION_UPGRADE_HISTORY", (new StringBuilder()).append(s2).append(";").append(s1).toString(), Globals.d());
                return;
            }
        }
    }

    public static String g()
    {
        return b("YCPInstallTrackStatus", Globals.d());
    }

    public static void g(Context context, long l1)
    {
        a("SkuStatusUpdateTime", Long.valueOf(l1), context);
    }

    public static long h(Context context, long l1)
    {
        return b("SkuStatusUpdateTime", Long.valueOf(l1), context).longValue();
    }

    public static String h()
    {
        return b("SRNumberOri", Globals.d());
    }

    public static String i()
    {
        return b("ABOUT_LATEST_VERSION", "", Globals.d());
    }

    public static boolean j()
    {
        return a("CameraInfoCollectedV2", false, Globals.d());
    }

    public static boolean k()
    {
        return a("ApplyLargePhotoFailed", false, Globals.d());
    }

    public static void l()
    {
        a("ApplyLargePhotoFailed", Boolean.valueOf(true), Globals.d());
    }

    public static void m()
    {
        a("ApplyLargePhotoFailed", Boolean.valueOf(false), Globals.d());
    }

    public static boolean n()
    {
        return a("ApplyLargePhotoFailedOnce", false, Globals.d());
    }

    public static void o()
    {
        a("ApplyLargePhotoFailedOnce", Boolean.valueOf(true), Globals.d());
    }

    public static boolean p()
    {
        return a("HAS_RUN_4_6_UPDATE", false, Globals.d());
    }

    public static boolean q()
    {
        return a("HAS_RUN_4_8_UPDATE", false, Globals.d());
    }

    public static boolean r()
    {
        return a("HAS_RUN_4_11_UPDATE", false, Globals.d());
    }

    public static void s()
    {
        a("HAS_RUN_4_6_UPDATE", Boolean.valueOf(true), Globals.d());
    }

    public static void t()
    {
        a("HAS_RUN_4_8_UPDATE", Boolean.valueOf(true), Globals.d());
    }

    public static void u()
    {
        a("HAS_RUN_4_11_UPDATE", Boolean.valueOf(true), Globals.d());
    }

    public static String v()
    {
        return b("VERSION_UPGRADE_HISTORY", Globals.d());
    }
}
