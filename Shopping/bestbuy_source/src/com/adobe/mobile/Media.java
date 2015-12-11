// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.adobe.mobile:
//            MediaSettings, StaticMethods, MediaAnalytics

public final class Media
{

    private static final String NO_ANALYTICS_MESSAGE = "Analytics - ADBMobile is not configured correctly to use Analytics.";

    public Media()
    {
    }

    public static MediaSettings adSettingsWith(String s, double d, String s1, String s2, String s3, double d1, 
            String s4)
    {
        return MediaSettings.adSettingsWith(s, d, s1, s2, s3, d1, s4);
    }

    public static void click(final String name, final double offset)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final String val$name;
            final double val$offset;

            public void run()
            {
                MediaAnalytics.sharedInstance().click(name, offset);
            }

            
            {
                name = s;
                offset = d;
                super();
            }
        });
    }

    public static void close(final String name)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final String val$name;

            public void run()
            {
                MediaAnalytics.sharedInstance().close(name);
            }

            
            {
                name = s;
                super();
            }
        });
    }

    public static void complete(final String name, final double offset)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final String val$name;
            final double val$offset;

            public void run()
            {
                MediaAnalytics.sharedInstance().complete(name, offset);
            }

            
            {
                name = s;
                offset = d;
                super();
            }
        });
    }

    public static void open(final MediaSettings settings, final MediaCallback callback)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final MediaCallback val$callback;
            final MediaSettings val$settings;

            public void run()
            {
                MediaAnalytics.sharedInstance().open(settings, callback);
            }

            
            {
                settings = mediasettings;
                callback = mediacallback;
                super();
            }
        });
    }

    public static void play(final String name, final double offset)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final String val$name;
            final double val$offset;

            public void run()
            {
                MediaAnalytics.sharedInstance().play(name, offset);
            }

            
            {
                name = s;
                offset = d;
                super();
            }
        });
    }

    public static MediaSettings settingsWith(String s, double d, String s1, String s2)
    {
        return MediaSettings.settingsWith(s, d, s1, s2);
    }

    public static void stop(final String name, final double offset)
    {
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final String val$name;
            final double val$offset;

            public void run()
            {
                MediaAnalytics.sharedInstance().stop(name, offset);
            }

            
            {
                name = s;
                offset = d;
                super();
            }
        });
    }

    public static void track(final String name, final Map fdata)
    {
        MediaAnalytics.sharedInstance().setTrackCalledOnItem(name);
        if (fdata != null)
        {
            fdata = new HashMap(fdata);
        } else
        {
            fdata = null;
        }
        StaticMethods.getMediaExecutor().execute(new Runnable() {

            final Map val$fdata;
            final String val$name;

            public void run()
            {
                MediaAnalytics.sharedInstance().track(name, fdata);
            }

            
            {
                name = s;
                fdata = map;
                super();
            }
        });
    }
}
