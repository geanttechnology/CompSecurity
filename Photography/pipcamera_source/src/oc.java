// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import java.io.File;

public class oc
{

    private static Bitmap a(Bitmap bitmap)
    {
        Bitmap bitmap1;
        Canvas canvas;
        Paint paint;
        int j;
        int k;
label0:
        {
            j = bitmap.getWidth();
            k = bitmap.getHeight();
            int i;
            if (j > k)
            {
                i = j;
            } else
            {
                i = k;
            }
            bitmap1 = Bitmap.createBitmap(i, i, bitmap.getConfig());
            canvas = new Canvas(bitmap1);
            paint = new Paint();
            canvas.drawColor(-1);
            if (bitmap != null && !bitmap.isRecycled())
            {
                if (j <= k)
                {
                    break label0;
                }
                canvas.drawBitmap(bitmap, 0.0F, Math.abs(j - k) / 2, paint);
            }
            return bitmap1;
        }
        canvas.drawBitmap(bitmap, Math.abs(j - k) / 2, 0.0F, paint);
        return bitmap1;
    }

    public static void a(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060207);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        a(activity, bitmap, "com.facebook.katana", "Facebook", s, activity.getString(0x7f0601fd), "ShareFaceBook", activity.getString(0x7f0601fe), od1);
    }

    public static void a(Activity activity, Bitmap bitmap, String s, Object obj, od od1)
    {
        a(activity, bitmap, "jp.naver.line.android", "Line", activity.getString(0x7f060207), activity.getString(0x7f0601fd), "ShareLine", activity.getString(0x7f0601fe), od1);
    }

    protected static void a(Activity activity, Bitmap bitmap, String s, String s1, String s2, String s3, String s4, String s5, 
            od od1)
    {
        if (!a(((Context) (activity)), s))
        {
            Toast.makeText(activity, s5, 1).show();
            if (od1 != null)
            {
                od1.a(false, false);
            }
            return;
        } else
        {
            (new Handler()).postDelayed(new Runnable(activity, s, s1, s2, bitmap, od1, s4) {

                final Activity a;
                final String b;
                final String c;
                final String d;
                final Bitmap e;
                final od f;
                final String g;

                public void run()
                {
                    if (!oc.a(a, b, c, d, e, -1, -1))
                    {
                        Toast.makeText(a, d, 1).show();
                        if (f != null)
                        {
                            f.a(true, false);
                        }
                    } else
                    {
                        FlurryAgent.logEvent(g);
                        if (f != null)
                        {
                            f.a(true, true);
                            return;
                        }
                    }
                }

            
            {
                a = activity;
                b = s;
                c = s1;
                d = s2;
                e = bitmap;
                f = od1;
                g = s3;
                super();
            }
            }, 200L);
            return;
        }
    }

    public static boolean a(Activity activity, String s, String s1, String s2, Bitmap bitmap, int i, int j)
    {
        try
        {
            bitmap = Uri.fromFile(new File(yl.a("insta_share.jpg", bitmap)));
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
            Crashlytics.logException(activity);
            return false;
        }
        return true;
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
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public static void b(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060207);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        a(activity, bitmap, "com.twitter.android", "Twitter", s, activity.getString(0x7f0601fd), "ShareTwitter", activity.getString(0x7f060209), od1);
    }

    public static void b(Activity activity, Bitmap bitmap, String s, Object obj, od od1)
    {
        a(activity, bitmap, "com.qzone", "QZone", activity.getString(0x7f060206), activity.getString(0x7f0601fd), "ShareQzone", activity.getString(0x7f060204), od1);
    }

    public static void c(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060207);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        if (bitmap == null)
        {
            return;
        } else
        {
            a(activity, a(bitmap), "com.instagram.android", "Instagram", s, activity.getString(0x7f0601fd), "ShareTwitter", activity.getString(0x7f0601ff), od1);
            return;
        }
    }

    public static void c(Activity activity, Bitmap bitmap, String s, Object obj, od od1)
    {
        a(activity, bitmap, "com.tencent.mobileqq", "QZone", activity.getString(0x7f060206), activity.getString(0x7f0601fd), "ShareQQ", activity.getString(0x7f060202), od1);
    }

    public static void d(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060207);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        a(activity, bitmap, "com.tumblr", "Tumblr", s, activity.getString(0x7f0601fd), "ShareTumblr", activity.getString(0x7f060208), od1);
    }

    public static void d(Activity activity, Bitmap bitmap, String s, Object obj, od od1)
    {
        s = new of(activity);
        if (!s.b())
        {
            Toast.makeText(activity, activity.getString(0x7f06020a), 1).show();
            if (od1 != null)
            {
                od1.a(false, false);
            }
        } else
        {
            s.a(bitmap);
            FlurryAgent.logEvent("ShareWechat");
            if (od1 != null)
            {
                od1.a(true, true);
                return;
            }
        }
    }

    public static void e(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060206);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        a(activity, bitmap, "com.sina.weibo", "Sina", s, activity.getString(0x7f0601fd), "ShareSina", activity.getString(0x7f060205), od1);
    }

    public static void e(Activity activity, Bitmap bitmap, String s, Object obj, od od1)
    {
        s = new of(activity);
        if (!s.b())
        {
            Toast.makeText(activity, activity.getString(0x7f060201), 1).show();
            if (od1 != null)
            {
                od1.a(false, false);
            }
        } else
        {
            s.b(bitmap);
            FlurryAgent.logEvent("ShareWechatTimeLine");
            if (od1 != null)
            {
                od1.a(true, true);
                return;
            }
        }
    }

    public static void f(Activity activity, Bitmap bitmap, String s, Object obj, String s1, od od1)
    {
        obj = activity.getString(0x7f060206);
        s = ((String) (obj));
        if (s1 != null)
        {
            s = ((String) (obj));
            if (s1.length() > 0)
            {
                s = s1;
            }
        }
        a(activity, bitmap, "com.tencent.WBlog", "QQWeibo", s, activity.getString(0x7f0601fd), "ShareQQWeibo", activity.getString(0x7f060203), od1);
    }
}
