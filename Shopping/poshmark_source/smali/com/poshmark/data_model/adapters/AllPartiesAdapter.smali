.class public Lcom/poshmark/data_model/adapters/AllPartiesAdapter;
.super Landroid/widget/CursorAdapter;
.source "AllPartiesAdapter.java"

# interfaces
.implements Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersAdapter;


# instance fields
.field imageList:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/widget/ImageView;",
            ">;"
        }
    .end annotation
.end field

.field private inflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "flags"    # I

    .prologue
    .line 37
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 33
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->imageList:Ljava/util/Set;

    .line 39
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 10
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 44
    move-object v5, p3

    check-cast v5, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 45
    .local v5, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v5, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    .line 46
    .local v2, "idCol":I
    invoke-virtual {v5, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PartyEvent;

    .line 48
    .local v1, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;

    .line 49
    .local v6, "viewHolder":Lcom/poshmark/utils/view_holders/PartyOverviewHolder;
    if-eqz v1, :cond_1

    .line 50
    iget-object v0, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyCovershotView:Landroid/widget/ImageView;

    .line 51
    .local v0, "covershot":Landroid/widget/ImageView;
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 52
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    .line 53
    .local v3, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCovershot()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 54
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->imageList:Ljava/util/Set;

    invoke-interface {v7, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 57
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f020022

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {p1, v7}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 58
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyTitleView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f09003c

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 59
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f090038

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 60
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f090038

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 62
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyTitleView:Landroid/widget/TextView;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 64
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getListingCount()I

    move-result v4

    .line 65
    .local v4, "listingCount":I
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    const-string v8, "Ends in ..."

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 67
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f090003

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {p1, v7}, Landroid/view/View;->setBackgroundColor(I)V

    .line 68
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyTitleView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f090040

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 69
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f090040

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 70
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f090040

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 72
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const v9, 0x7f06018f

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const v9, 0x7f0600ce

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getFormattedPendingTime()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 75
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    const v8, 0x7f06015b

    invoke-virtual {p2, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    .end local v4    # "listingCount":I
    :cond_0
    :goto_0
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v7

    if-nez v7, :cond_1

    .line 91
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getHosts()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v7

    const/4 v8, 0x1

    if-le v7, v8, :cond_6

    .line 92
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const v9, 0x7f060143

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCommaSeparatedHostNames()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 98
    .end local v0    # "covershot":Landroid/widget/ImageView;
    .end local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_1
    :goto_1
    return-void

    .line 77
    .restart local v0    # "covershot":Landroid/widget/ImageView;
    .restart local v3    # "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    :cond_2
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 78
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getListingCount()I

    move-result v4

    .line 79
    .restart local v4    # "listingCount":I
    if-nez v4, :cond_3

    .line 80
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    const v8, 0x7f0601d2

    invoke-virtual {p2, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 81
    :cond_3
    const/4 v7, 0x1

    if-ne v4, v7, :cond_4

    .line 82
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const v9, 0x7f060167

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 84
    :cond_4
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const v9, 0x7f06018f

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 86
    .end local v4    # "listingCount":I
    :cond_5
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->isFutureEvent()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 87
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    invoke-virtual {v1, p2}, Lcom/poshmark/data_model/models/PartyEvent;->getStartDateTimeString(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 94
    :cond_6
    iget-object v7, v6, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const v9, 0x7f060141

    invoke-virtual {p2, v9}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getCommaSeparatedHostNames()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1
.end method

.method public clearImageList()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 172
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->imageList:Ljava/util/Set;

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 174
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/widget/ImageView;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 175
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 176
    .local v2, "img":Landroid/widget/ImageView;
    invoke-virtual {v2}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/BitmapDrawable;

    .line 177
    .local v1, "drawable":Landroid/graphics/drawable/BitmapDrawable;
    if-eqz v1, :cond_0

    .line 178
    invoke-virtual {v1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 179
    .local v0, "bmp":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 180
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 181
    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 182
    invoke-virtual {v2, v5}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 185
    .end local v0    # "bmp":Landroid/graphics/Bitmap;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 187
    .end local v1    # "drawable":Landroid/graphics/drawable/BitmapDrawable;
    .end local v2    # "img":Landroid/widget/ImageView;
    :cond_1
    return-void
.end method

.method public getHeaderId(I)J
    .locals 6
    .param p1, "position"    # I

    .prologue
    const-wide/16 v4, 0x0

    .line 150
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v2

    .line 151
    .local v2, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentPartiesCount()I

    move-result v0

    .line 152
    .local v0, "currentPartiesCount":I
    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getUpcomingPartiesCount()I

    move-result v1

    .line 153
    .local v1, "futurePartiesCount":I
    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getPastPartiesCount()I

    move-result v3

    .line 155
    .local v3, "pastPartiesCount":I
    if-lez v0, :cond_3

    .line 156
    if-ge p1, v0, :cond_1

    .line 167
    :cond_0
    :goto_0
    return-wide v4

    .line 158
    :cond_1
    add-int v4, v0, v1

    if-ge p1, v4, :cond_2

    .line 159
    int-to-long v4, v0

    goto :goto_0

    .line 161
    :cond_2
    add-int v4, v0, v1

    int-to-long v4, v4

    goto :goto_0

    .line 164
    :cond_3
    if-lt p1, v1, :cond_0

    .line 167
    int-to-long v4, v1

    goto :goto_0
.end method

.method public getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const v8, 0x7f060211

    const v7, 0x7f060210

    .line 118
    if-nez p2, :cond_0

    .line 119
    new-instance v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    invoke-direct {v3}, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;-><init>()V

    .line 120
    .local v3, "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f0300c4

    const/4 v6, 0x0

    invoke-virtual {v4, v5, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 121
    const v4, 0x7f0c0130

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    .line 122
    invoke-virtual {p2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 126
    :goto_0
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v2

    .line 127
    .local v2, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentPartiesCount()I

    move-result v0

    .line 128
    .local v0, "currentPartiesCount":I
    invoke-virtual {v2}, Lcom/poshmark/controllers/GlobalPartiesController;->getUpcomingPartiesCount()I

    move-result v1

    .line 130
    .local v1, "futurePartiesCount":I
    if-lez v0, :cond_3

    .line 131
    if-ge p1, v0, :cond_1

    .line 132
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    const v5, 0x7f06020f

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(I)V

    .line 145
    :goto_1
    return-object p2

    .line 124
    .end local v0    # "currentPartiesCount":I
    .end local v1    # "futurePartiesCount":I
    .end local v2    # "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    .end local v3    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;

    .restart local v3    # "viewHolder":Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;
    goto :goto_0

    .line 133
    .restart local v0    # "currentPartiesCount":I
    .restart local v1    # "futurePartiesCount":I
    .restart local v2    # "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    :cond_1
    add-int v4, v0, v1

    if-ge p1, v4, :cond_2

    .line 134
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 136
    :cond_2
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 139
    :cond_3
    if-ge p1, v1, :cond_4

    .line 140
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1

    .line 142
    :cond_4
    iget-object v4, v3, Lcom/poshmark/utils/view_holders/TableSectionHeaderViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setText(I)V

    goto :goto_1
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 102
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 103
    new-instance v1, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;-><init>()V

    .line 105
    .local v1, "viewHolder":Lcom/poshmark/utils/view_holders/PartyOverviewHolder;
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f030098

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 106
    .local v0, "v":Landroid/view/View;
    const v2, 0x7f0c0254

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyCovershotView:Landroid/widget/ImageView;

    .line 107
    const v2, 0x7f0c0255

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyTitleView:Landroid/widget/TextView;

    .line 108
    const v2, 0x7f0c0256

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyDetailsView:Landroid/widget/TextView;

    .line 109
    const v2, 0x7f0c0257

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/PartyOverviewHolder;->partyHostsView:Landroid/widget/TextView;

    .line 111
    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 112
    return-object v0
.end method
