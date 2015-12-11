.class public Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;
.super Landroid/widget/CursorAdapter;
.source "ListingSummaryAdapter.java"


# instance fields
.field imageList:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/poshmark/ui/customviews/PMImageView;",
            ">;"
        }
    .end annotation
.end field

.field private inflater:Landroid/view/LayoutInflater;

.field ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field textFormatter:Lcom/poshmark/utils/TextFormatter;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 45
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 39
    new-instance v0, Lcom/poshmark/utils/TextFormatter;

    invoke-direct {v0}, Lcom/poshmark/utils/TextFormatter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    .line 41
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->imageList:Ljava/util/Set;

    .line 46
    iput-object p2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 47
    return-void
.end method

.method private loadCovershot(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/ui/customviews/PMCovershotImageView;Lcom/poshmark/ui/customviews/ListingStatusView;)V
    .locals 4
    .param p1, "item"    # Lcom/poshmark/data_model/models/ListingSummary;
    .param p2, "covershot"    # Lcom/poshmark/ui/customviews/PMCovershotImageView;
    .param p3, "statusView"    # Lcom/poshmark/ui/customviews/ListingStatusView;

    .prologue
    .line 105
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v3}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->setListingId(Ljava/lang/String;)V

    .line 106
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getSmallCovershot()Ljava/lang/String;

    move-result-object v2

    .line 107
    .local v2, "smallImageUrl":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getMediumCovershot()Ljava/lang/String;

    move-result-object v1

    .line 108
    .local v1, "mediumImageUrl":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->getImageURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {p2}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->getImageURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 109
    if-eqz v2, :cond_2

    .end local v2    # "smallImageUrl":Ljava/lang/String;
    :goto_0
    invoke-virtual {p2, v2}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->loadImage(Ljava/lang/String;)V

    .line 112
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v0

    .line 113
    .local v0, "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    sget-object v3, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-eq v0, v3, :cond_1

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v0, v3, :cond_3

    .line 114
    :cond_1
    const/4 v3, 0x0

    invoke-virtual {p3, v3}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    .line 115
    invoke-virtual {p3, v0}, Lcom/poshmark/ui/customviews/ListingStatusView;->setListingStatus(Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;)V

    .line 116
    invoke-virtual {p3}, Lcom/poshmark/ui/customviews/ListingStatusView;->bringToFront()V

    .line 121
    :goto_1
    return-void

    .end local v0    # "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .restart local v2    # "smallImageUrl":Ljava/lang/String;
    :cond_2
    move-object v2, v1

    .line 109
    goto :goto_0

    .line 119
    .end local v2    # "smallImageUrl":Ljava/lang/String;
    .restart local v0    # "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    :cond_3
    const/16 v3, 0x8

    invoke-virtual {p3, v3}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 52
    move-object v3, p3

    check-cast v3, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 53
    .local v3, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v5, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v3, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 56
    .local v0, "idCol":I
    invoke-virtual {v3, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/utils/ItemPair;

    .line 58
    .local v2, "listingPair":Lcom/poshmark/utils/ItemPair;, "Lcom/poshmark/utils/ItemPair<Lcom/poshmark/data_model/models/ListingSummary;>;"
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;

    .line 61
    .local v4, "viewHolder":Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;
    invoke-virtual {v2}, Lcom/poshmark/utils/ItemPair;->getLeftItem()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 62
    .local v1, "item":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v6, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    if-eqz v1, :cond_2

    const/4 v5, 0x0

    :goto_0
    invoke-virtual {v6, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 63
    if-eqz v1, :cond_0

    .line 64
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotLeft:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iget-object v6, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->statusViewLeft:Lcom/poshmark/ui/customviews/ListingStatusView;

    invoke-direct {p0, v1, v5, v6}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->loadCovershot(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/ui/customviews/PMCovershotImageView;Lcom/poshmark/ui/customviews/ListingStatusView;)V

    .line 65
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->creatorTextViewLeft:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const v7, 0x7f06006c

    invoke-virtual {p2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->isNWT()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 67
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 68
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0601d6

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 75
    :goto_1
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->titleViewLeft:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->priceViewLeft:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewLeft:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->sizeViewLeft:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const v7, 0x7f060281

    invoke-virtual {p2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    :cond_0
    invoke-virtual {v2}, Lcom/poshmark/utils/ItemPair;->getRightItem()Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "item":Lcom/poshmark/data_model/models/ListingSummary;
    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 83
    .restart local v1    # "item":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v6, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    if-eqz v1, :cond_5

    const/4 v5, 0x0

    :goto_2
    invoke-virtual {v6, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 84
    if-eqz v1, :cond_1

    .line 85
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotRight:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iget-object v6, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->statusViewRight:Lcom/poshmark/ui/customviews/ListingStatusView;

    invoke-direct {p0, v1, v5, v6}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->loadCovershot(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/ui/customviews/PMCovershotImageView;Lcom/poshmark/ui/customviews/ListingStatusView;)V

    .line 86
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->creatorTextViewRight:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const v7, 0x7f06006c

    invoke-virtual {p2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->isNWT()Z

    move-result v5

    if-eqz v5, :cond_6

    .line 88
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 89
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0601d6

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 96
    :goto_3
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->titleViewRight:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->priceViewRight:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewRight:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v7

    invoke-static {v7}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 99
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->sizeViewRight:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const v7, 0x7f060281

    invoke-virtual {p2, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    :cond_1
    return-void

    .line 62
    :cond_2
    const/4 v5, 0x4

    goto/16 :goto_0

    .line 69
    :cond_3
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->isRetail()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 70
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 71
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f06022c

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 73
    :cond_4
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 83
    :cond_5
    const/4 v5, 0x4

    goto/16 :goto_2

    .line 90
    :cond_6
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->isRetail()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 91
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 92
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f06022c

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 94
    :cond_7
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto/16 :goto_3
.end method

.method public clearImageList()V
    .locals 3

    .prologue
    .line 163
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->imageList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 165
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/ui/customviews/PMImageView;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 166
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMImageView;

    .line 167
    .local v0, "img":Lcom/poshmark/ui/customviews/PMImageView;
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMImageView;->releaseInternalBitmap()V

    .line 168
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 170
    .end local v0    # "img":Lcom/poshmark/ui/customviews/PMImageView;
    :cond_0
    return-void
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const v9, 0x7f0c00b7

    const v8, 0x7f0c0081

    const v7, 0x7f0c0080

    const v6, 0x7f0c007f

    const v5, 0x7f0c007d

    .line 126
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 127
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f030079

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 128
    .local v0, "v":Landroid/view/View;
    new-instance v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;-><init>()V

    .line 130
    .local v1, "viewHolder":Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;
    const v2, 0x7f0c01d5

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    .line 132
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c01d7

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotLeft:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 133
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0127

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/ListingStatusView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->statusViewLeft:Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 134
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c01d8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->creatorTextViewLeft:Landroid/widget/TextView;

    .line 135
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->titleViewLeft:Landroid/widget/TextView;

    .line 136
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewLeft:Lcom/poshmark/ui/customviews/PMTextView;

    .line 137
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->priceViewLeft:Landroid/widget/TextView;

    .line 138
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewLeft:Landroid/widget/TextView;

    .line 139
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewLeft:Landroid/widget/TextView;

    iget-object v3, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewLeft:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v3

    or-int/lit8 v3, v3, 0x10

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 140
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->leftLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->sizeViewLeft:Landroid/widget/TextView;

    .line 142
    const v2, 0x7f0c01d6

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    .line 144
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c01d7

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotRight:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 145
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0127

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/ListingStatusView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->statusViewRight:Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 146
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c01d8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->creatorTextViewRight:Landroid/widget/TextView;

    .line 147
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v9}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->titleViewRight:Landroid/widget/TextView;

    .line 148
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->nwtViewRight:Lcom/poshmark/ui/customviews/PMTextView;

    .line 149
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->priceViewRight:Landroid/widget/TextView;

    .line 150
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewRight:Landroid/widget/TextView;

    .line 151
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewRight:Landroid/widget/TextView;

    iget-object v3, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->originalPriceViewRight:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v3

    or-int/lit8 v3, v3, 0x10

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 152
    iget-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->rightLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->sizeViewRight:Landroid/widget/TextView;

    .line 155
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->imageList:Ljava/util/Set;

    iget-object v3, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotLeft:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 156
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->imageList:Ljava/util/Set;

    iget-object v3, v1, Lcom/poshmark/utils/view_holders/ListingSummaryViewHolder;->covershotRight:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    invoke-interface {v2, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 158
    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 159
    return-object v0
.end method
