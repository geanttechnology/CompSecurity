// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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

    private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";
    private static final Pattern NAMES_PATTERN = Pattern.compile("\\{([^/]+?)\\}");
    private static final long serialVersionUID = 1L;
    private final Pattern matchPattern;
    private final UriComponents uriComponents;
    private final String uriTemplate;
    private final List variableNames;

    public UriTemplate(String s)
    {
    /* block-local class not found */
    class Parser {}

        Parser parser = new Parser(s, null);
        uriTemplate = s;
        variableNames = Parser.access._mth100(parser);
        matchPattern = Parser.access._mth200(parser);
        uriComponents = UriComponentsBuilder.fromUriString(s).build();
    }

    protected URI encodeUri(String s)
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
            throw new IllegalArgumentException((new StringBuilder()).append("Could not create URI from [").append(s).append("]: ").append(urisyntaxexception).toString(), urisyntaxexception);
        }
        return uri;
    }

    public URI expand(Map map)
    {
        return uriComponents.expand(map).encode().toUri();
    }

    public transient URI expand(Object aobj[])
    {
        return uriComponents.expand(aobj).encode().toUri();
    }

    public List getVariableNames()
    {
        return variableNames;
    }

    public Map match(String s)
    {
        Assert.notNull(s, "'uri' must not be null");
        LinkedHashMap linkedhashmap = new LinkedHashMap(variableNames.size());
        s = matchPattern.matcher(s);
        if (s.find())
        {
            for (int i = 1; i <= s.groupCount(); i++)
            {
                linkedhashmap.put((String)variableNames.get(i - 1), s.group(i));
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
            return matchPattern.matcher(s).matches();
        }
    }

    public String toString()
    {
        return uriTemplate;
    }


}
