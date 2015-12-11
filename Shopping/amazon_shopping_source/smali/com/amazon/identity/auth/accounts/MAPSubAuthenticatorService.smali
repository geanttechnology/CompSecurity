.class public Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;
.super Landroid/app/Service;
.source "MAPSubAuthenticatorService.java"


# instance fields
.field private mSubAuthenticator:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;->mSubAuthenticator:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;->getIBinder()Landroid/os/IBinder;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 21
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 23
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 25
    new-instance v0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;

    invoke-direct {v0, p0, p0}, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService$1;-><init>(Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/MAPSubAuthenticatorService;->mSubAuthenticator:Lcom/amazon/identity/auth/accounts/AbstractSubAuthenticator;

    .line 77
    return-void
.end method
