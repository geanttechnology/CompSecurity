.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterAccountAction;
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
    name = "DeregisterAccountAction"
.end annotation


# static fields
.field public static final KEY_DIRECTED_ID:Ljava/lang/String; = "directedId"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 291
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parametersToBundle(Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 2
    .param p0, "directedId"    # Ljava/lang/String;
    .param p1, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 297
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 298
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "directedId"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToBundle(Landroid/os/Bundle;)V

    .line 300
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 306
    if-eqz p2, :cond_0

    move-object v2, p2

    .line 308
    .local v2, "parameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v5, "directedId"

    invoke-virtual {v2, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 310
    .local v1, "directedId":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    .line 311
    .local v0, "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    const-string/jumbo v5, "DeregisterAccount"

    invoke-static {v2, v5}, Lcom/amazon/identity/auth/device/framework/Tracer;->createFromBundle(Landroid/os/Bundle;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v3

    .line 312
    .local v3, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v5, "com.amazon.dcp.sso.ErrorCode"

    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {p3, v3, v5, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapRegistrationCallbackWithMetrics(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    .line 318
    .local v4, "wrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    invoke-virtual {v0, v1, v4, v3}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->deregisterAccount(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 319
    const/4 v5, 0x0

    return-object v5

    .line 306
    .end local v0    # "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .end local v1    # "directedId":Ljava/lang/String;
    .end local v2    # "parameters":Landroid/os/Bundle;
    .end local v3    # "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    .end local v4    # "wrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    :cond_0
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
