.class public interface abstract Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper$AddAccountCallback;
.super Ljava/lang/Object;
.source "AccountManagerWrapper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AddAccountCallback"
.end annotation


# virtual methods
.method public abstract accountAdded(Landroid/accounts/Account;)V
.end method

.method public abstract accountAlreadyExists(Landroid/accounts/Account;)V
.end method
