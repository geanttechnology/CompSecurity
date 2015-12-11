.class public Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;
.super Landroid/widget/ArrayAdapter;
.source "PinterestBoardListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/poshmark/utils/meta_data/PinterestBoard;",
        ">;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;

.field data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

.field defaultColor:I

.field defaultColorSet:Z

.field layoutResourceId:I


# direct methods
.method public constructor <init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "layoutResourceId"    # I
    .param p3, "data"    # Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    .prologue
    .line 30
    invoke-virtual {p3}, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->getAllboards()Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 27
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->defaultColorSet:Z

    .line 31
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    .line 32
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->context:Landroid/content/Context;

    .line 33
    iput p2, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->layoutResourceId:I

    .line 34
    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    const/4 v9, 0x0

    .line 38
    invoke-virtual {p0, p1}, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 39
    .local v0, "boardItem":Lcom/poshmark/utils/meta_data/PinterestBoard;
    move-object v4, p2

    .line 40
    .local v4, "row":Landroid/view/View;
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->context:Landroid/content/Context;

    check-cast v7, Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    .line 41
    .local v2, "inflater":Landroid/view/LayoutInflater;
    if-nez v4, :cond_0

    .line 42
    iget v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->layoutResourceId:I

    invoke-virtual {v2, v7, p3, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 44
    :cond_0
    const v7, 0x7f0c025d

    invoke-virtual {v4, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 45
    .local v5, "textView":Landroid/widget/TextView;
    const v7, 0x7f0c0097

    invoke-virtual {v4, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 46
    .local v1, "checkMark":Landroid/widget/ImageView;
    const v7, 0x7f0c025c

    invoke-virtual {v4, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 48
    .local v6, "thumbNail":Landroid/widget/ImageView;
    iget-boolean v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->defaultColorSet:Z

    if-nez v7, :cond_1

    .line 49
    iput-boolean v11, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->defaultColorSet:Z

    .line 50
    invoke-virtual {v5}, Landroid/widget/TextView;->getTextColors()Landroid/content/res/ColorStateList;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/res/ColorStateList;->getDefaultColor()I

    move-result v7

    iput v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->defaultColor:I

    .line 54
    :cond_1
    invoke-virtual {v5, v9, v9, v9, v9}, Landroid/widget/TextView;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 55
    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getDisplay()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 56
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v7, v7, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-virtual {v7}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 57
    invoke-virtual {v5, v9, v11}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 58
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f09003c

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 59
    invoke-virtual {v1, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 65
    :goto_0
    new-instance v7, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v7}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    const v8, 0x7f020138

    invoke-virtual {v7, v8}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageForEmptyUri(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v7

    invoke-virtual {v7}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v3

    .line 67
    .local v3, "options":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v7

    invoke-virtual {v0}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getImage_url()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8, v6, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V

    .line 69
    invoke-virtual {v4, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 71
    return-object v4

    .line 61
    .end local v3    # "options":Lcom/nostra13/universalimageloader/core/DisplayImageOptions;
    :cond_2
    const/16 v7, 0x8

    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 62
    invoke-virtual {v5, v9, v10}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 63
    iget v7, p0, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;->defaultColor:I

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method
