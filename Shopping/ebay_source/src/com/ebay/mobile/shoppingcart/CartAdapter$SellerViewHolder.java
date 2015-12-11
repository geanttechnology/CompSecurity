// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            CartAdapter

private static final class sellerNameLabel
    implements sellerNameLabel
{

    private final String sellerNameLabel;
    public TextView statusBanner;
    public TextView title;

    public void update(Object obj, boolean flag)
    {
label0:
        {
            obj = (com.ebay.nautilus.domain.data.ellerNameLabel)obj;
            if (obj != null)
            {
                SpannableString spannablestring = new SpannableString(((com.ebay.nautilus.domain.data.ellerNameLabel) (obj)).ellerNameLabel);
                spannablestring.setSpan(new StyleSpan(1), 0, spannablestring.length(), 0);
                title.setText(TextUtils.concat(new CharSequence[] {
                    sellerNameLabel, spannablestring
                }));
                if (!((com.ebay.nautilus.domain.data.ellerNameLabel) (obj)).ion)
                {
                    break label0;
                }
                if (((com.ebay.nautilus.domain.data.ion) (obj)).ndsOn.before(Calendar.getInstance().getTime()))
                {
                    statusBanner.setText(0x7f070aa6);
                } else
                {
                    obj = DateFormat.getMediumDateFormat(statusBanner.getContext()).format(((com.ebay.nautilus.domain.data.tatusBanner) (obj)).ndsOn);
                    statusBanner.setText(statusBanner.getContext().getString(0x7f070aa5, new Object[] {
                        obj
                    }));
                }
                statusBanner.setVisibility(0);
            }
            return;
        }
        statusBanner.setVisibility(8);
    }

    public (View view)
    {
        title = (TextView)view.findViewById(0x7f10005f);
        statusBanner = (TextView)view.findViewById(0x7f1007c4);
        sellerNameLabel = view.getContext().getString(0x7f070aa8);
    }
}
