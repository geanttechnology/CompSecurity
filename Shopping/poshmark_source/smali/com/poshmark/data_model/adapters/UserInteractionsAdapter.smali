.class public Lcom/poshmark/data_model/adapters/UserInteractionsAdapter;
.super Landroid/widget/CursorAdapter;
.source "UserInteractionsAdapter.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "flags"    # I

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 27
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 43
    move-object v4, p3

    check-cast v4, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 44
    .local v4, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v4, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 47
    .local v1, "idCol":I
    invoke-virtual {v4, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 50
    .local v3, "interactionData":Lcom/poshmark/data_model/models/inner_models/UserReference;
    const v7, 0x7f0c02f4

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 51
    .local v0, "avataar":Landroid/widget/ImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    .line 52
    .local v2, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v6

    .line 53
    .local v6, "url":Ljava/lang/String;
    if-eqz v6, :cond_0

    .line 54
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 61
    :goto_0
    const v7, 0x7f0c02f5

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 62
    .local v5, "name":Landroid/widget/TextView;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getDisplayHandle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 64
    return-void

    .line 56
    .end local v5    # "name":Landroid/widget/TextView;
    :cond_0
    const v7, 0x7f0200d4

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .locals 6
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 69
    move-object v2, p1

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 71
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 74
    .local v0, "idCol":I
    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 78
    .local v1, "interactionData":Lcom/poshmark/data_model/models/inner_models/UserReference;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getDisplayHandle()Ljava/lang/String;

    move-result-object v3

    .line 80
    .local v3, "name":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "@"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 31
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 32
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300c8

    const/4 v4, 0x0

    invoke-virtual {v0, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 34
    .local v1, "v":Landroid/view/View;
    new-instance v2, Lcom/poshmark/utils/view_holders/ListingViewHolder;

    invoke-direct {v2}, Lcom/poshmark/utils/view_holders/ListingViewHolder;-><init>()V

    .line 35
    .local v2, "viewHolder":Lcom/poshmark/utils/view_holders/ListingViewHolder;
    invoke-virtual {v1, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 37
    return-object v1
.end method
