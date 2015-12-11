.class public Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication$GetAccountForMappingsUserAction;
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
    name = "GetAccountForMappingsUserAction"
.end annotation


# static fields
.field public static final KEY_ACCOUNT_MAPPINGS:Ljava/lang/String; = "mappings"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 155
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResult(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 163
    const-string/jumbo v0, "value"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static varargs parametersToBundle([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Landroid/os/Bundle;
    .locals 3
    .param p0, "mappings"    # [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    .prologue
    .line 168
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 169
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "mappings"

    # invokes: Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->serialize([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->access$000([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 176
    if-eqz p2, :cond_0

    .line 177
    .end local p2    # "givenParameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v3, "mappings"

    invoke-virtual {p2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    # invokes: Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->deserialize(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-static {v3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsCommunication;->access$100(Ljava/lang/String;)[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    move-result-object v1

    .line 179
    .local v1, "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v3

    .line 181
    invoke-virtual {v3, v1}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v0

    .line 183
    .local v0, "directedId":Ljava/lang/String;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 184
    .local v2, "result":Landroid/os/Bundle;
    const-string/jumbo v3, "value"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    return-object v2

    .line 176
    .end local v0    # "directedId":Ljava/lang/String;
    .end local v1    # "mappings":[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;
    .end local v2    # "result":Landroid/os/Bundle;
    .restart local p2    # "givenParameters":Landroid/os/Bundle;
    :cond_0
    new-instance p2, Landroid/os/Bundle;

    .end local p2    # "givenParameters":Landroid/os/Bundle;
    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
