.class public Lcom/amazon/identity/auth/device/token/RefreshToken;
.super Lcom/amazon/identity/auth/device/token/AbstractToken;
.source "RefreshToken.java"


# static fields
.field public static final DEFAULT_REGION_HINT:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mRegionHint:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->NA:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    sput-object v0, Lcom/amazon/identity/auth/device/token/RefreshToken;->DEFAULT_REGION_HINT:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    .line 18
    const-class v0, Lcom/amazon/identity/auth/device/token/RefreshToken;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/RefreshToken;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;Ljava/lang/String;)V
    .locals 3
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "regionHint"    # Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;
    .param p3, "directedId"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/AbstractToken;-><init>(Ljava/lang/String;)V

    .line 48
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 50
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "directedid"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    :cond_0
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mRegionHint:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    .line 53
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "region_hint"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mRegionHint:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Lcom/amazon/identity/auth/device/token/RefreshToken;->LOG_TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Creating Token "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/RefreshToken;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " for id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/RefreshToken;->getDirectedId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 55
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "token"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 34
    sget-object v0, Lcom/amazon/identity/auth/device/token/RefreshToken;->DEFAULT_REGION_HINT:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    invoke-direct {p0, p1, v0, p2}, Lcom/amazon/identity/auth/device/token/RefreshToken;-><init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;Ljava/lang/String;)V

    .line 35
    return-void
.end method


# virtual methods
.method public getDMSDirectedId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 98
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "dms.directed.id"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "directedid"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getRegionHint()Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mRegionHint:Lcom/amazon/identity/auth/device/AccountManagerConstants$REGION_HINT;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 75
    const-string/jumbo v0, "com.amazon.identity.token.refreshToken"

    return-object v0
.end method

.method public setDMSDirectedId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "dmsDirectedId"    # Ljava/lang/String;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/RefreshToken;->mTokenData:Ljava/util/Map;

    const-string/jumbo v1, "dms.directed.id"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/token/RefreshToken;->getToken()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
