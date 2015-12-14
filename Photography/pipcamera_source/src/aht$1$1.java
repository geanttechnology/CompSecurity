// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.crashlytics.android.Crashlytics;

class g.Object
    implements Runnable
{

    final String a;
    final g.String b;

    public void run()
    {
        if (a == null)
        {
            Error error = new Error("error");
            b.b.a(aht.a(b.b), error);
            return;
        } else
        {
            b.b.a(aht.a(b.b), a);
            return;
        }
    }

    g.String( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class aht$1

/* anonymous class */
    class aht._cls1
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
                aht.b(c).post(new aht._cls1._cls1(this, s));
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            Error error = new Error("error");
            aht.b(c).post(new aht._cls1._cls2(error));
        }

            
            {
                c = aht1;
                a = s;
                b = ahu1;
                super();
            }

        // Unreferenced inner class aht$1$2

/* anonymous class */
        class aht._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
