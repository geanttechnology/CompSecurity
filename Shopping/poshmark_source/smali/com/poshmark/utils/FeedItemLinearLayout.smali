.class public Lcom/poshmark/utils/FeedItemLinearLayout;
.super Landroid/widget/LinearLayout;
.source "FeedItemLinearLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/FeedItemLinearLayout$5;
    }
.end annotation


# instance fields
.field commentButtonListener:Landroid/view/View$OnClickListener;

.field footerClickListener:Landroid/view/View$OnClickListener;

.field likeButtonListener:Landroid/view/View$OnClickListener;

.field shareButtonListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 70
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$1;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->commentButtonListener:Landroid/view/View$OnClickListener;

    .line 81
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$2;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$2;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->likeButtonListener:Landroid/view/View$OnClickListener;

    .line 106
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$3;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$3;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->shareButtonListener:Landroid/view/View$OnClickListener;

    .line 146
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$4;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$4;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->footerClickListener:Landroid/view/View$OnClickListener;

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 45
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 70
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$1;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$1;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->commentButtonListener:Landroid/view/View$OnClickListener;

    .line 81
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$2;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$2;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->likeButtonListener:Landroid/view/View$OnClickListener;

    .line 106
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$3;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$3;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->shareButtonListener:Landroid/view/View$OnClickListener;

    .line 146
    new-instance v0, Lcom/poshmark/utils/FeedItemLinearLayout$4;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/FeedItemLinearLayout$4;-><init>(Lcom/poshmark/utils/FeedItemLinearLayout;)V

    iput-object v0, p0, Lcom/poshmark/utils/FeedItemLinearLayout;->footerClickListener:Landroid/view/View$OnClickListener;

    .line 46
    return-void
.end method


# virtual methods
.method public populateViewHolder(Lcom/poshmark/utils/view_holders/ListingViewHolder;)V
    .locals 3
    .param p1, "viewHolder"    # Lcom/poshmark/utils/view_holders/ListingViewHolder;

    .prologue
    .line 50
    const v2, 0x7f0c010f

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/FeedItemLinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->topBorder:Landroid/view/View;

    .line 53
    const v2, 0x7f0c0110

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/FeedItemLinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 54
    .local v0, "listingHeaderLayout":Landroid/widget/LinearLayout;
    const v2, 0x7f0c011b

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 56
    const v2, 0x7f0c01cd

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->userNameView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 57
    const v2, 0x7f0c011a

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->headerTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 58
    const v2, 0x7f0c011c

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->attributionView:Landroid/widget/TextView;

    .line 61
    const v2, 0x7f0c0111

    invoke-virtual {p0, v2}, Lcom/poshmark/utils/FeedItemLinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 62
    .local v1, "listingOverviewLayout":Landroid/widget/LinearLayout;
    const v2, 0x7f0c0121

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCovershotImageView;

    iput-object v2, p1, Lcom/poshmark/utils/view_holders/ListingViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMCovershotImageView;

    .line 67
    return-void
.end method
