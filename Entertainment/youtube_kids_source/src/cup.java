// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.net.Uri;

final class cup
    implements bhv
{

    private cun a;

    cup(cun cun1)
    {
        a = cun1;
        super();
    }

    public final void a(Object obj, Exception exception)
    {
        obj = String.valueOf((Uri)obj);
        bmo.b((new StringBuilder(String.valueOf(obj).length() + 56)).append("Failed to get bitmap for playback controllers with URI: ").append(((String) (obj))).toString());
    }

    public final void a(Object obj, Object obj1)
    {
        obj1 = (Bitmap)obj1;
        cun cun1 = a;
        obj = a;
        int i = (int)((float)((Bitmap) (obj1)).getWidth() * 0.5625F);
        int j = (((Bitmap) (obj1)).getHeight() - i) / 2;
        obj = obj1;
        if (j > 0)
        {
            obj = Bitmap.createBitmap(((Bitmap) (obj1)), 0, j, ((Bitmap) (obj1)).getWidth(), i);
        }
        cun1.c.e = ((Bitmap) (obj));
        cun1.c();
    }
}
