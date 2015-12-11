// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.ModelTemplate;

// Referenced classes of package jumiomobile:
//            in, ii, iq, q, 
//            cs

class it extends Thread
{

    final in a;

    public it(in in1)
    {
        a = in1;
        super();
    }

    public void run()
    {
        boolean flag1 = false;
        byte abyte0[];
        android.graphics.Bitmap bitmap;
        boolean flag;
        if (in.s(a) + in.t(a) >= 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.d.a(0.0F);
        a.d.c(false);
        abyte0 = iq.b(in.e(a));
        if (iq.a(in.e(a)) == 90 || iq.a(in.e(a)) == 270)
        {
            flag1 = true;
        }
        bitmap = q.a(abyte0, flag1, in.a(a), 1.313025F);
        if (cs.a())
        {
            java.io.File file = cs.a(a.a, "");
            cs.a(a.a, bitmap, file, "liveness.jpg", android.graphics.Bitmap.CompressFormat.JPEG, 60);
        }
        a.d.a(bitmap, bitmap, true);
        a.e.I.setLivenessDetected(Boolean.valueOf(flag));
        a.d.c();
    }
}
