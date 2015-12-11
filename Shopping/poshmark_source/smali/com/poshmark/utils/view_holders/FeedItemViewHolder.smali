.class public Lcom/poshmark/utils/view_holders/FeedItemViewHolder;
.super Ljava/lang/Object;
.source "FeedItemViewHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/view_holders/FeedItemViewHolder$1;
    }
.end annotation


# instance fields
.field public allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

.field public attributionView:Landroid/widget/TextView;

.field public avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

.field public brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

.field public categoryView:Landroid/widget/ImageView;

.field public comment1:Lcom/poshmark/ui/customviews/PMTextView;

.field public comment2:Lcom/poshmark/ui/customviews/PMTextView;

.field public commentButton:Landroid/widget/Button;

.field public commentLayout1:Landroid/widget/LinearLayout;

.field public commentLayout2:Landroid/widget/LinearLayout;

.field public commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

.field public commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

.field public commentsCount:Landroid/widget/TextView;

.field public coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

.field public coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMClickableImageView;

.field public coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMClickableImageView;

.field public coverShotViewSmall3:Lcom/poshmark/ui/customviews/PMClickableImageView;

.field public descriptionView:Landroid/widget/TextView;

.field public footerLayout:Landroid/view/View;

.field public footerTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field public headerIconView:Landroid/widget/ImageView;

.field public headerTitleView:Lcom/poshmark/ui/customviews/PMTextView;

.field public likeButton:Landroid/widget/Button;

.field public likesCount:Landroid/widget/TextView;

.field public likesLayout:Landroid/widget/LinearLayout;

.field public likesView:Lcom/poshmark/ui/customviews/PMTextView;

.field public motherContainer:Landroid/view/View;

.field public nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

.field public originalPriceView:Landroid/widget/TextView;

.field public poshPostTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field public priceView:Landroid/widget/TextView;

.field public shareButton:Landroid/widget/Button;

.field public sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

.field public statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

.field public titleView:Landroid/widget/TextView;

.field public topBorder:Landroid/view/View;

.field public usernameTextView:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 119
    return-void
.end method


