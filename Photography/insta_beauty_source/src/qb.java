// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.Test118.NativeView;
import com.instabeauty.application.InstaBeautyApplication;
import java.util.concurrent.Semaphore;

class qb
    implements Runnable
{

    final Bitmap a;
    final String b;
    final qc c;
    final qa d;

    qb(qa qa1, Bitmap bitmap, String s, qc qc1)
    {
        d = qa1;
        a = bitmap;
        b = s;
        c = qc1;
        super();
    }

    public void run()
    {
        d.b();
        Log.e(qa.a(d), "saveInstaBeautySrcBitmapAsync start");
        try
        {
            NativeView.a(a, b, 100);
            sm.a(b, InstaBeautyApplication.a);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            if (c != null)
            {
                c.b();
            }
            d.c();
            return;
        }
        d.c();
        if (c != null && qa.b(d).getQueueLength() <= 2)
        {
            c.a();
        }
    }
}
