// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

private static final class <init> extends <init>
{

    private final category child;

    public final com.ebay.nautilus.kernel.util. add(ArrayList arraylist)
    {
        com.ebay.common.model.search.t t = new com.ebay.common.model.search.t();
        category = t;
        arraylist.add(t);
        return this;
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "childCategoryHistogram".equals(s1))
        {
            return child.dd(((com.ebay.common.model.search..add)category).category);
        } else
        {
            return super.category(s, s1, s2, attributes);
        }
    }

    private ()
    {
        super(null);
        child = new init>(null);
    }

    init>(init> init>)
    {
        this();
    }
}
