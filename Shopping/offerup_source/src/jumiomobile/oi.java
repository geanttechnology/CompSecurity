// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            ai, cb, oa, hu, 
//            ag, oo, cs, ob

class oi extends ai
{

    final oa e;

    private oi(oa oa1)
    {
        e = oa1;
        super();
    }

    oi(oa oa1, ob ob)
    {
        this(oa1);
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag1;
        flag1 = true;
        cb.a(getClass());
        oa.a(e).c = hu.t;
        int i;
        long l;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            38, 90, 19, -37, -45, -48
        }, 0xbe73a308a57e9538L)).append(oa.a(e).j).append(ag.a(new byte[] {
            -33, -92, -126, 38, -74, 28, -46, -126, 92, 112, 
            13, -69, -125, -103, -14, -112
        }, 0x10bd4cdf17a775c8L)).toString());
        a = e.a("PUT", avoid);
        l = System.currentTimeMillis();
        b(10000);
        i = a.getResponseCode();
        long l1;
        l1 = System.currentTimeMillis();
        avoid = oa.g(e, a);
        a(i);
        boolean flag = flag1;
        if (!oo.a())
        {
            break MISSING_BLOCK_LABEL_338;
        }
        cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
            getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
        }));
        flag = flag1;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        i = 0;
_L3:
        try
        {
            a(i);
            throw avoid;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            oa.a(e, avoid, getClass());
            flag = false;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (b())
            {
                oa.a(e, getClass(), true);
                flag = false;
            } else
            {
                if (!isCancelled())
                {
                    oa.a(e, avoid, getClass());
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
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.u, hu.v);
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
