// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public final class ic
    implements hs
{

    Toolbar a;
    CharSequence b;
    private int c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private CharSequence h;
    private CharSequence i;
    private final hy j;
    private int k;
    private Drawable l;

    public ic(Toolbar toolbar, boolean flag)
    {
        this(toolbar, true, 0x7f0b016d, 0x7f02000e);
    }

    private ic(Toolbar toolbar, boolean flag, int i1, int j1)
    {
        k = 0;
        a = toolbar;
        b = toolbar.i;
        h = toolbar.j;
        CharSequence charsequence = b;
        if (flag)
        {
            toolbar = ib.a(toolbar.getContext(), null, gl.a, 0x7f01008f, 0);
            Object obj = toolbar.b(0);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                b = ((CharSequence) (obj));
                if ((c & 8) != 0)
                {
                    a.a(((CharSequence) (obj)));
                }
            }
            obj = toolbar.b(5);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                h = ((CharSequence) (obj));
                if ((c & 8) != 0)
                {
                    a.b(((CharSequence) (obj)));
                }
            }
            obj = toolbar.a(9);
            if (obj != null)
            {
                f = ((Drawable) (obj));
                a();
            }
            obj = toolbar.a(8);
            if (obj != null)
            {
                e = ((Drawable) (obj));
                a();
            }
            obj = toolbar.a(2);
            if (obj != null)
            {
                g = ((Drawable) (obj));
                c();
            }
            a(toolbar.a(4, 0));
            int k1 = toolbar.e(14, 0);
            if (k1 != 0)
            {
                View view = LayoutInflater.from(a.getContext()).inflate(k1, a, false);
                if (d != null && (c & 0x10) != 0)
                {
                    a.removeView(d);
                }
                d = view;
                if (view != null && (c & 0x10) != 0)
                {
                    a.addView(d);
                }
                a(c | 0x10);
            }
            k1 = toolbar.d(1, 0);
            if (k1 > 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                layoutparams.height = k1;
                a.setLayoutParams(layoutparams);
            }
            int i2 = toolbar.b(21, -1);
            k1 = toolbar.b(22, -1);
            if (i2 >= 0 || k1 >= 0)
            {
                Toolbar toolbar1 = a;
                i2 = Math.max(i2, 0);
                k1 = Math.max(k1, 0);
                toolbar1.h.a(i2, k1);
            }
            k1 = toolbar.e(6, 0);
            if (k1 != 0)
            {
                Toolbar toolbar2 = a;
                Context context = a.getContext();
                toolbar2.f = k1;
                if (toolbar2.a != null)
                {
                    toolbar2.a.setTextAppearance(context, k1);
                }
            }
            k1 = toolbar.e(7, 0);
            if (k1 != 0)
            {
                Toolbar toolbar3 = a;
                Context context1 = a.getContext();
                toolbar3.g = k1;
                if (toolbar3.b != null)
                {
                    toolbar3.b.setTextAppearance(context1, k1);
                }
            }
            k1 = toolbar.e(26, 0);
            if (k1 != 0)
            {
                a.a(k1);
            }
            ((ib) (toolbar)).a.recycle();
            j = toolbar.a();
        } else
        {
            int l1 = 11;
            Object obj1 = a;
            if (((Toolbar) (obj1)).c != null)
            {
                obj1 = ((Toolbar) (obj1)).c.getDrawable();
            } else
            {
                obj1 = null;
            }
            if (obj1 != null)
            {
                l1 = 15;
            }
            c = l1;
            j = new hy(toolbar.getContext());
        }
        if (i1 != k)
        {
            k = i1;
            if (TextUtils.isEmpty(a.a()))
            {
                i1 = k;
                id id1;
                if (i1 == 0)
                {
                    toolbar = null;
                } else
                {
                    toolbar = a.getContext().getString(i1);
                }
                i = toolbar;
                b();
            }
        }
        i = a.a();
        toolbar = j.a(j1);
        if (l != toolbar)
        {
            l = toolbar;
            c();
        }
        toolbar = a;
        id1 = new id(this);
        toolbar.b();
        toolbar.c.setOnClickListener(id1);
    }

    private void a()
    {
        Toolbar toolbar;
        Drawable drawable = null;
        if ((c & 2) != 0)
        {
            if ((c & 1) != 0)
            {
                if (f != null)
                {
                    drawable = f;
                } else
                {
                    drawable = e;
                }
            } else
            {
                drawable = e;
            }
        }
        toolbar = a;
        if (drawable == null) goto _L2; else goto _L1
_L1:
        if (toolbar.d == null)
        {
            toolbar.d = new ImageView(toolbar.getContext());
        }
        if (toolbar.d.getParent() == null)
        {
            toolbar.a(toolbar.d);
            toolbar.b(toolbar.d);
        }
_L4:
        if (toolbar.d != null)
        {
            toolbar.d.setImageDrawable(drawable);
        }
        return;
_L2:
        if (toolbar.d != null && toolbar.d.getParent() != null)
        {
            toolbar.removeView(toolbar.d);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(int i1)
    {
label0:
        {
            int j1 = c ^ i1;
            c = i1;
            if (j1 != 0)
            {
                if ((j1 & 4) != 0)
                {
                    if ((i1 & 4) != 0)
                    {
                        c();
                        b();
                    } else
                    {
                        a.a(null);
                    }
                }
                if ((j1 & 3) != 0)
                {
                    a();
                }
                if ((j1 & 8) != 0)
                {
                    if ((i1 & 8) != 0)
                    {
                        a.a(b);
                        a.b(h);
                    } else
                    {
                        a.a(null);
                        a.b(null);
                    }
                }
                if ((j1 & 0x10) != 0 && d != null)
                {
                    if ((i1 & 0x10) == 0)
                    {
                        break label0;
                    }
                    a.addView(d);
                }
            }
            return;
        }
        a.removeView(d);
    }

    private void b()
    {
label0:
        {
            if ((c & 4) != 0)
            {
                if (!TextUtils.isEmpty(i))
                {
                    break label0;
                }
                Toolbar toolbar = a;
                int i1 = k;
                CharSequence charsequence;
                if (i1 != 0)
                {
                    charsequence = toolbar.getContext().getText(i1);
                } else
                {
                    charsequence = null;
                }
                toolbar.c(charsequence);
            }
            return;
        }
        a.c(i);
    }

    private void c()
    {
        if ((c & 4) != 0)
        {
            Toolbar toolbar = a;
            Drawable drawable;
            if (g != null)
            {
                drawable = g;
            } else
            {
                drawable = l;
            }
            toolbar.a(drawable);
        }
    }
}
