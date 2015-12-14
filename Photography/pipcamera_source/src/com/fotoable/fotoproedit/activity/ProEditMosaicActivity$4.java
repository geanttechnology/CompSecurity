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
                gm.c().a(new go() {

                    final ProEditMosaicActivity._cls4 a;

                    public void a()
                    {
                        a.b.setResult(-1);
                        a.b.b();
                        a.b.finish();
                        a.b.overridePendingTransition(0, 0x7f040027);
                    }

            
            {
                a = ProEditMosaicActivity._cls4.this;
                super();
            }
                }, a, b);
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b.b();
    }

    _cls1.a(ProEditMosaicActivity proeditmosaicactivity, Bitmap bitmap)
    {
        b = proeditmosaicactivity;
        a = bitmap;
        super();
    }
}
