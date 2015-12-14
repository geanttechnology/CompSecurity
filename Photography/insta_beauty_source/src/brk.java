// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.sina.WeiboException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

public abstract class brk
{

    public brk()
    {
    }

    private bru a(long l, long l1, brp brp1)
    {
        bru bru1 = new bru();
        bru1.a("oauth_consumer_key", brt.b());
        bru1.a("oauth_nonce", String.valueOf(l));
        bru1.a("oauth_signature_method", "HMAC-SHA1");
        bru1.a("oauth_timestamp", String.valueOf(l1));
        bru1.a("oauth_version", "1.0");
        if (brp1 != null)
        {
            bru1.a("oauth_token", brp1.a());
            return bru1;
        } else
        {
            bru1.a("source", brt.b());
            return bru1;
        }
    }

    private bru a(bru bru1, bru bru2, String s)
    {
        bru bru3 = new bru();
        bru3.a(bru1);
        bru3.a("source", brt.b());
        bru3.a(bru2);
        a(s, bru3);
        return a(bru3);
    }

    public static String a(bru bru1, String s, boolean flag)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < bru1.a(); i++)
        {
            if (stringbuffer.length() != 0)
            {
                if (flag)
                {
                    stringbuffer.append("\"");
                }
                stringbuffer.append(s);
            }
            stringbuffer.append(b(bru1.a(i))).append("=");
            if (flag)
            {
                stringbuffer.append("\"");
            }
            stringbuffer.append(b(bru1.b(i)));
        }

        if (stringbuffer.length() != 0 && flag)
        {
            stringbuffer.append("\"");
        }
        return stringbuffer.toString();
    }

    public static String a(String s)
    {
        String s1;
        String s2;
        int i;
        int j;
        i = s.indexOf("?");
        s1 = s;
        if (-1 != i)
        {
            s1 = s.substring(0, i);
        }
        i = s1.indexOf("/", 8);
        s2 = s1.substring(0, i).toLowerCase();
        j = s2.indexOf(":", 8);
        s = s2;
        if (-1 == j) goto _L2; else goto _L1
_L1:
        if (!s2.startsWith("http://") || !s2.endsWith(":80")) goto _L4; else goto _L3
_L3:
        s = s2.substring(0, j);
_L2:
        return (new StringBuilder()).append(s).append(s1.substring(i)).toString();
_L4:
        s = s2;
        if (s2.startsWith("https://"))
        {
            s = s2;
            if (s2.endsWith(":443"))
            {
                s = s2.substring(0, j);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private String a(String s, bru bru1, String s1, brp brp1)
    {
        s = (new StringBuffer(s)).append("&").append(b(a(s1))).append("&");
        s.append(b(a(bru1, "&", false)));
        return s.toString();
    }

    public static String b(String s)
    {
        StringBuffer stringbuffer = null;
        int i;
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = stringbuffer;
        }
        stringbuffer = new StringBuffer(s.length());
        i = 0;
        while (i < s.length()) 
        {
            char c = s.charAt(i);
            if (c == '*')
            {
                stringbuffer.append("%2A");
            } else
            if (c == '+')
            {
                stringbuffer.append("%20");
            } else
            if (c == '%' && i + 1 < s.length() && s.charAt(i + 1) == '7' && s.charAt(i + 2) == 'E')
            {
                stringbuffer.append('~');
                i += 2;
            } else
            {
                stringbuffer.append(c);
            }
            i++;
        }
        return stringbuffer.toString();
    }

    public abstract bru a(bru bru1);

    public abstract String a(String s, brp brp1);

    public String a(String s, String s1, bru bru1, String s2, String s3, brp brp1)
    {
        long l = System.currentTimeMillis() / 1000L;
        s2 = a(l + (long)(new Random()).nextInt(), l, brp1);
        s2.a("oauth_signature", a(a(s, a(((bru) (s2)), bru1, s1), s1, brp1), brp1));
        a(((bru) (s2)), bru1);
        return (new StringBuilder()).append("OAuth ").append(a(((bru) (s2)), ",", true)).toString();
    }

    public abstract void a(bru bru1, bru bru2);

    public void a(String s, bru bru1)
    {
        int i;
        int j;
        i = 0;
        j = s.indexOf("?");
        if (-1 == j) goto _L2; else goto _L1
_L1:
        s = s.substring(j + 1).split("&");
        String as[];
        try
        {
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new WeiboException(s);
        }
_L8:
        if (i >= j) goto _L2; else goto _L3
_L3:
        as = s[i].split("=");
        if (as.length != 2) goto _L5; else goto _L4
_L4:
        bru1.a(URLDecoder.decode(as[0], "UTF-8"), URLDecoder.decode(as[1], "UTF-8"));
          goto _L6
_L5:
        bru1.a(URLDecoder.decode(as[0], "UTF-8"), "");
          goto _L6
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
