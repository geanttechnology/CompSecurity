// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.groupon.models.GenericAmount;
import com.groupon.util.CurrencyFormatter;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class GrouponBucks extends GrouponActivity
{

    private CurrencyFormatter currencyFormatter;
    GenericAmount gBucksAmount;
    String gBucksDisclaimerValue;
    TextView gBucksValue;
    View gbucksDetailsContainer;
    TextView gbucksDisclaimer;
    TextView gbucksDisclaimerShort;

    public GrouponBucks()
    {
    }

    private void setupViews()
    {
        int i = 0;
        gBucksValue.setText(currencyFormatter.format(gBucksAmount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Never));
        Object obj = new SpannableString(getResources().getString(0x7f0804dd));
        ((SpannableString) (obj)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e00c2)), 21, 34, 0);
        gbucksDisclaimerShort.setText(((CharSequence) (obj)), android.widget.TextView.BufferType.SPANNABLE);
        if (Strings.notEmpty(gBucksDisclaimerValue))
        {
            gbucksDisclaimer.setText(gBucksDisclaimerValue);
        }
        obj = gbucksDetailsContainer;
        if (!Strings.notEmpty(gBucksDisclaimerValue))
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setDisplayToolbarTitle(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030125);
        setupViews();
    }
}
