// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.File;

public class aty
{

    public static void a(Activity activity, String s)
    {
        a(activity, "com.sina.weibo", "Sina", s, null, 0, 0);
    }

    public static boolean a(Activity activity, String s, String s1, String s2, Bitmap bitmap, int i, int j)
    {
        Intent intent;
        try
        {
            intent = new Intent("android.intent.action.SEND");
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(boy.b("insta_share.jpg", bitmap))));
        intent.setType("image/*");
_L1:
        intent.putExtra("android.intent.extra.TITLE", s1);
        intent.putExtra("android.intent.extra.TEXT", s2);
        intent.setPackage(s);
        activity.startActivity(intent);
        return true;
        intent.setType("text/*");
          goto _L1
    }

    public static boolean a(Context context)
    {
        return atq.a(context, "com.sina.weibo");
    }

    public static void b(Activity activity, String s)
    {
        a(activity, "com.tencent.WBlog", "QWeibo", s, null, 0, 0);
    }

    public static boolean b(Context context)
    {
        return atq.a(context, "com.tencent.WBlog");
    }

    public static void c(Activity activity, String s)
    {
        a(activity, "com.renren.mobile.android", "QZone", s, null, 0, 0);
    }

    public static boolean c(Context context)
    {
        return atq.a(context, "com.renren.mobile.android");
    }

    public static void d(Activity activity, String s)
    {
        a(activity, "com.qzone", "QZone", s, null, 0, 0);
    }

    public static boolean d(Context context)
    {
        return atq.a(context, "com.qzone");
    }
}
