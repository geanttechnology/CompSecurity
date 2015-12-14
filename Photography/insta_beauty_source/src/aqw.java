// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.onLineImage.ImageViewOnline;

public class aqw
    implements aqu
{

    final ImageViewOnline a;

    public aqw(ImageViewOnline imageviewonline)
    {
        a = imageviewonline;
        super();
    }

    public void a(Bitmap bitmap)
    {
        ImageViewOnline.access$000(a);
        ImageViewOnline.access$102(a, bitmap);
        a.setImageBitmap(ImageViewOnline.access$100(a));
    }

    public void a(Exception exception)
    {
    }
}
