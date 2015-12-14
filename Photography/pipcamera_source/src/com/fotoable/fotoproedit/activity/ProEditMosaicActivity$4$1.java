// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.graphics.Bitmap;
import gm;
import go;
import kf;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements go
{

    final ridePendingTransition a;

    public void a()
    {
        a.a.setResult(-1);
        a.a.b();
        a.a.finish();
        a.a.overridePendingTransition(0, 0x7f040027);
    }

    A(A a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/fotoable/fotoproedit/activity/ProEditMosaicActivity$4

/* anonymous class */
    class ProEditMosaicActivity._cls4
        implements Runnable
    {

        final Bitmap a;
        final ProEditMosaicActivity b;

        public void run()
        {
            try
            {
                if (a != null)
                {
                    kf.b("mosaic");
                    b.a();
                    gm.c().a(new ProEditMosaicActivity._cls4._cls1(this), a, b);
                }
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            b.b();
        }

            
            {
                b = proeditmosaicactivity;
                a = bitmap;
                super();
            }
    }

}
