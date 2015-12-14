// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.DocumentProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            DocumentPropertiesSerializer, SimpleSerializers, AuthorListSerializer, JsonSerializer

static class 
{

    public void serializeFields(DocumentProperties documentproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("title");
        SimpleSerializers.serializeString(documentproperties.getTitle(), jsongenerator);
        jsongenerator.writeFieldName("authors");
        AuthorListSerializer.INSTANCE.serialize(documentproperties.getAuthors(), jsongenerator);
        jsongenerator.writeFieldName("documentVersion");
        SimpleSerializers.serializeString(documentproperties.getDocumentVersion(), jsongenerator);
    }

    ()
    {
    }
}
