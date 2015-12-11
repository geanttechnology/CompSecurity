// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            ListOfTrendingViewModel, TrendItemViewModel

public class TrendingViewHolder extends ViewHolder
{
    public class TrendItemViewHolder extends ViewHolder
    {

        private final int imageIds[] = {
            0x7f1002c9, 0x7f1002ca, 0x7f1002cb
        };
        final TrendingViewHolder this$0;
        private final TextView topicIdx;
        private final TextView topicName;
        private final TextView topicStat;
        public List trendImages;

        public void bind(ViewModel viewmodel)
        {
            super.bind(viewmodel);
            viewmodel = (TrendItemViewModel)viewmodel;
            topicIdx.setText(((TrendItemViewModel) (viewmodel)).label);
            topicName.setText(((TrendItemViewModel) (viewmodel)).topicName);
            topicStat.setText(resources.getQuantityString(0x7f08003a, (int)((TrendItemViewModel) (viewmodel)).noOfViews, new Object[] {
                Long.valueOf(((TrendItemViewModel) (viewmodel)).noOfViews)
            }));
            int j = Math.min(trendImages.size(), ((TrendItemViewModel) (viewmodel)).imageUrl.size());
            int i = 0;
            while (i < trendImages.size()) 
            {
                if (i < j)
                {
                    ((RemoteImageView)trendImages.get(i)).setRemoteImageUrl((String)((TrendItemViewModel) (viewmodel)).imageUrl.get(i));
                    ((RemoteImageView)trendImages.get(i)).setVisibility(0);
                } else
                {
                    ((RemoteImageView)trendImages.get(i)).setVisibility(4);
                }
                i++;
            }
        }

        public TrendItemViewHolder(View view)
        {
            this$0 = TrendingViewHolder.this;
            super(view);
            trendImages = new ArrayList();
            topicIdx = (TextView)view.findViewById(0x7f1002cc);
            topicName = (TextView)view.findViewById(0x7f1002cd);
            topicStat = (TextView)view.findViewById(0x7f1002ce);
            trendingviewholder = imageIds;
            int j = TrendingViewHolder.this.length;
            for (int i = 0; i < j; i++)
            {
                RemoteImageView remoteimageview = (RemoteImageView)view.findViewById(TrendingViewHolder.this[i]);
                if (remoteimageview != null)
                {
                    trendImages.add(remoteimageview);
                }
            }

        }
    }


    protected static boolean isTablet;
    private static final int separatorIds[] = {
        0x7f1002c0, 0x7f1002c2, 0x7f1002c4, 0x7f1002c6
    };
    private static final int viewIds[] = {
        0x7f1002bf, 0x7f1002c1, 0x7f1002c3, 0x7f1002c5, 0x7f1002c7
    };
    private final Resources resources;
    public final List separatorViews = new ArrayList();
    private final Button showMoreButton;
    public final List trendViews = new ArrayList();

    public TrendingViewHolder(View view)
    {
        super(view);
        resources = itemView.getResources();
        isTablet = resources.getBoolean(0x7f0b0006);
        int ai[] = viewIds;
        int k = ai.length;
        for (int i = 0; i < k; i++)
        {
            View view1 = view.findViewById(ai[i]);
            if (view1 != null)
            {
                trendViews.add(new TrendItemViewHolder(view1));
            }
        }

        ai = separatorIds;
        k = ai.length;
        for (int j = 0; j < k; j++)
        {
            View view2 = view.findViewById(ai[j]);
            if (view2 != null)
            {
                separatorViews.add(view2);
            }
        }

        showMoreButton = (Button)view.findViewById(0x7f1002c8);
        showMoreButton.setOnClickListener(this);
    }

    public void bind(ViewModel viewmodel)
    {
        super.bind(viewmodel);
        viewmodel = (ListOfTrendingViewModel)viewmodel;
        for (Iterator iterator = trendViews.iterator(); iterator.hasNext(); ((TrendItemViewHolder)iterator.next()).itemView.setVisibility(8)) { }
        for (Iterator iterator1 = separatorViews.iterator(); iterator1.hasNext(); ((View)iterator1.next()).setVisibility(8)) { }
        int j = Math.min(((ListOfTrendingViewModel) (viewmodel)).trends.size(), trendViews.size());
        for (int i = 0; i < j; i++)
        {
            TrendItemViewHolder trenditemviewholder = (TrendItemViewHolder)trendViews.get(i);
            trenditemviewholder.bind((ViewModel)((ListOfTrendingViewModel) (viewmodel)).trends.get(i));
            trenditemviewholder.itemView.setVisibility(0);
            int k = i - 1;
            if (k >= 0 && k < separatorViews.size())
            {
                ((View)separatorViews.get(k)).setVisibility(0);
            }
            trenditemviewholder.itemView.setOnClickListener(this);
        }

    }

    public void onClick(View view)
    {
        ListOfTrendingViewModel listoftrendingviewmodel = (ListOfTrendingViewModel)model;
        view.getId();
        JVM INSTR tableswitch 2131755711 2131755719: default 64
    //                   2131755711 75
    //                   2131755712 64
    //                   2131755713 83
    //                   2131755714 64
    //                   2131755715 91
    //                   2131755716 64
    //                   2131755717 99
    //                   2131755718 64
    //                   2131755719 107;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L5 _L1 _L6
_L1:
        listoftrendingviewmodel.trendAnchor = -1;
_L8:
        super.onClick(view);
        return;
_L2:
        listoftrendingviewmodel.trendAnchor = 0;
        continue; /* Loop/switch isn't completed */
_L3:
        listoftrendingviewmodel.trendAnchor = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        listoftrendingviewmodel.trendAnchor = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        listoftrendingviewmodel.trendAnchor = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        listoftrendingviewmodel.trendAnchor = 4;
        if (true) goto _L8; else goto _L7
_L7:
    }


}