# virtual methods
.method public populateViewHolderWithFooterViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V
    .locals 8
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p2, "container"    # Landroid/view/View;

    .prologue
    const/high16 v7, 0x41200000    # 10.0f

    const v6, 0x7f0c0171

    const v5, 0x7f0c016f

    const/high16 v4, 0x41500000    # 13.0f

    const/4 v3, 0x2

    .line 127
    iput-object p2, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->footerLayout:Landroid/view/View;

    .line 129
    sget-object v1, Lcom/poshmark/utils/view_holders/FeedItemViewHolder$1;->$SwitchMap$com$poshmark$data_model$models$inner_models$FeedItemFooterLayout$Layout:[I

    iget-object v2, p1, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->footerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 224
    :goto_0
    return-void

    .line 131
    :pswitch_0
    const v1, 0x7f0c011d

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->footerTextView:Lcom/poshmark/ui/customviews/PMTextView;

    goto :goto_0

    .line 135
    :pswitch_1
    const v1, 0x7f0c0130

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->titleView:Landroid/widget/TextView;

    .line 136
    const v1, 0x7f0c007d

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 137
    const v1, 0x7f0c007f

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->priceView:Landroid/widget/TextView;

    .line 138
    const v1, 0x7f0c0080

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    .line 139
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v2

    or-int/lit8 v2, v2, 0x10

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 140
    const v1, 0x7f0c0132

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->categoryView:Landroid/widget/ImageView;

    .line 141
    const v1, 0x7f0c0081

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 142
    const v1, 0x7f0c0134

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 144
    const v1, 0x7f0c0112

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    .line 145
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0137

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesCount:Landroid/widget/TextView;

    .line 146
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0138

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentsCount:Landroid/widget/TextView;

    .line 148
    const v1, 0x7f0c0116

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 149
    .local v0, "listingActions":Landroid/widget/LinearLayout;
    const v1, 0x7f0c0045

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    .line 150
    const v1, 0x7f0c0168

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    .line 151
    const v1, 0x7f0c0046

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    .line 153
    const v1, 0x7f0c0113

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    .line 154
    const v1, 0x7f0c0114

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    .line 156
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 157
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 159
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    .line 161
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    .line 163
    const v1, 0x7f0c0115

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 166
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v7}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 167
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v4}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 168
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v4}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    goto/16 :goto_0

    .line 178
    .end local v0    # "listingActions":Landroid/widget/LinearLayout;
    :pswitch_2
    const v1, 0x7f0c0130

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->titleView:Landroid/widget/TextView;

    .line 179
    const v1, 0x7f0c007d

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 180
    const v1, 0x7f0c007f

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->priceView:Landroid/widget/TextView;

    .line 181
    const v1, 0x7f0c0080

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    .line 182
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->originalPriceView:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v2

    or-int/lit8 v2, v2, 0x10

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 183
    const v1, 0x7f0c0132

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->categoryView:Landroid/widget/ImageView;

    .line 184
    const v1, 0x7f0c0081

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 185
    const v1, 0x7f0c0134

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 187
    const v1, 0x7f0c0135

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->descriptionView:Landroid/widget/TextView;

    .line 188
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->descriptionView:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setMaxLines(I)V

    .line 189
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->descriptionView:Landroid/widget/TextView;

    sget-object v2, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 192
    const v1, 0x7f0c0112

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    .line 193
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesLayout:Landroid/widget/LinearLayout;

    const v2, 0x7f0c01d2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likesView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 195
    const v1, 0x7f0c0116

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 196
    .restart local v0    # "listingActions":Landroid/widget/LinearLayout;
    const v1, 0x7f0c0045

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->likeButton:Landroid/widget/Button;

    .line 197
    const v1, 0x7f0c0168

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentButton:Landroid/widget/Button;

    .line 198
    const v1, 0x7f0c0046

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->shareButton:Landroid/widget/Button;

    .line 200
    const v1, 0x7f0c0113

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    .line 201
    const v1, 0x7f0c0114

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    .line 203
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar1:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 204
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commenterAvataar2:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 206
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout1:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment1:Lcom/poshmark/ui/customviews/PMTextView;

    .line 208
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->commentLayout2:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->comment2:Lcom/poshmark/ui/customviews/PMTextView;

    .line 210
    const v1, 0x7f0c0115

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->allCommentsView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 213
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->nwtTextView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v7}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 214
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->sizeView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v4}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 215
    iget-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->brandView:Lcom/poshmark/ui/customviews/SearchFilterTextView;

    invoke-virtual {v1, v3, v4}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    goto/16 :goto_0

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public populateViewHolderWithHeaderViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V
    .locals 3
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p2, "container"    # Landroid/view/View;

    .prologue
    .line 83
    move-object v0, p2

    check-cast v0, Landroid/widget/LinearLayout;

    .line 84
    .local v0, "feedItemHeaderLayout":Landroid/widget/LinearLayout;
    const v1, 0x7f0c011b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->avataarView:Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 85
    const v1, 0x7f0c011a

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->headerTitleView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 86
    const v1, 0x7f0c011c

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->attributionView:Landroid/widget/TextView;

    .line 88
    iget-object v1, p1, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->headerLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout;->currentLayout:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;->DOUBLE_LEVEL_HEADER:Lcom/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout;

    if-ne v1, v2, :cond_0

    .line 89
    const v1, 0x7f0c0119

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->headerIconView:Landroid/widget/ImageView;

    .line 90
    const v1, 0x7f0c0058

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v1, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->usernameTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 92
    :cond_0
    return-void
.end method

.method public populateViewHolderWithImageViews(Lcom/poshmark/data_model/models/FeedItem;Landroid/view/View;)V
    .locals 5
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/FeedItem;
    .param p2, "container"    # Landroid/view/View;

    .prologue
    const v4, 0x7f0c0123

    const v3, 0x7f0c0122

    const v2, 0x7f0c0121

    .line 96
    sget-object v0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder$1;->$SwitchMap$com$poshmark$data_model$models$FeedItemImageLayout$Layout:[I

    iget-object v1, p1, Lcom/poshmark/data_model/models/FeedItem;->layoutInfo:Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/FeedItemLayoutInfo;->imageLayout:Lcom/poshmark/data_model/models/FeedItemImageLayout;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout;->getCurrentLayout()Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/FeedItemImageLayout$Layout;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 123
    :goto_0
    iput-object p2, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->motherContainer:Landroid/view/View;

    .line 124
    return-void

    .line 100
    :pswitch_0
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 101
    const v0, 0x7f0c0127

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/ListingStatusView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->statusView:Lcom/poshmark/ui/customviews/ListingStatusView;

    goto :goto_0

    .line 105
    :pswitch_1
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 106
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 107
    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 108
    const v0, 0x7f0c0125

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall3:Lcom/poshmark/ui/customviews/PMClickableImageView;

    goto :goto_0

    .line 112
    :pswitch_2
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 113
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall1:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 114
    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewSmall2:Lcom/poshmark/ui/customviews/PMClickableImageView;

    goto :goto_0

    .line 118
    :pswitch_3
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMClickableImageView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->coverShotViewBig:Lcom/poshmark/ui/customviews/PMClickableImageView;

    .line 119
    const v0, 0x7f0c0129

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v0, p0, Lcom/poshmark/utils/view_holders/FeedItemViewHolder;->poshPostTextView:Lcom/poshmark/ui/customviews/PMTextView;

    goto :goto_0

    .line 96
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
