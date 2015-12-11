// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class cjg
    implements ckk
{

    private final ckk a;
    private final ckk b;
    private final Context c;
    private final cnb d;
    private ckk e;
    private boolean f;
    private cke g;

    public cjg(ckk ckk1, ckk ckk2, Context context, cnb cnb1)
    {
        a = (ckk)b.a(ckk1);
        b = (ckk)b.a(ckk2);
        c = (Context)b.a(context);
        d = (cnb)b.a(cnb1);
        e = ckk1;
    }

    private boolean a(bww bww1, bwp bwp1)
    {
        boolean flag3 = false;
        boolean flag2;
        if (android.os.Build.VERSION.SDK_INT < 16 || !d.a())
        {
            flag2 = true;
        } else
        {
            if (bww1.g || bww1.a())
            {
                return true;
            }
            flag2 = flag3;
            if (!bww1.b.isEmpty())
            {
                if (!bwp1.a(d.c()))
                {
                    return true;
                }
                bwp1 = bwd.h();
                Set set = bwd.k();
                bww1 = bww1.c.iterator();
                boolean flag = false;
                boolean flag1 = false;
                while (bww1.hasNext()) 
                {
                    int i1 = ((bwb)bww1.next()).a.b;
                    flag1 |= bwp1.contains(Integer.valueOf(i1));
                    flag = set.contains(Integer.valueOf(i1)) | flag;
                }
                if (flag1 && flag)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag2 = flag3;
                if (!flag)
                {
                    return true;
                }
            }
        }
        return flag2;
    }

    public final cku a(bww bww1, bwp bwp1, boolean flag)
    {
        ckk ckk1;
        if (a(bww1, bwp1))
        {
            ckk1 = b;
        } else
        {
            ckk1 = a;
        }
        return ckk1.a(bww1, bwp1, flag);
    }

    public final void a(float f1)
    {
        a.a(f1);
        b.a(f1);
    }

    public final void a(Handler handler)
    {
        a.a(handler);
        b.a(handler);
    }

    public final void a(bww bww1, int i1, String s, bwp bwp1)
    {
        boolean flag = a(bww1, bwp1);
        Object obj;
        if (flag)
        {
            obj = b;
        } else
        {
            obj = a;
        }
        if (obj != e)
        {
            if (f)
            {
                e.n();
                ((ckk) (obj)).a(g);
            }
            e = ((ckk) (obj));
        }
        if (d.a.getBoolean("show_exo_player_debug_messages", false))
        {
            if (flag)
            {
                obj = "Using fallback player";
            } else
            {
                obj = "Using ExoPlayer";
            }
            Toast.makeText(c, ((CharSequence) (obj)), 0).show();
        }
        e.a(bww1, i1, s, bwp1);
    }

    public final void a(cke cke)
    {
        f = true;
        g = cke;
        e.a(cke);
    }

    public final void a(String s, Uri uri)
    {
        e.a(s, uri);
    }

    public final bwb b()
    {
        return e.b();
    }

    public final void b(int i1)
    {
        e.b(i1);
    }

    public final bwb c()
    {
        return e.c();
    }

    public final void d()
    {
        e.d();
    }

    public final void e()
    {
        e.e();
    }

    public final void f()
    {
        e.f();
    }

    public final void g()
    {
        e.g();
    }

    public final int h()
    {
        return e.h();
    }

    public final int i()
    {
        return e.i();
    }

    public final int j()
    {
        return e.j();
    }

    public final boolean k()
    {
        return e.k();
    }

    public final boolean l()
    {
        return e.l();
    }

    public final void m()
    {
        e.m();
    }

    public final void n()
    {
        f = false;
        g = null;
        a.n();
        b.n();
    }
}
