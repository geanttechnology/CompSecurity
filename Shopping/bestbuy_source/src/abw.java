// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class abw
{

    public static final abx a = new abx() {

        public Void a()
        {
            return null;
        }

        public Void a(InputStream inputstream)
        {
            return null;
        }

        public Object b()
        {
            return a();
        }

        public Object b(InputStream inputstream)
        {
            return a(inputstream);
        }

    };

    public abw()
    {
    }

    public Future a(String s, abx abx)
    {
        return abp.a(new Callable(s, abx) {

            final String a;
            final abx b;
            final abw c;

            public Object call()
            {
                Object obj;
                Object obj3;
                Object obj4;
                obj4 = null;
                obj = null;
                obj3 = null;
                Object obj1 = (HttpURLConnection)(new URL(a)).openConnection();
                p.a(((java.net.URLConnection) (obj1)));
                ((HttpURLConnection) (obj1)).connect();
                p.b(((java.net.URLConnection) (obj1)));
                p.a(((java.net.URLConnection) (obj1)));
                int i;
                i = ((HttpURLConnection) (obj1)).getResponseCode();
                p.b(((java.net.URLConnection) (obj1)));
                p.c(((java.net.URLConnection) (obj1)));
                if (i < 200 || i > 299) goto _L2; else goto _L1
_L1:
                obj = b.b(p.d(((java.net.URLConnection) (obj1))));
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
                return obj;
                obj;
                p.a(((java.net.URLConnection) (obj1)), ((IOException) (obj)));
                throw obj;
                Object obj2;
                obj2;
_L8:
                obj = obj1;
                acb.d("Error making HTTP request.", ((Throwable) (obj2)));
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
_L3:
                return b.b();
                obj;
                p.a(((java.net.URLConnection) (obj1)), ((IOException) (obj)));
                throw obj;
                obj2;
_L6:
                obj = obj1;
                acb.d("Error making HTTP request.", ((Throwable) (obj2)));
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
                  goto _L3
_L2:
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
                  goto _L3
                obj2;
                obj1 = obj;
                obj = obj2;
_L5:
                if (obj1 != null)
                {
                    ((HttpURLConnection) (obj1)).disconnect();
                }
                throw obj;
                obj;
                if (true) goto _L5; else goto _L4
_L4:
                obj2;
                obj1 = obj4;
                  goto _L6
                obj2;
                obj1 = obj3;
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                c = abw.this;
                a = s;
                b = abx1;
                super();
            }
        });
    }

}
