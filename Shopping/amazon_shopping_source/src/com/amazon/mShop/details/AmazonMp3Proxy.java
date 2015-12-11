// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

// Referenced classes of package com.amazon.mShop.details:
//            FriendAppProxy

public class AmazonMp3Proxy extends FriendAppProxy
{

    private static final AmazonMp3Proxy instance = new AmazonMp3Proxy();

    public AmazonMp3Proxy()
    {
    }

    public static AmazonMp3Proxy getInstance()
    {
        return instance;
    }

    public String getButtonLabel(Context context)
    {
        if (isFriendAppInstalled(context))
        {
            if (needFriendAppUpdate(context))
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_update_amazon_mp3_to_buy);
            } else
            {
                return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_buy_now_from_amazon_mp3);
            }
        } else
        {
            return context.getResources().getString(com.amazon.mShop.android.lib.R.string.buy_box_install_amazon_mp3_to_buy);
        }
    }

    protected Intent getIntentForStart(Context context, ProductController productcontroller)
    {
        return getIntentForStart(context, productcontroller.getGroupId(), productcontroller.getAsin());
    }

    protected Intent getIntentForStart(Context context, String s)
    {
        s = Uri.parse(s.toLowerCase());
        String s1 = s.getQueryParameter("asin");
        if (Util.isEmpty(s1))
        {
            UIUtils.info(context, com.amazon.mShop.android.lib.R.string.error_can_not_find_product);
            return null;
        }
        s = s.getQueryParameter("type");
        if ("album".equalsIgnoreCase(s))
        {
            s = "digital_music_album_display_on_website";
        } else
        if ("track".equalsIgnoreCase(s))
        {
            s = "digital_music_track_display_on_website";
        } else
        {
            s = "digital_music_artist_display_on_website";
        }
        return getIntentForStart(context, s, s1);
    }

    public Intent getIntentForStart(Context context, String s, String s1)
    {
        Intent intent = new Intent();
        if ("digital_music_album_display_on_website".equals(s))
        {
            intent.setAction("com.amazon.mp3.action.EXTERNAL_EVENT");
            intent.putExtra("com.amazon.mp3.extra.EXTERNAL_EVENT_TYPE", "com.amazon.mp3.type.SHOW_ALBUM_DETAIL");
            intent.putExtra("com.amazon.mp3.extra.ALBUM_ASIN", s1);
        } else
        {
            intent.setAction("com.amazon.mp3.action.EXTERNAL_EVENT");
            intent.putExtra("com.amazon.mp3.extra.EXTERNAL_EVENT_TYPE", "com.amazon.mp3.type.SEARCH");
            intent.putExtra("com.amazon.mp3.extra.SEARCH_STRING", s1);
            intent.putExtra("com.amazon.mp3.extra.SEARCH_TYPE", 0);
        }
        addRefTag(context, intent);
        return intent;
    }

    protected String getPackageName(Context context)
    {
        return context.getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_mp3_package_name);
    }

    protected String getRefTag()
    {
        return "mp3";
    }

    protected boolean needFriendAppUpdate(Context context)
    {
        Method method;
        Intent intent;
        String s;
        intent = new Intent();
        s = getPackageName(context);
        method = null;
        Method method1 = android/content/Intent.getMethod("setPackage", new Class[] {
            java/lang/String
        });
        method = method1;
_L1:
        Object obj;
        if (method != null)
        {
            try
            {
                method.invoke(intent, new Object[] {
                    s
                });
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.d("AmazonMp3Proxy.needFriendAppUpdate", illegalargumentexception.getMessage());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.d("AmazonMp3Proxy.needFriendAppUpdate", illegalaccessexception.getMessage());
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.d("AmazonMp3Proxy.needFriendAppUpdate", invocationtargetexception.getMessage());
            }
        }
        intent.setAction("com.amazon.mp3.action.EXTERNAL_EVENT");
        context = context.getPackageManager().queryIntentActivities(intent, 64);
        return context == null || context.size() <= 0;
        obj;
        Log.d("AmazonMp3Proxy.needFriendAppUpdate", ((SecurityException) (obj)).getMessage());
          goto _L1
        obj;
        Log.d("AmazonMp3Proxy.needFriendAppUpdate", ((NoSuchMethodException) (obj)).getMessage());
          goto _L1
    }

}
