.class Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;
.super Ljava/lang/Object;
.source "CentralTokenManagementCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/token/TokenCache$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

.field final synthetic val$baseTokenKey:Ljava/lang/String;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$firstTimeFixCentralToken:Z

.field final synthetic val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

.field final synthetic val$tokenCache:Lcom/amazon/identity/auth/device/token/TokenCache;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Z)V
    .locals 0

    .prologue
    .line 237
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$tokenCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$baseTokenKey:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$directedId:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-boolean p7, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$firstTimeFixCentralToken:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public failure(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 286
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v0, p2, p3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 287
    return-void
.end method

.method public failure(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "result"    # Landroid/os/Bundle;

    .prologue
    .line 280
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v0, p2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onError(Landroid/os/Bundle;)V

    .line 281
    return-void
.end method

.method public success()V
    .locals 7

    .prologue
    .line 242
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$tokenCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$baseTokenKey:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/token/TokenCache;->getToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 248
    .local v2, "tokenValue":Ljava/lang/String;
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->this$0:Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    # getter for: Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    invoke-static {v4}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;->access$100(Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v4

    invoke-direct {v0, v4}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;-><init>(Landroid/content/Context;)V

    .line 258
    .local v0, "dataStorage":Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/storage/StorageKeyUtils;->getKeyWithPackageNamespace(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "timeRefreshedAtKey":Ljava/lang/String;
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 262
    .local v3, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 263
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$directedId:Ljava/lang/String;

    invoke-virtual {v0, v4, v3}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V

    .line 265
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v4, v2}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackSuccess(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 267
    iget-boolean v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$firstTimeFixCentralToken:Z

    if-eqz v4, :cond_0

    .line 270
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication$2;->val$directedId:Ljava/lang/String;

    const-string/jumbo v5, "force_refresh_dms_to_oauth_done_once"

    const-string/jumbo v6, "true"

    invoke-virtual {v0, v4, v5, v6}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 273
    const-string/jumbo v4, "fixCentralTokenOnGrover/Canary"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 275
    :cond_0
    return-void
.end method
