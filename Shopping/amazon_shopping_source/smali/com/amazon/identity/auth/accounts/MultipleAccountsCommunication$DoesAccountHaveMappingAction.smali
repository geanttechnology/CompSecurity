.class public Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$DoesAccountHaveMappingAction;
.super Ljava/lang/Object;
.source "MultipleAccountsCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/IPCCommand;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DoesAccountHaveMappingAction"
.end annotation


# static fields
.field public static final KEY_ACCOUNT_MAPPING:Ljava/lang/String; = "mapping"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directedId"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResult(Landroid/os/Bundle;)Z
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 119
    const-string/jumbo v0, "value"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static parametersToBundle(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;
    .locals 4
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "mapping"    # Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 124
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 125
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "directedId"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    const-string/jumbo v1, "mapping"

    const/4 v2, 0x1

    new-array v2, v2, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    # invokes: Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->serialize([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->access$000([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 133
    if-eqz p2, :cond_0

    move-object v3, p2

    .line 134
    .local v3, "parameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v5, "directedId"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "directedId":Ljava/lang/String;
    const-string/jumbo v5, "mapping"

    invoke-virtual {v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    # invokes: Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->deserialize(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-static {v5}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->access$100(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    move-result-object v2

    .line 138
    .local v2, "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    if-eqz v2, :cond_1

    array-length v5, v2

    const/4 v6, 0x1

    if-ne v5, v6, :cond_1

    .line 140
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v5

    .line 141
    const/4 v6, 0x0

    aget-object v6, v2, v6

    invoke-virtual {v5, v0, v6}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v1

    .line 149
    .local v1, "doesMappingExist":Z
    :goto_1
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 150
    .local v4, "result":Landroid/os/Bundle;
    const-string/jumbo v5, "value"

    invoke-virtual {v4, v5, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 151
    return-object v4

    .line 133
    .end local v0    # "directedId":Ljava/lang/String;
    .end local v1    # "doesMappingExist":Z
    .end local v2    # "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v3    # "parameters":Landroid/os/Bundle;
    .end local v4    # "result":Landroid/os/Bundle;
    :cond_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    goto :goto_0

    .line 145
    .restart local v0    # "directedId":Ljava/lang/String;
    .restart local v2    # "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .restart local v3    # "parameters":Landroid/os/Bundle;
    :cond_1
    # getter for: Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->access$200()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "Did not specify the mappings properly"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    const/4 v1, 0x0

    .restart local v1    # "doesMappingExist":Z
    goto :goto_1
.end method
