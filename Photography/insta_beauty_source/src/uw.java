// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.instabeauty.application.InstaBeautyApplication;

class uw
    implements Runnable
{

    final Bitmap a;
    final boolean b;
    final uy c;
    final uv d;

    uw(uv uv1, Bitmap bitmap, boolean flag, uy uy1)
    {
        d = uv1;
        a = bitmap;
        b = flag;
        c = uy1;
        super();
    }

    public void run()
    {
        d.a();
        float f;
        int i;
        i = azn.d();
        f = (float)uv.a(d).getWidth() / (float)uv.a(d).getHeight();
        if (f <= 1.0F)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        int k = (int)((float)i / f);
        int j;
        j = i;
        i = k;
_L1:
        try
        {
            uv.a(d, uv.b(d), a);
            if (b)
            {
                sm.a(uv.b(d), InstaBeautyApplication.a);
            }
            uv.a(d, Bitmap.createScaledBitmap(a, j, i, true));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        d.b();
        if (c != null)
        {
            c.a();
        }
        return;
        j = (int)(f * (float)i);
          goto _L1
    }
}
