.class public interface abstract Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection$ISubAuthenticatorConnectionCallback;
.super Ljava/lang/Object;
.source "SubAuthenticatorConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ISubAuthenticatorConnectionCallback"
.end annotation


# virtual methods
.method public abstract onConnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
.end method

.method public abstract onConnectionTimeout(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
.end method

.method public abstract onDisconnected(Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;)V
.end method
