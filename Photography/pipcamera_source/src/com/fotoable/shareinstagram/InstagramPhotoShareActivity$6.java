// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.fotoable.shareinstagram:
//            InstagramPhotoShareActivity

class a
    implements Runnable
{

    final int a;
    final InstagramPhotoShareActivity b;

    public void run()
    {
        Bitmap bitmap = InstagramPhotoShareActivity.a(b.d, a);
        b.runOnUiThread(new Runnable(bitmap) {

            final Bitmap a;
            final InstagramPhotoShareActivity._cls6 b;

            public void run()
            {
                InstagramPhotoShareActivity.a(b.b);
                if (a == null || a.isRecycled())
                {
                    b.b.o.setImageBitmap(b.b.d);
                    return;
                } else
                {
                    b.b.o.setImageBitmap(a);
                    return;
                }
            }

            
            {
                b = InstagramPhotoShareActivity._cls6.this;
                a = bitmap;
                super();
            }
        });
    }

    _cls1.a(InstagramPhotoShareActivity instagramphotoshareactivity, int i)
    {
        b = instagramphotoshareactivity;
        a = i;
        super();
    }
}
