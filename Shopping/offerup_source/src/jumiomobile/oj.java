// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Build;
import com.jumio.netverify.sdk.core.ModelTemplate;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.SSLException;
import org.json.JSONObject;

// Referenced classes of package jumiomobile:
//            ai, cb, oa, hu, 
//            g, ag, oo, cs, 
//            ob

class oj extends ai
{

    final oa e;

    private oj(oa oa1)
    {
        e = oa1;
        super();
    }

    oj(oa oa1, ob ob)
    {
        this(oa1);
    }

    protected transient Boolean a(Void avoid[])
    {
        JSONObject jsonobject;
        StringBuilder stringbuilder;
        int i;
        boolean flag;
        cb.a(getClass());
        oa.a(e).c = hu.e;
        if (!e.e)
        {
            e.d = UUID.randomUUID();
        } else
        {
            e.e = false;
        }
        avoid = new JSONObject();
        avoid.put("sdk-platform", "Android");
        avoid.put("sdk-version", "JMSDK 1.7.0 (1441790640-34)");
        avoid.put("manufacturer", Build.MANUFACTURER);
        avoid.put("model", Build.MODEL);
        avoid.put("software-version", android.os.Build.VERSION.RELEASE);
        avoid.put("software-build-number", Build.DISPLAY);
        avoid.put("kernel-version", System.getProperty("os.version"));
        jsonobject = new JSONObject();
        if (!oa.a(e).x.equals(""))
        {
            jsonobject.put("merchantIdScanReference", oa.a(e).x);
        }
        if (!oa.a(e).y.equals(""))
        {
            jsonobject.put("merchantReportingCriteria", oa.a(e).y);
        }
        jsonobject.put("deviceDetail", avoid);
        jsonobject.put("requireVerification", oa.a(e).F);
        if (!oa.a(e).z.equals(""))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!oa.a(e).A.equals(""))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (oa.a(e).C == null || oa.a(e).C.length() == 0) goto _L2; else goto _L1
_L1:
        avoid = new ArrayList(Arrays.asList(oa.a(e).C.split(",")));
        if (g.a(oa.a(e).a) || !avoid.contains("idFaceMatch")) goto _L4; else goto _L3
_L3:
        avoid.remove("idFaceMatch");
_L12:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        avoid.remove("idFirstName");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_377;
        }
        avoid.remove("idLastName");
_L19:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        jsonobject.put("firstName", oa.a(e).z);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_421;
        }
        jsonobject.put("lastName", oa.a(e).A);
        if (!oa.a(e).B.equals(""))
        {
            jsonobject.put("customerId", oa.a(e).B);
        }
        if (!oa.a(e).i.equals(""))
        {
            jsonobject.put("callbackUrl", oa.a(e).i);
        }
        if (avoid == null) goto _L6; else goto _L5
_L5:
        if (avoid.size() == 0) goto _L6; else goto _L7
_L7:
        stringbuilder = new StringBuilder();
        i = 0;
_L9:
        if (i >= avoid.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        stringbuilder.append(",");
        stringbuilder.append((String)avoid.get(i));
        i++;
        if (true) goto _L9; else goto _L8
_L4:
        if (oa.a(e).s || !oa.a(e).t) goto _L11; else goto _L10
_L10:
        boolean flag1;
        avoid.remove("idFaceMatch");
          goto _L12
_L17:
        return Boolean.valueOf(flag1);
_L11:
        if (!oa.a(e).s || avoid.contains("idFaceMatch")) goto _L14; else goto _L13
_L13:
        avoid.add("idFaceMatch");
          goto _L12
_L14:
        if (oa.a(e).t || !avoid.contains("idFaceMatch")) goto _L12; else goto _L15
_L15:
        oa.a(e).s = true;
          goto _L12
_L8:
        jsonobject.put("enabledFields", stringbuilder.toString());
_L6:
        long l;
        avoid = new URL((new StringBuilder()).append(oa.l(e)).append(ag.a(new byte[] {
            111, -17, -97, -127, -78
        }, 0x543e3b2684b25382L)).toString());
        a = e.a("POST", avoid);
        l = System.currentTimeMillis();
        b(10000);
        a.getOutputStream().write(jsonobject.toString().getBytes());
        i = a.getResponseCode();
        long l1;
        l1 = System.currentTimeMillis();
        avoid = oa.b(e, a);
        a(i);
        JSONObject jsonobject1 = new JSONObject(avoid);
        oa.a(e).j = jsonobject1.getString("jumioIdScanReference");
        if (oo.a())
        {
            cs.a(String.format(Locale.getDefault(), "task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), oa.a(e).j, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
            }));
        }
          goto _L16
_L18:
        try
        {
            a(i);
            throw avoid;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            oa.a(e, avoid, getClass());
            flag1 = false;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (b())
            {
                oa.a(e, getClass(), true);
                flag1 = false;
            } else
            {
                if (!isCancelled())
                {
                    oa.a(e, avoid, getClass());
                }
                flag1 = false;
            }
        }
          goto _L17
        avoid;
          goto _L18
_L2:
        avoid = null;
          goto _L19
_L16:
        flag1 = true;
          goto _L17
        avoid;
        i = 0;
          goto _L18
    }

    protected void a(Boolean boolean1)
    {
        oa.a(e, this, boolean1);
        oa.a(e, boolean1, hu.f, hu.g);
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
