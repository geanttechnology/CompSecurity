// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            AbstractDeserializer, BulkResponseFieldDeserializer

public class BulkTrashRestoreNodesResponseDeserializer extends AbstractDeserializer
{

    public static final JsonDeserializer INSTANCE = new BulkTrashRestoreNodesResponseDeserializer();

    private BulkTrashRestoreNodesResponseDeserializer()
    {
        super(new BulkResponseFieldDeserializer());
    }

    protected BulkTrashRestoreNodesResponse createValue()
    {
        return new BulkTrashRestoreNodesResponse();
    }

    protected volatile Object createValue()
    {
        return createValue();
    }

}
