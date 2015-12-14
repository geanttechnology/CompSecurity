// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.http:
//            AbstractHttpMessage, HttpFactory

public abstract class AbstractHttpGetMessage extends AbstractHttpMessage
{

    private final Map params = new HashMap();

    public AbstractHttpGetMessage(HttpFactory httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent)
        throws InvalidParameterException
    {
        super(httpfactory.getHttpGetRequest(), metricsevent, httpfactory.getSourceInfo());
    }

    private void appendParam(StringBuilder stringbuilder, String s, String s1)
        throws UnsupportedEncodingException
    {
        stringbuilder.append(URLEncoder.encode(s, "UTF-8")).append('=').append(URLEncoder.encode(s1, "UTF-8")).append('&');
    }

    private String getQueryParams()
        throws TerminalException
    {
        Object obj;
        Iterator iterator;
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("?");
        iterator = params.entrySet().iterator();
_L4:
        java.util.Map.Entry entry;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_167;
        }
        entry = (java.util.Map.Entry)iterator.next();
        String as[];
        int i;
        int j;
        if (entry.getValue() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (entry.getValue() instanceof String)
        {
            appendParam(((StringBuilder) (obj)), (String)entry.getKey(), (String)entry.getValue());
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            as = (String[])(String[])entry.getValue();
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new TerminalException(((Throwable) (obj)));
        }
        i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[i];
        appendParam(((StringBuilder) (obj)), (String)entry.getKey(), s);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).deleteCharAt(((StringBuilder) (obj)).length() - 1);
        if (((StringBuilder) (obj)).length() <= 0)
        {
            return null;
        } else
        {
            return ((StringBuilder) (obj)).toString();
        }
    }

    protected abstract URI getURI(String s);

    public void populateRequest(Endpoint endpoint)
        throws TerminalException
    {
        super.populateRequest(endpoint);
        String s = getQueryParams();
        URI uri = getURI(endpoint.getHttpPath());
        endpoint = uri;
        if (s != null)
        {
            endpoint = URI.create((new StringBuilder()).append(uri.toString()).append(s).toString());
        }
        request.setURI(endpoint);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(getClass().getName());
        stringbuilder.append(" [");
        Iterator iterator = params.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null)
            {
                stringbuilder.append((String)entry.getKey()).append(" = ");
                if (entry.getValue() instanceof String)
                {
                    stringbuilder.append(entry.getValue());
                } else
                {
                    stringbuilder.append(Arrays.toString((String[])(String[])entry.getValue()));
                }
                stringbuilder.append(",");
            }
        } while (true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }
}
