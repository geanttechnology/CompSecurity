// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Build;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            ai, fl, ah, cb, 
//            aa, cs, fx, fp

class fo extends ai
{

    final fl e;
    private String f;
    private boolean g;

    public fo(fl fl1, String s)
    {
        e = fl1;
        super();
        f = "";
        g = false;
        f = s;
        fl1.e = UUID.randomUUID();
        fl1.f = null;
    }

    protected transient Boolean a(Void avoid[])
    {
        cb.a(getClass());
        fl.a(e, false);
        fl.b(e, false);
        fl.c(e, false);
        avoid = new aa();
        aa aa1 = new aa();
        aa1.put("sdk-platform", "Android");
        aa1.put("sdk-version", "JMSDK 1.7.0 (1441790640-34)");
        aa1.put("manufacturer", Build.MANUFACTURER);
        aa1.put("model", Build.MODEL);
        aa1.put("software-version", android.os.Build.VERSION.RELEASE);
        aa1.put("software-build-number", Build.DISPLAY);
        aa1.put("kernel-version", System.getProperty("os.version"));
        avoid.put("mobileDeviceDetail", aa1);
        avoid.put("merchantReportingCriteria", f);
        avoid.put("dataTransferEnabledSupported", true);
        int i;
        long l;
        URL url = new URL(fl.a(e));
        a = e.a("POST", url);
        a.getOutputStream().write(avoid.toString().getBytes());
        l = System.currentTimeMillis();
        b(5000);
        i = a.getResponseCode();
        long l1;
        l1 = System.currentTimeMillis();
        avoid = fl.a(e, a);
        a(i);
        if (avoid == null)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        if (!avoid.isEmpty())
        {
            aa aa2 = new aa(avoid);
            e.f = aa2.optString("requestReference");
            fl.a(e, aa2.optBoolean("dataTransferEnabled", true));
            fl.b(e, aa2.optBoolean("highResImageTransmissionEnabled", false));
            fl.c(e, aa2.optBoolean("brandingEnabled", false));
            fl.d(e, aa2.optBoolean("logoDetectionEnabled", false));
            g = true;
        }
        if (cs.a())
        {
            cs.a("\r\n");
            fx.a(String.format("task: %s, scanref: %s, time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), e.f, Long.valueOf(l1 - l), Integer.valueOf(i), avoid
            }));
        }
        if (e.f.equals(""))
        {
            throw new ah(200, "no idScanReference received");
        }
_L2:
        if (!g)
        {
            fl.a(e, false);
            fl.b(e, false);
            fl.d(e, false);
        }
        return Boolean.valueOf(g);
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
            g = false;
            if (!b() && !isCancelled() && (avoid.b() || avoid.a() == 403))
            {
                fl.a(e, avoid, getClass());
            }
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            g = false;
            fl.a(e, avoid, getClass());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            g = false;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            g = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
        avoid;
          goto _L3
    }

    protected void a(Boolean boolean1)
    {
        (new Thread(new fp(this, null))).start();
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
