// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.util.UUID;

class ng.Object
    implements Runnable
{

    final String a;
    final ng.String b;

    public void run()
    {
        if (b.b == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        android.graphics.Bitmap bitmap = BitmapFactory.decodeFile(a);
        b.b.a(bitmap);
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    ng.String(ng ng, String s)
    {
        b = ng;
        a = s;
        super();
    }

    // Unreferenced inner class ky$1

/* anonymous class */
    class ky._cls1
        implements Runnable
    {

        final String a;
        final Context b;
        final String c;
        final kz d;
        final ky e;

        public void run()
        {
            String s;
            s = UUID.randomUUID().toString();
            s = (new StringBuilder()).append(ky.a()).append("/").append(s).toString();
            e.a(a, s);
            la.a(b, ky.b, c, s);
            ky.a(e).post(new ky._cls1._cls1(this, s));
_L1:
            return;
            Exception exception;
            exception;
            if (d != null)
            {
                d.a(exception);
                return;
            }
              goto _L1
        }

            
            {
                e = ky1;
                a = s;
                b = context;
                c = s1;
                d = kz1;
                super();
            }
    }

}
