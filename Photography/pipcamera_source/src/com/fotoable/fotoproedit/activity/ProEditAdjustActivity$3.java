// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.graphics.Bitmap;
import gm;
import go;
import kf;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditAdjustActivity

class a
    implements Runnable
{

    final Bitmap a;
    final ProEditAdjustActivity b;

    public void run()
    {
        if (a == null || a == ProEditAdjustActivity.m(b))
        {
            b.b();
            b.finish();
            b.overridePendingTransition(0, 0x7f040027);
        } else
        if (a != null)
        {
            kf.b("adjust");
            b.a();
            gm.c().a(new go() {

                final ProEditAdjustActivity._cls3 a;

                public void a()
                {
                    a.b.setResult(-1);
                    a.b.b();
                    a.b.finish();
                    a.b.overridePendingTransition(0, 0x7f040027);
                }

            
            {
                a = ProEditAdjustActivity._cls3.this;
                super();
            }
            }, a, b);
            return;
        }
    }

    _cls1.a(ProEditAdjustActivity proeditadjustactivity, Bitmap bitmap)
    {
        b = proeditadjustactivity;
        a = bitmap;
        super();
    }
}
