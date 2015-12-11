.class public Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
.super Lcom/comcast/cim/android/image/CimImageLoader;
.source "NetworkLogoImageLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/image/CimImageLoader",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private final entityThumbnailUrl:Ljava/lang/String;

.field private largeLogos:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private logo_large_height:I

.field private logo_large_width:I

.field private logo_small_height:I

.field private logo_small_width:I

.field final res:Landroid/content/res/Resources;

.field private smallLogos:Landroid/support/v4/util/LongSparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LongSparseArray",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;Landroid/content/Context;)V
    .locals 4
    .param p1, "entityThumbnailUrl"    # Ljava/lang/String;
    .param p4, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/github/ignition/support/images/remote/RemoteImageLoader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Lcom/github/ignition/support/cache/AbstractImageCache",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .prologue
    .line 41
    .local p2, "imageLoader":Lcom/github/ignition/support/images/remote/RemoteImageLoader;, "Lcom/github/ignition/support/images/remote/RemoteImageLoader<Landroid/graphics/Bitmap;>;"
    .local p3, "imageCache":Lcom/github/ignition/support/cache/AbstractImageCache;, "Lcom/github/ignition/support/cache/AbstractImageCache<Landroid/graphics/Bitmap;>;"
    invoke-direct {p0, p2, p3}, Lcom/comcast/cim/android/image/CimImageLoader;-><init>(Lcom/github/ignition/support/images/remote/RemoteImageLoader;Lcom/github/ignition/support/cache/AbstractImageCache;)V

    .line 42
    iput-object p1, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->entityThumbnailUrl:Ljava/lang/String;

    .line 43
    invoke-virtual {p4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    .line 45
    new-instance v0, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v0}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x5191db2eb5f4aeb9L    # 8.67216208335442E84

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallcinemax:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x4acd937245c76579L    # 2.2131362554602866E52

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallencore:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x489f141b597c9d11L    # 6.76830716255189E41

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallhbo:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x4daa5dcfd0e4a3d1L    # 1.3883557558793808E66

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallmovieplex:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x5b4aca02ef0587b1L    # 5.942187667558922E131

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallshowtime:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 51
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x767875080c061f21L    # 4.813291402491272E262

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallstarzoncomcast:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 52
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x62fb954a0c4dc881L    # 6.506113354787228E168

    sget v1, Lcom/xfinity/playerlib/R$drawable;->smallstreampix:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 54
    new-instance v0, Landroid/support/v4/util/LongSparseArray;

    invoke-direct {v0}, Landroid/support/v4/util/LongSparseArray;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x5191db2eb5f4aeb9L    # 8.67216208335442E84

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_cinemax:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x4acd937245c76579L    # 2.2131362554602866E52

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_encore:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x489f141b597c9d11L    # 6.76830716255189E41

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_hbo:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x4daa5dcfd0e4a3d1L    # 1.3883557558793808E66

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_movieplex:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 59
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x5b4aca02ef0587b1L    # 5.942187667558922E131

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_showtime:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x767875080c061f21L    # 4.813291402491272E262

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_starz:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    const-wide v2, 0x62fb954a0c4dc881L    # 6.506113354787228E168

    sget v1, Lcom/xfinity/playerlib/R$drawable;->prem_streampix:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v3, v1}, Landroid/support/v4/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    sget v1, Lcom/xfinity/playerlib/R$dimen;->network_logo_small_src_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_width:I

    .line 64
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    sget v1, Lcom/xfinity/playerlib/R$dimen;->network_logo_small_src_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_height:I

    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    sget v1, Lcom/xfinity/playerlib/R$dimen;->network_logo_large_src_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_width:I

    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    sget v1, Lcom/xfinity/playerlib/R$dimen;->network_logo_large_src_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_height:I

    .line 68
    return-void
.end method

.method private getLogoUrl(JII)Ljava/lang/String;
    .locals 5
    .param p1, "companyId"    # J
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 115
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v1, "%s/Network-%d/%d/%d"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->entityThumbnailUrl:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public loadNetworkLogoLarge(JLandroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    .locals 5
    .param p1, "companyId"    # J
    .param p3, "view"    # Landroid/widget/ImageView;
    .param p4, "dummyDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p5, "errorDrawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 94
    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->indexOfKey(J)I

    move-result v2

    if-ltz v2, :cond_0

    .line 95
    iget-object v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 96
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 101
    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-void

    .line 98
    :cond_0
    iget v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_width:I

    iget v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_height:I

    invoke-direct {p0, p1, p2, v2, v3}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->getLogoUrl(JII)Ljava/lang/String;

    move-result-object v1

    .line 99
    .local v1, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v1, p3, p4, p5}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public loadNetworkLogoLarge(Lcom/xfinity/playerlib/model/tags/Network;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V
    .locals 7
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p2, "view"    # Landroid/widget/ImageView;
    .param p3, "onLoadListener"    # Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;

    .prologue
    const/4 v6, 0x0

    .line 81
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v0

    .line 83
    .local v0, "companyId":J
    iget-object v4, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v4, v0, v1}, Landroid/support/v4/util/LongSparseArray;->indexOfKey(J)I

    move-result v4

    if-ltz v4, :cond_0

    .line 84
    iget-object v5, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    iget-object v4, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->largeLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v4, v0, v1}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v5, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 85
    .local v2, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p2, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 86
    invoke-interface {p3, p2, v6, v6}, Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;->onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 91
    .end local v2    # "d":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-void

    .line 88
    :cond_0
    iget v4, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_width:I

    iget v5, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_large_height:I

    invoke-direct {p0, v0, v1, v4, v5}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->getLogoUrl(JII)Ljava/lang/String;

    move-result-object v3

    .line 89
    .local v3, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v3, p2, p3}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto :goto_0
.end method

.method public loadNetworkLogoSmall(JLandroid/widget/ImageView;)V
    .locals 5
    .param p1, "companyId"    # J
    .param p3, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 71
    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->indexOfKey(J)I

    move-result v2

    if-ltz v2, :cond_0

    .line 72
    iget-object v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 73
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 78
    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-void

    .line 75
    :cond_0
    iget v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_width:I

    iget v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_height:I

    invoke-direct {p0, p1, p2, v2, v3}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->getLogoUrl(JII)Ljava/lang/String;

    move-result-object v1

    .line 76
    .local v1, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v1, p3}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto :goto_0
.end method

.method public loadNetworkLogoSmall(JLandroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)V
    .locals 5
    .param p1, "companyId"    # J
    .param p3, "view"    # Landroid/widget/ImageView;
    .param p4, "dummyDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p5, "errorDrawable"    # Landroid/graphics/drawable/Drawable;
    .param p6, "useLogoCache"    # Z

    .prologue
    .line 105
    if-eqz p6, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->indexOfKey(J)I

    move-result v2

    if-ltz v2, :cond_0

    .line 106
    iget-object v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->res:Landroid/content/res/Resources;

    iget-object v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->smallLogos:Landroid/support/v4/util/LongSparseArray;

    invoke-virtual {v2, p1, p2}, Landroid/support/v4/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v3, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 107
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p3, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 112
    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    :goto_0
    return-void

    .line 109
    :cond_0
    iget v2, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_width:I

    iget v3, p0, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->logo_small_height:I

    invoke-direct {p0, p1, p2, v2, v3}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->getLogoUrl(JII)Ljava/lang/String;

    move-result-object v1

    .line 110
    .local v1, "imageUrl":Ljava/lang/String;
    invoke-virtual {p0, v1, p3, p4, p5}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method
