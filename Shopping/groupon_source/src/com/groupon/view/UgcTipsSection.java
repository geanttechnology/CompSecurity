// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.Tip;
import com.groupon.models.nst.TravelReviewsClickExtraInfo;
import com.groupon.models.nst.TravelReviewsDetailImpressionExtraInfo;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.HumanReadableDateTimeDifferenceFormat;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            ExpandablePanel

public class UgcTipsSection extends ExpandablePanel
{
    private class OnTipClickListener
        implements android.view.View.OnClickListener
    {

        final UgcTipsSection this$0;
        private final TextView tipText;

        public void onClick(View view)
        {
            int i = 0x7fffffff;
            if (isExpanding())
            {
                return;
            }
            view = tipText;
            if (tipText.getMaxLines() == 0x7fffffff)
            {
                i = 4;
            }
            view.setMaxLines(i);
            tipText.getViewTreeObserver().addOnGlobalLayoutListener(new OnTipLayoutListener(tipText, tipText.getHeight()));
        }

        public OnTipClickListener(TextView textview)
        {
            this$0 = UgcTipsSection.this;
            super();
            tipText = textview;
        }
    }

    private class OnTipLayoutListener
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private final int startingHeight;
        final UgcTipsSection this$0;
        private final View tipText;

        public void onGlobalLayout()
        {
            contentView.getLayoutParams().height = contentView.getHeight() + (tipText.getHeight() - startingHeight);
            contentView.setLayoutParams(contentView.getLayoutParams());
            tipText.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        public OnTipLayoutListener(View view, int i)
        {
            this$0 = UgcTipsSection.this;
            super();
            tipText = view;
            startingHeight = i;
        }
    }


    private String dealType;
    View expandButton;
    View header;
    private HumanReadableDateTimeDifferenceFormat humanReadableDateTimeDifferenceFormat;
    protected Logger logger;
    private List merchantTips;
    private String percentMessage;
    TextView recommendText;
    LinearLayout tipsList;
    private String totalMessage;
    private String uuid;

    public UgcTipsSection(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void init(Context context, AttributeSet attributeset)
    {
        ButterKnife.bind(this, LayoutInflater.from(context).inflate(0x7f03021e, this, true));
        RoboGuice.getInjector(context).injectMembers(this);
        setCollapsedHeight(0);
        setAnimationDuration(500);
        handleView = header;
        contentView = tipsList;
    }

    public void updatePanelState(boolean flag, boolean flag1)
    {
        super.updatePanelState(flag, flag1);
        ViewPropertyAnimator viewpropertyanimator = expandButton.animate();
        float f;
        long l;
        if (flag)
        {
            f = 180F;
        } else
        {
            f = 0.0F;
        }
        viewpropertyanimator = viewpropertyanimator.rotation(f);
        if (flag1)
        {
            l = animationDuration;
        } else
        {
            l = 0L;
        }
        viewpropertyanimator.setDuration(l).start();
        if (flag1)
        {
            Logger logger1 = logger;
            String s1 = uuid;
            EncodedNSTField encodednstfield = new EncodedNSTField() {

                final UgcTipsSection this$0;

                public String toEncodedString()
                {
                    return dealType;
                }

            
            {
                this$0 = UgcTipsSection.this;
                super();
            }
            };
            String s;
            if (flag)
            {
                s = "expand";
            } else
            {
                s = "collapse";
            }
            logger1.logClick("", "travel_reviews_header_click", s1, encodednstfield, new TravelReviewsClickExtraInfo("UGC", s));
            if (flag)
            {
                logger.logImpression("", "travel_reviews_details", uuid, dealType, new TravelReviewsDetailImpressionExtraInfo(percentMessage, totalMessage, merchantTips.size()));
            }
        }
    }

    public void updateViews(String s, String s1, List list, String s2, String s3)
    {
        merchantTips = list;
        uuid = s;
        dealType = s1;
        percentMessage = s2;
        totalMessage = s3;
        tipsList.removeAllViews();
        int k = list.size();
        boolean flag;
        if (Strings.notEmpty(s2) && Strings.notEmpty(s3))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (k > 0)
        {
            for (int i = 0; i < k; i++)
            {
                s = (Tip)list.get(i);
                s1 = LayoutInflater.from(getContext()).inflate(0x7f03021d, tipsList, false);
                TextView textview = (TextView)s1.findViewById(0x7f100573);
                TextView textview1 = (TextView)s1.findViewById(0x7f100574);
                TextView textview2 = (TextView)s1.findViewById(0x7f100575);
                textview.setText(((Tip) (s)).maskedName);
                if (((Tip) (s)).updatedAt != null)
                {
                    textview1.setText(humanReadableDateTimeDifferenceFormat.getReadableTimer(((Tip) (s)).updatedAt));
                }
                textview2.setText(((Tip) (s)).text);
                if (i == k - 1)
                {
                    s1.setBackground(null);
                }
                s1.setOnClickListener(new OnTipClickListener(textview2));
                tipsList.addView(s1);
            }

            expandButton.setRotation(0.0F);
        } else
        {
            expandButton.setVisibility(8);
            header.setClickable(false);
            tipsList.setVisibility(8);
        }
        if (flag)
        {
            int j = s2.length() + 1;
            s = (Spannable)Html.fromHtml(getResources().getString(0x7f080308, new Object[] {
                s2, s3
            }));
            s.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e0004)), 0, j, 0);
            s.setSpan(new AbsoluteSizeSpan(16, true), 0, j, 0);
            recommendText.setText(s);
            recommendText.setVisibility(0);
        }
        if (k > 0 || flag)
        {
            setVisibility(0);
            updatePanelState(shouldExpandAfterLayout, false);
        }
    }

}
