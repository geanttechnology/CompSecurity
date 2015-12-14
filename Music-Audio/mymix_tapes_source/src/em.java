// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Build;
import java.lang.reflect.Field;

public final class em
{

    public static final int a;
    public static final boolean b;
    public static final boolean c;
    private static boolean d;
    private static boolean e;
    private static final boolean f;

    static 
    {
label0:
        {
            boolean flag1 = false;
            a = Integer.parseInt(android.os.Build.VERSION.SDK);
            String s;
            String s1;
            int i;
            boolean flag;
            try
            {
                s = (String)android/os/Build.getField("MANUFACTURER").get(null);
            }
            catch (Exception exception)
            {
                exception = "";
            }
            s1 = Build.MODEL;
            if (s.equalsIgnoreCase("samsung") && (s1.equalsIgnoreCase("SGH-T959") || s1.equalsIgnoreCase("SAMSUNG-SGH-I897") || s1.equalsIgnoreCase("SGH-I897") || s1.equalsIgnoreCase("GT-I9000")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            d = flag;
            if (s.equalsIgnoreCase("htc") && (s1.equalsIgnoreCase("PC36100") || s1.equalsIgnoreCase("ADR6300") || s1.equalsIgnoreCase("HTC Glacier") || s1.equalsIgnoreCase("T-Mobile myTouch 4G") || s1.equalsIgnoreCase("T-Mobile G2")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b = flag;
            e = s1.equalsIgnoreCase("Motorola_i1");
            if (s.equalsIgnoreCase("Motorola") && s1.equalsIgnoreCase("MB860"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            if (s.equalsIgnoreCase("samsung"))
            {
                i = a;
            }
            if (!d)
            {
                flag = flag1;
                if (!e)
                {
                    break label0;
                }
            }
            flag = true;
        }
        c = flag;
        flag = d;
        flag = f;
    }
}
