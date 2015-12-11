// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.AbstractList;
import java.util.List;

// Referenced classes of package com.google.protobuf:
//            RepeatedFieldBuilder, MessageOrBuilder

private static class builder extends AbstractList
    implements List
{

    RepeatedFieldBuilder builder;

    public MessageOrBuilder get(int i)
    {
        return builder.getMessageOrBuilder(i);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    void incrementModCount()
    {
        modCount = modCount + 1;
    }

    public int size()
    {
        return builder.getCount();
    }

    (RepeatedFieldBuilder repeatedfieldbuilder)
    {
        builder = repeatedfieldbuilder;
    }
}
