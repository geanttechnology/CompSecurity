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
    implements android.view.mishFixActivity._cls4
{

    final BlemishFixActivity a;

    public final void onClick(View view)
    {
        if (!BlemishFixActivity.a(a).i)
        {
            (new Thread(new Runnable(view) {

                final View a;
                final BlemishFixActivity._cls4 b;

                public final void run()
                {
                    boolean flag;
                    boolean flag1 = false;
                    BlemishFixImageView blemishfiximageview = BlemishFixActivity.a(b.a);
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
                        b.a.runOnUiThread(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                a.b.a.b();
                                a.a.setEnabled(false);
                                a.b.a.findViewById(0x7f1001aa).setEnabled(false);
                                a.b.a.findViewById(0x7f1001a8).setEnabled(false);
                                BlemishFixActivity.a(a.b.a).invalidate();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return;
                    } else
                    {
                        b.a.runOnUiThread(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                a.b.a.b();
                                BlemishFixActivity.a(a.b.a).invalidate();
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        return;
                    }
                    flag = true;
                      goto _L1
                }

            
            {
                b = BlemishFixActivity._cls4.this;
                a = view;
                super();
            }
            })).start();
            a.a();
            return;
        } else
        {
            Utils.b(a, 0x7f080405);
            return;
        }
    }

    _cls1.a(BlemishFixActivity blemishfixactivity)
    {
        a = blemishfixactivity;
        super();
    }
}
