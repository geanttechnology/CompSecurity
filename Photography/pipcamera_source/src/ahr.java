// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ahr
{

    private ExecutorService a;
    private final Handler b = new Handler();

    public ahr()
    {
        a = Executors.newFixedThreadPool(5);
    }

    static Handler a(ahr ahr1)
    {
        return ahr1.b;
    }

    public byte[] a(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Crashlytics.logException(s);
                throw new RuntimeException(s);
            }
        }
          goto _L1
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        s.close();
        return abyte0;
    }

    public byte[] a(String s, ahs ahs)
    {
        a.submit(new Runnable(s, ahs) {

            final String a;
            final ahs b;
            final ahr c;

            public void run()
            {
                try
                {
                    byte abyte0[] = c.a(a);
                    ahr.a(c).post(new Runnable(this, abyte0) {

                        final byte a[];
                        final _cls1 b;

                        public void run()
                        {
                            b.b.a(b.a, a);
                        }

            
            {
                b = _pcls1;
                a = abyte0;
                super();
            }
                    });
                    return;
                }
                catch (Exception exception)
                {
                    Crashlytics.logException(exception);
                    RuntimeException runtimeexception = new RuntimeException(exception);
                    ahr.a(c).post(new Runnable(this, runtimeexception) {

                        final Exception a;
                        final _cls1 b;

                        public void run()
                        {
                            b.b.a(a);
                        }

            
            {
                b = _pcls1;
                a = exception;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                c = ahr.this;
                a = s;
                b = ahs;
                super();
            }
        });
        return null;
    }
}
