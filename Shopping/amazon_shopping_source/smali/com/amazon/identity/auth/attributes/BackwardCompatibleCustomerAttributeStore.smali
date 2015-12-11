.class public Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;
.super Ljava/lang/Object;
.source "BackwardCompatibleCustomerAttributeStore.java"

# interfaces
.implements Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;


# instance fields
.field private mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

.field private mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private mHasCentralAPK:Ljava/lang/Boolean;

.field private mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

.field private mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .prologue
    const/4 v0, 0x0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 32
    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

    .line 33
    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mHasCentralAPK:Ljava/lang/Boolean;

    .line 34
    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 35
    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 36
    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;

    .line 37
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;ZZZLcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;)V
    .locals 1
    .param p1, "context"    # Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    .param p2, "isPlatFormHasCustomerAttributeStoreProvider"    # Z
    .param p3, "isNewIdentityMobilePlatformSSO"    # Z
    .param p4, "hasCentralAPK"    # Z
    .param p5, "centralCustomerAttributeStore"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    .param p6, "centralCustomerAttributeStoreCommunication"    # Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 50
    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;

    .line 51
    invoke-static {p3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

    .line 52
    invoke-static {p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mHasCentralAPK:Ljava/lang/Boolean;

    .line 53
    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 54
    iput-object p6, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 55
    return-void
.end method

.method private initCentralCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    .locals 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    if-nez v0, :cond_0

    .line 106
    new-instance v0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 109
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStore:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    return-object v0
.end method

.method private initCentralCustomerAttributeStoreCommunication()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;
    .locals 2

    .prologue
    .line 114
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    if-nez v0, :cond_0

    .line 116
    new-instance v0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mCentralCustomerAttributeStoreCommunication:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    return-object v0
.end method

.method private shouldReadAttributeFromLocalCentralCAS(Ljava/lang/String;)Z
    .locals 4
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 124
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mHasCentralAPK:Ljava/lang/Boolean;

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->hasCentralAPK(Landroid/content/Context;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mHasCentralAPK:Ljava/lang/Boolean;

    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mHasCentralAPK:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    sget-object v3, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->CUSTOMER_ATTRIBUTE_STORE_URI:Landroid/net/Uri;

    invoke-static {v2, v3}, Lcom/amazon/identity/platform/util/PlatformUtils;->unSecureCheckHasContentProviderWithAuthority(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;

    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsPlatformHasCustomerAttributeStoreProvider:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_4

    :cond_2
    move v0, v1

    .line 139
    :cond_3
    :goto_0
    return v0

    .line 129
    :cond_4
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreKeyUtils;->isCorPfm(Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 134
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

    if-nez v2, :cond_5

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-static {v2}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPostMergeDevice(Landroid/content/Context;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

    :cond_5
    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->mIsNewIdentiyMobilePlatformSSO:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_3

    move v0, v1

    .line 139
    goto :goto_0
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "info"    # Landroid/os/Bundle;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Landroid/os/Bundle;",
            "Ljava/util/EnumSet",
            "<",
            "Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;",
            ">;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 65
    .local p5, "options":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    if-nez p4, :cond_0

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 66
    .local v4, "nonNullInfo":Landroid/os/Bundle;
    :goto_0
    if-nez p5, :cond_1

    const-class v0, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;

    invoke-static {v0}, Ljava/util/EnumSet;->noneOf(Ljava/lang/Class;)Ljava/util/EnumSet;

    move-result-object v5

    .line 69
    .local v5, "nonNullOptions":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    :goto_1
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->shouldReadAttributeFromLocalCentralCAS(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 71
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 80
    :goto_2
    return-object v0

    .end local v4    # "nonNullInfo":Landroid/os/Bundle;
    .end local v5    # "nonNullOptions":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    :cond_0
    move-object v4, p4

    .line 65
    goto :goto_0

    .restart local v4    # "nonNullInfo":Landroid/os/Bundle;
    :cond_1
    move-object v5, p5

    .line 66
    goto :goto_1

    .line 80
    .restart local v5    # "nonNullOptions":Ljava/util/EnumSet;, "Ljava/util/EnumSet<Lcom/amazon/identity/auth/device/api/CustomerAttributeStore$GetAttributeOptions;>;"
    :cond_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStoreCommunication()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_2
.end method

.method public peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->shouldReadAttributeFromLocalCentralCAS(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 98
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStoreCommunication()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    goto :goto_0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 148
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->shouldReadAttributeFromLocalCentralCAS(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStore()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 154
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/BackwardCompatibleCustomerAttributeStore;->initCentralCustomerAttributeStoreCommunication()Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreDefinition;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    goto :goto_0
.end method
