// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.as;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

// Referenced classes of package myobfuscated.as:
//            f, b, g

public abstract class a
{

    private static final WeakHashMap a = new WeakHashMap(0);

    public a()
    {
    }

    public static a a(View view)
    {
        a a1 = (a)a.get(view);
        Object obj = a1;
        if (a1 == null)
        {
            int i = Integer.valueOf(android.os.Build.VERSION.SDK).intValue();
            if (i >= 14)
            {
                obj = new f(view);
            } else
            if (i >= 11)
            {
                obj = new b(view);
            } else
            {
                obj = new g(view);
            }
            a.put(view, obj);
        }
        return ((a) (obj));
    }

    public abstract a a();

    public abstract a a(float f1);

    public abstract a a(Interpolator interpolator);

}
