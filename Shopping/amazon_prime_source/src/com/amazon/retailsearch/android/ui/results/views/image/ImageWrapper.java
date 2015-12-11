// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.BitmapUtil;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.LoaderContext;
import com.amazon.ansel.fetch.ResourceListener;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.ansel.fetch.cache.ResourceCache;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.android.ui.results.views.cart.CartQuantityMessage;
import com.amazon.retailsearch.data.search.SearchLoaderLogger;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.InbandImage;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapperModel, ThumbSwitcher

public abstract class ImageWrapper extends LinearLayout
    implements RetailSearchResultView
{
    private static class ViewHolder
    {

        public ImageRequest displayedImage;
        public ImageView imageView;
        public CartQuantityMessage overlayMessage;
        public ThumbSwitcher thumbSwitcher;

        private ViewHolder()
        {
        }

    }


    private ImageRequest activeImageRequest;
    private ImageRequest displayedImage;
    FeatureConfiguration featureConfig;
    private ResourceListener imageListener;
    protected ImageView imageView;
    LoaderContext loaderContext;
    protected CartQuantityMessage overlayMessage;
    private ResourceProvider resourceProvider;
    private RetailSearchLogger retailSearchLogger;
    SearchDataSource searchDataSource;
    protected ThumbSwitcher thumbSwitcher;

    public ImageWrapper(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
    }

    private void increaseLoadedImage()
    {
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().increaseLoadedImage();
        }
    }

    private boolean loadAndShowInbandImage(ImageRequest imagerequest, InbandImage inbandimage)
    {
        if (inbandimage == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (inbandimage.getUrl() == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (inbandimage.getUrl().isEmpty())
        {
            return false;
        }
        Bitmap bitmap = getImageBitmapForUrl(inbandimage.getUrl());
        Object obj;
        obj = bitmap;
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = inbandimage.getBase64EncodedImage();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (((String) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_195;
        }
        obj = Base64.decode(((String) (obj)), 0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        bitmap = BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        int i;
        i = BitmapUtil.getBitmapByteCount(bitmap);
        if (imagerequest.getBitmapDensity() != 0)
        {
            bitmap.setDensity(imagerequest.getBitmapDensity());
        }
        obj = bitmap;
        if (loaderContext == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = bitmap;
        if (loaderContext.getPrimaryCache() == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        loaderContext.getPrimaryCache().put(inbandimage.getUrl(), new ResourceCacheValue(bitmap, i, -1L));
        obj = bitmap;
        showImage(activeImageRequest, ((Bitmap) (obj)));
        return true;
        imagerequest;
        retailSearchLogger.error("Error decoding InbandImage ", imagerequest);
        return false;
    }

    public void buildView(ImageWrapperModel imagewrappermodel, ResultLayoutType resultlayouttype)
    {
        if (imageView == null || imagewrappermodel == null)
        {
            hideImage();
            return;
        }
        resourceProvider = imagewrappermodel.getResourceProvider();
        if (imagewrappermodel.getPreloadDrawable() != null)
        {
            imageView.setImageDrawable(imagewrappermodel.getPreloadDrawable());
        }
        if (!hasThumbSwitcher())
        {
            loadAndShowImage(imagewrappermodel.getImage(), imagewrappermodel.getInbandImage());
        } else
        {
            thumbSwitcher.buildView(imagewrappermodel.getAsin(), this, imagewrappermodel.getImageList(), resourceProvider);
        }
        if (hasCartQuantityOverlay())
        {
            overlayMessage.buildView(imagewrappermodel.getCartState(), resultlayouttype);
        }
        if (imagewrappermodel.isImageAnimated())
        {
            imageView.setVisibility(4);
            return;
        } else
        {
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((ImageWrapperModel)obj, resultlayouttype);
    }

    public Bitmap getImageBitmapForUrl(String s)
    {
        if (loaderContext != null && loaderContext.getPrimaryCache() != null)
        {
            s = (ResourceCacheValue)loaderContext.getPrimaryCache().get(s);
            if (s != null && (s.getValue() instanceof Bitmap))
            {
                return (Bitmap)s.getValue();
            }
        }
        return null;
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    public ThumbSwitcher getThumbSwitcher()
    {
        return thumbSwitcher;
    }

    public boolean hasCartQuantityOverlay()
    {
        return overlayMessage != null;
    }

    public boolean hasThumbSwitcher()
    {
        return thumbSwitcher != null;
    }

    public void hideImage()
    {
        imageView.setImageDrawable(null);
        displayedImage = null;
        updateTag();
    }

    protected void loadAndShowImage(final ImageRequest imageRequest, InbandImage inbandimage)
    {
        if (displayedImage != null && displayedImage.equals(imageRequest))
        {
            return;
        }
        if (imageRequest == null || displayedImage != null)
        {
            hideImage();
        }
        activeImageRequest = imageRequest;
        if ("T1".equals(FeatureStateUtil.getInbandImageWeblab(featureConfig)) && loadAndShowInbandImage(imageRequest, inbandimage))
        {
            increaseLoadedImage();
            return;
        } else
        {
            imageListener = new AbstractResourceListener() {

                final ImageWrapper this$0;
                final ImageRequest val$imageRequest;

                public void result(Bitmap bitmap)
                {
                    if (imageListener != this || !Utils.isEqual(imageRequest, activeImageRequest))
                    {
                        return;
                    }
                    increaseLoadedImage();
                    if (bitmap == null)
                    {
                        hideImage();
                        return;
                    } else
                    {
                        showImage(activeImageRequest, bitmap);
                        return;
                    }
                }

                public volatile void result(Object obj)
                {
                    result((Bitmap)obj);
                }

            
            {
                this$0 = ImageWrapper.this;
                imageRequest = imagerequest;
                super();
            }
            };
            imageRequest = new ImageLoader(resourceProvider.getContext(), imageListener, System.currentTimeMillis(), imageRequest);
            resourceProvider.execute(imageRequest);
            return;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ViewHolder viewholder = (ViewHolder)getTag();
        if (viewholder == null)
        {
            postInflate();
            updateTag();
            return;
        } else
        {
            displayedImage = viewholder.displayedImage;
            imageView = viewholder.imageView;
            thumbSwitcher = viewholder.thumbSwitcher;
            overlayMessage = viewholder.overlayMessage;
            return;
        }
    }

    protected abstract void postInflate();

    public void showImage(ImageRequest imagerequest, Bitmap bitmap)
    {
        if (bitmap == null)
        {
            hideImage();
            return;
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap.getConfig() == null)
        {
            bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
        }
        imageView.setImageBitmap(bitmap1);
        displayedImage = imagerequest;
        updateTag();
    }

    void updateTag()
    {
        ViewHolder viewholder = new ViewHolder();
        viewholder.displayedImage = displayedImage;
        viewholder.imageView = imageView;
        viewholder.thumbSwitcher = thumbSwitcher;
        viewholder.overlayMessage = overlayMessage;
        setTag(viewholder);
    }



}
