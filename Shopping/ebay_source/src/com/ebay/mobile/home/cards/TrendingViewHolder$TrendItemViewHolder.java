// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home.cards:
//            TrendingViewHolder, TrendItemViewModel

public class trendImages extends ViewHolder
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
        topicStat.setText(TrendingViewHolder.access$000(TrendingViewHolder.this).getQuantityString(0x7f08003a, (int)((TrendItemViewModel) (viewmodel)).noOfViews, new Object[] {
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

    public (View view)
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
