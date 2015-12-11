// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            FindPopularSearchesResponse

private class searches extends com.ebay.nautilus.kernel.util.
{

    private final ArrayList searches;
    final FindPopularSearchesResponse this$0;

    public void text(String s)
        throws SAXException
    {
        if (!TextUtils.isEmpty(s))
        {
            s = s.split(";");
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = s[i];
                searches.add(obj);
            }

        }
    }

    public (ArrayList arraylist)
    {
        this$0 = FindPopularSearchesResponse.this;
        super();
        searches = arraylist;
    }
}
