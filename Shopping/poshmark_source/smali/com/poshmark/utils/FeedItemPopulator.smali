.class public Lcom/poshmark/utils/FeedItemPopulator;
.super Ljava/lang/Object;
.source "FeedItemPopulator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/FeedItemPopulator$3;,
        Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    return-void
.end method

.method public static populateFooter(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "hetroFeedListAdapter"    # Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
    .param p2, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p3, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    .line 191
    sget-object v11, Lcom/poshmark/utils/FeedItemPopulator$3;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    move-object/from16 v0, p2

    iget-object v12, v0, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v12, v12, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    iget-object v12, v12, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v12}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v12

    aget v11, v11, v12

    packed-switch v11, :pswitch_data_0

    .line 368
    :goto_0
    return-void

    .line 194
    :pswitch_0
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->footerTextView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v12, 0x0

    invoke-virtual/range {p2 .. p2}, Lcom/poshmark/data_model/models/FeedItem;->getFooterString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v11, v12, v13}, Lcom/poshmark/ui/customviews/PMTextView;->setTitleWithHtmlString(Ljava/lang/String;Ljava/lang/String;)V

    .line 196
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->footerLayout:Landroid/view/View;

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    goto :goto_0

    .line 200
    :pswitch_1
    move-object/from16 v0, p2

    iget-object v11, v0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    const/4 v12, 0x0

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/ListingSocial;

    .line 202
    .local v5, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v11

    if-eqz v11, :cond_1

    .line 203
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 209
    :goto_1
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->priceView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getPriceString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 212
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getOriginalPriceString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 213
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v1

    .line 214
    .local v1, "category":Ljava/lang/String;
    invoke-static {v1}, Lcom/poshmark/utils/ListingUtils;->getDrawableIconForCategory(Ljava/lang/String;)I

    move-result v3

    .line 215
    .local v3, "id":I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 216
    .local v2, "d":Landroid/graphics/drawable/Drawable;
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->categoryView:Landroid/widget/ImageView;

    invoke-virtual {v11, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 217
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const v13, 0x7f060281

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 218
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 220
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 221
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 223
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v7

    .line 224
    .local v7, "size":Ljava/lang/CharSequence;
    if-nez v7, :cond_2

    .line 225
    new-instance v8, Ljava/lang/String;

    const-string v11, ""

    invoke-direct {v8, v11}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 229
    .local v8, "sizeString":Ljava/lang/String;
    :goto_2
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v11, v8}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSize(Ljava/lang/String;)V

    .line 230
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const-string v12, "listings_feed_screen"

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 231
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setBrand(Ljava/lang/String;)V

    .line 232
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const-string v12, "listings_feed_screen"

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 233
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->isRetail()Z

    move-result v11

    if-eqz v11, :cond_3

    .line 234
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/4 v12, 0x1

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setRetailConditionFlag(Ljava/lang/Boolean;)V

    .line 235
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 236
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 237
    const v11, 0x7f06022c

    invoke-virtual {p0, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 238
    .local v6, "s":Ljava/lang/String;
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v6}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 248
    .end local v6    # "s":Ljava/lang/String;
    :cond_0
    :goto_3
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 249
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getTotalLikes()I

    move-result v10

    .line 250
    .local v10, "totalLikes":I
    if-lez v10, :cond_5

    .line 251
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 252
    const/4 v11, 0x1

    if-ne v10, v11, :cond_4

    .line 253
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v10}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f060163

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 260
    :goto_4
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    invoke-virtual {v11, v5}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 261
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->viewLikesListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 264
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getTotalComments()I

    move-result v9

    .line 265
    .local v9, "totalComments":I
    if-lez v9, :cond_7

    .line 266
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 267
    const/4 v11, 0x1

    if-ne v9, v11, :cond_6

    .line 268
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f06008d

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 275
    :goto_5
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    invoke-virtual {v11, v5}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 276
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->viewDetailsListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 279
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v11

    move-object/from16 v0, p3

    invoke-virtual {p1, v0, v11}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->setLikeButtonState(Lcom/poshmark/utils/view_holders/FeedItemViewHolder;Z)V

    .line 282
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 283
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 286
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 287
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 288
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 291
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->commentButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 292
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->likeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 293
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 206
    .end local v1    # "category":Ljava/lang/String;
    .end local v2    # "d":Landroid/graphics/drawable/Drawable;
    .end local v3    # "id":I
    .end local v7    # "size":Ljava/lang/CharSequence;
    .end local v8    # "sizeString":Ljava/lang/String;
    .end local v9    # "totalComments":I
    .end local v10    # "totalLikes":I
    :cond_1
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 227
    .restart local v1    # "category":Ljava/lang/String;
    .restart local v2    # "d":Landroid/graphics/drawable/Drawable;
    .restart local v3    # "id":I
    .restart local v7    # "size":Ljava/lang/CharSequence;
    :cond_2
    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    .restart local v8    # "sizeString":Ljava/lang/String;
    goto/16 :goto_2

    .line 240
    :cond_3
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v11

    if-eqz v11, :cond_0

    .line 241
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/4 v12, 0x1

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setNWTConditionFlag(Ljava/lang/Boolean;)V

    .line 242
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 243
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 244
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const v12, 0x7f0601d6

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(I)V

    goto/16 :goto_3

    .line 255
    .restart local v10    # "totalLikes":I
    :cond_4
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v10}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f060165

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 258
    :cond_5
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v10}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f060165

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 270
    .restart local v9    # "totalComments":I
    :cond_6
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f06008e

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_5

    .line 273
    :cond_7
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const v13, 0x7f06008e

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_5

    .line 298
    .end local v1    # "category":Ljava/lang/String;
    .end local v2    # "d":Landroid/graphics/drawable/Drawable;
    .end local v3    # "id":I
    .end local v5    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v7    # "size":Ljava/lang/CharSequence;
    .end local v8    # "sizeString":Ljava/lang/String;
    .end local v9    # "totalComments":I
    .end local v10    # "totalLikes":I
    :pswitch_2
    move-object/from16 v0, p2

    iget-object v11, v0, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    const/4 v12, 0x0

    invoke-interface {v11, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/ListingSocial;

    .line 300
    .restart local v5    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v11

    if-eqz v11, :cond_9

    .line 301
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 307
    :goto_6
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->titleView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 309
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->priceView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getPriceString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 310
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getOriginalPriceString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 311
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v1

    .line 312
    .restart local v1    # "category":Ljava/lang/String;
    invoke-static {v1}, Lcom/poshmark/utils/ListingUtils;->getDrawableIconForCategory(Ljava/lang/String;)I

    move-result v3

    .line 313
    .restart local v3    # "id":I
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-virtual {v11, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 314
    .restart local v2    # "d":Landroid/graphics/drawable/Drawable;
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->categoryView:Landroid/widget/ImageView;

    invoke-virtual {v11, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 315
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const v13, 0x7f060281

    invoke-virtual {p0, v13}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 316
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const-string v12, "listings_feed_screen"

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 317
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const-string v12, "listings_feed_screen"

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 320
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->descriptionView:Landroid/widget/TextView;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setVisibility(I)V

    .line 321
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->descriptionView:Landroid/widget/TextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getDescription()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 323
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 324
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 326
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

    move-result-object v7

    .line 327
    .restart local v7    # "size":Ljava/lang/CharSequence;
    if-nez v7, :cond_a

    .line 328
    new-instance v8, Ljava/lang/String;

    const-string v11, ""

    invoke-direct {v8, v11}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 332
    .restart local v8    # "sizeString":Ljava/lang/String;
    :goto_7
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v11, v8}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSize(Ljava/lang/String;)V

    .line 333
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getBrand()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setBrand(Ljava/lang/String;)V

    .line 334
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->isNWT()Z

    move-result v11

    if-eqz v11, :cond_8

    .line 335
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/4 v12, 0x1

    invoke-static {v12}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setNWTConditionFlag(Ljava/lang/Boolean;)V

    .line 336
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getCategoryLabel()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 337
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 341
    :cond_8
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getLikes()Ljava/util/List;

    move-result-object v4

    .line 342
    .local v4, "likes":Ljava/util/List;
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v11

    if-lez v11, :cond_b

    .line 343
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 344
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v4, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setLikesMessage(Ljava/util/List;Ljava/lang/String;)V

    .line 350
    :goto_8
    move-object/from16 v0, p3

    invoke-virtual {p1, p0, v5, v0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->addComments(Landroid/content/Context;Lcom/poshmark/data_model/models/ListingSocial;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V

    .line 353
    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getListingLikeStatus()Z

    move-result v11

    move-object/from16 v0, p3

    invoke-virtual {p1, v0, v11}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->setLikeButtonState(Lcom/poshmark/utils/view_holders/FeedItemViewHolder;Z)V

    .line 356
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 357
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 358
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    invoke-virtual {v11, v5}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 359
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v11, v5}, Lcom/poshmark/ui/customviews/PMTextView;->setTag(Ljava/lang/Object;)V

    .line 362
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->commentButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 363
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->likeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 364
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    iget-object v12, p1, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v11, v12}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 304
    .end local v1    # "category":Ljava/lang/String;
    .end local v2    # "d":Landroid/graphics/drawable/Drawable;
    .end local v3    # "id":I
    .end local v4    # "likes":Ljava/util/List;
    .end local v7    # "size":Ljava/lang/CharSequence;
    .end local v8    # "sizeString":Ljava/lang/String;
    :cond_9
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    goto/16 :goto_6

    .line 330
    .restart local v1    # "category":Ljava/lang/String;
    .restart local v2    # "d":Landroid/graphics/drawable/Drawable;
    .restart local v3    # "id":I
    .restart local v7    # "size":Ljava/lang/CharSequence;
    :cond_a
    invoke-interface {v7}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    .restart local v8    # "sizeString":Ljava/lang/String;
    goto/16 :goto_7

    .line 346
    .restart local v4    # "likes":Ljava/util/List;
    :cond_b
    move-object/from16 v0, p3

    iget-object v11, v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const/16 v12, 0x8

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_8

    .line 191
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static populateHeader(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "hetroFeedListAdapter"    # Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
    .param p2, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p3, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    .line 39
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->headerTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    if-eqz v2, :cond_0

    .line 40
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->headerTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v3, 0x0

    iget-object v4, p2, Lcom/poshmark/data_model/models/FeedItem;->header:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/poshmark/ui/customviews/PMTextView;->setTitleWithHtmlString(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    :cond_0
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->attributionView:Landroid/widget/TextView;

    if-eqz v2, :cond_1

    iget-object v2, p2, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v2, v2, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v3, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-eq v2, v3, :cond_1

    .line 44
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->attributionView:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getAttributionText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    :cond_1
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getActorImageUrl()Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "actorImageURL":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/FeedItemPopulator$3;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemHeaderLayout$Layout:[I

    iget-object v3, p2, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v3, v3, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    iget-object v3, v3, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 78
    :cond_2
    :goto_0
    return-void

    .line 52
    :pswitch_0
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    if-eqz v2, :cond_2

    .line 53
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {p2, p0, v2}, Lcom/poshmark/data_model/models/FeedItem;->renderHeaderAvataar(Landroid/content/Context;Lcom/poshmark/ui/customviews/PMAvataarImageView;)V

    .line 54
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getActorId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    goto :goto_0

    .line 58
    :pswitch_1
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->usernameTextView:Lcom/poshmark/ui/customviews/PMTextView;

    if-eqz v2, :cond_3

    .line 59
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->usernameTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getContentOwnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setUserName(Ljava/lang/String;)V

    .line 61
    :cond_3
    iget-object v2, p2, Lcom/poshmark/data_model/models/FeedItem;->storyType:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType;->getStoryType()Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;->LISTING_SHARE_SIFU:Lcom/poshmark/data_model/models/inner_models/FeedItemStoryType$StoryType;

    if-ne v2, v3, :cond_2

    .line 62
    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getContentOwnerImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 63
    .local v1, "ownerImageURL":Ljava/lang/String;
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    if-eqz v2, :cond_2

    if-eqz v1, :cond_2

    .line 64
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 65
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getContentOwnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    goto :goto_0

    .line 70
    .end local v1    # "ownerImageURL":Ljava/lang/String;
    :pswitch_2
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    if-eqz v2, :cond_2

    .line 71
    if-eqz v0, :cond_2

    .line 72
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {v2, v0}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 73
    iget-object v2, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    invoke-virtual {p2}, Lcom/poshmark/data_model/models/FeedItem;->getActorId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    goto :goto_0

    .line 49
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static populateImages(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
    .locals 11
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "hetroFeedListAdapter"    # Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
    .param p2, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p3, "viewHolder"    # Lcom/poshmark/utils/view_holders/FeedItemViewHolder;

    .prologue
    const/16 v10, 0x8

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 83
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$3;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    iget-object v6, p2, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v6, v6, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/FeedItemImageLayout;->getCurrentLayout()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 86
    :pswitch_0
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 87
    .local v1, "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v7, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 88
    iget-object v4, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 89
    .local v4, "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    const-class v5, Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {p2, v7, v5}, Lcom/poshmark/data_model/models/FeedItem;->getContentFromIndex(ILjava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSocial;

    .line 90
    .local v2, "listing":Lcom/poshmark/data_model/models/ListingSocial;
    if-eqz v2, :cond_3

    .line 91
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v3

    .line 92
    .local v3, "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    sget-object v5, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-eq v3, v5, :cond_1

    sget-object v5, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v3, v5, :cond_2

    .line 93
    :cond_1
    invoke-virtual {v4, v7}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    .line 94
    invoke-virtual {v4, v3}, Lcom/poshmark/ui/customviews/ListingStatusView;->setListingStatus(Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;)V

    .line 95
    invoke-virtual {v4}, Lcom/poshmark/ui/customviews/ListingStatusView;->bringToFront()V

    goto :goto_0

    .line 97
    :cond_2
    if-eqz v4, :cond_0

    .line 98
    invoke-virtual {v4, v10}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    goto :goto_0

    .line 102
    .end local v3    # "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    :cond_3
    if-eqz v4, :cond_0

    .line 103
    invoke-virtual {v4, v10}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    goto :goto_0

    .line 109
    .end local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    .end local v2    # "listing":Lcom/poshmark/data_model/models/ListingSocial;
    .end local v4    # "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    :pswitch_1
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 110
    .restart local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->LARGE:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v7, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 113
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 114
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v8, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 117
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 118
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v9, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    goto :goto_0

    .line 122
    .end local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    :pswitch_2
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 123
    .restart local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v7, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 126
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 127
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v8, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 130
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 131
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v9, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 134
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall3:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 135
    const/4 v5, 0x3

    sget-object v6, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v5, v6}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    goto :goto_0

    .line 140
    .end local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    :pswitch_3
    iget-object v1, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 141
    .restart local v1    # "covershot":Lcom/poshmark/ui/customviews/PMClickableImageView;
    sget-object v5, Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;->SMALL:Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    invoke-static {v1, p2, v7, v5}, Lcom/poshmark/utils/FeedItemPopulator;->updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V

    .line 142
    invoke-virtual {p2, v7}, Lcom/poshmark/data_model/models/FeedItem;->getContentStringFromIndex(I)Ljava/lang/String;

    move-result-object v0

    .line 143
    .local v0, "contentString":Ljava/lang/String;
    iget-object v5, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->poshPostTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v5, p2}, Lcom/poshmark/ui/customviews/PMTextView;->setTag(Ljava/lang/Object;)V

    .line 144
    iget-object v5, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->poshPostTextView:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setTitleWithHtmlString(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    iget-object v5, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->poshPostTextView:Lcom/poshmark/ui/customviews/PMTextView;

    new-instance v6, Lcom/poshmark/utils/FeedItemPopulator$1;

    invoke-direct {v6}, Lcom/poshmark/utils/FeedItemPopulator$1;-><init>()V

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 161
    iget-object v5, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->motherContainer:Landroid/view/View;

    invoke-virtual {v5, p2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 162
    iget-object v5, p3, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->motherContainer:Landroid/view/View;

    new-instance v6, Lcom/poshmark/utils/FeedItemPopulator$2;

    invoke-direct {v6}, Lcom/poshmark/utils/FeedItemPopulator$2;-><init>()V

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 83
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static updateCovershotOfFeedItemAtIndex(Lcom/poshmark/ui/customviews/PMClickableImageView;Lcom/poshmark/data_model/models/FeedItem;ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)V
    .locals 9
    .param p0, "covershot"    # Lcom/poshmark/ui/customviews/PMClickableImageView;
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p2, "index"    # I
    .param p3, "size"    # Lcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;

    .prologue
    const/4 v8, 0x0

    .line 372
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 373
    .local v0, "b":Landroid/os/Bundle;
    invoke-virtual {p1, p2}, Lcom/poshmark/data_model/models/FeedItem;->getContentIdFromIndex(I)Ljava/lang/String;

    move-result-object v3

    .line 374
    .local v3, "id":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 375
    const-string v6, "ID"

    invoke-virtual {v0, v6, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 384
    :cond_0
    :goto_0
    invoke-virtual {p1, p2, p3}, Lcom/poshmark/data_model/models/FeedItem;->getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;

    move-result-object v2

    .line 385
    .local v2, "coverShotUrl":Ljava/lang/String;
    invoke-virtual {p1, p2}, Lcom/poshmark/data_model/models/FeedItem;->getContentStringFromIndex(I)Ljava/lang/String;

    move-result-object v1

    .line 388
    .local v1, "contentString":Ljava/lang/String;
    invoke-virtual {p0, v8}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBackgroundColor(I)V

    .line 389
    invoke-virtual {p0, v8, v8, v8, v8}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setPadding(IIII)V

    .line 391
    iget-object v6, p1, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v6, v6, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v7, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Post:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v6, v7, :cond_3

    .line 392
    const-class v6, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setDestinationFragment(Ljava/lang/Class;)V

    .line 393
    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getImageURL()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 394
    invoke-virtual {p1, p2, p3}, Lcom/poshmark/data_model/models/FeedItem;->getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImage(Ljava/lang/String;)V

    .line 428
    :cond_1
    :goto_1
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBundle(Landroid/os/Bundle;)V

    .line 429
    return-void

    .line 378
    .end local v1    # "contentString":Ljava/lang/String;
    .end local v2    # "coverShotUrl":Ljava/lang/String;
    :cond_2
    iget-object v6, p1, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v6, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/PoshmarkPost;

    .line 379
    .local v5, "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    iget-object v6, v5, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    if-eqz v6, :cond_0

    iget-object v6, v5, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    iget-object v6, v6, Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;->url:Ljava/lang/String;

    if-eqz v6, :cond_0

    .line 380
    const-string v6, "DEEP_LINK"

    iget-object v7, v5, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    iget-object v7, v7, Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;->url:Ljava/lang/String;

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 397
    .end local v5    # "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    .restart local v1    # "contentString":Ljava/lang/String;
    .restart local v2    # "coverShotUrl":Ljava/lang/String;
    :cond_3
    iget-object v6, p1, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v6, v6, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v7, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->User:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v6, v7, :cond_5

    .line 398
    const-class v6, Lcom/poshmark/ui/fragments/ClosetFragment;

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setDestinationFragment(Ljava/lang/Class;)V

    .line 399
    if-eqz v2, :cond_4

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getImageURL()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 400
    invoke-virtual {p1, p2, p3}, Lcom/poshmark/data_model/models/FeedItem;->getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImage(Ljava/lang/String;)V

    .line 402
    :cond_4
    if-eqz v1, :cond_1

    .line 403
    const/4 v6, 0x1

    invoke-virtual {p0, v1, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImageWithString(Ljava/lang/String;Z)V

    goto :goto_1

    .line 405
    :cond_5
    iget-object v6, p1, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v6, v6, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v7, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->Brand:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v6, v7, :cond_8

    .line 406
    const-string v6, "MODE"

    sget-object v7, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    invoke-virtual {v7}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    const-class v6, Lcom/poshmark/ui/fragments/BrandFragment;

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setDestinationFragment(Ljava/lang/Class;)V

    .line 408
    if-eqz v2, :cond_7

    .line 409
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getImageURL()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_6

    .line 410
    invoke-virtual {p1, p2, p3}, Lcom/poshmark/data_model/models/FeedItem;->getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImage(Ljava/lang/String;)V

    .line 413
    :cond_6
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    const/high16 v7, 0x3f000000    # 0.5f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v4, v6

    .line 414
    .local v4, "padding":I
    invoke-virtual {p0, v4, v4, v4, v4}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setPadding(IIII)V

    .line 415
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f090016

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->setBackgroundColor(I)V

    goto/16 :goto_1

    .line 418
    .end local v4    # "padding":I
    :cond_7
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->resetImageUrl()V

    .line 419
    if-eqz v1, :cond_1

    .line 420
    invoke-virtual {p0, v1, v8}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImageWithString(Ljava/lang/String;Z)V

    goto/16 :goto_1

    .line 423
    :cond_8
    iget-object v6, p1, Lcom/poshmark/data_model/models/FeedItem;->contentType:Lcom/poshmark/data_model/models/FeedItemContentType;

    iget-object v6, v6, Lcom/poshmark/data_model/models/FeedItemContentType;->type:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    sget-object v7, Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;->PoshmarkPost:Lcom/poshmark/data_model/models/FeedItemContentType$ContentType;

    if-ne v6, v7, :cond_1

    .line 424
    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMClickableImageView;->getImageURL()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 425
    invoke-virtual {p1, p2, p3}, Lcom/poshmark/data_model/models/FeedItem;->getContentImageUrlFromIndex(ILcom/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6}, Lcom/poshmark/ui/customviews/PMClickableImageView;->loadImage(Ljava/lang/String;)V

    goto/16 :goto_1
.end method
