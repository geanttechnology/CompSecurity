// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ImmutableNameValue, NameValue, MyEbayListItem

public class EbayItemIdAndVariationSpecifics
{

    protected String hash;
    public final long id;
    public final List variationSpecifics;

    public EbayItemIdAndVariationSpecifics(long l, List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        id = l;
        stringbuilder.append(l);
        if (list == null || list.isEmpty())
        {
            variationSpecifics = Collections.emptyList();
        } else
        {
            stringbuilder.append('{');
            ArrayList arraylist = new ArrayList(list.size());
            ImmutableNameValue immutablenamevalue;
            for (list = list.iterator(); list.hasNext(); immutablenamevalue.append(stringbuilder))
            {
                immutablenamevalue = new ImmutableNameValue((NameValue)list.next());
                arraylist.add(immutablenamevalue);
            }

            variationSpecifics = Collections.unmodifiableList(arraylist);
            stringbuilder.append('}');
        }
        hash = stringbuilder.toString();
    }

    public EbayItemIdAndVariationSpecifics(MyEbayListItem myebaylistitem)
    {
        this(myebaylistitem.id, ((List) (myebaylistitem.nameValueList)));
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj.getClass() != getClass() || !hash.equals(obj.toString()))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return hash.hashCode();
    }

    public String toString()
    {
        return hash;
    }
}
