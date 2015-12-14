// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bs;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.socialin.android.brushlib.util.e;
import com.socialin.android.brushlib.util.f;
import com.socialin.android.util.c;
import java.util.Iterator;
import java.util.LinkedList;

public class b
{

    private static final String a = myobfuscated/bs/b.getSimpleName();
    private static Resources b;
    private static int c;
    private static final e d;

    public b()
    {
    }

    public static e a()
    {
        return d;
    }

    public static void a(Resources resources)
    {
        b = resources;
    }

    public static void b()
    {
        e e1 = d;
        for (Iterator iterator = e1.a.iterator(); iterator.hasNext(); e1.a(((f)iterator.next()).b)) { }
        e1.a.clear();
        com.socialin.android.util.c.b(a);
    }

    static Resources c()
    {
        return b;
    }

    static String d()
    {
        return a;
    }

    static 
    {
        c = 2;
        d = new e(c) {

            public final void a(Object obj)
            {
                obj = (Bitmap)obj;
                if (obj != null)
                {
                    ((Bitmap) (obj)).recycle();
                }
            }

            public final Object b(Object obj)
            {
                String s = (String)obj;
                Object obj1;
                if (s.equals("default"))
                {
                    obj = com.socialin.android.util.c.a(myobfuscated.bs.b.c(), 0x7f0206d4, null, b.d());
                } else
                {
                    obj = com.socialin.android.util.c.a(s, null, b.d());
                }
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = com.socialin.android.util.c.a(s, null, b.d());
                }
                return obj1;
            }

        };
    }
}
