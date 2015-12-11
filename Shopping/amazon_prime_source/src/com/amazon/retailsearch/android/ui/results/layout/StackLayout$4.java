// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.searchapp.retailsearch.client.MsaUtil;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

class this._cls0
    implements ImageRequestFactory
{

    final StackLayout this$0;

    public ImageRequest fromUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, StackLayout.access$800(StackLayout.this))), 160);
        }
    }

    ()
    {
        this$0 = StackLayout.this;
        super();
    }
}
