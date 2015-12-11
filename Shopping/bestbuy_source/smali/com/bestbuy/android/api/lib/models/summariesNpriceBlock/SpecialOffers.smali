.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;
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
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getTarget()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->target:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isDisplayOnMdot()Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->displayOnMdot:Z

    return v0
.end method

.method public setDisplayOnMdot(Z)V
    .locals 0

    .prologue
    .line 69
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->displayOnMdot:Z

    .line 70
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->name:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setTarget(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->target:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;->url:Ljava/lang/String;

    .line 64
    return-void
.end method
