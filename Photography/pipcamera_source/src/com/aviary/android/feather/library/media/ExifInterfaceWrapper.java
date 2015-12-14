// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.media;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;

public class ExifInterfaceWrapper
{

    private static SimpleDateFormat a;
    private static Object e = new Object();
    private String b;
    private HashMap c;
    private boolean d;

    public ExifInterfaceWrapper(String s)
    {
        b = s;
        c();
    }

    private static float a(String s, String s1)
    {
label0:
        {
label1:
            {
                double d1;
                boolean flag;
                try
                {
                    s = s.split(",");
                    String as[] = s[0].split("/");
                    d1 = Double.parseDouble(as[0].trim()) / Double.parseDouble(as[1].trim());
                    as = s[1].split("/");
                    double d3 = Double.parseDouble(as[0].trim()) / Double.parseDouble(as[1].trim());
                    s = s[2].split("/");
                    double d2 = Double.parseDouble(s[0].trim()) / Double.parseDouble(s[1].trim());
                    d3 /= 60D;
                    d1 = d2 / 3600D + (d1 + d3);
                    if (s1.equals("S"))
                    {
                        break label1;
                    }
                    flag = s1.equals("W");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new IllegalArgumentException();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new IllegalArgumentException();
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return (float)(-d1);
        }
        return (float)d1;
    }

    public static double b(String s)
    {
        double d1;
        double d2;
        s = s.split("/");
        d1 = Double.parseDouble(s[0].trim());
        d2 = Double.parseDouble(s[1].trim());
        return d1 / d2;
        s;
_L2:
        return 0.0D;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void c()
    {
        int i = 0;
        c = new HashMap();
        String s;
        synchronized (e)
        {
            s = getAttributesNative(b);
        }
        int j = s.indexOf(' ');
        int k = Integer.parseInt(s.substring(0, j));
        j++;
        while (i < k) 
        {
            int l = s.indexOf('=', j);
            obj = s.substring(j, l);
            l++;
            j = s.indexOf(' ', l);
            l = Integer.parseInt(s.substring(l, j));
            j++;
            String s1 = s.substring(j, j + l);
            j = l + j;
            if (((String) (obj)).equals("hasThumbnail"))
            {
                d = s1.equalsIgnoreCase("true");
            } else
            {
                c.put(obj, s1);
            }
            i++;
        }
        break MISSING_BLOCK_LABEL_183;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private native String getAttributesNative(String s);

    public double a(double d1)
    {
        int i = -1;
        double d3 = a("GPSAltitude", -1D);
        int j = a("GPSAltitudeRef", -1);
        double d2 = d1;
        if (d3 >= 0.0D)
        {
            d2 = d1;
            if (j >= 0)
            {
                if (j != 1)
                {
                    i = 1;
                }
                d2 = d3 * (double)i;
            }
        }
        return d2;
    }

    public double a(String s, double d1)
    {
        s = (String)c.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        return d1;
_L2:
        double d2;
        double d3;
        int i;
        try
        {
            i = s.indexOf("/");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return d1;
        }
        if (i == -1) goto _L1; else goto _L3
_L3:
        d2 = Double.parseDouble(s.substring(i + 1));
        if (d2 == 0.0D) goto _L1; else goto _L4
_L4:
        d3 = Double.parseDouble(s.substring(0, i));
        return d3 / d2;
    }

    public int a()
    {
        int i = a("Orientation", -1);
        if (i == -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 3 8: default 52
    //                   3 57
    //                   4 52
    //                   5 52
    //                   6 54
    //                   7 52
    //                   8 61;
           goto _L2 _L3 _L2 _L2 _L4 _L2 _L5
_L2:
        return 0;
_L4:
        return 90;
_L3:
        return 180;
_L5:
        return 270;
    }

    public int a(String s, int i)
    {
        s = (String)c.get(s);
        if (s == null)
        {
            return i;
        }
        int j;
        try
        {
            j = Integer.valueOf(s).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public String a(String s)
    {
        return (String)c.get(s);
    }

    public boolean a(float af[])
    {
        String s;
        String s1;
        String s2;
        String s3;
        s = (String)c.get("GPSLatitude");
        s1 = (String)c.get("GPSLatitudeRef");
        s2 = (String)c.get("GPSLongitude");
        s3 = (String)c.get("GPSLongitudeRef");
        if (s == null || s1 == null || s2 == null || s3 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        af[0] = a(s, s1);
        af[1] = a(s2, s3);
        return true;
        af;
        return false;
    }

    public boolean b()
    {
        return d;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        for (Iterator iterator = c.keySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append(s).append(" = ").append(a(s)).append("\n").toString()))
        {
            s = (String)iterator.next();
        }

        stringbuilder.append((new StringBuilder()).append("hasThumbnail = ").append(b()).append("\n").toString());
        return stringbuilder.toString();
    }

    static 
    {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("exif_shared");
        a = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        a.setTimeZone(TimeZone.getDefault());
    }
}
