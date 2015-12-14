// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.crashlytics.android.Crashlytics;

class g.Object
    implements Runnable
{

    final byte a[];
    final a b;

    public void run()
    {
        b.b.a(b.b, a);
    }

    ( , byte abyte0[])
    {
        b = ;
        a = abyte0;
        super();
    }

    // Unreferenced inner class ahr$1

/* anonymous class */
    class ahr._cls1
        implements Runnable
    {

        final String a;
        final ahs b;
        final ahr c;

        public void run()
        {
            try
            {
                byte abyte0[] = c.a(a);
                ahr.a(c).post(new ahr._cls1._cls1(this, abyte0));
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
                RuntimeException runtimeexception = new RuntimeException(exception);
                ahr.a(c).post(new ahr._cls1._cls2(runtimeexception));
                return;
            }
        }

            
            {
                c = ahr1;
                a = s;
                b = ahs1;
                super();
            }

        // Unreferenced inner class ahr$1$2

/* anonymous class */
        class ahr._cls1._cls2
            implements Runnable
        {

            final Exception a;
            final ahr._cls1 b;

            public void run()
            {
                b.b.a(a);
            }

                    
                    {
                        b = ahr._cls1.this;
                        a = exception;
                        super();
                    }
        }

    }

}
