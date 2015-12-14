// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;

class ux
    implements Runnable
{

    final Bitmap a;
    final uv b;

    ux(uv uv1, Bitmap bitmap)
    {
        b = uv1;
        a = bitmap;
        super();
    }

    public void run()
    {
        b.a();
        Log.e("MNewImageKeeper", "saveDisplayBitmap lock");
        uv.a(b, a);
        if (uv.c(b) != null)
        {
            uv.c(b).a();
            uv.a(b, null);
        }
        uv uv1 = b;
        uv1.a = uv1.a + 1;
        uv.a(b, b.a);
        uv.b(b, uv.b(b, b.a), uv.a(b));
        if (uv.d(b) - uv.e(b) < 6) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = uv.d(b) - 6;
        i = uv.e(b);
_L8:
        if (i >= j) goto _L4; else goto _L3
_L3:
        File file = new File(b.a(uv.b(b, i)));
        if (file == null) goto _L6; else goto _L5
_L5:
        if (file.exists())
        {
            file.delete();
        }
          goto _L6
_L4:
        try
        {
            uv.c(b, j + 1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
_L2:
        b.b();
        Log.e("MNewImageKeeper", "saveDisplayBitmap unlock");
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
