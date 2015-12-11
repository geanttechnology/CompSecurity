.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private listImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

.field private primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

.field private thumbnailImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->listImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    return-object v0
.end method

.method public getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    return-object v0
.end method

.method public getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->thumbnailImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    return-object v0
.end method

.method public setListImage(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->listImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    .line 59
    return-void
.end method

.method public setPrimaryImage(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    .line 52
    return-void
.end method

.method public setThumbnailImage(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->thumbnailImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    .line 66
    return-void
.end method
