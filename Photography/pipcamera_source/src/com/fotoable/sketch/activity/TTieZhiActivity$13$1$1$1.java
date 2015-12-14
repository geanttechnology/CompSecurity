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
    implements go
{

    final endingTransition a;

    public void a()
    {
        a.a.a.a.setResult(-1);
        TTieZhiActivity.a(a.a.a.a, false, "");
        a.a.a.a.finish();
        a.a.a.a.overridePendingTransition(0, 0x7f040027);
    }

    ( )
    {
        a = ;
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


    // Unreferenced inner class com/fotoable/sketch/activity/TTieZhiActivity$13$1$1

/* anonymous class */
    class TTieZhiActivity._cls13._cls1._cls1
        implements Runnable
    {

        final Bitmap a;
        final TTieZhiActivity._cls13._cls1 b;

        public void run()
        {
            if (a != null)
            {
                gm.c().a(new TTieZhiActivity._cls13._cls1._cls1._cls1(this), a, b.a.a);
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
    }

}
