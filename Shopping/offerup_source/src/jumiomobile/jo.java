// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;

// Referenced classes of package jumiomobile:
//            ay, jk, jp, ii

class jo
    implements Runnable
{

    final jk a;
    private Bitmap b;

    public jo(jk jk1, Bitmap bitmap)
    {
        a = jk1;
        super();
        b = bitmap;
    }

    public void run()
    {
        jk.b(a, ay.a(b, android.graphics.Bitmap.CompressFormat.JPEG, 80));
        jk.X(a).a(new jp(this));
    }
}
