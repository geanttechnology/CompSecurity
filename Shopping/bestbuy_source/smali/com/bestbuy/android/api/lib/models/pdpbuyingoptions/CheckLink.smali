.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private height:I

.field private target:Ljava/lang/String;

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
    .line 20
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->height:I

    return v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->url:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 44
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->width:I

    return v0
.end method

.method public setHeight(I)V
    .locals 0

    .prologue
    .line 24
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->height:I

    .line 25
    return-void
.end method

.method public setTarget(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->target:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->url:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setWidth(I)V
    .locals 0

    .prologue
    .line 48
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/CheckLink;->width:I

    .line 49
    return-void
.end method
