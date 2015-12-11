.class public Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;
.super Ljava/lang/Object;
.source "DelegatedAccountHelper.java"


# static fields
.field private static final CACHE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->TAG:Ljava/lang/String;

    .line 18
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->CACHE:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelegateeAccountForTheDelegatedAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 28
    sget-object v2, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->CACHE:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 29
    .local v0, "cachedValue":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 39
    .end local v0    # "cachedValue":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 33
    .restart local v0    # "cachedValue":Ljava/lang/String;
    :cond_0
    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.delegateeaccount"

    invoke-virtual {p2, p1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 35
    .local v1, "value":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 37
    sget-object v2, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->CACHE:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    .line 39
    goto :goto_0
.end method

.method public getDelegationDomainForDirectedId(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/DataStorage;)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 50
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    if-nez p2, :cond_1

    .line 52
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/accounts/DelegatedAccountHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Invalid Arguments in getDelegationDomainForDirectedId. Returning null."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    const/4 v0, 0x0

    .line 59
    :goto_0
    return-object v0

    .line 55
    :cond_1
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.delegationDomain"

    invoke-virtual {p2, p1, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getDelegationDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 2
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 73
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 75
    .local v0, "domain":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 77
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 80
    .end local v0    # "domain":Ljava/lang/String;
    :cond_0
    return-object v0
.end method
