// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package cn.jpush.android.api:
//            r

public final class q
{

    private static int a;
    private static int b;
    private static final String z[];

    public static int a()
    {
        return a;
    }

    private static Bitmap a(Context context, String s)
    {
        context = context.getResources().getAssets();
        s = context.open(s);
        context = BitmapFactory.decodeStream(s);
        s.close();
        return context;
        s;
        context = null;
_L2:
        s.printStackTrace();
        return context;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static void a(Context context, WindowManager windowmanager, WebView webview, ImageButton imagebutton)
    {
        int j = 200;
        int i = -300;
        Object obj = context.getResources().getDisplayMetrics();
        if (obj != null)
        {
            (new StringBuilder(z[3])).append(((DisplayMetrics) (obj)).widthPixels).toString();
            x.c();
            (new StringBuilder(z[5])).append(((DisplayMetrics) (obj)).heightPixels).toString();
            x.c();
            (new StringBuilder(z[6])).append(((DisplayMetrics) (obj)).density).toString();
            x.c();
            (new StringBuilder(z[4])).append(((DisplayMetrics) (obj)).densityDpi).toString();
            x.c();
            (new StringBuilder(z[2])).append(((DisplayMetrics) (obj)).xdpi).toString();
            x.c();
            (new StringBuilder(z[1])).append(((DisplayMetrics) (obj)).ydpi).toString();
            x.c();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            a = (((DisplayMetrics) (obj)).widthPixels * 3) / 4;
            b = ((DisplayMetrics) (obj)).heightPixels / 2;
            j = a / 2;
            i = -(b / 2);
        }
        obj = new android.view.WindowManager.LayoutParams();
        obj.format = 1;
        obj.gravity = 17;
        obj.type = 2003;
        obj.flags = ((android.view.WindowManager.LayoutParams) (obj)).flags | 0x228;
        obj.width = a;
        obj.height = b;
        obj.x = -1;
        obj.y = -1;
        windowmanager.addView(webview, ((android.view.ViewGroup.LayoutParams) (obj)));
        imagebutton.setBackgroundColor(context.getResources().getColor(0x106000d));
        imagebutton.setImageBitmap(a(context, z[0]));
        obj.width = -2;
        obj.height = -2;
        obj.y = i;
        obj.x = j;
        windowmanager.addView(imagebutton, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public static void a(Context context, d d)
    {
        (new Handler(Looper.getMainLooper())).post(new r(d, context));
    }

    public static void a(WindowManager windowmanager, WebView webview, ImageButton imagebutton)
    {
        windowmanager.removeView(webview);
        windowmanager.removeView(imagebutton);
    }

    public static int b()
    {
        return b;
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[7];
        i = 0;
        obj1 = "7\003\033\026Z\002\020\002\nA8]\036\013U";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 381
    //                   1 388
    //                   2 395
    //                   3 402;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_402;
_L3:
        byte0 = 50;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "$\027\036\f\022gS";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "%\027\036\f\022gS";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "*\032\n\021Z}IN";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "9\026\000\026[)\n*\025[}IN";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "5\026\007\002Z)STE";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "9\026\000\026[)\nN_\022";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            z = as;
            a = 400;
            b = 600;
            return;
        }
          goto _L12
_L8:
        byte0 = 93;
          goto _L13
_L5:
        byte0 = 115;
          goto _L13
_L6:
        byte0 = 110;
          goto _L13
        byte0 = 101;
          goto _L13
    }
}
