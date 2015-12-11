// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.animations.AnimatableResultsImage;
import com.amazon.retailsearch.android.ui.listadapter.ContentSwitcherController;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.android.ui.results.layout.SearchLayout;
import com.amazon.retailsearch.android.ui.results.views.BestSeller;
import com.amazon.retailsearch.android.ui.results.views.RatingsLine;
import com.amazon.retailsearch.android.ui.results.views.image.ImageWrapper;
import com.amazon.retailsearch.android.ui.results.views.image.ThumbSwitcher;
import com.amazon.retailsearch.android.ui.results.views.messaging.EditionLine;
import com.amazon.retailsearch.android.ui.results.views.messaging.Sponsored;
import com.amazon.retailsearch.android.ui.results.views.messaging.Subtitle;
import com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLine;
import com.amazon.retailsearch.android.ui.results.views.price.OffersLine;
import com.amazon.retailsearch.android.ui.results.views.price.Price;
import com.amazon.retailsearch.android.ui.results.views.price.PriceModel;
import com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSave;
import com.amazon.retailsearch.android.ui.results.views.twister.Twister;
import com.amazon.retailsearch.data.EditionsPriceInfoUtil;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.data.stores.StoreManager;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;
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
//            ProductViewModel, ResultLayoutType, SwipeDetector, ContentSwitcherModel, 
//            ContentSwitcher

