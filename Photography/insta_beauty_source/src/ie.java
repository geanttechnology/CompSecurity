// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;

public class ie
{

    public static String a = "com.instamag.activity";
    public static String b = "com.wantu.activity";
    public static String c = "com.fotoable.fotobeauty";
    public static String d = "com.hicollage.activity";
    public static String e = "com.pipcamera.activity";
    public static String f = "com.fotoable.helpr";
    public static String g = "com.pintu.activity";
    public static String h = "com.fotoable.read";
    public static String i = "com.fotoable.girls";
    public static String j = "com.fotoable.photoeditor";
    public static String k = "com.fotoable.makeup";
    public static String l = "com.fotoable.photocollage";
    public static String m = "com.fotoable.locker";

    public static String a(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("market://"))
            {
                s1 = s.substring(s.lastIndexOf("=") + 1);
            }
        }
        return s1;
    }

    public static void a(Context context, String s)
    {
        String s1;
        if (context == null)
        {
            return;
        }
        s1 = a(s);
        Object obj;
        Object obj1;
        if (!yp.a(context, "com.android.vending"))
        {
            break MISSING_BLOCK_LABEL_215;
        }
        obj1 = Uri.parse((new StringBuilder()).append("market://details?id=").append(s1).toString());
        obj = new Intent("android.intent.action.MAIN");
        ((Intent) (obj)).setPackage("com.android.vending");
        ((Intent) (obj)).addCategory("android.intent.category.LAUNCHER");
        obj = ((Intent) (obj)).resolveActivity(context.getPackageManager());
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = null;
_L1:
        try
        {
            obj1 = new Intent("android.intent.action.VIEW", ((Uri) (obj1)));
            if (!(context instanceof Activity))
            {
                ((Intent) (obj1)).addFlags(0x10000000);
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s1).toString()));
                if (!(context instanceof Activity))
                {
                    s.addFlags(0x10000000);
                }
                context.startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Crashlytics.logException(context);
            }
            return;
        }
        catch (Exception exception)
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s).toString()));
            if (!(context instanceof Activity))
            {
                s.addFlags(0x10000000);
            }
            context.startActivity(s);
            Crashlytics.logException(exception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        if (!((String) (obj)).equals("") && !((String) (obj)).equals("null"))
        {
            ((Intent) (obj1)).setClassName("com.android.vending", ((String) (obj)));
        }
        context.startActivity(((Intent) (obj1)));
        return;
        obj = ((ComponentName) (obj)).getClassName();
          goto _L1
        obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s1).toString()));
        if (!(context instanceof Activity))
        {
            ((Intent) (obj)).addFlags(0x10000000);
        }
        context.startActivity(((Intent) (obj)));
        return;
    }

}
