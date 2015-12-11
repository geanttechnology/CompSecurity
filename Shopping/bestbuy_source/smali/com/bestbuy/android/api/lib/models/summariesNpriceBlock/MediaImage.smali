.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private altText:Ljava/lang/String;

.field private aspectRatio:D

.field private height:I

.field private path:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private width:I


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
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getAspectRatio()D
    .locals 2

    .prologue
    .line 29
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->aspectRatio:D

    return-wide v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->height:I

    return v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 59
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->width:I

    return v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->altText:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setAspectRatio(D)V
    .locals 1

    .prologue
    .line 65
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->aspectRatio:D

    .line 66
    return-void
.end method

.method public setHeight(I)V
    .locals 0

    .prologue
    .line 71
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->height:I

    .line 72
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->path:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->url:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public setWidth(I)V
    .locals 0

    .prologue
    .line 95
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->width:I

    .line 96
    return-void
.end method
