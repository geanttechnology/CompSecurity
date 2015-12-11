.class public Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
.super Lcom/amazon/mShop/net/HttpFetcher$Params;
.source "BitmapFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/BitmapFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BitmapFetcherParams"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/net/HttpFetcher$Params",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# static fields
.field private static final sServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;


# instance fields
.field private mBaseUrl:Ljava/lang/String;

.field private mMaxDimension:I

.field protected mResidencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field protected mUseDiskCache:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 134
    new-instance v0, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v1, "images"

    const-string/jumbo v2, "getImages"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->sServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 0
    .param p1, "fullUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 93
    .local p2, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/net/HttpFetcher$Params;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 94
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;)V
    .locals 7
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p3, "maxDimension"    # I
    .param p4, "tag"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;I",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 97
    .local p2, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V

    .line 98
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;ILjava/lang/Object;ZLcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)V
    .locals 1
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p3, "maxDimension"    # I
    .param p4, "tag"    # Ljava/lang/Object;
    .param p5, "useDiskCache"    # Z
    .param p6, "p"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;I",
            "Ljava/lang/Object;",
            "Z",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
            ")V"
        }
    .end annotation

    .prologue
    .line 114
    .local p2, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0, p2, p4}, Lcom/amazon/mShop/net/HttpFetcher$Params;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;Ljava/lang/Object;)V

    .line 115
    iput p3, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mMaxDimension:I

    .line 116
    iput-object p1, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mBaseUrl:Ljava/lang/String;

    .line 117
    iput-boolean p5, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mUseDiskCache:Z

    .line 118
    iput-object p6, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mResidencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .line 119
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V
    .locals 0
    .param p1, "fullUrl"    # Ljava/lang/String;
    .param p2, "baseUrl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p3, "subscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p1, p3}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 89
    iput-object p2, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mBaseUrl:Ljava/lang/String;

    .line 90
    return-void
.end method


# virtual methods
.method public getBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mBaseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxDimension()I
    .locals 1

    .prologue
    .line 158
    iget v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mMaxDimension:I

    return v0
.end method

.method public getResidencePriority()Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mResidencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    return-object v0
.end method

.method public getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;
    .locals 1

    .prologue
    .line 138
    sget-object v0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->sServiceCallIdentifier:Lcom/amazon/mShop/net/ServiceCallIdentifier;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mUrl:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 128
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mBaseUrl:Ljava/lang/String;

    iget v1, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mMaxDimension:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mUrl:Ljava/lang/String;

    .line 130
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public useDiskCache()Z
    .locals 1

    .prologue
    .line 154
    iget-boolean v0, p0, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->mUseDiskCache:Z

    return v0
.end method
