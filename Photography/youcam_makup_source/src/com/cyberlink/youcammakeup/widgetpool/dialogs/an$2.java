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
    implements l
{

    final an a;

    private void a()
    {
        Globals.c(new Runnable() {

            final an._cls2 a;

            public void run()
            {
                a.a.c.setVisibility(8);
            }

            
            {
                a = an._cls2.this;
                super();
            }
        });
    }

    static void a(a a1)
    {
        a1.a();
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
        Globals.c(new Runnable(s) {

            final String a;
            final an._cls2 b;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.an._cls2.a(b);
                ImageView imageview = (ImageView)b.a.getView().findViewById(0x7f0c071b);
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

            
            {
                b = an._cls2.this;
                a = s;
                super();
            }
        });
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

    _cls2.a(an an1)
    {
        a = an1;
        super();
    }
}
