// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.DocumentProperties;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, DocumentPropertiesDeserializer, SimpleDeserializers, AuthorListDeserializer, 
//            JsonDeserializer

static class q
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, DocumentProperties documentproperties)
        throws IOException
    {
        if ("title".equals(s))
        {
            documentproperties.setTitle(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("authors".equals(s))
        {
            documentproperties.setAuthors((List)AuthorListDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("documentVersion".equals(s))
        {
            documentproperties.setDocumentVersion(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (DocumentProperties)obj);
    }

    q()
    {
    }
}
