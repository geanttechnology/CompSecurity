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
    implements Runnable
{

    final Bitmap a;
    final b b;

    public void run()
    {
        if (a != null)
        {
            gm.c().a(new go() {

                final TTieZhiActivity._cls13._cls1._cls1 a;

                public void a()
                {
                    a.b.a.a.setResult(-1);
                    TTieZhiActivity.a(a.b.a.a, false, "");
                    a.b.a.a.finish();
                    a.b.a.a.overridePendingTransition(0, 0x7f040027);
                }

            
            {
                a = TTieZhiActivity._cls13._cls1._cls1.this;
                super();
            }
            }, a, b.b.b);
            return;
        } else
        {
            TTieZhiActivity.a(b.b.b, false, "");
            return;
        }
    }

    _cls1.a(_cls1.a a1, Bitmap bitmap)
    {
        b = a1;
        a = bitmap;
        super();
    }

    // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$13

/* anonymous class */
    class TTieZhiActivity._cls13
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
                (new Thread(new TTieZhiActivity._cls13._cls1(this))).start();
                return;
            }
        }

        public void e()
        {
            TTieZhiActivity.c(a);
        }

            
            {
                a = ttiezhiactivity;
                super();
            }
    }


    // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$13$1

/* anonymous class */
    class TTieZhiActivity._cls13._cls1
        implements Runnable
    {

        final TTieZhiActivity._cls13 a;

        public void run()
        {
            Bitmap bitmap = TTieZhiActivity.a(a.a, a.a.h.getWidth(), a.a.h.getHeight());
            a.a.runOnUiThread(new TTieZhiActivity._cls13._cls1._cls1(this, bitmap));
        }

            
            {
                a = _pcls13;
                super();
            }
    }

}
