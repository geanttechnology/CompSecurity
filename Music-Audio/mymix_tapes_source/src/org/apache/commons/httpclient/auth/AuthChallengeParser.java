// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterParser;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            MalformedChallengeException

public final class AuthChallengeParser
{

    public AuthChallengeParser()
    {
    }

    public static Map extractParams(String s)
        throws MalformedChallengeException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Challenge may not be null");
        }
        int i = s.indexOf(' ');
        if (i == -1)
        {
            throw new MalformedChallengeException("Invalid challenge: " + s);
        }
        HashMap hashmap = new HashMap();
        s = (new ParameterParser()).parse(s.substring(i + 1, s.length()), ',');
        for (int j = 0; j < s.size(); j++)
        {
            NameValuePair namevaluepair = (NameValuePair)s.get(j);
            hashmap.put(namevaluepair.getName().toLowerCase(), namevaluepair.getValue());
        }

        return hashmap;
    }

    public static String extractScheme(String s)
        throws MalformedChallengeException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Challenge may not be null");
        }
        int i = s.indexOf(' ');
        String s1;
        if (i == -1)
        {
            s1 = s;
        } else
        {
            s1 = s.substring(0, i);
        }
        if (s1.equals(""))
        {
            throw new MalformedChallengeException("Invalid challenge: " + s);
        } else
        {
            return s1.toLowerCase();
        }
    }

    public static Map parseChallenges(Header aheader[])
        throws MalformedChallengeException
    {
        if (aheader == null)
        {
            throw new IllegalArgumentException("Array of challenges may not be null");
        }
        HashMap hashmap = new HashMap(aheader.length);
        for (int i = 0; i < aheader.length; i++)
        {
            String s = aheader[i].getValue();
            hashmap.put(extractScheme(s), s);
        }

        return hashmap;
    }
}
