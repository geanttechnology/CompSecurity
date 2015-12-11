.class public Lcom/amazon/mShop/details/VariationFilters;
.super Landroid/widget/LinearLayout;
.source "VariationFilters.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;,
        Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mCurrentDimension:I

.field private mCurrentSelections:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mFetched:Z

.field private mFilterButtons:[Landroid/widget/Button;

.field private mOptionsAdapter:Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;

.field private mPriceRow:Landroid/widget/LinearLayout;

.field private mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;

.field private mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

.field private mVariations:Lcom/amazon/mShop/control/item/Variations;

.field private mVariationsController:Lcom/amazon/mShop/details/VariationsController;

.field private onDimensionButtonClicked:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 78
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mFetched:Z

    .line 179
    new-instance v0, Lcom/amazon/mShop/details/VariationFilters$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/details/VariationFilters$1;-><init>(Lcom/amazon/mShop/details/VariationFilters;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->onDimensionButtonClicked:Landroid/view/View$OnClickListener;

    .line 54
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/details/VariationFilters;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/details/VariationFilters;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I

    return v0
.end method

.method static synthetic access$1000(Lcom/amazon/mShop/details/VariationFilters;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->notifySelectionIncomplete()V

    return-void
.end method

.method static synthetic access$1100(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/amazon/mShop/details/VariationFilters;Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;
    .param p1, "x1"    # Lcom/amazon/mShop/AmazonAlertDialog;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/details/VariationFilters;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/details/VariationsController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/details/VariationFilters;II)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;
    .param p1, "x1"    # I
    .param p2, "x2"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/VariationFilters;->selectOption(II)V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/details/VariationFilters;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->isAllSelected()Z

    move-result v0

    return v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/VariationsSelectionAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/mShop/details/VariationFilters;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->loadSelectedChild()V

    return-void
.end method

.method static synthetic access$800(Lcom/amazon/mShop/details/VariationFilters;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->notifySelectionComplete()V

    return-void
.end method

.method static synthetic access$900(Lcom/amazon/mShop/details/VariationFilters;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/details/VariationFilters;

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->updateUnselectedLabel()V

    return-void
.end method

.method private isAllSelected()Z
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 200
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    if-nez v1, :cond_0

    move v1, v2

    .line 207
    :goto_0
    return v1

    .line 202
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 203
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v3, -0x1

    if-ne v1, v3, :cond_1

    move v1, v2

    .line 204
    goto :goto_0

    .line 202
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 207
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private loadSelectedChild()V
    .locals 3

    .prologue
    .line 221
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/details/VariationsController;->getSelectedChild(Ljava/util/List;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    .line 222
    .local v0, "child":Lcom/amazon/mShop/control/item/Variations$Child;
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    invoke-interface {v1, v0}, Lcom/amazon/mShop/control/VariationsSelectionAdapter;->setSelectedVariationChild(Lcom/amazon/mShop/control/item/Variations$Child;)V

    .line 223
    return-void
.end method

.method private notifySelectionComplete()V
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    if-eqz v0, :cond_0

    .line 428
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;->onSelectionComplete()V

    .line 430
    :cond_0
    return-void
.end method

.method private notifySelectionIncomplete()V
    .locals 1

    .prologue
    .line 421
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    if-eqz v0, :cond_0

    .line 422
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    invoke-interface {v0}, Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;->onSelectionIncomplete()V

    .line 424
    :cond_0
    return-void
.end method

.method private selectOption(II)V
    .locals 6
    .param p1, "dimensionIndex"    # I
    .param p2, "optionIndex"    # I

    .prologue
    const/4 v5, 0x0

    .line 226
    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v3

    array-length v3, v3

    if-lt p1, v3, :cond_1

    .line 239
    :cond_0
    :goto_0
    return-void

    .line 229
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v3

    aget-object v0, v3, p1

    .line 231
    .local v0, "dimension":Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getValues()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge p2, v3, :cond_0

    .line 233
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getDisplayLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ": "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getValues()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 234
    .local v2, "text":Ljava/lang/String;
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, v2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 235
    .local v1, "spannable":Landroid/text/SpannableString;
    new-instance v3, Landroid/text/style/StyleSpan;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getDisplayLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v1, v3, v5, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 236
    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mFilterButtons:[Landroid/widget/Button;

    aget-object v3, v3, p1

    sget-object v4, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setTypeface(Landroid/graphics/Typeface;)V

    .line 237
    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mFilterButtons:[Landroid/widget/Button;

    aget-object v3, v3, p1

    invoke-virtual {v3, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 238
    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    invoke-virtual {v3, p1, p2}, Lcom/amazon/mShop/details/VariationsController;->selectAndUpdate(II)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    goto :goto_0
.end method

.method private setFetched(Z)V
    .locals 0
    .param p1, "fetched"    # Z

    .prologue
    .line 84
    iput-boolean p1, p0, Lcom/amazon/mShop/details/VariationFilters;->mFetched:Z

    .line 85
    return-void
.end method

.method private updateUnselectedLabel()V
    .locals 5

    .prologue
    .line 211
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 212
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_0

    .line 213
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mFilterButtons:[Landroid/widget/Button;

    aget-object v2, v2, v0

    sget-object v3, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setTypeface(Landroid/graphics/Typeface;)V

    .line 214
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v3

    aget-object v3, v3, v0

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getDisplayLabel()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/details/VariationFilters;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->please_select:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 215
    .local v1, "label":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mFilterButtons:[Landroid/widget/Button;

    aget-object v2, v2, v0

    invoke-virtual {v2, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 211
    .end local v1    # "label":Ljava/lang/String;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 218
    :cond_1
    return-void
.end method


# virtual methods
.method public getDimensionCount()I
    .locals 2

    .prologue
    .line 69
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    if-eqz v1, :cond_0

    .line 70
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v0

    .line 71
    .local v0, "dims":[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    array-length v1, v0

    .line 73
    .end local v0    # "dims":[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 59
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    invoke-virtual {v0}, Lcom/amazon/mShop/details/VariationsController;->cancelFetchInfos()V

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_1

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 66
    :cond_1
    return-void
.end method

.method public setSubscriber(Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    .prologue
    .line 433
    iput-object p1, p0, Lcom/amazon/mShop/details/VariationFilters;->mSubscriber:Lcom/amazon/mShop/details/VariationFilters$VariationFiltersSubscriber;

    .line 434
    return-void
.end method

.method public showDimensionList(Ljava/lang/Integer;)V
    .locals 9
    .param p1, "dimension"    # Ljava/lang/Integer;

    .prologue
    .line 188
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I

    .line 189
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;

    iget v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/details/VariationsController;->checkAvailabilitiesForDimension(I)Ljava/util/List;

    move-result-object v6

    .line 190
    .local v6, "availabilities":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Boolean;>;"
    new-instance v0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/VariationFilters;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, v6}, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;-><init>(Lcom/amazon/mShop/details/VariationFilters;Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mOptionsAdapter:Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;

    .line 192
    new-instance v7, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v7, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 193
    .local v7, "dialogBuilder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-virtual {v7}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 194
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v2

    iget v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I

    aget-object v2, v2, v3

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getDisplayLabel()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters;->mOptionsAdapter:Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;

    iget-object v4, p0, Lcom/amazon/mShop/details/VariationFilters;->mOptionsAdapter:Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;

    iget-object v5, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;

    iget v8, p0, Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I

    invoke-interface {v5, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->customizeAlertDialog(Landroid/content/Context;Lcom/amazon/mShop/AmazonAlertDialog;Ljava/lang/String;Landroid/widget/ListAdapter;Landroid/widget/AdapterView$OnItemClickListener;I)V

    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 197
    return-void
.end method

.method public updatePriceRow()V
    .locals 3

    .prologue
    .line 99
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    instance-of v1, v1, Lcom/amazon/mShop/control/item/ProductController;

    if-eqz v1, :cond_1

    .line 100
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mPriceRow:Landroid/widget/LinearLayout;

    if-nez v1, :cond_0

    .line 101
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->product_price_row_stub:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/details/VariationFilters;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewStub;

    .line 102
    .local v0, "stub":Landroid/view/ViewStub;
    invoke-virtual {v0}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mPriceRow:Landroid/widget/LinearLayout;

    .line 104
    .end local v0    # "stub":Landroid/view/ViewStub;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/details/VariationFilters;->isAllSelected()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 105
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    check-cast v1, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters;->mPriceRow:Landroid/widget/LinearLayout;

    invoke-static {v1, v2}, Lcom/amazon/mShop/details/ItemViewUtils;->updateActualPriceRow(Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/LinearLayout;)V

    .line 111
    :cond_1
    :goto_0
    return-void

    .line 108
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/details/VariationFilters;->mPriceRow:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method
