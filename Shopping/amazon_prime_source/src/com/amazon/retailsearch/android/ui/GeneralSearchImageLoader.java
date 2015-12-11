// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceListener;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.searchapp.retailsearch.client.MsaUtil;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            SearchImageLoader, ImageRequestFactory, SearchImageLoaderListener

public class GeneralSearchImageLoader
    implements SearchImageLoader
{
    public static class Builder
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

                    final Builder this$0;

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
                this$0 = Builder.this;
                super();
            }
                };
                return new GeneralSearchImageLoader(resourceProvider, imagerequestfactory);
            }
        }


        public Builder(ResourceProvider resourceprovider, int i)
        {
            resourceProvider = resourceprovider;
            imageRes = i;
        }
    }


    private ImageRequestFactory imageRequestFactory;
    private ResourceListener resourceListener;
    private ResourceProvider resourceProvider;

    private GeneralSearchImageLoader(ResourceProvider resourceprovider, ImageRequestFactory imagerequestfactory)
    {
        resourceProvider = resourceprovider;
        imageRequestFactory = imagerequestfactory;
    }


    public void load(String s, final SearchImageLoaderListener searchImageLoaderListener)
    {
        if (TextUtils.isEmpty(s) || searchImageLoaderListener == null)
        {
            return;
        } else
        {
            s = imageRequestFactory.fromUrl(s);
            resourceListener = new AbstractResourceListener() {

                final GeneralSearchImageLoader this$0;
                final SearchImageLoaderListener val$searchImageLoaderListener;

                public void result(Bitmap bitmap)
                {
                    if (bitmap == null)
                    {
                        return;
                    }
                    Bitmap bitmap1 = bitmap;
                    if (bitmap.getConfig() == null)
                    {
                        bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
                    }
                    searchImageLoaderListener.onLoad(bitmap1);
                }

                public volatile void result(Object obj)
                {
                    result((Bitmap)obj);
                }

            
            {
                this$0 = GeneralSearchImageLoader.this;
                searchImageLoaderListener = searchimageloaderlistener;
                super();
            }
            };
            s = new ImageLoader(resourceProvider.getContext(), resourceListener, System.currentTimeMillis(), s);
            resourceProvider.execute(s);
            return;
        }
    }
}
