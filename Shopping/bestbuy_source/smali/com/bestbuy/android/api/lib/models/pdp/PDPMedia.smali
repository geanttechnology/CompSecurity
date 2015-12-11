.class public Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private backImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

.field private galleryImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;",
            ">;"
        }
    .end annotation
.end field

.field private primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBackImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->backImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    return-object v0
.end method

.method public getGalleryImages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->galleryImages:Ljava/util/List;

    return-object v0
.end method

.method public getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    return-object v0
.end method

.method public setBackImage(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->backImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    .line 41
    return-void
.end method

.method public setGalleryImages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->galleryImages:Ljava/util/List;

    .line 25
    return-void
.end method

.method public setPrimaryImage(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->primaryImage:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    .line 33
    return-void
.end method
