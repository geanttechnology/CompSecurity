.class public interface abstract Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$IDeregisterConnectionCallback;
.super Ljava/lang/Object;
.source "SubAuthenticatorConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "IDeregisterConnectionCallback"
.end annotation


# virtual methods
.method public abstract error(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;ILjava/lang/String;)V
.end method

.method public abstract success(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;Landroid/os/Bundle;)V
.end method
