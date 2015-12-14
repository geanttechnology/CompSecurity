// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime.content;

import org.apache.james.mime4j.message.Entity;
import org.apache.james.mime4j.message.SingleBody;

// Referenced classes of package org.apache.http.entity.mime.content:
//            ContentBody

public abstract class AbstractContentBody extends SingleBody
    implements ContentBody
{

    private final String mediaType;
    private final String mimeType;
    private Entity parent;
    private final String subType;

    public AbstractContentBody(String s)
    {
        parent = null;
        if (s == null)
        {
            throw new IllegalArgumentException("MIME type may not be null");
        }
        mimeType = s;
        int i = s.indexOf('/');
        if (i != -1)
        {
            mediaType = s.substring(0, i);
            subType = s.substring(i + 1);
            return;
        } else
        {
            mediaType = s;
            subType = null;
            return;
        }
    }

    public String getMimeType()
    {
        return mimeType;
    }

    public void setParent(Entity entity)
    {
        parent = entity;
    }
}
