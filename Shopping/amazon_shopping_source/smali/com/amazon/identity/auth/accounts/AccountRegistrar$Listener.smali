.class public interface abstract Lcom/amazon/identity/auth/accounts/AccountRegistrar$Listener;
.super Ljava/lang/Object;
.source "AccountRegistrar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountRegistrar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract accountAlreadyExists(Ljava/lang/String;)V
.end method

.method public abstract failure(Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;Landroid/os/Bundle;)V
.end method

.method public abstract success(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
.end method
