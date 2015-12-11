// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.util.Utils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ConsumableMessagingModel

public class ConsumableMessaging extends LinearLayout
    implements RetailSearchResultView
{

    private TextView badgeLine;
    private TextView badgeMessageLine;
    private ConsumableMessagingModel model;
    private ResultLayoutType resultLayoutType;

    public ConsumableMessaging(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private void buildBadgeLine()
    {
        if (TextUtils.isEmpty(model.getBadgeId()) && TextUtils.isEmpty(model.getBadgeText()))
        {
            badgeLine.setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, getContext());
        if (TextUtils.isEmpty(model.getBadgeId()))
        {
            styledspannablestring.append(model.getBadgeText(), com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Label_NoBadge);
        } else
        if (!TextUtils.isEmpty(model.getBadgeText()))
        {
            styledspannablestring.appendBadge(model.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Badge_WithText));
            styledspannablestring.append((new StringBuilder()).append(" ").append(model.getBadgeText()).toString(), com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Label);
        } else
        {
            styledspannablestring.appendBadge(model.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Badge));
        }
        setText(badgeLine, styledspannablestring);
    }

    private void buildBadgeMessageLine()
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, getContext());
        if (TextUtils.isEmpty(model.getBadgeMessage())) goto _L2; else goto _L1
_L1:
        styledspannablestring.append(model.getBadgeMessage(), com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Message);
_L4:
        setText(badgeMessageLine, styledspannablestring);
        return;
_L2:
        if (!Utils.isEmpty(model.getStyledBadgeMessage()))
        {
            styledspannablestring.append(model.getStyledBadgeMessage(), com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Message);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setText(TextView textview, SpannableStringBuilder spannablestringbuilder)
    {
        if (TextUtils.isEmpty(spannablestringbuilder))
        {
            textview.setVisibility(8);
            return;
        } else
        {
            textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            textview.setVisibility(0);
            return;
        }
    }

    public void buildView(ConsumableMessagingModel consumablemessagingmodel, ResultLayoutType resultlayouttype)
    {
        if (consumablemessagingmodel == null || resultlayouttype == null)
        {
            setVisibility(8);
            return;
        } else
        {
            model = consumablemessagingmodel;
            resultLayoutType = resultlayouttype;
            buildBadgeLine();
            buildBadgeMessageLine();
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((ConsumableMessagingModel)obj, resultlayouttype);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        badgeLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_consumable_message_badge);
        badgeMessageLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_consumable_message);
    }
}
