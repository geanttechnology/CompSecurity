// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.SearchImageLoader;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.model.PastPurchasesModel;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Image;

public class PastPurchasesWidget extends LinearLayout
    implements ModelView
{

    public static final String AMAZON_FRESH = "amazonfresh";
    private static final int DEFAULT_QUANTITY = 1;
    private static final String QID_PARAMETER = "qid";
    private static final String SR_PARAMETER = "sr";
    private Button addToCartButton;
    private TextView header;
    private TextView itemTitle;
    private PastPurchasesModel model;
    private View pastPurchaseContainer;
    UserPreferenceManager preferencesManager;
    private ImageView productImage;
    private TextView productPrice;
    private ResourceProvider resourceProvider;
    private ResultLayoutType resultLayoutType;
    private SearchImageLoader searchImageLoader;
    private TextView seeAllLink;
    UserInteractionListener userInteractionListener;

    public PastPurchasesWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
        inflate(context, com.amazon.retailsearch.R.layout.rs_past_purchases, this);
        pastPurchaseContainer = findViewById(com.amazon.retailsearch.R.id.past_purchase_container);
        header = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_header);
        itemTitle = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_item_title);
        productImage = (ImageView)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_image);
        productPrice = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_product_price);
        addToCartButton = (Button)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_btn_add_to_cart);
        seeAllLink = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_past_purchase_see_all_link);
        resultLayoutType = preferencesManager.getResultLayoutType();
    }

    private void loadAndShowImage()
    {
        if (model.getProductImage() == null || TextUtils.isEmpty(model.getProductImage().getUrl()) || getSearchImageLoader() == null)
        {
            return;
        } else
        {
            productImage.setVisibility(8);
            productImage.setContentDescription(model.getProductImage().getAltText());
            getSearchImageLoader().load(model.getProductImage().getUrl(), new SearchImageLoaderListener() {

                final PastPurchasesWidget this$0;

                public void onLoad(Bitmap bitmap)
                {
                    productImage.setImageBitmap(bitmap);
                    productImage.setVisibility(0);
                }

            
            {
                this$0 = PastPurchasesWidget.this;
                super();
            }
            });
            return;
        }
    }

    private void setText(TextView textview, SpannableStringBuilder spannablestringbuilder)
    {
        if (TextUtils.isEmpty(spannablestringbuilder))
        {
            textview.setVisibility(8);
            return;
        } else
        {
            textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            textview.setVisibility(0);
            return;
        }
    }

    private void setText(TextView textview, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            textview.setVisibility(8);
            return;
        } else
        {
            textview.setText(s);
            textview.setVisibility(0);
            return;
        }
    }

    private void setupAddToCart()
    {
        addToCartButton.setVisibility(8);
    }

    private void setupItemClickListeners()
    {
        pastPurchaseContainer.setOnClickListener(new android.view.View.OnClickListener() {

            final PastPurchasesWidget this$0;

            public void onClick(View view)
            {
                view = model.getDetailPageUrl();
                int i;
                if (view.indexOf("/dp/") > 0)
                {
                    i = view.indexOf("/dp/") + 4;
                } else
                {
                    i = 0;
                }
                view = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(null, view.substring(i), null);
                userInteractionListener.resultItemSelected(view, DetailPageType.MAIN);
            }

            
            {
                this$0 = PastPurchasesWidget.this;
                super();
            }
        });
    }

    private void showPriceAndPrimeBadge()
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, getContext());
        if (!TextUtils.isEmpty(model.getBuyingPrice()))
        {
            styledspannablestring.append(model.getBuyingPrice(), com.amazon.retailsearch.R.style.Rs_Widget_PastPurchase_PriceText);
            if (!TextUtils.isEmpty(model.getPrimeBadgeAssetId()))
            {
                styledspannablestring.append(" ", com.amazon.retailsearch.R.style.Rs_Widget_PastPurchase_PriceText);
                styledspannablestring.appendBadge(model.getPrimeBadgeAssetId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_PriceBadgeSpan));
            }
        }
        setText(productPrice, styledspannablestring);
    }

    private void showSeeAllLink()
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, getContext());
        if (!Utils.isEmpty(model.getSeeAllLinks()) && !TextUtils.isEmpty(model.getStore()) && "amazonfresh".equals(model.getStore()))
        {
            styledspannablestring.append(model.getSeeAllLinks(), com.amazon.retailsearch.R.style.Rs_Widget_PastPurchase_SeeAllLink);
        }
        setText(seeAllLink, styledspannablestring);
    }

    public void build(PastPurchasesModel pastpurchasesmodel)
    {
        if (pastpurchasesmodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            model = pastpurchasesmodel;
            resourceProvider = model.getResourceProvider();
            loadAndShowImage();
            setText(header, model.getPurchasedDate());
            setText(itemTitle, model.getProductTitle());
            showPriceAndPrimeBadge();
            showSeeAllLink();
            setupAddToCart();
            setupItemClickListeners();
            setVisibility(0);
            return;
        }
    }

    public volatile void build(Object obj)
    {
        build((PastPurchasesModel)obj);
    }

    public SearchImageLoader getSearchImageLoader()
    {
        if (searchImageLoader == null)
        {
            searchImageLoader = (new com.amazon.retailsearch.android.ui.GeneralSearchImageLoader.Builder(resourceProvider, model.getProductImageRes())).build();
        }
        return searchImageLoader;
    }


}
