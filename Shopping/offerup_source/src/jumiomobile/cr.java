// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONException;

// Referenced classes of package jumiomobile:
//            am, ab, cq, aa

public class cr
    implements am
{

    private static String a = "https://acquisition.netverify.com/api/internal/acquisitions/dumpimage";
    private Context b;
    private String c;
    private String d;

    public cr()
    {
        d = "https://sdk.preprod.jumio.com";
    }

    public void a(Context context)
    {
        b = context;
    }

    public void a(String s)
    {
        c = s;
    }

    public boolean a()
    {
        return b != null;
    }

    public boolean a(String s, byte abyte0[], String s1, String s2, int i)
    {
        if (a != null && !a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_24;
        }
        ab.e("ImageDumpService", "no URL defined for current configuration!");
        return false;
        Object obj;
        obj = new URL(a);
        if (!((URL) (obj)).toString().contains("https://"))
        {
            break MISSING_BLOCK_LABEL_589;
        }
        cq cq1 = new cq(s);
        s = (HttpsURLConnection)((URL) (obj)).openConnection();
        obj = SSLContext.getInstance("TLS");
        ((SSLContext) (obj)).init(null, new TrustManager[] {
            cq1
        }, null);
        ((HttpsURLConnection)s).setSSLSocketFactory(((SSLContext) (obj)).getSocketFactory());
_L1:
        String s3;
        s.setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(c).toString());
        s.setRequestProperty("Accept", "application/json");
        s.setRequestProperty("User-Agent", "Jumio Netswipe Android SDK JMSDK 1.7.0 (1441790640-34)");
        s.setRequestProperty("X-TrackingId", s2);
        s2 = new aa();
        s2.put("channel", "NS_MOBILE");
        s2.put("public guid", s1);
        s2.put("timestamp", "0");
        s2.put("cctype", String.valueOf(i));
        s.setDoOutput(true);
        s3 = (new StringBuilder("+++_ImageDumpService_")).append(System.currentTimeMillis()).append("+++").toString();
        s.setRequestProperty("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(s3).toString());
        s1 = new DataOutputStream(s.getOutputStream());
        s1.writeBytes((new StringBuilder()).append("--").append(s3).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Disposition: form-data; name=\"metaData\"")).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Type: text/plain; charset=UTF-8")).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Length: ")).append(s2.toString().length()).append("\r\n").toString());
        s1.writeBytes((new StringBuilder()).append(s2.toString()).append("\r\n").toString());
        s1.writeBytes((new StringBuilder()).append("--").append(s3).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Disposition: form-data; name=\"image\"; filename=\"cc_front_01.webp\"")).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Type: image/webp")).append("\r\n").toString());
        s1.writeBytes((new StringBuilder("Content-Length: ")).append(abyte0.length).append("\r\n").toString());
        s1.writeBytes("\r\n");
        s1.write(abyte0);
        s1.writeBytes("\r\n");
        s1.writeBytes((new StringBuilder()).append("--").append(s3).append("\r\n").toString());
        s1.flush();
        i = s.getResponseCode();
        s1.close();
        ab.a("ImageDumpService", (new StringBuilder("IDS Response: ")).append(s.getResponseMessage()).toString());
        return i == 200;
        s = (HttpURLConnection)((URL) (obj)).openConnection();
          goto _L1
_L8:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        abyte0.close();
        throw s;
        s;
_L6:
        ab.a(s);
_L3:
        return false;
        s;
_L4:
        s.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        s;
          goto _L4
        s;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        abyte0 = s1;
        continue; /* Loop/switch isn't completed */
        s;
        abyte0 = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
