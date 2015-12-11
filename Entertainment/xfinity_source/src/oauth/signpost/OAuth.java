// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import com.google.gdata.util.common.base.PercentEscaper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import oauth.signpost.http.HttpParameters;

public class OAuth
{

    private static final PercentEscaper percentEncoder = new PercentEscaper("-._~", false);

    public static void debugOut(String s, String s1)
    {
        if (System.getProperty("debug") != null)
        {
            System.out.println((new StringBuilder()).append("[SIGNPOST] ").append(s).append(": ").append(s1).toString());
        }
    }

    public static HttpParameters decodeForm(InputStream inputstream)
        throws IOException
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        StringBuilder stringbuilder = new StringBuilder();
        for (inputstream = bufferedreader.readLine(); inputstream != null; inputstream = bufferedreader.readLine())
        {
            stringbuilder.append(inputstream);
        }

        return decodeForm(stringbuilder.toString());
    }

    public static HttpParameters decodeForm(String s)
    {
        HttpParameters httpparameters = new HttpParameters();
        if (!isEmpty(s))
        {
            String as[] = s.split("\\&");
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = as[i];
                int k = s1.indexOf('=');
                if (k < 0)
                {
                    s = percentDecode(s1);
                    s1 = null;
                } else
                {
                    s = percentDecode(s1.substring(0, k));
                    s1 = percentDecode(s1.substring(k + 1));
                }
                httpparameters.put(s, s1);
                i++;
            }
        }
        return httpparameters;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static HttpParameters oauthHeaderToParamsMap(String s)
    {
        HttpParameters httpparameters = new HttpParameters();
        if (s != null && s.startsWith("OAuth "))
        {
            s = s.substring("OAuth ".length()).split(",");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = s[i].split("=");
                httpparameters.put(as[0].trim(), as[1].replace("\"", "").trim());
                i++;
            }
        }
        return httpparameters;
    }

    public static String percentDecode(String s)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            s = URLDecoder.decode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage(), s);
        }
        return s;
    }

    public static String percentEncode(String s)
    {
        if (s == null)
        {
            return "";
        } else
        {
            return percentEncoder.escape(s);
        }
    }

    public static String toHeaderElement(String s, String s1)
    {
        return (new StringBuilder()).append(percentEncode(s)).append("=\"").append(percentEncode(s1)).append("\"").toString();
    }

}
