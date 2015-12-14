// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

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

public class bse
{

    public bse()
    {
    }

    private String a(String s, String s1, String s2)
    {
        Mac mac;
        StringBuilder stringbuilder;
        try
        {
            mac = Mac.getInstance("HmacSHA1");
            stringbuilder = (new StringBuilder()).append(bsh.a(s1)).append("&");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s1 = "";
_L4:
        mac.init(new SecretKeySpec(stringbuilder.append(s1).toString().getBytes(), "HmacSHA1"));
        return new String(bsa.a(mac.doFinal(s.getBytes())));
_L2:
        s1 = bsh.a(s2);
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
        stringbuilder.append(bsh.a(a(url)));
        stringbuilder.append("&");
        stringbuilder.append(bsh.a(a(list)));
        return stringbuilder.toString();
    }

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        QParameter qparameter;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(bsh.a(qparameter.getValue())))
        {
            qparameter = (QParameter)list.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(bsh.a(qparameter.getName()));
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

    public brz a(brz brz1)
    {
        String s = (new bsf()).a("https://open.t.qq.com/cgi-bin/request_token", a("https://open.t.qq.com/cgi-bin/request_token", "GET", brz1.d(), "", brz1.a()));
        System.out.println((new StringBuilder()).append("responseData:").append(s).toString());
        if (!a(s, brz1))
        {
            brz1.a(1);
        }
        return brz1;
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
            s = null;
        }
        s = a(((URL) (s)), s2, s3, s1, list);
        s1 = (new StringBuilder()).append(s5).append("&oauth_signature=").toString();
        return (new StringBuilder()).append(s1).append(bsh.a(s)).toString();
    }

    public boolean a(String s, brz brz1)
    {
        if (s != null && !s.equals(""))
        {
            brz1.f(s);
            s = s.split("&");
            if (s.length >= 2)
            {
                String s2 = s[0];
                String s1 = s[1];
                String as1[] = s2.split("=");
                if (as1.length >= 2)
                {
                    brz1.c(as1[1]);
                    String as[] = s1.split("=");
                    if (as.length >= 2)
                    {
                        brz1.d(as[1]);
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

    public brz b(brz brz1)
    {
        if (!a((new bsf()).a("https://open.t.qq.com/cgi-bin/access_token", a("https://open.t.qq.com/cgi-bin/access_token", "GET", brz1.d(), brz1.f(), brz1.b())), brz1))
        {
            brz1.a(2);
        }
        return brz1;
    }

    public bry c(brz brz1)
    {
        String s;
        String s1;
        String s2;
        String s7;
        String s8;
        Object obj;
        s = null;
        brz1 = new JSONObject((new brx()).a(brz1, "json"));
        if (brz1.getInt("ret") != 0)
        {
            return null;
        }
        obj = brz1.getJSONObject("data");
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
        brz1 = s2;
        if (!((JSONObject) (obj)).has("sex")) goto _L2; else goto _L1
_L1:
        int i = ((JSONObject) (obj)).getInt("sex");
        if (i != 1) goto _L4; else goto _L3
_L3:
        brz1 = "M";
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
        obj = new bry();
        ((bry) (obj)).a(s7);
        ((bry) (obj)).b(s8);
        ((bry) (obj)).e(s);
        ((bry) (obj)).f(s1);
        ((bry) (obj)).c(brz1);
        ((bry) (obj)).g(s2);
        ((bry) (obj)).h(s3);
        ((bry) (obj)).i(s4);
        ((bry) (obj)).j(s5);
        ((bry) (obj)).d(s6);
        return ((bry) (obj));
_L4:
        brz1 = s2;
        if (i == 2)
        {
            brz1 = "F";
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
