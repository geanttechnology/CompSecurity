// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.data.BadgeType;
import com.amazon.searchapp.retailsearch.model.Promotion;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            PromotionsModel

public class Promotions extends TextView
    implements RetailSearchResultView
{

    public static final String TYPE_AUTO_RIP = "AUTO_RIP";
    private static final String TYPE_GENERAL = "GENERAL";
    Context context;

    public Promotions(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(PromotionsModel promotionsmodel, ResultLayoutType resultlayouttype)
    {
        if (promotionsmodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, context);
        promotionsmodel = promotionsmodel.getPromotions().iterator();
        do
        {
label0:
            {
                Promotion promotion;
                if (promotionsmodel.hasNext())
                {
                    promotion = (Promotion)promotionsmodel.next();
                    if (!"GENERAL".equals(promotion.getType()))
                    {
                        break label0;
                    }
                    if (TextUtils.isEmpty(promotion.getText()))
                    {
                        continue;
                    }
                    resultlayouttype.append(promotion.getText(), com.amazon.retailsearch.R.style.Results_Promotions_List);
                }
                if (TextUtils.isEmpty(resultlayouttype))
                {
                    setVisibility(8);
                    return;
                } else
                {
                    setText(resultlayouttype);
                    setVisibility(0);
                    return;
                }
            }
            if ("AUTO_RIP".equals(promotion.getType()))
            {
                resultlayouttype.appendBadge(BadgeType.AUTO_RIP.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_Promotions_List));
            }
        } while (true);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((PromotionsModel)obj, resultlayouttype);
    }
}
