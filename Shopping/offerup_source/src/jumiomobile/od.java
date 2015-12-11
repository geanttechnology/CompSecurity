// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, cb, oa, hu, 
//            ab, ag, oo, cs

class od extends ai
{

    final oa e;
    private Country f;
    private String g;
    private String h;

    public od(oa oa1, Country country, NVDocumentType nvdocumenttype, NVDocumentVariant nvdocumentvariant)
    {
        e = oa1;
        super();
        f = null;
        g = null;
        h = null;
        f = country;
        g = nvdocumenttype.toString();
        h = nvdocumentvariant.toString();
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag;
        flag = true;
        cb.a(getClass());
        oa.a(e).c = hu.h;
        ab.a("reactivate", (new StringBuilder("attemptTask: ")).append(oa.a(e).c.toString()).toString());
        int i;
        long l;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            38, 90, 19, -37, -45, -48
        }, 0xbe73a308a57e9538L)).append(oa.a(e).j).append(ag.a(new byte[] {
            60, -68, -8, -108, 29, 37, -11, -45, 36, -19, 
            76, -44, 32
        }, 0xa5416adaa03cda79L)).toString());
        a = e.a("PUT", avoid);
        avoid = new JSONObject();
        avoid.put("country", f.b());
        avoid.put("idType", g);
        avoid.put("documentVariant", h);
        a.getOutputStream().write(avoid.toString().getBytes());
        l = System.currentTimeMillis();
        b(10000);
        i = a.getResponseCode();
        long l1;
        l1 = System.currentTimeMillis();
        avoid = oa.c(e, a);
        try
        {
            a(i);
            if (oo.a())
            {
                cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                    getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
                }));
            }
            avoid = new JSONObject(avoid);
            if (!avoid.optString("httpStatus").isEmpty())
            {
                throw new Exception(avoid.optString("message"));
            }
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
        return Boolean.valueOf(flag);
        avoid;
        i = 0;
_L2:
        a(i);
        throw avoid;
        avoid;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.i, hu.j);
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
