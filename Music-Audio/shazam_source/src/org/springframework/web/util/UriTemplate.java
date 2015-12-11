// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.web.util:
//            UriComponentsBuilder, UriUtils, UriComponents

public class UriTemplate
    implements Serializable
{

    private static final Pattern a = Pattern.compile("\\{([^/]+?)\\}");
    private final UriComponents b;
    private final List c;
    private final Pattern d;
    private final String e;

    public UriTemplate(String s)
    {
    /* block-local class not found */
    class a {}

        a a1 = new a(s, (byte)0);
        e = s;
        c = Collections.unmodifiableList(a1.a);
        d = Pattern.compile(a1.b.toString());
        b = UriComponentsBuilder.fromUriString(s).build();
    }

    static Pattern a()
    {
        return a;
    }

    public URI encodeUri(String s)
    {
        URI uri;
        try
        {
            uri = new URI(UriUtils.encodeUri(s, "UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalStateException(s);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalArgumentException((new StringBuilder("Could not create URI from [")).append(s).append("]: ").append(urisyntaxexception).toString(), urisyntaxexception);
        }
        return uri;
    }

    public URI expand(Map map)
    {
        return b.expand(map).encode().toUri();
    }

    public transient URI expand(Object aobj[])
    {
        return b.expand(aobj).encode().toUri();
    }

    public List getVariableNames()
    {
        return c;
    }

    public Map match(String s)
    {
        Assert.notNull(s, "'uri' must not be null");
        LinkedHashMap linkedhashmap = new LinkedHashMap(c.size());
        s = d.matcher(s);
        if (s.find())
        {
            for (int i = 1; i <= s.groupCount(); i++)
            {
                linkedhashmap.put((String)c.get(i - 1), s.group(i));
            }

        }
        return linkedhashmap;
    }

    public boolean matches(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return d.matcher(s).matches();
        }
    }

    public String toString()
    {
        return e;
    }

}
