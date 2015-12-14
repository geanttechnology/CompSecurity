// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.wantu.weibo.other.tencent.beans.QParameter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class zn
{

    public zn()
    {
    }

    private String a(String s, String s1, String s2)
    {
        Mac mac;
        StringBuilder stringbuilder;
        try
        {
            mac = Mac.getInstance("HmacSHA1");
            stringbuilder = (new StringBuilder()).append(zq.a(s1)).append("&");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return null;
        }
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s1 = "";
_L4:
        mac.init(new SecretKeySpec(stringbuilder.append(s1).toString().getBytes(), "HmacSHA1"));
        return new String(zk.a(mac.doFinal(s.getBytes())));
_L2:
        s1 = zq.a(s2);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String a(URL url)
    {
        try
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(url.getProtocol());
            stringbuilder.append("://");
            stringbuilder.append(url.getHost());
            if ((url.getProtocol().equals("http") || url.getProtocol().equals("https")) && url.getPort() != -1)
            {
                stringbuilder.append(":");
                stringbuilder.append(url.getPort());
            }
            stringbuilder.append(url.getPath());
            url = stringbuilder.toString();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            Crashlytics.logException(url);
            return null;
        }
        return url;
    }

    private String a(URL url, String s, String s1, String s2, List list)
    {
        return a(a(url, s2, list), s, s1);
    }

    private String a(URL url, String s, List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s.toUpperCase());
        stringbuilder.append("&");
        stringbuilder.append(zq.a(a(url)));
        stringbuilder.append("&");
        stringbuilder.append(zq.a(a(list)));
        return stringbuilder.toString();
    }

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        QParameter qparameter;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(zq.a(qparameter.getValue())))
        {
            qparameter = (QParameter)list.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(zq.a(qparameter.getName()));
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

    public String a(String s, String s1, String s2, String s3, List list)
    {
        Collections.sort(list);
        String s5 = a(list);
        String s4 = s;
        if (s5 != null)
        {
            s4 = s;
            if (!s5.equals(""))
            {
                s4 = (new StringBuilder()).append(s).append("?").append(s5).toString();
            }
        }
        try
        {
            s = new URL(s4);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            System.err.println((new StringBuilder()).append("URL parse error:").append(s.getLocalizedMessage()).toString());
            Crashlytics.logException(s);
            s = null;
        }
        s = a(((URL) (s)), s2, s3, s1, list);
        s1 = (new StringBuilder()).append(s5).append("&oauth_signature=").toString();
        return (new StringBuilder()).append(s1).append(zq.a(s)).toString();
    }

    public zj a(zj zj1)
    {
        String s = (new zo()).a("https://open.t.qq.com/cgi-bin/request_token", a("https://open.t.qq.com/cgi-bin/request_token", "GET", zj1.d(), "", zj1.a()));
        System.out.println((new StringBuilder()).append("responseData:").append(s).toString());
        if (!a(s, zj1))
        {
            zj1.a(1);
        }
        return zj1;
    }

    public boolean a(String s, zj zj1)
    {
        if (s != null && !s.equals(""))
        {
            zj1.f(s);
            s = s.split("&");
            if (s.length >= 2)
            {
                String s2 = s[0];
                String s1 = s[1];
                String as1[] = s2.split("=");
                if (as1.length >= 2)
                {
                    zj1.c(as1[1]);
                    String as[] = s1.split("=");
                    if (as.length >= 2)
                    {
                        zj1.d(as[1]);
                        if (s.length == 3)
                        {
                            s = s[2].split("=");
                            if ("name".equals(s[0]))
                            {
                                if (s.length != 2);
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public zj b(zj zj1)
    {
        if (!a((new zo()).a("https://open.t.qq.com/cgi-bin/access_token", a("https://open.t.qq.com/cgi-bin/access_token", "GET", zj1.d(), zj1.f(), zj1.b())), zj1))
        {
            zj1.a(2);
        }
        return zj1;
    }

    public zi c(zj zj1)
    {
        String s;
        String s1;
        String s2;
        String s7;
        String s8;
        Object obj;
        s = null;
        zj1 = new JSONObject((new zh()).a(zj1, "json"));
        if (zj1.getInt("ret") != 0)
        {
            return null;
        }
        obj = zj1.getJSONObject("data");
        s7 = ((JSONObject) (obj)).getString("name");
        s8 = ((JSONObject) (obj)).getString("nick");
        if (((JSONObject) (obj)).has("uid"))
        {
            s = String.valueOf(((JSONObject) (obj)).getInt("uid"));
        }
        s1 = "";
        if (((JSONObject) (obj)).has("location"))
        {
            s1 = ((JSONObject) (obj)).getString("location");
        }
        s2 = "";
        zj1 = s2;
        if (!((JSONObject) (obj)).has("sex")) goto _L2; else goto _L1
_L1:
        int i = ((JSONObject) (obj)).getInt("sex");
        if (i != 1) goto _L4; else goto _L3
_L3:
        zj1 = "M";
_L2:
        s2 = "";
        if (((JSONObject) (obj)).has("birth_year"))
        {
            s2 = ((JSONObject) (obj)).getString("birth_year");
        }
        String s3 = "";
        if (((JSONObject) (obj)).has("country_code"))
        {
            s3 = ((JSONObject) (obj)).getString("country_code");
        }
        String s4 = "";
        if (((JSONObject) (obj)).has("province_code"))
        {
            s4 = ((JSONObject) (obj)).getString("province_code");
        }
        String s5 = "";
        if (((JSONObject) (obj)).has("city_code"))
        {
            s5 = ((JSONObject) (obj)).getString("city_code");
        }
        String s6 = "";
        if (((JSONObject) (obj)).has("fansnum"))
        {
            s6 = String.valueOf(((JSONObject) (obj)).getInt("fansnum"));
        }
        obj = new zi();
        ((zi) (obj)).a(s7);
        ((zi) (obj)).b(s8);
        ((zi) (obj)).e(s);
        ((zi) (obj)).f(s1);
        ((zi) (obj)).c(zj1);
        ((zi) (obj)).g(s2);
        ((zi) (obj)).h(s3);
        ((zi) (obj)).i(s4);
        ((zi) (obj)).j(s5);
        ((zi) (obj)).d(s6);
        return ((zi) (obj));
_L4:
        zj1 = s2;
        if (i == 2)
        {
            zj1 = "F";
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
