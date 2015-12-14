// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

// Referenced classes of package myobfuscated.t:
//            p

public final class n
{

    public final int a;
    public final int b;
    public final int c;
    private final Context d;

    public n(Context context, ActivityManager activitymanager, p p1, float f, float f1, int i, float f2, 
            float f3)
    {
        d = context;
        int j = i;
        if (a(activitymanager))
        {
            j = i / 2;
        }
        c = j;
        i = activitymanager.getMemoryClass();
        boolean flag = a(activitymanager);
        float f4 = i * 1024 * 1024;
        int k;
        int l;
        if (!flag)
        {
            f3 = f2;
        }
        i = Math.round(f4 * f3);
        k = p1.a.widthPixels * p1.a.heightPixels * 4;
        j = Math.round((float)k * f1);
        k = Math.round((float)k * f);
        l = i - c;
        if (k + j <= l)
        {
            b = k;
            a = j;
        } else
        {
            f2 = (float)l / (f1 + f);
            b = Math.round(f2 * f);
            a = Math.round(f2 * f1);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3))
        {
            context = (new StringBuilder("Calculation complete, Calculated memory cache size: ")).append(a(b)).append(", pool size: ").append(a(a)).append(", byte array size: ").append(a(c)).append(", memory class limited? ");
            boolean flag1;
            if (k + j > i)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context.append(flag1).append(", max size: ").append(a(i)).append(", memoryClass: ").append(activitymanager.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(activitymanager));
        }
    }

    private String a(int i)
    {
        return Formatter.formatFileSize(d, i);
    }

    private static boolean a(ActivityManager activitymanager)
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            return activitymanager.isLowRamDevice();
        }
        return android.os.Build.VERSION.SDK_INT < 11;
    }
}
