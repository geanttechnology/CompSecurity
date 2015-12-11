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

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        b.a(a.a, a.a, a.a, a.a);
        n.a(b.b(a.a), b.c(a.a)[2], 0.3F, false);
    }

    lator(lator lator)
    {
        a = lator;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/b$8

/* anonymous class */
    class b._cls8
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
                Object obj1 = new b._cls8._cls1(this);
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

}
