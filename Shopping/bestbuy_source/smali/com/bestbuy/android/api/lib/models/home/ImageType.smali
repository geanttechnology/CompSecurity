.class public Lcom/bestbuy/android/api/lib/models/home/ImageType;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x381fcb57eaf80e9bL


# instance fields
.field private altText:Ljava/lang/String;

.field private aspectRatio:F

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
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->altText:Ljava/lang/String;

    return-object v0
.end method

.method public getAspectRatio()F
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->aspectRatio:F

    return v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->height:I

    return v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->path:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->width:I

    return v0
.end method

.method public setAltText(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->altText:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setAspectRatio(F)V
    .locals 0

    .prologue
    .line 63
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->aspectRatio:F

    .line 64
    return-void
.end method

.method public setHeight(I)V
    .locals 0

    .prologue
    .line 69
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->height:I

    .line 70
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->path:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->url:Ljava/lang/String;

    .line 82
    return-void
.end method

.method public setWidth(I)V
    .locals 0

    .prologue
    .line 93
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/home/ImageType;->width:I

    .line 94
    return-void
.end method
