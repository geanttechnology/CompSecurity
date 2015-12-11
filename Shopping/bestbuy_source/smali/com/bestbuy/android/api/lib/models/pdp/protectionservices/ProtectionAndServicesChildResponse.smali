.class public Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionAndServicesChildResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private protectionAndServices:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getProtectionAndServices()Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionAndServicesChildResponse;->protectionAndServices:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionAndServicesChildResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setProtectionAndServices(Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;)V
    .locals 0

    .prologue
    .line 20
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionAndServicesChildResponse;->protectionAndServices:Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionService;

    .line 21
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/protectionservices/ProtectionAndServicesChildResponse;->skuId:Ljava/lang/String;

    .line 29
    return-void
.end method