public abstract class ProductView extends FrameLayout
    implements ContentSwitcherController, ModelView
{
    private class SwipeListener
        implements SwipeDetector.Listener
    {

        final ProductView this$0;

        private boolean eventInView(MotionEvent motionevent, View view, int i)
        {
            int ai[] = new int[2];
            view.getLocationOnScreen(ai);
            float f = (float)view.getWidth() / 2.0F;
            float f1 = (float)view.getHeight() / 2.0F;
            float f2 = (float)i * getResources().getDisplayMetrics().density;
            float f3 = Math.abs(((float)ai[0] + f) - motionevent.getRawX());
            float f4 = Math.abs(((float)ai[1] + f1) - motionevent.getRawY());
            return f3 <= Math.max(f2, f) && f4 <= Math.max(f2, f1);
        }

        public boolean onDown(MotionEvent motionevent)
        {
            boolean flag1 = false;
            if (!swipeDetector.isSwiping())
            {
                swiped = false;
            }
            boolean flag = flag1;
            if (imageWrapper.getChildCount() > 0)
            {
                flag = flag1;
                if (eventInView(motionevent, imageWrapper, 0))
                {
                    flag = true;
                }
            }
            return flag;
        }

        public boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3)
        {
            if (!swiped)
            {
                swiped = true;
                motionevent = imageWrapper.getThumbSwitcher();
                int j = motionevent.getPosition();
                int i;
                if (f2 < 0.0F)
                {
                    i = 1;
                } else
                {
                    i = -1;
                }
                motionevent.setPosition(motionevent.normalizePosition(i + j));
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
    protected AnimatableResultsImage animationImage;
    protected Availability availabilityInfo;
    private BestSeller bestSeller;
    protected ContentSwitcher contentSwitcher;
    protected EditionLine editionLine;
    private FreeRentalLine freeRentalLine;
    protected GestureDetector gestureDetector;
    protected ProductGestureListener gestureListener;
    protected boolean hasAutoRip;
    protected ImageView imageView;
    protected ImageWrapper imageWrapper;
    protected boolean isImageAnimated;
    protected boolean isSponsoredPrice;
    protected PriceInfo mainPrice;
    protected ProductViewModel model;
    protected int numOffers;
    private OffersLine offersLine;
    protected Price price;
    protected Product product;
    protected ImageRequestFactory productImageFactory;
    protected Ratings ratings;
    private RatingsLine ratingsLine;
    protected ResourceProvider resourceProvider;
    protected RetailSearchResultItem resultItem;
    protected ResultLayoutType resultLayoutType;
    IRetailSearchDataProvider retailSearchDataProvider;
    protected Shipping shippingInfo;
    private Sponsored sponsored;
    protected StoreManager storeManager;
    private SubscribeAndSave subscribeAndSave;
    protected PriceInfo subscribeAndSavePrice;
    private Subtitle subtitle;
    protected SwipeDetector swipeDetector;
    protected boolean swiped;
    private TextView title;
    protected Twister twister;
    protected boolean useEditionsPricing;
    protected boolean useOffers;
    UserInteractionListener userInteractionListener;

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

    private void animateProductImage()
    {
        ViewTreeObserver viewtreeobserver;
        if (isImageAnimated)
        {
            if ((viewtreeobserver = imageView.getViewTreeObserver()) != null)
            {
                viewtreeobserver.addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                    final ProductView this$0;

                    public boolean onPreDraw()
                    {
                        imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                        int ai[] = calculateAnimationImageFinalCoords();
                        int i = imageView.getWidth();
                        int j = imageView.getHeight();
                        AnimatableResultsImage animatableresultsimage = animationImage;
                        android.animation.Animator.AnimatorListener animatorlistener = new android.animation.Animator.AnimatorListener() {

                            final _cls1 this$1;

                            public void onAnimationCancel(Animator animator)
                            {
                            }

                            public void onAnimationEnd(Animator animator)
                            {
                                imageView.setVisibility(0);
                                animationImage.setVisibility(8);
                                model.getSearchLayout().enableTouchEvents();
                            }

                            public void onAnimationRepeat(Animator animator)
                            {
                            }

                            public void onAnimationStart(Animator animator)
                            {
                                model.getSearchLayout().disableTouchEvents();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        };
                        animatableresultsimage.animateToDestination(ai, new int[] {
                            i, j
                        }, animatorlistener);
                        return true;
                    }

            
            {
                this$0 = ProductView.this;
                super();
            }
                });
                return;
            }
        }
    }

    private int[] calculateAnimationImageFinalCoords()
    {
        int ai[] = new int[2];
        getLocationOnScreen(ai);
        int ai1[] = new int[2];
        imageView.getLocationOnScreen(ai1);
        int ai2[] = model.getSearchLayout().getCoordinates();
        int j = ai1[0];
        int k = ai2[0];
        int l = ai1[1];
        int i1 = ai[1];
        int i = ai[1] - ai2[1];
        if (resultLayoutType == ResultLayoutType.ImmersiveView)
        {
            i = 75;
        }
        return (new int[] {
            j - k, i + (l - i1)
        });
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
        Object obj = null;
        PriceInfo priceinfo;
        if (model.getActiveOffer() != null)
        {
            priceinfo = EditionsPriceInfoUtil.toPriceInfo(model.getActiveOffer());
        } else
        {
            Prices prices = product.getPrices();
            priceinfo = obj;
            if (prices != null)
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
                priceinfo = obj;
                if (prices.getSponsored() != null)
                {
                    return prices.getSponsored();
                }
            }
        }
        return priceinfo;
    }

    private Shipping getShippingInfo()
    {
        if (model.getActiveOffer() != null)
        {
            return model.getActiveOffer().getShipping();
        } else
        {
            return product.getShipping();
        }
    }

    private boolean isDigitalVideoEditionsType(Prices prices)
    {
        return prices != null && "digital_video".equals(prices.getEditionsType());
    }

    public void build(ProductViewModel productviewmodel)
    {
        boolean flag1 = true;
        model = productviewmodel;
        if (productviewmodel == null || productviewmodel.getProduct() == null)
        {
            setVisibility(8);
            return;
        }
        productviewmodel.invalidateCartStates();
        product = productviewmodel.getProduct();
        productImageFactory = productviewmodel.getProductImageFactory();
        resourceProvider = productviewmodel.getResourceProvider();
        animationImage = productviewmodel.getAnimationImage();
        Object obj;
        Object obj1;
        int i;
        boolean flag;
        if (product.getOffers() != null)
        {
            i = product.getOffers().size();
        } else
        {
            i = 0;
        }
        numOffers = i;
        if (retailSearchDataProvider.getStoreManager().isMultiStoreOffersEnabled() && numOffers > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        useOffers = flag;
        if (numOffers > 0 && productviewmodel.getActiveOffer() == null)
        {
            productviewmodel.setActiveOffer((EditionsPriceInfo)product.getOffers().get(0));
        }
        if (productviewmodel.getActiveOffer() != null && productviewmodel.getActiveOffer().getLink() != null)
        {
            obj = productviewmodel.getActiveOffer().getLink().getUrl();
        } else
        {
            obj = null;
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (product.getLink() != null)
            {
                obj1 = obj;
                if (!TextUtils.isEmpty(product.getLink().getUrl()))
                {
                    obj1 = product.getLink().getUrl();
                }
            }
        }
        resultItem = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(product.getAsin(), ((String) (obj1)), product.getGroup());
        gestureListener.setResultItem(resultItem);
        gestureListener.setProductView(this);
        swiped = false;
        shippingInfo = getShippingInfo();
        mainPrice = getMainPrice();
        obj1 = product.getPrices();
        if (obj1 != null && (((Prices) (obj1)).getDigital() != null || isDigitalVideoEditionsType(((Prices) (obj1)))) && ((Prices) (obj1)).getEditions() != null && !((Prices) (obj1)).getEditions().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        useEditionsPricing = flag;
        availabilityInfo = getAvailabilityInfo();
        if (obj1 != null)
        {
            obj = ((Prices) (obj1)).getSponsored();
        } else
        {
            obj = null;
        }
        if (mainPrice != null && mainPrice == obj)
        {
            flag = true;
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
        if (obj1 != null && ((Prices) (obj1)).getSubscribeAndSave() != null)
        {
            subscribeAndSavePrice = ((Prices) (obj1)).getSubscribeAndSave();
        }
        if (android.os.Build.VERSION.SDK_INT >= 11 && animationImage != null && animationImage.getTargetProductModel() == productviewmodel)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isImageAnimated = flag;
        buildView();
        if (userInteractionListener != null && imageWrapper != null)
        {
            userInteractionListener.resultItemBuilt(this, imageWrapper.getImageView(), product.getAsin());
        }
        animateProductImage();
    }

    public volatile void build(Object obj)
    {
        build((ProductViewModel)obj);
    }

    protected void buildView()
    {
        com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel.Builder builder = (new com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel.Builder()).setCartState(model, imageWrapper);
        Object obj1 = product.getAsin();
        String s = product.getTitle();
        com.amazon.searchapp.retailsearch.model.Image image = product.getImage();
        List list = product.getInbandImages();
        List list1 = product.getAltImages();
        boolean flag = imageWrapper.hasThumbSwitcher();
        ImageRequestFactory imagerequestfactory = productImageFactory;
        ResourceProvider resourceprovider = resourceProvider;
        boolean flag1 = isImageAnimated;
        Object obj;
        if (isImageAnimated)
        {
            obj = animationImage.getDrawable();
        } else
        {
            obj = null;
        }
        obj = builder.build(((String) (obj1)), s, image, list, list1, flag, imagerequestfactory, resourceprovider, flag1, ((android.graphics.drawable.Drawable) (obj)));
        imageWrapper.buildView(((com.amazon.retailsearch.android.ui.results.views.image.ImageWrapperModel) (obj)), resultLayoutType);
        if (product.getTitle() == null)
        {
            title.setText("");
        } else
        {
            title.setText(product.getTitle());
        }
        if (subtitle != null || editionLine != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.EditionLineModel.Builder()).build(mainPrice, useEditionsPricing, product.getTypeName(), isSponsoredPrice);
        } else
        {
            obj = null;
        }
        if (subtitle != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.SubtitleModel.Builder()).build(product.getByLine(), ((com.amazon.retailsearch.android.ui.results.views.messaging.EditionLineModel) (obj)));
            subtitle.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.SubtitleModel) (obj)), resultLayoutType);
        } else
        if (editionLine != null)
        {
            editionLine.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.EditionLineModel) (obj)), resultLayoutType);
        }
        obj1 = product.getPrices();
        if (model.getActiveOffer() == null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.price.PriceModel.Builder()).build(((Prices) (obj1)), mainPrice, shippingInfo, useEditionsPricing, isSponsoredPrice, price.getShowListPrice(), price.getShowSomePrime());
        } else
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.price.PriceModel.Builder()).build(mainPrice, shippingInfo, price.getShowListPrice(), price.getShowSomePrime());
        }
        price.buildView(((PriceModel) (obj)), resultLayoutType);
        if (obj != null)
        {
            flag = ((PriceModel) (obj)).hasAutoRip();
        } else
        {
            flag = false;
        }
        hasAutoRip = flag;
        if (offersLine != null)
        {
            obj = new com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel.Builder();
            if (price.getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel.Builder) (obj)).build(((Prices) (obj1)), flag, offersLine.getIsPriceBackup());
            offersLine.buildView(((com.amazon.retailsearch.android.ui.results.views.price.OffersLineModel) (obj)), resultLayoutType);
        }
        if (twister != null)
        {
            com.amazon.searchapp.retailsearch.model.EditionsMetadata editionsmetadata;
            if (obj1 == null)
            {
                obj = null;
            } else
            {
                obj = ((Prices) (obj1)).getEditionsType();
            }
            if (obj1 == null)
            {
                editionsmetadata = null;
            } else
            {
                editionsmetadata = ((Prices) (obj1)).getEditionsMetadata();
            }
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = ((Prices) (obj1)).getEditions();
            }
            obj = (new com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel.Builder()).build(product.getTitle(), ((String) (obj)), editionsmetadata, ((List) (obj1)), product.getGroup(), getContext());
            twister.buildView(((com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel) (obj)), resultLayoutType);
        }
        if (subscribeAndSave != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSaveModel.Builder()).build(subscribeAndSavePrice, subscribeAndSave.getShowSaveMoreText(), resultLayoutType, getResources());
            subscribeAndSave.buildView(((com.amazon.retailsearch.android.ui.results.views.price.SubscribeAndSaveModel) (obj)), resultLayoutType);
        }
        if (freeRentalLine != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLineModel.Builder()).build(product.getPrices(), shippingInfo);
            freeRentalLine.buildView(((com.amazon.retailsearch.android.ui.results.views.price.FreeRentalLineModel) (obj)), resultLayoutType);
        }
        if (bestSeller != null && !hasPastPurchases())
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.BestSellerModel.Builder()).build(product.getBestSeller(), getResources());
            bestSeller.buildView(((com.amazon.retailsearch.android.ui.results.views.BestSellerModel) (obj)), resultLayoutType);
        }
        if (ratingsLine != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.RatingsLineModel.Builder()).build(ratings, getResources());
            ratingsLine.buildView(((com.amazon.retailsearch.android.ui.results.views.RatingsLineModel) (obj)), resultLayoutType);
        }
        if (sponsored != null)
        {
            obj = (new com.amazon.retailsearch.android.ui.results.views.messaging.SponsoredModel.Builder()).build(product.getType(), product.getDecorations());
            sponsored.buildView(((com.amazon.retailsearch.android.ui.results.views.messaging.SponsoredModel) (obj)), resultLayoutType);
        }
        setVisibility(0);
    }

    public ContentSwitcher getContentSwitcher()
    {
        return contentSwitcher;
    }

    public ProductViewModel getModel()
    {
        return model;
    }

    public Product getProduct()
    {
        return product;
    }

    public ResultLayoutType getResultLayoutType()
    {
        return resultLayoutType;
    }

    protected boolean hasPastPurchases()
    {
        return false;
    }

    protected void init(Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        storeManager = retailSearchDataProvider.getStoreManager();
        swipeDetector = new SwipeDetector(getContext(), new SwipeListener());
        gestureListener = new ProductGestureListener(getResources().getDisplayMetrics());
        gestureDetector = new GestureDetector(getContext(), gestureListener);
    }

    protected void initProductElements()
    {
        imageWrapper = (ImageWrapper)findViewById(com.amazon.retailsearch.R.id.rs_results_image_wrapper);
        imageView = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_results_image);
        title = (TextView)findViewById(com.amazon.retailsearch.R.id.item_title);
        subtitle = (Subtitle)findViewById(com.amazon.retailsearch.R.id.rs_item_subtitle);
        editionLine = (EditionLine)findViewById(com.amazon.retailsearch.R.id.item_edition);
        price = (Price)findViewById(com.amazon.retailsearch.R.id.rs_results_price);
        offersLine = (OffersLine)findViewById(com.amazon.retailsearch.R.id.item_offers_line);
        twister = (Twister)findViewById(com.amazon.retailsearch.R.id.rs_item_twister);
        subscribeAndSave = (SubscribeAndSave)findViewById(com.amazon.retailsearch.R.id.item_subscribe_and_save);
        freeRentalLine = (FreeRentalLine)findViewById(com.amazon.retailsearch.R.id.item_free_rental_line);
        bestSeller = (BestSeller)findViewById(com.amazon.retailsearch.R.id.rs_results_best_seller);
        ratingsLine = (RatingsLine)findViewById(com.amazon.retailsearch.R.id.rs_results_ratings);
        sponsored = (Sponsored)findViewById(com.amazon.retailsearch.R.id.rs_results_sponsored_message);
    }

    public boolean isImmersiveViewSupported()
    {
        return model != null && model.isImmersiveViewSupported() && contentSwitcher != null;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initProductElements();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 66 || i == 23)
        {
            userInteractionListener.resultItemSelected(resultItem, DetailPageType.MAIN);
        }
        return super.onKeyUp(i, keyevent);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent != null)
        {
            boolean flag;
            boolean flag1;
            if (imageWrapper == null || !imageWrapper.hasThumbSwitcher())
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
            if (!flag1 && !super.onTouchEvent(motionevent))
            {
                return false;
            }
        }
        return true;
    }

    public void scrollIntoView()
    {
        if (model != null && model.getSearchLayout() != null && model.getResultsModel() != null)
        {
            model.getSearchLayout().scrollToResultsModel(model.getResultsModel(), 350);
        }
    }

    public void setContentSwitcher(ContentSwitcher contentswitcher)
    {
        contentSwitcher = contentswitcher;
    }

    public void switchViewTypes(ContentSwitcherModel contentswitchermodel)
    {
        if (getContentSwitcher() == null || !contentswitchermodel.isValid())
        {
            return;
        }
        if (animationImage != null)
        {
            animationImage.positionOverInitialImage(imageView);
            animationImage.setAnimationSpeed(350);
            animationImage.setTargetModel(model);
        }
        getContentSwitcher().switchViews(contentswitchermodel);
    }

    public void switchViewTypes(EditionsPriceInfo editionspriceinfo, ContentSwitcherModel contentswitchermodel)
    {
        model.setActiveOffer(editionspriceinfo);
        switchViewTypes(contentswitchermodel);
    }


}
