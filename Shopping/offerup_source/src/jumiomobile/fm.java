// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.BitmapFactory;

// Referenced classes of package jumiomobile:
//            fl, cs

class fm
    implements Runnable
{

    final byte a[];
    final fl b;

    fm(fl fl1, byte abyte0[])
    {
        b = fl1;
        a = abyte0;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = BitmapFactory.decodeByteArray(a, 0, a.length);
        cs.a(fl.f(b), bitmap, cs.a(fl.f(b), b.f), (new StringBuilder()).append(b.f).append("_imagedump.webp").toString(), android.graphics.Bitmap.CompressFormat.WEBP, 80);
    }
}
