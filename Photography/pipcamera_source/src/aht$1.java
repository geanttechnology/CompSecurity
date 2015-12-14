// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.crashlytics.android.Crashlytics;

class ang.Object
    implements Runnable
{

    final String a;
    final ahu b;
    final aht c;

    public void run()
    {
        try
        {
            String s = aht.a(c, a);
            aht.b(c).post(new Runnable(s) {

                final String a;
                final aht._cls1 b;

                public void run()
                {
                    if (a == null)
                    {
                        Error error1 = new Error("error");
                        b.b.a(aht.a(b.c), error1);
                        return;
                    } else
                    {
                        b.b.a(aht.a(b.c), a);
                        return;
                    }
                }

            
            {
                b = aht._cls1.this;
                a = s;
                super();
            }
            });
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        Error error = new Error("error");
        aht.b(c).post(new Runnable(error) {

            final Error a;
            final aht._cls1 b;

            public void run()
            {
                b.b.a(aht.a(b.c), a);
            }

            
            {
                b = aht._cls1.this;
                a = error;
                super();
            }
        });
    }

    (aht aht1, String s, ahu ahu)
    {
        c = aht1;
        a = s;
        b = ahu;
        super();
    }
}
