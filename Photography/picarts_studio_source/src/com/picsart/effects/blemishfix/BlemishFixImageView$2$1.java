// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import android.graphics.Point;
import java.util.ArrayList;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixImageView, BlemishFixActivity, a

final class a
    implements Runnable
{

    private a a;
    private b b;

    public final void run()
    {
        ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.b)).b();
        b.b.h.add(a);
        ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.b)).a(true);
        b.b.invalidate();
        BlemishFixImageView.f(b.b);
    }

    ( , a a1)
    {
        b = ;
        a = a1;
        super();
    }

    // Unreferenced inner class com/picsart/effects/blemishfix/BlemishFixImageView$2

/* anonymous class */
    final class BlemishFixImageView._cls2
        implements Runnable
    {

        final BlemishFixImageView a;
        private Point b;

        public final void run()
        {
            BlemishFixImageView.a(a, b, (int)BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
            a a1 = new a(b, (int)BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
            com.picsart.effects.blemishfix.BlemishFixImageView.c(a).runOnUiThread(new BlemishFixImageView._cls2._cls1(this, a1));
        }

            
            {
                a = blemishfiximageview;
                b = point;
                super();
            }
    }

}
