// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.webkit.URLUtil;
import c.f;
import com.immersion.hapticmediasdk.b.b;
import java.io.File;
import java.net.MalformedURLException;

// Referenced classes of package com.immersion.hapticmediasdk:
//            a, e, b

public class d extends a
{

    public static int h = 13;
    public static int i = 0;
    public static int j = 1;
    public static int k = 2;
    private int l;

    public d(Context context)
    {
        try
        {
            super(0, context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
        if (((h + j) * h) % k != i)
        {
            h = j();
            i = j();
        }
        try
        {
            l = 400;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw context;
        }
    }

    public static int a(d d1, int i1)
    {
        if (((j() + j) * j()) % k != i)
        {
            h = 4;
            i = j();
        }
        try
        {
            d1.l = i1;
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            throw d1;
        }
        return i1;
    }

    private boolean b(String s)
    {
        boolean flag1 = false;
        s = s.replaceFirst("https", "http");
        InterruptedException interruptedexception;
        int i1;
        boolean flag;
        try
        {
            s = new f(this, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", s.getMessage());
            return false;
        }
        (new Thread(s, "ping url")).start();
        s;
        JVM INSTR monitorenter ;
        l = -100;
_L2:
        i1 = l;
        Exception exception;
label0:
        {
            if (i1 >= 0)
            {
                break label0;
            }
            try
            {
                s.wait(100L);
            }
            // Misplaced declaration of an exception variable
            catch (InterruptedException interruptedexception) { }
            finally { }
        }
        if (true) goto _L2; else goto _L1
_L1:
label1:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label1;

                    case 1: // '\001'
                        continue label1;
                    }
                }
                break;

            case 0: // '\0'
                break label1;

            case 1: // '\001'
                break;
            }
        } while (true);
        flag = flag1;
        if (200 > l)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        flag = flag1;
        if (l <= 399)
        {
            flag = true;
        }
        s;
        JVM INSTR monitorexit ;
        return flag;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private int c(String s)
    {
        if (s == null)
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "invalid local hapt file url: null");
            return -4;
        }
        File file = new File(s);
        if (file.isFile())
        {
            if (file.canRead())
            {
                c.a(s, false);
                return c.a(b);
            } else
            {
                com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "could not access local hapt file: permission denied");
                return -3;
            }
        } else
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "invalid local hapt file url: directory");
            return -4;
        }
    }

    public static int j()
    {
        return 61;
    }

    public static int k()
    {
        return 1;
    }

    public static int l()
    {
        return 2;
    }

    public int a(String s)
    {
_L2:
        if (URLUtil.isFileUrl(s))
        {
            return c(s);
        } else
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "could not access hapt file url: unsupposted protocol");
            return -5;
        }
        com.immersion.hapticmediasdk.b b1 = c();
        if (b1 != b.d && b1 != b.a && b1 != b && b1 != b.e)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        int i1 = c.a(b.a);
        if (i1 != 0)
        {
            return i1;
        }
        if (!URLUtil.isValidUrl(s))
        {
            return c(s);
        }
        if (!URLUtil.isHttpUrl(s) && !URLUtil.isHttpsUrl(s)) goto _L2; else goto _L1
_L1:
        if (b(s))
        {
            c.a(s, true);
            return c.a(b);
        } else
        {
            com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "could not access hapt file url: Inaccessible URL");
            return -2;
        }
        return -1;
    }
}
