// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.graphics.Point;
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
            return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, Math.max(StackLayout.access$900(StackLayout.this).x, StackLayout.access$900(StackLayout.this).y))), 160);
        }
    }

    ()
    {
        this$0 = StackLayout.this;
        super();
    }
}
