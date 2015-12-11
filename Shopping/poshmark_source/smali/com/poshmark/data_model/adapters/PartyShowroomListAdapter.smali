.class public Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;
.super Landroid/support/v4/widget/CursorAdapter;
.source "PartyShowroomListAdapter.java"

# interfaces
.implements Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;


# instance fields
.field private context:Landroid/content/Context;

.field event:Lcom/poshmark/data_model/models/PartyEvent;

.field private inflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Landroid/support/v4/app/Fragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1, p3, p4}, Landroid/support/v4/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 37
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->context:Landroid/content/Context;

    .line 38
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 12
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/16 v11, 0x8

    const/4 v10, 0x0

    .line 46
    move-object v3, p3

    check-cast v3, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 47
    .local v3, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v8, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v3, v8}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 48
    .local v1, "idCol":I
    invoke-virtual {v3, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .local v5, "roomInfo":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    move-object v2, p1

    .line 50
    check-cast v2, Landroid/widget/LinearLayout;

    .line 51
    .local v2, "itemLayout":Landroid/widget/LinearLayout;
    const v8, 0x7f0c023e

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 52
    .local v4, "partyCovershotImageView":Lcom/poshmark/ui/customviews/RoundedImageView;
    const v8, 0x7f0c0240

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 53
    .local v6, "showroomIconView":Landroid/widget/ImageView;
    const v8, 0x7f0c0241

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/PMTextView;

    .line 54
    .local v7, "titleTextView":Lcom/poshmark/ui/customviews/PMTextView;
    const v8, 0x7f0c0242

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    .line 56
    .local v0, "descriptionTextView":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const v9, 0x7f06026d

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getDescription()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 59
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 60
    invoke-virtual {v4, v10}, Lcom/poshmark/ui/customviews/RoundedImageView;->setVisibility(I)V

    .line 61
    invoke-virtual {v6, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 62
    iget-object v8, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v8, :cond_0

    .line 63
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v8

    iget-object v9, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v9}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9, v4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 71
    :cond_0
    :goto_0
    return-void

    .line 67
    :cond_1
    invoke-virtual {v4, v11}, Lcom/poshmark/ui/customviews/RoundedImageView;->setVisibility(I)V

    .line 68
    invoke-virtual {v6, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 69
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->getIconDrawable()I

    move-result v9

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-virtual {v6, v8}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public getHeaderId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 101
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 83
    if-nez p2, :cond_1

    .line 84
    new-instance v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    invoke-direct {v0}, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;-><init>()V

    .line 85
    .local v0, "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v2, 0x7f0300c4

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 86
    const v1, 0x7f0c0130

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    .line 87
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 92
    :goto_0
    if-nez p1, :cond_0

    .line 93
    iget-object v1, v0, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->context:Landroid/content/Context;

    const v3, 0x7f060063

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 96
    :cond_0
    return-object p2

    .line 89
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
    .line 75
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 76
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v2, 0x7f03009c

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 77
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setEvent(Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 0
    .param p1, "event"    # Lcom/poshmark/data_model/models/PartyEvent;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/PartyShowroomListAdapter;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 42
    return-void
.end method
