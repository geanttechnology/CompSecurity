// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.share:
//            SharableAppInfo

public class SocialAppConfig
{

    private static final String STATIC_CONFIG_PACKAGE_IDS[] = {
        "com.sina.weibo", "com.tencent.mm.timeline", "com.tencent.mm", "com.qzone", "com.tencent.WBlog", "com.douban.shuo", "com.renren", "com.kaixin001.activity", "email", "com.android.mms"
    };
    private static final int STATIC_CONFIG_PRIORITIES[] = {
        20, 25, 30, 40, 100, 100, 100, 100, 85, 90
    };
    private static final String STATIC_CONFIG_REFTAGS[] = {
        "si_upd_awd_weibo", "we_upd_awd_wechat", "we_upd_awd_wechat", "qz_upd_awd_qzone", "tc_upd_awd_wblog", "db_upd_awd_douban", "re_upd_awd_renren", "kx_upd_awd_kaixin", "upd_awd_email", "other_upd_awd_sms"
    };
    private static Map sAppConfigMap;
    private int mPriority;
    private String mRefTag;

    public SocialAppConfig(String s, int i)
    {
        mRefTag = s;
        mPriority = i;
    }

    public static SharableAppInfo buildWechatTimelineInfo(Context context, ResolveInfo resolveinfo)
    {
        if (!sAppConfigMap.containsKey("com.tencent.mm.timeline"))
        {
            return null;
        } else
        {
            SocialAppConfig socialappconfig = (SocialAppConfig)sAppConfigMap.get("com.tencent.mm.timeline");
            return new SharableAppInfo(context.getResources().getString(com.amazon.mShop.android.lib.R.string.sharing_friends), context.getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.tencent_timeline), "com.tencent.mm.timeline", socialappconfig.getRefTag(), socialappconfig.getPriority(), resolveinfo);
        }
    }

    public static int getDefaultPriority()
    {
        return 100;
    }

    public static String getDefaultRefTag()
    {
        return "other_upd_awd_other";
    }

    public static String getEmailPackageId()
    {
        return "email";
    }

    public static Map getStaticConfig()
    {
        com/amazon/mShop/share/SocialAppConfig;
        JVM INSTR monitorenter ;
        if (sAppConfigMap != null) goto _L2; else goto _L1
_L1:
        int j;
        sAppConfigMap = new HashMap();
        j = Math.min(Math.min(STATIC_CONFIG_PACKAGE_IDS.length, STATIC_CONFIG_PRIORITIES.length), STATIC_CONFIG_REFTAGS.length);
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        SocialAppConfig socialappconfig = new SocialAppConfig(STATIC_CONFIG_REFTAGS[i], STATIC_CONFIG_PRIORITIES[i]);
        sAppConfigMap.put(STATIC_CONFIG_PACKAGE_IDS[i], socialappconfig);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        Map map = sAppConfigMap;
        com/amazon/mShop/share/SocialAppConfig;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getWechatAddFavoriteActivityName()
    {
        return "com.tencent.mm.ui.tools.AddFavoriteUI";
    }

    public static String getWechatPackageName()
    {
        return "com.tencent.mm";
    }

    public static String getWechatTimelinePackageName()
    {
        return "com.tencent.mm.timeline";
    }

    public int getPriority()
    {
        return mPriority;
    }

    public String getRefTag()
    {
        return mRefTag;
    }

}
