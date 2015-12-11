// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.StatFs;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.a.b:
//            ac, az, ao, ay, 
//            s

public final class ba
{

    static int a(Bitmap bitmap)
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            i = bitmap.getByteCount();
        } else
        {
            i = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (i < 0)
        {
            throw new IllegalStateException((new StringBuilder("Negative size: ")).append(bitmap).toString());
        } else
        {
            return i;
        }
    }

    static long a(File file)
    {
        long l;
        try
        {
            file = new StatFs(file.getAbsolutePath());
            l = file.getBlockCount();
            l = ((long)file.getBlockSize() * l) / 50L;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            l = 0x500000L;
        }
        return Math.max(Math.min(l, 0x3200000L), 0x500000L);
    }

    static s a(Context context)
    {
        ac ac1;
        try
        {
            Class.forName("com.a.a.r");
            ac1 = new ac(context);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return new az(context);
        }
        return ac1;
    }

    public static String a(ao ao1)
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        if (ao1.a != null)
        {
            String s = ao1.a.toString();
            stringbuilder = new StringBuilder(s.length() + 50);
            stringbuilder.append(s);
        } else
        {
            stringbuilder = new StringBuilder(50);
            stringbuilder.append(ao1.b);
        }
        stringbuilder.append('\n');
        if (ao1.h != 0.0F)
        {
            stringbuilder.append("rotation:").append(ao1.h);
            if (ao1.k)
            {
                stringbuilder.append('@').append(ao1.i).append('x').append(ao1.j);
            }
            stringbuilder.append('\n');
        }
        if (ao1.d != 0)
        {
            stringbuilder.append("resize:").append(ao1.d).append('x').append(ao1.e);
            stringbuilder.append('\n');
        }
        if (!ao1.f) goto _L2; else goto _L1
_L1:
        stringbuilder.append("centerCrop\n");
_L4:
        if (ao1.c != null)
        {
            j = ao1.c.size();
            for (i = 0; i < j; i++)
            {
                stringbuilder.append(((ay)ao1.c.get(i)).b());
                stringbuilder.append('\n');
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (ao1.g)
        {
            stringbuilder.append("centerInside\n");
        }
        if (true) goto _L4; else goto _L3
_L3:
        return stringbuilder.toString();
    }

    static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return;
        }
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
    }

    static boolean a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.split(" ", 2);
        if ("CACHE".equals(s[0]))
        {
            return true;
        }
        if (s.length == 1) goto _L1; else goto _L3
_L3:
        if (!"CONDITIONAL_CACHE".equals(s[0])) goto _L1; else goto _L4
_L4:
        int i = Integer.parseInt(s[1]);
        if (i == 304)
        {
            return true;
        }
          goto _L1
        s;
        return false;
    }

    static File b(Context context)
    {
        context = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!context.exists())
        {
            context.mkdirs();
        }
        return context;
    }
}
