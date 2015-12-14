// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixImageView

final class a
    implements Runnable
{

    private lidate a;

    public final void run()
    {
        if (!BlemishFixImageView.a(a.a))
        {
            BlemishFixImageView.b(a.a).a(a.a, a.a);
            a.a.invalidate();
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/picsart/effects/blemishfix/BlemishFixImageView$1

/* anonymous class */
    final class BlemishFixImageView._cls1
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
            com.picsart.effects.blemishfix.BlemishFixImageView.c(c).runOnUiThread(new BlemishFixImageView._cls1._cls1(this));
        }

            
            {
                c = blemishfiximageview;
                a = f;
                b = f1;
                super();
            }
    }

}
