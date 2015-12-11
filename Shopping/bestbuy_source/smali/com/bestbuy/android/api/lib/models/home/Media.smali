.class public Lcom/bestbuy/android/api/lib/models/home/Media;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x32cd159ce399eeabL


# instance fields
.field private listImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

.field private primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

.field private thumbnailImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getListImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->listImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    return-object v0
.end method

.method public getPrimaryImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    return-object v0
.end method

.method public getThumbnailImage()Lcom/bestbuy/android/api/lib/models/home/ImageType;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->thumbnailImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    return-object v0
.end method

.method public setListImage(Lcom/bestbuy/android/api/lib/models/home/ImageType;)V
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->listImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    .line 48
    return-void
.end method

.method public setPrimaryImage(Lcom/bestbuy/android/api/lib/models/home/ImageType;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->primaryImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    .line 42
    return-void
.end method

.method public setThumbnailImage(Lcom/bestbuy/android/api/lib/models/home/ImageType;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Media;->thumbnailImage:Lcom/bestbuy/android/api/lib/models/home/ImageType;

    .line 54
    return-void
.end method
