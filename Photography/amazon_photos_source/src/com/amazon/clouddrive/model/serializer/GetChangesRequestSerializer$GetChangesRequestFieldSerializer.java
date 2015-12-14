// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.GetChangesRequest;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            GetChangesRequestSerializer, SimpleSerializers

public static class i
{

    public void serializeFields(GetChangesRequest getchangesrequest, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("includePurged");
        SimpleSerializers.serializeString(getchangesrequest.getIncludePurged(), jsongenerator);
        jsongenerator.writeFieldName("chunkSize");
        SimpleSerializers.serializeInteger(getchangesrequest.getChunkSize(), jsongenerator);
        jsongenerator.writeFieldName("checkpoint");
        SimpleSerializers.serializeString(getchangesrequest.getCheckpoint(), jsongenerator);
        jsongenerator.writeFieldName("maxNodes");
        SimpleSerializers.serializeInteger(getchangesrequest.getMaxNodes(), jsongenerator);
        if (getchangesrequest.getLimit() != null)
        {
            getchangesrequest = getchangesrequest.getLimit().toString();
        } else
        {
            getchangesrequest = null;
        }
        jsongenerator.writeFieldName("limit");
        SimpleSerializers.serializeString(getchangesrequest, jsongenerator);
    }

    public i()
    {
    }
}
