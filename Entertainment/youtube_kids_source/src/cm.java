// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.google.android.libraries.youtube.common.ui.TouchImageView;

public class cm
    implements bhv, bn, gz, mj
{

    public final kn a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Drawable f;
    public Drawable g;
    public Drawable h;
    public cuv i;
    public final TouchImageView j;
    public final Context k;
    public final String l;
    public volatile Object m;
    public final mj n;
    public final bwb o;
    public final long p;
    public final String q;
    public final cun r;

    public static boolean b(int i1)
    {
        return i1 == 79 || i1 == 85 || i1 == 86 || i1 == 126 || i1 == 127 || i1 == 87 || i1 == 88 || i1 == 175;
    }

    public Drawable a()
    {
        if (f == null)
        {
            f = aw.a(k, 0x7f02020f);
        }
        return f;
    }

    public void a(int i1, int j1)
    {
        b = i1;
        c = j1;
    }

    public void a(AnimationDrawable animationdrawable)
    {
        j.setImageDrawable(animationdrawable);
        animationdrawable.start();
    }

    public void a(bqv bqv1)
    {
        n.a(bqv1.a.b);
    }

    public void a(ced ced1)
    {
        if (ced1 != null && ced1.b.equals(q))
        {
            cun.a(r, ced1);
        }
    }

    public void a(cuv cuv1)
    {
        Drawable drawable = j.getDrawable();
        if (cuv1 == i && drawable != null && drawable.isVisible())
        {
            return;
        }
        if (cuv1 == cuv.c)
        {
            j.setContentDescription(k.getText(0x7f0b0139));
            if (i == cuv.b)
            {
                a(((AnimationDrawable) (null)));
            } else
            {
                j.setImageDrawable(a());
            }
        } else
        if (cuv1 == cuv.b)
        {
            j.setContentDescription(k.getText(0x7f0b013a));
            if (i == cuv.c)
            {
                a(((AnimationDrawable) (null)));
            } else
            {
                j.setImageDrawable(b());
            }
        } else
        {
            j.setContentDescription(k.getText(0x7f0b013b));
            j.setImageDrawable(c());
        }
        i = cuv1;
    }

    public void a(gt gt1, boolean flag)
    {
        if (gt1 instanceof hb)
        {
            ((hb)gt1).h.a(false);
        }
        gt1 = a;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((bqv)obj);
    }

    public void a(Object obj, Exception exception)
    {
        k();
    }

    public volatile void a(Object obj, Object obj1)
    {
        a((ced)obj1);
    }

    public void a(mp mp)
    {
        n.a(mp);
    }

    public boolean a(int i1)
    {
        if (i1 == 89 || i1 == 90)
        {
            if (d != 0x80000000 && i1 == e)
            {
                i1 = d;
                d = 0x80000000;
                e = 0;
            }
        } else
        if (!b(i1))
        {
            return false;
        }
        return true;
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        if (d != 0x80000000 && i1 != e)
        {
            return true;
        }
        if (i1 == 89 || i1 == 90)
        {
            if (b != 0x80000000 && c != 0x80000000)
            {
                if (keyevent.getRepeatCount() == 0)
                {
                    d = b;
                    e = i1;
                }
                int j1 = d;
                if (i1 == 89)
                {
                    i1 = -20000;
                } else
                {
                    i1 = 20000;
                }
                d = i1 + j1;
                d = Math.max(0, Math.min(d, c));
                i1 = d;
            }
            return true;
        }
        if (b(i1))
        {
            return keyevent.getRepeatCount() <= 0 ? true : true;
        } else
        {
            return false;
        }
    }

    public boolean a(gt gt1)
    {
        if (gt1 == null)
        {
            return false;
        }
        ((hb)gt1).getItem().getItemId();
        gt1 = a;
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            return false;
        }
    }

    public Drawable b()
    {
        if (g == null)
        {
            g = aw.a(k, 0x7f02020d);
        }
        return g;
    }

    public Drawable c()
    {
        if (h == null)
        {
            h = aw.a(k, 0x7f020213);
        }
        return h;
    }

    public String d()
    {
        return l;
    }

    public void e()
    {
        m = null;
    }

    public bwb f()
    {
        return o;
    }

    public long g()
    {
        return o.a.k;
    }

    public boolean h()
    {
        return p == g();
    }

    public String i()
    {
        return null;
    }

    public long j()
    {
        return 0L;
    }

    public void k()
    {
        String s = String.valueOf(q);
        if (s.length() != 0)
        {
            s = "Failed to get the video for use in playback controls: ".concat(s);
        } else
        {
            s = new String("Failed to get the video for use in playback controls: ");
        }
        bmo.b(s);
    }
}
