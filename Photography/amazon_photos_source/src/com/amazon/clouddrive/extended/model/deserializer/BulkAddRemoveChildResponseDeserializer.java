// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.BulkAddRemoveChildResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            AbstractDeserializer, BulkResponseFieldDeserializer

public class BulkAddRemoveChildResponseDeserializer extends AbstractDeserializer
{

    public static final JsonDeserializer INSTANCE = new BulkAddRemoveChildResponseDeserializer();

    private BulkAddRemoveChildResponseDeserializer()
    {
        super(new BulkResponseFieldDeserializer());
    }

    protected BulkAddRemoveChildResponse createValue()
    {
        return new BulkAddRemoveChildResponse();
    }

    protected volatile Object createValue()
    {
        return createValue();
    }

}
