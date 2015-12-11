.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication;
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
    name = "RegisterChildApplication"
.end annotation


# static fields
.field public static final KEY_DEVICE_TYPE:Ljava/lang/String; = "device_type"

.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directed_id"

.field public static final KEY_OPTIONS:Ljava/lang/String; = "options"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parametersToBundle(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 2
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "deviceType"    # Ljava/lang/String;
    .param p2, "options"    # Landroid/os/Bundle;
    .param p3, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 73
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 74
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "directed_id"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const-string/jumbo v1, "device_type"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string/jumbo v1, "options"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 77
    invoke-virtual {p3, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToBundle(Landroid/os/Bundle;)V

    .line 78
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 84
    if-eqz p2, :cond_0

    move-object v6, p2

    .line 85
    .local v6, "parameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v7, "directed_id"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 86
    .local v1, "directedId":Ljava/lang/String;
    const-string/jumbo v7, "device_type"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 87
    .local v2, "deviceType":Ljava/lang/String;
    const-string/jumbo v7, "options"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    .line 89
    .local v3, "options":Landroid/os/Bundle;
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    .line 91
    .local v0, "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    const-string/jumbo v7, "RegisterChildApplication"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/framework/Tracer;->createFromBundle(Landroid/os/Bundle;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 92
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-static {v5, p3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    .line 93
    .local v4, "wrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerChildApplication(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 94
    const/4 v7, 0x0

    return-object v7

    .line 84
    .end local v0    # "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .end local v1    # "directedId":Ljava/lang/String;
    .end local v2    # "deviceType":Ljava/lang/String;
    .end local v3    # "options":Landroid/os/Bundle;
    .end local v4    # "wrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    .end local v5    # "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    .end local v6    # "parameters":Landroid/os/Bundle;
    :cond_0
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
