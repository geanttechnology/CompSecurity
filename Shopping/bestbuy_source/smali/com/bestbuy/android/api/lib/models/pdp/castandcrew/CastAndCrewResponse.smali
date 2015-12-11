.class public Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private productType:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCastAndCrew()Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    return-object v0
.end method

.method public getSkuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setCastAndCrew(Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->castAndCrew:Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrew;

    .line 26
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 33
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 34
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->productType:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    .line 50
    return-void
.end method

.method public setSkuid(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/castandcrew/CastAndCrewResponse;->skuId:Ljava/lang/String;

    .line 58
    return-void
.end method
