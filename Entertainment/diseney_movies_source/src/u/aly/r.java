// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package u.aly:
//            h, bi, bv, w, 
//            bj, bb, cc, f

public class r
{

    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private final int d = 1;
    private String e;
    private String f;
    private int g;
    private Context h;
    private w i;
    private f j;

    public r(Context context)
    {
        f = "10.0.0.172";
        g = 80;
        h = context;
        j = u.aly.h.b(context);
        e = a(context);
    }

    private String a(Context context)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("Android");
        stringbuffer.append("/");
        stringbuffer.append("5.2.4");
        stringbuffer.append(" ");
        try
        {
            StringBuffer stringbuffer1 = new StringBuffer();
            stringbuffer1.append(bi.v(context));
            stringbuffer1.append("/");
            stringbuffer1.append(bi.d(context));
            stringbuffer1.append(" ");
            stringbuffer1.append(Build.MODEL);
            stringbuffer1.append("/");
            stringbuffer1.append(android.os.Build.VERSION.RELEASE);
            stringbuffer1.append(" ");
            stringbuffer1.append(u.aly.bv.a(AnalyticsConfig.getAppkey(context)));
            stringbuffer.append(URLEncoder.encode(stringbuffer1.toString(), "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return stringbuffer.toString();
    }

    private boolean a()
    {
        if (h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", h.getPackageName()) != 0)
        {
            return false;
        }
        Object obj = ((ConnectivityManager)h.getSystemService("connectivity")).getActiveNetworkInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (((NetworkInfo) (obj)).getType() == 1)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = ((NetworkInfo) (obj)).getExtraInfo();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        boolean flag;
        if (((String) (obj)).equals("cmwap") || ((String) (obj)).equals("3gwap"))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        flag = ((String) (obj)).equals("uniwap");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        return true;
        Exception exception;
        exception;
        exception.printStackTrace();
        return false;
    }

    private byte[] a(byte abyte0[], String s)
    {
        HttpPost httppost;
        Object obj;
        httppost = new HttpPost(s);
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 10000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 30000);
        obj = new DefaultHttpClient(((HttpParams) (obj)));
        httppost.addHeader("X-Umeng-Sdk", e);
        httppost.addHeader("Msg-Type", "envelope");
        if (a())
        {
            HttpHost httphost = new HttpHost(f, g);
            ((HttpClient) (obj)).getParams().setParameter("http.route.default-proxy", httphost);
        }
        httppost.setEntity(new InputStreamEntity(new ByteArrayInputStream(abyte0), abyte0.length));
        if (i != null)
        {
            i.e();
        }
        abyte0 = ((HttpClient) (obj)).execute(httppost);
        if (i != null)
        {
            i.f();
        }
        int k = abyte0.getStatusLine().getStatusCode();
        u.aly.bj.a("MobclickAgent", (new StringBuilder("status code : ")).append(k).toString());
        if (abyte0.getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        u.aly.bj.a("MobclickAgent", (new StringBuilder("Sent message to ")).append(s).toString());
        abyte0 = abyte0.getEntity();
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        abyte0 = abyte0.getContent();
        s = bv.b(abyte0);
        bv.c(abyte0);
        return s;
        s;
        try
        {
            bv.c(abyte0);
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bj.b("MobclickAgent", "ClientProtocolException,Failed to send message.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            bj.b("MobclickAgent", "IOException,Failed to send message.", abyte0);
        }
        break MISSING_BLOCK_LABEL_304;
        return null;
        return null;
        return null;
    }

    private int b(byte abyte0[])
    {
        bb bb1 = new bb();
        cc cc1 = new cc(new cr.a());
        try
        {
            cc1.a(bb1, abyte0);
            if (bb1.a == 1)
            {
                j.b(bb1.j());
                j.c();
            }
            u.aly.bj.a("MobclickAgent", (new StringBuilder("send log:")).append(bb1.f()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        return bb1.a != 1 ? 3 : 2;
    }

    public int a(byte abyte0[])
    {
        byte abyte1[];
        int k;
        abyte1 = null;
        k = 0;
_L2:
        if (k >= a.f.length)
        {
            abyte0 = abyte1;
        } else
        {
label0:
            {
                abyte1 = a(abyte0, a.f[k]);
                if (abyte1 == null)
                {
                    break label0;
                }
                abyte0 = abyte1;
                if (i != null)
                {
                    i.c();
                    abyte0 = abyte1;
                }
            }
        }
        if (abyte0 == null)
        {
            return 1;
        } else
        {
            return b(abyte0);
        }
        if (i != null)
        {
            i.d();
        }
        k++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(w w1)
    {
        i = w1;
    }
}
