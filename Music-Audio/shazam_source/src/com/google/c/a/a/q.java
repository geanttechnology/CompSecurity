// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.c.a.a:
//            j, i

public final class q extends j
{

    private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern b = Pattern.compile("\r\n[ \t]");
    private static final Pattern c = Pattern.compile("\\\\[nN]");
    private static final Pattern d = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern e = Pattern.compile("=");
    private static final Pattern f = Pattern.compile(";");
    private static final Pattern g = Pattern.compile("(?<!\\\\);+");

    public q()
    {
    }

    static List a(CharSequence charsequence, String s)
    {
        ArrayList arraylist;
        int k;
        int j1;
        k = 0;
        j1 = s.length();
        arraylist = null;
_L4:
        if (k >= j1) goto _L2; else goto _L1
_L1:
        Object obj;
        int l;
        obj = Pattern.compile((new StringBuilder("(?:^|\n)")).append(charsequence).append("(?:;([^:]*))?:").toString(), 2).matcher(s);
        l = k;
        if (k > 0)
        {
            l = k - 1;
        }
        if (!((Matcher) (obj)).find(l)) goto _L2; else goto _L3
_L3:
        int k1 = ((Matcher) (obj)).end(0);
        String s1 = ((Matcher) (obj)).group(1);
        Object obj1 = null;
        int i1 = 0;
        k = 0;
        Object obj2 = null;
        obj = null;
        int i2;
        if (s1 != null)
        {
            String as[] = f.split(s1);
            int l1 = as.length;
            i1 = 0;
            while (i1 < l1) 
            {
                String s2 = as[i1];
                obj2 = obj1;
                if (obj1 == null)
                {
                    obj2 = new ArrayList(1);
                }
                ((List) (obj2)).add(s2);
                obj1 = e.split(s2, 2);
                if (obj1.length > 1)
                {
                    String s3 = obj1[0];
                    obj1 = obj1[1];
                    if ("ENCODING".equalsIgnoreCase(s3) && "QUOTED-PRINTABLE".equalsIgnoreCase(((String) (obj1))))
                    {
                        k = 1;
                    } else
                    if ("CHARSET".equalsIgnoreCase(s3))
                    {
                        obj = obj1;
                    }
                }
                i1++;
                obj1 = obj2;
            }
            i1 = k;
        } else
        {
            obj1 = null;
            obj = obj2;
        }
        k = k1;
        do
        {
            i2 = s.indexOf('\n', k);
            if (i2 < 0)
            {
                break;
            }
            if (i2 < s.length() - 1 && (s.charAt(i2 + 1) == ' ' || s.charAt(i2 + 1) == '\t'))
            {
                k = i2 + 2;
                continue;
            }
            if (i1 == 0 || (i2 <= 0 || s.charAt(i2 - 1) != '=') && (i2 < 2 || s.charAt(i2 - 2) != '='))
            {
                break;
            }
            k = i2 + 1;
        } while (true);
        if (i2 < 0)
        {
            k = j1;
        } else
        if (i2 > k1)
        {
            if (arraylist == null)
            {
                arraylist = new ArrayList(1);
            }
            k = i2;
            if (i2 > 0)
            {
                k = i2;
                if (s.charAt(i2 - 1) == '\r')
                {
                    k = i2 - 1;
                }
            }
            obj2 = s.substring(k1, k).trim();
            if (i1 != 0)
            {
                obj = c(((CharSequence) (obj2)), ((String) (obj)));
            } else
            {
                obj = b.matcher(((CharSequence) (obj2))).replaceAll("");
                obj = c.matcher(((CharSequence) (obj))).replaceAll("\n");
                obj = d.matcher(((CharSequence) (obj))).replaceAll("$1");
            }
            if (obj1 == null)
            {
                obj1 = new ArrayList(1);
                ((List) (obj1)).add(obj);
                arraylist.add(obj1);
            } else
            {
                ((List) (obj1)).add(0, obj);
                arraylist.add(obj1);
            }
            k++;
        } else
        {
            k = i2 + 1;
        }
        if (true) goto _L4; else goto _L2
_L2:
        return arraylist;
    }

    private static void a(ByteArrayOutputStream bytearrayoutputstream, String s, StringBuilder stringbuilder)
    {
        if (bytearrayoutputstream.size() > 0)
        {
            byte abyte0[] = bytearrayoutputstream.toByteArray();
            if (s == null)
            {
                s = new String(abyte0, Charset.forName("UTF-8"));
            } else
            {
                try
                {
                    s = new String(abyte0, s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s = new String(abyte0, Charset.forName("UTF-8"));
                }
            }
            bytearrayoutputstream.reset();
            stringbuilder.append(s);
        }
    }

    static List b(CharSequence charsequence, String s)
    {
        charsequence = a(charsequence, s);
        if (charsequence == null || charsequence.isEmpty())
        {
            return null;
        } else
        {
            return (List)charsequence.get(0);
        }
    }

    private static String c(CharSequence charsequence, String s)
    {
        StringBuilder stringbuilder;
        ByteArrayOutputStream bytearrayoutputstream;
        int k;
        int i1;
        i1 = charsequence.length();
        stringbuilder = new StringBuilder(i1);
        bytearrayoutputstream = new ByteArrayOutputStream();
        k = 0;
_L8:
        if (k >= i1) goto _L2; else goto _L1
_L1:
        char c1;
        int l;
        c1 = charsequence.charAt(k);
        l = k;
        c1;
        JVM INSTR lookupswitch 3: default 88
    //                   10: 107
    //                   13: 107
    //                   61: 116;
           goto _L3 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        a(bytearrayoutputstream, s, stringbuilder);
        stringbuilder.append(c1);
        l = k;
_L6:
        k = l + 1;
        continue; /* Loop/switch isn't completed */
_L5:
        l = k;
        if (k < i1 - 2)
        {
            char c2 = charsequence.charAt(k + 1);
            l = k;
            if (c2 != '\r')
            {
                l = k;
                if (c2 != '\n')
                {
                    char c3 = charsequence.charAt(k + 2);
                    l = a(c2);
                    int j1 = a(c3);
                    if (l >= 0 && j1 >= 0)
                    {
                        bytearrayoutputstream.write((l << 4) + j1);
                    }
                    l = k + 2;
                }
            }
        }
        if (true) goto _L6; else goto _L2
_L2:
        a(bytearrayoutputstream, s, stringbuilder);
        return stringbuilder.toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected final i a()
    {
        return i.a;
    }

    public final boolean a(String s)
    {
        s = c(s);
        s = a.matcher(s);
        return s.find() && s.start() == 0;
    }

}
