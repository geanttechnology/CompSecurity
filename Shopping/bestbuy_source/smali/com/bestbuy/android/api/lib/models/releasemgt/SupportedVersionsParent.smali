.class public Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0xf9436b2b9ab4f09L


# instance fields
.field private response:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

.field private type:Ljava/lang/String;

.field private version:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->response:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->version:Ljava/lang/String;

    return-object v0
.end method

.method public setResponse(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->response:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    .line 53
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->type:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->version:Ljava/lang/String;

    .line 41
    return-void
.end method
