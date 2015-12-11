// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLException;

// Referenced classes of package jumiomobile:
//            ai, cb, aa, ay, 
//            fl, ag, cs, fx

class fn extends ai
{

    final fl e;
    private byte f[];
    private int g;
    private int h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    public fn(fl fl1, String s, byte abyte0[], int i1, int j1, String s1, String s2, 
            String s3, String s4)
    {
        e = fl1;
        super();
        f = null;
        g = 0;
        h = 0;
        i = "";
        j = "";
        k = "";
        l = "";
        m = "";
        f = abyte0;
        g = i1;
        h = j1;
        i = s1;
        j = s2;
        k = s3;
        l = s4;
        m = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        boolean flag;
        flag = true;
        cb.a(getClass());
        byte abyte0[];
        avoid = new aa();
        aa aa1 = new aa();
        aa1.put("cameraPosition", i);
        aa1.put("orientationMode", j);
        aa1.put("imageSize", k);
        aa1.put("flashMode", l);
        avoid.put("cameraDeviceDetail", aa1);
        abyte0 = ay.a(f, g, h, android.graphics.Bitmap.CompressFormat.WEBP, 80);
        DataOutputStream dataoutputstream;
        a = e.a("POST", new URL((new StringBuilder()).append(fl.a(e)).append(m).append("/").append(ag.a(new byte[] {
            1, -114, -15, 83, -71, 50
        }, 0xb6f50d13ca3403c7L)).toString()));
        a.setDoOutput(true);
        a.setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(d).toString());
        dataoutputstream = new DataOutputStream(a.getOutputStream());
        int i1;
        long l1;
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        dataoutputstream.writeBytes("Content-Disposition: form-data; name=\"cameraDeviceDetail\"\r\n");
        dataoutputstream.writeBytes("Content-Type: application/json; charset=UTF-8\r\n");
        dataoutputstream.writeBytes((new StringBuilder("Content-Length: ")).append(avoid.toString().length()).append("\r\n").toString());
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes((new StringBuilder()).append(avoid.toString()).append("\r\n").toString());
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("\r\n").toString());
        dataoutputstream.writeBytes("Content-Disposition: form-data; name=\"image\"; filename=\"rawImage\"\r\n");
        dataoutputstream.writeBytes("Content-Type: image/webp\r\n");
        dataoutputstream.writeBytes((new StringBuilder("Content-Length: ")).append(abyte0.length).append("\r\n").toString());
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.write(abyte0);
        dataoutputstream.writeBytes("\r\n");
        dataoutputstream.writeBytes((new StringBuilder("--")).append(d).append("--\r\n").toString());
        dataoutputstream.flush();
        if (cs.a())
        {
            fx.a(abyte0, fx.a(fl.f(e), m), String.format("%s.webp", new Object[] {
                m
            }));
        }
        l1 = System.currentTimeMillis();
        b(0x15f90);
        i1 = a.getResponseCode();
        long l2 = System.currentTimeMillis();
        if (cs.a())
        {
            avoid = fl.b(e, a);
            fx.a(String.format("task: %s, scanref: %s time: %d, response: %d, message: %s", new Object[] {
                getClass().getName(), m, Long.valueOf(l2 - l1), Integer.valueOf(i1), avoid
            }));
        }
        try
        {
            dataoutputstream.close();
            a(i1);
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
        return Boolean.valueOf(flag);
        avoid;
        dataoutputstream = null;
        i1 = 0;
_L2:
        if (dataoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_628;
        }
        dataoutputstream.close();
        a(i1);
        throw avoid;
        avoid;
        i1 = 0;
        continue; /* Loop/switch isn't completed */
        avoid;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
        fl.a(e, m);
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
