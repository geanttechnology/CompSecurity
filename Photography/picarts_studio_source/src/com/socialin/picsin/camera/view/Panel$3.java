// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.socialin.picsin.camera.view:
//            Panel

final class a
    implements Runnable
{

    private Panel a;

    public final void run()
    {
        int i;
        int j;
        int i1;
        boolean flag1;
        boolean flag2;
        flag2 = true;
        flag1 = true;
        i1 = 0;
        if (Panel.a(a) == ate.FLYING)
        {
            Panel panel = a;
            int j1;
            if (Panel.e(a) == 0 || Panel.e(a) == 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (Panel.j(a) > 0.0F)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            Panel.a(panel, i ^ j);
        }
        if (Panel.d(a) != 1) goto _L2; else goto _L1
_L1:
        int k = Panel.g(a);
        if (!Panel.k(a))
        {
            i = k;
            if (Panel.e(a) == 0)
            {
                i = -k;
            }
            j = 0;
            k = i;
        } else
        {
            j = k;
            if (Panel.e(a) == 0)
            {
                j = -k;
            }
            k = 0;
        }
        if (Panel.a(a) == ate.TRACKING)
        {
            Object obj;
            int l;
            boolean flag;
            if (Math.abs(Panel.l(a) - (float)k) < Math.abs(Panel.l(a) - (float)j))
            {
                panel = a;
                if (Panel.k(a))
                {
                    flag1 = false;
                }
                Panel.a(panel, flag1);
            } else
            {
                k = j;
            }
            j = (int)Panel.l(a);
            i = k;
            k = j;
        } else
        {
            i = j;
            if (Panel.a(a) == ate.FLYING)
            {
                k = (int)Panel.l(a);
                i = j;
            }
        }
        if (Panel.a(a) == ate.FLYING && Panel.m(a))
        {
            j1 = Math.max((int)(Math.abs((float)(i - k) / Panel.j(a)) * 1000F), 20);
            j = 0;
            i1 = i;
            l = 0;
            i = j1;
        } else
        {
            if (Panel.g(a) > 0)
            {
                j = (Panel.n(a) * Math.abs(i - k)) / Panel.g(a);
            } else
            {
                j = 0;
            }
            flag = false;
            l = 0;
            i1 = i;
            i = j;
            j = ((flag) ? 1 : 0);
        }
        Panel.a(a, Panel.b(a, 0.0F));
        if (i == 0)
        {
            Panel.a(a, ate.READY);
            if (Panel.k(a))
            {
                Panel.c(a).setVisibility(8);
            }
            Panel.p(a);
            return;
        }
          goto _L3
_L2:
        k = Panel.f(a);
        if (!Panel.k(a))
        {
            i = k;
            if (Panel.e(a) == 2)
            {
                i = -k;
            }
            j = 0;
        } else
        {
            j = k;
            if (Panel.e(a) == 2)
            {
                j = -k;
            }
            i = 0;
        }
        if (Panel.a(a) == ate.TRACKING)
        {
            if (Math.abs(Panel.o(a) - (float)i) < Math.abs(Panel.o(a) - (float)j))
            {
                obj = a;
                if (!Panel.k(a))
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                Panel.a(((Panel) (obj)), flag1);
            } else
            {
                i = j;
            }
            j = (int)Panel.o(a);
            l = i;
            i = j;
        } else
        {
            l = j;
            if (Panel.a(a) == ate.FLYING)
            {
                i = (int)Panel.o(a);
                l = j;
            }
        }
        if (Panel.a(a) == ate.FLYING && Panel.m(a))
        {
            if (Panel.j(a) != 0.0F)
            {
                j = (int)(Math.abs((float)(l - i) / Panel.j(a)) * 1000F);
            } else
            {
                j = 0;
            }
            k = Math.max(j, 20);
            j = i;
            flag = false;
            i = k;
            k = ((flag) ? 1 : 0);
        } else
        if (Panel.f(a) != 0)
        {
            k = (Panel.n(a) * Math.abs(l - i)) / Panel.f(a);
            j = i;
            flag = false;
            i = k;
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 0;
            j = i;
            flag = false;
            i = k;
            k = ((flag) ? 1 : 0);
        }
        if (false)
        {
            break MISSING_BLOCK_LABEL_758;
        } else
        {
            break MISSING_BLOCK_LABEL_266;
        }
_L3:
        obj = new TranslateAnimation(j, l, k, i1);
        ((TranslateAnimation) (obj)).setDuration(i);
        ((TranslateAnimation) (obj)).setAnimationListener(Panel.q(a));
        if (Panel.a(a) != ate.FLYING || !Panel.m(a)) goto _L5; else goto _L4
_L4:
        ((TranslateAnimation) (obj)).setInterpolator(new LinearInterpolator());
_L7:
        a.startAnimation(((android.view.animation.Animation) (obj)));
        return;
_L5:
        if (Panel.r(a) != null)
        {
            ((TranslateAnimation) (obj)).setInterpolator(Panel.r(a));
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    r(Panel panel)
    {
        a = panel;
        super();
    }
}
