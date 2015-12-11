// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.w;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class o
{

    private static final Pattern a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");
    private static final Pattern b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");
    private static final Pattern c;
    private static final Pattern d;
    private String e;
    private String f;
    private final SortedMap g = new TreeMap();
    private String h;

    public o(String s)
    {
        e = "application";
        f = "octet-stream";
        c(s);
    }

    private boolean a(o o1)
    {
        return o1 != null && e.equalsIgnoreCase(o1.e) && f.equalsIgnoreCase(o1.f);
    }

    static boolean b(String s)
    {
        return b.matcher(s).matches();
    }

    public static boolean b(String s, String s1)
    {
        return s1 != null && (new o(s)).a(new o(s1));
    }

    private o c(String s)
    {
        s = c.matcher(s);
        w.a(s.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        String s1 = s.group(1);
        w.a(a.matcher(s1).matches(), "Type contains reserved characters");
        e = s1;
        h = null;
        s1 = s.group(2);
        w.a(a.matcher(s1).matches(), "Subtype contains reserved characters");
        f = s1;
        h = null;
        s = s.group(3);
        if (s != null)
        {
            String s3;
            for (Matcher matcher = d.matcher(s); matcher.find(); a(s3, s))
            {
                s3 = matcher.group(1);
                String s2 = matcher.group(3);
                s = s2;
                if (s2 == null)
                {
                    s = matcher.group(2);
                }
            }

        }
        return this;
    }

    public final o a(String s, String s1)
    {
        if (s1 == null)
        {
            h = null;
            g.remove(s.toLowerCase());
            return this;
        } else
        {
            w.a(b.matcher(s).matches(), "Name contains reserved characters");
            h = null;
            g.put(s.toLowerCase(), s1);
            return this;
        }
    }

    public final String a()
    {
        if (h != null)
        {
            return h;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(e);
        stringbuilder.append('/');
        stringbuilder.append(f);
        if (g != null)
        {
            Object obj;
            for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(((String) (obj))))
            {
                obj = (java.util.Map.Entry)iterator.next();
                String s = (String)((java.util.Map.Entry) (obj)).getValue();
                stringbuilder.append("; ");
                stringbuilder.append((String)((java.util.Map.Entry) (obj)).getKey());
                stringbuilder.append("=");
                obj = s;
                if (!b(s))
                {
                    obj = String.valueOf(String.valueOf(s.replace("\\", "\\\\").replace("\"", "\\\"")));
                    obj = (new StringBuilder(((String) (obj)).length() + 2)).append("\"").append(((String) (obj))).append("\"").toString();
                }
            }

        }
        h = stringbuilder.toString();
        return h;
    }

    public final String a(String s)
    {
        return (String)g.get(s.toLowerCase());
    }

    public final Charset b()
    {
        String s = a("charset");
        if (s == null)
        {
            return null;
        } else
        {
            return Charset.forName(s);
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof o)
        {
            if (a(((o) (obj = (o)obj))) && g.equals(((o) (obj)).g))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return a().hashCode();
    }

    public final String toString()
    {
        return a();
    }

    static 
    {
        String s = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        String s1 = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        String s2 = String.valueOf(String.valueOf(";.*"));
        c = Pattern.compile((new StringBuilder(s.length() + 14 + s1.length() + s2.length())).append("\\s*(").append(s).append(")/(").append(s1).append(")\\s*(").append(s2).append(")?").toString(), 32);
        s = String.valueOf(String.valueOf("\"([^\"]*)\""));
        s1 = String.valueOf(String.valueOf("[^\\s;\"]*"));
        s1 = (new StringBuilder(s.length() + 1 + s1.length())).append(s).append("|").append(s1).toString();
        s = String.valueOf(String.valueOf("[^\\s/=;\"]+"));
        s1 = String.valueOf(String.valueOf(s1));
        d = Pattern.compile((new StringBuilder(s.length() + 12 + s1.length())).append("\\s*;\\s*(").append(s).append(")=(").append(s1).append(")").toString());
    }
}
