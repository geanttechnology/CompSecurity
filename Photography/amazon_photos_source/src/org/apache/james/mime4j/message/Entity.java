// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.message;

import org.apache.james.mime4j.field.ContentTransferEncodingField;

// Referenced classes of package org.apache.james.mime4j.message:
//            Header, Body

public abstract class Entity
{

    private Body body;
    private Header header;
    private Entity parent;

    protected Entity()
    {
        header = null;
        body = null;
        parent = null;
    }

    public Body getBody()
    {
        return body;
    }

    public String getContentTransferEncoding()
    {
        return ContentTransferEncodingField.getEncoding((ContentTransferEncodingField)getHeader().getField("Content-Transfer-Encoding"));
    }

    public Header getHeader()
    {
        return header;
    }

    public void setBody(Body body1)
    {
        if (body != null)
        {
            throw new IllegalStateException("body already set");
        } else
        {
            body = body1;
            body1.setParent(this);
            return;
        }
    }

    public void setHeader(Header header1)
    {
        header = header1;
    }

    public void setParent(Entity entity)
    {
        parent = entity;
    }
}
