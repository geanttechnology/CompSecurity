// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.cyberlink.beautycircle.c;
import com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.CameraLandscapeActivity;
import com.cyberlink.youcammakeup.activity.ExtraDownloadCategoryActivity;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.activity.PromotionWebViewerActivity;
import com.cyberlink.youcammakeup.activity.WebViewerExActivity;
import com.cyberlink.youcammakeup.camera.o;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.kernelctrl.LiveDemoConfigHelper;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup:
//            Globals

public class g
{

    public static void a(Activity activity, String s)
    {
        c.a(activity, Long.parseLong(s), true, 0, "ymk", "howto");
    }

    public static void a(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/youcammakeup/activity/LauncherActivity);
        context.startActivity(intent);
    }

    public static void a(Context context, Uri uri)
    {
        try
        {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    public static void a(Context context, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State state, String s, String s1, Intent intent, boolean flag)
    {
        if (intent != null)
        {
            intent = new Intent(intent);
        } else
        {
            intent = new Intent();
        }
        intent.setClass(context, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
        intent.putExtra("LibraryPickerActivity_STATE", state);
        intent.putExtra("Type", s);
        intent.putExtra("Guid", s1);
        intent.putExtra("FromBC", Boolean.valueOf(flag).toString());
        context.startActivity(intent);
    }

    public static void a(Context context, com.cyberlink.youcammakeup.activity.LibraryPickerActivity.State state, String s, String s1, String s2, Intent intent)
    {
        if (intent != null)
        {
            intent = new Intent(intent);
        } else
        {
            intent = new Intent();
        }
        intent.setClass(context, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
        intent.putExtra("LibraryPickerActivity_STATE", state);
        intent.putExtra("SkuType", s);
        intent.putExtra("SkuGuid", s1);
        intent.putExtra("SkuItemGuid", s2);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, String s1, String s2)
    {
        if (!o.a())
        {
            Toast.makeText(context, 0x7f070062, 0).show();
            return;
        }
        Globals.d();
        Intent intent = new Intent();
        if (LiveDemoConfigHelper.h().d())
        {
            intent.setClass(context, com/cyberlink/youcammakeup/activity/CameraLandscapeActivity);
        } else
        {
            intent.setClass(context, com/cyberlink/youcammakeup/activity/CameraActivity);
        }
        intent.putExtra("SkuType", s);
        intent.putExtra("SkuGuid", s1);
        intent.putExtra("SkuItemGuid", s2);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, String s1, String s2, String s3, String s4, String s5, boolean flag)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/youcammakeup/activity/PromotionWebViewerActivity);
        intent.putExtra("RedirectUrl", s);
        intent.putExtra("PromotionPageID", s1);
        intent.putExtra("SourceType", s2);
        intent.putExtra("SourceId", s3);
        intent.putExtra("SkuGuid", s4);
        intent.putExtra("SkuItemGuid", s5);
        intent.putExtra("HideTopBar", flag);
        context.startActivity(intent);
    }

    public static void a(Context context, String s, String s1, String s2, boolean flag)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        intent.putExtra("RedirectUrl", s);
        intent.putExtra("SourceType", s1);
        intent.putExtra("SourceId", s2);
        intent.putExtra("HideTopBar", flag);
        context.startActivity(intent);
    }

    public static void a(Context context, ArrayList arraylist, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, String s, String s1)
    {
        Intent intent = new Intent();
        YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent.Source.a.a());
        intent.setClass(context, com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.b));
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", context.getString(0x7f070502));
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.b);
        intent.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", displaymakeuptype.ordinal());
        intent.putExtra("SourceType", s);
        intent.putExtra("SourceId", s1);
        if (arraylist != null)
        {
            intent.putStringArrayListExtra("PromoLookIds", arraylist);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, ArrayList arraylist, String s, String s1)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/youcammakeup/activity/CameraActivity);
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", CategoryType.a(CategoryType.b));
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", context.getString(0x7f070502));
        intent.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", CategoryType.b);
        intent.putExtra("SourceType", s);
        intent.putExtra("SourceId", s1);
        if (arraylist != null)
        {
            intent.putStringArrayListExtra("PromoLookIds", arraylist);
        }
        context.startActivity(intent);
    }

    public static void b(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/cyberlink/youcammakeup/activity/BeautyTipCategoryActivity);
        context.startActivity(intent);
    }
}
