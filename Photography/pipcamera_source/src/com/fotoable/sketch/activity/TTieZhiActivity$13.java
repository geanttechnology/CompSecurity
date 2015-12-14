// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import gm;
import go;
import kf;
import ma;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements ma
{

    final TTieZhiActivity a;

    public void d()
    {
        while (a.e.getVisibility() == 0 || a.o != null && a.o.getVisibility() == 0 || a.h == null || a.h.isRecycled()) 
        {
            return;
        }
        kf.b("TieZhi");
        if (a.m != null && !a.m.hasTieZhi())
        {
            TTieZhiActivity.d(a);
            return;
        } else
        {
            TTieZhiActivity.a(a, true, "");
            (new Thread(new Runnable() {

                final TTieZhiActivity._cls13 a;

                public void run()
                {
                    Bitmap bitmap = TTieZhiActivity.a(a.a, a.a.h.getWidth(), a.a.h.getHeight());
                    a.a.runOnUiThread(new Runnable(this, bitmap) {

                        final Bitmap a;
                        final _cls1 b;

                        public void run()
                        {
                            if (a != null)
                            {
                                gm.c().a(new go(this) {

                                    final _cls1 a;

                                    public void a()
                                    {
                                        a.b.a.a.setResult(-1);
                                        TTieZhiActivity.a(a.b.a.a, false, "");
                                        a.b.a.a.finish();
                                        a.b.a.a.overridePendingTransition(0, 0x7f040027);
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                }, a, b.a.a);
                                return;
                            } else
                            {
                                TTieZhiActivity.a(b.a.a, false, "");
                                return;
                            }
                        }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
                    });
                }

            
            {
                a = TTieZhiActivity._cls13.this;
                super();
            }
            })).start();
            return;
        }
    }

    public void e()
    {
        TTieZhiActivity.c(a);
    }

    _cls1.a(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
