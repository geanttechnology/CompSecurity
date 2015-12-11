.class public Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;
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
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAltText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getAspectRatio()D
    .locals 2

    .prologue
    .line 22
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->aspectRatio:D

    return-wide v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->height:I

    return v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 38
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->width:I

    return v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->altText:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setAspectRatio(D)V
    .locals 1

    .prologue
    .line 26
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->aspectRatio:D

    .line 27
    return-void
.end method

.method public setHeight(I)V
    .locals 0

    .prologue
    .line 34
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->height:I

    .line 35
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->path:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->url:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setWidth(I)V
    .locals 0

    .prologue
    .line 42
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundlePrimaryImage;->width:I

    .line 43
    return-void
.end method
