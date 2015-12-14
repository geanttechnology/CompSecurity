// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.SponsorAdActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.pages.moreview.ag;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
{

    public static void a(String s, Activity activity, Intent intent)
    {
        if (s.indexOf(ag.b) == 0 || s.indexOf(ag.a) == 0)
        {
            intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.b));
            intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f070502));
            intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.b);
        } else
        {
            if (s.indexOf(ag.c) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.c));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f0703e1));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.c);
                return;
            }
            if (s.indexOf(ag.h) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.i));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07008c));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.i);
                return;
            }
            if (s.indexOf(ag.i) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.m));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f0704fd));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.m);
                return;
            }
            if (s.indexOf(ag.d) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.d));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07033c));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.d);
                return;
            }
            if (s.indexOf(ag.e) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.e));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07033b));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.e);
                return;
            }
            if (s.indexOf(ag.f) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.f));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07033a));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.f);
                return;
            }
            if (s.indexOf(ag.g) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.o));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f070501));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.o);
                return;
            }
            if (e(s))
            {
                intent.putExtra("URL_CONTENT", com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.GetPromotionBannerResponse.PromotionBanner.a(s));
                return;
            }
            if (s.indexOf(ag.j) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.j));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07008d));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.j);
                intent.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", true);
                return;
            }
            if (s.indexOf(ag.k) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.k));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07008e));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.k);
                intent.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", true);
                return;
            }
            if (s.indexOf(ag.l) == 0)
            {
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.l));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", activity.getString(0x7f07008b));
                intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.l);
                intent.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", true);
                return;
            }
        }
    }

    public static boolean a(String s)
    {
        return s.indexOf("ymk://") == 0;
    }

    public static void b(String s, Activity activity, Intent intent)
    {
        Object obj;
        String s3;
        s3 = null;
        obj = null;
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        Object obj3;
        if (s.indexOf("market://") == 0 || s.indexOf("http://") == 0 || s.indexOf("https://") == 0)
        {
            s = new Intent("android.intent.action.VIEW", f(s));
            try
            {
                activity.startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            return;
        }
        Object obj2;
        String s5;
        try
        {
            obj1 = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        s5 = ((Uri) (obj1)).getScheme();
        obj3 = ((Uri) (obj1)).getHost();
        obj2 = ((Uri) (obj1)).getPathSegments();
        if (obj3 == null || !s5.equals(activity.getString(0x7f070742)))
        {
            break MISSING_BLOCK_LABEL_1161;
        }
        if (((String) (obj3)).equals(activity.getString(0x7f0707bb)))
        {
            g.a(activity);
            return;
        }
        if (((String) (obj3)).equals(activity.getString(0x7f0707c0)))
        {
            intent = ((Uri) (obj1)).getQueryParameter("SourceType");
            obj = ((Uri) (obj1)).getQueryParameter("SourceId");
            s3 = ((Uri) (obj1)).getQueryParameter("SkuId");
            String s6 = ((Uri) (obj1)).getQueryParameter("SkuItemGuid");
            boolean flag = ((Uri) (obj1)).getBooleanQueryParameter("HideTopBar", true);
            s = "";
            obj1 = ((Uri) (obj1)).getQueryParameter("ECShoppingUrl");
            h.b().v(s3, ((String) (obj1)));
            if (obj2 != null)
            {
                s = (String)((List) (obj2)).get(0);
            }
            if (s.length() > 0)
            {
                g.a(activity, null, s, intent, ((String) (obj)), s3, s6, flag);
                return;
            } else
            {
                Log.e("ActionUrlHelper", "PromotionId is empty!!");
                return;
            }
        }
        if (((String) (obj3)).equals(activity.getString(0x7f0707c2)))
        {
            s = "";
            if (obj2 != null)
            {
                s = (String)((List) (obj2)).get(0);
            }
            intent = ((Uri) (obj1)).getQueryParameter("SkuGuid");
            obj = ((Uri) (obj1)).getQueryParameter("SkuItemGuid");
            s3 = ((Uri) (obj1)).getQueryParameter("ECShoppingUrl");
            h.b().v(intent, s3);
            g.a(activity, s, intent, ((String) (obj)));
            return;
        }
        if (((String) (obj3)).equals(activity.getString(0x7f0707be)))
        {
            String s7;
            if (obj2 != null)
            {
                s = (String)((List) (obj2)).get(0);
            } else
            {
                s = "";
            }
            obj = new com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State("editView");
            s3 = ((Uri) (obj1)).getQueryParameter("SkuGuid");
            obj2 = ((Uri) (obj1)).getQueryParameter("SkuItemGuid");
            s7 = ((Uri) (obj1)).getQueryParameter("Guid");
            obj1 = ((Uri) (obj1)).getQueryParameter("ECShoppingUrl");
            h.b().v(s3, ((String) (obj1)));
            if (s3 != null)
            {
                g.a(activity, ((com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State) (obj)), s, s3, ((String) (obj2)), intent);
            } else
            {
                g.a(activity, ((com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State) (obj)), s, s7, intent, true);
            }
            s = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.o);
            if (s != null)
            {
                s.finish();
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj3)).equals(activity.getString(0x7f0707bf)))
        {
            intent = ((Uri) (obj1)).getQueryParameter("SourceType");
            s3 = ((Uri) (obj1)).getQueryParameter("SourceId");
            String s4 = ((Uri) (obj1)).getQueryParameter("Type");
            if (s4 != null)
            {
                com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.a;
                obj3 = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.c;
                com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype1 = com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType.b;
                List list = Arrays.asList(new String[] {
                    "Look", "Look_Live", "Look_Edit"
                });
                if (list.contains(s4))
                {
                    obj1 = ((Uri) (obj1)).getQueryParameters("Guid");
                    s = ((String) (obj));
                    if (obj1 != null)
                    {
                        s = new ArrayList(((List) (obj1)).size());
                        s.addAll(((java.util.Collection) (obj1)));
                    }
                    int i = list.indexOf(s4);
                    obj = (new com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType[] {
                        displaymakeuptype, obj3, displaymakeuptype1
                    })[i];
                    BeautifierManager.a();
                    g.a(activity, s, ((com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType) (obj)), intent, s3);
                    return;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj3)).equals(activity.getString(0x7f0707c1))) goto _L4; else goto _L3
_L3:
        s = ((Uri) (obj1)).getQueryParameter("RedirectUrl");
        intent = URLDecoder.decode(s, "UTF-8");
        s = intent;
_L5:
        intent = ((Uri) (obj1)).getQueryParameter("SourceType");
        String s1 = ((Uri) (obj1)).getQueryParameter("SourceId");
        boolean flag1 = ((Uri) (obj1)).getBooleanQueryParameter("HideTopBar", false);
        if (s != null)
        {
            g.a(activity, s, intent, s1, flag1);
            return;
        }
        continue; /* Loop/switch isn't completed */
        intent;
        intent.printStackTrace();
        if (true) goto _L5; else goto _L4
_L4:
        if (((String) (obj3)).equals(activity.getString(0x7f0707bd)))
        {
            g.b(activity);
            return;
        }
        if (!((String) (obj3)).equals(activity.getString(0x7f0707bc)))
        {
            break; /* Loop/switch isn't completed */
        }
        intent = ((Uri) (obj1)).getQueryParameter("SourceType");
        String s2 = ((Uri) (obj1)).getQueryParameter("SourceId");
        s = ((Uri) (obj1)).getQueryParameter("Type");
        if (s != null && s.equals("Look_Live"))
        {
            obj1 = ((Uri) (obj1)).getQueryParameters("Guid");
            s = s3;
            if (obj1 != null)
            {
                s = new ArrayList(((List) (obj1)).size());
                s.addAll(((java.util.Collection) (obj1)));
            }
            g.a(activity, s, intent, s2);
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
        if (s.indexOf(ag.b) != 0 && s.indexOf(ag.a) != 0 && s.indexOf(ag.c) != 0 && s.indexOf(ag.h) != 0 && s.indexOf(ag.i) != 0 && s.indexOf(ag.j) != 0 && s.indexOf(ag.k) != 0 && s.indexOf(ag.l) != 0) goto _L8; else goto _L7
_L7:
        BeautifierManager.a();
        if (s.indexOf(ag.a) != 0) goto _L10; else goto _L9
_L9:
        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.b.a());
_L11:
        intent = new Intent(activity, com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
        a(s, activity, intent);
        activity.startActivity(intent);
        return;
_L10:
        if (s.indexOf(ag.c) == 0)
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.c.a());
        }
        if (true) goto _L11; else goto _L8
