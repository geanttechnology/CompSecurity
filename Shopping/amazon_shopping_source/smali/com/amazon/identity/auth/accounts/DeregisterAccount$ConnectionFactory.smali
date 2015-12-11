.class public interface abstract Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ConnectionFactory"
.end annotation


# virtual methods
.method public abstract createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.end method

.method public abstract createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
.end method
