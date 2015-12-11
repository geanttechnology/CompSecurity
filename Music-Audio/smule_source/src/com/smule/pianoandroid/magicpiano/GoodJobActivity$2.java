// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.smule.android.c.aa;
import com.smule.magicpiano.MagicPerformanceStats;
import com.smule.pianoandroid.magicpiano.a.k;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class b
    implements android.animation.istener
{

    int a;
    final int b;
    final ProgressBar c;
    final String d;
    final MagicPerformanceStats e;
    final GoodJobActivity f;
    private int g;

    private void a(String s)
    {
        a = a + 1;
        ((ImageView)f.findViewById(f.getResources().getIdentifier((new StringBuilder()).append(s).append(a).toString(), "id", f.getPackageName()))).setImageResource(GoodJobActivity.a(f, k.values()[e.difficulty]));
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (c.getProgress() == 1000)
        {
            a(d);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
        a(d);
        c.setProgress(0);
        g = g - c.getMax();
        String s = GoodJobActivity.d();
        StringBuilder stringbuilder = (new StringBuilder()).append("next progress = ");
        int i;
        if (g >= c.getMax())
        {
            i = c.getMax();
        } else
        {
            i = g;
        }
        aa.a(s, stringbuilder.append(i).toString());
        animator = (ObjectAnimator)animator;
        if (g >= c.getMax())
        {
            i = c.getMax();
        } else
        {
            i = g;
        }
        animator.setIntValues(new int[] {
            i
        });
    }

    public void onAnimationStart(Animator animator)
    {
    }

    _cls9(GoodJobActivity goodjobactivity, int i, ProgressBar progressbar, String s, MagicPerformanceStats magicperformancestats)
    {
        f = goodjobactivity;
        b = i;
        c = progressbar;
        d = s;
        e = magicperformancestats;
        super();
        a = 0;
        g = b;
    }
}