_L8:
        if (s.indexOf(ag.d) == 0 || s.indexOf(ag.e) == 0 || s.indexOf(ag.f) == 0 || s.indexOf(ag.g) == 0 || s.indexOf(ag.j) == 0 || s.indexOf(ag.k) == 0 || s.indexOf(ag.l) == 0)
        {
            BeautifierManager.a();
            intent = new Intent(activity, com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
            a(s, activity, intent);
            activity.startActivity(intent);
            return;
        }
        if (e(s))
        {
            BeautifierManager.a();
            intent = new Intent(activity, com/cyberlink/youcammakeup/activity/SponsorAdActivity);
            a(s, activity, intent);
            activity.startActivity(intent);
            return;
        } else
        {
            g.a(activity, ((Uri) (obj1)));
            return;
        }
        g.a(activity, ((Uri) (obj1)));
        return;
    }

    public static boolean b(String s)
    {
        return s.indexOf("ymk://promotion_page") == 0;
    }

    public static boolean c(String s)
    {
        return s.indexOf("ymk://sponsor") == 0;
    }

    public static String d(String s)
    {
        if (!b(s))
        {
            return "none";
        }
        try
        {
            s = s.substring(s.lastIndexOf("/") + 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "none";
        }
        return s;
    }

    private static boolean e(String s)
    {
        Object obj = new ArrayList();
        ((List) (obj)).add("ymk://blush");
        ((List) (obj)).add("ymk://eye_brow");
        ((List) (obj)).add("ymk://eye_contact");
        ((List) (obj)).add("ymk://eye_lash");
        ((List) (obj)).add("ymk://eye_line");
        ((List) (obj)).add("ymk://eye_shadow");
        ((List) (obj)).add("ymk://lipstick");
        ((List) (obj)).add("ymk://skin_toner");
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            if (s.indexOf((String)((Iterator) (obj)).next()) == 0)
            {
                return true;
            }
        }

        return false;
    }

    private static Uri f(String s)
    {
        return Uri.parse(s);
    }
}
