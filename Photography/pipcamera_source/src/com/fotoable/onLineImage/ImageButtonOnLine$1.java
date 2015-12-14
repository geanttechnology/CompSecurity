// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.onLineImage;

import android.graphics.Bitmap;
import kz;

// Referenced classes of package com.fotoable.onLineImage:
//            ImageButtonOnLine

class a
    implements kz
{

    final ImageButtonOnLine a;

    public void a(Bitmap bitmap)
    {
        ImageButtonOnLine.access$000(a);
        ImageButtonOnLine.access$102(a, bitmap);
        a.setImageBitmap(ImageButtonOnLine.access$100(a));
    }

    public void a(Exception exception)
    {
    }

    (ImageButtonOnLine imagebuttononline)
    {
        a = imagebuttononline;
        super();
    }
}
