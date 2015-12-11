// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.ansel.fetch.AbstractResourceListener;
import com.amazon.ansel.fetch.ImageLoader;
import com.amazon.ansel.fetch.ResourceListener;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsButton;
import com.amazon.retailsearch.android.ui.buttons.InlineActionsListener;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.MultiStoreOfferInteractionListener;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            InteractiveRetailSearchResultView, MultiStoreOfferModel

public class MultiStoreOfferView extends LinearLayout
    implements InteractiveRetailSearchResultView
{

    private static final int ADDED_TO_CART_DURATION = 800;
    private ImageView badgeView;
    private Context context;
    private InlineActionsButton inlineActionsButton;
    private TextView message;
    private MultiStoreOfferModel model;
    private int offerViewHeight;
    private int offerViewPaddingLeftRight;
    private int offerViewPaddingTopBottom;
    RetailSearchAndroidPlatform platform;
    private TextView price;
    private ResourceListener resourceListener;

    public MultiStoreOfferView(Context context1)
    {
        super(context1);
        init(context1);
    }

    public MultiStoreOfferView(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        init(context1);
    }

    private void init(Context context1)
    {
        RetailSearchDaggerGraphController.inject(this);
        context = context1;
        context1 = context1.getResources();
        offerViewHeight = (int)context1.getDimension(com.amazon.retailsearch.R.dimen.rs_multi_store_item_height);
        offerViewPaddingLeftRight = (int)context1.getDimension(com.amazon.retailsearch.R.dimen.rs_multi_store_item_padding_left_right);
        offerViewPaddingTopBottom = (int)context1.getDimension(com.amazon.retailsearch.R.dimen.rs_multi_store_item_padding_top_bottom);
    }

    private void loadBadgeImage(String s, final ImageView badgeView)
    {
        if (TextUtils.isEmpty(s) || badgeView == null)
        {
            return;
        } else
        {
            s = model.getImageFactory().fromUrl(s);
            resourceListener = new AbstractResourceListener() {

                final MultiStoreOfferView this$0;
                final ImageView val$badgeView;

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
                    badgeView.setImageBitmap(bitmap1);
                }

                public volatile void result(Object obj)
                {
                    result((Bitmap)obj);
                }

            
            {
                this$0 = MultiStoreOfferView.this;
                badgeView = imageview;
                super();
            }
            };
            s = new ImageLoader(model.getResourceProvider().getContext(), resourceListener, System.currentTimeMillis(), s);
            model.getResourceProvider().execute(s);
            return;
        }
    }

    public void buildView(MultiStoreOfferModel multistoreoffermodel, ResultLayoutType resultlayouttype)
    {
        if (multistoreoffermodel == null)
        {
            setVisibility(8);
            return;
        }
        model = multistoreoffermodel;
        Object obj = multistoreoffermodel.getBadgeUrl();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            loadBadgeImage(((String) (obj)), badgeView);
        }
        obj = new StyledSpannableString(resultlayouttype, context);
        String s = multistoreoffermodel.getPrice();
        if (!TextUtils.isEmpty(s))
        {
            ((StyledSpannableString) (obj)).append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_PriceSpan_MultiStore);
        }
        s = multistoreoffermodel.getUnitOrIssuePrice();
        if (!TextUtils.isEmpty(s))
        {
            ((StyledSpannableString) (obj)).append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_UnitPriceSpan);
        }
        s = multistoreoffermodel.getListPrice();
        if (!TextUtils.isEmpty(s))
        {
            ((StyledSpannableString) (obj)).append(s, com.amazon.retailsearch.R.style.Results_ListPriceSpan);
        }
        price.setText(((CharSequence) (obj)));
        price.setVisibility(0);
        message.setVisibility(8);
        obj = (new com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel.Builder()).setHasMultipleOffers(multistoreoffermodel.hasMultipleOffers()).setOffer(multistoreoffermodel.getOffer()).setViewSwitching(multistoreoffermodel.getProductView(), new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, multistoreoffermodel.getProductViewModel())).setInlineActionsListener(new InlineActionsListener() {

            final MultiStoreOfferView this$0;

            public void onAddToCartSuccess()
            {
                price.setVisibility(8);
                message.setVisibility(0);
                platform.invokeLater(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        price.setVisibility(0);
                        message.setVisibility(8);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }, 800L);
            }

            
            {
                this$0 = MultiStoreOfferView.this;
                super();
            }
        }).build(multistoreoffermodel.getProductViewModel().getProduct(), multistoreoffermodel.getProductViewModel().getOfferCartState(multistoreoffermodel.getOffer()));
        inlineActionsButton.buildView(((com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonModel) (obj)), resultlayouttype);
        resultlayouttype = new android.widget.LinearLayout.LayoutParams(-1, offerViewHeight);
        if (multistoreoffermodel.isShowBorder())
        {
            if (multistoreoffermodel.getOfferPosition() == MultiStoreOfferModel.OfferPosition.TOP)
            {
                UIUtils.setBackground(this, context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_top));
            } else
            if (multistoreoffermodel.getOfferPosition() == MultiStoreOfferModel.OfferPosition.BOTTOM)
            {
                UIUtils.setBackground(this, context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_bottom));
            } else
            {
                UIUtils.setBackground(this, context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_middle));
            }
        }
        setPadding(offerViewPaddingLeftRight, offerViewPaddingTopBottom, offerViewPaddingLeftRight, offerViewPaddingTopBottom);
        setLayoutParams(resultlayouttype);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((MultiStoreOfferModel)obj, resultlayouttype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        if (model.getListener() == null)
        {
            return;
        } else
        {
            model.getListener().offerSelected(model.getOffer());
            return;
        }
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        badgeView = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_multi_store_item_badge);
        price = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_multi_store_item_price);
        inlineActionsButton = (InlineActionsButton)findViewById(com.amazon.retailsearch.R.id.rs_item_button);
        message = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_multi_store_item_message);
    }


}
