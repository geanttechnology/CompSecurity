// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.Html;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class alue extends 
{

    public List aspectValues;
    public com.ebay.nautilus.domain.data.ring name;

    public int compareTo( )
    {
        return super.compareTo();
    }

    public String getValuesAsString()
    {
        Object obj = new DelimitedStringBuilder(", ");
        for (Iterator iterator = aspectValues.iterator(); iterator.hasNext(); ((DelimitedStringBuilder) (obj)).append(((alue)iterator.next()).value.ceContent())) { }
        String s = ((DelimitedStringBuilder) (obj)).toString();
        obj = s;
        if (!TextUtils.isEmpty(s))
        {
            obj = Html.fromHtml(s).toString();
        }
        return ((String) (obj));
    }

    public alue()
    {
    }
}
