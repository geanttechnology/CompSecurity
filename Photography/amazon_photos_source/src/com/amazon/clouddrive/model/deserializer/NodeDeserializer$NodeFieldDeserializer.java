// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.INode;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            NodeDeserializer, SimpleDeserializers, AssetsDeserializer, JsonDeserializer

public static class eldDeserializer extends eldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
        throws IOException
    {
        if (super.handleField(jsonparser, s, ieditablenode))
        {
            return true;
        }
        if (ieditablenode instanceof INode)
        {
            if ("version".equals(s))
            {
                ((INode)ieditablenode).setVersion(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
                return true;
            }
            if ("eTagResponse".equals(s))
            {
                ((INode)ieditablenode).setETagResponse(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("assets".equals(s))
            {
                ((INode)ieditablenode).setAssets((List)AssetsDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("isShared".equals(s))
            {
                ((INode)ieditablenode).setIsShared(SimpleDeserializers.deserializeBoolean(jsonparser));
                return true;
            }
            if ("isRoot".equals(s))
            {
                ((INode)ieditablenode).setIsRoot(SimpleDeserializers.deserializeBoolean(jsonparser));
                return true;
            }
            if ("eTagRequest".equals(s))
            {
                ((INode)ieditablenode).setETagRequest(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("exclusivelyTrashed".equals(s))
            {
                ((INode)ieditablenode).setExclusivelyTrashed(SimpleDeserializers.deserializeBoolean(jsonparser));
                return true;
            }
            if ("createdDate".equals(s))
            {
                ((INode)ieditablenode).setCreatedDate(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("recursivelyTrashed".equals(s))
            {
                ((INode)ieditablenode).setRecursivelyTrashed(SimpleDeserializers.deserializeBoolean(jsonparser));
                return true;
            }
            if ("modifiedDate".equals(s))
            {
                ((INode)ieditablenode).setModifiedDate(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("createdBy".equals(s))
            {
                ((INode)ieditablenode).setCreatedBy(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("tempLink".equals(s))
            {
                ((INode)ieditablenode).setTempLink(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
        }
        return false;
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (IEditableNode)obj);
    }

    public eldDeserializer()
    {
    }
}
