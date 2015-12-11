.class public Lcom/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction;
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
    name = "RegisterAccountAction"
.end annotation


# static fields
.field public static final KEY_REG_DATA:Ljava/lang/String; = "regData"

.field public static final KEY_REG_TYPE:Ljava/lang/String; = "regType"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 234
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parametersToBundle(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/framework/Tracer;)Landroid/os/Bundle;
    .locals 3
    .param p0, "regType"    # Lcom/amazon/identity/auth/device/api/RegistrationType;
    .param p1, "regData"    # Landroid/os/Bundle;
    .param p2, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 243
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 244
    .local v0, "paramBundles":Landroid/os/Bundle;
    const-string/jumbo v1, "regType"

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/RegistrationType;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    const-string/jumbo v1, "regData"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 246
    invoke-virtual {p2, v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->addToBundle(Landroid/os/Bundle;)V

    .line 247
    return-object v0
.end method


# virtual methods
.method public performIPCAction(Landroid/content/Context;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Landroid/os/Bundle;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "givenParameters"    # Landroid/os/Bundle;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 253
    if-eqz p2, :cond_0

    move-object v2, p2

    .line 255
    .local v2, "parameters":Landroid/os/Bundle;
    :goto_0
    const-string/jumbo v6, "regType"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 256
    invoke-static {v6}, Lcom/amazon/identity/auth/device/api/RegistrationType;->fromName(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/RegistrationType;

    move-result-object v4

    .line 258
    .local v4, "regType":Lcom/amazon/identity/auth/device/api/RegistrationType;
    const-string/jumbo v6, "regData"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    .line 260
    .local v3, "regData":Landroid/os/Bundle;
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    move-result-object v0

    .line 263
    .local v0, "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "RegisterAccount:"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->getRegType(Lcom/amazon/identity/auth/device/api/RegistrationType;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v2, v6}, Lcom/amazon/identity/auth/device/framework/Tracer;->createFromBundle(Landroid/os/Bundle;Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 265
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    const-string/jumbo v6, "Count"

    invoke-virtual {v5, v6}, Lcom/amazon/identity/auth/device/framework/Tracer;->incrementCounter(Ljava/lang/String;)V

    .line 266
    const-string/jumbo v6, "com.amazon.dcp.sso.ErrorCode"

    sget-object v7, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-static {p3, v5, v6, v7}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapRegistrationCallbackWithMetrics(Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v1

    .line 272
    .local v1, "metricsWrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    invoke-virtual {v0, v4, v3, v1, v5}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->registerAccount(Lcom/amazon/identity/auth/device/api/RegistrationType;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 273
    const/4 v6, 0x0

    return-object v6

    .line 253
    .end local v0    # "acctManLogic":Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
    .end local v1    # "metricsWrappedCallback":Lcom/amazon/identity/auth/device/api/Callback;
    .end local v2    # "parameters":Landroid/os/Bundle;
    .end local v3    # "regData":Landroid/os/Bundle;
    .end local v4    # "regType":Lcom/amazon/identity/auth/device/api/RegistrationType;
    .end local v5    # "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    :cond_0
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    goto :goto_0
.end method
