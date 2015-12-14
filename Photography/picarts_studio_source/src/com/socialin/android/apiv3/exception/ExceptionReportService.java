// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.exception;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.flurry.android.FlurryAgent;
import com.socialin.android.apiv3.model.parsers.StringParser;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.FileUtils;
import com.socialin.asyncnet.Request;
import java.io.PrintWriter;
import java.io.StringWriter;
import myobfuscated.f.m;

public class ExceptionReportService
{

    public ExceptionReportService()
    {
    }

    public static String getMoreDetails(Context context, String s)
    {
        String s1;
        String s2;
        String s3;
        String s4;
        if (m.a(context, "string", "app_name"))
        {
            s2 = context.getString(m.e(context, "app_name"));
        } else
        {
            s2 = null;
        }
        if (m.a(context, "string", "si_app_uid"))
        {
            s1 = context.getString(m.e(context, "si_app_uid"));
        } else
        {
            s1 = null;
        }
        s3 = s1;
        if (m.a(context, "string", "app_name_short"))
        {
            s3 = s1;
            if (" - ".equals(s1))
            {
                s3 = context.getString(m.e(context, "app_name_short"));
            }
        }
        if (m.a(context, "string", "app_type"))
        {
            s1 = context.getString(m.e(context, "app_type"));
        } else
        {
            s1 = null;
        }
        s4 = AnalyticUtils.getInstance(context.getApplicationContext()).getLocalTrackerData();
        return (new StringBuilder("\n\tApp Name: ")).append(s2).append("\n\tApp UID: ").append(s3).append("\n\tApp Type: ").append(s1).append("\n\tManual: true\n\tMaxMem: ").append(Runtime.getRuntime().maxMemory() / 0x100000L).append("\n\tHeap: ").append(Runtime.getRuntime().totalMemory() / 0x100000L).append("\n\tPhoneStorage: ").append(FileUtils.a(context)).append("\n\tSDcardAvailable: ").append(FileUtils.d()).append("\n\tSDcard: ").append(FileUtils.c()).append("\n\tUserId: ").append(s).append("\n\tDeviceId: ").append(context.getSharedPreferences("socialin", 0).getString("device_id", null)).append("\n\tTracker: ").append(s4).toString();
    }

    public static void report(Context context, Throwable throwable, long l)
    {
        report(context, throwable, String.valueOf(l));
    }

    public static void report(Context context, Throwable throwable, String s)
    {
        try
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            throwable.printStackTrace();
            PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String s1 = packageinfo.versionName;
            String s2 = android.os.Build.VERSION.RELEASE;
            (new Thread(s1, packageinfo.packageName, Build.MODEL, s2, stringwriter.toString(), context, s) {

                private String a;
                private String b;
                private String c;
                private String d;
                private String e;
                private Context f;
                private String g;

                public final void run()
                {
                    ExceptionReportService.sendStackTrace("http://t27.socialin.com/services/exception.php", "SocialInGames2011", a, b, c, d, e, true, ExceptionReportService.getMoreDetails(f, g));
                    try
                    {
                        Thread.sleep(1000L);
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }

            
            {
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = s4;
                f = context;
                g = s5;
                super();
            }
            }).start();
            FlurryAgent.onError("handled", throwable.getMessage(), throwable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void report(Throwable throwable)
    {
        try
        {
            StringWriter stringwriter = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stringwriter));
            throwable.printStackTrace();
            throwable = android.os.Build.VERSION.RELEASE;
            (new Thread(Build.MODEL, throwable, stringwriter.toString()) {

                private String a;
                private String b;
                private String c;

                public final void run()
                {
                    ExceptionReportService.sendStackTrace("http://t27.socialin.com/services/exception.php", "SocialInGames2011", "", "", a, b, c, true, "");
                    try
                    {
                        Thread.sleep(1000L);
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }

            
            {
                a = s;
                b = s1;
                c = s2;
                super();
            }
            }).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public static void reportString(Context context, String s, String s1)
    {
        try
        {
            PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String s2 = packageinfo.versionName;
            String s3 = android.os.Build.VERSION.RELEASE;
            (new Thread(s2, packageinfo.packageName, Build.MODEL, s3, s, getMoreDetails(context, s1)) {

                private String a;
                private String b;
                private String c;
                private String d;
                private String e;
                private String f;

                public final void run()
                {
                    ExceptionReportService.sendStackTrace("http://t27.socialin.com/services/exception.php", "SocialInGames2011", a, b, c, d, e, true, f);
                    try
                    {
                        Thread.sleep(1000L);
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }

            
            {
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = s4;
                f = s5;
                super();
            }
            }).start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void sendStackTrace(String s, String s1)
    {
        s = new Request(s, StringParser.instance(), "POST");
        s.a(s1);
        try
        {
            s.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public static void sendStackTrace(String s, String s1, String s2, String s3, String s4, String s5, String s6, boolean flag, 
            String s7)
    {
        s = new Request(s, StringParser.instance(), "POST");
        s.b("SECURITY_TOKEN", s1);
        s.b("APPLICATION_VERSION", s2);
        s.b("APPLICATION_PACKAGE", s3);
        s.b("PHONE_MODEL", s4);
        s.b("ANDROID_VERSION", s5);
        s.b("APPLICATION_STACKTRACE", s6);
        s.b("ADDITIONAL_DATA", s7);
        s.b("HANDLED_EXCEPTION", String.valueOf(flag));
        try
        {
            s.d();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }
}
