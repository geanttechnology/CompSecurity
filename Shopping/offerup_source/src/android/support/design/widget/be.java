// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package android.support.design.widget:
//            bf, bg

final class be
{

    private final ArrayList a = new ArrayList();
    private bg b;
    private Animation c;
    private WeakReference d;
    private android.view.animation.Animation.AnimationListener e;

    be()
    {
        b = null;
        c = null;
        e = new bf(this);
    }

    static Animation a(be be1)
    {
        return be1.c;
    }

    static Animation a(be be1, Animation animation)
    {
        be1.c = null;
        return null;
    }

    private View b()
    {
        if (d == null)
        {
            return null;
        } else
        {
            return (View)d.get();
        }
    }

    public final void a()
    {
        if (c != null)
        {
            View view = b();
            if (view != null && view.getAnimation() == c)
            {
                view.clearAnimation();
            }
        }
    }

    final void a(View view)
    {
        View view1 = b();
        if (view1 != view)
        {
            if (view1 != null)
            {
                View view2 = b();
                int j = a.size();
                for (int i = 0; i < j; i++)
                {
                    Animation animation = ((bg)a.get(i)).b;
                    if (view2.getAnimation() == animation)
                    {
                        view2.clearAnimation();
                    }
                }

                d = null;
                b = null;
                c = null;
            }
            if (view != null)
            {
                d = new WeakReference(view);
                return;
            }
        }
    }

    final void a(int ai[])
    {
        int i;
        int j;
        j = a.size();
        i = 0;
_L5:
        bg bg1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        bg1 = (bg)a.get(i);
        if (!StateSet.stateSetMatches(bg1.a, ai)) goto _L2; else goto _L1
_L1:
        ai = bg1;
_L8:
        if (ai != b) goto _L4; else goto _L3
_L3:
        return;
_L2:
        i++;
          goto _L5
_L4:
        if (b != null && c != null)
        {
            View view = b();
            if (view != null && view.getAnimation() == c)
            {
                view.clearAnimation();
            }
            c = null;
        }
        b = ai;
        if (ai == null) goto _L3; else goto _L6
_L6:
        c = ((bg) (ai)).b;
        ai = b();
        if (ai == null) goto _L3; else goto _L7
_L7:
        ai.startAnimation(c);
        return;
        ai = null;
          goto _L8
    }

    public final void a(int ai[], Animation animation)
    {
        ai = new bg(ai, animation, (byte)0);
        animation.setAnimationListener(e);
        a.add(ai);
    }
}
