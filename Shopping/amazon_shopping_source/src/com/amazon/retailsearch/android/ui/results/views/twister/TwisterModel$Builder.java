// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.retailsearch.android.ui.results.ProductUtil;
import com.amazon.searchapp.retailsearch.model.EditionsMetadata;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterModel

public static class m.Builder
{

    private static final String AIV_EDITION_TYPE = "digital_video";

    public TwisterModel build(String s, String s1, EditionsMetadata editionsmetadata, List list, String s2, Context context)
    {
        if (s1 != null && list != null && list.size() > 1 && !"digital_video".equals(s1)) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        context = new TwisterModel();
        context.setProductTitle(s);
        context.setEditionType(s1);
        TwisterModel.access$002(context, new _cls02[list.size()]);
        context.setEditionsMetadata(editionsmetadata);
        int i = 0;
        do
        {
            s = context;
            if (i >= list.size())
            {
                continue;
            }
            Object obj = (EditionsPriceInfo)list.get(i);
            if (obj != null && ((EditionsPriceInfo) (obj)).getLink() != null)
            {
                s = ((EditionsPriceInfo) (obj)).getLink().getText();
                String s4 = ((EditionsPriceInfo) (obj)).getLink().getUrl();
                if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s4))
                {
                    editionsmetadata = ((EditionsPriceInfo) (obj)).getPrice();
                    String s3 = ProductUtil.getPrimeProgramBadgeId(((EditionsPriceInfo) (obj)).getShipping());
                    obj = (new com.amazon.retailsearch.android.api.display.results.item.m.Builder()).build(((EditionsPriceInfo) (obj)).getAsin(), s4, s2, s1);
                    m am[] = TwisterModel.access$000(context);
                    context.getClass();
                    am[i] = new <init>(context, s, editionsmetadata, s3, ((com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem) (obj)));
                }
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public m.Builder()
    {
    }
}
