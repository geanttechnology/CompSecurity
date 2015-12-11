// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.xml;


public class XML
{

    public static final String CHARSET_UTF8 = "utf-8";
    public static final String CONTENT_TYPE = "text/xml; charset=\"utf-8\"";

    public XML()
    {
    }

    public static final String escapeXMLChars(String s)
    {
        return escapeXMLChars(s, true);
    }

    private static final String escapeXMLChars(String s, boolean flag)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        String s1;
        StringBuffer stringbuffer;
        char ac[];
        int i;
        int j;
        int l;
        stringbuffer = new StringBuffer();
        l = s.length();
        ac = new char[l];
        s.getChars(0, l, ac, 0);
        j = 0;
        s1 = null;
        i = 0;
_L11:
label0:
        {
            if (i < l)
            {
                break label0;
            }
            if (j != 0)
            {
                stringbuffer.append(ac, j, l - j);
                return stringbuffer.toString();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        ac[i];
        JVM INSTR lookupswitch 5: default 136
    //                   34: 219
    //                   38: 191
    //                   39: 209
    //                   60: 197
    //                   62: 203;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_219;
_L12:
        String s2 = s1;
        int k = j;
        if (s1 != null)
        {
            stringbuffer.append(ac, j, i - j);
            stringbuffer.append(s1);
            k = i + 1;
            s2 = null;
        }
        i++;
        s1 = s2;
        j = k;
          goto _L11
_L7:
        s1 = "&amp;";
          goto _L12
_L9:
        s1 = "&lt;";
          goto _L12
_L10:
        s1 = "&gt;";
          goto _L12
_L8:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        s1 = "&apos;";
          goto _L12
        if (flag)
        {
            s1 = "&quot;";
        }
          goto _L12
    }

    public static final String unescapeXMLChars(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&apos;", "'").replace("&quot;", "\"");
        }
    }
}
