.class public Lcom/poshmark/ui/fragments/MySizePickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "MySizePickerFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;
    }
.end annotation


# instance fields
.field bIsMySizeSet:Z

.field info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

.field isG2FiltersEnabled:Z

.field mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

.field mySizeSwitchChanged:Z

.field mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

.field parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

.field setCategoryButton:Landroid/widget/RelativeLayout;

.field setMySizeButton:Landroid/widget/RelativeLayout;

.field sizeButtonListener:Landroid/view/View$OnClickListener;

.field sizeDataChanged:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 43
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 46
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->sizeDataChanged:Z

    .line 47
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeSwitchChanged:Z

    .line 49
    sget-object v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->MY_SIZE:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    .line 54
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->bIsMySizeSet:Z

    .line 55
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->isG2FiltersEnabled:Z

    .line 347
    new-instance v0, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$6;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->sizeButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method

.method private isMySizeSet()Z
    .locals 2

    .prologue
    .line 187
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v0

    .line 188
    .local v0, "summary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v0, :cond_0

    iget-object v1, v0, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 189
    const/4 v1, 0x1

    .line 191
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private setupClickHandlers()V
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setCategoryButton:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 147
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setMySizeButton:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    return-void
.end method

.method private setupSizeGrid()V
    .locals 14

    .prologue
    .line 259
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getView()Landroid/view/View;

    move-result-object v12

    const v13, 0x7f0c015d

    invoke-virtual {v12, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 260
    .local v1, "containerLayout":Landroid/widget/LinearLayout;
    const/4 v12, 0x0

    invoke-virtual {v1, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 261
    const/4 v8, 0x0

    .line 262
    .local v8, "numRows":I
    const/4 v9, 0x0

    .line 264
    .local v9, "partialRowCount":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    if-eqz v12, :cond_0

    .line 265
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    div-int/lit8 v8, v12, 0x3

    .line 266
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v12

    rem-int/lit8 v9, v12, 0x3

    .line 269
    :cond_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v8, :cond_1

    .line 270
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v12

    invoke-static {v12}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 271
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f030058

    const/4 v13, 0x0

    invoke-virtual {v3, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    .line 272
    .local v11, "v":Landroid/view/View;
    invoke-virtual {v1, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 273
    mul-int/lit8 v10, v2, 0x3

    .line 274
    .local v10, "startPos":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/MetaItem;

    .line 275
    .local v5, "item1":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x1

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/MetaItem;

    .line 276
    .local v6, "item2":Lcom/poshmark/data_model/models/MetaItem;
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x2

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/poshmark/data_model/models/MetaItem;

    .line 278
    .local v7, "item3":Lcom/poshmark/data_model/models/MetaItem;
    const v12, 0x7f0c015f

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 279
    .local v0, "button":Landroid/widget/Button;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 280
    invoke-virtual {p0, v0, v5, v10}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 282
    const v12, 0x7f0c0160

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 283
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 284
    add-int/lit8 v12, v10, 0x1

    invoke-virtual {p0, v0, v6, v12}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 287
    const v12, 0x7f0c0161

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 288
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v7}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 289
    add-int/lit8 v12, v10, 0x2

    invoke-virtual {p0, v0, v7, v12}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 269
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 293
    .end local v0    # "button":Landroid/widget/Button;
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v5    # "item1":Lcom/poshmark/data_model/models/MetaItem;
    .end local v6    # "item2":Lcom/poshmark/data_model/models/MetaItem;
    .end local v7    # "item3":Lcom/poshmark/data_model/models/MetaItem;
    .end local v10    # "startPos":I
    .end local v11    # "v":Landroid/view/View;
    :cond_1
    if-lez v9, :cond_3

    .line 294
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v12

    invoke-static {v12}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 295
    .restart local v3    # "inflater":Landroid/view/LayoutInflater;
    const v12, 0x7f030058

    const/4 v13, 0x0

    invoke-virtual {v3, v12, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    .line 296
    .restart local v11    # "v":Landroid/view/View;
    invoke-virtual {v1, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 298
    mul-int/lit8 v10, v8, 0x3

    .line 300
    .restart local v10    # "startPos":I
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    invoke-interface {v12, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    .line 301
    .local v4, "item":Lcom/poshmark/data_model/models/MetaItem;
    const v12, 0x7f0c015f

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 302
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 303
    invoke-virtual {p0, v0, v4, v10}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 306
    const/4 v12, 0x1

    if-le v9, v12, :cond_2

    .line 307
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x1

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "item":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    .line 308
    .restart local v4    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const v12, 0x7f0c0160

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 309
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 310
    add-int/lit8 v12, v10, 0x1

    invoke-virtual {p0, v0, v4, v12}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 313
    :cond_2
    const/4 v12, 0x2

    if-le v9, v12, :cond_3

    .line 314
    iget-object v12, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v12, v12, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    add-int/lit8 v13, v10, 0x2

    invoke-interface {v12, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "item":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v4, Lcom/poshmark/data_model/models/MetaItem;

    .line 315
    .restart local v4    # "item":Lcom/poshmark/data_model/models/MetaItem;
    const v12, 0x7f0c0161

    invoke-virtual {v11, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .end local v0    # "button":Landroid/widget/Button;
    check-cast v0, Landroid/widget/Button;

    .line 316
    .restart local v0    # "button":Landroid/widget/Button;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getFormattedDisplayStringBuilder()Landroid/text/SpannableStringBuilder;

    move-result-object v12

    invoke-virtual {v0, v12}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 317
    add-int/lit8 v12, v10, 0x2

    invoke-virtual {p0, v0, v4, v12}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V

    .line 320
    .end local v0    # "button":Landroid/widget/Button;
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v4    # "item":Lcom/poshmark/data_model/models/MetaItem;
    .end local v10    # "startPos":I
    .end local v11    # "v":Landroid/view/View;
    :cond_3
    return-void
.end method


# virtual methods
.method public isMetaItemInSelectedItemList(Lcom/poshmark/data_model/models/MetaItem;)Z
    .locals 5
    .param p1, "item"    # Lcom/poshmark/data_model/models/MetaItem;

    .prologue
    .line 333
    const/4 v1, 0x0

    .line 334
    .local v1, "retVal":Z
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    if-eqz v3, :cond_1

    .line 335
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 336
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 337
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 338
    .local v2, "selectedItem":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 339
    const/4 v1, 0x1

    .line 344
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/MetaItem;>;"
    .end local v2    # "selectedItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    return v1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 89
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 92
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    sget-object v2, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    if-ne v1, v2, :cond_3

    .line 93
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 94
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 95
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->isMySizeSet()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->bIsMySizeSet:Z

    .line 97
    const v1, 0x7f0c02e5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    .line 98
    const v1, 0x7f0c02e6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setMySizeButton:Landroid/widget/RelativeLayout;

    .line 99
    const v1, 0x7f0c02e8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setCategoryButton:Landroid/widget/RelativeLayout;

    .line 101
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupClickHandlers()V

    .line 103
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 104
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->bIsMySizeSet:Z

    if-eqz v1, :cond_1

    .line 105
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setMySizeButton:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 111
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-nez v1, :cond_2

    .line 112
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setCategoryButton:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 117
    :goto_1
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->bIsMySizeSet:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-boolean v1, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    if-eqz v1, :cond_0

    .line 118
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v2, 0x1

    invoke-virtual {v1, v4, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 120
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mySizeToggleButton:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f02007e

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v4, v4, v2, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 126
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    :goto_2
    return-void

    .line 107
    .restart local v0    # "v":Landroid/view/View;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setMySizeButton:Landroid/widget/RelativeLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 108
    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-boolean v3, v1, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    goto :goto_0

    .line 114
    :cond_2
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupSizeGrid()V

    goto :goto_1

    .line 124
    .end local v0    # "v":Landroid/view/View;
    :cond_3
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setupSizeGrid()V

    goto :goto_2
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 6
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 374
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 375
    if-eqz p2, :cond_0

    .line 376
    packed-switch p1, :pswitch_data_0

    .line 392
    :cond_0
    :goto_0
    return-void

    .line 378
    :pswitch_0
    const/4 v3, 0x0

    .line 379
    .local v3, "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    const-string v4, "RETURNED_RESULTS"

    invoke-virtual {p3, v4}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 380
    .local v1, "b":Landroid/os/Bundle;
    const-string v4, "DATA_SELECTED"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 381
    .local v2, "jsonString":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 382
    const-class v4, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v2, v4}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    .line 384
    .restart local v3    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    if-eqz v3, :cond_0

    .line 385
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-object v3, v4, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 386
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 387
    .local v0, "allSizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v5, v5, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->sizeFacetList:Ljava/util/List;

    invoke-static {v0, v5}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v5

    iput-object v5, v4, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    goto :goto_0

    .line 376
    nop

    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 60
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FeatureManager;->isFilterBarv2FeatureEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->isG2FiltersEnabled:Z

    .line 61
    invoke-static {}, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->values()[Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "MODE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    .line 62
    const-class v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    .line 63
    const-class v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/PMFilterableFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    .line 65
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    if-nez v0, :cond_1

    .line 66
    new-instance v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/MySizePickerInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    .line 67
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->SIZE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    .line 68
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    if-nez v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    .line 71
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    .line 72
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v0, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->getCurrentSizeSelections()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 73
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->categoryFacetList:Ljava/util/List;

    .line 74
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->SIZE_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getUnscrubbedFacetList(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Ljava/util/List;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->sizeFacetList:Ljava/util/List;

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getFilterManager()Lcom/poshmark/utils/FilterResultsManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FilterResultsManager;->isMySizeEnabled()Z

    move-result v1

    iput-boolean v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    .line 76
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->parentFragment:Lcom/poshmark/ui/fragments/PMFilterableFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;->CATEGORY_MODE:Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFilterableFragment;->getCurrentMetaItemSelection(Lcom/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES;)Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 78
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 82
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 83
    const v1, 0x7f0300c0

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 84
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 5
    .param p1, "b"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 397
    packed-switch p2, :pswitch_data_0

    .line 413
    :cond_0
    :goto_0
    return-void

    .line 399
    :pswitch_0
    const/4 v2, 0x0

    .line 400
    .local v2, "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    const-string v3, "DATA_SELECTED"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 401
    .local v1, "jsonString":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 402
    const-class v3, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v1, v3}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 405
    .restart local v2    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    if-eqz v2, :cond_0

    .line 406
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iput-object v2, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    .line 407
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/poshmark/db/DbApi;->getSizesForCategory(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 408
    .local v0, "allSizesForCategory":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v4, v4, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->sizeFacetList:Ljava/util/List;

    invoke-static {v0, v4}, Lcom/poshmark/utils/ListingsFilterUtils;->getScrubbedList(Ljava/util/List;Ljava/util/List;)Ljava/util/List;

    move-result-object v4

    iput-object v4, v3, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->allItems:Ljava/util/List;

    goto :goto_0

    .line 397
    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_0
    .end packed-switch
.end method

.method public returnData()Z
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/4 v9, -0x1

    .line 197
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 198
    .local v2, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 199
    .local v0, "b":Landroid/os/Bundle;
    iget-boolean v7, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->sizeDataChanged:Z

    if-eqz v7, :cond_2

    .line 200
    const-string v7, "SIZE_CHANGED"

    const/4 v8, 0x1

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 201
    new-instance v7, Lcom/poshmark/ui/fragments/MySizePickerFragment$4;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$4;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/MySizePickerFragment$4;->getType()Ljava/lang/reflect/Type;

    move-result-object v4

    .line 202
    .local v4, "listOfObjectType":Ljava/lang/reflect/Type;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->selectedItems:Ljava/util/List;

    invoke-static {v7, v4}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v3

    .line 203
    .local v3, "json":Ljava/lang/String;
    const-string v7, "SIZE_LIST"

    invoke-virtual {v0, v7, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    .end local v3    # "json":Ljava/lang/String;
    .end local v4    # "listOfObjectType":Ljava/lang/reflect/Type;
    :goto_0
    const-string v7, "MYSIZE_SWITCH_STATE"

    iget-object v8, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-boolean v8, v8, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->bIsMySizeEnabled:Z

    invoke-virtual {v0, v7, v8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 210
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    if-eqz v7, :cond_0

    .line 211
    iget-object v7, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->info:Lcom/poshmark/utils/meta_data/MySizePickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/MySizePickerInfo;->currentCategory:Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v7}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 212
    .restart local v3    # "json":Ljava/lang/String;
    const-string v7, "DATA_SELECTED"

    invoke-virtual {v0, v7, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    .end local v3    # "json":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 215
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_3

    .line 216
    const-string v7, "RETURNED_RESULTS"

    invoke-virtual {v2, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 217
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getTargetRequestCode()I

    move-result v6

    .line 218
    .local v6, "requestCode":I
    invoke-virtual {v1, v6, v9, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 219
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    .line 220
    .local v5, "parent":Landroid/app/Activity;
    if-eqz v5, :cond_1

    .line 221
    invoke-virtual {v5}, Landroid/app/Activity;->onBackPressed()V

    .line 228
    .end local v5    # "parent":Landroid/app/Activity;
    .end local v6    # "requestCode":I
    :cond_1
    :goto_1
    return v10

    .line 205
    .end local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_2
    const-string v7, "SIZE_CHANGED"

    invoke-virtual {v0, v7, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_0

    .line 224
    .restart local v1    # "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    :cond_3
    invoke-virtual {v2, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 225
    invoke-virtual {p0, v9, v2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    goto :goto_1
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 250
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->mode:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;->SEARCH_FILTER:Lcom/poshmark/ui/fragments/MySizePickerFragment$MODE;

    if-ne v0, v1, :cond_0

    .line 251
    const-string v0, "listing_select_size_filter_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 256
    :goto_0
    return-void

    .line 254
    :cond_0
    const-string v0, "multi_selector_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 233
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 235
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->isG2FiltersEnabled:Z

    if-eqz v1, :cond_0

    .line 236
    const v1, 0x7f06004a

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 240
    .local v0, "buttonText":Ljava/lang/String;
    :goto_0
    new-instance v1, Lcom/poshmark/ui/fragments/MySizePickerFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment$5;-><init>(Lcom/poshmark/ui/fragments/MySizePickerFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setNextActionButton(Ljava/lang/String;Landroid/view/View$OnClickListener;)Landroid/widget/Button;

    .line 246
    const-string v1, "Select Size"

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->setTitle(Ljava/lang/String;)V

    .line 247
    return-void

    .line 238
    .end local v0    # "buttonText":Ljava/lang/String;
    :cond_0
    const v1, 0x7f0600bf

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "buttonText":Ljava/lang/String;
    goto :goto_0
.end method

.method public setupButton(Landroid/widget/Button;Lcom/poshmark/data_model/models/MetaItem;I)V
    .locals 2
    .param p1, "button"    # Landroid/widget/Button;
    .param p2, "item"    # Lcom/poshmark/data_model/models/MetaItem;
    .param p3, "index"    # I

    .prologue
    .line 323
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 324
    invoke-virtual {p0, p2}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->isMetaItemInSelectedItemList(Lcom/poshmark/data_model/models/MetaItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 325
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020015

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 326
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/MySizePickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090040

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setTextColor(I)V

    .line 328
    :cond_0
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 329
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MySizePickerFragment;->sizeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 330
    return-void
.end method
