// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class jg
    implements Runnable
{

    final Handler a;
    Method b;
    boolean c;
    private final DisplayManager d;

    public jg(Context context, Handler handler)
    {
        if (android.os.Build.VERSION.SDK_INT != 17)
        {
            throw new UnsupportedOperationException();
        }
        d = (DisplayManager)context.getSystemService("display");
        a = handler;
        try
        {
            b = android/hardware/display/DisplayManager.getMethod("scanWifiDisplays", new Class[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public final void run()
    {
        if (c)
        {
            try
            {
                b.invoke(d, new Object[0]);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", illegalaccessexception);
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                Log.w("MediaRouterJellybeanMr1", "Cannot scan for wifi displays.", invocationtargetexception);
            }
            a.postDelayed(this, 15000L);
        }
    }
}
