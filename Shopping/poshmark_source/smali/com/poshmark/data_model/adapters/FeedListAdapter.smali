.class public Lcom/poshmark/data_model/adapters/FeedListAdapter;
.super Landroid/widget/CursorAdapter;
.source "FeedListAdapter.java"


# instance fields
.field commentButtonListener:Landroid/view/View$OnClickListener;

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

.field likeButtonListener:Landroid/view/View$OnClickListener;

.field shareButtonListener:Landroid/view/View$OnClickListener;

.field textFormatter:Lcom/poshmark/utils/TextFormatter;

.field viewDetailsListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Landroid/support/v4/app/Fragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 151
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 61
    new-instance v0, Lcom/poshmark/utils/TextFormatter;

    invoke-direct {v0}, Lcom/poshmark/utils/TextFormatter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    .line 63
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->imageList:Ljava/util/Set;

    .line 66
    new-instance v0, Lcom/poshmark/data_model/adapters/FeedListAdapter$1;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/FeedListAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->commentButtonListener:Landroid/view/View$OnClickListener;

    .line 77
    new-instance v0, Lcom/poshmark/data_model/adapters/FeedListAdapter$2;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/FeedListAdapter$2;-><init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->likeButtonListener:Landroid/view/View$OnClickListener;

    .line 100
    new-instance v0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/FeedListAdapter$3;-><init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->shareButtonListener:Landroid/view/View$OnClickListener;

    .line 139
    new-instance v0, Lcom/poshmark/data_model/adapters/FeedListAdapter$4;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/FeedListAdapter$4;-><init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->viewDetailsListener:Landroid/view/View$OnClickListener;

    .line 152
    return-void
.end method

