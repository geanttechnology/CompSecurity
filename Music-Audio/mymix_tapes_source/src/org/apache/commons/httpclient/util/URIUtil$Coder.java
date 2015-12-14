// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.util.BitSet;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;

// Referenced classes of package org.apache.commons.httpclient.util:
//            URIUtil

protected static class  extends URI
{

    public static String decode(char ac[], String s)
        throws URIException
    {
        return URI.decode(ac, s);
    }

    public static char[] encode(String s, BitSet bitset, String s1)
        throws URIException
    {
        return URI.encode(s, bitset, s1);
    }

    public static String replace(String s, char c, char c1)
    {
        StringBuffer stringbuffer = new StringBuffer(s.length());
        int i = 0;
        do
        {
            int j = s.indexOf(c);
            if (j >= 0)
            {
                stringbuffer.append(s.substring(0, j));
                stringbuffer.append(c1);
            } else
            {
                stringbuffer.append(s.substring(i));
            }
            i = j;
        } while (j >= 0);
        return stringbuffer.toString();
    }

    public static String replace(String s, char ac[], char ac1[])
    {
        for (int i = ac.length; i > 0; i--)
        {
            s = replace(s, ac[i], ac1[i]);
        }

        return s;
    }

    public static boolean verifyEscaped(char ac[])
    {
        int i = 0;
_L7:
        if (i >= ac.length) goto _L2; else goto _L1
_L1:
        char c = ac[i];
        if (c <= '\200') goto _L4; else goto _L3
_L3:
        return false;
_L4:
        int j;
        j = i;
        if (c != '%')
        {
            continue; /* Loop/switch isn't completed */
        }
        i++;
        if (Character.digit(ac[i], 16) == -1) goto _L3; else goto _L5
_L5:
        j = i + 1;
        if (Character.digit(ac[j], 16) == -1) goto _L3; else goto _L6
_L6:
        i = j + 1;
          goto _L7
_L2:
        return true;
    }

    protected ()
    {
    }
}
