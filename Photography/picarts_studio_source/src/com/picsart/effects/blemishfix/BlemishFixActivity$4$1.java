// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, BlemishFixImageView, a

final class a
    implements Runnable
{

    final View a;
    final alidate b;

    public final void run()
    {
        boolean flag;
        boolean flag1 = false;
        BlemishFixImageView blemishfiximageview = BlemishFixActivity.a(b.b);
        if (blemishfiximageview.h.size() <= 0 || blemishfiximageview.i)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        blemishfiximageview.i = true;
        blemishfiximageview.h.remove(blemishfiximageview.h.size() - 1);
        blemishfiximageview.b.position(0);
        blemishfiximageview.a.copyPixelsFromBuffer(blemishfiximageview.b);
        blemishfiximageview.c.position(0);
        blemishfiximageview.a.copyPixelsToBuffer(blemishfiximageview.c);
        for (int i = 0; i < blemishfiximageview.h.size(); i++)
        {
            a a1 = (a)blemishfiximageview.h.get(i);
            blemishfiximageview.a(a1.a, a1.b, a1.c, a1.d);
        }

        if (!blemishfiximageview.g.isFinishing())
        {
            blemishfiximageview.c.position(0);
            blemishfiximageview.a.copyPixelsFromBuffer(blemishfiximageview.c);
            blemishfiximageview.c.position(0);
        }
        blemishfiximageview.i = false;
        if (blemishfiximageview.h.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        flag = flag1;
_L1:
        if (flag)
        {
            b.b.runOnUiThread(new Runnable() {

                private BlemishFixActivity._cls4._cls1 a;

                public final void run()
                {
                    a.b.a.b();
                    a.a.setEnabled(false);
                    a.b.a.findViewById(0x7f1001aa).setEnabled(false);
                    a.b.a.findViewById(0x7f1001a8).setEnabled(false);
                    BlemishFixActivity.a(a.b.a).invalidate();
                }

            
            {
                a = BlemishFixActivity._cls4._cls1.this;
                super();
            }
            });
            return;
        } else
        {
            b.b.runOnUiThread(new Runnable() {

                private BlemishFixActivity._cls4._cls1 a;

                public final void run()
                {
                    a.b.a.b();
                    BlemishFixActivity.a(a.b.a).invalidate();
                }

            
            {
                a = BlemishFixActivity._cls4._cls1.this;
                super();
            }
            });
            return;
        }
        flag = true;
          goto _L1
    }

    _cls2.a(_cls2.a a1, View view)
    {
        b = a1;
        a = view;
        super();
    }

    // Unreferenced inner class com/picsart/effects/blemishfix/BlemishFixActivity$4

/* anonymous class */
    final class BlemishFixActivity._cls4
        implements android.view.View.OnClickListener
    {

        final BlemishFixActivity a;

        public final void onClick(View view)
        {
            if (!BlemishFixActivity.a(a).i)
            {
                (new Thread(new BlemishFixActivity._cls4._cls1(this, view))).start();
                a.a();
                return;
            } else
            {
                Utils.b(a, 0x7f080405);
                return;
            }
        }

            
            {
                a = blemishfixactivity;
                super();
            }
    }

}
