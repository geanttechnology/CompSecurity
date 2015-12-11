// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.flurry.sdk:
//            m, gk, gd, fp, 
//            hq

class nit>
    implements 
{

    final ImageView a;
    final m b;

    public void a(gk gk1, Bitmap bitmap)
    {
        gd.a(3, m.a(), (new StringBuilder()).append("Image request -- HTTP status code is:").append(gk1.e()).toString());
        if (gk1.c())
        {
            fp.a().a(new hq(bitmap) {

                final Bitmap a;
                final m._cls1 b;

                public void safeRun()
                {
                    b.a.setImageBitmap(a);
                }

            
            {
                b = m._cls1.this;
                a = bitmap;
                super();
            }
            });
        }
    }

    public volatile void a(gk gk1, Object obj)
    {
        a(gk1, (Bitmap)obj);
    }

    eView(m m1, ImageView imageview)
    {
        b = m1;
        a = imageview;
        super();
    }
}
