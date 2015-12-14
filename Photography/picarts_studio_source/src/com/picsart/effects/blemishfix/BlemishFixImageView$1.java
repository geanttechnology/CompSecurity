// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixImageView

final class b
    implements Runnable
{

    final float a;
    final float b;
    final BlemishFixImageView c;

    public final void run()
    {
        try
        {
            Thread.sleep(300L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        com.picsart.effects.blemishfix.BlemishFixImageView.c(c).runOnUiThread(new Runnable() {

            private BlemishFixImageView._cls1 a;

            public final void run()
            {
                if (!BlemishFixImageView.a(a.c))
                {
                    BlemishFixImageView.b(a.c).a(a.a, a.b);
                    a.c.invalidate();
                }
            }

            
            {
                a = BlemishFixImageView._cls1.this;
                super();
            }
        });
    }

    _cls1.a(BlemishFixImageView blemishfiximageview, float f, float f1)
    {
        c = blemishfiximageview;
        a = f;
        b = f1;
        super();
    }
}