.method private addComments(Landroid/content/Context;Landroid/database/Cursor;Lcom/poshmark/utils/view_holders/ListingViewHolder;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "viewHolder"    # Lcom/poshmark/utils/view_holders/ListingViewHolder;

    .prologue
    .line 335
    move-object v4, p2

    check-cast v4, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 336
    .local v4, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v6, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v4, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 337
    .local v3, "idCol":I
    invoke-virtual {v4, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSocial;

    .line 339
    .local v2, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getComments()Ljava/util/List;

    move-result-object v1

    .line 342
    .local v1, "commentList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    const/4 v7, 0x1

    if-lt v6, v7, :cond_0

    .line 345
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 347
    const/4 v6, 0x0

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 350
    .local v0, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getComment()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setComment(Ljava/lang/String;)V

    .line 353
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 354
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 364
    .end local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    const/4 v7, 0x2

    if-lt v6, v7, :cond_1

    .line 367
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 370
    const/4 v6, 0x1

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 373
    .restart local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getComment()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setComment(Ljava/lang/String;)V

    .line 376
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 377
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 383
    .end local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    :goto_1
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 384
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v7, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->viewDetailsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 385
    const-string v5, ""

    .line 386
    .local v5, "str":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    const/4 v7, 0x2

    if-le v6, v7, :cond_2

    .line 387
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f06018e

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 388
    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 393
    :goto_2
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v6, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 394
    return-void

    .line 360
    .end local v5    # "str":Ljava/lang/String;
    :cond_0
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 380
    :cond_1
    iget-object v6, p3, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1

    .line 391
    .restart local v5    # "str":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0602bf

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_2
.end method

.method private setLikeButtonState(Lcom/poshmark/utils/view_holders/ListingViewHolder;Z)V
    .locals 4
    .param p1, "viewHolder"    # Lcom/poshmark/utils/view_holders/ListingViewHolder;
    .param p2, "liked"    # Z

    .prologue
    const/4 v3, 0x0

    .line 397
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 399
    .local v0, "resources":Landroid/content/res/Resources;
    if-eqz p2, :cond_0

    .line 400
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020017

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 401
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020095

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 406
    :goto_0
    return-void

    .line 403
    :cond_0
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020016

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 404
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020093

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    goto :goto_0
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 22
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 156
    move-object/from16 v13, p3

    check-cast v13, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 157
    .local v13, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v19, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v13, v0}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v10

    .line 160
    .local v10, "idCol":I
    invoke-virtual {v13, v10}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/data_model/models/ListingSocial;

    .line 162
    .local v8, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lcom/poshmark/utils/view_holders/ListingViewHolder;

    .line 164
    .local v18, "viewHolder":Lcom/poshmark/utils/view_holders/ListingViewHolder;
    invoke-interface/range {p3 .. p3}, Landroid/database/Cursor;->getPosition()I

    move-result v19

    if-nez v19, :cond_3

    .line 165
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->topBorder:Landroid/view/View;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setVisibility(I)V

    .line 172
    :goto_0
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->userNameView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getUserName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/PMTextView;->setUserName(Ljava/lang/String;)V

    .line 175
    move-object/from16 v0, v18

    iget-object v6, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 176
    .local v6, "covershot":Lcom/poshmark/ui/customviews/PMCovershotImageView;
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->setListingId(Ljava/lang/String;)V

    .line 177
    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->getImageURL()Ljava/lang/String;

    move-result-object v19

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getCovershot()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v19

    if-nez v19, :cond_0

    .line 178
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getCovershot()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/PMCovershotImageView;->loadImage(Ljava/lang/String;)V

    .line 181
    :cond_0
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

    move-object/from16 v17, v0

    .line 182
    .local v17, "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v12

    .line 183
    .local v12, "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    sget-object v19, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-object/from16 v0, v19

    if-eq v12, v0, :cond_1

    sget-object v19, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-object/from16 v0, v19

    if-ne v12, v0, :cond_4

    .line 184
    :cond_1
    const/16 v19, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    .line 185
    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Lcom/poshmark/ui/customviews/ListingStatusView;->setListingStatus(Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;)V

    .line 186
    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/ListingStatusView;->bringToFront()V

    .line 192
    :goto_1
    move-object/from16 v0, v18

    iget-object v4, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 193
    .local v4, "avataar":Lcom/poshmark/ui/customviews/PMAvataarImageView;
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getUserId()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 194
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getAvataar()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v4, v0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 198
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Lcom/poshmark/utils/TextFormatter;->getPublishedAtMessageString(Lcom/poshmark/data_model/models/ListingSocial;)Ljava/lang/String;

    move-result-object v14

    .line 199
    .local v14, "sharedMsgString":Ljava/lang/String;
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->attributionView:Landroid/widget/TextView;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 201
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v19

    if-eqz v19, :cond_5

    .line 202
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 208
    :goto_2
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->titleView:Landroid/widget/TextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 210
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->priceView:Landroid/widget/TextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getPriceString()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getOriginalPriceString()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 212
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryLabel()Ljava/lang/String;

    move-result-object v5

    .line 213
    .local v5, "category":Ljava/lang/String;
    invoke-static {v5}, Lcom/poshmark/utils/ListingUtils;->getDrawableIconForCategory(Ljava/lang/String;)I

    move-result v9

    .line 214
    .local v9, "id":I
    invoke-virtual/range {p2 .. p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 215
    .local v7, "d":Landroid/graphics/drawable/Drawable;
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->categoryView:Landroid/widget/ImageView;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 216
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    const v21, 0x7f060281

    move-object/from16 v0, p2

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    const-string v21, " "

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 217
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 219
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryLabel()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 220
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 222
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v15

    .line 224
    .local v15, "size":Ljava/lang/CharSequence;
    if-nez v15, :cond_6

    .line 225
    new-instance v16, Ljava/lang/String;

    const-string v19, ""

    move-object/from16 v0, v16

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 229
    .local v16, "sizeString":Ljava/lang/String;
    :goto_3
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSize(Ljava/lang/String;)V

    .line 230
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setBrand(Ljava/lang/String;)V

    .line 231
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v19

    if-eqz v19, :cond_2

    .line 232
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    const/16 v20, 0x1

    invoke-static/range {v20 .. v20}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setNWTConditionFlag(Ljava/lang/Boolean;)V

    .line 233
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryLabel()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 234
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 238
    :cond_2
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->descriptionView:Landroid/widget/TextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getDescription()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 241
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getLikes()Ljava/util/List;

    move-result-object v11

    .line 242
    .local v11, "likes":Ljava/util/List;
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v19

    if-lez v19, :cond_7

    .line 243
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 244
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v19, v0

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    invoke-virtual {v0, v11, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setLikesMessage(Ljava/util/List;Ljava/lang/String;)V

    .line 249
    :goto_4
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, v18

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/data_model/adapters/FeedListAdapter;->addComments(Landroid/content/Context;Landroid/database/Cursor;Lcom/poshmark/utils/view_holders/ListingViewHolder;)V

    .line 252
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v19

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/adapters/FeedListAdapter;->setLikeButtonState(Lcom/poshmark/utils/view_holders/ListingViewHolder;Z)V

    .line 255
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 256
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->shareButton:Landroid/widget/Button;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 257
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentButton:Landroid/widget/Button;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 258
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    move-object/from16 v19, v0

    move-object/from16 v0, v19

    invoke-virtual {v0, v8}, Lcom/poshmark/ui/customviews/PMTextView;->setTag(Ljava/lang/Object;)V

    .line 259
    return-void

    .line 168
    .end local v4    # "avataar":Lcom/poshmark/ui/customviews/PMAvataarImageView;
    .end local v5    # "category":Ljava/lang/String;
    .end local v6    # "covershot":Lcom/poshmark/ui/customviews/PMCovershotImageView;
    .end local v7    # "d":Landroid/graphics/drawable/Drawable;
    .end local v9    # "id":I
    .end local v11    # "likes":Ljava/util/List;
    .end local v12    # "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .end local v14    # "sharedMsgString":Ljava/lang/String;
    .end local v15    # "size":Ljava/lang/CharSequence;
    .end local v16    # "sizeString":Ljava/lang/String;
    .end local v17    # "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    :cond_3
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->topBorder:Landroid/view/View;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 189
    .restart local v6    # "covershot":Lcom/poshmark/ui/customviews/PMCovershotImageView;
    .restart local v12    # "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .restart local v17    # "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    :cond_4
    const/16 v19, 0x8

    move-object/from16 v0, v17

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    goto/16 :goto_1

    .line 205
    .restart local v4    # "avataar":Lcom/poshmark/ui/customviews/PMAvataarImageView;
    .restart local v14    # "sharedMsgString":Ljava/lang/String;
    :cond_5
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 227
    .restart local v5    # "category":Ljava/lang/String;
    .restart local v7    # "d":Landroid/graphics/drawable/Drawable;
    .restart local v9    # "id":I
    .restart local v15    # "size":Ljava/lang/CharSequence;
    :cond_6
    invoke-interface {v15}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v16

    .restart local v16    # "sizeString":Ljava/lang/String;
    goto/16 :goto_3

    .line 246
    .restart local v11    # "likes":Ljava/util/List;
    :cond_7
    move-object/from16 v0, v18

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    move-object/from16 v19, v0

    const/16 v20, 0x8

    invoke-virtual/range {v19 .. v20}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_4
.end method

.method public clearImageList()V
    .locals 3

    .prologue
    .line 409
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->imageList:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 411
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/ui/customviews/PMImageView;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 412
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMImageView;

    .line 413
    .local v0, "img":Lcom/poshmark/ui/customviews/PMImageView;
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMImageView;->releaseInternalBitmap()V

    .line 414
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 416
    .end local v0    # "img":Lcom/poshmark/ui/customviews/PMImageView;
    :cond_0
    return-void
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const v11, 0x7f0c0171

    const v10, 0x7f0c016f

    const/high16 v9, 0x41500000    # 13.0f

    const/4 v8, 0x2

    .line 264
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    iput-object v5, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 265
    iget-object v5, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v6, 0x7f03003f

    const/4 v7, 0x0

    invoke-virtual {v5, v6, p3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 267
    .local v3, "v":Landroid/view/View;
    new-instance v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;

    invoke-direct {v4}, Lcom/poshmark/utils/view_holders/ListingViewHolder;-><init>()V

    .line 269
    .local v4, "viewHolder":Lcom/poshmark/utils/view_holders/ListingViewHolder;
    const v5, 0x7f0c010f

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->topBorder:Landroid/view/View;

    .line 271
    const v5, 0x7f0c0110

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 272
    .local v1, "listingHeaderLayout":Landroid/widget/LinearLayout;
    const v5, 0x7f0c011b

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 274
    const v5, 0x7f0c01cd

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->userNameView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 275
    const v5, 0x7f0c011c

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->attributionView:Landroid/widget/TextView;

    .line 277
    const v5, 0x7f0c0111

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 278
    .local v2, "listingOverviewLayout":Landroid/widget/LinearLayout;
    const v5, 0x7f0c0121

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 280
    const v5, 0x7f0c0127

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/ListingStatusView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 282
    const v5, 0x7f0c0130

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->titleView:Landroid/widget/TextView;

    .line 283
    const v5, 0x7f0c007d

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 284
    const v5, 0x7f0c007f

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->priceView:Landroid/widget/TextView;

    .line 285
    const v5, 0x7f0c0080

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    .line 286
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    iget-object v6, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v6}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v6

    or-int/lit8 v6, v6, 0x10

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 287
    const v5, 0x7f0c0132

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->categoryView:Landroid/widget/ImageView;

    .line 288
    const v5, 0x7f0c0081

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 289
    const v5, 0x7f0c0134

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 290
    const v5, 0x7f0c0135

    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->descriptionView:Landroid/widget/TextView;

    .line 291
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->descriptionView:Landroid/widget/TextView;

    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 292
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->descriptionView:Landroid/widget/TextView;

    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 293
    const v5, 0x7f0c0112

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    .line 294
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v6, 0x7f0c01d2

    invoke-virtual {v5, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 297
    const v5, 0x7f0c0116

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 298
    .local v0, "listingActions":Landroid/widget/LinearLayout;
    const v5, 0x7f0c0045

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    .line 299
    const v5, 0x7f0c0168

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentButton:Landroid/widget/Button;

    .line 300
    const v5, 0x7f0c0046

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->shareButton:Landroid/widget/Button;

    .line 302
    const v5, 0x7f0c0113

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    .line 303
    const v5, 0x7f0c0114

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    .line 305
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 306
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v10}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 308
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v11}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    .line 310
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v5, v11}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    .line 312
    const v5, 0x7f0c0115

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 315
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/high16 v6, 0x41200000    # 10.0f

    invoke-virtual {v5, v8, v6}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 316
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5, v8, v9}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 317
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5, v8, v9}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 320
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentButton:Landroid/widget/Button;

    iget-object v6, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->commentButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    iget-object v6, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->likeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 322
    iget-object v5, v4, Lcom/poshmark/utils/view_holders/ListingViewHolder;->shareButton:Landroid/widget/Button;

    iget-object v6, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 327
    invoke-virtual {v3, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 329
    return-object v3
.end method
