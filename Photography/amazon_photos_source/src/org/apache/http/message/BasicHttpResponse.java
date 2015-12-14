// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;

// Referenced classes of package org.apache.http.message:
//            AbstractHttpMessage, BasicStatusLine

public class BasicHttpResponse extends AbstractHttpMessage
    implements HttpResponse
{

    private HttpEntity entity;
    private Locale locale;
    private ReasonPhraseCatalog reasonCatalog;
    private StatusLine statusline;

    public BasicHttpResponse(ProtocolVersion protocolversion, int i, String s)
    {
        this(((StatusLine) (new BasicStatusLine(protocolversion, i, s))), ((ReasonPhraseCatalog) (null)), ((Locale) (null)));
    }

    public BasicHttpResponse(StatusLine statusline1, ReasonPhraseCatalog reasonphrasecatalog, Locale locale1)
    {
        if (statusline1 == null)
        {
            throw new IllegalArgumentException("Status line may not be null.");
        }
        statusline = statusline1;
        reasonCatalog = reasonphrasecatalog;
        if (locale1 == null)
        {
            locale1 = Locale.getDefault();
        }
        locale = locale1;
    }

    public HttpEntity getEntity()
    {
        return entity;
    }

    public StatusLine getStatusLine()
    {
        return statusline;
    }

    public void setEntity(HttpEntity httpentity)
    {
        entity = httpentity;
    }

    public void setStatusLine(StatusLine statusline1)
    {
        if (statusline1 == null)
        {
            throw new IllegalArgumentException("Status line may not be null");
        } else
        {
            statusline = statusline1;
            return;
        }
    }
}
