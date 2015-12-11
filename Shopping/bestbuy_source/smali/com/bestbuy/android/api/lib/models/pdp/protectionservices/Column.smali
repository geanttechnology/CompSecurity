.class public Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private planType:Ljava/lang/String;

.field private price:Ljava/lang/String;

.field private serviceInFeature:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPlanType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->planType:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->price:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceInFeature()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->serviceInFeature:Ljava/lang/String;

    return-object v0
.end method

.method public setPlanType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->planType:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->price:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setServiceInFeature(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/Column;->serviceInFeature:Ljava/lang/String;

    .line 39
    return-void
.end method
