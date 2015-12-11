.class public Lcom/poshmark/utils/FeedItem_Mifu_3_Left_LinearLayout;
.super Lcom/poshmark/utils/FeedItemLinearLayout;
.source "FeedItem_Mifu_3_Left_LinearLayout.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/FeedItemLinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Lcom/poshmark/utils/FeedItemLinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 25
    return-void
.end method


# virtual methods
.method public populateViewHolder(Lcom/poshmark/utils/view_holders/ListingViewHolder;)V
    .locals 4
    .param p1, "viewHolder"    # Lcom/poshmark/utils/view_holders/ListingViewHolder;

    .prologue
    .line 29
    invoke-super {p0, p1}, Lcom/poshmark/utils/FeedItemLinearLayout;->populateViewHolder(Lcom/poshmark/utils/view_holders/ListingViewHolder;)V

    .line 30
    const v2, 0x7f0c0111

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/FeedItem_Mifu_3_Left_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 31
    .local v1, "listingOverviewLayout":Landroid/widget/LinearLayout;
    const v2, 0x7f0c0122

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 32
    const v2, 0x7f0c0123

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 34
    const v2, 0x7f0c012c

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/FeedItem_Mifu_3_Left_LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 35
    .local v0, "footerLayout":Landroid/widget/RelativeLayout;
    iput-object v0, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->footerLayout:Landroid/widget/RelativeLayout;

    .line 36
    const v2, 0x7f0c011d

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->footerTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 37
    iget-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->footerLayout:Landroid/widget/RelativeLayout;

    iget-object v3, p0, Lcom/poshmark/utils/FeedItem_Mifu_3_Left_LinearLayout;->footerClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    return-void
.end method
