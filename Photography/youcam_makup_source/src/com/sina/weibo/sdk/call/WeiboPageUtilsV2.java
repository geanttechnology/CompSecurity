// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

// Referenced classes of package com.sina.weibo.sdk.call:
//            WeiboIllegalParameterException, CommonUtils

public final class WeiboPageUtilsV2
{

    private WeiboPageUtilsV2()
    {
    }

    public static void displayInWeiboMap(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        String s = "";
        String s1;
        String s2;
        String s3;
        Object obj;
        if (hashmap != null)
        {
            s2 = (String)hashmap.get("longitude");
            s1 = (String)hashmap.get("latitude");
            s = (String)hashmap.get("offset");
        } else
        {
            s1 = "";
            s2 = "";
        }
        obj = null;
        s3 = obj;
        if (hashmap != null)
        {
            s3 = obj;
            if (!TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
            {
                s3 = (String)hashmap.get("packagename");
            }
        }
        if (hashmap != null)
        {
            openInWeiboBrowser(context, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] {
                s2, s1, s
            }), "default", (String)hashmap.get("extparam"), s3);
        }
    }

    public static void openInWeiboBrowser(Context context, String s, String s1, String s2, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("url\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (!TextUtils.isEmpty(s1) && !"topnav".equals(s1) && !"default".equals(s1) && !"fullscreen".equals(s1))
        {
            throw new WeiboIllegalParameterException("sinainternalbrowser\u4E0D\u5408\u6CD5");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://browser");
        HashMap hashmap = new HashMap();
        hashmap.put("url", s);
        hashmap.put("sinainternalbrowser", s1);
        hashmap.put("extparam", s2);
        stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        if (!TextUtils.isEmpty(s3))
        {
            s = new StringBuilder("sinaweibo://browser");
            if (hashmap != null)
            {
                s.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), s3);
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void openQrcodeScanner(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://qrcode");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://qrcode");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void postNewWeibo(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://sendweibo");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://sendweibo");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewNearbyPeople(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://nearbypeople");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://nearbypeople");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewNearbyWeibo(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://nearbyweibo");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://nearbyweibo");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPageDetailInfo(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("cardid")))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pagedetailinfo");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pagedetailinfo");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPageInfo(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null || TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageinfo");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pageinfo");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPagePhotoList(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("cardid")))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        int i;
        try
        {
            i = Integer.parseInt((String)hashmap.get("count"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = -1;
        }
        if (i < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pagephotolist");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pagephotolist");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPageProductList(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("cardid")))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        int i;
        try
        {
            i = Integer.parseInt((String)hashmap.get("count"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = -1;
        }
        if (i < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageproductlist");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pageproductlist");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPageUserList(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("cardid")))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        int i;
        try
        {
            i = Integer.parseInt((String)hashmap.get("count"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = -1;
        }
        if (i < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageuserlist");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pageuserlist");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewPageWeiboList(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("pageid")))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("cardid")))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        int i;
        try
        {
            i = Integer.parseInt((String)hashmap.get("count"));
        }
        catch (NumberFormatException numberformatexception)
        {
            i = -1;
        }
        if (i < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageweibolist");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://pageweibolist");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewUserInfo(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null || TextUtils.isEmpty((CharSequence)hashmap.get("uid")) && TextUtils.isEmpty((CharSequence)hashmap.get("nick")))
        {
            throw new WeiboIllegalParameterException("uid\u548Cnick\u5FC5\u987B\u81F3\u5C11\u6709\u4E00\u4E2A\u4E0D\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://userinfo");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://userinfo");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void viewUsertrends(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null || TextUtils.isEmpty((CharSequence)hashmap.get("uid")))
        {
            throw new WeiboIllegalParameterException("uid\u548Cnick\u5FC5\u987B\u81F3\u5C11\u6709\u4E00\u4E2A\u4E0D\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://usertrends");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://usertrends");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }

    public static void weiboDetail(Context context, HashMap hashmap)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (hashmap == null)
        {
            throw new WeiboIllegalParameterException("mblogId(\u5FAE\u535Aid)\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty((CharSequence)hashmap.get("mblogid")))
        {
            throw new WeiboIllegalParameterException("mblogId(\u5FAE\u535Aid)\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://detail");
        if (hashmap != null)
        {
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        }
        if (hashmap != null && !TextUtils.isEmpty((CharSequence)hashmap.get("packagename")))
        {
            StringBuilder stringbuilder1 = new StringBuilder("sinaweibo://detail");
            if (hashmap != null)
            {
                stringbuilder1.append(CommonUtils.buildUriQuery(hashmap));
            }
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), (String)hashmap.get("packagename"));
            return;
        } else
        {
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString(), null);
            return;
        }
    }
}
