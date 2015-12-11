.class public Lcom/poshmark/data_model/adapters/ShowroomListAdapter;
.super Landroid/widget/CursorAdapter;
.source "ShowroomListAdapter.java"

# interfaces
.implements Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;


# instance fields
.field private context:Landroid/content/Context;

.field private inflater:Landroid/view/LayoutInflater;

.field showroom:Lcom/poshmark/data_model/models/Showroom;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "flags"    # I

    .prologue
    .line 33
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 34
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->context:Landroid/content/Context;

    .line 35
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
    move-object v2, p3

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 44
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v6, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 45
    .local v0, "idCol":I
    invoke-virtual {v2, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/Showroom;

    .local v3, "showroom":Lcom/poshmark/data_model/models/Showroom;
    move-object v1, p1

    .line 47
    check-cast v1, Landroid/widget/LinearLayout;

    .line 48
    .local v1, "itemLayout":Landroid/widget/LinearLayout;
    const v6, 0x7f0c02d3

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 49
    .local v4, "showroomCovershotImageView":Landroid/widget/ImageView;
    const v6, 0x7f0c0241

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 51
    .local v5, "titleTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v6

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v7

    iget-object v7, v7, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    invoke-virtual {v6, v7, v4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 53
    return-void
.end method

.method public getHeaderId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 83
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 65
    if-nez p2, :cond_1

    .line 66
    new-instance v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;-><init>()V

    .line 67
    .local v0, "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v2, 0x7f0300c4

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 68
    const v1, 0x7f0c0130

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    .line 69
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 74
    :goto_0
    if-nez p1, :cond_0

    .line 75
    iget-object v1, v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->context:Landroid/content/Context;

    const v3, 0x7f060269

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    :cond_0
    return-object p2

    .line 71
    .end local v0    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    .restart local v0    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 57
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 58
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v2, 0x7f0300bb

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 59
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setShowroom(Lcom/poshmark/data_model/models/Showroom;)V
    .locals 0
    .param p1, "showroom"    # Lcom/poshmark/data_model/models/Showroom;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 39
    return-void
.end method
