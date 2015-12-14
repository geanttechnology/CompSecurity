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
    implements gp
{

    final a a;

    public void a(String s)
    {
    }

    A(A a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/fotoable/fotoproedit/activity/ProEditMainActivity$1

/* anonymous class */
    class ProEditMainActivity._cls1
        implements Runnable
    {

        final String a;
        final ProEditMainActivity b;

        public void run()
        {
            Bitmap bitmap = BitmapFactory.decodeFile(a);
            b.runOnUiThread(new ProEditMainActivity._cls1._cls1(this, bitmap));
        }

            
            {
                b = proeditmainactivity;
                a = s;
                super();
            }
    }


    // Unreferenced inner class com/fotoable/fotoproedit/activity/ProEditMainActivity$1$1

/* anonymous class */
    class ProEditMainActivity._cls1._cls1
        implements Runnable
    {

        final Bitmap a;
        final ProEditMainActivity._cls1 b;

        public void run()
        {
            b.b.b();
            b.b.b.setImageBitmap(a);
            gm.c().a(a, new ProEditMainActivity._cls1._cls1._cls1(this));
        }

            
            {
                b = _pcls1;
                a = bitmap;
                super();
            }
    }

}
