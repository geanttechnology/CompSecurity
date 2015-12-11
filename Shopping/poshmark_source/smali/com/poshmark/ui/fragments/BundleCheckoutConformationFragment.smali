.class public Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;
.super Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;
.source "BundleCheckoutConformationFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public handleBack()Z
    .locals 6

    .prologue
    .line 259
    iget-object v2, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v2}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    .line 260
    .local v1, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/poshmark/http/api/PMApi;->releaseBundle(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 261
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 262
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "listing"

    const-string v5, "removed_lineitem_from_order"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    const/4 v2, 0x0

    return v2
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->onCreate(Landroid/os/Bundle;)V

    .line 36
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 45
    const-string v0, "multi_item_checkout_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 40
    invoke-super {p0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupActionBar()V

    .line 41
    const v0, 0x7f060078

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->setTitle(Ljava/lang/String;)V

    .line 42
    return-void
.end method

.method protected setupView(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 50
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupView(Landroid/view/View;)V

    .line 51
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->singleItemSummaryAndPricingContainer:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 52
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->lineItemsLayout:Landroid/widget/LinearLayout;

    .line 53
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->lineItemsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 54
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    const v0, 0x7f0c00a6

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 56
    return-void
.end method

.method protected updateView()V
    .locals 42

    .prologue
    .line 60
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->current_state:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    move-object/from16 v38, v0

    sget-object v39, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;->GATHER_DETAILS:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE;

    move-object/from16 v0, v38

    move-object/from16 v1, v39

    if-ne v0, v1, :cond_1

    .line 255
    :cond_0
    :goto_0
    return-void

    .line 63
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    move-object/from16 v38, v0

    invoke-virtual/range {v38 .. v38}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v24

    .line 65
    .local v24, "poshmarkOrder":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Ljava/util/List;->size()I

    move-result v38

    if-lez v38, :cond_0

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAmount()Ljava/util/List;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Ljava/util/List;->size()I

    move-result v38

    if-lez v38, :cond_0

    .line 68
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v12

    .line 69
    .local v12, "currencySymbol":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Landroid/support/v4/app/FragmentActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v18

    .line 72
    .local v18, "inflater":Landroid/view/LayoutInflater;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->lineItemsLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    invoke-virtual/range {v38 .. v38}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 73
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    invoke-virtual/range {v38 .. v38}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 76
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getLineItems()Ljava/util/List;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v20

    .line 77
    .local v20, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/LineItem;>;"
    :goto_1
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v38

    if-eqz v38, :cond_3

    .line 78
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Lcom/poshmark/data_model/models/inner_models/LineItem;

    .line 80
    .local v21, "lineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    const v38, 0x7f03005a

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/LinearLayout;

    .line 82
    .local v19, "itemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0162

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/ImageView;

    .line 83
    .local v22, "listingImageView":Landroid/widget/ImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v17

    .line 84
    .local v17, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPictureURL()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v17

    move-object/from16 v1, v38

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 86
    const v38, 0x7f0c0035

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 87
    .local v36, "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getTitle()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 89
    const v38, 0x7f0c0163

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v26

    check-cast v26, Lcom/poshmark/ui/customviews/PMTextView;

    .line 90
    .local v26, "priceView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v38

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getPrice()Ljava/math/BigDecimal;

    move-result-object v39

    invoke-static/range {v39 .. v39}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v26

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    const v38, 0x7f0c0164

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v33

    check-cast v33, Lcom/poshmark/ui/customviews/PMTextView;

    .line 93
    .local v33, "sizeView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    const v39, 0x7f060281

    move-object/from16 v0, p0

    move/from16 v1, v39

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v21 .. v21}, Lcom/poshmark/data_model/models/inner_models/LineItem;->getSize()Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v33

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    const v38, 0x7f0c012a

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 96
    .local v7, "bottomBorder":Landroid/view/View;
    const v38, 0x7f0c0165

    move-object/from16 v0, v19

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v30

    .line 98
    .local v30, "separatorView":Landroid/view/View;
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v38

    if-eqz v38, :cond_2

    .line 99
    const/16 v38, 0x8

    move/from16 v0, v38

    invoke-virtual {v7, v0}, Landroid/view/View;->setVisibility(I)V

    .line 100
    const/16 v38, 0x0

    move-object/from16 v0, v30

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 107
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->lineItemsLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_1

    .line 103
    :cond_2
    const/16 v38, 0x0

    move/from16 v0, v38

    invoke-virtual {v7, v0}, Landroid/view/View;->setVisibility(I)V

    .line 104
    const/16 v38, 0x8

    move-object/from16 v0, v30

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 113
    .end local v7    # "bottomBorder":Landroid/view/View;
    .end local v17    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    .end local v19    # "itemView":Landroid/widget/LinearLayout;
    .end local v21    # "lineItem":Lcom/poshmark/data_model/models/inner_models/LineItem;
    .end local v22    # "listingImageView":Landroid/widget/ImageView;
    .end local v26    # "priceView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v30    # "separatorView":Landroid/view/View;
    .end local v33    # "sizeView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_3
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/math/BigDecimal;->doubleValue()D

    move-result-wide v38

    const-wide/16 v40, 0x0

    cmpl-double v38, v38, v40

    if-lez v38, :cond_4

    .line 114
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v27

    check-cast v27, Landroid/widget/LinearLayout;

    .line 115
    .local v27, "pricingSummaryItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move-object/from16 v0, v27

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 116
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f060067

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    const v38, 0x7f0c0163

    move-object/from16 v0, v27

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 119
    .local v25, "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalOriginalPriceString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 125
    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v27    # "pricingSummaryItemView":Landroid/widget/LinearLayout;
    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_4
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getDiscounts()Ljava/util/List;

    move-result-object v38

    invoke-interface/range {v38 .. v38}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .line 126
    .local v16, "discountItr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMDiscount;>;"
    :cond_5
    :goto_3
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v38

    if-eqz v38, :cond_6

    .line 127
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/poshmark/data_model/models/PMDiscount;

    .line 128
    .local v14, "discount":Lcom/poshmark/data_model/models/PMDiscount;
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/PMDiscount;->getTargetType()Ljava/lang/String;

    move-result-object v38

    const-string v39, "iprc"

    invoke-virtual/range {v38 .. v39}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v38

    if-eqz v38, :cond_5

    .line 129
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/LinearLayout;

    .line 130
    .local v15, "discountItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move/from16 v0, v38

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 131
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/PMDiscount;->getTitle()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 133
    const v38, 0x7f0c0163

    move/from16 v0, v38

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 134
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    const-string v39, "-"

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/PMDiscount;->getDiscountPriceString()Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 136
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    invoke-virtual {v0, v15}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_3

    .line 142
    .end local v14    # "discount":Lcom/poshmark/data_model/models/PMDiscount;
    .end local v15    # "discountItemView":Landroid/widget/LinearLayout;
    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_6
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v32

    check-cast v32, Landroid/widget/LinearLayout;

    .line 143
    .local v32, "shippingItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move-object/from16 v0, v32

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 144
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f060260

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 146
    const v38, 0x7f0c0163

    move-object/from16 v0, v32

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 147
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalShippingString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 149
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getShippingDiscountTitle()Ljava/lang/String;

    move-result-object v31

    .line 150
    .local v31, "shippingDiscountTitle":Ljava/lang/String;
    if-eqz v31, :cond_7

    invoke-virtual/range {v31 .. v31}, Ljava/lang/String;->length()I

    move-result v38

    if-lez v38, :cond_7

    .line 151
    const v38, 0x7f0c0135

    move-object/from16 v0, v32

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Lcom/poshmark/ui/customviews/PMTextView;

    .line 152
    .local v13, "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    const/16 v38, 0x0

    move/from16 v0, v38

    invoke-virtual {v13, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 153
    move-object/from16 v0, v31

    invoke-virtual {v13, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 156
    .end local v13    # "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_7
    const v38, 0x7f0c0165

    move-object/from16 v0, v32

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v29

    .line 157
    .local v29, "separator":Landroid/view/View;
    const/16 v38, 0x0

    move-object/from16 v0, v29

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 159
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 164
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalTax()Ljava/math/BigDecimal;

    move-result-object v38

    sget-object v39, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual/range {v38 .. v39}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v38

    if-lez v38, :cond_8

    .line 165
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v35

    check-cast v35, Landroid/widget/LinearLayout;

    .line 166
    .local v35, "taxItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move-object/from16 v0, v35

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 167
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f060297

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 169
    const v38, 0x7f0c0163

    move-object/from16 v0, v35

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 170
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalTaxString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 172
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 177
    .end local v35    # "taxItemView":Landroid/widget/LinearLayout;
    :cond_8
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v37

    check-cast v37, Landroid/widget/LinearLayout;

    .line 178
    .local v37, "totalItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    invoke-virtual/range {v37 .. v38}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 179
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f06029d

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 181
    const v38, 0x7f0c0163

    invoke-virtual/range {v37 .. v38}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 182
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 184
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 188
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getCreditsToApply()Ljava/math/BigDecimal;

    move-result-object v38

    sget-object v39, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual/range {v38 .. v39}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v38

    if-lez v38, :cond_9

    .line 189
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/LinearLayout;

    .line 190
    .local v11, "creditsItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move/from16 v0, v38

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 191
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f06020c

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 193
    const v38, 0x7f0c0163

    move/from16 v0, v38

    invoke-virtual {v11, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 194
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    const-string v39, "-"

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getCreditsToApplyString()Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 196
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    invoke-virtual {v0, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 200
    .end local v11    # "creditsItemView":Landroid/widget/LinearLayout;
    :cond_9
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getRedeemableToApply()Ljava/math/BigDecimal;

    move-result-object v38

    sget-object v39, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual/range {v38 .. v39}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v38

    if-lez v38, :cond_a

    .line 201
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v28

    check-cast v28, Landroid/widget/LinearLayout;

    .line 202
    .local v28, "redeemableItemView":Landroid/widget/LinearLayout;
    const v38, 0x7f0c0270

    move-object/from16 v0, v28

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 203
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const v38, 0x7f060222

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 205
    const v38, 0x7f0c0163

    move-object/from16 v0, v28

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 206
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v38, Ljava/lang/StringBuilder;

    invoke-direct/range {v38 .. v38}, Ljava/lang/StringBuilder;-><init>()V

    const-string v39, "-"

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getRedeemableToApplyString()Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 208
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 213
    .end local v28    # "redeemableItemView":Landroid/widget/LinearLayout;
    :cond_a
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v38

    const/high16 v39, 0x41200000    # 10.0f

    invoke-static/range {v38 .. v39}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v38

    move/from16 v0, v38

    float-to-int v0, v0

    move/from16 v34, v0

    .line 215
    .local v34, "spacing":I
    const v38, 0x7f0300a5

    const/16 v39, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v38

    move-object/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v23

    check-cast v23, Landroid/widget/LinearLayout;

    .line 216
    .local v23, "netChargeItemView":Landroid/widget/LinearLayout;
    const/16 v38, 0x0

    div-int/lit8 v39, v34, 0x2

    const/16 v40, 0x0

    const/16 v41, 0x0

    move-object/from16 v0, v23

    move/from16 v1, v38

    move/from16 v2, v39

    move/from16 v3, v40

    move/from16 v4, v41

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 218
    const v38, 0x7f0c026f

    move-object/from16 v0, v23

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    .line 219
    .local v9, "contentLayout":Landroid/widget/LinearLayout;
    move/from16 v0, v34

    move/from16 v1, v34

    move/from16 v2, v34

    move/from16 v3, v34

    invoke-virtual {v9, v0, v1, v2, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 220
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v38

    const v39, 0x7f090009

    invoke-virtual/range {v38 .. v39}, Landroid/content/res/Resources;->getColor(I)I

    move-result v38

    move/from16 v0, v38

    invoke-virtual {v9, v0}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 223
    const v38, 0x7f0c0270

    move-object/from16 v0, v23

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v36

    .end local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v36, Lcom/poshmark/ui/customviews/PMTextView;

    .line 224
    .restart local v36    # "titleView":Lcom/poshmark/ui/customviews/PMTextView;
    const/16 v38, 0x0

    const/16 v39, 0x1

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    move/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 225
    const v38, 0x7f0601be

    move-object/from16 v0, p0

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getString(I)Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v36

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 227
    const v38, 0x7f0c0163

    move-object/from16 v0, v23

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .end local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    check-cast v25, Lcom/poshmark/ui/customviews/PMTextView;

    .line 228
    .restart local v25    # "priceTextView":Lcom/poshmark/ui/customviews/PMTextView;
    const/16 v38, 0x2

    const/high16 v39, 0x41900000    # 18.0f

    move-object/from16 v0, v25

    move/from16 v1, v38

    move/from16 v2, v39

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextSize(IF)V

    .line 229
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getNetBalanceString()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v25

    move-object/from16 v1, v38

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalDiscountTitle()Ljava/lang/String;

    move-result-object v38

    if-eqz v38, :cond_b

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalDiscountTitle()Ljava/lang/String;

    move-result-object v38

    invoke-virtual/range {v38 .. v38}, Ljava/lang/String;->length()I

    move-result v38

    if-lez v38, :cond_b

    .line 231
    const v38, 0x7f0c0135

    move-object/from16 v0, v23

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Lcom/poshmark/ui/customviews/PMTextView;

    .line 232
    .restart local v13    # "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    const/16 v38, 0x0

    move/from16 v0, v38

    invoke-virtual {v13, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 233
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getTotalDiscountTitle()Ljava/lang/String;

    move-result-object v38

    move-object/from16 v0, v38

    invoke-virtual {v13, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 237
    .end local v13    # "descriptionView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->bundleOrderPricingSummaryLayout:Landroid/widget/LinearLayout;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 239
    const v38, 0x7f0c012a

    move-object/from16 v0, v23

    move/from16 v1, v38

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 240
    .local v6, "border":Landroid/view/View;
    const/16 v38, 0x0

    move/from16 v0, v38

    invoke-virtual {v6, v0}, Landroid/view/View;->setVisibility(I)V

    .line 244
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    move-object/from16 v38, v0

    invoke-virtual/range {v38 .. v38}, Lcom/poshmark/utils/CheckoutFlowHandler;->getCreditCard()Lcom/poshmark/data_model/models/inner_models/CreditCard;

    move-result-object v10

    .line 245
    .local v10, "creditCard":Lcom/poshmark/data_model/models/inner_models/CreditCard;
    if-eqz v10, :cond_d

    invoke-virtual {v10}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getNumber()Ljava/lang/String;

    move-result-object v38

    if-eqz v38, :cond_d

    .line 246
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v38

    move-object/from16 v0, v38

    invoke-static {v0, v10}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromCreditCard(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/CreditCard;)Ljava/lang/String;

    move-result-object v8

    .line 247
    .local v8, "ccText":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 254
    .end local v8    # "ccText":Ljava/lang/String;
    :cond_c
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeShippingInfoButton:Landroid/widget/Button;

    move-object/from16 v38, v0

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getShippingAddress()Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v39

    invoke-static/range {v39 .. v39}, Lcom/poshmark/utils/AddressUtils;->addressStringWithoutPhone(Lcom/poshmark/data_model/models/inner_models/Address;)Ljava/lang/String;

    move-result-object v39

    invoke-virtual/range {v38 .. v39}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 249
    :cond_d
    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v38

    if-eqz v38, :cond_c

    .line 250
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v38

    invoke-virtual/range {v24 .. v24}, Lcom/poshmark/data_model/models/PMOrder;->getLastPaymentInfo()Lcom/poshmark/data_model/models/inner_models/PaymentInfo;

    move-result-object v39

    invoke-static/range {v38 .. v39}, Lcom/poshmark/utils/CreditCardUtils;->getStringFromPaymentInfo(Landroid/content/Context;Lcom/poshmark/data_model/models/inner_models/PaymentInfo;)Ljava/lang/String;

    move-result-object v8

    .line 251
    .restart local v8    # "ccText":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/BundleCheckoutConformationFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutConfirmationFormViewHolder;->changeCreditCardInfoButton:Landroid/widget/Button;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4
.end method
