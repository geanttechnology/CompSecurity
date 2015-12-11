.class public Lcom/bestbuy/android/api/lib/models/home/OfferImage;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x1b278e6e75ada261L


# instance fields
.field private altText:Ljava/lang/String;

.field private aspectRatio:D

.field private height:J

.field private path:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private width:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getAspectRatio()D
    .locals 2

    .prologue
    .line 26
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->aspectRatio:D

    return-wide v0
.end method

.method public getHeight()J
    .locals 2

    .prologue
    .line 32
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->height:J

    return-wide v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()J
    .locals 2

    .prologue
    .line 56
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->width:J

    return-wide v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->altText:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setAspectRatio(D)V
    .locals 1

    .prologue
    .line 62
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->aspectRatio:D

    .line 63
    return-void
.end method

.method public setHeight(J)V
    .locals 1

    .prologue
    .line 68
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->height:J

    .line 69
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->path:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->url:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setWidth(J)V
    .locals 1

    .prologue
    .line 92
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->width:J

    .line 93
    return-void
.end method
