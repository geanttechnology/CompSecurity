// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import java.util.concurrent.Semaphore;

public class qa
{

    public static qa a;
    private String b;
    private Bitmap c;
    private String d;
    private Semaphore e;

    public qa()
    {
        b = "CameraImageKeeper";
        c = null;
        d = "";
        e = new Semaphore(2);
    }

    static String a(qa qa1)
    {
        return qa1.b;
    }

    public static qa a()
    {
        if (a == null)
        {
            a = new qa();
        }
        return a;
    }

    static Semaphore b(qa qa1)
    {
        return qa1.e;
    }

    public void a(Bitmap bitmap, String s, qc qc)
    {
        if (s == null)
        {
            return;
        } else
        {
            d = s;
            (new Thread(new qb(this, bitmap, s, qc))).start();
            return;
        }
    }

    public void b()
    {
        try
        {
            e.acquire();
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
            e.release();
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
