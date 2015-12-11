.class public Lcom/amazon/mShop/ui/BadgeView;
.super Landroid/widget/TextView;
.source "BadgeView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mBadgeSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 99
    new-instance v0, Lcom/amazon/mShop/ui/BadgeView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/ui/BadgeView$1;-><init>(Lcom/amazon/mShop/ui/BadgeView;)V

    iput-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    .line 39
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 40
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/ui/BadgeView;)Lcom/amazon/mShop/net/BitmapFetcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/BadgeView;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/ui/BadgeView;Lcom/amazon/mShop/net/BitmapFetcher;)Lcom/amazon/mShop/net/BitmapFetcher;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/BadgeView;
    .param p1, "x1"    # Lcom/amazon/mShop/net/BitmapFetcher;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/ui/BadgeView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/ui/BadgeView;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/ui/BadgeView;Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/ui/BadgeView;
    .param p1, "x1"    # Landroid/graphics/Bitmap;
    .param p2, "x2"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ui/BadgeView;->updateBadgeItem(Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V

    return-void
.end method

.method private cancelBadgeFetcher()V
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 142
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 144
    :cond_0
    return-void
.end method

.method private getBadgeFromBackground(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 123
    iget-object v1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_2

    .line 124
    iget-object v1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 128
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/ui/BadgeView;->cancelBadgeFetcher()V

    .line 131
    :cond_2
    if-eqz p1, :cond_0

    .line 132
    const/4 v1, 0x2

    invoke-static {v1}, Lcom/amazon/mShop/util/UIUtils;->convertDipToPixel(I)I

    move-result v0

    .line 133
    .local v0, "extraPixels":I
    new-instance v1, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {p0}, Lcom/amazon/mShop/ui/BadgeView;->getTextSize()F

    move-result v2

    float-to-int v2, v2

    add-int/2addr v2, v0

    invoke-static {p1, v2}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrlWithMaxHeight(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeSubscriber:Lcom/amazon/mShop/net/HttpFetcher$Subscriber;

    invoke-direct {v1, v2, p1, v3}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 135
    iget-object v1, p0, Lcom/amazon/mShop/ui/BadgeView;->mBadgeFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0
.end method

.method private updateBadgeItem(Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "mActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v1, 0x0

    .line 72
    if-eqz p1, :cond_0

    .line 73
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/ui/BadgeView;->setVisibility(I)V

    .line 74
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 75
    .local v0, "spanned":Landroid/text/SpannableStringBuilder;
    invoke-static {p2, p1, v0, v1}, Lcom/amazon/mShop/util/UIUtils;->setImageSpan(Lcom/amazon/mShop/AmazonActivity;Landroid/graphics/Bitmap;Landroid/text/SpannableStringBuilder;I)V

    .line 76
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ui/BadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    .end local v0    # "spanned":Landroid/text/SpannableStringBuilder;
    :cond_0
    return-void
.end method

.method private updateBadgeItem(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p1, "richMessage"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .param p2, "mActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 86
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/ui/BadgeView;->setVisibility(I)V

    .line 88
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 89
    .local v1, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v0

    .line 90
    .local v0, "backgroundColor":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    .line 91
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 93
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v2

    invoke-static {p0, p2, v2, v1}, Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;Ljava/util/List;)V

    .line 94
    return-void
.end method


# virtual methods
.method public onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 148
    invoke-super {p0}, Landroid/widget/TextView;->onDetachedFromWindow()V

    .line 149
    invoke-direct {p0}, Lcom/amazon/mShop/ui/BadgeView;->cancelBadgeFetcher()V

    .line 150
    return-void
.end method

.method public update(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V
    .locals 4
    .param p1, "badge"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 46
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 47
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getImageLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 48
    .local v1, "imageUrl":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/BadgeUtils;->getCachedBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 49
    .local v0, "badgeBitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_1

    .line 51
    iget-object v2, p0, Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0, v0, v2}, Lcom/amazon/mShop/ui/BadgeView;->updateBadgeItem(Landroid/graphics/Bitmap;Lcom/amazon/mShop/AmazonActivity;)V

    .line 64
    .end local v0    # "badgeBitmap":Landroid/graphics/Bitmap;
    .end local v1    # "imageUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 55
    .restart local v0    # "badgeBitmap":Landroid/graphics/Bitmap;
    .restart local v1    # "imageUrl":Ljava/lang/String;
    :cond_1
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeDefaultHyperText(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 56
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0, v2, v3}, Lcom/amazon/mShop/ui/BadgeView;->updateBadgeItem(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V

    .line 58
    :cond_2
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->getBadgeImageUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/amazon/mShop/ui/BadgeView;->getBadgeFromBackground(Ljava/lang/String;)V

    goto :goto_0

    .line 61
    .end local v0    # "badgeBitmap":Landroid/graphics/Bitmap;
    .end local v1    # "imageUrl":Ljava/lang/String;
    :cond_3
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeDefaultHyperText(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 62
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/ui/BadgeView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0, v2, v3}, Lcom/amazon/mShop/ui/BadgeView;->updateBadgeItem(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0
.end method
