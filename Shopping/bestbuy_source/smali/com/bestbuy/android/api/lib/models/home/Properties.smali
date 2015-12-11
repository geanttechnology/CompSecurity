.class public Lcom/bestbuy/android/api/lib/models/home/Properties;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x35ecfcd0e4532a8dL


# instance fields
.field private contractCondition:Ljava/lang/String;

.field private format:Ljava/lang/String;

.field private freeShippingCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getContractCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->contractCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->format:Ljava/lang/String;

    return-object v0
.end method

.method public getFreeShippingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->freeShippingCode:Ljava/lang/String;

    return-object v0
.end method

.method public setContractCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->contractCondition:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setFormat(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->format:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setFreeShippingCode(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/Properties;->freeShippingCode:Ljava/lang/String;

    .line 46
    return-void
.end method
