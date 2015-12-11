// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.TypeLiteral;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;

// Referenced classes of package com.google.inject.internal:
//            InjectorImpl

private static class <init>
{

    final Map multimap;

    List getAll(TypeLiteral typeliteral)
    {
        if ((List)multimap.get(typeliteral) != null)
        {
            return Collections.unmodifiableList((List)multimap.get(typeliteral));
        } else
        {
            return ImmutableList.of();
        }
    }

    void put(TypeLiteral typeliteral, Binding binding)
    {
        List list = (List)multimap.get(typeliteral);
        Object obj = list;
        if (list == null)
        {
            obj = Lists.newArrayList();
            multimap.put(typeliteral, obj);
        }
        ((List) (obj)).add(binding);
    }

    private ()
    {
        multimap = Maps.newHashMap();
    }

    ( )
    {
        this();
    }
}
