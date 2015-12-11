// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
//            RequestWrapper

public class EntityEnclosingRequestWrapper extends RequestWrapper
    implements HttpEntityEnclosingRequest
{
    class EntityWrapper extends HttpEntityWrapper
    {

        final EntityEnclosingRequestWrapper this$0;

        public InputStream getContent()
            throws IOException
        {
            consumed = true;
            return super.getContent();
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            consumed = true;
            super.writeTo(outputstream);
        }

        EntityWrapper(HttpEntity httpentity)
        {
            this$0 = EntityEnclosingRequestWrapper.this;
            super(httpentity);
        }
    }


    private boolean consumed;
    private HttpEntity entity;

    public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest httpentityenclosingrequest)
        throws ProtocolException
    {
        super(httpentityenclosingrequest);
        setEntity(httpentityenclosingrequest.getEntity());
    }

    public boolean expectContinue()
    {
        Header header = getFirstHeader("Expect");
        return header != null && "100-continue".equalsIgnoreCase(header.getValue());
    }

    public HttpEntity getEntity()
    {
        return entity;
    }

    public boolean isRepeatable()
    {
        return entity == null || entity.isRepeatable() || !consumed;
    }

    public void setEntity(HttpEntity httpentity)
    {
        if (httpentity != null)
        {
            httpentity = new EntityWrapper(httpentity);
        } else
        {
            httpentity = null;
        }
        entity = httpentity;
        consumed = false;
    }


/*
    static boolean access$002(EntityEnclosingRequestWrapper entityenclosingrequestwrapper, boolean flag)
    {
        entityenclosingrequestwrapper.consumed = flag;
        return flag;
    }

*/
}
