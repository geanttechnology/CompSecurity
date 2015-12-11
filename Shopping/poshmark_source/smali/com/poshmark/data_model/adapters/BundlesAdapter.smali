.class public Lcom/poshmark/data_model/adapters/BundlesAdapter;
.super Landroid/widget/CursorAdapter;
.source "BundlesAdapter.java"


# instance fields
.field ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 32
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 33
    iput-object p2, p0, Lcom/poshmark/data_model/adapters/BundlesAdapter;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 34
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 12
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 61
    move-object v6, p3

    check-cast v6, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 62
    .local v6, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v9, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v6, v9}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 63
    .local v3, "idCol":I
    invoke-virtual {v6, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PMBundle;

    .line 64
    .local v1, "bundle":Lcom/poshmark/data_model/models/PMBundle;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;

    .line 66
    .local v8, "viewHolder":Lcom/poshmark/utils/view_holders/BundleViewHolder;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v4

    .line 67
    .local v4, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMBundle;->getSellerAvataar()Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "avataarURI":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_0

    .line 69
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMBundle;->getSellerAvataar()Ljava/lang/String;

    move-result-object v9

    iget-object v10, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->avataar:Landroid/widget/ImageView;

    invoke-virtual {v4, v9, v10}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 75
    :goto_0
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->userName:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMBundle;->getSellerUsername()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMBundle;->getList()Ljava/util/List;

    move-result-object v7

    .line 78
    .local v7, "posts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    const/4 v2, 0x0

    .line 79
    .local v2, "i":I
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    if-le v9, v2, :cond_1

    .line 80
    invoke-interface {v7, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/ListingSummary;

    .line 81
    .local v5, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    .line 82
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSummary;->getMediumCovershot()Ljava/lang/String;

    move-result-object v9

    iget-object v10, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v4, v9, v10}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 83
    add-int/lit8 v2, v2, 0x1

    .line 88
    .end local v5    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :goto_1
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    if-le v9, v2, :cond_2

    .line 89
    invoke-interface {v7, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/ListingSummary;

    .line 90
    .restart local v5    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    .line 91
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSummary;->getMediumCovershot()Ljava/lang/String;

    move-result-object v9

    iget-object v10, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v4, v9, v10}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 92
    add-int/lit8 v2, v2, 0x1

    .line 97
    .end local v5    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :goto_2
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    if-le v9, v2, :cond_3

    .line 98
    invoke-interface {v7, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/ListingSummary;

    .line 99
    .restart local v5    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    .line 100
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSummary;->getMediumCovershot()Ljava/lang/String;

    move-result-object v9

    iget-object v10, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v4, v9, v10}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 104
    .end local v5    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :goto_3
    return-void

    .line 72
    .end local v2    # "i":I
    .end local v7    # "posts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_0
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->avataar:Landroid/widget/ImageView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f0200d4

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 85
    .restart local v2    # "i":I
    .restart local v7    # "posts":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :cond_1
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    goto :goto_1

    .line 94
    :cond_2
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    goto :goto_2

    .line 102
    :cond_3
    iget-object v9, v8, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    goto :goto_3
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v4, 0x0

    .line 38
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 39
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f03000d

    invoke-virtual {v0, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 40
    .local v1, "v":Landroid/view/View;
    new-instance v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;

    invoke-direct {v2}, Lcom/poshmark/utils/view_holders/BundleViewHolder;-><init>()V

    .line 41
    .local v2, "viewHolder":Lcom/poshmark/utils/view_holders/BundleViewHolder;
    const v3, 0x7f0c0057

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->avataar:Landroid/widget/ImageView;

    .line 42
    const v3, 0x7f0c0058

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->userName:Lcom/poshmark/ui/customviews/PMTextView;

    .line 43
    const v3, 0x7f0c0059

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 44
    const v3, 0x7f0c005a

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 45
    const v3, 0x7f0c005b

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMListingImageView;

    iput-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 48
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setFocusable(Z)V

    .line 49
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image1:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setClickable(Z)V

    .line 50
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setFocusable(Z)V

    .line 51
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image2:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setClickable(Z)V

    .line 52
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setFocusable(Z)V

    .line 53
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/BundleViewHolder;->image3:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setClickable(Z)V

    .line 55
    invoke-virtual {v1, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 56
    return-object v1
.end method
