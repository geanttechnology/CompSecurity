// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            NameValue

public final class ImmutableNameValue
{

    public final String name;
    public final List values;

    public ImmutableNameValue(NameValue namevalue)
    {
        this(namevalue.getName(), namevalue.getValues());
    }

    public ImmutableNameValue(String s, List list)
    {
        name = s;
        if (list == null || list.isEmpty())
        {
            values = Collections.emptyList();
            return;
        } else
        {
            values = Collections.unmodifiableList(new ArrayList(list));
            return;
        }
    }

    final StringBuilder append(StringBuilder stringbuilder)
    {
        if (name != null)
        {
            stringbuilder.append('"').append(name).append('"');
        }
        stringbuilder.append('{');
        String s;
        for (Iterator iterator = values.iterator(); iterator.hasNext(); stringbuilder.append('"').append(s).append('"'))
        {
            s = (String)iterator.next();
        }

        stringbuilder.append('}');
        return stringbuilder;
    }

    public NameValue getMutable()
    {
        return new NameValue(name, values);
    }

    public String toString()
    {
        return append(new StringBuilder()).toString();
    }
}
