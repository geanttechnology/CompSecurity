// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.f;

// Referenced classes of package android.support.v4.app:
//            e, d, c, g, 
//            h, b, f

public final class a
    implements f
{

    private static final b h;
    public final Activity a;
    public final DrawerLayout b;
    public boolean c;
    public boolean d;
    public Drawable e;
    public Drawable f;
    public final int g;
    private final android.support.v4.app.f i;
    private h j;
    private final int k;
    private final int l;
    private Object m;

    public a(Activity activity, DrawerLayout drawerlayout)
    {
        boolean flag1 = true;
        boolean flag;
        if (activity.getApplicationInfo().targetSdkVersion >= 21 && android.os.Build.VERSION.SDK_INT >= 21)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            flag1 = false;
        }
        this(activity, drawerlayout, flag1);
    }

    private a(Activity activity, DrawerLayout drawerlayout, boolean flag)
    {
        c = true;
        a = activity;
        float f1;
        if (activity instanceof g)
        {
            i = ((g)activity).a();
        } else
        {
            i = null;
        }
        b = drawerlayout;
        g = 0x7f0200ab;
        k = 0x7f0e0101;
        l = 0x7f0e0035;
        e = d();
        f = android.support.v4.a.a.a(activity, 0x7f0200ab);
        j = new h(this, f, (byte)0);
        activity = j;
        if (flag)
        {
            f1 = 0.3333333F;
        } else
        {
            f1 = 0.0F;
        }
        activity.b = f1;
        activity.invalidateSelf();
    }

    static Activity a(a a1)
    {
        return a1.a;
    }

    private void a(int i1)
    {
        if (i != null)
        {
            return;
        } else
        {
            m = h.a(m, a, i1);
            return;
        }
    }

    public final void a()
    {
        if (b.a())
        {
            j.a(1.0F);
        } else
        {
            j.a(0.0F);
        }
        if (c)
        {
            h h1 = j;
            int i1;
            if (b.a())
            {
                i1 = l;
            } else
            {
                i1 = k;
            }
            if (i == null)
            {
                m = h.a(m, a, h1, i1);
            }
        }
    }

    public final void a(float f1)
    {
        float f2 = j.a;
        if (f1 > 0.5F)
        {
            f1 = Math.max(f2, Math.max(0.0F, f1 - 0.5F) * 2.0F);
        } else
        {
            f1 = Math.min(f2, f1 * 2.0F);
        }
        j.a(f1);
    }

    public final void b()
    {
        j.a(1.0F);
        if (c)
        {
            a(l);
        }
    }

    public final void c()
    {
        j.a(0.0F);
        if (c)
        {
            a(k);
        }
    }

    public final Drawable d()
    {
        if (i != null)
        {
            return i.a();
        } else
        {
            return h.a(a);
        }
    }

    static 
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 >= 18)
        {
            h = new e((byte)0);
        } else
        if (i1 >= 11)
        {
            h = new d((byte)0);
        } else
        {
            h = new c((byte)0);
        }
    }
}
