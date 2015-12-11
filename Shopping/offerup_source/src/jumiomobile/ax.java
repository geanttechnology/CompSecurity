// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

// Referenced classes of package jumiomobile:
//            aw, ab, ap

public class ax
{

    private static aw a;

    public ax()
    {
    }

    public static Bitmap a(String s, String s1)
    {
        return a(s, s1, null);
    }

    public static Bitmap a(String s, String s1, android.graphics.BitmapFactory.Options options)
    {
        int i;
        s1 = (new StringBuilder()).append(s).append("assets/nv/images/country/flag_").append(s1.toLowerCase()).append(".webp").toString();
        i = s1.hashCode();
        if (!a().b(i)) goto _L2; else goto _L1
_L1:
        s = a().a(i);
        ab.c((new StringBuilder("Reading ")).append(s1).append(" from local cache").toString());
_L9:
        return s;
_L2:
        try
        {
            System.currentTimeMillis();
            s = (new ap(s1)).a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ab.a(jumiomobile/ax.getSimpleName(), s);
            return null;
        }
        if (s == null) goto _L4; else goto _L3
_L3:
        System.currentTimeMillis();
        if (options == null) goto _L6; else goto _L5
_L5:
        s = BitmapFactory.decodeByteArray(s, 0, s.length, options);
_L7:
        a().a(i, s);
        continue; /* Loop/switch isn't completed */
_L6:
        s = BitmapFactory.decodeByteArray(s, 0, s.length);
        if (true) goto _L7; else goto _L4
_L4:
        s = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static aw a()
    {
        jumiomobile/ax;
        JVM INSTR monitorenter ;
        aw aw1;
        if (a == null)
        {
            a = new aw();
        }
        aw1 = a;
        jumiomobile/ax;
        JVM INSTR monitorexit ;
        return aw1;
        Exception exception;
        exception;
        throw exception;
    }
}
