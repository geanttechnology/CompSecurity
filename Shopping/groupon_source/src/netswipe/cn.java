// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.location.Location;
import android.os.Build;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package netswipe:
//            cu, cl, de, cq, 
//            ck

class cn extends cu
{

    final cl a;
    private String c;

    public cn(cl cl1, String s)
    {
        a = cl1;
        super();
        c = "";
        c = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        b = new HttpPost(cl.b());
        b.setHeader("Authorization", (new StringBuilder()).append("Basic ").append(cl.a(a)).toString());
        b.setHeader("Accept", "application/json");
        b.setHeader("Content-Type", "application/json");
        b.setHeader("User-Agent", "Jumio Netswipe Android SDK 2.0.3");
        avoid = new de();
        de de1 = new de();
        de1.put("sdk-platform", "Android");
        de1.put("sdk-version", "2.0.3");
        de1.put("manufacturer", Build.MANUFACTURER);
        de1.put("model", Build.MODEL);
        de1.put("software-version", android.os.Build.VERSION.RELEASE);
        de1.put("software-build-number", Build.DISPLAY);
        de1.put("kernel-version", System.getProperty("os.version"));
        if (cl.b(a) != null)
        {
            de1.put("latitude", cl.b(a).getLatitude());
            de1.put("longitude", cl.b(a).getLongitude());
        }
        avoid.put("mobileDeviceDetail", de1);
        avoid.put("deviceFingerprint", cl.c(a));
        avoid.put("sessionId", cl.d(a));
        avoid.put("merchantReportingCriteria", c);
        ((HttpPost)b).setEntity(new StringEntity(avoid.toString()));
        a(30000);
        avoid = cl.e(a).execute(b);
        a(((HttpResponse) (avoid)));
        avoid = EntityUtils.toString(avoid.getEntity());
        if (avoid == null) goto _L2; else goto _L1
_L1:
        if (avoid.isEmpty()) goto _L2; else goto _L3
_L3:
        avoid = (new de(avoid)).optString("requestReference");
        boolean flag = true;
_L7:
        if (avoid.equals(""))
        {
            throw new cq(200, "no idScanReference received");
        }
          goto _L4
_L5:
        return Boolean.valueOf(flag);
_L4:
        try
        {
            cl.f(a).a(avoid);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            if (a())
            {
                cl.a(a, new TimeoutException(avoid.getMessage()), getClass());
                flag = false;
            } else
            {
                if (!isCancelled())
                {
                    cl.a(a, avoid, getClass());
                }
                flag = false;
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        avoid = "";
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void a(Boolean boolean1)
    {
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
