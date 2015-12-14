// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import gm;
import gp;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMainActivity

class a
    implements Runnable
{

    final String a;
    final ProEditMainActivity b;

    public void run()
    {
        Bitmap bitmap = BitmapFactory.decodeFile(a);
        b.runOnUiThread(new Runnable(bitmap) {

            final Bitmap a;
            final ProEditMainActivity._cls1 b;

            public void run()
            {
                b.b.b();
                b.b.b.setImageBitmap(a);
                gm.c().a(a, new gp(this) {

                    final _cls1 a;

                    public void a(String s)
                    {
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                b = ProEditMainActivity._cls1.this;
                a = bitmap;
                super();
            }
        });
    }

    _cls1.a(ProEditMainActivity proeditmainactivity, String s)
    {
        b = proeditmainactivity;
        a = s;
        super();
    }
}
