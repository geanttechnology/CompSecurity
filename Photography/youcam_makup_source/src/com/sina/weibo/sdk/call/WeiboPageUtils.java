// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.call;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

// Referenced classes of package com.sina.weibo.sdk.call:
//            WeiboIllegalParameterException, Position, CommonUtils

public final class WeiboPageUtils
{

    private WeiboPageUtils()
    {
    }

    public static void displayInWeiboMap(Context context, Position position, String s)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        String s3 = "";
        String s2 = "";
        String s1 = "";
        if (position != null)
        {
            s3 = position.getStrLongitude();
            s2 = position.getStrLatitude();
            s1 = position.getStrOffset();
        }
        openInWeiboBrowser(context, String.format("http://weibo.cn/dpool/ttt/maps.php?xy=%s,%s&amp;size=320x320&amp;offset=%s", new Object[] {
            s3, s2, s1
        }), "default", s);
    }

    public static void openInWeiboBrowser(Context context, String s, String s1, String s2)
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
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://browser");
            HashMap hashmap = new HashMap();
            hashmap.put("url", s);
            hashmap.put("sinainternalbrowser", s1);
            hashmap.put("extparam", s2);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void openQrcodeScanner(Context context, String s)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://qrcode");
            HashMap hashmap = new HashMap();
            hashmap.put("extparam", s);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void postNewWeibo(Context context, String s, String s1, String s2, Position position, String s3, String s4)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://sendweibo");
        HashMap hashmap = new HashMap();
        try
        {
            hashmap.put("content", URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        hashmap.put("poiid", s1);
        hashmap.put("poiname", s2);
        if (position != null)
        {
            hashmap.put("longitude", position.getStrLongitude());
            hashmap.put("latitude", position.getStrLatitude());
        }
        hashmap.put("pageid", s3);
        hashmap.put("extparam", s4);
        stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
    }

    public static void viewNearPhotoList(Context context, String s, String s1, Integer integer, String s2)
    {
        viewPagePhotoList(context, (new StringBuilder("100101")).append(s).append("_").append(s1).toString(), "nearphoto", "\u5468\u8FB9\u70ED\u56FE", integer, s2);
    }

    public static void viewNearbyPeople(Context context, Position position, String s)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://nearbypeople");
        HashMap hashmap = new HashMap();
        if (position != null)
        {
            hashmap.put("longitude", position.getStrLongitude());
            hashmap.put("latitude", position.getStrLatitude());
            hashmap.put("offset", position.getStrOffset());
        }
        hashmap.put("extparam", s);
        stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
    }

    public static void viewNearbyWeibo(Context context, Position position, String s)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        StringBuilder stringbuilder = new StringBuilder("sinaweibo://nearbyweibo");
        HashMap hashmap = new HashMap();
        if (position != null)
        {
            hashmap.put("longitude", position.getStrLongitude());
            hashmap.put("latitude", position.getStrLatitude());
            hashmap.put("offset", position.getStrOffset());
        }
        hashmap.put("extparam", s);
        stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
        CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
    }

    public static void viewPageDetailInfo(Context context, String s, String s1, String s2, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pagedetailinfo");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("cardid", s1);
            hashmap.put("title", s2);
            hashmap.put("extparam", s3);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPageInfo(Context context, String s, String s1, String s2)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageinfo");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("title", s1);
            hashmap.put("extparam", s2);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPagePhotoList(Context context, String s, String s1, String s2, Integer integer, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (integer != null && integer.intValue() < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pagephotolist");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("cardid", s1);
            hashmap.put("title", s2);
            hashmap.put("page", "1");
            hashmap.put("count", String.valueOf(integer));
            hashmap.put("extparam", s3);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPageProductList(Context context, String s, String s1, String s2, Integer integer, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (integer != null && integer.intValue() < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageproductlist");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("cardid", s1);
            hashmap.put("title", s2);
            hashmap.put("page", "1");
            hashmap.put("count", String.valueOf(integer));
            hashmap.put("extparam", s3);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPageUserList(Context context, String s, String s1, String s2, Integer integer, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (integer != null && integer.intValue() < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageuserlist");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("cardid", s1);
            hashmap.put("title", s2);
            hashmap.put("page", "1");
            hashmap.put("count", String.valueOf(integer));
            hashmap.put("extparam", s3);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPageWeiboList(Context context, String s, String s1, String s2, Integer integer, String s3)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("cardId\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (integer != null && integer.intValue() < 0)
        {
            throw new WeiboIllegalParameterException("count\u4E0D\u80FD\u4E3A\u8D1F\u6570");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://pageweibolist");
            HashMap hashmap = new HashMap();
            hashmap.put("pageid", s);
            hashmap.put("cardid", s1);
            hashmap.put("title", s2);
            hashmap.put("page", "1");
            hashmap.put("count", String.valueOf(integer));
            hashmap.put("extparam", s3);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewPoiPage(Context context, String s, String s1, String s2, String s3)
    {
        viewPageInfo(context, (new StringBuilder("100101")).append(s).append("_").append(s1).toString(), s2, s3);
    }

    public static void viewPoiPhotoList(Context context, String s, Integer integer, String s1)
    {
        viewPagePhotoList(context, (new StringBuilder("100101")).append(s).toString(), "nearphoto", "\u5468\u8FB9\u70ED\u56FE", integer, s1);
    }

    public static void viewUserInfo(Context context, String s, String s1, String s2)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            throw new WeiboIllegalParameterException("uid\u548Cnick\u5FC5\u987B\u81F3\u5C11\u6709\u4E00\u4E2A\u4E0D\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://userinfo");
            HashMap hashmap = new HashMap();
            hashmap.put("uid", s);
            hashmap.put("nick", s1);
            hashmap.put("extparam", s2);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void viewUsertrends(Context context, String s, String s1)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("uid\u548Cnick\u5FC5\u987B\u81F3\u5C11\u6709\u4E00\u4E2A\u4E0D\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://usertrends");
            HashMap hashmap = new HashMap();
            hashmap.put("uid", s);
            hashmap.put("extparam", s1);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }

    public static void weiboDetail(Context context, String s, String s1)
    {
        if (context == null)
        {
            throw new WeiboIllegalParameterException("context\u4E0D\u80FD\u4E3A\u7A7A");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new WeiboIllegalParameterException("pageId\u4E0D\u80FD\u4E3A\u7A7A");
        } else
        {
            StringBuilder stringbuilder = new StringBuilder("sinaweibo://detail");
            HashMap hashmap = new HashMap();
            hashmap.put("mblogid", s);
            hashmap.put("extparam", s1);
            stringbuilder.append(CommonUtils.buildUriQuery(hashmap));
            CommonUtils.openWeiboActivity(context, "android.intent.action.VIEW", stringbuilder.toString());
            return;
        }
    }
}
