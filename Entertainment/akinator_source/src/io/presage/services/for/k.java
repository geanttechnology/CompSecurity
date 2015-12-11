// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.for;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.presage.Presage;
import io.presage.services.if.g;
import io.presage.utils.do.a;
import io.presage.utils.f;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;

// Referenced classes of package io.presage.services.for:
//            d, j

public final class k extends d
    implements j
{

    private g a;
    private a b;
    private Context c;
    private String d;

    public k(String s)
    {
        d = s;
        a = new g();
        if (Presage.getInstance().getId() == null)
        {
            a.c();
        }
        c = Presage.getInstance().getContext();
        b = Presage.getInstance().getWS();
    }

    private Context a()
    {
        if (c == null)
        {
            c = Presage.getInstance().getContext();
        }
        return c;
    }

    public final void b()
    {
        if (a != null)
        {
            b.a(d, a.d());
        }
    }

    public final void e()
    {
        a = null;
    }

    public final void h()
    {
        Object obj;
        Object obj1;
        Object obj2;
        try
        {
            a.e(a().getResources().getConfiguration().locale.getISO3Country());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.e("ZZZ");
        }
        a.f(a().getResources().getConfiguration().locale.getLanguage());
        try
        {
            obj = io.presage.utils.a.a(c);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = null;
        }
        if (obj != null)
        {
            a.b(((io.presage.utils.a.a) (obj)).a());
            obj1 = a;
            boolean flag;
            if (!((io.presage.utils.a.a) (obj)).b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((g) (obj1)).a(flag);
        }
        obj1 = Build.MANUFACTURER;
        obj = Build.MODEL;
        if (((String) (obj)).startsWith(((String) (obj1))))
        {
            a.c(((String) (obj)));
        } else
        {
            obj1 = new StringBuilder(((String) (obj1)));
            ((StringBuilder) (obj1)).append(" ");
            ((StringBuilder) (obj1)).append(((String) (obj)));
            a.c(((StringBuilder) (obj1)).toString());
        }
        a.d(android.os.Build.VERSION.RELEASE);
        obj2 = (WindowManager)a().getSystemService("window");
        obj1 = new Point();
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        ((WindowManager) (obj2)).getDefaultDisplay().getSize(((Point) (obj1)));
_L4:
        Exception exception;
        try
        {
            obj = new DisplayMetrics();
            ((WindowManager) (obj2)).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        }
        catch (Exception exception1)
        {
            exception1 = a().getResources().getDisplayMetrics();
        }
        obj2 = new HashMap();
        ((HashMap) (obj2)).put("width", Integer.valueOf(((Point) (obj1)).x));
        ((HashMap) (obj2)).put("height", Integer.valueOf(((Point) (obj1)).y));
        ((HashMap) (obj2)).put("density", Float.valueOf(((DisplayMetrics) (obj)).density));
        a.a(((java.util.Map) (obj2)));
        obj = System.getProperty("java.vm.version");
        obj1 = System.getProperty("java.vm.name");
        a.a(((String) (obj1)), ((String) (obj)));
        obj = System.getProperty("os.arch");
        a.g(((String) (obj)));
        a.a(Presage.getInstance().getPackageHelper().a());
        return;
_L2:
        if (android.os.Build.VERSION.SDK_INT >= 13) goto _L4; else goto _L3
_L3:
        obj1.x = ((WindowManager) (obj2)).getDefaultDisplay().getWidth();
        obj1.y = ((WindowManager) (obj2)).getDefaultDisplay().getHeight();
          goto _L4
        exception;
          goto _L4
    }
}
