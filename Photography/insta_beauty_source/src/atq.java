// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import java.io.File;

public class atq
{

    public static void a(Activity activity, Uri uri, String s, Object obj, String s1, atx atx1)
    {
        s = activity.getString(0x7f06022d);
        if (s1 != null)
        {
            s = s1;
        }
        if (uri == null)
        {
            return;
        } else
        {
            a(activity, uri, "com.instagram.android", "Instagram", s, activity.getString(0x7f060223), "ShareTwitter", activity.getString(0x7f060225), atx1);
            return;
        }
    }

    public static boolean a(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        return a(activity, bitmap, "com.facebook.katana", "Facebook", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareFaceBook", activity.getString(0x7f060224), atx1);
    }

    public static boolean a(Activity activity, Bitmap bitmap, String s, Object obj, String s1, atx atx1)
    {
        s = activity.getString(0x7f06022c);
        if (s1 != null)
        {
            s = s1;
        }
        return a(activity, bitmap, "com.sina.weibo", "Sina", s, activity.getString(0x7f060223), "ShareSina", activity.getString(0x7f06022b), atx1);
    }

    protected static boolean a(Activity activity, Bitmap bitmap, String s, String s1, String s2, String s3, String s4, String s5, 
            atx atx1)
    {
        if (!a(((Context) (activity)), s))
        {
            Toast.makeText(activity, s5, 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new att(activity, s, s1, s2, bitmap, atx1, s4), 200L);
            return true;
        }
    }

    public static boolean a(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return b(activity, uri, "jp.naver.line.android", "Line", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareLine", activity.getString(0x7f060226), atx1);
    }

    protected static boolean a(Activity activity, Uri uri, String s, String s1, String s2, String s3, String s4, String s5, 
            atx atx1)
    {
        if (!a(((Context) (activity)), s))
        {
            Toast.makeText(activity, s5, 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new atu(activity, s, s1, s2, uri, atx1, s4), 200L);
            return true;
        }
    }

    public static boolean a(Activity activity, String s, String s1, Object obj, atx atx1)
    {
        return a(activity, s, "com.facebook.katana", "Facebook", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareFaceBook", activity.getString(0x7f060224), atx1);
    }

    public static boolean a(Activity activity, String s, String s1, String s2, Bitmap bitmap, int i, int j)
    {
        try
        {
            bitmap = Uri.fromFile(new File(boy.a("insta_share.png", bitmap)));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", bitmap);
            intent.putExtra("android.intent.extra.TITLE", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.setPackage(s);
            activity.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Activity activity, String s, String s1, String s2, Uri uri)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TITLE", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.setPackage(s);
            activity.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Activity activity, String s, String s1, String s2, Uri uri, int i, int j)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.putExtra("android.intent.extra.TITLE", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.setPackage(s);
            activity.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Activity activity, String s, String s1, String s2, String s3)
    {
        try
        {
            s3 = Uri.fromFile(new File(s3));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("video/*");
            intent.putExtra("android.intent.extra.STREAM", s3);
            intent.putExtra("android.intent.extra.TITLE", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.setPackage(s);
            activity.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    protected static boolean a(Activity activity, String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            atx atx1)
    {
        if (!a(((Context) (activity)), s1))
        {
            Toast.makeText(activity, s6, 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new atw(activity, s1, s2, s3, s, atx1, s5), 200L);
            return true;
        }
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        return a(activity, bitmap, "com.twitter.android", "Twitter", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareTwitter", activity.getString(0x7f06022f), atx1);
    }

    public static boolean b(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return b(activity, uri, "com.instagram.android", "Instagram", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareTwitter", activity.getString(0x7f060225), atx1);
    }

    public static boolean b(Activity activity, Uri uri, String s, Object obj, String s1, atx atx1)
    {
        s = activity.getString(0x7f06022c);
        if (s1 != null)
        {
            s = s1;
        }
        return a(activity, uri, "com.sina.weibo", "Sina", s, activity.getString(0x7f060223), "ShareSina", activity.getString(0x7f06022b), atx1);
    }

    protected static boolean b(Activity activity, Uri uri, String s, String s1, String s2, String s3, String s4, String s5, 
            atx atx1)
    {
        if (!a(activity, s))
        {
            Toast.makeText(activity, s5, 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new atv(activity, s, s1, s2, uri, atx1, s4), 200L);
            return true;
        }
    }

    public static boolean b(Activity activity, String s, String s1, Object obj, atx atx1)
    {
        return a(activity, s, "com.tencent.mm", "Wechat", activity.getString(0x7f06022c), activity.getString(0x7f060223), "ShareWechat", activity.getString(0x7f060230), atx1);
    }

    public static boolean c(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        return a(activity, bitmap, "com.instagram.android", "Instagram", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareTwitter", activity.getString(0x7f060225), atx1);
    }

    public static boolean c(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return b(activity, uri, "com.tencent.mobileqq", "QZone", activity.getString(0x7f06022c), activity.getString(0x7f060223), "ShareQQ", activity.getString(0x7f060228), atx1);
    }

    public static boolean d(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        return a(activity, bitmap, "com.tumblr", "Tumblr", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareTumblr", activity.getString(0x7f06022e), atx1);
    }

    public static boolean d(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return a(activity, uri, "jp.naver.line.android", "Line", activity.getString(0x7f06022d), activity.getString(0x7f060223), "ShareLine", activity.getString(0x7f060226), atx1);
    }

    public static boolean e(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        s = new atz(activity);
        if (!s.b())
        {
            Toast.makeText(activity, activity.getString(0x7f060230), 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new atr(s, bitmap, atx1), 200L);
            return true;
        }
    }

    public static boolean e(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return a(activity, uri, "com.qzone", "QZone", activity.getString(0x7f06022c), activity.getString(0x7f060223), "ShareQzone", activity.getString(0x7f06022a), atx1);
    }

    public static boolean f(Activity activity, Bitmap bitmap, String s, Object obj, atx atx1)
    {
        s = new atz(activity);
        if (!s.b())
        {
            Toast.makeText(activity, activity.getString(0x7f060227), 1).show();
            if (atx1 != null)
            {
                atx1.a(false, false);
            }
            return false;
        } else
        {
            (new Handler()).postDelayed(new ats(s, bitmap, atx1), 200L);
            return true;
        }
    }

    public static boolean f(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return a(activity, uri, "com.tencent.mobileqq", "QZone", activity.getString(0x7f06022c), activity.getString(0x7f060223), "ShareQQ", activity.getString(0x7f060228), atx1);
    }

    public static boolean g(Activity activity, Uri uri, String s, Object obj, atx atx1)
    {
        return a(activity, uri, "com.tencent.WBlog", "QQWeibo", activity.getString(0x7f06022c), activity.getString(0x7f060223), "ShareQQWeibo", activity.getString(0x7f060229), atx1);
    }
}
