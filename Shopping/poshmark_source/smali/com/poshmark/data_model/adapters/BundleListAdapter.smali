.class public Lcom/poshmark/data_model/adapters/BundleListAdapter;
.super Landroid/widget/CursorAdapter;
.source "BundleListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;
    }
.end annotation


# instance fields
.field public covershot:Lcom/poshmark/ui/customviews/PMClickableImageView;

.field public mode:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

.field ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field public priceLayout:Lcom/poshmark/ui/customviews/PMPriceLayout;

.field public removeItemListener:Lcom/poshmark/utils/BundleItemRemoveClickListener;

.field public title:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/utils/BundleItemRemoveClickListener;Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Lcom/poshmark/ui/fragments/PMFragment;
    .param p3, "listener"    # Lcom/poshmark/utils/BundleItemRemoveClickListener;
    .param p4, "mode"    # Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;
    .param p5, "c"    # Landroid/database/Cursor;
    .param p6, "flags"    # I

    .prologue
    .line 43
    invoke-direct {p0, p1, p5, p6}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 44
    iput-object p2, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter;->ownerFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 45
    iput-object p3, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter;->removeItemListener:Lcom/poshmark/utils/BundleItemRemoveClickListener;

    .line 46
    iput-object p4, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter;->mode:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    .line 47
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 15
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 61
    move-object/from16 v5, p3

    check-cast v5, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 62
    .local v5, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v13, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v5, v13}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 63
    .local v2, "idCol":I
    invoke-virtual {v5, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/ListingSummary;

    .line 65
    .local v4, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    const v13, 0x7f0c007c

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 66
    .local v1, "covershot":Lcom/poshmark/ui/customviews/PMCovershotImageView;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v1, v13}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->setListingId(Ljava/lang/String;)V

    .line 68
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    .line 69
    .local v3, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getSmallCovershot()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v3, v13, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 71
    const v13, 0x7f0c007e

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Lcom/poshmark/ui/customviews/PMTextView;

    .line 72
    .local v12, "title":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    const v13, 0x7f0c007f

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMTextView;

    .line 75
    .local v9, "priceView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getPriceStringAsWholeNumber()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v9, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    const v13, 0x7f0c0080

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/PMTextView;

    .line 78
    .local v7, "originalPriceView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getOriginalPriceString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v7, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 80
    const v13, 0x7f0c0081

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMTextView;

    .line 81
    .local v11, "sizeView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const v14, 0x7f060281

    move-object/from16 v0, p2

    invoke-virtual {v0, v14}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, " "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v11, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    const v13, 0x7f0c007d

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/customviews/PMTextView;

    .line 84
    .local v6, "nwtView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->isNWT()Z

    move-result v13

    if-eqz v13, :cond_0

    .line 85
    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 86
    invoke-virtual/range {p2 .. p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f0601d6

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    :goto_0
    const v13, 0x7f0c0083

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Lcom/poshmark/ui/customviews/PMButton;

    .line 95
    .local v10, "removeButton":Lcom/poshmark/ui/customviews/PMButton;
    invoke-virtual {v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getPosition()I

    move-result v13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v10, v13}, Lcom/poshmark/ui/customviews/PMButton;->setTag(Ljava/lang/Object;)V

    .line 96
    new-instance v13, Lcom/poshmark/data_model/adapters/BundleListAdapter$1;

    invoke-direct {v13, p0}, Lcom/poshmark/data_model/adapters/BundleListAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/BundleListAdapter;)V

    invoke-virtual {v10, v13}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 106
    const v13, 0x7f0c0082

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 107
    .local v8, "overlay":Landroid/view/View;
    iget-object v13, p0, Lcom/poshmark/data_model/adapters/BundleListAdapter;->mode:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    sget-object v14, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_UNAVAILABLE_ITEMS:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    if-ne v13, v14, :cond_2

    .line 108
    const/4 v13, 0x0

    invoke-virtual {v8, v13}, Landroid/view/View;->setVisibility(I)V

    .line 109
    const/high16 v13, 0x3f800000    # 1.0f

    invoke-virtual {v10, v13}, Lcom/poshmark/ui/customviews/PMButton;->setAlpha(F)V

    .line 115
    :goto_1
    return-void

    .line 87
    .end local v8    # "overlay":Landroid/view/View;
    .end local v10    # "removeButton":Lcom/poshmark/ui/customviews/PMButton;
    :cond_0
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->isRetail()Z

    move-result v13

    if-eqz v13, :cond_1

    .line 88
    const/4 v13, 0x0

    invoke-virtual {v6, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 89
    invoke-virtual/range {p2 .. p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f06022c

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v6, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 91
    :cond_1
    const/16 v13, 0x8

    invoke-virtual {v6, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_0

    .line 112
    .restart local v8    # "overlay":Landroid/view/View;
    .restart local v10    # "removeButton":Lcom/poshmark/ui/customviews/PMButton;
    :cond_2
    const/16 v13, 0x8

    invoke-virtual {v8, v13}, Landroid/view/View;->setVisibility(I)V

    .line 113
    const v13, 0x3e99999a    # 0.3f

    invoke-virtual {v10, v13}, Lcom/poshmark/ui/customviews/PMButton;->setAlpha(F)V

    goto :goto_1
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 52
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 53
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f030017

    const/4 v4, 0x0

    invoke-virtual {v0, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 54
    .local v2, "v":Landroid/view/View;
    const v3, 0x7f0c0080

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 55
    .local v1, "originalPriceView":Landroid/widget/TextView;
    invoke-virtual {v1}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v3

    or-int/lit8 v3, v3, 0x10

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 56
    return-object v2
.end method
