// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import opens.components.http.EOnlineDownType;

public class aht
{

    protected int a;
    private EOnlineDownType b;
    private ExecutorService c;
    private final Handler d = new Handler();

    public aht()
    {
        a = 50000;
        c = Executors.newFixedThreadPool(1);
    }

    static String a(aht aht1, String s)
    {
        return aht1.a(s);
    }

    private String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        throw exception;
    }

    private String a(String s)
    {
        int i;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setConnectTimeout(a);
        i = s.getResponseCode();
        if (i != 200) goto _L2; else goto _L1
_L1:
        s = s.getInputStream();
_L4:
        if (i != 200 || s == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        s = a(((InputStream) (s)));
        return s;
        s;
        s.printStackTrace();
        Crashlytics.logException(s);
        return null;
        s;
        try
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
        }
        return null;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static EOnlineDownType a(aht aht1)
    {
        return aht1.b;
    }

    static Handler b(aht aht1)
    {
        return aht1.d;
    }

    public void a(String s, ahu ahu)
    {
        c.submit(new Runnable(s, ahu) {

            final String a;
            final ahu b;
            final aht c;

            public void run()
            {
                try
                {
                    String s1 = aht.a(c, a);
                    aht.b(c).post(new Runnable(this, s1) {

                        final String a;
                        final _cls1 b;

                        public void run()
                        {
                            if (a == null)
                            {
                                Error error = new Error("error");
                                b.b.a(aht.a(b.c), error);
                                return;
                            } else
                            {
                                b.b.a(aht.a(b.c), a);
                                return;
                            }
                        }

            
            {
                b = _pcls1;
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
                aht.b(c).post(new Runnable(this, error) {

                    final Error a;
                    final _cls1 b;

                    public void run()
                    {
                        b.b.a(aht.a(b.c), a);
                    }

            
            {
                b = _pcls1;
                a = error;
                super();
            }
                });
            }

            
            {
                c = aht.this;
                a = s;
                b = ahu;
                super();
            }
        });
    }

    public void a(EOnlineDownType eonlinedowntype)
    {
        b = eonlinedowntype;
    }
}
