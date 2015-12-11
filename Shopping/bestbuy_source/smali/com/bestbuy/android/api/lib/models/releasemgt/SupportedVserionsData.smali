.class public Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private currentVersion:Ljava/lang/String;

.field private currentVersionMessage:Ljava/lang/String;

.field private minimumSupportedVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->currentVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentVersionMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->currentVersionMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getMinimumSupportedVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->minimumSupportedVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setCurrentVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->currentVersion:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setCurrentVersionMessage(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->currentVersionMessage:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setMinimumSupportedVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 29
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->minimumSupportedVersion:Ljava/lang/String;

    .line 30
    return-void
.end method
