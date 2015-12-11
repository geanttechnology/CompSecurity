.class public Lcom/poshmark/ui/fragments/ViewBundleFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ViewBundleFragment.java"

# interfaces
.implements Lcom/poshmark/utils/BundleItemRemoveClickListener;


# instance fields
.field VIEW_UNAVAILABLE_ITEMS:I

.field adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

.field addMoreItemsButton:Lcom/poshmark/ui/customviews/PMButton;

.field bundleData:Lcom/poshmark/data_model/models/PMBundle;

.field bundlesListView:Landroid/widget/ListView;

.field listFooterView:Landroid/widget/LinearLayout;

.field listHeaderView:Landroid/widget/LinearLayout;

.field unavailableBundleData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation
.end field

.field unavailableItemsView:Lcom/poshmark/ui/customviews/PMTextView;

.field userName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 54
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->VIEW_UNAVAILABLE_ITEMS:I

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ViewBundleFragment;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->updateView()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ViewBundleFragment;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->fetchBundleData()V

    return-void
.end method

.method private createAllViews(Landroid/view/View;)V
    .locals 6
    .param p1, "rootView"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 144
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 145
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f0c030b

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundlesListView:Landroid/widget/ListView;

    .line 147
    const v2, 0x7f0300d0

    invoke-virtual {v0, v2, v5, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listHeaderView:Landroid/widget/LinearLayout;

    .line 148
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundlesListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listHeaderView:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 150
    const v2, 0x7f0300cf

    invoke-virtual {v0, v2, v5, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    .line 151
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundlesListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 152
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0313

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableItemsView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 153
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableItemsView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v3, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$1;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 164
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0314

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->addMoreItemsButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 165
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->addMoreItemsButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v3, Lcom/poshmark/ui/fragments/ViewBundleFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$2;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 175
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0315

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMButton;

    .line 176
    .local v1, "viewAllBundlesButton":Lcom/poshmark/ui/customviews/PMButton;
    new-instance v2, Lcom/poshmark/ui/fragments/ViewBundleFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$3;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 186
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundlesListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 187
    return-void
.end method

.method private fetchBundleData()V
    .locals 2

    .prologue
    .line 311
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 312
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->userName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ViewBundleFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$6;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getBundleFromCloset(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 327
    return-void
.end method

.method private setupBottomBar()V
    .locals 12

    .prologue
    const/4 v9, 0x1

    const/16 v11, 0x8

    const/4 v10, 0x0

    .line 260
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getView()Landroid/view/View;

    move-result-object v7

    const v8, 0x7f0c00ab

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 261
    .local v6, "v":Landroid/view/View;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-nez v7, :cond_0

    .line 262
    invoke-virtual {v6, v11}, Landroid/view/View;->setVisibility(I)V

    .line 308
    :goto_0
    return-void

    .line 266
    :cond_0
    const v7, 0x7f0c030c

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 267
    .local v3, "numItems":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v2

    .line 268
    .local v2, "itemCount":I
    if-le v2, v9, :cond_1

    .line 269
    const-string v7, "%s Items - "

    new-array v8, v9, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 274
    :goto_1
    const v7, 0x7f0c030d

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;

    .line 275
    .local v4, "priceLayout":Lcom/poshmark/ui/customviews/PMAutoScaleTextView;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PMBundle;->getFinalPriceAsString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/poshmark/ui/customviews/PMAutoScaleTextView;->setText(Ljava/lang/CharSequence;)V

    .line 277
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PMBundle;->getTotalDiscountTitle()Ljava/lang/String;

    move-result-object v1

    .line 278
    .local v1, "discountMessage":Ljava/lang/String;
    const v7, 0x7f0c030e

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 279
    .local v5, "savingsText":Lcom/poshmark/ui/customviews/PMTextView;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    if-lez v7, :cond_2

    .line 280
    invoke-virtual {v5, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 281
    invoke-virtual {v5, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 287
    :goto_2
    invoke-virtual {v6, v10}, Landroid/view/View;->setVisibility(I)V

    .line 289
    const v7, 0x7f0c0186

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 291
    .local v0, "buyButton":Landroid/widget/Button;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    if-lez v7, :cond_3

    .line 292
    invoke-virtual {v0, v10}, Landroid/widget/Button;->setVisibility(I)V

    .line 294
    new-instance v7, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$5;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-virtual {v0, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 271
    .end local v0    # "buyButton":Landroid/widget/Button;
    .end local v1    # "discountMessage":Ljava/lang/String;
    .end local v4    # "priceLayout":Lcom/poshmark/ui/customviews/PMAutoScaleTextView;
    .end local v5    # "savingsText":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_1
    const-string v7, "1 Item - "

    invoke-virtual {v3, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 284
    .restart local v1    # "discountMessage":Ljava/lang/String;
    .restart local v4    # "priceLayout":Lcom/poshmark/ui/customviews/PMAutoScaleTextView;
    .restart local v5    # "savingsText":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_2
    invoke-virtual {v5, v11}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_2

    .line 305
    .restart local v0    # "buyButton":Landroid/widget/Button;
    :cond_3
    invoke-virtual {v0, v11}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_0
.end method

.method private setupListViewHeaderFooter()V
    .locals 14

    .prologue
    const/16 v11, 0x8

    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 198
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listHeaderView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0316

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 199
    .local v1, "bundleDiscountHeaderLayout":Landroid/widget/LinearLayout;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/PMBundle;->getBundleDiscountMessage()Ljava/lang/String;

    move-result-object v5

    .line 200
    .local v5, "msg":Ljava/lang/String;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_0

    .line 201
    invoke-virtual {v1, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 202
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listHeaderView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0317

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 203
    .local v2, "discountTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v2, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 210
    .end local v2    # "discountTextView":Lcom/poshmark/ui/customviews/PMTextView;
    :goto_0
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c030f

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 211
    .local v3, "emptyBundleLayout":Landroid/widget/LinearLayout;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_1

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_1

    .line 212
    invoke-virtual {v3, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 213
    const v9, 0x7f0c010c

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMButton;

    .line 214
    .local v4, "learnMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    new-instance v9, Lcom/poshmark/ui/fragments/ViewBundleFragment$4;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment$4;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;)V

    invoke-virtual {v4, v9}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 230
    .end local v4    # "learnMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    :goto_1
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0312

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/LinearLayout;

    .line 231
    .local v7, "unavailableItemsLayout":Landroid/widget/LinearLayout;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-lez v9, :cond_3

    .line 232
    invoke-virtual {v7, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 233
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0313

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMTextView;

    .line 234
    .local v6, "textView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-ne v9, v13, :cond_2

    .line 235
    const v9, 0x7f0602c7

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    .end local v6    # "textView":Lcom/poshmark/ui/customviews/PMTextView;
    :goto_2
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0314

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMButton;

    .line 247
    .local v0, "addMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_4

    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-nez v9, :cond_4

    .line 248
    const v9, 0x7f060033

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-array v10, v13, [Ljava/lang/Object;

    iget-object v11, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v11}, Lcom/poshmark/data_model/models/PMBundle;->getSellerUsername()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    .line 253
    :goto_3
    invoke-virtual {v0, v12}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 255
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->listFooterView:Landroid/widget/LinearLayout;

    const v10, 0x7f0c0315

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lcom/poshmark/ui/customviews/PMButton;

    .line 256
    .local v8, "viewAllBundlesButton":Lcom/poshmark/ui/customviews/PMButton;
    invoke-virtual {v8, v12}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 257
    return-void

    .line 206
    .end local v0    # "addMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    .end local v3    # "emptyBundleLayout":Landroid/widget/LinearLayout;
    .end local v7    # "unavailableItemsLayout":Landroid/widget/LinearLayout;
    .end local v8    # "viewAllBundlesButton":Lcom/poshmark/ui/customviews/PMButton;
    :cond_0
    invoke-virtual {v1, v11}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 226
    .restart local v3    # "emptyBundleLayout":Landroid/widget/LinearLayout;
    :cond_1
    invoke-virtual {v3, v11}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 238
    .restart local v6    # "textView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v7    # "unavailableItemsLayout":Landroid/widget/LinearLayout;
    :cond_2
    const v9, 0x7f0602c8

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-array v10, v13, [Ljava/lang/Object;

    iget-object v11, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 242
    .end local v6    # "textView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_3
    invoke-virtual {v7, v11}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_2

    .line 251
    .restart local v0    # "addMoreButton":Lcom/poshmark/ui/customviews/PMButton;
    :cond_4
    const v9, 0x7f060035

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-array v10, v13, [Ljava/lang/Object;

    iget-object v11, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v11}, Lcom/poshmark/data_model/models/PMBundle;->getSellerUsername()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v12

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v9}, Lcom/poshmark/ui/customviews/PMButton;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3
.end method

.method private updateView()V
    .locals 5

    .prologue
    .line 190
    const v1, 0x7f060065

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMBundle;->getSellerUsername()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 191
    .local v0, "title":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->setTitle(Ljava/lang/String;)V

    .line 192
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->setupListViewHeaderFooter()V

    .line 193
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->setupBottomBar()V

    .line 194
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 115
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 136
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 137
    sget v0, Lcom/poshmark/utils/BundleFlowHandler;->BUY_BUNDLE_REQUEST:I

    if-ne p1, v0, :cond_0

    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getParentActivity()Lcom/poshmark/ui/PMActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 141
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 60
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 61
    .local v7, "uName":Ljava/lang/String;
    if-eqz v7, :cond_1

    .line 62
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->userName:Ljava/lang/String;

    .line 71
    :cond_0
    :goto_0
    new-instance v0, Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v4, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_BUNDLE:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    const/4 v5, 0x0

    const/high16 v6, -0x80000000

    move-object v2, p0

    move-object v3, p0

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/data_model/adapters/BundleListAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/utils/BundleItemRemoveClickListener;Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    .line 72
    return-void

    .line 65
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 66
    if-eqz v7, :cond_0

    .line 67
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->userName:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 77
    const v1, 0x7f0300ce

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 78
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->createAllViews(Landroid/view/View;)V

    .line 79
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 84
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 85
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 89
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 90
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 91
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    if-nez v0, :cond_1

    .line 94
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->fetchBundleData()V

    .line 98
    :goto_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.BUNDLE_ITEMS_CHANGED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 99
    return-void

    .line 96
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->updateView()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 106
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 107
    iput-object v1, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 109
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->notifyDataSetChanged()V

    .line 110
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 120
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 121
    return-void
.end method

.method public removeItemFromBundle(I)V
    .locals 7
    .param p1, "position"    # I

    .prologue
    .line 331
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    if-eqz v2, :cond_0

    .line 332
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->bundleData:Lcom/poshmark/data_model/models/PMBundle;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v0

    .line 333
    .local v0, "bundleItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ge p1, v2, :cond_0

    .line 334
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v4, "bundle"

    const-string v5, "remove_listing_from_bundle_tapped"

    const/4 v6, 0x0

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 336
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    const v2, 0x7f060224

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 337
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;

    invoke-direct {v4, p0, v0, p1}, Lcom/poshmark/ui/fragments/ViewBundleFragment$7;-><init>(Lcom/poshmark/ui/fragments/ViewBundleFragment;Ljava/util/List;I)V

    invoke-static {v2, v3, v4}, Lcom/poshmark/http/api/PMApi;->removeListingFromBundle(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 354
    .end local v0    # "bundleItems":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 131
    const-string v0, "bundle_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ViewBundleFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 126
    const v0, 0x7f060064

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ViewBundleFragment;->setTitle(Ljava/lang/String;)V

    .line 127
    return-void
.end method
