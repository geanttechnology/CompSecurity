// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.graphics.Bitmap;
import android.view.View;
import com.j.a.d.ag;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;

// Referenced classes of package com.j.a.g:
//            w

public class y
{

    public y()
    {
    }

    private static int a(Bitmap bitmap)
    {
        int i;
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 12)
            {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
            i = bitmap.getByteCount();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            w.b(com/j/a/g/y.getSimpleName(), bitmap);
            return 0xc3500;
        }
        return i;
    }

    public static String a(View view)
        throws JSONException
    {
        Bitmap bitmap;
        ByteArrayOutputStream bytearrayoutputstream;
        int i;
        view.setDrawingCacheEnabled(true);
        bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        bytearrayoutputstream = new ByteArrayOutputStream();
        i = view.getId();
        if (i == -1)
        {
            i = 1010;
        }
        Object obj;
        if (a(bitmap) <= 0xb71b0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        obj = android.graphics.Bitmap.CompressFormat.JPEG;
        view = (new StringBuilder()).append(String.valueOf(i)).append(".jpg").toString();
_L1:
        bitmap.compress(((android.graphics.Bitmap.CompressFormat) (obj)), 60, bytearrayoutputstream);
        obj = bytearrayoutputstream.toByteArray();
        ag.c().a(view, ((byte []) (obj)));
        return view;
        obj = android.graphics.Bitmap.CompressFormat.PNG;
        view = (new StringBuilder()).append(String.valueOf(i)).append(".png").toString();
          goto _L1
        Exception exception;
        exception;
        view = null;
_L3:
        w.b("Error creating screenshot: ", exception);
        return view;
        exception;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
