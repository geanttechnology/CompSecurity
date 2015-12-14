// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.onLineImage;

import android.graphics.Bitmap;
import kz;

// Referenced classes of package com.fotoable.onLineImage:
//            ImageViewOnline

class a
    implements kz
{

    final ImageViewOnline a;

    public void a(Bitmap bitmap)
    {
        ImageViewOnline.access$000(a);
        ImageViewOnline.access$102(a, bitmap);
        a.setImageBitmap(ImageViewOnline.access$100(a));
    }

    public void a(Exception exception)
    {
    }

    (ImageViewOnline imageviewonline)
    {
        a = imageviewonline;
        super();
    }
}
