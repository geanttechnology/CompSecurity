// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.internal;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.http.SslError;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.inmobi.commons.internal:
//            Log

public class WrapperFunctions
{

    private static int a;

    public WrapperFunctions()
    {
    }

    private static void a(WebView webview, int i)
    {
        try
        {
            webview.getClass().getMethod("setLayerType", new Class[] {
                Integer.TYPE, android/graphics/Paint
            }).invoke(webview, new Object[] {
                Integer.valueOf(i), null
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot set hardware accl", webview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot set hardware accl", webview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot set hardware accl", webview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot set hardware accl", webview);
        }
    }

    public static void disableHardwareAccl(WebView webview)
    {
        a(webview, 1);
    }

    public static int getCurrentOrientationInFixedValues(Context context)
    {
        switch (context.getResources().getConfiguration().orientation)
        {
        default:
            return 1;

        case 1: // '\001'
            if (android.os.Build.VERSION.SDK_INT < 8)
            {
                return 1;
            }
            int i = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
            return i != 1 && i != 2 ? 1 : 9;

        case 2: // '\002'
            break;
        }
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            return 0;
        }
        int j = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
        return j != 0 && j != 1 ? 8 : 0;
    }

    public static int getDisplayHeight(Display display)
    {
        Method method = null;
        Method method1 = android/view/Display.getMethod("getSize", new Class[] {
            android/graphics/Point
        });
        int i;
        method = method1;
        i = 1;
_L2:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        NoSuchMethodException nosuchmethodexception;
        Method method2;
        try
        {
            Point point = new Point();
            method.invoke(display, new Object[] {
                point
            });
            i = point.y;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display height", display);
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display height", display);
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display height", display);
            return 0;
        }
        return i;
        nosuchmethodexception;
        method2 = android/view/Display.getMethod("getHeight", (Class[])null);
        method = method2;
        i = 0;
        continue; /* Loop/switch isn't completed */
        method2;
        Log.internal("[InMobi]-4.5.5", "Cannot get display height", method2);
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
        i = ((Integer)method.invoke(display, (Object[])null)).intValue();
        return i;
    }

    public static int getDisplayWidth(Display display)
    {
        Method method = null;
        Method method1 = android/view/Display.getMethod("getSize", new Class[] {
            android/graphics/Point
        });
        int i;
        method = method1;
        i = 1;
_L2:
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        NoSuchMethodException nosuchmethodexception;
        Method method2;
        try
        {
            Point point = new Point();
            method.invoke(display, new Object[] {
                point
            });
            i = point.x;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display width", display);
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display width", display);
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Display display)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get display width", display);
            return 0;
        }
        return i;
        nosuchmethodexception;
        method2 = android/view/Display.getMethod("getWidth", (Class[])null);
        method = method2;
        i = 0;
        continue; /* Loop/switch isn't completed */
        method2;
        Log.internal("[InMobi]-4.5.5", "Cannot get display width", method2);
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
        i = ((Integer)method.invoke(display, (Object[])null)).intValue();
        return i;
    }

    public static int getParamConfigScreenSize()
    {
        int i = 0;
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        try
        {
            field = android/content/pm/ActivityInfo.getField("CONFIG_SCREEN_SIZE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get screen size", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get screen size", exception);
            return 0;
        }
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        i = field.getInt(activityinfo);
        return i;
    }

    public static int getParamConfigSmallestScreenSize()
    {
        int i = 0;
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        try
        {
            field = android/content/pm/ActivityInfo.getField("CONFIG_SMALLEST_SCREEN_SIZE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get smallest screen size", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get smallest screen size", exception);
            return 0;
        }
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        i = field.getInt(activityinfo);
        return i;
    }

    public static int getParamFillParent()
    {
        if (a != 0) goto _L2; else goto _L1
_L1:
        com/inmobi/commons/internal/WrapperFunctions;
        JVM INSTR monitorenter ;
        if (a != 0) goto _L4; else goto _L3
_L3:
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(1, 1);
        Field field = android/view/ViewGroup$LayoutParams.getField("MATCH_PARENT");
_L7:
        if (field == null) goto _L4; else goto _L5
_L5:
        a = field.getInt(layoutparams);
_L4:
        com/inmobi/commons/internal/WrapperFunctions;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Object obj;
        obj;
        try
        {
            obj = android/view/ViewGroup$LayoutParams.getField("FILL_PARENT");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        Log.internal("[InMobi]-4.5.5", "Cannot get fill parent param", ((Throwable) (obj)));
        obj = null;
        continue; /* Loop/switch isn't completed */
        obj;
        Log.internal("[InMobi]-4.5.5", "Cannot get fill parent param", ((Throwable) (obj)));
          goto _L4
        com/inmobi/commons/internal/WrapperFunctions;
        JVM INSTR monitorexit ;
        throw obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static int getParamLandscapeOrientation(int i)
    {
        boolean flag = false;
        int j = ((flag) ? 1 : 0);
        if (i != 3)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        try
        {
            field = android/content/pm/ActivityInfo.getField("SCREEN_ORIENTATION_REVERSE_LANDSCAPE");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get landscape orientation", nosuchfieldexception);
            return 0;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get landscape orientation", exception);
            return 0;
        }
        j = ((flag) ? 1 : 0);
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        j = field.getInt(activityinfo);
        return j;
    }

    public static int getParamPortraitOrientation(int i)
    {
        boolean flag = true;
        int j = ((flag) ? 1 : 0);
        if (i != 2)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        ActivityInfo activityinfo = new ActivityInfo();
        Field field;
        try
        {
            field = android/content/pm/ActivityInfo.getField("SCREEN_ORIENTATION_REVERSE_PORTRAIT");
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get portrait orientation", nosuchfieldexception);
            return 1;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get portrait orientation", exception);
            return 1;
        }
        j = ((flag) ? 1 : 0);
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        j = field.getInt(activityinfo);
        return j;
    }

    public static String getSSLErrorUrl(SslError sslerror)
    {
        try
        {
            sslerror = Class.forName("android.net.http.SslError").getDeclaredMethod("getUrl", new Class[0]).invoke(sslerror, new Object[0]).toString();
        }
        // Misplaced declaration of an exception variable
        catch (SslError sslerror)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get SSL Url", sslerror);
            return null;
        }
        return sslerror;
    }

    public static Bitmap getVideoBitmap(String s)
        throws Exception
    {
        try
        {
            s = (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[] {
                java/lang/String, Integer.TYPE
            }).invoke(null, new Object[] {
                s, Integer.valueOf(1)
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-4.5.5", "Cannot get video bitmap", s);
            throw s;
        }
        return s;
    }
}
