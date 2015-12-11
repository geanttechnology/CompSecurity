// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.util.SparseArray;
import java.lang.reflect.Method;

// Referenced classes of package jumiomobile:
//            ch, ab

public class eb extends ch
{

    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;

    public eb()
    {
        j = "netswipe_";
        if (h == null)
        {
            h = new SparseArray();
        }
        try
        {
            Class class1 = Class.forName("com.jumio.netswipe.resources.NSImageResources");
            class1.getDeclaredMethod("init", new Class[] {
                android/util/SparseArray, Integer.TYPE
            }).invoke(class1, new Object[] {
                h, Integer.valueOf(k)
            });
            return;
        }
        catch (Exception exception)
        {
            ab.a(exception);
        }
    }

    static 
    {
        int i = a;
        a = i + 1;
        k = i;
        i = a;
        a = i + 1;
        l = i;
        i = a;
        a = i + 1;
        m = i;
        i = a;
        a = i + 1;
        n = i;
        i = a;
        a = i + 1;
        o = i;
        i = a;
        a = i + 1;
        p = i;
        i = a;
        a = i + 1;
        q = i;
        i = a;
        a = i + 1;
        r = i;
        i = a;
        a = i + 1;
        s = i;
        i = a;
        a = i + 1;
        t = i;
        i = a;
        a = i + 1;
        u = i;
    }
}
