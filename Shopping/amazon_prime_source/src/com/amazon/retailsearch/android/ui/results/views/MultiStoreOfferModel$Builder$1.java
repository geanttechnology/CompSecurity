// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.res.Resources;
import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.searchapp.retailsearch.client.MsaUtil;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreOfferModel

class val.resources
    implements ImageRequestFactory
{

    final val.resources this$0;
    final Resources val$resources;

    public ImageRequest fromUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, val$resources.getDimensionPixelSize(com.amazon.retailsearch.ight))), 160);
        }
    }

    ()
    {
        this$0 = final_;
        val$resources = Resources.this;
        super();
    }
}
