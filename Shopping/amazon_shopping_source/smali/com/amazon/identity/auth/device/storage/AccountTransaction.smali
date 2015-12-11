.class public Lcom/amazon/identity/auth/device/storage/AccountTransaction;
.super Ljava/lang/Object;
.source "AccountTransaction.java"


# instance fields
.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mDirectedId:Ljava/lang/String;

.field private final mTokens:Ljava/util/Map;
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

.field private final mUserData:Ljava/util/Map;
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


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    .local p2, "userData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/storage/AccountTransaction;-><init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 49
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p4, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/auth/device/storage/DataStorage;",
            ")V"
        }
    .end annotation

    .prologue
    .line 61
    .local p2, "userData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "AccountData directedId cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 68
    :cond_0
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDirectedId:Ljava/lang/String;

    .line 71
    if-nez p2, :cond_1

    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mUserData:Ljava/util/Map;

    .line 80
    :goto_0
    if-nez p3, :cond_2

    .line 82
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mTokens:Ljava/util/Map;

    .line 89
    :goto_1
    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 90
    return-void

    .line 77
    :cond_1
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mUserData:Ljava/util/Map;

    goto :goto_0

    .line 86
    :cond_2
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mTokens:Ljava/util/Map;

    goto :goto_1
.end method


# virtual methods
.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method public getToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 124
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mTokens:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 125
    .local v0, "value":Ljava/lang/String;
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    if-eqz v1, :cond_0

    .line 127
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 129
    :cond_0
    return-object v0
.end method

.method public getTokens()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mTokens:Ljava/util/Map;

    return-object v0
.end method

.method public getUserData(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 152
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mUserData:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 153
    .local v0, "value":Ljava/lang/String;
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    if-eqz v1, :cond_0

    .line 155
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mDirectedId:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 157
    :cond_0
    return-object v0
.end method

.method public getUserData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mUserData:Ljava/util/Map;

    return-object v0
.end method

.method public setToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 141
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mTokens:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    return-void
.end method

.method public setUserData(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/AccountTransaction;->mUserData:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    return-void
.end method
