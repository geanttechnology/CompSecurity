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

    // Unreferenced inner class com/fotoable/fotoproedit/activity/ProEditAdjustActivity$3

/* anonymous class */
    class ProEditAdjustActivity._cls3
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
                gm.c().a(new ProEditAdjustActivity._cls3._cls1(this), a, b);
                return;
            }
        }

            
            {
                b = proeditadjustactivity;
                a = bitmap;
                super();
            }
    }

}
