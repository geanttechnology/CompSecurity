// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime;

import org.apache.http.entity.mime.content.ContentBody;
import org.apache.james.mime4j.descriptor.ContentDescriptor;
import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.Header;

// Referenced classes of package org.apache.http.entity.mime:
//            MinimalField

public class FormBodyPart extends BodyPart
{

    private final String name;

    public FormBodyPart(String s, ContentBody contentbody)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (contentbody == null)
        {
            throw new IllegalArgumentException("Body may not be null");
        } else
        {
            name = s;
            setHeader(new Header());
            setBody(contentbody);
            generateContentDisp(contentbody);
            generateContentType(contentbody);
            generateTransferEncoding(contentbody);
            return;
        }
    }

    private void addField(String s, String s1)
    {
        getHeader().addField(new MinimalField(s, s1));
    }

    protected void generateContentDisp(ContentBody contentbody)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"");
        stringbuilder.append(getName());
        stringbuilder.append("\"");
        if (contentbody.getFilename() != null)
        {
            stringbuilder.append("; filename=\"");
            stringbuilder.append(contentbody.getFilename());
            stringbuilder.append("\"");
        }
        addField("Content-Disposition", stringbuilder.toString());
    }

    protected void generateContentType(ContentDescriptor contentdescriptor)
    {
        if (contentdescriptor.getMimeType() != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(contentdescriptor.getMimeType());
            if (contentdescriptor.getCharset() != null)
            {
                stringbuilder.append("; charset=");
                stringbuilder.append(contentdescriptor.getCharset());
            }
            addField("Content-Type", stringbuilder.toString());
        }
    }

    protected void generateTransferEncoding(ContentDescriptor contentdescriptor)
    {
        if (contentdescriptor.getTransferEncoding() != null)
        {
            addField("Content-Transfer-Encoding", contentdescriptor.getTransferEncoding());
        }
    }

    public String getName()
    {
        return name;
    }
}
