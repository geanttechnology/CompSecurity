.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private displayOnMdot:Z

.field private name:Ljava/lang/String;

.field private target:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isDisplayOnMdot()Z
    .locals 1

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->displayOnMdot:Z

    return v0
.end method

.method public setDisplayOnMdot(Z)V
    .locals 0

    .prologue
    .line 48
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->displayOnMdot:Z

    .line 49
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->name:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setTarget(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->target:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;->url:Ljava/lang/String;

    .line 41
    return-void
.end method
