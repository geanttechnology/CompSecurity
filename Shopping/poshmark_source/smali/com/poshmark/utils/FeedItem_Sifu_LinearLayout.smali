.class public Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;
.super Lcom/poshmark/utils/FeedItemLinearLayout;
.source "FeedItem_Sifu_LinearLayout.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/FeedItemLinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/utils/FeedItemLinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    return-void
.end method


# virtual methods
.method public populateViewHolder(Lcom/poshmark/utils/view_holders/ListingViewHolder;)V
    .locals 9
    .param p1, "viewHolder"    # Lcom/poshmark/utils/view_holders/ListingViewHolder;

    .prologue
    const v8, 0x7f0c0171

    const v7, 0x7f0c016f

    const/high16 v6, 0x41500000    # 13.0f

    const/4 v5, 0x2

    .line 34
    invoke-super {p0, p1}, Lcom/poshmark/utils/FeedItemLinearLayout;->populateViewHolder(Lcom/poshmark/utils/view_holders/ListingViewHolder;)V

    .line 37
    const v3, 0x7f0c0111

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 38
    .local v2, "listingOverviewLayout":Landroid/widget/LinearLayout;
    const v3, 0x7f0c0127

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/ListingStatusView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 41
    const v3, 0x7f0c012c

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 43
    .local v0, "footerLayout":Landroid/widget/LinearLayout;
    const v3, 0x7f0c0130

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->titleView:Landroid/widget/TextView;

    .line 44
    const v3, 0x7f0c007d

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 45
    const v3, 0x7f0c007f

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->priceView:Landroid/widget/TextView;

    .line 46
    const v3, 0x7f0c0080

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    .line 47
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    iget-object v4, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v4

    or-int/lit8 v4, v4, 0x10

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 48
    const v3, 0x7f0c0132

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->categoryView:Landroid/widget/ImageView;

    .line 49
    const v3, 0x7f0c0081

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 50
    const v3, 0x7f0c0134

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 52
    const v3, 0x7f0c0112

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    .line 53
    iget v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->resourceId:I

    const v4, 0x7f03004c

    if-ne v3, v4, :cond_0

    .line 54
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0137

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesCount:Landroid/widget/TextView;

    .line 55
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0138

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentsCount:Landroid/widget/TextView;

    .line 58
    :cond_0
    const v3, 0x7f0c0116

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 59
    .local v1, "listingActions":Landroid/widget/LinearLayout;
    const v3, 0x7f0c0045

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    .line 60
    const v3, 0x7f0c0168

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentButton:Landroid/widget/Button;

    .line 61
    const v3, 0x7f0c0046

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->shareButton:Landroid/widget/Button;

    .line 63
    const v3, 0x7f0c0113

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    .line 64
    const v3, 0x7f0c0114

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    .line 66
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 67
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 69
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    .line 71
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    .line 73
    const v3, 0x7f0c0115

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 76
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    const/high16 v4, 0x41200000    # 10.0f

    invoke-virtual {v3, v5, v4}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 77
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v3, v5, v6}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 78
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v3, v5, v6}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 81
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->commentButton:Landroid/widget/Button;

    iget-object v4, p0, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->commentButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 82
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->likeButton:Landroid/widget/Button;

    iget-object v4, p0, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->likeButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    iget-object v3, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->shareButton:Landroid/widget/Button;

    iget-object v4, p0, Lcom/poshmark/utils/FeedItem_Sifu_LinearLayout;->shareButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 86
    return-void
.end method
