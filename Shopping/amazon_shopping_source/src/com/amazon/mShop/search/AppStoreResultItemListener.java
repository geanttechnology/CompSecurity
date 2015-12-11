// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.net.Uri;
import android.text.TextUtils;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search:
//            ResultItemListener, SearchActivity

class AppStoreResultItemListener extends ResultItemListener
{

    public AppStoreResultItemListener(SearchActivity searchactivity)
    {
        super(searchactivity);
    }

    private String parseRefParameter(Uri uri)
    {
        Object obj;
        List list;
        int i;
        list = uri.getPathSegments();
        obj = null;
        i = list.size() - 1;
_L8:
        uri = obj;
        if (i < 0) goto _L2; else goto _L1
_L1:
        uri = (String)list.get(i);
        if (!uri.startsWith("ref=")) goto _L3; else goto _L2
_L2:
        if (!TextUtils.isEmpty(uri)) goto _L5; else goto _L4
_L4:
        return null;
_L3:
        i--;
        continue; /* Loop/switch isn't completed */
_L5:
        if ((uri = uri.split("=")).length < 2) goto _L4; else goto _L6
_L6:
        return uri[1];
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected boolean openView(RetailSearchResultItem retailsearchresultitem)
    {
        Object obj = Uri.parse(retailsearchresultitem.getDetailPageUrlPath());
        String s = ((Uri) (obj)).getQueryParameter("qid");
        String s1 = ((Uri) (obj)).getQueryParameter("sr");
        obj = parseRefParameter(((Uri) (obj)));
        if ("mobile_application".equals(retailsearchresultitem.getProductGroup()))
        {
            ActivityUtils.startAppstoreActivityWithAsin(getSearchActivity(), retailsearchresultitem.getAsin(), ((String) (obj)), s, s1);
            return true;
        } else
        {
            return false;
        }
    }
}
