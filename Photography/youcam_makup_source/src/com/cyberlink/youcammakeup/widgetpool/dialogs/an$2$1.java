// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            an

class a
    implements Runnable
{

    final String a;
    final a b;

    public void run()
    {
        com.cyberlink.youcammakeup.widgetpool.dialogs.a(b);
        ImageView imageview = (ImageView)b.b.getView().findViewById(0x7f0c071b);
        android.graphics.Bitmap bitmap;
        if (imageview != null)
        {
            if ((bitmap = BitmapFactory.decodeFile(a)) != null)
            {
                imageview.setImageBitmap(bitmap);
                return;
            }
        }
    }

    a(a a1, String s)
    {
        b = a1;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/an$2

/* anonymous class */
    class an._cls2
        implements l
    {

        final an a;

        private void a()
        {
            Globals.c(new an._cls2._cls2());
        }

        static void a(an._cls2 _pcls2)
        {
            _pcls2.a();
        }

        public void a(a a1)
        {
        }

        public void a(bn bn1)
        {
            if (bn1 == null);
            a();
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s)
        {
            Globals.d().a(Uri.fromFile(new File(s)));
            Globals.c(new an._cls2._cls1(this, s));
        }

        public void a(Void void1)
        {
            a();
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

        public void d(Object obj)
        {
            a((a)obj);
        }

            
            {
                a = an1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/an$2$2

/* anonymous class */
        class an._cls2._cls2
            implements Runnable
        {

            final an._cls2 a;

            public void run()
            {
                a.a.c.setVisibility(8);
            }

                    
                    {
                        a = an._cls2.this;
                        super();
                    }
        }

    }

}
