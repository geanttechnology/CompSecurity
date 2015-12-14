// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;

import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpMessage;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest:
//            RestClient

private class httpMessage
    implements httpMessage
{

    protected final AbstractHttpMessage httpMessage;
    final RestClient this$0;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (httpMessage)obj;
        if (httpMessage != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((httpMessage) (obj)).httpMessage == null) goto _L1; else goto _L3
_L3:
        return false;
        if (httpMessage.equals(((equals) (obj)).httpMessage)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public Object get()
        throws TerminalException, TransientException
    {
        Object obj;
        try
        {
            obj = executeOperation(httpMessage);
            obj = httpMessage.buildResponse(((org.json.JSONObject) (obj)));
        }
        catch (RuntimeException runtimeexception)
        {
            throw new TerminalException(runtimeexception);
        }
        return obj;
    }

    public int hashCode()
    {
        int i;
        if (httpMessage == null)
        {
            i = 0;
        } else
        {
            i = httpMessage.hashCode();
        }
        return i + 31;
    }

    public String toString()
    {
        return httpMessage.toString();
    }

    public (AbstractHttpMessage abstracthttpmessage)
    {
        this$0 = RestClient.this;
        super();
        httpMessage = abstracthttpmessage;
    }
}
