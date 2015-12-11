// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.views.BestSeller;
import com.amazon.retailsearch.android.ui.results.views.RatingsLine;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapper;
import com.amazon.retailsearch.android.ui.results.views.image.ThumbSwitcher;
import com.amazon.retailsearch.android.ui.results.views.messaging.EditionLine;
import com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLine;
import com.amazon.retailsearch.android.ui.results.views.price.OffersLine;
import com.amazon.retailsearch.android.ui.results.views.price.Price;
import com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSave;
import com.amazon.retailsearch.android.ui.results.views.twister.Twister;
import com.amazon.retailsearch.data.EditionsPriceInfoUtil;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.Availability;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.PriceInfo;
import com.amazon.searchapp.retailsearch.model.Prices;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Ratings;
import com.amazon.searchapp.retailsearch.model.Shipping;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ProductViewModel, SwipeDetector, ViewType

public abstract class ProductView extends FrameLayout
    implements ModelView
{
    private class SwipeListener
        implements SwipeDetector.Listener
    {

        final ProductView this$0;

        public boolean onDown(MotionEvent motionevent)
        {
            if (!swipeDetector.isSwiping())
            {
                swiped = false;
            }
            return true;
        }

        public boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3)
        {
            if (!swiped)
            {
                swiped = true;
            }
            return true;
        }

        public boolean onSwipe(float f, float f1, MotionEvent motionevent, float f2, float f3)
        {
            return true;
        }

        private SwipeListener()
        {
            this$0 = ProductView.this;
            super();
        }

    }


    private static final String EDITIONS_TYPE_DIGITAL_VIDEO = "digital_video";
    protected static final String LINE_SEPARATOR = System.getProperty("line.separator");
    protected static final int MAX_EDITIONS = 3;
    protected Availability availabilityInfo;
    private BestSeller bestSeller;
    private EditionLine editionLine;
    private FreeRentalLine freeRentalLine;
    protected GestureDetector gestureDetector;
    protected ProductGestureListener gestureListener;
    private ImageWrapper imageWrapper;
    protected boolean isSponsoredPrice;
    protected PriceInfo mainPrice;
    private OffersLine offersLine;
    private Price price;
    protected Product product;
    protected ImageRequestFactory productImageFactory;
    protected Ratings ratings;
    private RatingsLine ratingsLine;
    protected ResourceProvider resourceProvider;
    protected Shipping shippingInfo;
    private SubscribeAndSave subscribeAndSave;
    protected PriceInfo subscribeAndSavePrice;
    protected SwipeDetector swipeDetector;
    protected boolean swiped;
    protected ThumbSwitcher thumbSwitcher;
    private TextView title;
    protected Twister twister;
    protected boolean useEditionsPricing;
    UserInteractionListener userInteractionListener;
    protected ViewType viewType;

    public ProductView(Context context)
    {
        super(context);
        init(context);
    }

    public ProductView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    private Availability getAvailabilityInfo()
    {
        if (product != null)
        {
            if (product.getAvailability() != null)
            {
                return product.getAvailability();
            }
            if (mainPrice != null)
            {
                return mainPrice.getAvailability();
            }
        }
        return null;
    }

    private PriceInfo getMainPrice()
    {
        Prices prices;
        if (product != null)
        {
            if ((prices = product.getPrices()) != null)
            {
                if (prices.getBuy() != null)
                {
                    return prices.getBuy();
                }
                if (prices.getEditions() != null && !prices.getEditions().isEmpty())
                {
                    return EditionsPriceInfoUtil.toPriceInfo((EditionsPriceInfo)prices.getEditions().get(0));
                }
                if (prices.getDigital() != null)
                {
                    return prices.getDigital();
                }
                if (prices.getRental() != null)
                {
                    return prices.getRental();
                }
                if (prices.getSponsored() != null)
                {
                    return prices.getSponsored();
                }
            }
        }
        return null;
    }

    private boolean isDigitalVideoEditionsType(Prices prices)
    {
        return prices != null && "digital_video".equals(prices.getEditionsType());
    }

    public void build(ProductViewModel productviewmodel)
    {
        boolean flag1 = true;
        if (productviewmodel == null || productviewmodel.getProduct() == null)
        {
            setVisibility(8);
        } else
        {
            product = productviewmodel.getProduct();
            productImageFactory = productviewmodel.getProductImageFactory();
            resourceProvider = productviewmodel.getResourceProvider();
            Prices prices = null;
            productviewmodel = prices;
            if (product.getLink() != null)
            {
                productviewmodel = prices;
                if (!TextUtils.isEmpty(product.getLink().getUrl()))
                {
                    productviewmodel = product.getLink().getUrl();
                }
            }
            productviewmodel = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(product.getAsin(), productviewmodel, product.getGroup());
            gestureListener.setResultItem(productviewmodel);
            swiped = false;
            shippingInfo = product.getShipping();
            mainPrice = getMainPrice();
            prices = product.getPrices();
            boolean flag;
            if (prices != null && (prices.getDigital() != null || isDigitalVideoEditionsType(prices)) && prices.getEditions() != null && !prices.getEditions().isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            useEditionsPricing = flag;
            availabilityInfo = getAvailabilityInfo();
            if (prices != null)
            {
                productviewmodel = prices.getSponsored();
            } else
            {
                productviewmodel = null;
            }
            if (mainPrice != null && mainPrice == productviewmodel)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            isSponsoredPrice = flag;
            ratings = product.getRatings();
            if (ratings == null && mainPrice != null)
            {
                ratings = mainPrice.getRatings();
            }
            subscribeAndSavePrice = null;
            if (prices != null && prices.getSubscribeAndSave() != null)
            {
                subscribeAndSavePrice = prices.getSubscribeAndSave();
            }
            buildView();
            if (userInteractionListener != null && imageWrapper != null)
            {
                userInteractionListener.resultItemBuilt(this, imageWrapper.getImageView(), product.getAsin());
                return;
            }
        }
    }

    public volatile void build(Object obj)
    {
        build((ProductViewModel)obj);
    }

    protected void buildView()
    {
        Object obj = (new com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel.Builder()).build(product.getAsin(), product.getTitle(), product.getImage(), product.getAltImages(), imageWrapper.hasThumbSwitcher(), productImageFactory, resourceProvider);
        imageWrapper.buildView(((com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel) (obj)), viewType);
        Object obj3;
        if (product.getTitle() == null)
        {
            title.setText("");
        } else
        {
            title.setText(product.getTitle());
        }
        if (editionLine != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.EditionLineModel.Builder()).build(mainPrice, useEditionsPricing, product.getTypeName(), isSponsoredPrice);
            editionLine.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.EditionLineModel) (obj)), viewType);
        }
        obj3 = product.getPrices();
        obj = (new com.amazon.retailsearch.android.ui.results.views.price.PriceModel.Builder()).build(((Prices) (obj3)), mainPrice, shippingInfo, useEditionsPricing, isSponsoredPrice, price.getShowListPrice(), price.getShowSomePrime());
        price.buildView(((com.amazon.retailsearch.android.ui.results.views.price.PriceModel) (obj)), viewType);
        if (offersLine != null)
        {
            Object obj1 = new com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel.Builder();
            boolean flag;
            if (price.getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj1 = ((com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel.Builder) (obj1)).build(((Prices) (obj3)), flag, offersLine.getIsPriceBackup());
            offersLine.buildView(((com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel) (obj1)), viewType);
        }
        if (twister != null)
        {
            Object obj2;
            com.amazon.searchapp.retailsearch.model.EditionsMetadata editionsmetadata;
            if (obj3 == null)
            {
                obj2 = null;
            } else
            {
                obj2 = ((Prices) (obj3)).getEditionsType();
            }
            if (obj3 == null)
            {
                editionsmetadata = null;
            } else
            {
                editionsmetadata = ((Prices) (obj3)).getEditionsMetadata();
            }
            if (obj3 == null)
            {
                obj3 = null;
            } else
            {
                obj3 = ((Prices) (obj3)).getEditions();
            }
            obj2 = (new com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel.Builder()).build(product.getTitle(), ((String) (obj2)), editionsmetadata, ((List) (obj3)), product.getGroup(), getContext());
            twister.buildView(((com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel) (obj2)), viewType);
        }
        if (subscribeAndSave != null)
        {
            obj2 = (new com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSaveModel.Builder()).build(subscribeAndSavePrice, subscribeAndSave.getShowSaveMoreText(), viewType, getResources());
            subscribeAndSave.buildView(((com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSaveModel) (obj2)), viewType);
        }
        if (freeRentalLine != null)
        {
            obj2 = (new com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLineModel.Builder()).build(product.getPrices(), shippingInfo);
            freeRentalLine.buildView(((com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLineModel) (obj2)), viewType);
        }
        if (bestSeller != null)
        {
            obj2 = (new com.amazon.retailsearch.android.ui.results.views.BestSellerModel.Builder()).build(product.getBestSeller(), getResources());
            bestSeller.buildView(((com.amazon.retailsearch.android.ui.results.views.BestSellerModel) (obj2)), viewType);
        }
        if (ratingsLine != null)
        {
            obj2 = (new com.amazon.retailsearch.android.ui.results.views.RatingsLineModel.Builder()).build(ratings, getResources());
            ratingsLine.buildView(((com.amazon.retailsearch.android.ui.results.views.RatingsLineModel) (obj2)), viewType);
        }
        setVisibility(0);
    }

    public Product getProduct()
    {
        return product;
    }

    protected void init(Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        swipeDetector = new SwipeDetector(getContext(), new SwipeListener());
        gestureListener = new ProductGestureListener(getResources().getDisplayMetrics());
        gestureDetector = new GestureDetector(getContext(), gestureListener);
    }

    protected void initProductElements()
    {
        imageWrapper = (ImageWrapper)findViewById(com.amazon.retailsearch.R.id.rs_results_image_wrapper);
        title = (TextView)findViewById(com.amazon.retailsearch.R.id.item_title);
        editionLine = (EditionLine)findViewById(com.amazon.retailsearch.R.id.item_edition);
        price = (Price)findViewById(com.amazon.retailsearch.R.id.rs_results_price);
        offersLine = (OffersLine)findViewById(com.amazon.retailsearch.R.id.item_offers_line);
        twister = (Twister)findViewById(com.amazon.retailsearch.R.id.rs_item_twister);
        subscribeAndSave = (SubscribeAndSave)findViewById(com.amazon.retailsearch.R.id.item_subscribe_and_save);
        freeRentalLine = (FreeRentalLine)findViewById(com.amazon.retailsearch.R.id.item_free_rental_line);
        bestSeller = (BestSeller)findViewById(com.amazon.retailsearch.R.id.rs_results_best_seller);
        ratingsLine = (RatingsLine)findViewById(com.amazon.retailsearch.R.id.rs_results_ratings);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initProductElements();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        if (thumbSwitcher == null)
        {
            flag = gestureDetector.onTouchEvent(motionevent);
        } else
        {
            flag = swipeDetector.onTouchEvent(motionevent);
        }
        flag1 = flag;
        if (!swipeDetector.isSwiping())
        {
            flag1 = flag;
            if (!swiped)
            {
                flag1 = flag | gestureDetector.onTouchEvent(motionevent);
            }
        }
        return flag1 || super.onTouchEvent(motionevent);
    }

}
