// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.core.InternalCardInformation;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            ai, cb, aa, fl, 
//            ag, cs, fx

class fq extends ai
{

    final fl e;
    private String f;
    private String g;
    private InternalCardInformation h;
    private aa i;
    private aa j;
    private aa k;

    public fq(fl fl1, String s, InternalCardInformation internalcardinformation, aa aa1, aa aa2, aa aa3, String s1)
    {
        e = fl1;
        super();
        f = "";
        g = "";
        f = s1;
        h = internalcardinformation;
        i = aa1;
        j = aa2;
        k = aa3;
        g = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag1;
        flag1 = true;
        cb.a(getClass());
        avoid = new aa();
        aa aa1 = new aa();
        if (h.getCardNumber().length != 0)
        {
            aa1.put("cardNumber", h.getCardNumber());
        }
        if (h.getCardExpiryDateMonth().length != 0)
        {
            aa1.put("cardExpiryMonth", h.getCardExpiryDateMonth());
        }
        if (h.getCardExpiryDateYear().length != 0)
        {
            aa1.put("cardExpiryYear", h.getCardExpiryDateYear());
        }
        aa1.put("cardHolderName", h.getCardHolderName());
        aa1.put("cardSortCode", h.getCardSortCode());
        aa1.put("cardAccountNumber", h.getCardAccountNumber());
        aa1.put("cardUMP", h.c());
        aa aa2 = new aa();
        aa2.put("recognitionResult", f);
        if (i != null && i.length() != 0)
        {
            aa2.put("digitCoordinates", i);
        }
        if (j != null && j.length() != 0)
        {
            aa2.put("cvvCoordinates", j);
        }
        avoid.put("cardData", aa1);
        avoid.put("ocrResult", aa2);
        avoid.put("timings", k);
        int l;
        long l1;
        URL url = new URL((new StringBuilder()).append(fl.a(e)).append(g).append("/").append(ag.a(new byte[] {
            -37, -73, -57, -11, 111, 113, -37
        }, 0x9e7e6332f10b04f8L)).toString());
        a = e.a("POST", url);
        a.getOutputStream().write(avoid.toString().getBytes("UTF-8"));
        avoid.a();
        l1 = System.currentTimeMillis();
        b(10000);
        l = a.getResponseCode();
        long l2;
        l2 = System.currentTimeMillis();
        avoid = fl.c(e, a);
        a(l);
        boolean flag = flag1;
        if (!cs.a())
        {
            break MISSING_BLOCK_LABEL_495;
        }
        fx.a(String.format("task: %s, scanref: %s time: %d, response: %d, message: %s", new Object[] {
            getClass().getName(), g, Long.valueOf(l2 - l1), Integer.valueOf(l), avoid
        }));
        flag = flag1;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        l = 0;
_L3:
        try
        {
            a(l);
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
        if (h != null)
        {
            h.clear();
        }
        fl.b(e, g);
        fl.a(e, this, boolean1);
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
