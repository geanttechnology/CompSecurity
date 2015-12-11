// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.BrowseDepartmentActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;

// Referenced classes of package com.ebay.mobile.collections:
//            TrendingCollectionsAdapter, CollectionViewModel, CollectionDetailsActivity

public class BrowseCollectionsActivity extends BrowseDepartmentActivity
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener
{

    public BrowseCollectionsActivity()
    {
    }

    public RecyclerContentAdapter getChannelContentAdapter(Boolean boolean1)
    {
        return new TrendingCollectionsAdapter(this, boolean1);
    }

    public ContentSourceEnum getContentSourceEnum(String s)
    {
        if (s.equals("FEATURED"))
        {
            return ContentSourceEnum.EBAY_TODAY;
        } else
        {
            return ContentSourceEnum.TRENDING_COLLECTION;
        }
    }

    public String getSubDepartmentTitle(String s, String s1)
    {
        if (s.equals("FEATURED"))
        {
            return getString(0x7f070244);
        } else
        {
            return getString(0x7f070242, new Object[] {
                s1
            });
        }
    }

    public String getTrackingEventName()
    {
        return "CollectionsBrowse";
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        viewmodel = (CollectionViewModel)viewmodel;
        if (view.getId() == 0x7f1000f7)
        {
            UserDetailActivity.StartActivity(this, null, ((CollectionViewModel) (viewmodel)).username, null, null, false, true, false, false, null, false, null);
            return;
        } else
        {
            view = TrackingData.sanitize(departmentId);
            CollectionDetailsActivity.startActivity(this, ((CollectionViewModel) (viewmodel)).collectionId, view, new SourceIdentification("CollectionsBrowse", "collections", view));
            return;
        }
    }

    public void sendTracking(String s, Contents contents)
    {
        contents = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        contents.addKeyValuePair("chnl", s, true);
        if (TextUtils.equals(s, departmentId))
        {
            s = "0";
        } else
        {
            s = "1";
        }
        contents.addKeyValuePair("filter", s);
        contents.addSourceIdentification(getIntent());
        contents.send(this);
    }
}
