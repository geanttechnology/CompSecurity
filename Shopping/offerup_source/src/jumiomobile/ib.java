// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import com.jumio.netverify.sdk.core.ModelTemplate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package jumiomobile:
//            hz, ii, oo, ic, 
//            ab

class ib
    implements Runnable
{

    final hz a;
    private Bitmap b;

    public ib(hz hz1, Bitmap bitmap)
    {
        a = hz1;
        super();
        b = bitmap;
    }

    public void run()
    {
        Object obj = new ByteArrayOutputStream();
        a.d.a(b, null, false);
        if (oo.a())
        {
            java.io.File file = oo.a(a.a, (new StringBuilder("LF_")).append(a.e.j).toString());
            oo.a(a.a, b, file, "exact.jpg", android.graphics.Bitmap.CompressFormat.JPEG, 80);
        }
        b.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, ((java.io.OutputStream) (obj)));
        hz.a(a, ((ByteArrayOutputStream) (obj)).toByteArray());
        ((ByteArrayOutputStream) (obj)).flush();
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ab.a(((Throwable) (obj)));
        }
_L2:
        a.d.a(new ic(this));
        return;
        Object obj1;
        obj1;
        ab.a(((Throwable) (obj1)));
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ab.a(((Throwable) (obj)));
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        try
        {
            ((ByteArrayOutputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            ab.a(ioexception);
        }
        throw obj1;
    }
}
