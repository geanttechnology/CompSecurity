.class public Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private productType:Ljava/lang/String;

.field private requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

.field private rights:Lcom/bestbuy/android/api/lib/models/pdp/techsupport/Rights;

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
.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getRequirements()Lcom/bestbuy/android/api/lib/models/pdp/Requirement;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    return-object v0
.end method

.method public getRights()Lcom/bestbuy/android/api/lib/models/pdp/techsupport/Rights;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->rights:Lcom/bestbuy/android/api/lib/models/pdp/techsupport/Rights;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 27
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->productType:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setRequirements(Lcom/bestbuy/android/api/lib/models/pdp/Requirement;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->requirements:Lcom/bestbuy/android/api/lib/models/pdp/Requirement;

    .line 43
    return-void
.end method

.method public setRights(Lcom/bestbuy/android/api/lib/models/pdp/techsupport/Rights;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->rights:Lcom/bestbuy/android/api/lib/models/pdp/techsupport/Rights;

    .line 51
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/techsupport/TechSupportDetails;->skuId:Ljava/lang/String;

    .line 59
    return-void
.end method
