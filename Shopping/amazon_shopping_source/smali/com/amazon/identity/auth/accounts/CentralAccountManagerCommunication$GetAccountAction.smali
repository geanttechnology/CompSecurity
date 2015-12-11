.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction;
.super Ljava/lang/Object;
.source "CentralAccountManagerCommunication.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/framework/IPCCommand;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetAccountAction"
.end annotation


# static fields
.field public static final KEY_PACKAGE_NAME:Ljava/lang/String; = "packageName"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResult(Landroid/os/Bundle;)Ljava/lang/String;
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 182
    const-string/jumbo v0, "value"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static parametersToBundle(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 187
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 188
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "packageName"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 195
    if-eqz p2, :cond_0

    .line 196
    .end local p2    # "givenParameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v4, "packageName"

    invoke-virtual {p2, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 198
    .local v2, "packageName":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    .line 200
    .local v0, "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 201
    .local v3, "result":Landroid/os/Bundle;
    invoke-virtual {v0, v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getAccount(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 202
    .local v1, "directedId":Ljava/lang/String;
    const-string/jumbo v4, "value"

    invoke-virtual {v3, v4, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    return-object v3

    .line 195
    .end local v0    # "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .end local v1    # "directedId":Ljava/lang/String;
    .end local v2    # "packageName":Ljava/lang/String;
    .end local v3    # "result":Landroid/os/Bundle;
    .restart local p2    # "givenParameters":Landroid/os/Bundle;
    :cond_0
    new-instance p2, Landroid/os/Bundle;

    .end local p2    # "givenParameters":Landroid/os/Bundle;
    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
