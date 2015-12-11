// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.common.model.cart.Incentive;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.util.ThemeUtil;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            ReminderItemsActivity

protected class conditions extends ArrayAdapter
{

    private final int colorTextDefault;
    private final String conditions;
    private final int id;
    private final LayoutInflater inflater;
    private final int redColor;
    private final StringBuffer redemptionCode;
    private final int spanStart;
    final ReminderItemsActivity this$0;

    public int getCount()
    {
        if (ReminderItemsActivity.access$1400(ReminderItemsActivity.this) == null)
        {
            return 0;
        } else
        {
            return ReminderItemsActivity.access$1400(ReminderItemsActivity.this).size();
        }
    }

    public Incentive getItem(int i)
    {
        return (Incentive)ReminderItemsActivity.access$1400(ReminderItemsActivity.this).get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final Incentive incentive = (Incentive)ReminderItemsActivity.access$1400(ReminderItemsActivity.this).get(i);
        View view1 = inflater.inflate(id, viewgroup, false);
        ((TextView)view1.findViewById(0x7f100160)).setText(incentive.displayMsg);
        view = (TextView)view1.findViewById(0x7f100161);
        viewgroup = new StringBuffer(redemptionCode);
        viewgroup.append(Incentive.obfuscateIncentiveCode(incentive.redemptionCode));
        i = viewgroup.length();
        viewgroup = new SpannableString(new StringBuilder(viewgroup));
        viewgroup.setSpan(new StyleSpan(1), spanStart, i, 33);
        view.setText(viewgroup);
        TextView textview = (TextView)view1.findViewById(0x7f100162);
        textview.setTextColor(colorTextDefault);
        view = "";
        Date date = incentive.expiration;
        if (date != null)
        {
            viewgroup = DateFormat.getDateInstance(3).format(date);
            view = viewgroup;
            if (date.getTime() - System.currentTimeMillis() <= 0x240c8400L)
            {
                textview.setTextColor(redColor);
                view = viewgroup;
            }
        }
        if (view.length() > 0)
        {
            textview.setText(getString(0x7f0703ec, new Object[] {
                view
            }));
        } else
        {
            textview.setText("");
        }
        view = (TextView)view1.findViewById(0x7f100163);
        if (incentive.campaign != null && !TextUtils.isEmpty(incentive.campaign.olor))
        {
            view.setTextColor(colorTextDefault);
            view.setText(Html.fromHtml((new StringBuilder()).append("<a href='#'>").append(conditions).append("</a>").toString()));
            view.setVisibility(0);
            Linkify.addLinks(view, 1);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ReminderItemsActivity.CouponAdapter this$1;
                final Incentive val$incentive;

                public void onClick(View view2)
                {
                    ShowWebViewActivity.start(this$0, incentive.campaign.FAQUrl, conditions, "IncentiveFaqInfo");
                }

            
            {
                this$1 = ReminderItemsActivity.CouponAdapter.this;
                incentive = incentive1;
                super();
            }
            });
        } else
        {
            view.setVisibility(8);
        }
        view1.setTag(incentive);
        return view1;
    }


    public _cls1.val.incentive(Context context, int i)
    {
        this$0 = ReminderItemsActivity.this;
        super(context, i);
        id = i;
        redColor = getResources().getColor(0x7f0d0064);
        colorTextDefault = ThemeUtil.resolveThemeForegroundColor(getResources(), getTheme(), 0x1010036);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        redemptionCode = (new StringBuffer(getString(0x7f0708df))).append(" ");
        spanStart = redemptionCode.length();
        conditions = getString(0x7f070997);
    }
}
