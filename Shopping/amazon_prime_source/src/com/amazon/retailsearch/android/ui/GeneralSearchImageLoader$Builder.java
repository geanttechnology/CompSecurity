// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.searchapp.retailsearch.client.MsaUtil;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            GeneralSearchImageLoader, SearchImageLoader, ImageRequestFactory

public static class imageRes
{

    private int imageRes;
    private ResourceProvider resourceProvider;

    public SearchImageLoader build()
    {
        if (resourceProvider == null || imageRes <= 0)
        {
            return null;
        } else
        {
            ImageRequestFactory imagerequestfactory = new ImageRequestFactory() {

                final GeneralSearchImageLoader.Builder this$0;

                public ImageRequest fromUrl(String s)
                {
                    if (TextUtils.isEmpty(s))
                    {
                        return null;
                    } else
                    {
                        return new ImageRequest(new UriRequest(MsaUtil.setImageRes(s, imageRes)), 160);
                    }
                }

            
            {
                this$0 = GeneralSearchImageLoader.Builder.this;
                super();
            }
            };
            return new GeneralSearchImageLoader(resourceProvider, imagerequestfactory, null);
        }
    }


    public _cls1.this._cls0(ResourceProvider resourceprovider, int i)
    {
        resourceProvider = resourceprovider;
        imageRes = i;
    }
}
