// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            ai, cb, aa, fl, 
//            ag, cs, fx

class fr extends ai
{

    final fl e;
    private char f[];
    private char g[];
    private char h[];
    private String i;

    public fr(fl fl1, String s, char ac[], char ac1[], char ac2[])
    {
        e = fl1;
        super();
        i = "";
        i = s;
        f = Arrays.copyOf(ac, ac.length);
        g = Arrays.copyOf(ac1, ac1.length);
        h = Arrays.copyOf(ac2, ac2.length);
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag1;
        flag1 = true;
        cb.a(getClass());
        avoid = new aa();
        avoid.put("changedCardExpiryMonth", f);
        avoid.put("changedCardExpiryYear", g);
        avoid.put("changedCardHolderName", h);
        int j;
        long l;
        URL url = new URL((new StringBuilder()).append(fl.a(e)).append(i).append("/").append(ag.a(new byte[] {
            -98, -66, 73, -47, 98, 31
        }, 0xcd7953eb6c7773fbL)).toString());
        a = e.a("POST", url);
        a.getOutputStream().write(avoid.toString().getBytes("UTF-8"));
        l = System.currentTimeMillis();
        b(10000);
        j = a.getResponseCode();
        long l1;
        l1 = System.currentTimeMillis();
        avoid = fl.d(e, a);
        a(j);
        boolean flag = flag1;
        if (!cs.a())
        {
            break MISSING_BLOCK_LABEL_274;
        }
        fx.a(String.format("task: %s, scanref: %s time: %d, response: %d, message: %s", new Object[] {
            getClass().getName(), i, Long.valueOf(l1 - l), Integer.valueOf(j), avoid
        }));
        flag = flag1;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        j = 0;
_L3:
        try
        {
            a(j);
            throw avoid;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            fl.a(e, avoid, getClass());
            flag = false;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (b())
            {
                avoid = new TimeoutException(avoid.getMessage());
                fl.a(e, avoid, getClass());
                flag = false;
            } else
            {
                if (!isCancelled())
                {
                    fl.a(e, avoid, getClass());
                }
                flag = false;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        avoid;
          goto _L3
    }

    protected void a(Boolean boolean1)
    {
        fl.a(e, this, boolean1);
        Arrays.fill(f, '\0');
        Arrays.fill(g, '\0');
        Arrays.fill(h, '\0');
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
