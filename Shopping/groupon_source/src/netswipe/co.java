// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

// Referenced classes of package netswipe:
//            cu, cl, di, de, 
//            ck

class co extends cu
{

    final cl a;
    private String c;
    private String d;
    private NetswipeCardInformation e;
    private de f;
    private de g;

    public co(cl cl1, String s, NetswipeCardInformation netswipecardinformation, de de1, de de2, String s1)
    {
        a = cl1;
        super();
        c = "";
        d = "";
        c = s1;
        e = netswipecardinformation;
        f = de1;
        g = de2;
        d = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        b = new HttpPost((new StringBuilder()).append(cl.b()).append("/").append(d).append("/").append(di.a(new byte[] {
            -37, -73, -57, -11, 111, 113, -37
        }, 0x9e7e6332f10b04f8L)).toString());
        b.setHeader("Authorization", (new StringBuilder()).append("Basic ").append(cl.a(a)).toString());
        b.setHeader("Accept", "application/json");
        b.setHeader("Content-Type", "application/json");
        b.setHeader("User-Agent", "Jumio Netswipe Android SDK 2.0.3");
        avoid = new de();
        de de1 = new de();
        if (e.getCardNumber().length != 0)
        {
            de1.put("cardNumber", e.getCardNumber());
        }
        if (e.getExpiryDateMonth().length != 0)
        {
            de1.put("cardExpiryMonth", e.getExpiryDateMonth());
        }
        if (e.getExpiryDateYear().length != 0)
        {
            de1.put("cardExpiryYear", e.getExpiryDateYear());
        }
        de1.put("cardHolderName", e.getCardHolderName());
        de1.put("cardSortCode", e.getSortCode());
        de1.put("cardAccountNumber", e.getAccountNumber());
        de de2 = new de();
        de2.put("recognitionResult", c);
        if (f.length() != 0)
        {
            de2.put("digitCoordinates", f);
        }
        avoid.put("cardData", de1);
        avoid.put("ocrResult", de2);
        avoid.put("timings", g);
        ((HttpPost)b).setEntity(new StringEntity(avoid.toString()));
        avoid.a();
        a(30000);
        avoid = cl.e(a).execute(b);
        a(((HttpResponse) (avoid)));
        avoid.getEntity().consumeContent();
        boolean flag = true;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        boolean flag1 = false;
        if (a())
        {
            cl.a(a, new TimeoutException(avoid.getMessage()), getClass());
            flag = flag1;
        } else
        {
            flag = flag1;
            if (!isCancelled())
            {
                cl.a(a, avoid, getClass());
                flag = flag1;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
        cl.f(a).c(d);
        cl.a(a, boolean1);
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
