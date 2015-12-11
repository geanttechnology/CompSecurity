.class public abstract Lcom/amazon/identity/auth/device/storage/DataStorage;
.super Ljava/lang/Object;
.source "DataStorage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    return-void
.end method


# virtual methods
.method public abstract addAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/storage/AccountTransaction;Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;)Z
.end method

.method public doesAccountExist(Ljava/lang/String;)Z
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccounts()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public abstract expireToken(Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract getAccountNames()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAccounts()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getDirectedId(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getDisplayName(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract initialize()V
.end method

.method public abstract removeAccount(Ljava/lang/String;)V
.end method

.method public abstract setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V
.end method

.method public abstract setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public setDeviceData(Ljava/lang/String;Ljava/util/Map;)V
    .locals 4
    .param p1, "namespace"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 72
    .local p2, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 74
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p0, p1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 76
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method public abstract setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public setTokens(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p2, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1, p2}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V

    .line 84
    return-void
.end method

.method public abstract setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
.end method

.method public setUserData(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 91
    .local p2, "userData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setData(Lcom/amazon/identity/auth/device/storage/AccountTransaction;)V

    .line 92
    return-void
.end method

.method public abstract setup()V
.end method

.method public abstract syncDirtyData()V
.end method
