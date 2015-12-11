.class public Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
.super Landroid/widget/CursorAdapter;
.source "HetroFeedListAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;
    }
.end annotation


# instance fields
.field public commentButtonListener:Landroid/view/View$OnClickListener;

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

.field public likeButtonListener:Landroid/view/View$OnClickListener;

.field public shareButtonListener:Landroid/view/View$OnClickListener;

.field public viewDetailsListener:Landroid/view/View$OnClickListener;

.field public viewLikesListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Landroid/support/v4/app/Fragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 164
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 56
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->imageList:Ljava/util/Set;

    .line 59
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$1;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->commentButtonListener:Landroid/view/View$OnClickListener;

    .line 71
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$2;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$2;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->likeButtonListener:Landroid/view/View$OnClickListener;

    .line 97
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->shareButtonListener:Landroid/view/View$OnClickListener;

    .line 137
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$4;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$4;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->viewDetailsListener:Landroid/view/View$OnClickListener;

    .line 148
    new-instance v0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$5;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$5;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->viewLikesListener:Landroid/view/View$OnClickListener;

    .line 165
    return-void
.end method

.method private getFeedItemLayoutType(Landroid/database/Cursor;)Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;
    .locals 4
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 310
    move-object v2, p1

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 311
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 312
    .local v1, "idCol":I
    invoke-virtual {v2, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItem;

    .line 313
    .local v0, "feedItem":Lcom/poshmark/data_model/models/FeedItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/FeedItem;->getViewType()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    move-result-object v3

    return-object v3
.end method

.method private inflateFeedItem(Landroid/database/Cursor;Landroid/content/Context;Landroid/view/View;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 10
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "shellLayout"    # Landroid/view/View;
    .param p4, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    const v9, 0x7f030048

    const v8, 0x7f030045

    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 220
    move-object v2, p1

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 221
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 222
    .local v1, "idCol":I
    invoke-virtual {v2, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItem;

    .line 224
    .local v0, "feedItem":Lcom/poshmark/data_model/models/FeedItem;
    const v4, 0x7f0c010f

    invoke-virtual {p3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p4, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->topBorder:Landroid/view/View;

    .line 228
    iget-object v4, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    if-eqz v4, :cond_0

    .line 229
    sget-object v4, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    iget-object v5, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 254
    :cond_0
    :goto_0
    iget-object v4, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    if-eqz v4, :cond_1

    .line 255
    sget-object v4, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    iget-object v5, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/FeedItemImageLayout;->getCurrentLayout()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_1

    .line 285
    :cond_1
    :goto_1
    iget-object v4, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    if-eqz v4, :cond_2

    .line 286
    sget-object v4, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$6;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    iget-object v5, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    iget-object v5, v5, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_2

    .line 307
    .end local p3    # "shellLayout":Landroid/view/View;
    :cond_2
    :goto_2
    return-void

    .line 231
    .restart local p3    # "shellLayout":Landroid/view/View;
    :pswitch_0
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    invoke-virtual {v4, v8, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .local v3, "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 232
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 233
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithHeaderViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_0

    .line 236
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_1
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030041

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 237
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 238
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithHeaderViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_0

    .line 241
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_2
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    invoke-virtual {v4, v8, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 242
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 243
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithHeaderViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_0

    .line 246
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_3
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f03004a

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 247
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 248
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithHeaderViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_0

    .line 257
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_4
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    invoke-virtual {v4, v9, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 258
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 259
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_1

    .line 262
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_5
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030046

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 263
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 264
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto :goto_1

    .line 267
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_6
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030047

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 268
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 269
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_1

    .line 272
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_7
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    invoke-virtual {v4, v9, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 273
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 274
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_1

    .line 277
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_8
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030049

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .restart local v3    # "subLayout":Landroid/view/View;
    move-object v4, p3

    .line 278
    check-cast v4, Landroid/widget/LinearLayout;

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 279
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_1

    .line 288
    .end local v3    # "subLayout":Landroid/view/View;
    :pswitch_9
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030042

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 289
    .restart local v3    # "subLayout":Landroid/view/View;
    check-cast p3, Landroid/widget/LinearLayout;

    .end local p3    # "shellLayout":Landroid/view/View;
    invoke-virtual {p3, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 290
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithFooterViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_2

    .line 294
    .end local v3    # "subLayout":Landroid/view/View;
    .restart local p3    # "shellLayout":Landroid/view/View;
    :pswitch_a
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030043

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 295
    .restart local v3    # "subLayout":Landroid/view/View;
    check-cast p3, Landroid/widget/LinearLayout;

    .end local p3    # "shellLayout":Landroid/view/View;
    invoke-virtual {p3, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 296
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithFooterViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_2

    .line 300
    .end local v3    # "subLayout":Landroid/view/View;
    .restart local p3    # "shellLayout":Landroid/view/View;
    :pswitch_b
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f030044

    invoke-virtual {v4, v5, v7, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 301
    .restart local v3    # "subLayout":Landroid/view/View;
    check-cast p3, Landroid/widget/LinearLayout;

    .end local p3    # "shellLayout":Landroid/view/View;
    invoke-virtual {p3, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 302
    invoke-virtual {p4, v0, v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->populateViewHolderWithFooterViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V

    goto/16 :goto_2

    .line 229
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch

    .line 255
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch

    .line 286
    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method private populateViews(Landroid/content/Context;Landroid/database/Cursor;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p4, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    .line 185
    iget-object v0, p3, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    if-eqz v0, :cond_0

    .line 186
    invoke-static {p1, p0, p3, p4}, Lcom/poshmark/utils/FeedItemPopulator;->populateHeader(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 188
    :cond_0
    iget-object v0, p3, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    if-eqz v0, :cond_1

    .line 189
    invoke-static {p1, p0, p3, p4}, Lcom/poshmark/utils/FeedItemPopulator;->populateImages(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 191
    :cond_1
    iget-object v0, p3, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    if-eqz v0, :cond_2

    .line 192
    invoke-static {p1, p0, p3, p4}, Lcom/poshmark/utils/FeedItemPopulator;->populateFooter(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 194
    :cond_2
    return-void
.end method


# virtual methods
.method public addComments(Landroid/content/Context;Lcom/poshmark/data_model/models/ListingSocial;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "feedItem"    # Lcom/poshmark/data_model/models/ListingSocial;
    .param p3, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 338
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/ListingSocial;->getComments()Ljava/util/List;

    move-result-object v1

    .line 341
    .local v1, "commentList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Comment;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lt v3, v7, :cond_0

    .line 344
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 346
    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 349
    .local v0, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getComment()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setComment(Ljava/lang/String;)V

    .line 352
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 353
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 363
    .end local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lt v3, v8, :cond_1

    .line 366
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 369
    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 372
    .restart local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getComment()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-interface {v5}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setComment(Ljava/lang/String;)V

    .line 375
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 376
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 382
    .end local v0    # "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    :goto_1
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v3, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 383
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->viewDetailsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 385
    const-string v2, ""

    .line 386
    .local v2, "str":Ljava/lang/String;
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-le v3, v8, :cond_2

    .line 387
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06018e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 388
    new-array v3, v7, [Ljava/lang/Object;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 393
    :goto_2
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v3, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 394
    return-void

    .line 359
    .end local v2    # "str":Ljava/lang/String;
    :cond_0
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 379
    :cond_1
    iget-object v3, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1

    .line 391
    .restart local v2    # "str":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0602bf

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_2
.end method

.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 169
    move-object v2, p3

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 170
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v5, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 174
    .local v1, "idCol":I
    invoke-virtual {v2, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItem;

    .line 176
    .local v0, "feedItem":Lcom/poshmark/data_model/models/FeedItem;
    invoke-interface {p3}, Landroid/database/Cursor;->getPosition()I

    move-result v3

    .line 177
    .local v3, "pos":I
    const-string v5, "BIND VIEW"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "pos="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 179
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .line 180
    .local v4, "viewHolder":Lcom/poshmark/utils/view_holders/FeedItemViewHolder;
    invoke-direct {p0, p2, v2, v0, v4}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->populateViews(Landroid/content/Context;Landroid/database/Cursor;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 182
    return-void
.end method

.method public clearImageList()V
    .locals 3

    .prologue
    .line 409
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->imageList:Ljava/util/Set;

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

.method public getItemViewType(I)I
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 330
    invoke-virtual {p0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 331
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->moveToPosition(I)Z

    .line 332
    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 333
    .local v1, "idCol":I
    invoke-virtual {v2, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/FeedItem;

    .line 334
    .local v0, "feedItem":Lcom/poshmark/data_model/models/FeedItem;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/FeedItem;->getViewLayoutTypeId()I

    move-result v3

    return v3
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 318
    invoke-static {}, Lcom/poshmark/data_model/models/FeedItem;->getViewLayoutTypeCount()I

    move-result v0

    return v0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 200
    invoke-interface {p2}, Landroid/database/Cursor;->getPosition()I

    move-result v1

    .line 201
    .local v1, "pos":I
    const-string v4, "BIND VIEW - new"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "pos="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 204
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v4, :cond_0

    .line 205
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 208
    :cond_0
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f03004b

    const/4 v6, 0x0

    invoke-virtual {v4, v5, p3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 209
    .local v2, "v":Landroid/view/View;
    const v4, 0x7f0c012b

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 210
    .local v0, "container":Landroid/view/View;
    new-instance v3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    invoke-direct {v3}, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;-><init>()V

    .line 211
    .local v3, "viewHolder":Lcom/poshmark/utils/view_holders/FeedItemViewHolder;
    invoke-direct {p0, p2, p1, v0, v3}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->inflateFeedItem(Landroid/database/Cursor;Landroid/content/Context;Landroid/view/View;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 213
    invoke-virtual {v2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 215
    return-object v2
.end method

.method public setLikeButtonState(Lcom/poshmark/utils/view_holders/FeedItemViewHolder;Z)V
    .locals 4
    .param p1, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;
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
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020017

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 401
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020095

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 406
    :goto_0
    return-void

    .line 403
    :cond_0
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020016

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 404
    iget-object v1, p1, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    const v2, 0x7f020093

    invoke-virtual {v1, v2, v3, v3, v3}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    goto :goto_0
.end method
