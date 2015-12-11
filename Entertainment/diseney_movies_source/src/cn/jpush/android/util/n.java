// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package cn.jpush.android.util:
//            ac, x, ai, a, 
//            p, o

public final class n
{

    public static boolean a;
    private static final String z[];

    public static int a(Context context, JSONObject jsonobject, boolean flag)
    {
        Object obj = ac.a(2);
        if (!URLUtil.isHttpUrl(((String) (obj))))
        {
            x.f();
            return -1;
        }
        HttpPost httppost = new HttpPost(((String) (obj)));
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 30000);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 30000);
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient(((HttpParams) (obj)));
        if (context.getPackageManager().checkPermission(z[25], context.getPackageName()) == 0)
        {
            obj = ((ConnectivityManager)context.getSystemService(z[30])).getActiveNetworkInfo();
            if (obj != null && ((NetworkInfo) (obj)).getType() != 1)
            {
                obj = ((NetworkInfo) (obj)).getExtraInfo();
                if (obj != null && (((String) (obj)).equals(z[22]) || ((String) (obj)).equals(z[19]) || ((String) (obj)).equals(z[33])))
                {
                    defaulthttpclient.getParams().setParameter(z[34], new HttpHost(z[24], 80));
                }
            }
        }
        obj = "";
        if (jsonobject != null)
        {
            obj = jsonobject.toString();
        }
        if (ai.a(((String) (obj))))
        {
            x.c();
            return -2;
        }
        httppost.addHeader(z[28], z[31]);
        httppost.addHeader(z[26], z[21]);
        httppost.addHeader(z[35], z[21]);
        httppost.addHeader(z[23], cn.jpush.android.util.a.v(context));
        boolean flag1;
        if (obj == null)
        {
            context = ac.a(context);
        } else
        {
            context = ac.a(context, ((String) (obj)), 2);
        }
        if (ai.a(context))
        {
            x.c();
            flag1 = false;
        } else
        {
            context = ac.b(context);
            if (ai.a(context))
            {
                x.c();
                flag1 = false;
            } else
            {
                httppost.addHeader(z[29], (new StringBuilder(z[32])).append(context).toString());
                flag1 = true;
            }
        }
        if (!flag1)
        {
            x.c();
            return -3;
        }
        int i;
        try
        {
            jsonobject = ((String) (obj)).getBytes(z[10]);
            context = new ByteArrayOutputStream();
            obj = new GZIPOutputStream(context);
            ((OutputStream) (obj)).write(jsonobject);
            ((OutputStream) (obj)).close();
            jsonobject = context.toByteArray();
            context.close();
            context = new ByteArrayEntity(jsonobject);
            context.setContentEncoding(z[21]);
            httppost.setEntity(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -4;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -4;
        }
        i = defaulthttpclient.execute(httppost).getStatusLine().getStatusCode();
        (new StringBuilder(z[20])).append(i).toString();
        x.c();
        i;
        JVM INSTR lookupswitch 4: default 632
    //                   200: 643
    //                   401: 553
    //                   404: 560
    //                   429: 564;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return i / 100 != 5 ? -5 : 500;
_L3:
        x.e();
        return 401;
_L4:
        return 404;
_L5:
        return 429;
        context;
        (new StringBuilder(z[27])).append(context.getMessage()).toString();
        x.f();
_L6:
        return -1;
        context;
        (new StringBuilder(z[36])).append(context.getMessage()).toString();
        x.f();
          goto _L6
_L2:
        return 200;
    }

    public static String a(String s, int i, long l)
    {
        Object obj;
        Object obj1;
        Object obj2;
        long l1;
label0:
        {
            (new StringBuilder(z[3])).append(s).toString();
            x.c();
            if (l >= 200L)
            {
                l1 = l;
                if (l <= 60000L)
                {
                    break label0;
                }
            }
            l1 = 2000L;
        }
        obj2 = new HttpGet(s);
        ((HttpGet) (obj2)).addHeader(z[15], z[5]);
        obj = null;
        obj1 = null;
        i = 0;
_L9:
        Object obj3;
        a = true;
        obj3 = a().execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
        if (obj3 == null) goto _L2; else goto _L1
_L1:
        StatusLine statusline = ((HttpResponse) (obj3)).getStatusLine();
        if (statusline == null) goto _L2; else goto _L3
_L3:
        i = ((HttpResponse) (obj3)).getStatusLine().getStatusCode();
        obj2 = null;
        if (i < 200 || i >= 300) goto _L5; else goto _L4
_L4:
        s = ((String) (obj1));
        obj1 = ((HttpResponse) (obj3)).getEntity();
        s = ((String) (obj1));
        obj = obj1;
        obj2 = EntityUtils.toString(((HttpEntity) (obj1)), z[10]);
        s = ((String) (obj2));
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        s = ((String) (obj1));
        obj = obj1;
        x.h();
        s = ((String) (obj1));
        obj = obj1;
        obj2 = z[4];
        s = ((String) (obj2));
        obj = s;
        if (obj3 != null)
        {
            obj = s;
            if (obj1 != null)
            {
                try
                {
                    ((HttpEntity) (obj1)).consumeContent();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    x.i();
                    return s;
                }
                obj = s;
            }
        }
_L7:
        return ((String) (obj));
        obj3;
        x.h();
_L2:
        i++;
        if (i >= 5)
        {
            ((HttpGet) (obj2)).abort();
            return z[2];
        }
        try
        {
            Thread.sleep(l1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj3) { }
        continue; /* Loop/switch isn't completed */
        obj;
        obj = s;
        x.g();
        obj = s;
        obj1 = z[4];
        obj = obj1;
        if (obj3 != null)
        {
            obj = obj1;
            if (s != null)
            {
                try
                {
                    s.consumeContent();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    x.i();
                    return ((String) (obj1));
                }
                return ((String) (obj1));
            }
        }
        continue; /* Loop/switch isn't completed */
        s;
        if (obj3 != null && obj != null)
        {
            try
            {
                ((HttpEntity) (obj)).consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                x.i();
            }
        }
        throw s;
_L5:
        if (i < 400 || i >= 500)
        {
            break; /* Loop/switch isn't completed */
        }
        if (400 == i)
        {
            (new StringBuilder(z[11])).append(s).toString();
            x.c();
            return z[12];
        }
        if (401 == i)
        {
            (new StringBuilder(z[9])).append(s).toString();
            x.c();
            return z[4];
        }
        if (404 == i)
        {
            (new StringBuilder(z[13])).append(s).toString();
            x.c();
            return z[4];
        }
        if (406 == i)
        {
            (new StringBuilder(z[6])).append(s).toString();
            x.c();
            return z[4];
        }
        if (408 == i)
        {
            (new StringBuilder(z[14])).append(s).toString();
            x.c();
            return z[4];
        }
        obj = obj2;
        if (409 == i)
        {
            (new StringBuilder(z[0])).append(s).toString();
            x.c();
            return z[4];
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (i >= 500 && i < 600)
        {
            (new StringBuilder(z[8])).append(i).append(z[7]).append(s).toString();
            x.c();
            return z[4];
        }
        (new StringBuilder(z[1])).append(i).append(z[7]).append(s).toString();
        x.c();
        return z[4];
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static DefaultHttpClient a()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, z[10]);
        HttpProtocolParams.setUserAgent(basichttpparams, z[39]);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 30000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 30000);
        return new DefaultHttpClient(basichttpparams);
    }

    public static void a(String s, String s1, p p1)
    {
        cn/jpush/android/util/n;
        JVM INSTR monitorenter ;
        (new StringBuilder(z[37])).append(s).toString();
        x.b();
        if (!TextUtils.isEmpty(s) && s1 != null) goto _L2; else goto _L1
_L1:
        p1.a(false, "");
_L4:
        cn/jpush/android/util/n;
        JVM INSTR monitorexit ;
        return;
_L2:
        (new Thread(new o(s.trim(), s1, p1))).start();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static boolean a(String s)
    {
        return TextUtils.isEmpty(s) || s.equals(z[4]) || s.equals(z[12]) || s.equals(z[2]) || s.equals(z[38]);
    }

    public static byte[] a(String s, int i, long l, int j)
    {
        byte abyte0[] = null;
        i = 0;
        byte abyte1[];
        do
        {
            abyte1 = abyte0;
            if (i >= 4)
            {
                break;
            }
            abyte0 = b(s, 5, 5000L);
            abyte1 = abyte0;
            if (abyte0 != null)
            {
                break;
            }
            i++;
        } while (true);
        return abyte1;
    }

    private static byte[] b(String s, int i, long l)
    {
        int j;
label0:
        {
            if (i > 0)
            {
                j = i;
                if (i <= 10)
                {
                    break label0;
                }
            }
            j = 1;
        }
        {
            long l1;
label1:
            {
                if (l >= 200L)
                {
                    l1 = l;
                    if (l <= 60000L)
                    {
                        break label1;
                    }
                }
                l1 = 2000L;
            }
            (new StringBuilder(z[18])).append(s).toString();
            x.c();
            Object obj;
            byte abyte0[];
            Object obj1;
            Object obj2;
            try
            {
                obj = new HttpGet(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            ((HttpGet) (obj)).addHeader(z[15], z[5]);
            i = 0;
        }
        a = true;
        obj2 = a().execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        i = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
        if (200 != i) goto _L4; else goto _L3
_L3:
        s = ((HttpResponse) (obj2)).getEntity();
        if (s != null) goto _L6; else goto _L5
_L5:
        x.c();
        if (s != null)
        {
            try
            {
                s.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                x.h();
                return null;
            }
        }
_L12:
        return null;
        obj2;
        x.h();
_L2:
        i++;
        if (i >= j)
        {
            ((HttpGet) (obj)).abort();
            return null;
        }
        l = i;
        try
        {
            Thread.sleep(l * l1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        break MISSING_BLOCK_LABEL_92;
_L6:
        obj = ((HttpResponse) (obj2)).getFirstHeader(z[16]);
        if (obj == null) goto _L8; else goto _L7
_L7:
        abyte0 = ((Header) (obj)).getValue();
_L9:
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        i = Integer.parseInt(abyte0);
_L10:
        abyte0 = EntityUtils.toByteArray(((HttpResponse) (obj2)).getEntity());
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        x.c();
        if (s != null)
        {
            try
            {
                s.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                x.h();
                return null;
            }
            return null;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        abyte0 = null;
          goto _L9
        i = 0;
          goto _L10
        if (abyte0.length >= i)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        x.c();
        if (s != null)
        {
            try
            {
                s.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                x.h();
                return null;
            }
            return null;
        }
        if (true) goto _L12; else goto _L11
_L11:
        if (s != null)
        {
            try
            {
                s.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                x.h();
            }
        }
        return abyte0;
        s;
        s = null;
_L16:
        x.h();
        if (s == null) goto _L12; else goto _L13
_L13:
        try
        {
            s.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            x.h();
            return null;
        }
        return null;
        obj1;
        s = null;
_L15:
        if (s != null)
        {
            try
            {
                s.consumeContent();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                x.h();
            }
        }
        throw obj1;
_L4:
        if (400 == i)
        {
            (new StringBuilder(z[17])).append(s).toString();
            x.c();
            return null;
        }
        if (404 == i)
        {
            (new StringBuilder(z[13])).append(s).toString();
            x.c();
            return null;
        } else
        {
            (new StringBuilder(z[1])).append(i).append(z[7]).append(s).toString();
            x.c();
            return null;
        }
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L15; else goto _L14
_L14:
        obj1;
          goto _L16
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[40];
        i = 0;
        obj1 = "$\004\037a).\b\005=qwRQ*e";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac1[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac1 = ((String) (obj1)).toCharArray();
        j = ac1.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac1;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac1;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 1198
    //                   1 1205
    //                   2 1212
    //                   3 1219;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1219;
_L3:
        byte0 = 69;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "\b\037\031b7g\034\003h+ K\003b67\004\037t g\030\005f12\030Q*e";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "{W\027f,+\016\025X2.\037\031X7\"\037\003n 4UO";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "&\b\005n*)Q\031s178\030j5+\0166b1gFQ";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "{W\024u7(\031O9";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "\004\007\036t ";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = ")\004\005'$$\b\024w1&\t\035b\177s[G'hg";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "kK\004u)}";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "\024\016\003q 5K\024u7(\031Q*e";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "\025\016\000r 4\037Qi*3K\020r1/\004\003n?\"\017K3uvK\\'";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "\022?7*}";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "\024\016\003q 5K\003b67\004\037t g\r\020n)2\031\024=qw[Q*e";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "{W\027f,+\016\0259{";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "\025\016\000r 4\037Qw$3\003Qc*\"\030Qi*3K\024\177,4\037K'qw_Q*e";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            i = 14;
            obj1 = "5\016\000r 4\037Qs,*\016\036r1}_A?ejK";
            byte0 = 13;
            obj = as;
            break;

        case 13: // '\r'
            as1[j1] = ((String) (obj));
            i = 15;
            obj1 = "\004\004\037i $\037\030h+";
            byte0 = 14;
            obj = as;
            break;

        case 14: // '\016'
            as1[j1] = ((String) (obj));
            i = 16;
            obj1 = "\004\004\037s )\037\\K )\f\005o";
            byte0 = 15;
            obj = as;
            break;

        case 15: // '\017'
            as1[j1] = ((String) (obj));
            i = 17;
            obj1 = "4\016\003q 5K\003b67\004\037t g\r\020n)2\031\024'hg";
            byte0 = 16;
            obj = as;
            break;

        case 16: // '\020'
            as1[j1] = ((String) (obj));
            i = 18;
            obj1 = "&\b\005n*)Q\031s17,\024sejK";
            byte0 = 17;
            obj = as;
            break;

        case 17: // '\021'
            as1[j1] = ((String) (obj));
            i = 19;
            obj1 = "t\f\006f5";
            byte0 = 18;
            obj = as;
            break;

        case 18: // '\022'
            as1[j1] = ((String) (obj));
            i = 20;
            obj1 = "4\037\020s04K\022h!\"Q";
            byte0 = 19;
            obj = as;
            break;

        case 19: // '\023'
            as1[j1] = ((String) (obj));
            i = 21;
            obj1 = " \021\030w";
            byte0 = 20;
            obj = as;
            break;

        case 20: // '\024'
            as1[j1] = ((String) (obj));
            i = 22;
            obj1 = "$\006\006f5";
            byte0 = 21;
            obj = as;
            break;

        case 21: // '\025'
            as1[j1] = ((String) (obj));
            i = 23;
            obj1 = "\037F0w5j \024~";
            byte0 = 22;
            obj = as;
            break;

        case 22: // '\026'
            as1[j1] = ((String) (obj));
            i = 24;
            obj1 = "v[_7kwE@0w";
            byte0 = 23;
            obj = as;
            break;

        case 23: // '\027'
            as1[j1] = ((String) (obj));
            i = 25;
            obj1 = "&\005\025u*.\017_w 5\006\030t6.\004\037)\004\004(4T\026\030%4S\022\b9:X\026\023*%B";
            byte0 = 24;
            obj = as;
            break;

        case 24: // '\030'
            as1[j1] = ((String) (obj));
            i = 26;
            obj1 = "\006\b\022b53F4i&(\017\030i\"";
            byte0 = 25;
            obj = as;
            break;

        case 25: // '\031'
            as1[j1] = ((String) (obj));
            i = 27;
            obj1 = "\004\007\030b+3;\003h1(\b\036k\000?\b\024w1.\004\037=";
            byte0 = 26;
            obj = as;
            break;

        case 26: // '\032'
            as1[j1] = ((String) (obj));
            i = 28;
            obj1 = "\006\b\022b53";
            byte0 = 27;
            obj = as;
            break;

        case 27: // '\033'
            as1[j1] = ((String) (obj));
            i = 29;
            obj1 = "\006\036\005o*5\002\013f1.\004\037";
            byte0 = 28;
            obj = as;
            break;

        case 28: // '\034'
            as1[j1] = ((String) (obj));
            i = 30;
            obj1 = "$\004\037i $\037\030q,3\022";
            byte0 = 29;
            obj = as;
            break;

        case 29: // '\035'
            as1[j1] = ((String) (obj));
            i = 31;
            obj1 = "&\033\001k,$\n\005n*)D\033t*)";
            byte0 = 30;
            obj = as;
            break;

        case 30: // '\036'
            as1[j1] = ((String) (obj));
            i = 32;
            obj1 = "\005\n\002n&g";
            byte0 = 31;
            obj = as;
            break;

        case 31: // '\037'
            as1[j1] = ((String) (obj));
            i = 33;
            obj1 = "2\005\030p$7";
            byte0 = 32;
            obj = as;
            break;

        case 32: // ' '
            as1[j1] = ((String) (obj));
            i = 34;
            obj1 = "/\037\005wk5\004\004s i\017\024a$2\007\005*55\004\t~";
            byte0 = 33;
            obj = as;
            break;

        case 33: // '!'
            as1[j1] = ((String) (obj));
            i = 35;
            obj1 = "\004\004\037s )\037\\B+$\004\025n+ ";
            byte0 = 34;
            obj = as;
            break;

        case 34: // '"'
            as1[j1] = ((String) (obj));
            i = 36;
            obj1 = "\016$4\177&\"\033\005n*)Q\025b'2\f";
            byte0 = 35;
            obj = as;
            break;

        case 35: // '#'
            as1[j1] = ((String) (obj));
            i = 37;
            obj1 = "&\b\005n*)Q\025h2)\007\036f!\016\006\020` gFQr7+Q";
            byte0 = 36;
            obj = as;
            break;

        case 36: // '$'
            as1[j1] = ((String) (obj));
            i = 38;
            obj1 = "{W\037b10\004\003l 5\031\036u{y";
            byte0 = 37;
            obj = as;
            break;

        case 37: // '%'
            as1[j1] = ((String) (obj));
            i = 39;
            obj1 = "\r;$T\rj85L";
            byte0 = 38;
            obj = as;
            break;

        case 38: // '&'
            as1[j1] = ((String) (obj));
            z = as;
            a = false;
            return;
        }
          goto _L12
_L8:
        byte0 = 71;
          goto _L13
_L5:
        byte0 = 107;
          goto _L13
_L6:
        byte0 = 113;
          goto _L13
        byte0 = 7;
          goto _L13
    }
}
