// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.auth;

import com.comcast.cim.httpcomponentsandroid.HeaderElement;
import com.comcast.cim.httpcomponentsandroid.auth.MalformedChallengeException;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeaderValueParser;
import com.comcast.cim.httpcomponentsandroid.message.HeaderValueParser;
import com.comcast.cim.httpcomponentsandroid.message.ParserCursor;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.auth:
//            AuthSchemeBase

public abstract class RFC2617Scheme extends AuthSchemeBase
{

    private Map params;

    public RFC2617Scheme()
    {
    }

    public String getParameter(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter name may not be null");
        }
        if (params == null)
        {
            return null;
        } else
        {
            return (String)params.get(s.toLowerCase(Locale.ENGLISH));
        }
    }

    protected Map getParameters()
    {
        if (params == null)
        {
            params = new HashMap();
        }
        return params;
    }

    public String getRealm()
    {
        return getParameter("realm");
    }

    protected void parseChallenge(CharArrayBuffer chararraybuffer, int i, int j)
        throws MalformedChallengeException
    {
        chararraybuffer = BasicHeaderValueParser.DEFAULT.parseElements(chararraybuffer, new ParserCursor(i, chararraybuffer.length()));
        if (chararraybuffer.length == 0)
        {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        params = new HashMap(chararraybuffer.length);
        j = chararraybuffer.length;
        for (i = 0; i < j; i++)
        {
            HeaderElement headerelement = chararraybuffer[i];
            params.put(headerelement.getName(), headerelement.getValue());
        }

    }
}
