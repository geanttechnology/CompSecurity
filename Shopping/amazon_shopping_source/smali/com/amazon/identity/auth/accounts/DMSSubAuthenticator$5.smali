.class Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;
.super Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
.source "DMSSubAuthenticator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

.field final synthetic val$directedId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1014
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->val$directedId:Ljava/lang/String;

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;-><init>()V

    return-void
.end method


# virtual methods
.method public getPrivateKey()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1032
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$700(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$800(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    move-result-object v3

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1033
    .local v0, "privateKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1039
    .end local v0    # "privateKey":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "privateKey":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$700(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppPrivateKey:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$800(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    move-result-object v3

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getToken()Ljava/lang/String;
    .locals 4

    .prologue
    .line 1018
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$700(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$600(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    move-result-object v3

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->deviceTypeInvariantForm:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1020
    .local v0, "adpToken":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1026
    .end local v0    # "adpToken":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "adpToken":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$700(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$5;->this$0:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;

    # getter for: Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->mTokenTypeAppADPToken:Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;->access$600(Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator;)Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;

    move-result-object v3

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/DMSSubAuthenticator$DataKey;->legacyToken:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public isStale(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 1045
    const/4 v0, 0x0

    return v0
.end method
