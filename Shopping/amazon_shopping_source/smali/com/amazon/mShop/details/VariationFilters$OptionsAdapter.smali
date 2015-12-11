.class Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;
.super Landroid/widget/BaseAdapter;
.source "VariationFilters.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/VariationFilters;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OptionsAdapter"
.end annotation


# instance fields
.field private final mAvailabilities:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field private final mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

.field private final mValues:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/amazon/mShop/details/VariationFilters;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/details/VariationFilters;Landroid/content/Context;Ljava/util/List;)V
    .locals 2
    .param p2, "c"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 248
    .local p3, "availabilities":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Boolean;>;"
    iput-object p1, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 249
    iput-object p2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mContext:Landroid/content/Context;

    .line 250
    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {p1}, Lcom/amazon/mShop/details/VariationFilters;->access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v0

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {p1}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v1

    aget-object v0, v0, v1

    iput-object v0, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .line 251
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getValues()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mValues:Ljava/util/List;

    .line 252
    iput-object p3, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mAvailabilities:Ljava/util/List;

    .line 253
    return-void
.end method

.method private setPriceAndAvailableMessage(ILandroid/view/View;)V
    .locals 13
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;

    .prologue
    .line 312
    invoke-virtual {p2}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 313
    .local v6, "res":Landroid/content/res/Resources;
    sget v10, Lcom/amazon/mShop/android/lib/R$id;->item_price:I

    invoke-virtual {p2, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 314
    .local v5, "priceView":Landroid/widget/TextView;
    sget v10, Lcom/amazon/mShop/android/lib/R$id;->item_availability:I

    invoke-virtual {p2, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 315
    .local v1, "availabilityView":Landroid/widget/TextView;
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mAvailabilities:Ljava/util/List;

    invoke-interface {v10, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Boolean;

    invoke-virtual {v10}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 316
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$300(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/details/VariationsController;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {v11}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v11

    invoke-virtual {v10, v11, p1}, Lcom/amazon/mShop/details/VariationsController;->getPrice(II)Ljava/lang/String;

    move-result-object v4

    .line 317
    .local v4, "price":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_0

    .line 318
    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 319
    const/4 v10, 0x0

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 324
    :goto_0
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$300(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/details/VariationsController;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {v11}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v11

    invoke-virtual {v10, v11, p1}, Lcom/amazon/mShop/details/VariationsController;->getAvailabeMessage(II)Ljava/lang/String;

    move-result-object v0

    .line 325
    .local v0, "availability":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_1

    .line 326
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 327
    sget v10, Lcom/amazon/mShop/android/lib/R$color;->subtitle_text_color:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    .line 328
    .local v2, "color":I
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 329
    const/4 v10, 0x0

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 359
    .end local v0    # "availability":Ljava/lang/String;
    .end local v2    # "color":I
    .end local v4    # "price":Ljava/lang/String;
    :goto_1
    return-void

    .line 322
    .restart local v4    # "price":Ljava/lang/String;
    :cond_0
    const/16 v10, 0x8

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 332
    .restart local v0    # "availability":Ljava/lang/String;
    :cond_1
    const/16 v10, 0x8

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 339
    .end local v0    # "availability":Ljava/lang/String;
    .end local v4    # "price":Ljava/lang/String;
    :cond_2
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v10

    array-length v10, v10

    const/4 v11, 0x2

    if-ne v10, v11, :cond_5

    .line 340
    const/4 v9, 0x0

    .line 341
    .local v9, "theOtherDimension":I
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v10

    if-ne v9, v10, :cond_3

    .line 342
    const/4 v9, 0x1

    .line 344
    :cond_3
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/Variations;->getDimensionLabels()[Ljava/lang/String;

    move-result-object v10

    aget-object v3, v10, v9

    .line 345
    .local v3, "label":Ljava/lang/String;
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$200(Lcom/amazon/mShop/details/VariationFilters;)Ljava/util/List;

    move-result-object v10

    invoke-interface {v10, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/Integer;

    invoke-virtual {v10}, Ljava/lang/Integer;->intValue()I

    move-result v8

    .line 346
    .local v8, "selectionIndexForTheOtherDimension":I
    if-ltz v8, :cond_4

    .line 347
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v10

    aget-object v10, v10, v9

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getValues()Ljava/util/List;

    move-result-object v10

    invoke-interface {v10, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 348
    .local v7, "selection":Ljava/lang/String;
    sget v10, Lcom/amazon/mShop/android/lib/R$string;->variations_not_available_in_dimen_x_selection_y:I

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v3, v11, v12

    const/4 v12, 0x1

    aput-object v7, v11, v12

    invoke-virtual {v6, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 354
    .end local v3    # "label":Ljava/lang/String;
    .end local v7    # "selection":Ljava/lang/String;
    .end local v8    # "selectionIndexForTheOtherDimension":I
    .end local v9    # "theOtherDimension":I
    :cond_4
    :goto_2
    sget v10, Lcom/amazon/mShop/android/lib/R$color;->gray_text:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    .line 355
    .restart local v2    # "color":I
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 356
    const/4 v10, 0x0

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 357
    const/16 v10, 0x8

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 351
    .end local v2    # "color":I
    :cond_5
    iget-object v10, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {v10}, Lcom/amazon/mShop/details/VariationFilters;->access$000(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/item/Variations;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/Variations;->getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v10

    array-length v10, v10

    const/4 v11, 0x2

    if-le v10, v11, :cond_4

    .line 352
    sget v10, Lcom/amazon/mShop/android/lib/R$string;->variations_not_available_with_selected_options:I

    invoke-virtual {v6, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 378
    const/4 v0, 0x1

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mValues:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 262
    iget-object v0, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mValues:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 267
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 363
    const/4 v0, 0x0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 278
    if-nez p2, :cond_0

    .line 279
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mContext:Landroid/content/Context;

    const-string/jumbo v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/LayoutInflater;

    .line 280
    .local v3, "inflater":Landroid/view/LayoutInflater;
    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->variation_item:I

    const/4 v8, 0x0

    invoke-virtual {v3, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 283
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    :cond_0
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonImageView;

    .line 284
    .local v2, "imageView":Lcom/amazon/mShop/AmazonImageView;
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getSwatchUrls()Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_1

    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getSwatchUrls()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_1

    .line 285
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mDimension:Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getSwatchUrls()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 286
    .local v1, "imageUrl":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    invoke-virtual {v7}, Lcom/amazon/mShop/details/VariationFilters;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$dimen;->variation_item_image_dimension:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 287
    .local v4, "maxImageDimen":I
    invoke-virtual {v2, v1, v4}, Lcom/amazon/mShop/AmazonImageView;->fetchImage(Ljava/lang/String;I)V

    .line 293
    .end local v1    # "imageUrl":Ljava/lang/String;
    .end local v4    # "maxImageDimen":I
    :goto_0
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->mValues:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 294
    .local v5, "title":Ljava/lang/String;
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->item_title:I

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 295
    .local v6, "titleView":Landroid/widget/TextView;
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    sget v7, Lcom/amazon/mShop/android/lib/R$id;->item_checkmark:I

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 298
    .local v0, "checkmark":Landroid/widget/ImageView;
    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;
    invoke-static {v7}, Lcom/amazon/mShop/details/VariationFilters;->access$200(Lcom/amazon/mShop/details/VariationFilters;)Ljava/util/List;

    move-result-object v7

    if-eqz v7, :cond_2

    iget-object v7, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;
    invoke-static {v7}, Lcom/amazon/mShop/details/VariationFilters;->access$200(Lcom/amazon/mShop/details/VariationFilters;)Ljava/util/List;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {v8}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v8

    invoke-interface {v7, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    if-ne v7, p1, :cond_2

    .line 299
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 306
    :goto_1
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->setPriceAndAvailableMessage(ILandroid/view/View;)V

    .line 308
    return-object p2

    .line 290
    .end local v0    # "checkmark":Landroid/widget/ImageView;
    .end local v5    # "title":Ljava/lang/String;
    .end local v6    # "titleView":Landroid/widget/TextView;
    :cond_1
    const/16 v7, 0x8

    invoke-virtual {v2, v7}, Lcom/amazon/mShop/AmazonImageView;->setVisibility(I)V

    goto :goto_0

    .line 302
    .restart local v0    # "checkmark":Landroid/widget/ImageView;
    .restart local v5    # "title":Ljava/lang/String;
    .restart local v6    # "titleView":Landroid/widget/TextView;
    :cond_2
    const/4 v7, 0x4

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 368
    const/4 v0, 0x1

    return v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 272
    const/4 v0, 0x0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 373
    const/4 v0, 0x0

    return v0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 383
    const/4 v0, 0x1

    return v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 388
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentDimension:I
    invoke-static {v3}, Lcom/amazon/mShop/details/VariationFilters;->access$100(Lcom/amazon/mShop/details/VariationFilters;)I

    move-result v3

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->selectOption(II)V
    invoke-static {v2, v3, p3}, Lcom/amazon/mShop/details/VariationFilters;->access$400(Lcom/amazon/mShop/details/VariationFilters;II)V

    .line 390
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->isAllSelected()Z
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$500(Lcom/amazon/mShop/details/VariationFilters;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 391
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mVariationsController:Lcom/amazon/mShop/details/VariationsController;
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$300(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/details/VariationsController;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mCurrentSelections:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/mShop/details/VariationFilters;->access$200(Lcom/amazon/mShop/details/VariationFilters;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/details/VariationsController;->getSelectedChild(Ljava/util/List;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    .line 392
    .local v0, "newSelection":Lcom/amazon/mShop/control/item/Variations$Child;
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$600(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/control/VariationsSelectionAdapter;->getSelectedVariationChild()Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v1

    .line 393
    .local v1, "oldSelection":Lcom/amazon/mShop/control/item/Variations$Child;
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->loadSelectedChild()V
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$700(Lcom/amazon/mShop/details/VariationFilters;)V

    .line 394
    if-eq v0, v1, :cond_0

    .line 395
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->notifySelectionComplete()V
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$800(Lcom/amazon/mShop/details/VariationFilters;)V

    .line 405
    .end local v0    # "newSelection":Lcom/amazon/mShop/control/item/Variations$Child;
    .end local v1    # "oldSelection":Lcom/amazon/mShop/control/item/Variations$Child;
    :cond_0
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$1100(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 406
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$1100(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 407
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/mShop/details/VariationFilters;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-static {v2, v3}, Lcom/amazon/mShop/details/VariationFilters;->access$1102(Lcom/amazon/mShop/details/VariationFilters;Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;

    .line 409
    :cond_1
    return-void

    .line 399
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # getter for: Lcom/amazon/mShop/details/VariationFilters;->mSelectionAdapter:Lcom/amazon/mShop/control/VariationsSelectionAdapter;
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$600(Lcom/amazon/mShop/details/VariationFilters;)Lcom/amazon/mShop/control/VariationsSelectionAdapter;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/control/VariationsSelectionAdapter;->clearSelectedChild()V

    .line 400
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->updateUnselectedLabel()V
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$900(Lcom/amazon/mShop/details/VariationFilters;)V

    .line 401
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    invoke-virtual {v2}, Lcom/amazon/mShop/details/VariationFilters;->updatePriceRow()V

    .line 402
    iget-object v2, p0, Lcom/amazon/mShop/details/VariationFilters$OptionsAdapter;->this$0:Lcom/amazon/mShop/details/VariationFilters;

    # invokes: Lcom/amazon/mShop/details/VariationFilters;->notifySelectionIncomplete()V
    invoke-static {v2}, Lcom/amazon/mShop/details/VariationFilters;->access$1000(Lcom/amazon/mShop/details/VariationFilters;)V

    goto :goto_0
.end method
