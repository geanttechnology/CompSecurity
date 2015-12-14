// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import android.graphics.Point;
import java.util.ArrayList;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixImageView, a, BlemishFixActivity

final class b
    implements Runnable
{

    final BlemishFixImageView a;
    private Point b;

    public final void run()
    {
        BlemishFixImageView.a(a, b, (int)BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
        a a1 = new a(b, (int)BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
        com.picsart.effects.blemishfix.BlemishFixImageView.c(a).runOnUiThread(new Runnable(a1) {

            private a a;
            private BlemishFixImageView._cls2 b;

            public final void run()
            {
                ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.a)).b();
                b.a.h.add(a);
                ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.a)).a(true);
                b.a.invalidate();
                BlemishFixImageView.f(b.a);
            }

            
            {
                b = BlemishFixImageView._cls2.this;
                a = a1;
                super();
            }
        });
    }

    _cls1.a(BlemishFixImageView blemishfiximageview, Point point)
    {
        a = blemishfiximageview;
        b = point;
        super();
    }
}
