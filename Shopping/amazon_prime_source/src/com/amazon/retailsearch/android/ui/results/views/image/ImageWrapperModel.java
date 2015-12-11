// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.UriRequest;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.buttons.AddToCartState;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.InbandImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapper

public class ImageWrapperModel
{
    public static class Builder
    {

        private String asin;
        private AddToCartState cartState;
        private String contentDescription;
        private ImageRequest image;
        private List imageList;
        private InbandImage inbandImage;
        private boolean isImageAnimated;
        private Drawable preloadDrawable;
        private ResourceProvider resourceProvider;

        private List createImageList(Image image1, List list, ImageRequestFactory imagerequestfactory)
        {
            list = getImageUrls(image1, list, imagerequestfactory);
            image1 = new ArrayList(list.size());
            for (list = list.iterator(); list.hasNext(); image1.add(imagerequestfactory.fromUrl((String)list.next()))) { }
            return image1;
        }

        private HashSet getImageUrls(Image image1, List list, ImageRequestFactory imagerequestfactory)
        {
            imagerequestfactory = new LinkedHashSet(5);
            if (image1 != null && !TextUtils.isEmpty(image1.getUrl()))
            {
                imagerequestfactory.add(image1.getUrl());
            }
            if (list != null)
            {
                image1 = list.iterator();
                do
                {
                    if (!image1.hasNext())
                    {
                        break;
                    }
                    list = (Image)image1.next();
                    if (list != null && !TextUtils.isEmpty(list.getUrl()))
                    {
                        imagerequestfactory.add(list.getUrl());
                    }
                } while (true);
            }
            return imagerequestfactory;
        }

        public ImageWrapperModel build(String s, String s1, Image image1, List list, List list1, boolean flag, ImageRequestFactory imagerequestfactory, 
                ResourceProvider resourceprovider, boolean flag1, Drawable drawable)
        {
            if (s != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            asin = s;
            if (s1 == null)
            {
                s1 = "";
            }
            contentDescription = s1;
            if (image1 != null && !TextUtils.isEmpty(image1.getUrl()))
            {
                image = imagerequestfactory.fromUrl(image1.getUrl());
            }
            if (image == null) goto _L1; else goto _L3
_L3:
label0:
            {
                if (list == null || image.getUriRequest() == null || image.getUriRequest().getUri() == null || image.getUriRequest().getUri().isEmpty())
                {
                    break label0;
                }
                s = list.iterator();
                do
                {
                    if (!s.hasNext())
                    {
                        break label0;
                    }
                    s1 = (InbandImage)s.next();
                } while (s1 == null || !image.getUriRequest().getUri().equals(s1.getUrl()));
                inbandImage = s1;
            }
            if (!flag)
            {
                break; /* Loop/switch isn't completed */
            }
            imageList = createImageList(image1, list1, imagerequestfactory);
            if (imageList.isEmpty()) goto _L1; else goto _L4
_L4:
            resourceProvider = resourceprovider;
            isImageAnimated = flag1;
            preloadDrawable = drawable;
            return new ImageWrapperModel(this);
        }

        public Builder setCartState(ProductViewModel productviewmodel, ImageWrapper imagewrapper)
        {
            if (productviewmodel != null && "amazonfresh".equals(productviewmodel.getStore()) && imagewrapper != null && imagewrapper.hasCartQuantityOverlay())
            {
                cartState = productviewmodel.getVisibleOfferCartState();
                return this;
            } else
            {
                cartState = null;
                return this;
            }
        }










        public Builder()
        {
        }
    }


    private final String asin;
    private final AddToCartState cartState;
    private final String contentDescription;
    private final ImageRequest image;
    private final List imageList;
    private final InbandImage inbandImage;
    private final boolean isImageAnimated;
    private final Drawable preloadDrawable;
    private final ResourceProvider resourceProvider;

    private ImageWrapperModel(Builder builder)
    {
        asin = builder.asin;
        contentDescription = builder.contentDescription;
        image = builder.image;
        inbandImage = builder.inbandImage;
        imageList = builder.imageList;
        resourceProvider = builder.resourceProvider;
        isImageAnimated = builder.isImageAnimated;
        preloadDrawable = builder.preloadDrawable;
        cartState = builder.cartState;
    }


    public String getAsin()
    {
        return asin;
    }

    public AddToCartState getCartState()
    {
        return cartState;
    }

    public String getContentDescription()
    {
        return contentDescription;
    }

    public ImageRequest getImage()
    {
        return image;
    }

    public List getImageList()
    {
        return imageList;
    }

    public InbandImage getInbandImage()
    {
        return inbandImage;
    }

    public Drawable getPreloadDrawable()
    {
        return preloadDrawable;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }

    public boolean isImageAnimated()
    {
        return isImageAnimated;
    }
}
