// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.share:
//            SocialAppConfig, SharableAppInfo, WechatSDKManager

public class SharableAppInfoManager
{

    private static ArrayList sAppInfoList = new ArrayList();
    private static int sInterestedApps = 0;
    private static String sPackageName = null;
    private static Map sStaticAppConfigs = SocialAppConfig.getStaticConfig();
    private static boolean sTimelineIconAdded = false;

    public SharableAppInfoManager()
    {
    }

    public static List collectAppInfo(Activity activity)
    {
        if (sAppInfoList.size() > 0)
        {
            sAppInfoList.clear();
            sInterestedApps = 0;
            sTimelineIconAdded = false;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        PackageManager packagemanager = activity.getPackageManager();
        Iterator iterator = packagemanager.queryIntentActivities(intent, 0).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
            if (!resolveinfo.activityInfo.name.equals(SocialAppConfig.getWechatAddFavoriteActivityName()))
            {
                String s = resolveinfo.activityInfo.packageName;
                Object obj = SocialAppConfig.getDefaultRefTag();
                int i = SocialAppConfig.getDefaultPriority();
                Iterator iterator1 = sStaticAppConfigs.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Object obj1 = (String)iterator1.next();
                    if (s.contains(((CharSequence) (obj1))))
                    {
                        obj1 = (SocialAppConfig)sStaticAppConfigs.get(obj1);
                        obj = ((SocialAppConfig) (obj1)).getRefTag();
                        i = ((SocialAppConfig) (obj1)).getPriority();
                    }
                } while (true);
                obj = new SharableAppInfo(resolveinfo.loadLabel(packagemanager), null, s, ((String) (obj)), i, resolveinfo);
                sAppInfoList.add(obj);
                if (i != SocialAppConfig.getDefaultPriority())
                {
                    sInterestedApps++;
                }
                if (s.equals(SocialAppConfig.getWechatPackageName()) && WechatSDKManager.timelineSupported(activity) && !sTimelineIconAdded && isCnMshopPackage(activity))
                {
                    SharableAppInfo sharableappinfo = SocialAppConfig.buildWechatTimelineInfo(activity, resolveinfo);
                    if (sharableappinfo != null)
                    {
                        sAppInfoList.add(sharableappinfo);
                        sInterestedApps++;
                        sTimelineIconAdded = true;
                    }
                }
            }
        } while (true);
        Collections.sort(sAppInfoList);
        return sAppInfoList;
    }

    public static int getNumberOfInterestedApps()
    {
        return sInterestedApps;
    }

    public static boolean isCnMshopPackage(Context context)
    {
        if (sPackageName == null)
        {
            sPackageName = context.getPackageName();
        }
        return sPackageName.equalsIgnoreCase("cn.amazon.mShop.android");
    }

    public static void logClickRefMarker(SharableAppInfo sharableappinfo)
    {
        String s;
        if (sharableappinfo.getPackageName().contains(SocialAppConfig.getEmailPackageId()))
        {
            s = "cm_:sw_em_cl_%1s";
        } else
        {
            s = "cm_:sw_cl_%1s";
        }
        RefMarkerObserver.logRefMarker(String.format(s, new Object[] {
            sharableappinfo.getRefTag()
        }));
    }

    public static void replaceRefMarker(Intent intent, SharableAppInfo sharableappinfo)
    {
        String s;
        for (s = intent.getStringExtra("android.intent.extra.TEXT"); Util.isEmpty(s) || s.indexOf("ref=cm_sw_r_") <= 0;)
        {
            return;
        }

        StringBuilder stringbuilder = new StringBuilder(s.substring(0, s.lastIndexOf("ref=cm_sw_r_")));
        stringbuilder.append("ref=");
        if (sharableappinfo.getPackageName().contains(SocialAppConfig.getEmailPackageId()))
        {
            s = "cm_sw_em_r_%1s";
        } else
        {
            s = "cm_sw_r_%1s";
        }
        stringbuilder.append(String.format(s, new Object[] {
            sharableappinfo.getRefTag()
        }));
        stringbuilder.append("?ie=UTF8");
        intent.putExtra("android.intent.extra.TEXT", stringbuilder.toString());
    }

}
