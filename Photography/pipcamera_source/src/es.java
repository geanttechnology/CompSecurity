// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.crashlytics.android.Crashlytics;

public class es
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

    public static void a(Context context, String s)
    {
        Object obj;
        if (context == null)
        {
            return;
        }
        obj = s;
        if (s.startsWith("com."))
        {
            obj = (new StringBuilder()).append("market://details?id=").append(s).toString();
        }
        Object obj1;
        if (!ew.a(context, "com.android.vending"))
        {
            break MISSING_BLOCK_LABEL_197;
        }
        obj1 = Uri.parse(((String) (obj)));
        s = new Intent("android.intent.action.MAIN");
        s.setPackage("com.android.vending");
        s.addCategory("android.intent.category.LAUNCHER");
        s = s.resolveActivity(context.getPackageManager());
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        s = null;
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
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            if (!(context instanceof Activity))
            {
                ((Intent) (obj)).addFlags(0x10000000);
            }
            context.startActivity(((Intent) (obj)));
            Crashlytics.logException(s);
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (!s.equals("") && !s.equals("null"))
        {
            ((Intent) (obj1)).setClassName("com.android.vending", s);
        }
        context.startActivity(((Intent) (obj1)));
        return;
        s = s.getClassName();
          goto _L1
        s = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
        if (!(context instanceof Activity))
        {
            s.addFlags(0x10000000);
        }
        context.startActivity(s);
        return;
    }

}
