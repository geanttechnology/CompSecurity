// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;


// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            ListSerializer, QueryAndBlockSerializer, JsonSerializer

public class QueryAndBlockListSerializer extends ListSerializer
{

    public static final JsonSerializer INSTANCE = new QueryAndBlockListSerializer();

    private QueryAndBlockListSerializer()
    {
        super(QueryAndBlockSerializer.INSTANCE);
    }

}
