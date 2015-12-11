// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package c.a.a.a.a.e:
//            g, i, e, k

public final class d
{

    private static g a;
    private HttpURLConnection b;
    private URL c;
    private final String d;
    private k e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;

    private d(CharSequence charsequence, String s)
    {
        b = null;
        g = true;
        h = false;
        i = 8192;
        try
        {
            c = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new i(charsequence);
        }
        d = s;
    }

    static int a(d d1)
    {
        return d1.i;
    }

    private d a(InputStream inputstream, OutputStream outputstream)
    {
        return (d)(new e(this, inputstream, g, inputstream, outputstream)).call();
    }

    public static d a(CharSequence charsequence)
    {
        return new d(charsequence, "PUT");
    }

    public static d a(CharSequence charsequence, Map map, boolean flag)
    {
        return new d(c(a(charsequence, map)), "GET");
    }

    private d a(String s, String s1, String s2, String s3)
    {
        try
        {
            j();
            b(s, s1, ((String) (null)));
            e.a(s3);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new i(s);
        }
        return this;
    }

    private static String a(CharSequence charsequence, Map map)
    {
        Object obj;
        int l;
        int i1;
        obj = charsequence.toString();
        if (map == null || map.isEmpty())
        {
            return ((String) (obj));
        }
        charsequence = new StringBuilder(((String) (obj)));
        if (((String) (obj)).indexOf(':') + 2 == ((String) (obj)).lastIndexOf('/'))
        {
            charsequence.append('/');
        }
        l = ((String) (obj)).indexOf('?');
        i1 = charsequence.length() - 1;
        if (l != -1) goto _L2; else goto _L1
_L1:
        charsequence.append('?');
_L4:
        map = map.entrySet().iterator();
        obj = (java.util.Map.Entry)map.next();
        charsequence.append(((java.util.Map.Entry) (obj)).getKey().toString());
        charsequence.append('=');
        obj = ((java.util.Map.Entry) (obj)).getValue();
        if (obj != null)
        {
            charsequence.append(obj);
        }
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            charsequence.append('&');
            obj = (java.util.Map.Entry)map.next();
            charsequence.append(((java.util.Map.Entry) (obj)).getKey().toString());
            charsequence.append('=');
            obj = ((java.util.Map.Entry) (obj)).getValue();
            if (obj != null)
            {
                charsequence.append(obj);
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        if (l < i1 && ((String) (obj)).charAt(i1) != '&')
        {
            charsequence.append('&');
        }
        if (true) goto _L4; else goto _L3
_L3:
        return charsequence.toString();
    }

    public static d b(CharSequence charsequence)
    {
        return new d(charsequence, "DELETE");
    }

    public static d b(CharSequence charsequence, Map map, boolean flag)
    {
        return new d(c(a(charsequence, map)), "POST");
    }

    private d b(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"").append(s);
        if (s1 != null)
        {
            stringbuilder.append("\"; filename=\"").append(s1);
        }
        stringbuilder.append('"');
        c("Content-Disposition", stringbuilder.toString());
        if (s2 != null)
        {
            c("Content-Type", s2);
        }
        return d("\r\n");
    }

    static String b(String s)
    {
        return c(s);
    }

    private static String b(String s, String s1)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        int j1 = s.length();
        int l = s.indexOf(';') + 1;
        if (l == 0 || l == j1)
        {
            return null;
        }
        int i1 = s.indexOf(';', l);
        if (i1 == -1)
        {
            i1 = j1;
        }
        int k1;
        for (; l < i1; i1 = k1)
        {
            k1 = s.indexOf('=', l);
            if (k1 != -1 && k1 < i1 && s1.equals(s.substring(l, k1).trim()))
            {
                String s2 = s.substring(k1 + 1, i1).trim();
                l = s2.length();
                if (l != 0)
                {
                    s = s2;
                    if (l > 2)
                    {
                        s = s2;
                        if ('"' == s2.charAt(0))
                        {
                            s = s2;
                            if ('"' == s2.charAt(l - 1))
                            {
                                return s2.substring(1, l - 1);
                            }
                        }
                    }
                    continue; /* Loop/switch isn't completed */
                }
            }
            i1++;
            k1 = s.indexOf(';', i1);
            l = k1;
            if (k1 == -1)
            {
                l = j1;
            }
            k1 = l;
            l = i1;
        }

        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private d c(String s, String s1)
    {
        return d(s).d(": ").d(s1).d("\r\n");
    }

