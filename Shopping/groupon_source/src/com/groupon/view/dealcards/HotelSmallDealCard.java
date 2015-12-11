// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

// Referenced classes of package com.groupon.view.dealcards:
//            DefaultSmallDealCard

public class HotelSmallDealCard extends DefaultSmallDealCard
{

    private static final int HOTEL_TITLE_LINES = 1;

    public HotelSmallDealCard(Context context)
    {
        super(context);
    }

    public void alignViewsRtl()
    {
    }

    protected int getDefaultImageViewHeight()
    {
        return getResources().getDimensionPixelSize(0x7f0b016a);
    }

    protected int getDefaultImageViewWidth()
    {
        return getResources().getDimensionPixelSize(0x7f0b0034);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        titleView.setLines(1);
    }

    public void setGBucks(CharSequence charsequence)
    {
        SpannableString spannablestring = new SpannableString(getContext().getString(0x7f0801dc, new Object[] {
            charsequence
        }));
        spannablestring.setSpan(new TextAppearanceSpan(getContext(), 0x7f0a028b), 0, charsequence.length(), 0);
        spannablestring.setSpan(new TextAppearanceSpan(getContext(), 0x7f0a028a), charsequence.length(), spannablestring.length(), 0);
        gbucksTextView.setText(spannablestring, android.widget.TextView.BufferType.SPANNABLE);
    }
}
