// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.onLineImage.ImageButtonOnLine;

public class aqv
    implements aqu
{

    final ImageButtonOnLine a;

    public aqv(ImageButtonOnLine imagebuttononline)
    {
        a = imagebuttononline;
        super();
    }

    public void a(Bitmap bitmap)
    {
        ImageButtonOnLine.access$000(a);
        ImageButtonOnLine.access$102(a, bitmap);
        a.setImageBitmap(ImageButtonOnLine.access$100(a));
    }

    public void a(Exception exception)
    {
    }
}