    private static String c(CharSequence charsequence)
    {
        String s;
        URL url;
        int l;
        try
        {
            url = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new i(charsequence);
        }
        s = url.getHost();
        l = url.getPort();
        charsequence = s;
        if (l != -1)
        {
            charsequence = (new StringBuilder()).append(s).append(':').append(Integer.toString(l)).toString();
        }
        try
        {
            s = (new URI(url.getProtocol(), charsequence, url.getPath(), url.getQuery(), null)).toASCIIString();
            l = s.indexOf('?');
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            IOException ioexception = new IOException("Parsing URI failed");
            ioexception.initCause(charsequence);
            throw new i(ioexception);
        }
        charsequence = s;
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        charsequence = s;
        if (l + 1 < s.length())
        {
            charsequence = (new StringBuilder()).append(s.substring(0, l + 1)).append(s.substring(l + 1).replace("+", "%2B")).toString();
        }
        return charsequence;
    }

    private static String c(String s)
    {
        if (s != null && s.length() > 0)
        {
            return s;
        } else
        {
            return "UTF-8";
        }
    }

    private d d(CharSequence charsequence)
    {
        try
        {
            i();
            e.a(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new i(charsequence);
        }
        return this;
    }

    private String d(String s)
    {
        h();
        int l = a().getHeaderFieldInt("Content-Length", -1);
        ByteArrayOutputStream bytearrayoutputstream;
        if (l > 0)
        {
            bytearrayoutputstream = new ByteArrayOutputStream(l);
        } else
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        try
        {
            a(new BufferedInputStream(f(), i), bytearrayoutputstream);
            s = bytearrayoutputstream.toString(c(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new i(s);
        }
        return s;
    }

    private HttpURLConnection e()
    {
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = a.a(c);
            httpurlconnection.setRequestMethod(d);
        }
        catch (IOException ioexception)
        {
            throw new i(ioexception);
        }
        return httpurlconnection;
    }

    private InputStream f()
    {
        Object obj;
        if (b() < 400)
        {
            try
            {
                obj = a().getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new i(((IOException) (obj)));
            }
        } else
        {
            InputStream inputstream1 = a().getErrorStream();
            obj = inputstream1;
            if (inputstream1 == null)
            {
                InputStream inputstream;
                try
                {
                    inputstream = a().getInputStream();
                }
                catch (IOException ioexception)
                {
                    throw new i(ioexception);
                }
                return inputstream;
            }
        }
        return ((InputStream) (obj));
    }

    private d g()
    {
        if (e == null)
        {
            return this;
        }
        if (f)
        {
            e.a("\r\n--00content0boundary00--\r\n");
        }
        if (g)
        {
            try
            {
                e.close();
            }
            catch (IOException ioexception) { }
        } else
        {
            e.close();
        }
        e = null;
        return this;
    }

    private d h()
    {
        d d1;
        try
        {
            d1 = g();
        }
        catch (IOException ioexception)
        {
            throw new i(ioexception);
        }
        return d1;
    }

    private d i()
    {
        if (e != null)
        {
            return this;
        } else
        {
            a().setDoOutput(true);
            String s = b(a().getRequestProperty("Content-Type"), "charset");
            e = new k(a().getOutputStream(), s, i);
            return this;
        }
    }

    private d j()
    {
        if (!f)
        {
            f = true;
            a("Content-Type", "multipart/form-data; boundary=00content0boundary00").i();
            e.a("--00content0boundary00\r\n");
            return this;
        } else
        {
            e.a("\r\n--00content0boundary00\r\n");
            return this;
        }
    }

    public final d a(String s, Number number)
    {
        if (number != null)
        {
            number = number.toString();
        } else
        {
            number = null;
        }
        return a(s, ((String) (null)), ((String) (number)));
    }

    public final d a(String s, String s1)
    {
        a().setRequestProperty(s, s1);
        return this;
    }

    public final d a(String s, String s1, String s2)
    {
        return a(s, s1, null, s2);
    }

    public final d a(String s, String s1, String s2, File file)
    {
        BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
        file = bufferedinputstream;
        s = a(s, s1, s2, ((InputStream) (bufferedinputstream)));
        try
        {
            bufferedinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return s;
        }
        return s;
        s;
        file = null;
_L4:
        throw new i(s);
        s;
_L2:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
        }
        throw s;
        s;
        file = null;
        if (true) goto _L2; else goto _L1
_L1:
        s;
        file = bufferedinputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final d a(String s, String s1, String s2, InputStream inputstream)
    {
        try
        {
            j();
            b(s, s1, s2);
            a(inputstream, ((OutputStream) (e)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new i(s);
        }
        return this;
    }

    public final String a(String s)
    {
        h();
        return a().getHeaderField(s);
    }

    public final HttpURLConnection a()
    {
        if (b == null)
        {
            b = e();
        }
        return b;
    }

    public final int b()
    {
        int l;
        try
        {
            g();
            l = a().getResponseCode();
        }
        catch (IOException ioexception)
        {
            throw new i(ioexception);
        }
        return l;
    }

    public final String c()
    {
        return d(b(a("Content-Type"), "charset"));
    }

    public final String d()
    {
        return a().getRequestMethod();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a().getRequestMethod()).append(' ').append(a().getURL()).toString();
    }

    static 
    {
        a = g.a;
    }
}
