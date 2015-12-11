.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsDeviceRegisteredAction;
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
    name = "IsDeviceRegisteredAction"
.end annotation


# static fields
.field public static final KEY_CALLING_APPLICATION_INFO_BUNDLE:Ljava/lang/String; = "calling.app.info"

.field public static final KEY_VALUE:Ljava/lang/String; = "value"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getResult(Landroid/os/Bundle;)Z
    .locals 1
    .param p0, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 107
    const-string/jumbo v0, "value"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 113
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    .line 114
    .local v0, "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 115
    .local v2, "result":Landroid/os/Bundle;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->isDeviceRegistered()Z

    move-result v1

    .line 116
    .local v1, "isRegistered":Z
    const-string/jumbo v3, "value"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 117
    return-object v2
.end method
