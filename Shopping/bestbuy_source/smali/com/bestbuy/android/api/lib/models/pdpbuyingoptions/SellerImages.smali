.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private height:I

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
.method public getHeight()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->height:I

    return v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->width:I

    return v0
.end method

.method public setHeight(I)V
    .locals 0

    .prologue
    .line 23
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->height:I

    .line 24
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->url:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setWidth(I)V
    .locals 0

    .prologue
    .line 39
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->width:I

    .line 40
    return-void
.end method
