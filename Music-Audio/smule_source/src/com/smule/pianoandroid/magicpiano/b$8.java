// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.media.SoundPool;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import com.d.a.d;
import com.smule.pianoandroid.utils.n;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            b

class e
    implements Runnable
{

    final boolean a;
    final int b;
    final int c;
    final int d;
    final Activity e;
    final b f;

    public void run()
    {
        if (com.smule.pianoandroid.magicpiano.b.d(f) != 0)
        {
            com.smule.pianoandroid.magicpiano.b.b(f).stop(com.smule.pianoandroid.magicpiano.b.d(f));
        }
        if (a)
        {
            Object obj = new Handler();
            Object obj1 = new Runnable() {

                final b._cls8 a;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.b.a(a.f, a.b, a.c, a.d);
                    n.a(com.smule.pianoandroid.magicpiano.b.b(a.f), com.smule.pianoandroid.magicpiano.b.c(a.f)[2], 0.3F, false);
                }

            
            {
                a = b._cls8.this;
                super();
            }
            };
            int i;
            long l;
            if (com.smule.pianoandroid.magicpiano.b.f()[1] != 0)
            {
                i = com.smule.pianoandroid.magicpiano.b.f()[1];
            } else
            {
                i = 2000;
            }
            ((Handler) (obj)).postDelayed(((Runnable) (obj1)), i + 200);
            n.a(com.smule.pianoandroid.magicpiano.b.b(f), com.smule.pianoandroid.magicpiano.b.c(f)[1], 0.3F, false);
            obj = e;
            if (com.smule.pianoandroid.magicpiano.b.f()[1] != 0)
            {
                l = com.smule.pianoandroid.magicpiano.b.f()[1];
            } else
            {
                l = 2500L;
            }
            obj = new d(((Activity) (obj)), 200, 0x7f020198, l);
            ((d) (obj)).b(0.7F, 1.3F);
            ((d) (obj)).a(0.1F, 0.25F);
            ((d) (obj)).c(90F, 180F);
            ((d) (obj)).a(200L, new AccelerateInterpolator());
            obj1 = f.e;
            if (com.smule.pianoandroid.magicpiano.b.f()[1] != 0)
            {
                i = com.smule.pianoandroid.magicpiano.b.f()[1];
            } else
            {
                i = 2500;
            }
            ((d) (obj)).a(((android.view.View) (obj1)), 5, 200, i);
            return;
        } else
        {
            com.smule.pianoandroid.magicpiano.b.a(f, b, c, d);
            return;
        }
    }

    _cls1.a(b b1, boolean flag, int i, int j, int k, Activity activity)
    {
        f = b1;
        a = flag;
        b = i;
        c = j;
        d = k;
        e = activity;
        super();
    }
}
