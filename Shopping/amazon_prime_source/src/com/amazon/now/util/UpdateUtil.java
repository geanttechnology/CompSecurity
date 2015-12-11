// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amazon.now.AmazonActivity;

public class UpdateUtil
{
    private static final class AppStore extends Enum
    {

        private static final AppStore $VALUES[];
        public static final AppStore AMAZON_APP_STORE;
        public static final AppStore GOOGLE_PLAY;
        public static final AppStore OTHER;

        public static AppStore valueOf(String s)
        {
            return (AppStore)Enum.valueOf(com/amazon/now/util/UpdateUtil$AppStore, s);
        }

        public static AppStore[] values()
        {
            return (AppStore[])$VALUES.clone();
        }

        static 
        {
            GOOGLE_PLAY = new AppStore("GOOGLE_PLAY", 0);
            AMAZON_APP_STORE = new AppStore("AMAZON_APP_STORE", 1);
            OTHER = new AppStore("OTHER", 2);
            $VALUES = (new AppStore[] {
                GOOGLE_PLAY, AMAZON_APP_STORE, OTHER
            });
        }

        private AppStore(String s, int i)
        {
            super(s, i);
        }
    }


    public UpdateUtil()
    {
    }

    private static AppStore getAppStore(Context context, String s)
    {
        context = context.getPackageManager().getInstallerPackageName(s);
        if ("com.amazon.venezia".equalsIgnoreCase(context))
        {
            return AppStore.AMAZON_APP_STORE;
        }
        if ("com.android.vending".equalsIgnoreCase(context))
        {
            return AppStore.GOOGLE_PLAY;
        } else
        {
            return AppStore.OTHER;
        }
    }

    private static void launchAmazonAppStore(Context context, String s)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("amzn://apps/android?p=").append(s).toString())));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format(context.getString(0x7f070069), new Object[] {
                s
            }))));
        }
    }

    public static boolean launchAppStore(AmazonActivity amazonactivity)
    {
        String s = amazonactivity.getPackageName();
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[];

            static 
            {
                $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore = new int[AppStore.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[AppStore.GOOGLE_PLAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[AppStore.AMAZON_APP_STORE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$now$util$UpdateUtil$AppStore[AppStore.OTHER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.now.util.UpdateUtil.AppStore[getAppStore(amazonactivity, s).ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            launchGooglePlay(amazonactivity, s);
            return true;

        case 2: // '\002'
            launchAmazonAppStore(amazonactivity, s);
            return true;

        case 3: // '\003'
            return false;
        }
    }

    private static void launchGooglePlay(Context context, String s)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString())));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.format(context.getString(0x7f0700c5), new Object[] {
                s
            }))));
        }
    }
}
