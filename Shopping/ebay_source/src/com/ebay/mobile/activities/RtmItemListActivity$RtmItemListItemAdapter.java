// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.text.TextUtils;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.view.DefaultItemAdapter;
import com.ebay.common.view.ViewCache;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.net.image.ConstructDipUrl;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmItemListActivity

private class this._cls0 extends DefaultItemAdapter
{

    final RtmItemListActivity this$0;

    public void setItem(ViewCache viewcache, EbayItem ebayitem, int i)
    {
        super.setItem(viewcache, ebayitem, i);
        String s1 = ebayitem.galleryUrl;
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = s1;
            if (ebayitem.pictureUrls != null)
            {
                s = s1;
                if (ebayitem.pictureUrls.size() > 0)
                {
                    s = (String)ebayitem.pictureUrls.get(0);
                }
            }
        }
        s1 = s;
        if (TextUtils.isEmpty(s))
        {
            s1 = s;
            if (!TextUtils.isEmpty(ebayitem.masterImageUrl))
            {
                s1 = ConstructDipUrl.constructDynamicUrl(ebayitem.masterImageUrl, "_26");
            }
        }
        viewcache.image.setRemoteImageUrl(s1);
    }

    public volatile void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, int i)
    {
        setItem(viewcache, (EbayItem)ebaysearchlistitem, i);
    }

    public volatile void setItem(ViewCache viewcache, Object obj, int i)
    {
        setItem(viewcache, (EbayItem)obj, i);
    }

    public (Activity activity, boolean flag, boolean flag1, boolean flag2)
    {
        this$0 = RtmItemListActivity.this;
        super(activity, flag, flag1, flag2);
    }
}
