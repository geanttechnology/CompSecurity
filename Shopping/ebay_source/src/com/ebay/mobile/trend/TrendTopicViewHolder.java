// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.trend:
//            TopicListingViewHolder, TopicViewModel, TopicListingViewModel

public class TrendTopicViewHolder extends ViewHolder
{

    private static final int trendIds[] = {
        0x7f100119, 0x7f10011a, 0x7f10011b, 0x7f10011c, 0x7f100836
    };
    private String DELTA_TYPE_DOWN;
    private String DELTA_TYPE_NEW;
    private String DELTA_TYPE_UP;
    private final TextAppearanceSpan countAppearanceSpan;
    private final TextAppearanceSpan countTitleAppearanceSpan;
    private final ForegroundColorSpan countTitleColoreSpan;
    private final View divider;
    private final Resources resources;
    private final TextView topicClicks;
    private final TextView topicDeltaNew;
    private final TextView topicDescription;
    private final TextView topicPosition;
    private final TextView topicSearches;
    private final TextView topicSeeMore;
    private final TextView topicTitle;
    public final List trendViews = new ArrayList();

    public TrendTopicViewHolder(View view)
    {
        super(view);
        DELTA_TYPE_UP = "UP";
        DELTA_TYPE_DOWN = "DOWN";
        DELTA_TYPE_NEW = "NEW";
        int ai[] = trendIds;
        int k = ai.length;
        for (int i = 0; i < k; i++)
        {
            View view2 = view.findViewById(ai[i]);
            if (view2 != null)
            {
                trendViews.add(new TopicListingViewHolder(view2));
            }
        }

        resources = view.getResources();
        view.getContext();
        divider = view.findViewById(0x7f100834);
        int j;
        if (divider != null)
        {
            View view1 = divider;
            boolean flag;
            if (resources.getBoolean(0x7f0b0006))
            {
                j = 8;
            } else
            {
                j = 0;
            }
            view1.setVisibility(j);
        }
        topicDeltaNew = (TextView)view.findViewById(0x7f10082e);
        topicPosition = (TextView)view.findViewById(0x7f1002cc);
        topicTitle = (TextView)view.findViewById(0x7f1002cd);
        topicSearches = (TextView)view.findViewById(0x7f10082c);
        topicClicks = (TextView)view.findViewById(0x7f10082d);
        topicDescription = (TextView)view.findViewById(0x7f10082b);
        topicSeeMore = (TextView)view.findViewById(0x7f10011d);
        if (topicSeeMore != null)
        {
            topicSeeMore.setOnClickListener(this);
        }
        flag = resources.getBoolean(0x7f0b0006);
        view = view.getContext();
        if (flag)
        {
            j = 0x7f0a0155;
        } else
        {
            j = 0x7f0a0154;
        }
        countAppearanceSpan = new TextAppearanceSpan(view, j);
        if (flag)
        {
            j = 0x7f0a013f;
        } else
        {
            j = 0x7f0a0140;
        }
        countTitleAppearanceSpan = new TextAppearanceSpan(view, j);
        countTitleColoreSpan = new ForegroundColorSpan(resources.getColor(0x7f0d00e7));
    }

    private Spannable getSpanString(int i, String s)
    {
        s = new SpannableString((new StringBuilder()).append(s.substring(0, i)).append("\n").append(s.substring(i + 1)).toString());
        int j = s.length();
        s.setSpan(countAppearanceSpan, 0, i, 33);
        s.setSpan(countTitleAppearanceSpan, i + 1, j, 33);
        s.setSpan(countTitleColoreSpan, i + 1, j, 33);
        return s;
    }

    public static boolean isValidModel(ViewModel viewmodel, boolean flag)
    {
        if (!(viewmodel instanceof TopicViewModel))
        {
            return false;
        } else
        {
            return isNotEmpty(new CharSequence[] {
                ((TopicViewModel)viewmodel).topicTitle
            });
        }
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        if (viewmodel instanceof TopicViewModel)
        {
            viewmodel = (TopicViewModel)viewmodel;
            Object obj;
            String s;
            int i;
            int j;
            if (((TopicViewModel) (viewmodel)).trendDeltaType.equals(DELTA_TYPE_UP))
            {
                topicDeltaNew.setVisibility(8);
                topicPosition.setCompoundDrawablesWithIntrinsicBounds(0, 0x7f0201a5, 0, 0);
            } else
            if (((TopicViewModel) (viewmodel)).trendDeltaType.equals(DELTA_TYPE_DOWN))
            {
                topicDeltaNew.setVisibility(8);
                topicPosition.setCompoundDrawablesWithIntrinsicBounds(0, 0x7f0202b6, 0, 0);
            } else
            if (((TopicViewModel) (viewmodel)).trendDeltaType.equals(DELTA_TYPE_NEW))
            {
                topicPosition.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                topicDeltaNew.setVisibility(0);
            } else
            {
                topicPosition.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                topicDeltaNew.setVisibility(8);
            }
            topicPosition.setText(((TopicViewModel) (viewmodel)).topicPosition);
            topicTitle.setText(((TopicViewModel) (viewmodel)).topicTitle);
            obj = NumberFormat.getIntegerInstance().format(((TopicViewModel) (viewmodel)).noOfSearches);
            s = resources.getQuantityString(0x7f08003a, (int)((TopicViewModel) (viewmodel)).noOfSearches, new Object[] {
                Long.valueOf(((TopicViewModel) (viewmodel)).noOfSearches)
            });
            topicSearches.setText(getSpanString(((String) (obj)).length(), s));
            obj = NumberFormat.getIntegerInstance().format(((TopicViewModel) (viewmodel)).noOfClicks);
            s = resources.getQuantityString(0x7f080039, (int)((TopicViewModel) (viewmodel)).noOfClicks, new Object[] {
                Long.valueOf(((TopicViewModel) (viewmodel)).noOfClicks)
            });
            topicClicks.setText(getSpanString(((String) (obj)).length(), s));
            topicDescription.setText(((TopicViewModel) (viewmodel)).topicDescription);
            obj = topicSeeMore;
            if (((TopicViewModel) (viewmodel)).collectionId == null && ((TopicViewModel) (viewmodel)).searchParameters == null)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            ((TextView) (obj)).setVisibility(i);
            j = Math.min(trendViews.size(), ((TopicViewModel) (viewmodel)).listings.size());
            i = 0;
            while (i < trendViews.size()) 
            {
                TopicListingViewHolder topiclistingviewholder = (TopicListingViewHolder)trendViews.get(i);
                if (i < j)
                {
                    topiclistingviewholder.bind((TopicListingViewModel)((TopicViewModel) (viewmodel)).listings.get(i));
                    topiclistingviewholder.itemView.setVisibility(0);
                } else
                {
                    topiclistingviewholder.itemView.setVisibility(4);
                }
                i++;
            }
        }
    }

}
