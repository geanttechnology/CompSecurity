// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.Test118.NativeView;
import com.crashlytics.android.Crashlytics;
import java.util.concurrent.Semaphore;

public class sf
{

    public static sf a;
    private String b;
    private Bitmap c;
    private String d;
    private sg e;
    private Semaphore f;

    public sf()
    {
        b = "CameraImageKeeper";
        c = null;
        d = "";
        f = new Semaphore(2);
    }

    static String a(sf sf1)
    {
        return sf1.b;
    }

    public static sf a()
    {
        if (a == null)
        {
            a = new sf();
        }
        return a;
    }

    static sg b(sf sf1)
    {
        return sf1.e;
    }

    static Semaphore c(sf sf1)
    {
        return sf1.f;
    }

    public void a(Bitmap bitmap, String s, Context context, sg sg)
    {
        c = bitmap;
        e = sg;
        if (s == null)
        {
            return;
        } else
        {
            d = s;
            (new Thread(new Runnable(bitmap, s, context) {

                final Bitmap a;
                final String b;
                final Context c;
                final sf d;

                public void run()
                {
                    d.b();
                    Log.e(sf.a(d), "saveInstaBeautySrcBitmapAsync start");
                    try
                    {
                        NativeView.a(a, b, 100);
                        rd.a(b, c);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        if (sf.b(d) != null)
                        {
                            sf.b(d).b();
                        }
                        d.c();
                        return;
                    }
                    d.c();
                    if (sf.b(d) != null && sf.c(d).getQueueLength() <= 2)
                    {
                        sf.b(d).a();
                    }
                }

            
            {
                d = sf.this;
                a = bitmap;
                b = s;
                c = context;
                super();
            }
            })).start();
            return;
        }
    }

    public void b()
    {
        try
        {
            f.acquire();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Crashlytics.logException(interruptedexception);
            interruptedexception.printStackTrace();
            return;
        }
    }

    public void c()
    {
        try
        {
            f.release();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            exception.printStackTrace();
            return;
        }
    }
}
