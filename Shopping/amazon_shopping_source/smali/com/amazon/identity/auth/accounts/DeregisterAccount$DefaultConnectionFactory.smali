.class public Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DefaultConnectionFactory"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;->mContext:Landroid/content/Context;

    .line 90
    return-void
.end method


# virtual methods
.method public createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .locals 2

    .prologue
    .line 101
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .locals 2
    .param p1, "description"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .prologue
    .line 95
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;->mContext:Landroid/content/Context;

    invoke-direct {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;Landroid/content/Context;)V

    return-object v0
.end method
