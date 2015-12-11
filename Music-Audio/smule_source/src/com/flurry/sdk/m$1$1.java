// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.flurry.sdk:
//            hq, m, gk, gd, 
//            fp

class it> extends hq
{

    final Bitmap a;
    final ap b;

    public void safeRun()
    {
        b.b.setImageBitmap(a);
    }

    ap(ap ap, Bitmap bitmap)
    {
        b = ap;
        a = bitmap;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/m$1

/* anonymous class */
    class m._cls1
        implements gk.a
    {

        final ImageView a;
        final m b;

        public void a(gk gk1, Bitmap bitmap)
        {
            gd.a(3, m.a(), (new StringBuilder()).append("Image request -- HTTP status code is:").append(gk1.e()).toString());
            if (gk1.c())
            {
                fp.a().a(new m._cls1._cls1(this, bitmap));
            }
        }

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (Bitmap)obj);
        }

            
            {
                b = m1;
                a = imageview;
                super();
            }
    }

}
