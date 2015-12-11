// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package oauth.signpost;

import com.google.gdata.util.common.base.PercentEscaper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import oauth.signpost.http.HttpParameters;

public class OAuth
{

    private static final PercentEscaper percentEncoder = new PercentEscaper("-._~", false);

    public static String addQueryParameters(String s, Map map)
    {
        String as[] = new String[map.size() * 2];
        int i = 0;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            as[i] = s1;
            as[i + 1] = (String)map.get(s1);
            i += 2;
        }

        return addQueryParameters(s, as);
    }

    public static transient String addQueryParameters(String s, String as[])
    {
        String s1;
        if (s.contains("?"))
        {
            s1 = "&";
        } else
        {
            s1 = "?";
        }
        s = new StringBuilder((new StringBuilder()).append(s).append(s1).toString());
        for (int i = 0; i < as.length; i += 2)
        {
            if (i > 0)
            {
                s.append("&");
            }
            s.append((new StringBuilder()).append(percentEncode(as[i])).append("=").append(percentEncode(as[i + 1])).toString());
        }

        return s.toString();
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

    public static String formEncode(Collection collection)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        formEncode(collection, ((OutputStream) (bytearrayoutputstream)));
        return new String(bytearrayoutputstream.toByteArray());
    }

    public static void formEncode(Collection collection, OutputStream outputstream)
        throws IOException
    {
        if (collection != null)
        {
            boolean flag = true;
            collection = collection.iterator();
            while (collection.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)collection.next();
                if (flag)
                {
                    flag = false;
                } else
                {
                    outputstream.write(38);
                }
                outputstream.write(percentEncode(safeToString(entry.getKey())).getBytes());
                outputstream.write(61);
                outputstream.write(percentEncode(safeToString(entry.getValue())).getBytes());
            }
        }
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
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

    public static final String safeToString(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return obj.toString();
        }
    }

}
